package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.LogisticsCompany;

import java.util.List;

/**
 * 物流公司信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
public interface LogisticsCompanyService extends BaseService<LogisticsCompany> {

    List<LogisticsCompany> queryLogisticsCompanysByAreaId(Long areaId);
}
