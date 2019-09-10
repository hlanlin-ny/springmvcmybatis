package com.yaofei.springmvcmybatis.webapp.taglibs.myshiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class HasAnyPermissionTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    private String permissions;

    @Override
    public int doStartTag() throws JspException {
        String[] permissionArray = permissions.split(",");
        Subject subject = SecurityUtils.getSubject();
        for (String permission : permissionArray) {
            if (subject.isPermitted(permission)) {
                return TagSupport.EVAL_BODY_INCLUDE;
            }
        }
        return TagSupport.SKIP_BODY;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
