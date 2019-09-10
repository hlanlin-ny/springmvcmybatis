package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.MedicalAccumulationFundToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalNcmsToCityTransfer;
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
@RequestMapping("/admin/accumulationfundtocity")
public class MedicalAccumulationFundToCityTransferController extends BaseCRUDController<MedicalAccumulationFundToCityTransfer>{

    @RequestMapping(value = "/accumulationfundtocity.html", method = RequestMethod.GET)
    public String accumulationfundtocity() {
        return "admin/accumulationfundtocity/accumulationfundtocity";
    }
}
