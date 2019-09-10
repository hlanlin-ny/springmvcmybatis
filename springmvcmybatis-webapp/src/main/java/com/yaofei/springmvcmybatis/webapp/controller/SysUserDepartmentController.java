package com.yaofei.springmvcmybatis.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.entity.SysUserDepartment;
import com.yaofei.springmvcmybatis.service.SysUserDepartmentService;
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
 * 系统用户部门表
 *
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
@Controller
@RequestMapping("/admin/sysuserdepartment")
public class SysUserDepartmentController extends BaseCRUDController<SysUserDepartment> {
    @Autowired
    private SysUserDepartmentService sysUserDepartmentService;

    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/queryAllNodes", method = RequestMethod.GET)
    public JsonResult queryAllNodes(ServletRequest request) {
        //查询列表数据
        List<SysUserDepartment> sysUserDepartments = sysUserDepartmentService.queryListOrderByOrderNum();

        List<TreeNode> treeNodes = new ArrayList<>();
        //添加顶级菜单
        TreeNode node = new TreeNode(0L, -1L, "根部门", false, true);
        treeNodes.add(node);
        for (SysUserDepartment sysUserDepartment : sysUserDepartments) {
            node = new TreeNode(sysUserDepartment.getId(), sysUserDepartment.getParentId(), sysUserDepartment.getName(), false, true);
            treeNodes.add(node);
        }
        return JsonResult.ok().addResult(JSON.toJSON(treeNodes));
    }
}