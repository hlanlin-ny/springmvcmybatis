package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.FileStaticClass;
import com.yaofei.springmvcmybatis.plugins.datatables.DataTablesUtils;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.service.FileStaticCountService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/admin/staticfilecount")
public class StaticFileCountController extends BaseCRUDController<FileStaticClass>  {
	@Autowired
	private FileStaticCountService staticFileCountService;

	@ResponseBody
	@RequestMapping(value = "/queryCount", method = RequestMethod.POST)
	public JsonResult queryCount(HttpServletRequest request, HttpServletResponse response) {
		//对请求参数解析，生成 排序条件、列搜索对象、全局搜索对象
		DataTablesRequest dataTablesRequest = DataTablesUtils.getDataTableRequest(request);
		List<FileStaticClass> result = staticFileCountService.queryCount(dataTablesRequest);
		return JsonResult .ok().addResult(result);
	}

	@ResponseBody
	@RequestMapping(value = "/querySum", method = RequestMethod.POST)
	public JsonResult querySum(HttpServletRequest request, HttpServletResponse response) {
		//对请求参数解析，生成 排序条件、列搜索对象、全局搜索对象
		DataTablesRequest dataTablesRequest = DataTablesUtils.getDataTableRequest(request);
		List<FileStaticClass> result = staticFileCountService.querySum(dataTablesRequest);
		return JsonResult .ok().addResult(result);
	}
}