package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.HospitalUnitInformation;

import java.util.List;

/**
 * 医院单位信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:36:52
 */
public interface HospitalUnitInformationService extends BaseService<HospitalUnitInformation> {

    List<HospitalUnitInformation> queryHospitalByAreaId(Long areaId);


}
