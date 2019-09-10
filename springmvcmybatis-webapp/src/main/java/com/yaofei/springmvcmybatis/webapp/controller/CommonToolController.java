package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.CommonTool;
import com.yaofei.springmvcmybatis.service.CommonToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 常用工具表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-03 17:45:49
 */
@Controller
@RequestMapping("/admin/commontool")
public class CommonToolController extends BaseCRUDController<CommonTool>  {
	@Autowired
	private CommonToolService commonToolService;

}