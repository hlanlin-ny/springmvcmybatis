package com.yaofei.springmvcmybatis.shiro.authc;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Created by f_yao on 2017/1/22.
 */
public class IncorrectCaptchaException extends AuthenticationException {

    public IncorrectCaptchaException() {
        super();
    }

    public IncorrectCaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectCaptchaException(String message) {
        super(message);
    }

    public IncorrectCaptchaException(Throwable cause) {
        super(cause);
    }
}