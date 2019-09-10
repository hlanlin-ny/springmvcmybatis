package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.SysUser;
import com.yaofei.springmvcmybatis.entity.SysUserUserRole;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.repository.SysUserRepository;
import com.yaofei.springmvcmybatis.service.*;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("sysUserService")
public class SysUserServiceImpl extends AbstractBaseService<SysUser> implements SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;
    //@Autowired
    //private SysUserDepartmentService sysAreaService;
    @Autowired
    private SysAreaService sysAreaService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysUserUserRoleService sysUserUserRoleService;

    @Override
    public List<SysUser> queryListWithCustom(DataTablesRequest dataTablesRequest) {

        //翻译部门和角色代码
        Map<Long, String> sysUserDepartmentIdNameMap = sysAreaService.querySysAreaIdNameMap();
        Map<Long, String> sysUserRoleIdNameMap = sysUserRoleService.querySysUserRoleIdNameMap();
        StringBuilder stringBuilder;
        List<SysUserUserRole> sysUserUserRoles;

        List<SysUser> sysUsers = baseRepository.queryList(dataTablesRequest);
        for (SysUser sysUser : sysUsers) {

            if (sysUserDepartmentIdNameMap.containsKey(sysUser.getUserDepartmentId())) {
                sysUser.setUserDepartmentName(sysUserDepartmentIdNameMap.get(sysUser.getUserDepartmentId()));
            } else {
                sysUser.setUserDepartmentName("");
            }

            stringBuilder = new StringBuilder();
            sysUserUserRoles = sysUserUserRoleService.querySysUserUserRoleByUserId(sysUser.getId());
            for (SysUserUserRole sysUserUserRole : sysUserUserRoles) {
                if (sysUserRoleIdNameMap.containsKey(sysUserUserRole.getUserRoleId())) {
                    stringBuilder.append(sysUserRoleIdNameMap.get(sysUserUserRole.getUserRoleId()));
                    stringBuilder.append("，");
                }
            }
            if (stringBuilder.length() > 1) {
                String roleNames = stringBuilder.toString();
                sysUser.setUserRoleNames(roleNames.substring(0, roleNames.length() - 1));
            } else {
                sysUser.setUserRoleNames("");
            }
        }
        return sysUsers;
    }

    @Override
    public SysUser querySysUserByUsername(String username) {
        return sysUserRepository.querySysUserByUsername(username);
    }

    @Override
    public void saveUserAndUserRoles(SysUser sysUser) {
        // 检查用户名是否存在
        checkIsUsernameHasExist(sysUser.getUsername(), null);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String operatorUsername = SecurityUtils.getSubject().getPrincipal().toString();

        sysUser.setCreatedBy(operatorUsername);
        sysUser.setCreatedIp(request.getRemoteAddr());
        sysUser.setModificationBy(operatorUsername);
        sysUser.setModificationIp(request.getRemoteAddr());

        generatePassword(sysUser);
        sysUserRepository.save(sysUser);

        SysUserUserRole sysUserUserRole;
        for (Long userRoleId : sysUser.getUserRoleIds()) {
            sysUserUserRole = new SysUserUserRole();
            sysUserUserRole.setUserId(sysUser.getId());
            sysUserUserRole.setUserRoleId(userRoleId);
            sysUserUserRole.setCreatedBy(operatorUsername);
            sysUserUserRole.setCreatedIp(request.getRemoteAddr());
            sysUserUserRole.setModificationBy(operatorUsername);
            sysUserUserRole.setModificationIp(request.getRemoteAddr());
            sysUserUserRoleService.save(sysUserUserRole);
        }
    }

    /**
     * 检查用户名是否存在
     *
     * @param username
     * @param userId
     */
    private void checkIsUsernameHasExist(String username, Long userId) {
        long count = sysUserRepository.queryTotalByUserNameAndId(username, userId);
        if (count > 0) {
            throw new BussinessException("用户名已经存在，请使用其他用户名！");
        }
    }

    /**
     * 生成密码
     *
     * @param sysUser
     */
    private void generatePassword(SysUser sysUser) {
        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
        String passwordSalt = secureRandomNumberGenerator.nextBytes().toHex();
        String passwordSha256 = new Sha256Hash(sysUser.getPassword(), passwordSalt, 2).toString();
        sysUser.setPassword(passwordSha256);
        sysUser.setPasswordSalt(passwordSalt);
    }

    @Override
    public void updateUserAndUserRoles(SysUser sysUser) {
        // 检查用户名是否存在
        checkIsUsernameHasExist(sysUser.getUsername(), sysUser.getId());

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String operatorUsername = SecurityUtils.getSubject().getPrincipal().toString();

        sysUserUserRoleService.deleteByUserId(sysUser.getId());
        SysUserUserRole sysUserUserRole;
        for (Long userRoleId : sysUser.getUserRoleIds()) {
            sysUserUserRole = new SysUserUserRole();
            sysUserUserRole.setUserId(sysUser.getId());
            sysUserUserRole.setUserRoleId(userRoleId);
            sysUserUserRole.setCreatedBy(operatorUsername);
            sysUserUserRole.setCreatedIp(request.getRemoteAddr());
            sysUserUserRole.setModificationTime(new Date());
            sysUserUserRole.setModificationBy(operatorUsername);
            sysUserUserRole.setModificationIp(request.getRemoteAddr());
            sysUserUserRoleService.save(sysUserUserRole);
        }

        sysUser.setModificationBy(operatorUsername);
        sysUser.setModificationIp(request.getRemoteAddr());
        generatePassword(sysUser);
        sysUserRepository.update(sysUser);
    }

    @Override
    public void deleteUserAndUserRoles(Long id) {
        sysUserUserRoleService.deleteByUserId(id);
        sysUserRepository.delete(id);
    }

    @Override
    public void deleteUserAndUserRolesInBatch(Long[] ids) {
        for (Long id : ids) {
            sysUserUserRoleService.deleteByUserId(id);
        }
        sysUserRepository.deleteBatch(ids);
    }

    @Override
    public void updateLockedByUserByUserName(String userName) {
        sysUserRepository.updateLockedByUserByUserName(userName);
    }

    @Override
    public int changePassword(Long userId, String password, String newPassword) {
        SysUser sysUser = sysUserRepository.queryObject(userId);
        String passwordSha256 = new Sha256Hash(password, sysUser.getPasswordSalt(), 2).toString();
        if (!passwordSha256.equals(sysUser.getPassword())) {
            return 0;
        }
        sysUser.setPassword(newPassword);
        generatePassword(sysUser);
        sysUserRepository.update(sysUser);
        return 1;
    }

    @Override
    public List<SysUser> queryAllUsers() {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        dataTablesRequest.setLength(10000);
        dataTablesRequest.setOrderString("id asc");
        return sysUserRepository.queryList(dataTablesRequest);
    }
}
