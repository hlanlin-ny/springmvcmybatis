package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.MedicalInsuranceToCityTransfer;
import com.yaofei.springmvcmybatis.service.StaticInsuranceToCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 学生信息登记上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-06 16:18:01
 */
@Controller
@RequestMapping("/admin/insurancetocity")
public class MedicalInsuranceToCityTransferController extends BaseCRUDController<MedicalInsuranceToCityTransfer> {
	@Autowired
	private StaticInsuranceToCityService staticInsuranceToCityService;


	/**
	 * 情报数据页面
	 */
	@RequestMapping(value = "/insuranceCityData.html", method = RequestMethod.GET)
	public String insurancetocity() {
		return "admin/insurancetocity/insuranceCityData";
	}

}