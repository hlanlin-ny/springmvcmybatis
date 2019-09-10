package com.yaofei.springmvcmybatis.webapp.filter;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * 记录访问日志
 */
public class AccessLogFilter extends BaseFilter {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        //String username = getUsername();
        //String jsessionId = request.getRequestedSessionId();
        //String ip = IpUtils.getIpAddr(request);
        //String accept = request.getHeader("accept");
        //String userAgent = request.getHeader("User-Agent");
        //String url = request.getRequestURI();
        //String params = getParams(request);
        //String headers = getHeaders(request);
        //
        //StringBuilder s = new StringBuilder();
        //s.append(getBlock(username));
        //s.append(getBlock(jsessionId));
        //s.append(getBlock(ip));
        //s.append(getBlock(accept));
        //s.append(getBlock(userAgent));
        //s.append(getBlock(url));
        //s.append(getBlock(params));
        //s.append(getBlock(headers));
        //s.append(getBlock(request.getHeader("Referer")));
        //logger.info(s.toString());
        chain.doFilter(request, response);
    }

    private static String getHeaders(HttpServletRequest request) {
        Map<String, List<String>> headers = Maps.newHashMap();
        Enumeration<String> namesEnumeration = request.getHeaderNames();
        while(namesEnumeration.hasMoreElements()) {
            String name = namesEnumeration.nextElement();
            Enumeration<String> valueEnumeration = request.getHeaders(name);
            List<String> values = Lists.newArrayList();
            while(valueEnumeration.hasMoreElements()) {
                values.add(valueEnumeration.nextElement());
            }
            headers.put(name, values);
        }
        return JSON.toJSONString(headers);
    }


    protected static String getUsername() {
        //return (String) SecurityUtils.getSubject().getPrincipal();
        return "";
    }

    public static String getBlock(Object msg) {
        if (msg == null) {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }

    protected static String getParams(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        return JSON.toJSONString(params);
    }
}
