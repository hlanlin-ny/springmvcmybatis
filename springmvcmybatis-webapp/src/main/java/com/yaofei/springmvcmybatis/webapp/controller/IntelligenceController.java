package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.Intelligence;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.service.IntelligenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 情报信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-12 11:31:52
 */
@Controller
@RequestMapping("/admin/intelligence")
public class IntelligenceController extends BaseCRUDController<Intelligence>  {
	@Autowired
	private IntelligenceService intelligenceService;


	@Override
	protected void addBefore(Intelligence entity, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		super.addBefore(entity, result, request, response);
		entity.setAreaId(this.getAreaId());
	}

	@Override
	protected void queryListBefore(HttpServletRequest request, HttpServletResponse response, DataTablesRequest dataTablesRequest) {
		super.queryListBefore(request, response, dataTablesRequest);
		dataTablesRequest.getExtraSearch().put("areaId", String.valueOf(this.getAreaId()));
	}

}