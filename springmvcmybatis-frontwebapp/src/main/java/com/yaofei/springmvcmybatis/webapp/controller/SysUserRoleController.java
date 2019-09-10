package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.SysUserRole;
import com.yaofei.springmvcmybatis.service.SysUserRoleService;
import com.yaofei.springmvcmybatis.plugins.datatables.DataTablesUtils;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesResponse;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 系统用户角色表
 *
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
@Controller
@RequestMapping("/admin/sysuserrole")
public class SysUserRoleController extends BaseCRUDController<SysUserRole> {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 列表
     */
    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/queryListWithCustom", method = RequestMethod.POST)
    public JsonResult queryListWithCustom(HttpServletRequest request) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasSearchPermission();
        }

        //对请求参数解析，生成 排序条件、列搜索对象、全局搜索对象
        DataTablesRequest dataTablesRequest = DataTablesUtils.getDataTableRequest(request);

        //查询列表数据
        List<SysUserRole> currentPageData = sysUserRoleService.queryListWithCustom(dataTablesRequest);
        long recordsTotal = baseService.queryTotal(dataTablesRequest);

        //dataTable 相应参数
        DataTablesResponse<SysUserRole> dataTablesResponse = new DataTablesResponse<>(dataTablesRequest.getDraw(), recordsTotal, currentPageData);
        return JsonResult.ok().addResult(dataTablesResponse);
    }

    @ResponseBody
    @RequestMapping(value = "/queryAllUserRoles", method = RequestMethod.GET)
    public JsonResult queryAllUserRoles(HttpServletRequest request) throws Exception {
        //查询列表数据
        List<SysUserRole> allData = sysUserRoleService.queryAllUserRoles();
        return JsonResult.ok().addResult(allData);
    }

    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/saveUserRoleAndPermissions")
    public JsonResult saveUserRoleAndPermissions(@Validated @RequestBody SysUserRole sysUserRole,BindingResult bindingResult) throws ServletRequestBindingException {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        if(bindingResult.hasErrors()){
            throw new ServletRequestBindingException("校验请求失败");
        }

        sysUserRoleService.saveUserRoleAndPermissions(sysUserRole);
        return JsonResult.ok();
    }

    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/updateUserRoleAndPermissions")
    public JsonResult updateUserRoleAndPermissions(@Validated @RequestBody SysUserRole sysUserRole,BindingResult bindingResult) throws ServletRequestBindingException {
        if (permissionService != null) {
            this.permissionService.assertHasEditPermission();
        }
        if(bindingResult.hasErrors()){
            throw new ServletRequestBindingException("校验请求失败");
        }

        sysUserRoleService.updateUserRoleAndPermissions(sysUserRole);
        return JsonResult.ok();
    }

    /**
     * 删除
     */
    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/{id}/deleteUserRoleAndPermissions", method = RequestMethod.POST)
    public JsonResult deleteUserRoleAndPermissions(@PathVariable("id") Long id) {
        if (permissionService != null) {
            this.permissionService.assertHasDeletePermission();
        }

        sysUserRoleService.deleteUserRoleAndPermissions(id);
        return JsonResult.ok();
    }

    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/batch/deleteUserRoleAndPermissions",  method = RequestMethod.POST)
    public JsonResult deleteUserRoleAndPermissionsInBatch(@RequestBody Long[] ids) {
        if (permissionService != null) {
            this.permissionService.assertHasBatchDeletePermission();
        }

        if (ids != null && ids.length > 0) {
            sysUserRoleService.deleteUserRoleAndPermissionsInBatch(ids);
        }
        return JsonResult.ok();
    }
}