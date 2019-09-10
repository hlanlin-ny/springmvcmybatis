package com.yaofei.springmvcmybatis.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.entity.LogisticsCompany;
import com.yaofei.springmvcmybatis.service.LogisticsCompanyService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * 物流公司信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
@Controller
@RequestMapping("/admin/logisticscompany")
public class LogisticsCompanyController extends BaseCRUDController<LogisticsCompany>  {
	@Autowired
	private LogisticsCompanyService logisticsCompanyService;

	@ResponseBody
	@RequestMapping(value = "/queryLogisticsCompanysByAreaId", method = RequestMethod.GET)
	public JsonResult queryLogisticsCompanysByAreaId(ServletRequest request) {
		//查询列表数据
		List<LogisticsCompany> logisticsCompanies = logisticsCompanyService.queryLogisticsCompanysByAreaId(super.getAreaId());
		return JsonResult.ok().addResult(JSON.toJSON(logisticsCompanies));
	}

}