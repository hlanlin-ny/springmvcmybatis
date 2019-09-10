package com.yaofei.springmvcmybatis.webapp.context;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class   WebRequestContextFilter implements Filter {


    @Override
    public void init(FilterConfig cfg) throws ServletException {
//		try {
//			pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));
//		} catch (NumberFormatException e) {
//			pageSize = 10;
//		}
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        String operUserName = "default";
        try {
            HttpServletRequest request = (HttpServletRequest) req;
            String sessionKey = "operUserName";
            Object sessionObj = request.getSession().getAttribute(sessionKey);
            if (sessionObj != null) {
                operUserName = (String) sessionObj;
            }
        } catch (Exception e) {
        }

        try {
            WebRequestContext systemRequest = new WebRequestContext();
//			System.out.println("-------------------doFilter：operUserName:" + operUserName
//					+ "-----------------------");

            systemRequest.setOperUserName(operUserName);
            WebRequestContextHolder.initRequestHolder(systemRequest);
            chain.doFilter(req, resp);
        } finally {
            WebRequestContextHolder.remove();
        }
    }

    @Override
    public void destroy() {

    }
}
