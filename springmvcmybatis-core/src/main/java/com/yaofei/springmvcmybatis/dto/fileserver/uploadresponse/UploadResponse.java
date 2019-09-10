package com.yaofei.springmvcmybatis.dto.fileserver.uploadresponse;

import java.util.List;

/**
 * Created by phoenix on 2017/6/9.
 */
public class UploadResponse {
    private int code;
    private String message;
    private List<Result> result;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
    public List<Result> getResult() {
        return result;
    }
}
