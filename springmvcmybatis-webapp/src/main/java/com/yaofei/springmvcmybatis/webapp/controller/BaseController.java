package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.BaseEntity;
import com.yaofei.springmvcmybatis.shiro.domain.ShiroUser;
import com.yaofei.springmvcmybatis.webapp.plugins.xss.StringEscapeEditor;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by f_yao on 2017/1/12.
 */
public class BaseController<T extends BaseEntity> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        /**
         * 自动转换日期类型的字段格式
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        /**
         * 防止XSS攻击
         */
        binder.registerCustomEditor(String.class, new StringEscapeEditor());
    }

    /**
     * 获取当前登录用户对象
     *
     * @return {ShiroUser}
     */
    public ShiroUser getShiroUser() {
        return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取当前登录用户id
     *
     * @return {Long}
     */
    public Long getUserId() {
        return this.getShiroUser().getId();
    }

    /**
     * 获取当前登录用户名
     *
     * @return {String}
     */
    public Long getAreaId() {
        return this.getShiroUser().getAreaId();
    }

    /**
     * 获取当前登录用户名
     *
     * @return {String}
     */
    public String getUsername() {
        return this.getShiroUser().getUsername();
    }

    /**
     * 获取当前用户的真实姓名
     *
     * @return {String}
     */
    public String getRealName() {
        return this.getShiroUser().getUserRealName();
    }

    /**
     * 实体类型
     */
    protected Class<T> entityClass;
    private String viewPrefix;

    protected BaseController() {
        this.entityClass = null;
        Class<?> c = this.getClass();//获取实际运行的类的 Class
        Type type = c.getGenericSuperclass(); //获取实际运行的类的直接超类的泛型类型
        if (type instanceof ParameterizedType) { //如果该泛型类型是参数化类型
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
            System.out.println("BaseController的泛型的真实实现类是：" + this.entityClass.getName());
        }

        setViewPrefix(defaultViewPrefix());
    }

    private String defaultViewPrefix() {
        String currentViewPrefix = "";
        RequestMapping requestMapping = AnnotationUtils.findAnnotation(getClass(), RequestMapping.class);
        if (requestMapping != null && requestMapping.value().length > 0) {
            currentViewPrefix = requestMapping.value()[0];
        }

        if (StringUtils.isEmpty(currentViewPrefix)) {
            currentViewPrefix = this.entityClass.getSimpleName();
        }

        return currentViewPrefix;
    }

    /**
     * 当前模块 视图的前缀
     * 默认
     * 1、获取当前类头上的@RequestMapping中的value作为前缀
     * 2、如果没有就使用当前模型小写的简单类名
     */
    public void setViewPrefix(String viewPrefix) {
        if (viewPrefix.startsWith("/")) {
            viewPrefix = viewPrefix.substring(1);
        }
        this.viewPrefix = viewPrefix;
    }

    public String getViewPrefix() {
        return viewPrefix;
    }

    ///**
    // * 设置通用数据
    // */
    //protected void setCommonData(JsonResult jsonResult) {
    //}
    //
    //protected T newModel() {
    //    try {
    //        return entityClass.newInstance();
    //    } catch (Exception e) {
    //        throw new IllegalStateException("can not instantiated model : " + this.entityClass, e);
    //    }
    //}
    //
    ///**
    // * 获取视图名称：即prefixViewName + "/" + suffixName
    // *
    // * @return
    // */
    //public String viewName(String suffixName) {
    //    if (!suffixName.startsWith("/")) {
    //        suffixName = "/" + suffixName;
    //    }
    //    return getViewPrefix() + suffixName;
    //}
    //
    ///**
    // * 共享的验证规则
    // * 验证失败返回true
    // *
    // * @param m
    // * @param result
    // * @return
    // */
    //protected boolean hasError(T m, BindingResult result) {
    //    Assert.notNull(m);
    //    return result.hasErrors();
    //}
    //
    ///**
    // * @param backURL null 将重定向到默认getViewPrefix()
    // * @return
    // */
    //protected String redirectToUrl(String backURL) {
    //    if (StringUtils.isEmpty(backURL)) {
    //        backURL = getViewPrefix();
    //    }
    //    if (!backURL.startsWith("/") && !backURL.startsWith("http")) {
    //        backURL = "/" + backURL;
    //    }
    //    return "redirect:" + backURL;
    //}
}