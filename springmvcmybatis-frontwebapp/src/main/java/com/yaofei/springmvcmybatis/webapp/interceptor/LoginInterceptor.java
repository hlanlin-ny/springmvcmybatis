package com.yaofei.springmvcmybatis.webapp.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by f_yao on 2016/10/20.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private String[] allow;//允许不拦截的请求

    public String[] getAllow() {
        return allow;
    }

    public void setAllow(String[] allow) {
        this.allow = allow;
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        System.out.println("ServletDispatcher 完成处理时执行");
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

        System.out.println("处理请求后执行");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object object) throws Exception {

        String currentRequestURI = request.getRequestURI();

        currentRequestURI = currentRequestURI.substring(currentRequestURI.lastIndexOf("/")+1, currentRequestURI.length());

        if(currentRequestURI.equals("login")){//如果当前请求是登录请求，则把用户登录信息放进session

            if(request.getParameter("userName").equals("lin")){//判断用户登录信息是否正确
                HttpSession session = request.getSession();
                session.setAttribute("userName", request.getParameter("userName"));

                return true;
            }
            else{
                request.getRequestDispatcher("/login.jsp").forward(request, response);//回到登录页面，并且提示用户登录信息错误
                return false;
            }
        }

        if(allow != null && allow.length != 0){//如果当前请求不是登录，则看该请求是否需要被拦截
            for(String allowURI : allow){

                if(allowURI.equals(currentRequestURI)){

                    return true;//如果不需要拦截，则让请求通过，继续处理请求
                }
            }
        }

        HttpSession session = request.getSession();

        if(session.getAttribute("userName") == null){//判断用户是否已经登录，如果没有登录，跳转到登录页面

            response.sendRedirect("http://localhost:8080/SpringMVC_HelloWorld/login.jsp");
            return false;
        }
        else {
            return true;
        }
    }
}
