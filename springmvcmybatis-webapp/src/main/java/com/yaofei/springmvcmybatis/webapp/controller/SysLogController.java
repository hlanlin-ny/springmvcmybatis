package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.SysLog;
import com.yaofei.springmvcmybatis.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.InvocationTargetException;

/**
 * 系统日志
 */
@Controller
@RequestMapping("admin/syslog")
public class SysLogController extends BaseCRUDController<SysLog> {
	@Autowired
	private SysLogService sysLogService;
}
