package com.yaofei.springmvcmybatis.repository;


import com.yaofei.springmvcmybatis.entity.SysUserUserRole;

import java.util.List;

/**
 * 系统用户角色关系表
 * 
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public interface SysUserUserRoleRepository extends BaseRepository<SysUserUserRole> {

    void deleteByUserId(Long userId);

    List<SysUserUserRole> querySysUserUserRoleByUserId(Long id);
}
