package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.CarInfoTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: springmvcmybatis
 * @description: 停车场数据查询
 * @author: Mr.Wang
 * @create: 2019-02-28 15:42
 **/
@Controller
@RequestMapping("/admin/medicalParkingToCityTransfer")
public class MedicalParkingToCityTransferController extends BaseCRUDController<CarInfoTransfer>{
    @RequestMapping(value = "/medicalParkingToCityTransfer.html", method = RequestMethod.GET)
    public String medicalLettersCallsToCity() {
        return "admin/medicalparkingtocitytransfer/medicalParkingToCityTransfer";
    }
}
