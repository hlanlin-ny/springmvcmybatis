package com.yaofei.springmvcmybatis.repository;


import com.yaofei.springmvcmybatis.entity.SysUserPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 系统用户权限表
 *
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public interface SysUserPermissionRepository extends BaseRepository<SysUserPermission> {

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysUserPermission> queryNotButtonList();

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysUserPermission> queryListParentId(Long parentId);

    Set<String> queryAllPermissionCodes();

    Set<String> queryPermissionCodesByUserId(Long id);

    long queryTotalByPermissionAndId(@Param("permissionCode") String permissionCode, @Param("id") Long id);
}
