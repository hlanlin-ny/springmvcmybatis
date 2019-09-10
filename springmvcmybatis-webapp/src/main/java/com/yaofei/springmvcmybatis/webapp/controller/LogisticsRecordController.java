package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.LogisticsRecord;
import com.yaofei.springmvcmybatis.service.LogisticsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 物流记录表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
@Controller
@RequestMapping("/admin/logisticsrecord")
public class LogisticsRecordController extends BaseCRUDController<LogisticsRecord>  {
	@Autowired
	private LogisticsRecordService logisticsRecordService;
}