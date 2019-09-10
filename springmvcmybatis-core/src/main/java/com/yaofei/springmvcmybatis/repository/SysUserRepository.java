package com.yaofei.springmvcmybatis.repository;


import com.yaofei.springmvcmybatis.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * 系统用户表
 * 
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public interface SysUserRepository extends BaseRepository<SysUser> {

    SysUser querySysUserByUsername(String username);

    long queryTotalByUserNameAndId(@Param("username") String username, @Param("id") Long id);

    void updateLockedByUserByUserName(String userName);
}
