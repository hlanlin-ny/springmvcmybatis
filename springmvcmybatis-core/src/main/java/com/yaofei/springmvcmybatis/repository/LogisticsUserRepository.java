package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.LogisticsUser;
import org.apache.ibatis.annotations.Param;

/**
 * 物流用户信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
public interface LogisticsUserRepository extends BaseRepository<LogisticsUser> {

    long queryTotalByUserNameAndId(@Param("username") String username, @Param("id") Long id);
}
