package com.yaofei.springmvcmybatis.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.entity.ExpressUser;
import com.yaofei.springmvcmybatis.service.ExpressUserService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * 快递用户信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
@Controller
@RequestMapping("/admin/expressuser")
public class ExpressUserController extends BaseCRUDController<ExpressUser>  {
	@Autowired
	private ExpressUserService expressUserService;



	@ResponseBody
	@RequestMapping(value = "/queryExpressUsersByAreaId", method = RequestMethod.GET)
	public JsonResult queryExpressUsersByAreaId(ServletRequest request) {
		//查询列表数据
		List<ExpressUser> expressCompanies = expressUserService.queryExpressUsersByAreaId(super.getAreaId());
		return JsonResult.ok().addResult(JSON.toJSON(expressCompanies));
	}

}