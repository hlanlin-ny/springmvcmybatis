package com.yaofei.springmvcmybatis.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.entity.ExpressCompany;
import com.yaofei.springmvcmybatis.service.ExpressCompanyService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * 快递公司信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
@Controller
@RequestMapping("/admin/expresscompany")
public class ExpressCompanyController extends BaseCRUDController<ExpressCompany>  {
	@Autowired
	private ExpressCompanyService expressCompanyService;

	@ResponseBody
	@RequestMapping(value = "/queryExpressCompanysByAreaId", method = RequestMethod.GET)
	public JsonResult queryExpressCompanysByAreaId(ServletRequest request) {
		//查询列表数据
		List<ExpressCompany> expressCompanies = expressCompanyService.queryExpressCompanysByAreaId(super.getAreaId());
		return JsonResult.ok().addResult(JSON.toJSON(expressCompanies));
	}

}