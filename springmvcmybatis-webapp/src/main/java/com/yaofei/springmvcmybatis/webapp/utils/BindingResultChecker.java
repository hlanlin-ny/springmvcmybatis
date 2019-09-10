package com.yaofei.springmvcmybatis.webapp.utils;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;

/**
 * Created by f_yao on 2017/2/23.
 */
public class BindingResultChecker {
    public static void check(BindingResult result) throws ServletRequestBindingException {
        if(result.hasErrors()){
            throw new ServletRequestBindingException("校验请求失败");
        }
    }
}
