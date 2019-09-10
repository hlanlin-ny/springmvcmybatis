package com.yaofei.springmvcmybatis.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.entity.HospitalUser;
import com.yaofei.springmvcmybatis.service.HospitalUserService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * 医院网点信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-10-11 10:14:33
 */
@Controller
@RequestMapping("/admin/hospitaluser")
public class HospitalUserController extends BaseCRUDController<HospitalUser>  {
	@Autowired
	private HospitalUserService hospitalUserService;

	@ResponseBody
	@RequestMapping(value = "/queryHospitalUsersByAreaId", method = RequestMethod.GET)
	public JsonResult queryHospitalUsersByAreaId(ServletRequest request) {
		//查询列表数据
		List<HospitalUser> hospitalUser = hospitalUserService.queryHospitalUsersByAreaId(super.getAreaId());
		return JsonResult.ok().addResult(JSON.toJSON(hospitalUser));
	}

}