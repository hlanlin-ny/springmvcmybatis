package com.filesever.webapp.dto;

import org.springframework.ui.ModelMap;

/**
 * Created by f_yao on 2016/9/12.
 */
public class JsonResult extends ModelMap {

    private JsonResult() {
        this(0, "");
    }

    private JsonResult(int code, String message) {
        this.addAttribute("code", Integer.valueOf(code));
        this.addAttribute("message", message);
    }

    public static JsonResult ok() {
        return new JsonResult();
    }

    public static JsonResult error() {
        return new JsonResult(500, "未知异常，请联系管理员");
    }

    public static JsonResult error(int code, String message) {
        return new JsonResult(code, message);
    }

    public static JsonResult error(String message) {
        return new JsonResult(500, message);
    }

    public JsonResult setCode(int code) {
        this.addAttribute("code", Integer.valueOf(code));
        return this;
    }

    public JsonResult setMessage(String message) {
        this.addAttribute("message", message);
        return this;
    }

    public JsonResult addResult(Object attributeValue) {
        super.addAttribute("result", attributeValue);
        return this;
    }

    public JsonResult addAttribute(String attributeName, Object attributeValue) {
        super.addAttribute(attributeName, attributeValue);
        return this;
    }
}
