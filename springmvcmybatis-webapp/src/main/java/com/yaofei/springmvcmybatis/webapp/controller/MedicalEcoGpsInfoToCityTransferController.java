package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.EcoGpsInfoToCityTransfer;
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
@RequestMapping("/admin/ecogpsinfotocity")
public class MedicalEcoGpsInfoToCityTransferController extends BaseCRUDController<EcoGpsInfoToCityTransfer>{
    /**
     * 情报数据页面
     */
    @RequestMapping(value = "/ecogpsinfotocity.html", method = RequestMethod.GET)
    public String ecogpsinfotocity() {
        return "admin/ecogpsinfotocity/ecogpsinfotocity";
    }
}
