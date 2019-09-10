package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.MedicalStudentToCityTransfer;
import com.yaofei.springmvcmybatis.service.MedicalStudentToCityTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 学生信息登记上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-06 16:18:01
 */
@Controller
@RequestMapping("/admin/medicalstudenttocitytransfer")
public class MedicalStudentToCityTransferController extends BaseCRUDController<MedicalStudentToCityTransfer> {
	@Autowired
	private MedicalStudentToCityTransferService medicalStudentToCityTransferService;

}