package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.LogisticsUser;

import java.util.List;

/**
 * 物流用户信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
public interface LogisticsUserService extends BaseService<LogisticsUser> {
    List<LogisticsUser> queryLogisticsUsersByAreaId(Long areaId);

    LogisticsUser queryLogisticsUsersByUserName(String username);
}
