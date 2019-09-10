package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.ExpressUser;
import org.apache.ibatis.annotations.Param;

/**
 * 快递用户信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
public interface ExpressUserRepository extends BaseRepository<ExpressUser> {

    long queryTotalByUserNameAndId(@Param("username") String username, @Param("id") Long id);
}
