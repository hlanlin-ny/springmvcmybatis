package com.yaofei.springmvcmybatis.webapp.taglibs.myshiro;

import org.apache.shiro.SecurityUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class HasAllPermissionsTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    private String permissions;

    @Override
    public int doStartTag() throws JspException {
        String[] permissionArray = permissions.split(",");
        if(!SecurityUtils.getSubject().isPermittedAll(permissionArray)) {
            return TagSupport.SKIP_BODY;
        }else {
            return TagSupport.EVAL_BODY_INCLUDE;
        }
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
