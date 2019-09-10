package com.yaofei.springmvcmybatis.webapp.controlleradvice;

import com.yaofei.springmvcmybatis.plugins.quartz.QuartzJobException;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
@ControllerAdvice
public class GlobalExceptionControllerAdvice {

    //private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GlobalExceptionControllerAdvice.class);
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(UnauthorizedException.class)
    public String unauthorizedExceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return "admin/login/unauthorized";
    }


    @ResponseBody
    @ExceptionHandler(QuartzJobException.class)
    public JsonResult quartzJobExceptionrHandler(Exception e) {
        logger.error(e.getMessage(), e);
        if(StringUtils.isNotBlank(e.getMessage())){
            return JsonResult.error(e.getMessage());
        }else {
            return JsonResult.error();
        }
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public JsonResult exceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        if(StringUtils.isNotBlank(e.getMessage())){
            return JsonResult.error(e.getMessage());
        }else {
            return JsonResult.error();
        }
    }
}