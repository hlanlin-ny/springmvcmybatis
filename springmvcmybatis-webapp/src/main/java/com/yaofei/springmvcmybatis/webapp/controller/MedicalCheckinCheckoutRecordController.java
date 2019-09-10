package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.EcoGpsInfoToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalCheckinCheckoutRecord;
import com.yaofei.springmvcmybatis.entity.StaticFileClass;
import com.yaofei.springmvcmybatis.entity.UpdatingFileClass;
import com.yaofei.springmvcmybatis.plugins.datatables.DataTablesUtils;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.service.MedicalCheckinCheckoutRecordService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 医疗住（出）院信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:39:28
 */
@Controller
@RequestMapping("/admin/medicalcheckincheckoutrecord")
public class MedicalCheckinCheckoutRecordController extends BaseCRUDController<MedicalCheckinCheckoutRecord>  {
	@Autowired
	private MedicalCheckinCheckoutRecordService medicalCheckinCheckoutRecordService;

	@RequestMapping(value="/batch/export", method = RequestMethod.POST)
	public String export(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException, UnsupportedEncodingException {
		String fileName = "医疗住(出)院记录";
		final String userAgent = request.getHeader("USER-AGENT");
		String finalFileName;
		if(StringUtils.contains(userAgent, "MSIE")){//IE浏览器
			finalFileName = URLEncoder.encode(fileName, "UTF8");
		}else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
			finalFileName = new String(fileName.getBytes(), "ISO8859-1");
		}else{
			finalFileName = URLEncoder.encode(fileName,"UTF8");//其他浏览器
		}
		if(finalFileName!=""){
			response.reset(); //清除buffer缓存
			// 指定下载的文件名
			response.setHeader("Content-Disposition", "attachment;filename="+finalFileName+".xls");
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			HSSFWorkbook workbook=null;
			//导出Excel对象
			workbook = medicalCheckinCheckoutRecordService.exportExcelInfo();
			OutputStream output;
			try {
				output = response.getOutputStream();
				BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
				bufferedOutPut.flush();
				workbook.write(bufferedOutPut);
				bufferedOutPut.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	protected void queryListBefore(HttpServletRequest request, HttpServletResponse response, DataTablesRequest dataTablesRequest) {
		Long areaId = super.getAreaId();
		dataTablesRequest.getExtraSearch().put("areaId", String.valueOf(areaId));
	}

	@ResponseBody
	@RequestMapping(value = "/updatetocommon", method = RequestMethod.POST)
	public JsonResult updatetocommon(HttpServletRequest request, HttpServletResponse response) throws Exception {
			DataTablesRequest dataTablesRequest = DataTablesUtils.getDataTableRequest(request);
			List<MedicalCheckinCheckoutRecord> list = medicalCheckinCheckoutRecordService.queryListAll();
			UpdatingFileClass updatingFileClass = new UpdatingFileClass();
			for(int i=0;i<list.size();i++){
				updatingFileClass.setId(list.get(i).getId());
				updatingFileClass.setBusinessTypeId(list.get(i).getBusinessTypeId());
				updatingFileClass.setName(list.get(i).getName());
				updatingFileClass.setSex(list.get(i).getSex());
				updatingFileClass.setIdCardNo(list.get(i).getIdCardNum());
				updatingFileClass.setAddress(list.get(i).getAddress());
				updatingFileClass.setDwmc(list.get(i).getOrganization());
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