package com.yaofei.springmvcmybatis.webapp.controller;

import com.google.common.collect.Maps;
import com.yaofei.springmvcmybatis.service.impl.PermissionService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminIndexController {

    protected PermissionService permissionService = null;

    /**
     * key:    权限
     * value : 资源
     */
    private Map<String, String> resourcePermissions = Maps.newHashMap();

    @GetMapping("/")
    public String redirectToIndex() {
        return "redirect:/admin/index/index.html";
    }

    /**
     * 首页
     */
    @RequestMapping(value = "/admin/index/index.html", method = RequestMethod.GET)
    public String index() {
        return "admin/index/index";
    }

    /**
     * 管理员模块页面
     */
    @RequestMapping(value = "/admin/index/adminmodule.html", method = RequestMethod.GET)
    public String adminmodule() {
        return "admin/index/adminmodule";
    }

    /**
     * 情报数据页面
     */
    @RequestMapping(value = "/admin/index/intelligencedata.html", method = RequestMethod.GET)
    public String intelligencedata() {
        return "admin/index/intelligencedata";
    }

    /**
     * 系统设置页面
     */
    @RequestMapping(value = "/admin/index/sysconfig.html", method = RequestMethod.GET)
    public String sysconfig() {
        return "admin/index/sysconfig";
    }

    /**
     * 系统设置页面
     */
    @RequestMapping(value = "/admin/index/searchwarning.html", method = RequestMethod.GET)
    public String searchwarning() {
        return "admin/index/searchwarning";
    }



    @RequestMapping(value = "admin/index/detail.html")
    public String detailPage(){
        return "admin/index/details";
    }

    /**
     * test
     */
    @RequestMapping(value = "/admin/index/main.html", method = RequestMethod.GET)
    public String test() {
        return "admin/index/main";
    }


    //教研权限
    @ResponseBody
    @RequestMapping(value = "/admin/index/verification",method = RequestMethod.POST)
    public JsonResult verification(HttpServletRequest request){

        String adminPer = "adminmodule:list";
        String intellPer = "intelligencedata:list";
        String sysconfigPer = "systconfig:list";
        String searchplatPer = "searchplat:list";
        String searchwarning = "searchwarningtime:list";
        int admin = verPermissions(adminPer);
        int intell = verPermissions(intellPer);
        int sysconfig = verPermissions(sysconfigPer);
        int search = verPermissions(searchplatPer);
        int searchw = verPermissions(searchwarning);
        Map<String,Integer> url = new HashMap<>();
        url.put("admin",admin);
        url.put("intell",intell);
        url.put("sysconfig",sysconfig);
        url.put("search",search);
        url.put("searchw",searchw);
;       return JsonResult.ok().addResult(url);
    }



    public int verPermissions(String permission){
        String resourcePermission = resourcePermissions.get(permission);
        if (resourcePermission == null) {
            resourcePermission = permission;
        }
        if (!SecurityUtils.getSubject().isPermitted(resourcePermission)) {
                   return 0;
        }
        return 1;
    }
}
