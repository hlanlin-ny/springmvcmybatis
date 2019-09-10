package com.yaofei.springmvcmybatis.repository;


import com.yaofei.springmvcmybatis.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * 系统用户角色表
 * 
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public interface SysUserRoleRepository extends BaseRepository<SysUserRole> {

    Set<String> queryAllRoleCodes();
    Set<String> queryRoleCodesByUserId(Long id);

    long queryTotalByNameAndId(@Param("name") String name, @Param("id") Long id);
}
