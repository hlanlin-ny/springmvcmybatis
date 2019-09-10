package com.yaofei.springmvcmybatis.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminIndexController {

    @GetMapping("/")
    //@RequestMapping(value = "/", method = RequestMethod.GET)
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
     * test
     */
    @RequestMapping(value = "/admin/index/main.html", method = RequestMethod.GET)
    public String test() {
        return "admin/index/main";
    }
}
