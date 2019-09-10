package com.yaofei.springmvcmybatis.webapp.taglibs.myshiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HasAnyRoleTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    private String roles;

    @Override
    public int doStartTag() throws JspException {
        String[] roleArray = roles.split(",");

        Subject subject = SecurityUtils.getSubject();
        for (String role : roleArray) {
            if (subject.hasRole(role)) {
                return TagSupport.EVAL_BODY_INCLUDE;
            }
        }
        return TagSupport.SKIP_BODY;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
