package com.yaofei.springmvcmybatis.exception;

/**
 * Created by f_yao on 2017/2/18.
 */
public class BussinessException extends BaseException {

    public BussinessException(String defaultMessage) {
        super(defaultMessage);
    }

    public BussinessException(String defaultMessage, String exceptionMessage) {
        this(defaultMessage + "     异常信息：" + exceptionMessage);
    }
}
