package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.SysUserRole;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 系统用户角色表
 * 
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public interface SysUserRoleService  extends BaseService<SysUserRole> {
    List<SysUserRole> queryListWithCustom(DataTablesRequest dataTablesRequest);

    void saveUserRoleAndPermissions(SysUserRole sysUserRole);

    void updateUserRoleAndPermissions(SysUserRole sysUserRole);

    void deleteUserRoleAndPermissions(Long id);

    void deleteUserRoleAndPermissionsInBatch(Long[] ids);

    Set<String> queryAllRoleCodes();

    Set<String> queryRoleCodesByUserId(Long id);

    List<SysUserRole> queryAllUserRoles();

    Map querySysUserRoleIdNameMap();
}