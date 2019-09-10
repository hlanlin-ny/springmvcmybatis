package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.ExpressCompany;

import java.util.List;

/**
 * 快递公司信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
public interface ExpressCompanyService extends BaseService<ExpressCompany> {

    List<ExpressCompany> queryExpressCompanysByAreaId(Long areaId);
}
