package com.yaofei.springmvcmybatis.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.entity.SysUserPermission;
import com.yaofei.springmvcmybatis.service.SysUserPermissionService;
import com.yaofei.springmvcmybatis.webapp.dto.TreeNode;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统用户权限表
 *
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
@Controller
@RequestMapping("/admin/sysuserpermission")
public class SysUserPermissionController extends BaseCRUDController<SysUserPermission> {
    @Autowired
    private SysUserPermissionService sysUserPermissionService;

    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/queryNotButtonNodes", method = RequestMethod.GET)
    public JsonResult queryNotButtonNodes(ServletRequest request) {
        //查询列表数据
        List<SysUserPermission> sysUserPermissions = sysUserPermissionService.queryNotButtonList();

        List<TreeNode> treeNodes = new ArrayList<>();
        //添加顶级菜单
        TreeNode node = new TreeNode(0L, -1L, "根目录", false, true);
        treeNodes.add(node);
        for (SysUserPermission sysUserPermission : sysUserPermissions) {
            node = new TreeNode(sysUserPermission.getId(), sysUserPermission.getParentId(), sysUserPermission.getName(), false, true);
            treeNodes.add(node);
        }
        return JsonResult.ok().addResult(JSON.toJSON(treeNodes));
    }

    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/queryAllNodes", method = RequestMethod.GET)
    public JsonResult queryAllNodes(ServletRequest request) {
        //查询列表数据
        List<SysUserPermission> sysUserPermissions = sysUserPermissionService.queryAllNodesOrderByOderNum();

        List<TreeNode> treeNodes = new ArrayList<>();
        //添加顶级菜单
        TreeNode node = new TreeNode(0L, -1L, "根目录", false, true);
        treeNodes.add(node);
        for (SysUserPermission sysUserPermission : sysUserPermissions) {
            node = new TreeNode(sysUserPermission.getId(), sysUserPermission.getParentId(), sysUserPermission.getName(), false, true);
            treeNodes.add(node);
        }
        return JsonResult.ok().addResult(JSON.toJSON(treeNodes));
    }
}