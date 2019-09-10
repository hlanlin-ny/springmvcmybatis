package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.MedicalStaticPeopleToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticHealthyToCityTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: springmvcmybatis
 * @description: 信访人员查询
 * @author: Mr.Wang
 * @create: 2019-02-28 11:14
 **/
@Controller
@RequestMapping("/admin/statichealthytocity")
public class MedicalHealthyToCityTransferController extends BaseCRUDController<StaticHealthyToCityTransfer>{
    /**
     * 情报数据页面
     */
    @RequestMapping(value = "/statichealthytocity.html", method = RequestMethod.GET)
    public String statichealthyToCity() {
        return "admin/statichealthytocity/statichealthytocity";
    }
}
