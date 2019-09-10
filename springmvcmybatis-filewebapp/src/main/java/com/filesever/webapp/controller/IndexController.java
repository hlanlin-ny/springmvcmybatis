package com.filesever.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @GetMapping("/")
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectToIndex() {
        return "redirect:/index.html";
    }

    /**
     * 首页
     */
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
