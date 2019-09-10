package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.MedicalInsuranceCardRecord;
import com.yaofei.springmvcmybatis.entity.MedicalNewbornRecord;
import com.yaofei.springmvcmybatis.entity.UpdatingFileClass;
import com.yaofei.springmvcmybatis.plugins.datatables.DataTablesUtils;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.service.MedicalCheckinCheckoutRecordService;
import com.yaofei.springmvcmybatis.service.MedicalInsuranceCardRecordService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 医保刷卡记录信息ZQH-22-143600002
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-16 11:40:38
 */
@Controller
@RequestMapping("/admin/medicalinsurancecardrecord")
public class MedicalInsuranceCardRecordController extends BaseCRUDController<MedicalInsuranceCardRecord>  {
	@Autowired
	private MedicalInsuranceCardRecordService medicalInsuranceCardRecordService;
	@Autowired
	private MedicalCheckinCheckoutRecordService medicalCheckinCheckoutRecordService;

	@Override
	protected void queryListBefore(HttpServletRequest request, HttpServletResponse response, DataTablesRequest dataTablesRequest) {
		Long areaId = super.getAreaId();
		dataTablesRequest.getExtraSearch().put("areaId", String.valueOf(areaId));
	}


	@ResponseBody
	@RequestMapping(value = "/updatetocommon", method = RequestMethod.POST)
	public JsonResult updatetocommon(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DataTablesRequest dataTablesRequest = DataTablesUtils.getDataTableRequest(request);
		List<MedicalInsuranceCardRecord> list = medicalInsuranceCardRecordService.queryListAll();
		UpdatingFileClass updatingFileClass = new UpdatingFileClass();
		for(int i=0;i<list.size();i++){
			updatingFileClass.setId(list.get(i).getId());
			updatingFileClass.setBusinessTypeId(list.get(i).getBusinessTypeId());
			updatingFileClass.setName("");
			updatingFileClass.setSex("");
			updatingFileClass.setIdCardNo("");
			updatingFileClass.setAddress("");
			updatingFileClass.setDwmc("");
			updatingFileClass.setDetailsUrl(list.get(i).getDetailsUrl());
			updatingFileClass.setCollectTime(list.get(i).getCollectTime());
			updatingFileClass.setEsIndexName(list.get(i).getEsIndexName());
			updatingFileClass.setDetail(list.get(i).toString());
			updatingFileClass.setCreatedTime(list.get(i).getCreatedTime());
			updatingFileClass.setCreatedBy(list.get(i).getCreatedBy());
			updatingFileClass.setCreatedIp(list.get(i).getCreatedIp());
			updatingFileClass.setModificationTime(list.get(i).getModificationTime());
			updatingFileClass.setModificationBy(list.get(i).getModificationBy());
			updatingFileClass.setModificationIp(list.get(i).getModificationIp());
			updatingFileClass.setAreaId(list.get(i).getAreaId());
			medicalCheckinCheckoutRecordService.insertCommon(updatingFileClass);
		}
		return JsonResult.ok();
	}
}