package com.yaofei.springmvcmybatis.webapp.context;

/**
 * Created by f_yao on 2016/9/11.
 */
public class WebRequestContextHolder {
    private final static ThreadLocal<WebRequestContext> systemRequesthreadLocal = new ThreadLocal<WebRequestContext>();

    public static void initRequestHolder(WebRequestContext systemRequest) {
        systemRequesthreadLocal.set(systemRequest);
    }

    public static WebRequestContext getSystemRequest() {
        return systemRequesthreadLocal.get();
    }

    public static void remove() {
        systemRequesthreadLocal.remove();
    }
}
