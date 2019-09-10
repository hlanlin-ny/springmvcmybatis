package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.service.SysUserService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import com.yaofei.springmvcmybatis.webapp.plugins.csrf.CsrfToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by f_yao on 2017/2/18.
 */
@Controller
@RequestMapping(value = "/admin/login")
public class AdminLoginController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    @CsrfToken(create = true)
    public String login() {
        return "admin/login/login";
    }

    @ResponseBody
    @CsrfToken(remove = true)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(String username, String password, String captcha, String rememberMe) {

        //Session session = SecurityUtils.getSubject().getSession();
        //String kaptcha =  session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
        //session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        //if (!captcha.equalsIgnoreCase(kaptcha)) {
        //    return JsonResult.error("验证码不正确");
        //}

        //代表当前的用户
        Subject subject = SecurityUtils.getSubject();
        //获取基于用户名和密码的令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        if (rememberMe != null && "1".equals(rememberMe))
            // “已记住”和“已认证”是有区别的。可以在 spring-shiro.xml 进行配置  /** = user   /**=authc
            token.setRememberMe(true);
        try {
            // 回调reaml里的 doGetAuthenticationInfo 方法，进行认证
            subject.login(token);
        } catch (ExcessiveAttemptsException e) {
            return JsonResult.error(e.getMessage());
        } catch (LockedAccountException e) {
            return JsonResult.error(e.getMessage());
        } catch (DisabledAccountException e) {
            return JsonResult.error(e.getMessage());
        } catch (UnknownAccountException e) {
            return JsonResult.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return JsonResult.error("账户验证失败");
        } catch (AuthenticationException e) {
            return JsonResult.error("账户验证失败");
        }
        return JsonResult.ok();
    }

    /**
     * 退出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        SecurityUtils.getSubject().logout();
        //return "redirect:admin/login/login";
        return "redirect:login.html";
    }

    /**
     * 未授权
     */
    @RequestMapping(value = "/unauthorized.html", method = RequestMethod.GET)
    public String unauthorized() {
        if (SecurityUtils.getSubject().isAuthenticated() == false) {
            return "redirect:admin/login/login";
        }
        return "admin/login/unauthorized";
    }
}
