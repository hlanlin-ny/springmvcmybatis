package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalExaminationRecord;
import com.yaofei.springmvcmybatis.repository.MedicalExaminationRecordRepository;
import com.yaofei.springmvcmybatis.service.MedicalExaminationRecordService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service("medicalExaminationRecordService")
public class MedicalExaminationRecordServiceImpl extends AbstractBaseService<MedicalExaminationRecord> implements MedicalExaminationRecordService {
	@Autowired
	private MedicalExaminationRecordRepository medicalExaminationRecordRepository;


	@Override
	public HSSFWorkbook exportExcelInfo() {
		//根据条件查询数据，把数据装载到一个list中
		List<MedicalExaminationRecord> medicalExaminationRecords = medicalExaminationRecordRepository.queryBatch();
		//创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		//建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("医疗体检记录");
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
		row1.createCell(6).setCellValue("体检项目");
		row1.createCell(7).setCellValue("体检时间");
		row1.createCell(8).setCellValue("备注");
		//在sheet里循环插入数据
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		for (int i = 1; i < medicalExaminationRecords.size() + 1; i++) {
			HSSFRow row = sheet.createRow(i);
			row.setRowStyle(cellStyle);
			MedicalExaminationRecord medicalExaminationRecord = medicalExaminationRecords.get(i - 1);
			row.createCell(0).setCellValue(medicalExaminationRecord.getName());
			row.createCell(1).setCellValue(medicalExaminationRecord.getIdCardNum());
			row.createCell(2).setCellValue(medicalExaminationRecord.getPhone());
			row.createCell(3).setCellValue(medicalExaminationRecord.getAddress());
			row.createCell(4).setCellValue(medicalExaminationRecord.getProfession());
			row.createCell(5).setCellValue(medicalExaminationRecord.getOrganization());
			row.createCell(6).setCellValue(medicalExaminationRecord.getExaminationTerm());
			row.createCell(7).setCellValue(sdf.format(medicalExaminationRecord.getExaminationDateime()));
			row.createCell(8).setCellValue(medicalExaminationRecord.getRemark());
		}
		return wb;
	}
}
