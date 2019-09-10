package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.ControlApplyApplication;
import com.yaofei.springmvcmybatis.service.ControlApplyApplicationService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * 临时布控申请单
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-29 10:17:52
 */
@Controller
@RequestMapping("/admin/controlapplyapplication")
public class ControlApplyApplicationController extends BaseCRUDController<ControlApplyApplication>  {
	@Autowired
	private ControlApplyApplicationService controlApplyApplicationService;


	@ResponseBody
	@RequestMapping(value = "/addApplyApplication")
	public JsonResult addApplyApplication(HttpServletRequest request) throws ParseException {
        String username = super.getUsername();
		String url = request.getRemoteAddr();
		controlApplyApplicationService.addApplyApplication(username,url,request,super.getAreaId(),super.getUserId());
		return JsonResult.ok();
	}



}