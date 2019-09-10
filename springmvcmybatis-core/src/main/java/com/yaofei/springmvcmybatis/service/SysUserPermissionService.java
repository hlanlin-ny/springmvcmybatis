package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.SysUserPermission;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 系统用户权限表
 *
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public interface SysUserPermissionService extends BaseService<SysUserPermission> {

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysUserPermission> queryNotButtonList();

    List<SysUserPermission> queryAllNodesOrderByOderNum();

    Set<String> queryAllPermissionCodes();

    Set<String> queryPermissionCodesByUserId(Long id);

    Map querySysUserPermissionIdNameMap();
}