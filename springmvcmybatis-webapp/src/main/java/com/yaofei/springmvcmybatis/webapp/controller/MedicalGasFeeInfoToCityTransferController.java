package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.GasFeeInfoToCityTransfer;
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
@RequestMapping("/admin/gasfeeinfotocity")
public class MedicalGasFeeInfoToCityTransferController extends BaseCRUDController<GasFeeInfoToCityTransfer>{
    /**
     * 情报数据页面
     */
    @RequestMapping(value = "/gasfeeinfotocity.html", method = RequestMethod.GET)
    public String gasfeeinfotocity() {
        return "admin/gasfeeinfotocity/gasfeeinfotocity";
    }
}
