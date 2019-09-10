package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.IntelligenceOfficer;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.service.IntelligenceOfficerService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 情报员信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-12 11:31:29
 */
@Controller
@RequestMapping("/admin/intelligenceofficer")
public class IntelligenceOfficerController extends BaseCRUDController<IntelligenceOfficer>  {
	@Autowired
	private IntelligenceOfficerService intelligenceOfficerService;

	@ResponseBody
	@RequestMapping(value = "/queryOfficerNames", method = RequestMethod.GET)
	public JsonResult  queryOfficerNames() {
		Long arg = this.getAreaId();
		List<IntelligenceOfficer> result = intelligenceOfficerService.queryOfficerNames(arg.toString());
		return JsonResult .ok().addResult(result);
	}

	@Override
	protected void addBefore(IntelligenceOfficer entity, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		super.addBefore(entity, result, request, response);
		entity.setAreaId(this.getAreaId());
	}

	@Override
	protected void queryListBefore(HttpServletRequest request, HttpServletResponse response, DataTablesRequest dataTablesRequest) {
		super.queryListBefore(request, response, dataTablesRequest);
		dataTablesRequest.getExtraSearch().put("areaId", String.valueOf(this.getAreaId()));
	}
}