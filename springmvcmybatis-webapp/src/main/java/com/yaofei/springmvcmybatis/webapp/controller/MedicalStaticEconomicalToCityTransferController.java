package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.EconomicalInfoToCityTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: springmvcmybatis
 * @description: 电动车信息查询
 * @author: Mr.Wang
 * @create: 2019-02-28 16:27
 **/
@Controller
@RequestMapping("/admin/medicalStaticEconomicalToCityTransfer")
public class MedicalStaticEconomicalToCityTransferController extends BaseCRUDController<EconomicalInfoToCityTransfer>{

    @RequestMapping(value = "/medicalStaticEconomicalToCityTransfer.html", method = RequestMethod.GET)
    public String medicalStaticEconomicalToCityTransfer() {
        return "admin/medicalstaticeconomicaltocitytransfer/medicalStaticEconomicalToCityTransfer";
    }
}
