package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.ImportantPerson;
import com.yaofei.springmvcmybatis.entity.ScheduleJob;
import com.yaofei.springmvcmybatis.repository.ImportantPersonRepository;
import com.yaofei.springmvcmybatis.service.ImportantPersonService;
import com.yaofei.springmvcmybatis.service.ScheduleJobService;
import com.yaofei.springmvcmybatis.utils.ReadExcel;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

@Service("importantPersonService")
public class ImportantPersonServiceImpl extends AbstractBaseService<ImportantPerson> implements ImportantPersonService {
    @Autowired
    private ImportantPersonRepository importantPersonRepository;
    @Autowired
    private ScheduleJobService scheduleJobService;


    @Override
    public void reply(Long id) throws IOException {
        scheduleJobService.relateDeleteImportant(id);
        ImportantPerson importantPerson =  importantPersonRepository.queryObject(id);
        importantPerson.setStatus("未布控");
        importantPersonRepository.update(importantPerson);
    }

    @Override
    public void control(Long id,HttpServletRequest request,String userName,Long userId) {
        ImportantPerson importantPerson = importantPersonRepository.queryObject(id);
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setBeanName("importantPersonSearchJob");
        scheduleJob.setMethodName("query");
        scheduleJob.setParams(importantPerson.getName()+ ":" + importantPerson.getIdCardNo()+":"+importantPerson.getAreaId()+":"+userName+":"+userId+":"+importantPerson.getId());
        scheduleJob.setCronExpression("0 */3 * * * ?");
        scheduleJob.setStatus(0);
        scheduleJob.setRelateId(importantPerson.getId());
        scheduleJob.setScheduleType("重点人员布控");
        scheduleJobService.save(scheduleJob);
        importantPerson.setStatus("已布控");
        importantPersonRepository.update(importantPerson);
    }

    @Override
    public boolean batchImport(String name, MultipartFile file, String username, String ip,Long areaId) {
        //创建处理EXCEL
        ReadExcel readExcel = new ReadExcel();
        //解析excel，获取客户信息集合。
        List<ImportantPerson> importantPersons = readExcel.getExcelInfo(name, file, username, ip,areaId);
        Iterator<ImportantPerson> iterator = importantPersons.iterator();
        while (iterator.hasNext()) {
            ImportantPerson importantPerson = iterator.next();
            String idcard = importantPerson.getIdCardNo();
            importantPerson.setStatus("未布控");
            ImportantPerson IP = importantPersonRepository.queryPerson(idcard);
            if (IP != null) {
                iterator.remove();
            }
        }
        if (importantPersons.size() == 0) {
            return true;
        }
        importantPersonRepository.batchAdd(importantPersons);
        return true;
    }

    @Override
    public HSSFWorkbook exportExcelInfo() {
        //根据条件查询数据，把数据装载到一个list中
        List<ImportantPerson> importantPersonList = importantPersonRepository.queryBatch();
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("重点人员信息");
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
        row1.createCell(1).setCellValue("性别");
        row1.createCell(2).setCellValue("出生日期");
        row1.createCell(3).setCellValue("民族");
        row1.createCell(4).setCellValue("身份证号码");
        row1.createCell(5).setCellValue("地址");
        row1.createCell(6).setCellValue("人员类别");
        row1.createCell(7).setCellValue("布控人姓名");
        row1.createCell(8).setCellValue("布控人单位");
        row1.createCell(9).setCellValue("布控单位");
        row1.createCell(10).setCellValue("布控人联系方式");
        row1.createCell(11).setCellValue("备注");
        //在sheet里循环插入数据
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        for (int i = 1; i < importantPersonList.size() + 1; i++) {
            HSSFRow row = sheet.createRow(i);
            row.setRowStyle(cellStyle);
            ImportantPerson importantPerson = importantPersonList.get(i - 1);
            row.createCell(0).setCellValue(importantPerson.getName());
            row.createCell(1).setCellValue(importantPerson.getSex());
            row.createCell(2).setCellValue(sdf.format(importantPerson.getBornTime()));
            row.createCell(3).setCellValue(importantPerson.getNation());
            row.createCell(4).setCellValue(importantPerson.getIdCardNo());
            row.createCell(5).setCellValue(importantPerson.getAddress());
            row.createCell(6).setCellValue(importantPerson.getPersonType());
            row.createCell(7).setCellValue(importantPerson.getControlName());
            row.createCell(8).setCellValue(importantPerson.getControlPersonUnit());
            row.createCell(9).setCellValue(importantPerson.getControlUnit());
            row.createCell(10).setCellValue(importantPerson.getControlTel());
            row.createCell(11).setCellValue(importantPerson.getRemark());
        }
        return wb;
    }

    @Override
    public String queryTel(Long id) {
        String tel = importantPersonRepository.queryTel(id);
        return tel;
    }

    @Override
    public String queryIDcard(Long id) {
        String idcard = importantPersonRepository.queryIDcard(id);
        return idcard;
    }

    @Override
    public ImportantPerson queryPersonByIdcardno(String idcardno) {
        ImportantPerson importantPerson = importantPersonRepository.queryByCard(idcardno);
        return importantPerson;
    }

    @Override
    public ImportantPerson queryPersonByTel(String tel) {
        ImportantPerson importantPerson = importantPersonRepository.queryByTel(tel);
        return importantPerson;
    }


    @Override
    protected void deleteBatchBefore(Object[] ids) throws IOException {
        super.deleteBatchBefore(ids);
        scheduleJobService.relateDeleteImportantBatch(ids);
    }

    @Override
    protected void deleteBefore(Object id) throws IOException {
        super.deleteBefore(id);
        scheduleJobService.relateDeleteImportant(id);
    }
}
