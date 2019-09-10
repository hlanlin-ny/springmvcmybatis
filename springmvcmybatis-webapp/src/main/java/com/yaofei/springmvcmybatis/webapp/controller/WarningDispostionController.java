package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.WarningDispostion;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.service.WarningDispostionService;
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
 * 预警处置详情
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-21 11:14:23
 */
@Controller
@RequestMapping("/admin/warningdispostion")
public class WarningDispostionController extends BaseCRUDController<WarningDispostion>  {
	@Autowired
	private WarningDispostionService warningDispostionService;


	@ResponseBody
	@RequestMapping(value = "/claim")
	public JsonResult claim(HttpServletRequest request,Long id){
		warningDispostionService.claim(id);
		return JsonResult.ok();
	}

	/**
	 *   处置措施详情
	 */
	@ResponseBody
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public JsonResult detail(HttpServletRequest request, HttpServletResponse response,Long id) throws Exception {
		if (permissionService != null) {
			this.permissionService.assertHasSearchPermission();
		}
		List<Object> lists = warningDispostionService.detail(id);
		return JsonResult.ok().addResult(lists);
	}


	/**
	 *   处置措施详情
	 */
	@ResponseBody
	@RequestMapping(value = "/disposition", method = RequestMethod.POST)
	public JsonResult disposition(HttpServletRequest request, HttpServletResponse response,Long relateId) throws Exception {
		if (permissionService != null) {
			this.permissionService.assertHasSearchPermission();
		}
		List<Object> lists = warningDispostionService.queryDisposition(relateId);
		return JsonResult.ok().addResult(lists);
	}

	/**
	 *   反馈结果详情
	 */
	@ResponseBody
	@RequestMapping(value = "/feedBack", method = RequestMethod.POST)
	public JsonResult feedBack(HttpServletRequest request, HttpServletResponse response,Long relateId) throws Exception {
		if (permissionService != null) {
			this.permissionService.assertHasSearchPermission();
		}
		List<Object> lists = warningDispostionService.queryFeedBack(relateId);
		return JsonResult.ok().addResult(lists);
	}

	/**
	 *   增加处置结果
	 */
	@ResponseBody
	@RequestMapping(value = "/result/add", method = RequestMethod.POST)
	public JsonResult AddFeedBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (permissionService != null) {
			this.permissionService.assertHasSearchPermission();
		}
		String username = super.getUsername();
		boolean a = warningDispostionService.saveList(request,username);
		if(a == false){
			return JsonResult.error("添加处置结果失败");
		}
		return  JsonResult.ok();

	}

	/**
	 *   增加处置措施
	 */
	@ResponseBody
	@RequestMapping(value = "/disposition/add", method = RequestMethod.POST)
	public JsonResult AddDisposition(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (permissionService != null) {
			this.permissionService.assertHasSearchPermission();
		}
		String username = super.getUsername();
		warningDispostionService.saveDisposition(request,username);
		return JsonResult.ok().addResult(null);
	}

	@ResponseBody
	@RequestMapping(value = "/warningTime")
	public JsonResult warningTime(){
		List<WarningDispostion> warningDispostions = warningDispostionService.compare();
		return  JsonResult.ok().addResult(warningDispostions);
	}

	@ResponseBody
	@RequestMapping(value = "/queryUnclaim")
    public JsonResult queryUnclaim(HttpServletRequest request){
		int count = warningDispostionService.queryUnclaim();
		return JsonResult.ok().addResult(count);
	}



	@Override
	protected void queryListBefore(HttpServletRequest request, HttpServletResponse response, DataTablesRequest dataTablesRequest) {
		dataTablesRequest.setOrderString("warning_time");
		super.queryListBefore(request, response, dataTablesRequest);
	}
}