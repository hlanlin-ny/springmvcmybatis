package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.HospitalUser;

import java.util.List;

/**
 * 医院科室信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-10-11 10:14:33
 */
public interface HospitalUserService extends BaseService<HospitalUser> {

    List<HospitalUser> queryHospitalUsersByAreaId(Long areaId);

    HospitalUser queryHospitalUsersByUserName(String username);

}
