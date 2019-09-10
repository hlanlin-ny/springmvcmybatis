package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.MedicalNcmsToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalStudentToCityTransfer;
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
@RequestMapping("/admin/studentinfotocity")
public class MedicalStudentInfoToCityTransferController extends BaseCRUDController<MedicalStudentToCityTransfer>{

    @RequestMapping(value = "/studentinfotocity.html", method = RequestMethod.GET)
    public String studentinfotocity() {
        return "admin/studentinfotocity/studentinfotocity";
    }
}
