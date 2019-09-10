package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.VipInfoToCityTransfer;
import com.yaofei.springmvcmybatis.entity.VisitorInfoToCityTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: springmvcmybatis
 * @description: 新农合人员信息查询
 * @author: Mr.Wang
 * @create: 2019-02-28 14:45
 **/
@Controller
@RequestMapping("/admin/visitorinfotocity")
public class MedicalVisitorInfoToCityTransferController extends BaseCRUDController<VisitorInfoToCityTransfer>{

    @RequestMapping(value = "/visitorinfotocity.html", method = RequestMethod.GET)
    public String visitorinfotocity() {
        return "admin/visitorinfotocity/visitorinfotocity";
    }
}
