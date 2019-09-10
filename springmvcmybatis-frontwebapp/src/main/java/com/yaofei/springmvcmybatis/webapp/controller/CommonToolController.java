package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.CommonTool;
import com.yaofei.springmvcmybatis.service.CommonToolService;
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
 * 常用工具表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-03 17:45:49
 */
@Controller
@RequestMapping("/admin/commontool")
public class CommonToolController extends BaseCRUDController<CommonTool>  {
	@Autowired
	private CommonToolService commonToolService;


	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping(value = "/queryAllByAreaId", method = RequestMethod.GET)
	public JsonResult queryAllByAreaId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<CommonTool> allData = commonToolService.queryAllByAreaId(super.getAreaId());
		return JsonResult.ok().addResult(allData);
	}

}