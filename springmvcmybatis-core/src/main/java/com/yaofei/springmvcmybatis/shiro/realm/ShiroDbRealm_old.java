package com.yaofei.springmvcmybatis.shiro.realm;

import com.yaofei.springmvcmybatis.entity.SysUser;
import com.yaofei.springmvcmybatis.service.SysUserPermissionService;
import com.yaofei.springmvcmybatis.service.SysUserRoleService;
import com.yaofei.springmvcmybatis.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by f_yao on 2017/1/21.
 */
public class ShiroDbRealm_old extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysUserPermissionService sysUserPermissionService;

    public ShiroDbRealm_old(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
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
        //获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
        String currentUsername = (String) super.getAvailablePrincipal(principalCollection);
        if (currentUsername == null) {
            throw new AccountException();
        }

        SysUser sysUser = sysUserService.querySysUserByUsername(currentUsername);
        if (sysUser == null) {
            throw new UnknownAccountException();//没找到账户
            //throw new AuthorizationException();
        }
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

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (roleCodes != null) {
            for (String roleCode : roleCodes) {
                if (StringUtils.isNotBlank(roleCode)) {
                    //roleCodes.add(roleCode);
                    authorizationInfo.addRole(roleCode);
                }
            }
        }
        if (permissionCodes != null) {
            for (String permissionCode : permissionCodes) {
                if (StringUtils.isNotBlank(permissionCode)) {
                    authorizationInfo.addStringPermission(permissionCode);
                }
            }
        }
        return authorizationInfo;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取基于用户名和密码的令牌
        //实际上这个authenticationToken是从LoginController里面currentUser.login(token)传过来的
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

        //此处无需比对,比对的逻辑Shiro会做,我们只需返回一个和令牌相关的正确的验证信息
        //这样一来,在随后的登录页面上就只有这里指定的用户和密码才能通过验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser.getUsername(),
                sysUser.getPassword(), // 密码
                ByteSource.Util.bytes(sysUser.getPasswordSalt()),    // salt
                getName()  // realm name
        );
        return authenticationInfo;
    }
}