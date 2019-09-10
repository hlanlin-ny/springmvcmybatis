package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.MedicalExaminationRecord;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.service.MedicalExaminationRecordService;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 医疗体检信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:40:13
 */
@Controller
@RequestMapping("/admin/medicalexaminationrecord")
public class MedicalExaminationRecordController extends BaseCRUDController<MedicalExaminationRecord>  {
	@Autowired
	private MedicalExaminationRecordService medicalExaminationRecordService;

	@RequestMapping(value="/batch/export", method = RequestMethod.POST)
	public String export(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException, UnsupportedEncodingException {
		String fileName = "医疗体检记录";
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
			workbook = medicalExaminationRecordService.exportExcelInfo();
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
}