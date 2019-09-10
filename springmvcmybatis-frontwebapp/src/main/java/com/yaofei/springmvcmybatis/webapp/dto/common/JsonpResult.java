package com.yaofei.springmvcmybatis.webapp.dto.common;

import com.alibaba.fastjson.JSONPObject;

/**
 * @author dqliu
 * @since 2016/7/4
 */
public class JsonpResult {
    private JSONPObject jsonpObject;

    protected JsonpResult(JSONPObject jsonpObject) {
        this.jsonpObject = jsonpObject;
    }

    public static JsonpResult create(String callback) {
        return new JsonpResult(new JSONPObject(callback));
    }

    public JSONPObject addParameter(JsonResult jsonResult) {
        this.jsonpObject.addParameter(jsonResult);
        return this.jsonpObject;
    }
}
