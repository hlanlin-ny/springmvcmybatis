package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.ScheduleJobLog;
import com.yaofei.springmvcmybatis.service.ScheduleJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 定时任务日志
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-02-21 21:13:29
 */
@Controller
@RequestMapping("admin/schedulejoblog")
public class ScheduleJobLogController  extends BaseCRUDController<ScheduleJobLog> {
	@Autowired
	private ScheduleJobLogService scheduleJobLogService;
}