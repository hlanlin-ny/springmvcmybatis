package com.yaofei.springmvcmybatis.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.entity.SysArea;
import com.yaofei.springmvcmybatis.service.SysAreaService;
import com.yaofei.springmvcmybatis.webapp.dto.TreeNode;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统行政区划表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-07-31 08:07:18
 */
@Controller
@RequestMapping("/admin/sysarea")
public class SysAreaController extends BaseCRUDController<SysArea>  {
	@Autowired
	private SysAreaService sysAreaService;

	@ResponseBody
	@RequestMapping(value = "/queryAllNodes", method = RequestMethod.GET)
	public JsonResult queryAllNodes(ServletRequest request) {
		//查询列表数据
		List<SysArea> sysAreas = sysAreaService.queryListOrderByOrderNum();

		List<TreeNode> treeNodes = new ArrayList<>();
		//添加顶级菜单
		TreeNode node = new TreeNode(0L, -1L, "中国", false, true);
		treeNodes.add(node);
		for (SysArea sysArea : sysAreas) {
			node = new TreeNode(sysArea.getId(), sysArea.getParentId(), sysArea.getName(), false, true);
			treeNodes.add(node);
		}
		return JsonResult.ok().addResult(JSON.toJSON(treeNodes));
	}
}