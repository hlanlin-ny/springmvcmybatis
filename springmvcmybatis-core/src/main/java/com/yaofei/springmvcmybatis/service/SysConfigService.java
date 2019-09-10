package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.SysConfig;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统配置信息表
 */
public interface SysConfigService extends BaseService<SysConfig> {

    public String uploadImage(MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws Exception;

    public String uploadWarningMusic(MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws Exception;

    public String uploadBgMusic(MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws Exception;

}
