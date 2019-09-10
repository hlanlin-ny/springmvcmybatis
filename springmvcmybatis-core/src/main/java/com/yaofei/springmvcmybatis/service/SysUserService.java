package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.SysUser;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;

import java.util.List;

/**
 * 系统用户表
 *
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public interface SysUserService extends BaseService<SysUser> {
    SysUser querySysUserByUsername(String username);

    void saveUserAndUserRoles(SysUser sysUser);

    void updateUserAndUserRoles(SysUser sysUser);

    void deleteUserAndUserRoles(Long id);

    void deleteUserAndUserRolesInBatch(Long[] ids);

    List<SysUser> queryListWithCustom(DataTablesRequest dataTablesRequest);

    void updateLockedByUserByUserName(String userName);

    int changePassword(Long userId, String password, String newPassword);

    List<SysUser> queryAllUsers();
}