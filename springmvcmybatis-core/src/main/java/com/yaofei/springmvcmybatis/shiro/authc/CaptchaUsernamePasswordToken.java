package com.yaofei.springmvcmybatis.shiro.authc;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by f_yao on 2017/1/22.
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {
    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public CaptchaUsernamePasswordToken(String username, char[] password, boolean rememberMe, String host, String captcha) {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
    }
}