package com.yaofei.springmvcmybatis.webapp.taglibs.myshiro;

import com.yaofei.springmvcmybatis.shiro.domain.ShiroUser;
import org.apache.shiro.SecurityUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrentIdTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
    public int doEndTag() throws JspException {
        String mame = ((ShiroUser) SecurityUtils.getSubject().getPrincipal()).getId().toString();
        try {
            pageContext.getOut().print(mame);
        } catch (IOException ex) {
            Logger.getLogger(CurrentIdTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TagSupport.EVAL_PAGE;
    }
}
