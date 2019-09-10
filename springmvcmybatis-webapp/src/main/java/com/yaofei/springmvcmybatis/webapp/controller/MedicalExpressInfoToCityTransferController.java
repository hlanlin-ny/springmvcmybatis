package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.ExpressInfoToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalStaticWaterToCityTransfer;
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
@RequestMapping("/admin/expressinfotocity")
public class MedicalExpressInfoToCityTransferController extends BaseCRUDController<ExpressInfoToCityTransfer>{
    /**
     * 情报数据页面
     */
    @RequestMapping(value = "/expressinfotocity.html", method = RequestMethod.GET)
    public String expressinfotocity() {
        return "admin/expressinfotocity/expressinfotocity";
    }
}
