package com.yaofei.springmvcmybatis.shiro.realm;

import com.yaofei.springmvcmybatis.entity.SysUser;
import com.yaofei.springmvcmybatis.service.SysUserPermissionService;
import com.yaofei.springmvcmybatis.service.SysUserRoleService;
import com.yaofei.springmvcmybatis.service.SysUserService;
import com.yaofei.springmvcmybatis.shiro.domain.ShiroUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by f_yao on 2017/1/21.
 */
public class ShiroDbRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysUserPermissionService sysUserPermissionService;

    public ShiroDbRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
    }


    /**
     * 认证(登录时调用)
     * (原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("Shiro开始登录认证");
        //获取基于用户名和密码的令牌
        //实际上这个authenticationToken是从LoginController里面currentUser.login(token)传过来的
        //UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //String username = usernamePasswordToken.getUsername();
        String username = (String) authenticationToken.getPrincipal();
        //查询用户信息
        SysUser sysUser = sysUserService.querySysUserByUsername(username);
        //账号不存在
        if (sysUser == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        if (sysUser.getLocked()) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        if (!sysUser.getActivated()) {
            throw new DisabledAccountException("账号未激活，请先激活账号");
        }
        if (sysUser.getDisabled()) {
            throw new DisabledAccountException("账号已被禁用,请联系管理员");
        }



        ShiroUser shiroUser = new ShiroUser(sysUser.getId(), sysUser.getUsername(), sysUser.getRealName(),sysUser.getUserDepartmentId());
        //shiroUser.setStringPermissions(permissionCodes);
        //shiroUser.setRoles(roleCodes);

        //此处无需比对,比对的逻辑Shiro会做,我们只需返回一个和令牌相关的正确的验证信息
        //这样一来,在随后的登录页面上就只有这里指定的用户和密码才能通过验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                shiroUser,
                sysUser.getPassword(), // 密码
                ByteSource.Util.bytes(sysUser.getPasswordSalt()),    // salt
                getName()  // realm name
        );
        return authenticationInfo;
    }



    /**
     * 授权(验证权限时调用)
     * 为当前登录的Subject授予角色和权限
     * 该方法的调用时机为需授权资源被访问时
     * 经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
     * 个人感觉若使用了Spring3.1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache
     * 比如说这里从数据库获取权限信息时,先去访问Spring提供的缓存,而不使用Shior提供的AuthorizationCache
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        ShiroUser shiroUser = (ShiroUser) principalCollection.getPrimaryPrincipal();
        if (shiroUser == null) {
            throw new AccountException();
        }

        //查询用户信息
        SysUser sysUser = sysUserService.querySysUserByUsername(shiroUser.getUsername());
        Set<String> roleCodes;
        Set<String> permissionCodes;
        //系统管理员，拥有所有权限
        if (sysUser.getIsAdmin()) {
            roleCodes = sysUserRoleService.queryAllRoleCodes();
            permissionCodes = sysUserPermissionService.queryAllPermissionCodes();
        } else {
            roleCodes = sysUserRoleService.queryRoleCodesByUserId(sysUser.getId());
            permissionCodes = sysUserPermissionService.queryPermissionCodesByUserId(sysUser.getId());
        }

        if (permissionCodes != null && permissionCodes.size()>0) {
            Iterator<String> iterator = permissionCodes.iterator();
            while (iterator.hasNext()){
                String permissionCode=iterator.next();
                if (StringUtils.isBlank(permissionCode)) {
                    iterator.remove();
                }
            }
        }

        if (roleCodes != null && roleCodes.size()>0) {
            Iterator<String> iterator = roleCodes.iterator();
            while (iterator.hasNext()) {
                String roleCode = iterator.next();
                if (StringUtils.isBlank(roleCode)) {
                    iterator.remove();
                }
            }
        }

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleCodes);
        authorizationInfo.addStringPermissions(permissionCodes);

        return authorizationInfo;
    }

    @Override
    public void onLogout(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        removeUserCache(shiroUser);
    }

    /**
     * 清除用户缓存
     * @param shiroUser
     */
    public void removeUserCache(ShiroUser shiroUser){
        removeUserCache(shiroUser.getUsername());
    }

    /**
     * 清除用户缓存
     * @param loginName
     */
    public void removeUserCache(String loginName){
        SimplePrincipalCollection principals = new SimplePrincipalCollection();
        principals.add(loginName, super.getName());
        super.clearCachedAuthenticationInfo(principals);
    }
}