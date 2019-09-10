package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.CarInfoTransfer;
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
@RequestMapping("/admin/parkinginfotocity")
public class MedicalParkingInfoToCityTransferController extends BaseCRUDController<CarInfoTransfer>{

    @RequestMapping(value = "/parkinginfotocity.html", method = RequestMethod.GET)
    public String parkinginfotocity() {
        return "admin/parkinginfotocity/parkinginfotocity";
    }
}
