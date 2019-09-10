package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.SysSearchwarningConfig;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.service.SysSearchwarningConfigService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 搜索预警配置表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-24 17:12:36
 */
@Controller
@RequestMapping("/admin/syssearchwarningconfig")
public class SysSearchwarningConfigController extends BaseCRUDController<SysSearchwarningConfig>  {
	@Autowired
	private SysSearchwarningConfigService sysSearchwarningConfigService;

	@Override
	protected void addBefore(SysSearchwarningConfig entity, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		super.addBefore(entity, result, request, response);
		entity.setNoticeTo(String.valueOf(this.getUserId()));
		entity.setNoticeToName(this.getUsername());
		entity.setAreaId(this.getAreaId());
		String cron = "0 0/"+entity.getCronFrequency()+" * * * ?";
		entity.setCronExpression(cron);
	}

	@Override
	protected void updateBefore(SysSearchwarningConfig entity, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		super.updateBefore(entity, result, request, response);
		entity.setNoticeTo(String.valueOf(this.getUserId()));
		entity.setNoticeToName(this.getUsername());
		entity.setAreaId(this.getAreaId());
		String cron = "0 0/"+entity.getCronFrequency()+" * * * ?";
		entity.setCronExpression(cron);
	}

	@Override
	protected void queryListBefore(HttpServletRequest request, HttpServletResponse response, DataTablesRequest dataTablesRequest) {
		super.queryListBefore(request, response, dataTablesRequest);
		Map<String,String> search = dataTablesRequest.getExtraSearch();
		search.put("areaId",this.getAreaId().toString());
		dataTablesRequest.setExtraSearch(search);
	}

	/**
	 * 暂停运行
	 */
	@RequiresPermissions("syssearchwarningconfig:pause")
	@ResponseBody
	@RequestMapping(value = "/batch/pause", method = RequestMethod.POST)
	public JsonResult pause(@RequestBody Long[] ids) {
		sysSearchwarningConfigService.updateToPause(ids);
		return JsonResult.ok();
	}

	/**
	 * 恢复运行
	 */
	@RequiresPermissions("syssearchwarningconfig:resume")
	@ResponseBody
	@RequestMapping(value = "/batch/resume", method = RequestMethod.POST)
	public JsonResult resume(@RequestBody Long[] ids) {
		sysSearchwarningConfigService.updateToResume(ids);
		return JsonResult.ok();
	}

	/**
	 * 立即执行
	 */
	@RequiresPermissions("syssearchwarningconfig:run")
	@ResponseBody
	@RequestMapping(value = "/batch/run", method = RequestMethod.POST)
	public JsonResult run(@RequestBody Long[] ids) {
		sysSearchwarningConfigService.run(ids);
		return JsonResult.ok();
	}
}