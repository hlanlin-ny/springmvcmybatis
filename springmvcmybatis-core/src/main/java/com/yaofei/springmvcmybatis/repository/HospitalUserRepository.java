package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.HospitalUser;
import org.apache.ibatis.annotations.Param;

/**
 * 医院科室信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-10-11 10:14:33
 */
public interface HospitalUserRepository extends BaseRepository<HospitalUser> {

    long queryTotalByUserNameAndId(@Param("username") String username, @Param("id") Long id);
}
