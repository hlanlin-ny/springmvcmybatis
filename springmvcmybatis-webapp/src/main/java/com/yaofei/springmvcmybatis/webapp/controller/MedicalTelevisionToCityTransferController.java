package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.MedicalTelevisionToCityTransfer;
import com.yaofei.springmvcmybatis.service.MedicalTelevisionToCityTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 有线电视用户登记信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-07 07:47:48
 */
@Controller
@RequestMapping("/admin/medicaltelevisiontocitytransfer")
public class MedicalTelevisionToCityTransferController extends BaseCRUDController<MedicalTelevisionToCityTransfer> {
	@Autowired
	private MedicalTelevisionToCityTransferService medicalTelevisionToCityTransferService;

}