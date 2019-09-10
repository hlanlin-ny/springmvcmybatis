package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.MedicalStudentToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalTelevisionToCityTransfer;
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
@RequestMapping("/admin/televisoninfotocity")
public class MedicalTelevisonInfoToCityTransferController extends BaseCRUDController<MedicalTelevisionToCityTransfer>{

    @RequestMapping(value = "/televisoninfotocity.html", method = RequestMethod.GET)
    public String televisoninfotocity() {
        return "admin/televisoninfotocity/televisoninfotocity";
    }
}
