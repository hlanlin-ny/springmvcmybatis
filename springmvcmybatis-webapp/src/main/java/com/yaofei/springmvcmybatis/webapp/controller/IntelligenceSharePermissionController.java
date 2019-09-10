package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.IntelligenceSharePermission;
import com.yaofei.springmvcmybatis.service.IntelligenceSharePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 情报共享授权关系表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-03 11:47:02
 */
@Controller
@RequestMapping("/admin/intelligencesharepermission")
public class IntelligenceSharePermissionController extends BaseCRUDController<IntelligenceSharePermission>  {
	@Autowired
	private IntelligenceSharePermissionService intelligenceSharePermissionService;

}