package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.ExpressRecord;
import com.yaofei.springmvcmybatis.service.ExpressRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 快递记录表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
@Controller
@RequestMapping("/admin/expressrecord")
public class ExpressRecordController extends BaseCRUDController<ExpressRecord>  {
	@Autowired
	private ExpressRecordService expressRecordService;
}