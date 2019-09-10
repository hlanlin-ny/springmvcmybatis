package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.SysSearchwarningLog;

import java.util.Date;

/**
 * 系统搜索预警通知日志表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-24 17:13:53
 */
public interface SysSearchwarningLogService extends BaseService<SysSearchwarningLog> {

    Date queryLastNoticeTime(Long confId);
}
