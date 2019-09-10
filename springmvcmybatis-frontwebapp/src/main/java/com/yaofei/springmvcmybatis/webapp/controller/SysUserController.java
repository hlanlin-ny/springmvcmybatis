package com.yaofei.springmvcmybatis.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.entity.SysUser;
import com.yaofei.springmvcmybatis.plugins.datatables.DataTablesUtils;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesResponse;
import com.yaofei.springmvcmybatis.service.SysUserService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

/**
 * 系统用户表
 *
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
@Controller
@RequestMapping("/admin/sysuser")
public class SysUserController extends BaseCRUDController<SysUser> {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/queryListWithCustom", method = RequestMethod.POST)
    public JsonResult queryListWithCustom(HttpServletRequest request) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasListPermission();
        }

        //对请求参数解析，生成 排序条件、列搜索对象、全局搜索对象
        DataTablesRequest dataTablesRequest = DataTablesUtils.getDataTableRequest(request);

        //查询列表数据
        List<SysUser> currentPageData = sysUserService.queryListWithCustom(dataTablesRequest);
        long recordsTotal = baseService.queryTotal(dataTablesRequest);

        //dataTable 相应参数
        DataTablesResponse<SysUser> dataTablesResponse = new DataTablesResponse<>(dataTablesRequest.getDraw(), recordsTotal, currentPageData);
        return JsonResult.ok().addResult(dataTablesResponse);
    }

    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/saveUserAndUserRoles", method = RequestMethod.POST)
    public JsonResult saveUserAndUserRoles(ServletRequest request) throws ServletRequestBindingException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }

        return this.saveOrUpdate(request, true);
    }


    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/updateUserAndUserRoles", method = RequestMethod.POST)
    public JsonResult updateUserAndUserRoles(ServletRequest request) throws ServletRequestBindingException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (permissionService != null) {
            this.permissionService.assertHasEditPermission();
        }

        return this.saveOrUpdate(request, false);
    }

    private JsonResult saveOrUpdate(ServletRequest request, boolean isSave) throws ServletRequestBindingException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String result = super.resolveServletRequest(request);
        if (result == null || result.length() == 0 || result.length() <= 2) {
            throw new ServletRequestBindingException("校验请求失败");
        }
        SysUser sysUser = JSON.parseObject(result, this.entityClass);
        if (isSave) {
            sysUser.setCreatedBy(super.getUsername());
            sysUser.setCreatedIp(request.getRemoteAddr());
        }
        sysUser.setModificationBy(super.getUsername());
        sysUser.setModificationIp(request.getRemoteAddr());

        if (isSave) {
        } else {
        }

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<SysUser>> constraintViolations = validator.validate(sysUser);
        if (constraintViolations != null && constraintViolations.size() > 0) {
            throw new ServletRequestBindingException("校验请求失败");
        } else {
            if (isSave) {
                sysUserService.saveUserAndUserRoles(sysUser);
            } else {
                sysUserService.updateUserAndUserRoles(sysUser);
            }
        }
        return JsonResult.ok();
    }

    /**
     * 删除
     */
    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/{id}/deleteUserAndUserRoles", method = RequestMethod.POST)
    public JsonResult deleteUserAndUserRoles(@PathVariable("id") Long id) {
        if (permissionService != null) {
            this.permissionService.assertHasDeletePermission();
        }

        sysUserService.deleteUserAndUserRoles(id);
        return JsonResult.ok();
    }

    //@RequiresPermissions("sysuser:queryList")
    @ResponseBody
    @RequestMapping(value = "/batch/deleteUserAndUserRoles", method = RequestMethod.POST)
    public JsonResult deleteUserAndUserRolesInBatch(@RequestBody Long[] ids) {
        if (permissionService != null) {
            this.permissionService.assertHasBatchDeletePermission();
        }

        if (ids != null && ids.length > 0) {
            sysUserService.deleteUserAndUserRolesInBatch(ids);
        }
        return JsonResult.ok();
    }

    @ResponseBody
    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public JsonResult changePassword(String password, String newPassword, String confirmPassword) {

        if (StringUtils.isBlank(password)) {
            return JsonResult.error("新密码不为能空");
        }
        if (StringUtils.isBlank(newPassword) || StringUtils.isBlank(confirmPassword)) {
            return JsonResult.error("新密码不为能空");
        }
        if (!newPassword.equals(confirmPassword)) {
            return JsonResult.error("新密码和确认密码不一致");
        }

        //更新密码
        int count = sysUserService.changePassword(getUserId(), password, newPassword);
        if (count == 0) {
            return JsonResult.error("原密码不正确");
        }

        //退出
        SecurityUtils.getSubject().logout();
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping(value = "/queryAllUsers", method = RequestMethod.GET)
    public JsonResult queryAllUsers(HttpServletRequest request) throws Exception {
        //查询列表数据
        List<SysUser> allData = sysUserService.queryAllUsers();
        return JsonResult.ok().addResult(allData);
    }

    /**
     * 自定义的查询列表
     */
    //@ResponseBody
    //@RequestMapping(value = "/queryList", method = RequestMethod.POST)
    ////@RequiresPermissions("sysuser:queryList")
    //public JsonResult queryList(HttpServletRequest request) throws Exception {
    //    //对请求参数解析，生成 排序条件、列搜索对象、全局搜索对象
    //    DataTablesRequest dataTableRequest = DataTablesUtils.getDataTableRequest(request);
    //    long recordsTotal = 0;
    //    long recordsFiltered = 0;
    //    List<SysUser> data = new ArrayList<>();
    //    //dataTable 相应参数
    //    DataTablesResponse<SysUser> dataTableResponse = new DataTablesResponse<>(dataTableRequest.getDraw(), recordsTotal, recordsFiltered, data);
    //    return JsonResult.ok().addResult(dataTableResponse);
    //}

    //
    ///**
    // * 信息
    // */
    //@ResponseBody
    //@RequestMapping("/info/{id}")
    //@RequiresPermissions("sysuser:info")
    //public R info(@PathVariable("id") Long id){
    //	SysUser sysUser = sysUserService.queryObject(id);
    //
    //	return R.ok().put("sysUser", sysUser);
    //}
    //
    ///**
    // * 保存
    // */
    //@ResponseBody
    //@RequestMapping("/save")
    //@RequiresPermissions("sysuser:save")
    //public R save(@RequestBody SysUser sysUser){
    //	sysUserService.save(sysUser);
    //
    //	return R.ok();
    //}
    //
    ///**
    // * 修改
    // */
    //@ResponseBody
    //@RequestMapping("/update")
    //@RequiresPermissions("sysuser:update")
    //public R update(@RequestBody SysUser sysUser){
    //	sysUserService.update(sysUser);
    //
    //	return R.ok();
    //}
    //
    ///**
    // * 删除
    // */
    //@ResponseBody
    //@RequestMapping("/delete")
    //@RequiresPermissions("sysuser:delete")
    //public R delete(@RequestBody Long[] ids){
    //	sysUserService.deleteBatch(ids);
    //
    //	return R.ok();
    //}

}
