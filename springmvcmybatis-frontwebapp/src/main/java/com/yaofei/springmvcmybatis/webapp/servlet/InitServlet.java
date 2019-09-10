package com.yaofei.springmvcmybatis.webapp.servlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static WebApplicationContext wc;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // 初始化spring的工厂
        wc = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());


//		private static Properties p = new Properties();
//		InputStream in = null;
//		in = SalConstant.class.getClassLoader().getResourceAsStream("basicAuth.properties");
//		if(in == null){
//			throw new IOException("load basicAuth.properties error");
//		}
//		p.load(in);

        System.out
                .println("------------------------ System Init Sucess -----------------------------");
    }

    public static WebApplicationContext getWc() {
        return wc;
    }
}