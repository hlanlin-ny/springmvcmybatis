package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.BaseEntity;
import com.yaofei.springmvcmybatis.service.impl.AbstractBaseService;
import com.yaofei.springmvcmybatis.service.impl.PermissionService;
import com.yaofei.springmvcmybatis.plugins.datatables.DataTablesUtils;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesResponse;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import com.yaofei.springmvcmybatis.webapp.utils.BindingResultChecker;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 基础CRUD 控制器
 * Created by f_yao on 2017/1/12.
 */
public class BaseCRUDController<T extends BaseEntity> extends BaseController<T> {

    @Autowired
    protected AbstractBaseService<T> baseService;
    //@Autowired
    //protected MessageSource messageSource;
    //private boolean listAlsoSetCommonData = false;

    protected PermissionService permissionService = null;

    ///**
    // * 列表是否也要设置common data
    // */
    //public void setListAlsoSetCommonData(boolean listAlsoSetCommonData) {
    //    this.listAlsoSetCommonData = listAlsoSetCommonData;
    //}

    ///**
    // * 权限前缀：如sysuser
    // * 则生成的新增权限为 sysuser:create
    // */
    //public void setResourceIdentity(String resourceIdentity) {
    //    if (!StringUtils.isEmpty(resourceIdentity)) {
    //        permissionService = PermissionService.newPermissionList(resourceIdentity);
    //    }
    //}

    protected BaseCRUDController() {
        int splitIndex = super.getViewPrefix().lastIndexOf("/");
        String resourceIdentity = super.getViewPrefix().substring(splitIndex + 1);
        if (!StringUtils.isEmpty(resourceIdentity)) {
            permissionService = PermissionService.newPermissionList(resourceIdentity);
        }
    }

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public String list(HttpServletRequest request, HttpServletResponse response) {
        if (permissionService != null) {
            this.permissionService.assertHasListPermission();
        }
        listBefore(request, response);
        String result = getViewPrefix() + "/list";
        listAfter(request, response);
        return result;
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public JsonResult queryAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasSearchPermission();
        }
        queryAllBefore(request, response);
        //对请求参数解析，生成 排序条件、列搜索对象、全局搜索对象
        DataTablesRequest dataTablesRequest = DataTablesUtils.getDataTableRequest(request);
        //查询列表数据
        List<T> allData = baseService.queryAll();
        queryAllAfter(request, response);
        return JsonResult.ok().addResult(allData);
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public JsonResult queryList(HttpServletRequest request, HttpServletResponse response) {
        if (permissionService != null) {
            this.permissionService.assertHasSearchPermission();
        }
        //对请求参数解析，生成 排序条件、列搜索对象、全局搜索对象
        DataTablesRequest dataTablesRequest = DataTablesUtils.getDataTableRequest(request);

        queryListBefore(request, response,dataTablesRequest);
        //查询列表数据
        List<T> currentPageData = baseService.queryList(dataTablesRequest);
        long recordsTotal = baseService.queryTotal(dataTablesRequest);

        //dataTable 相应参数
        DataTablesResponse<T> dataTablesResponse = new DataTablesResponse<>(dataTablesRequest.getDraw(), recordsTotal, currentPageData);
        queryListAfter(request, response);
        return JsonResult.ok().addResult(dataTablesResponse);
    }

    ///**
    // * 信息
    // */
    //@ResponseBody
    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //public JsonResult view(@PathVariable("id") ID id) {
    //    if (permissionService != null) {
    //        this.permissionService.assertHasViewPermission();
    //    }
    //
    //    JsonResult jsonResult = JsonResult.ok();
    //    setCommonData(jsonResult);
    //
    //    return jsonResult.addResult(baseService.queryObject(id));
    //}


    ///**
    // * 显示添加界面的时候调用，用于数据初始化。根据需要调用
    // */
    //@RequestMapping(value = "/add", method = RequestMethod.GET)
    //public JsonResult showCreateForm() {
    //
    //    if (permissionService != null) {
    //        this.permissionService.assertHasCreatePermission();
    //    }
    //
    //    JsonResult jsonResult = JsonResult.ok();
    //    setCommonData(jsonResult);
    //
    //    return jsonResult.addResult(newModel());
    //}

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResult add(@Valid @RequestBody T entity, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ServletRequestBindingException {

        BindingResultChecker.check(result);
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }

        addBefore(entity, result, request, response);
        Field[] declaredFields = this.entityClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            switch (declaredField.getName()) {
                case "createdBy":
                    BeanUtils.setProperty(entity, "createdBy", super.getUsername());
                    break;
                case "createdIp":
                    BeanUtils.setProperty(entity, "createdIp", request.getRemoteAddr());
                    break;
                //case "modificationBy":
                //    BeanUtils.setProperty(entity, "modificationBy", super.getUsername());
                //    break;
                //case "modificationIp":
                //    BeanUtils.setProperty(entity, "modificationIp", request.getRemoteAddr());
                //    break;
                case "remark":
                    if (BeanUtils.getProperty(entity, "remark") == null) {
                        BeanUtils.setProperty(entity, "remark", "");
                    }
                    break;
                default:
                    break;
            }
        }
        baseService.save(entity);
        addAfter(entity, result, request, response);
        return JsonResult.ok();
    }

    ///**
    // * 显示修改界面的时候调用，用于数据初始化。根据需要调用
    // */
    //@RequestMapping(value = "/update", method = RequestMethod.GET)
    //public JsonResult showUpdateForm(ID id) {
    //
    //    if (permissionService != null) {
    //        this.permissionService.assertHasUpdatePermission();
    //    }
    //
    //    JsonResult jsonResult = JsonResult.ok();
    //    setCommonData(jsonResult);
    //    return jsonResult.addResult(baseService.queryObject(id));
    //}

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JsonResult update(@Valid @RequestBody T entity, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        BindingResultChecker.check(result);
        if (permissionService != null) {
            this.permissionService.assertHasEditPermission();
        }

        updateBefore(entity, result, request, response);
        Field[] declaredFields = this.entityClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            switch (declaredField.getName()) {
                case "modificationBy":
                    BeanUtils.setProperty(entity, "modificationBy", super.getUsername());
                    break;
                case "modificationIp":
                    BeanUtils.setProperty(entity, "modificationIp", request.getRemoteAddr());
                    break;
                default:
                    break;
            }
        }
        baseService.update(entity);
        updateAfter(entity, result, request, response);
        return JsonResult.ok();
    }

    ///**
    // * 显示删除界面的时候调用，用于数据初始化。根据需要调用
    // */
    //@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    //public JsonResult showDeleteForm(@PathVariable("id") Object id) {
    //
    //    if (permissionService != null) {
    //        this.permissionService.assertHasDeletePermission();
    //    }
    //
    //    JsonResult jsonResult = JsonResult.ok();
    //    setCommonData(jsonResult);
    //    //return jsonResult.addResult(baseService.findOne(id));
    //    return jsonResult;
    //}

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public JsonResult delete(@PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        if (id == null) {
            throw new ServletRequestBindingException("校验请求失败");
        }
        if (permissionService != null) {
            this.permissionService.assertHasDeletePermission();
        }
        deleteBefore(id, request, response);
        baseService.delete(id);
        deleteAfter(id, request, response);
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping(value = "/batch/delete", method = RequestMethod.POST)
    public JsonResult deleteBatch(@RequestBody Object[] ids, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        if (ids == null || ids.length < 1) {
            throw new ServletRequestBindingException("校验请求失败");
        }
        if (permissionService != null) {
            this.permissionService.assertHasBatchDeletePermission();
        }
        deleteBatchBefore(ids, request, response);
        if (ids != null && ids.length > 0) {
            baseService.deleteBatch(ids);
        }
        deleteBatchAfter(ids, request, response);
        return JsonResult.ok();
    }

    //扩展方法
    protected void listBefore(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void listAfter(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void queryAllBefore(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void queryAllAfter(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void queryListBefore(HttpServletRequest request, HttpServletResponse response,DataTablesRequest dataTablesRequest) {
    }

    protected void queryListAfter(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void addBefore(T entity, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
    }

    protected void addAfter(T entity, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
    }

    protected void updateBefore(T entity, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
    }

    protected void updateAfter(T entity, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
    }

    protected void deleteBefore(Object id, HttpServletRequest request, HttpServletResponse response) {
    }

    protected void deleteAfter(Object id, HttpServletRequest request, HttpServletResponse response) {
    }

    protected void deleteBatchBefore(Object[] ids, HttpServletRequest request, HttpServletResponse response) {
    }

    protected void deleteBatchAfter(Object[] ids, HttpServletRequest request, HttpServletResponse response) {
    }

    /**
     * 读取request请求内容
     *
     * @param servletRequest
     * @return
     */
    protected String resolveServletRequest(ServletRequest servletRequest) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = servletRequest.getReader()) {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}