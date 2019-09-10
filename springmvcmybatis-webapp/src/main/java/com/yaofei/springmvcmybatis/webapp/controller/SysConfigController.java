package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.SysConfig;
import com.yaofei.springmvcmybatis.service.SysConfigService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统配置信息表
 */
@Controller
@RequestMapping("/admin/sysconfig")
public class SysConfigController extends BaseCRUDController<SysConfig> {
    @Autowired
    private SysConfigService sysConfigService;


    @ResponseBody
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public JsonResult uploadImage(@RequestParam(value="bgImageFile") MultipartFile bgImageFile,HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        String url = sysConfigService.uploadImage(bgImageFile, request, response);
        return JsonResult.ok().addResult(url);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadWarningMusic", method = RequestMethod.POST)
    public JsonResult uploadWarningMusic(@RequestParam("musicFile")MultipartFile musicFile,HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        String url = sysConfigService.uploadWarningMusic(musicFile, request, response);
        return JsonResult.ok().addResult(url);
    }

    @ResponseBody
    @RequestMapping(value = "/uploadBgMusic", method = RequestMethod.POST)
    public JsonResult uploadBgMusic(@RequestParam("bgMusicFile") MultipartFile bgMusicFile,HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        String url = sysConfigService.uploadBgMusic(bgMusicFile, request, response);
        return JsonResult.ok().addResult(url);
    }
}