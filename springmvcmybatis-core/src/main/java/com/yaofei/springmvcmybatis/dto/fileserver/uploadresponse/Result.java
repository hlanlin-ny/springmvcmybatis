package com.yaofei.springmvcmybatis.dto.fileserver.uploadresponse;

/**
 * Created by phoenix on 2017/6/9.
 */
public class Result {
    private String originalFilename;
    private String newFileName;
    private String webAccessUrl;
    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }
    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }
    public String getNewFileName() {
        return newFileName;
    }

    public void setWebAccessUrl(String webAccessUrl) {
        this.webAccessUrl = webAccessUrl;
    }
    public String getWebAccessUrl() {
        return webAccessUrl;
    }
}
