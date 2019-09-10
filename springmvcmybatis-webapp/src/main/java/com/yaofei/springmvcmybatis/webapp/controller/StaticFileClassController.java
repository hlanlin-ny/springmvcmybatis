package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.StaticFileClass;
import com.yaofei.springmvcmybatis.service.StaticFileClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 静态文件上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-02-24 14:11:22
 */
@Controller
@RequestMapping("/admin/staticfileclass")
public class StaticFileClassController extends BaseCRUDController<StaticFileClass>  {
	@Autowired
	private StaticFileClassService staticFileClassService;

}