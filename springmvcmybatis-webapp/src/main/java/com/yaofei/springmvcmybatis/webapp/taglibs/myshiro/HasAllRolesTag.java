package com.yaofei.springmvcmybatis.webapp.taglibs.myshiro;

import org.apache.shiro.SecurityUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Arrays;


public class HasAllRolesTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    private String roles;

    @Override
    public int doStartTag() throws JspException {
        String[] roleArray = roles.split(",");
        if(!SecurityUtils.getSubject().hasAllRoles(Arrays.asList(roleArray))) {
            return TagSupport.SKIP_BODY;
        }else {
            return TagSupport.EVAL_BODY_INCLUDE;
        }
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
