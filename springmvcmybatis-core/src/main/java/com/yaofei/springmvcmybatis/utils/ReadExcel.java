package com.yaofei.springmvcmybatis.utils;

import com.yaofei.springmvcmybatis.entity.ImportantPerson;
import com.yaofei.springmvcmybatis.entity.StaticFileClass;
import com.yaofei.springmvcmybatis.repository.ImportantPersonRepository;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.io.*;
import java.text.ParseException;
import java.util.*;

/**
 * Created by 87796 on 2017/9/14.
 */
public class ReadExcel {
    //总行数
    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private String errorMsg;

    //构造方法
    public ReadExcel() {
    }

    //获取总行数
    public int getTotalRows() {
        return totalRows;
    }

    //获取总列数
    public int getTotalCells() {
        return totalCells;
    }

    //获取错误信息
    public String getErrorInfo() {
        return errorMsg;
    }

    @Resource
    private ImportantPersonRepository importantPersonRepository;

    /**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    /**
     * 读EXCEL文件，获取客户信息集合
     *
     * @param fileName
     * @return
     */
    public List<ImportantPerson> getExcelInfo(String fileName, MultipartFile Mfile, String username, String ip, Long areaId) {

        //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
        CommonsMultipartFile cf = (CommonsMultipartFile) Mfile; //获取本地存储路径
        File file = new File("D:\\测试EXCEL\\");
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!file.exists()) file.mkdirs();
        //新建一个文件
        File file1 = new File("D:\\测试EXCEL\\" + System.currentTimeMillis() + ".xlsx");
        //将上传的文件写入新建的文件中
        try {
            cf.getFileItem().write(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //初始化客户信息的集合
        List<ImportantPerson> ImportantPerson = new ArrayList<ImportantPerson>();
        //初始化输入流
        InputStream is = null;
        try {
            //验证文件名是否合格
            if (!validateExcel(fileName)) {
                return null;
            }
            //根据文件名判断文件是2003版本还是2007版本
            boolean isExcel2003 = true;
            if (WDWUtil.isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            //根据新建的文件实例化输入流
            is = new FileInputStream(file1);
            //根据excel里面的内容读取客户信息
            ImportantPerson = getExcelInfo(is, isExcel2003, username, ip, areaId);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return ImportantPerson;
    }

    /**
     * 根据excel里面的内容读取客户信息
     *
     * @param is          输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws java.io.IOException
     */
    public List<ImportantPerson> getExcelInfo(InputStream is, boolean isExcel2003, String username, String ip, Long areaId) {
        List<ImportantPerson> ImportantPerson = null;
        try {
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            //当excel是2003时
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {//当excel是2007时
                wb = new XSSFWorkbook(is);
            }
            //读取Excel里面客户的信息
            ImportantPerson = readExcelValue(wb, username, ip, areaId);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.print("日期有毛病");
            e.printStackTrace();
        }
        return ImportantPerson;
    }

    /**
     * 读取Excel里面客户的信息
     *
     * @param wb
     * @return
     */
    private List<ImportantPerson> readExcelValue(Workbook wb, String username, String ip, Long areaId) throws ParseException {
        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);

        //得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();

        //得到Excel的列数(前提是有行数)
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }

        List<ImportantPerson> importantPersonList = new ArrayList<ImportantPerson>();
        ImportantPerson importantPerson;
        //循环Excel行数,从第二行开始。标题不入库
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null){continue;}
            importantPerson = new ImportantPerson();
            importantPerson.setCreatedBy(username);
            importantPerson.setCreatedIp(ip);
            importantPerson.setCreatedTime(new Date());
            importantPerson.setAreaId(areaId);
            //循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if (c == 0) {//第一列
                        importantPerson.setName(cell.getStringCellValue());//重点人员名字
                    } else if (c == 1) {
                        importantPerson.setSex(cell.getStringCellValue());//性别
                    } else if (c == 2) {
                        importantPerson.setBornTime(cell.getDateCellValue());//出生日期
                    } else if (c == 3) {
                        importantPerson.setNation(cell.getStringCellValue());//民族
                    } else if (c == 4) {
                        importantPerson.setIdCardNo(cell.getStringCellValue());//身份证号码
                    } else if (c == 5) {
                        importantPerson.setAddress(cell.getStringCellValue());//户籍地址
                    } else if (c == 6) {
                        importantPerson.setPersonType(cell.getStringCellValue());//人员类别
                    } else if (c == 7) {
                        importantPerson.setControlName(cell.getStringCellValue());//布控人姓名
                    } else if (c == 8) {
                        importantPerson.setControlPersonUnit(cell.getStringCellValue());//布控人姓名
                    } else if (c == 9) {
                        importantPerson.setControlUnit(cell.getStringCellValue());//布控单位
                    } else if (c == 10) {
                        importantPerson.setControlTel(cell.getStringCellValue());//布控人联系方式
                    } else if (c == 11) {
                        importantPerson.setRemark(cell.getStringCellValue());//备注
                    }
                }
            }

            //添加客户
            importantPersonList.add(importantPerson);

        }
        return importantPersonList;
    }

    public List<StaticFileClass> readExcelStatic(String templeFileName, String username, String ip, Long areaId) throws Exception {
        File file = new File(templeFileName);
        InputStream is = null;
        boolean isExcel2003 = true;
        try {
            //验证文件名是否合格
            if (!validateExcel(templeFileName)) {
                throw new Exception("文件格式有误");
            }
            if (WDWUtil.isExcel2007(templeFileName)) {
                isExcel2003 = false;
            }
            is = new FileInputStream(file);
            List<StaticFileClass> staticFileClasses = getExcelInfoStatic(is, isExcel2003, username, ip, areaId);
            return staticFileClasses;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }
        return null;
    }


    public List<StaticFileClass> getExcelInfoStatic(InputStream is, Boolean isExcel2003, String username, String ip, Long areaId) throws Exception {
        List<StaticFileClass> staticFileClasses = new ArrayList<>();
        /** 根据版本选择创建Workbook的方式 */
        Workbook wb = null;
        //当excel是2003时
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {//当excel是2007时
            wb = new XSSFWorkbook(is);
        }
        //读取Excel里面客户的信息
        staticFileClasses = readExcelValueStatic(wb, username, ip, areaId);
        return staticFileClasses;
    }


    public List<StaticFileClass> readExcelValueStatic(Workbook wb, String username, String ip, Long areaId) throws Exception {
        List<StaticFileClass> staticFileClasses = new ArrayList<>();
        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        //得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        //得到Excel的列数(前提是有行数)
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        StaticFileClass staticFileClass = null;
        Integer name_index = null;
        Integer idcard_index = null;
        Integer address_index = null;
        Integer nation_index = null;
        Integer profession_index = null;
        Integer tel_index = null;
        Map<Integer, String> other_index = new HashMap<>();

        for (int r = 0; r < totalRows; r++) {//从标题开始
            String detail = "";
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            staticFileClass = new StaticFileClass();
            staticFileClass.setCreatedBy(username);
            staticFileClass.setCreatedIp(ip);
            staticFileClass.setCreatedTime(new Date());
            staticFileClass.setAreaId(areaId);
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                //1.获取表头下标和相关的表头名
                if (r == 0) {
                    if ("姓名".equals(cell.getStringCellValue())) {
                        name_index = c;
                    } else if ("身份证号".equals(cell.getStringCellValue())) {
                        idcard_index = c;
                    } else if ("户籍地".equals(cell.getStringCellValue())) {
                        address_index = c;
                    } else if ("民族".equals(cell.getStringCellValue())) {
                        nation_index = c;
                    } else if ("工作单位".equals(cell.getStringCellValue())) {
                        profession_index = c;
                    } else if ("联系电话".equals(cell.getStringCellValue())) {
                        tel_index = c;
                    } else {
                        other_index.put(c, cell.getStringCellValue());
                    }
                }
                if (r != 0) {
                    if (name_index == null && idcard_index == null && address_index == null && nation_index == null && profession_index == null && tel_index == null) {
                        throw new Exception("文件标题不符合格式");
                    }
                    if(cell != null) {
                    //2.循环数据
                    if (name_index != null && name_index == c) {//姓名
                        staticFileClass.setName(cell.getStringCellValue());
                        detail += "姓名" + "=" + cell.getStringCellValue() + ";";
                    } else if (idcard_index != null && idcard_index == c) {//身份证号
                        staticFileClass.setIdCardNo(cell.getStringCellValue());
                        detail += "身份证号" + "=" + cell.getStringCellValue() + ";";
                    } else if (tel_index != null && tel_index == c) {//身份证号
                        staticFileClass.setTel(cell.getStringCellValue());
                        detail += "联系电话" + "=" + cell.getStringCellValue() + ";";
                    } else if (address_index != null && address_index == c) {//地址
                        staticFileClass.setAddress(cell.getStringCellValue());
                        detail += "户籍地" + "=" + cell.getStringCellValue() + ";";
                    } else if (nation_index != null && nation_index == c) {//
                        staticFileClass.setNation(cell.getStringCellValue());
                        detail += "民族" + "=" + cell.getStringCellValue() + ";";
                    } else if (profession_index != null && profession_index == c) {
                        staticFileClass.setProfession(cell.getStringCellValue());
                        detail += "工作单位" + "=" + cell.getStringCellValue() + ";";
                    } else {
                        String title = other_index.get(c);
                        if(cell != null) {
                            switch (cell.getCellType()) {
                                case HSSFCell.CELL_TYPE_NUMERIC:// 数字类型
                                    detail += title + "=" + cell.getNumericCellValue() + ";";
                                    break;
                                case HSSFCell.CELL_TYPE_STRING:
                                    detail += title + "=" + cell.getStringCellValue() + ";";
                                    break;
                            }
                        }
                    }
                    }
                }
            }

            if (r != 0) {
                System.out.println(detail);
                staticFileClass.setDetail(detail);
                staticFileClass.setAreaId(areaId);
                staticFileClass.setCreatedBy(username);
                staticFileClass.setCreatedIp(ip);
                staticFileClasses.add(staticFileClass);
            }
        }
        return staticFileClasses;
    }
}
