package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.ExpressUser;

import java.util.List;

/**
 * 快递用户信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
public interface ExpressUserService extends BaseService<ExpressUser> {
    List<ExpressUser> queryExpressUsersByAreaId(Long areaId);

    ExpressUser queryExpressUsersByUserName(String username);
}
