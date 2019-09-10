package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.SysUserRolePermission;

import java.util.List;

/**
 * 系统用户角色权限关系表
 *
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public interface SysUserRolePermissionService extends BaseService<SysUserRolePermission> {

    List<SysUserRolePermission> querySysUserRolePermissionsByRoleId(Long userRoleId);

    void deleteByUserRoleId(Long userRoleId);
}
