package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalCheckinCheckoutRecord;
import com.yaofei.springmvcmybatis.entity.MedicalOutpatientRecord;
import com.yaofei.springmvcmybatis.entity.UpdatingFileClass;
import com.yaofei.springmvcmybatis.repository.MedicalCheckinCheckoutRecordRepository;
import com.yaofei.springmvcmybatis.repository.MedicalOutpatientRecordRepository;
import com.yaofei.springmvcmybatis.service.MedicalOutpatientRecordService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service("medicalOutpatientRecordService")
public class MedicalOutpatientRecordServiceImpl extends AbstractBaseService<MedicalOutpatientRecord> implements MedicalOutpatientRecordService {
	@Autowired
	private MedicalOutpatientRecordRepository medicalOutpatientRecordRepository;@Autowired
	private MedicalCheckinCheckoutRecordRepository medicalCheckinCheckoutRecordRepository;

	@Override
	public HSSFWorkbook exportExcelInfo() {
		//根据条件查询数据，把数据装载到一个list中
		List<MedicalOutpatientRecord> medicalOutpatientRecords = medicalOutpatientRecordRepository.queryBatch();
		//创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		//建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("医疗门诊记录");
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
		row1.createCell(4).setCellValue("体检时间");
		row1.createCell(5).setCellValue("门诊号");
		row1.createCell(6).setCellValue("科室名称");
		row1.createCell(7).setCellValue("人员费用类别");
		row1.createCell(8).setCellValue("医保证号");
		row1.createCell(9).setCellValue("医院诊断结果");
		row1.createCell(10).setCellValue("费用金额");
		row1.createCell(11).setCellValue("备注");
		//在sheet里循环插入数据
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		for (int i = 1; i < medicalOutpatientRecords.size() + 1; i++) {
			HSSFRow row = sheet.createRow(i);
			row.setRowStyle(cellStyle);
			MedicalOutpatientRecord medicalOutpatientRecord = medicalOutpatientRecords.get(i - 1);
			row.createCell(0).setCellValue(medicalOutpatientRecord.getName());
			row.createCell(1).setCellValue(medicalOutpatientRecord.getIdCardNum());
			row.createCell(2).setCellValue(medicalOutpatientRecord.getPhone());
			row.createCell(3).setCellValue(medicalOutpatientRecord.getAddress());
			row.createCell(4).setCellValue(sdf.format(medicalOutpatientRecord.getDiagnoseDatetime()));
			row.createCell(5).setCellValue(medicalOutpatientRecord.getDiagnoseNo());
			row.createCell(6).setCellValue(medicalOutpatientRecord.getDiagnoseDepartment());
			row.createCell(7).setCellValue(medicalOutpatientRecord.getCostType());
			row.createCell(8).setCellValue(medicalOutpatientRecord.getMedicareCardNo());
			row.createCell(9).setCellValue(medicalOutpatientRecord.getDiagnoseResult());
			row.createCell(10).setCellValue(medicalOutpatientRecord.getCost().toString());
			row.createCell(11).setCellValue(medicalOutpatientRecord.getRemark());
		}
		return wb;
	}

	@Override
	public List<MedicalOutpatientRecord> queryListAll(){
		return medicalOutpatientRecordRepository.queryListAll();

	}

	@Override
	public void insertCommon(UpdatingFileClass updatingFileClass){
		medicalCheckinCheckoutRecordRepository.insertCommon(updatingFileClass);
	}

}
