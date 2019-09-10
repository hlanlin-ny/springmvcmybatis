package com.filesever.webapp.dto;

/**
 * Created by phoenix on 2017/6/9.
 */
public class UploadFileInfo {
    private String originalFilename;
    private String newFileName;
    private String webAccessUrl;

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getWebAccessUrl() {
        return webAccessUrl;
    }

    public void setWebAccessUrl(String webAccessUrl) {
        this.webAccessUrl = webAccessUrl;
    }

    @Override
    public String toString() {
        return "UploadFileInfo{" +
                "originalFilename='" + originalFilename + '\'' +
                ", newFileName='" + newFileName + '\'' +
                ", webAccessUrl='" + webAccessUrl + '\'' +
                '}';
    }
}
