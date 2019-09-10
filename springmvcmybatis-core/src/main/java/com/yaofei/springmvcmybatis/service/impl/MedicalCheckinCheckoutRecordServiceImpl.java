package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalCheckinCheckoutRecord;
import com.yaofei.springmvcmybatis.entity.UpdatingFileClass;
import com.yaofei.springmvcmybatis.repository.MedicalCheckinCheckoutRecordRepository;
import com.yaofei.springmvcmybatis.service.MedicalCheckinCheckoutRecordService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service("medicalCheckinCheckoutRecordService")
public class MedicalCheckinCheckoutRecordServiceImpl extends AbstractBaseService<MedicalCheckinCheckoutRecord> implements MedicalCheckinCheckoutRecordService {
	@Autowired
	private MedicalCheckinCheckoutRecordRepository medicalCheckinCheckoutRecordRepository;

	@Override
	public HSSFWorkbook exportExcelInfo() {
		//根据条件查询数据，把数据装载到一个list中
		List<MedicalCheckinCheckoutRecord> medicalCheckinCheckoutRecords = medicalCheckinCheckoutRecordRepository.queryBatch();
		//创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		//建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("医疗住(出)院记录");
		sheet.setDefaultRowHeightInPoints(20);//设置缺省列高
		sheet.setDefaultColumnWidth(20);//设置缺省列宽
		HSSFCellStyle cellStyle = wb.createCellStyle();/*
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 设置居中*/
		//设置日期型数据的显示样式
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		//设置指定列的列宽，256 * 50这种写法是因为width参数单位是单个字符的256分之一
		sheet.setColumnWidth(cell.getColumnIndex(), 256 * 50);
		cell.setCellStyle(cellStyle);
		//创建单元格并设置单元格内容
		row1.createCell(0).setCellValue("姓名");
		row1.createCell(1).setCellValue("身份证号码");
		row1.createCell(2).setCellValue("联系电话");
		row1.createCell(3).setCellValue("家庭住址");
		row1.createCell(4).setCellValue("职业");
		row1.createCell(5).setCellValue("工作单位");
		row1.createCell(6).setCellValue("住院号");
		row1.createCell(7).setCellValue("住院科室");
		row1.createCell(8).setCellValue("住院时间");
		row1.createCell(9).setCellValue("出院时间");
		row1.createCell(10).setCellValue("备注");
		//在sheet里循环插入数据
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		for (int i = 1; i < medicalCheckinCheckoutRecords.size() + 1; i++) {
			HSSFRow row = sheet.createRow(i);
			row.setRowStyle(cellStyle);
			MedicalCheckinCheckoutRecord medicalCheckinCheckoutRecord = medicalCheckinCheckoutRecords.get(i - 1);
			row.createCell(0).setCellValue(medicalCheckinCheckoutRecord.getName());
			row.createCell(1).setCellValue(medicalCheckinCheckoutRecord.getIdCardNum());
			row.createCell(2).setCellValue(medicalCheckinCheckoutRecord.getPhone());
			row.createCell(3).setCellValue(medicalCheckinCheckoutRecord.getAddress());
			row.createCell(4).setCellValue(medicalCheckinCheckoutRecord.getProfession());
			row.createCell(5).setCellValue(medicalCheckinCheckoutRecord.getOrganization());
			row.createCell(6).setCellValue(medicalCheckinCheckoutRecord.getHospitalizationNo());
			row.createCell(7).setCellValue(medicalCheckinCheckoutRecord.getHospitalizationDepartment());
			row.createCell(8).setCellValue(sdf.format(medicalCheckinCheckoutRecord.getHospitalizationDatetime()));
			row.createCell(9).setCellValue(sdf.format(medicalCheckinCheckoutRecord.getLeavehospitalDatetime()));
			row.createCell(10).setCellValue(medicalCheckinCheckoutRecord.getRemark());
		}
		return wb;
	}

	@Override
	public List<MedicalCheckinCheckoutRecord> queryListAll(){
		return medicalCheckinCheckoutRecordRepository.queryListAll();

	}

	@Override
	public void insertCommon(UpdatingFileClass updatingFileClass){
		medicalCheckinCheckoutRecordRepository.insertCommon(updatingFileClass);
	}
}
