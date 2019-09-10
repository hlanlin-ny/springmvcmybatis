package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.SysUserRolePermission;
import com.yaofei.springmvcmybatis.service.SysUserRolePermissionService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统用户角色权限关系表
 *
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
@Controller
@RequestMapping("/admin/sysuserrolepermission")
public class SysUserRolePermissionController extends BaseCRUDController<SysUserRolePermission> {
    @Autowired
    private SysUserRolePermissionService sysUserRolePermissionService;

    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/{userRoleId}/queryPermissionsIdsByRoleId")
    public JsonResult queryPermissionsIdsByRoleId(@PathVariable("userRoleId") Long userRoleId) {
        List<Long> permissions = new ArrayList<>();
        //查询角色对应的菜单
        List<SysUserRolePermission> sysUserRolePermissions = sysUserRolePermissionService.querySysUserRolePermissionsByRoleId(userRoleId);
        for (SysUserRolePermission sysUserRolePermission : sysUserRolePermissions) {
            permissions.add(sysUserRolePermission.getUserPermissionId());
        }
        return JsonResult.ok().addResult(permissions);
    }
}