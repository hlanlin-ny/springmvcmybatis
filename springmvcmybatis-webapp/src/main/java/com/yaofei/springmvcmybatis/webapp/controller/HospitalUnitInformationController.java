package com.yaofei.springmvcmybatis.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.entity.HospitalUnitInformation;
import com.yaofei.springmvcmybatis.service.HospitalUnitInformationService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * 医院单位信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:36:52
 */
@Controller
@RequestMapping("/admin/hospitalunitinformation")
public class HospitalUnitInformationController extends BaseCRUDController<HospitalUnitInformation>  {
	@Autowired
	private HospitalUnitInformationService hospitalUnitInformationService;


	@ResponseBody
	@RequestMapping(value = "/queryHospitalByAreaId", method = RequestMethod.GET)
	public JsonResult queryHospitalByAreaId(ServletRequest request) {
		//查询列表数据
		List<HospitalUnitInformation> hospitalUnitInformation = hospitalUnitInformationService.queryHospitalByAreaId(super.getAreaId());
		return JsonResult.ok().addResult(JSON.toJSON(hospitalUnitInformation));
	}

}