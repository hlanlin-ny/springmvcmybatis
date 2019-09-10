package com.yaofei.springmvcmybatis.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.entity.LogisticsUser;
import com.yaofei.springmvcmybatis.service.LogisticsUserService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * 物流用户信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
@Controller
@RequestMapping("/admin/logisticsuser")
public class LogisticsUserController extends BaseCRUDController<LogisticsUser>  {
	@Autowired
	private LogisticsUserService logisticsUserService;



	@ResponseBody
	@RequestMapping(value = "/queryLogisticsUsersByAreaId", method = RequestMethod.GET)
	public JsonResult queryLogisticsUsersByAreaId(ServletRequest request) {
		//查询列表数据
		List<LogisticsUser> logisticsCompanies = logisticsUserService.queryLogisticsUsersByAreaId(super.getAreaId());
		return JsonResult.ok().addResult(JSON.toJSON(logisticsCompanies));
	}

}