package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.*;
import com.yaofei.springmvcmybatis.repository.MedicalNewbornRecordTransferRepository;
import com.yaofei.springmvcmybatis.service.*;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 情报导入记录
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-01 11:11:40
 */
@Controller
@RequestMapping( "/admin/intelligenceimportcity" )
public class IntelligenceImportCityController extends BaseCRUDController<IntelligenceImportCity> {

    @Value( "${upload.temp.dir}" )
    private String upload_dir = "upload_temp";
    /*文件所属类型*/
    private int Natural_Gas = 44;
    /*空字符串*/
    private String Empty = "";

    @Autowired
    private IntelligenceImportCityService intelligenceImportCityService;

    @Autowired
    private StaticFileToCityService staticFileToCityService;
    @Autowired
    private StaticWaterToCityService staticWaterToCityService;
    @Autowired
    private StaticPeopleToCityService staticPeopleToCityService;
    @Autowired
    private StaticHealthyToCityService staticHealthyToCityService;
    @Autowired
    private CarInfoToCityService carInfoToCityService;
    @Autowired
    private StaticNcmsToCityService staticNcmsToCityService;
    @Autowired
    private StaticInsuranceToCityService staticInsuranceToCityService;
    @Autowired
    private StaticAccumulationFundToCityService staticAccumulationFundToCityService;
    @Autowired
    private StaticLettersCallsToCityService staticLettersCallsToCityService;
    @Autowired
    private MedicalStudentToCityTransferService medicalStudentToCityTransferService;
    @Autowired
    private TYlbjTjxxService tYlbjTjxxService;
    @Autowired
    private MedicalTelevisionToCityTransferService medicalTelevisionToCityTransferService;
    @Autowired
    private VipInfoToCityTransferService vipInfoToCityTransferService;
    @Autowired
    private CarGpsInfoToCityTransferService carGpsInfoToCityTransferService;
    @Autowired
    private VisitorInfoToCityTransferService visitorInfoToCityTransferService;
    @Autowired
    private EconomicalInfoToCityTransferService economicalInfoToCityTransferService;
    @Autowired
    private GasFeeInfoToCityTransferService gasFeeInfoToCityTransferService;
    @Autowired
    private EcoGpsInfoToCityTransferService ecoGpsInfoToCityTransferService;
    @Autowired
    private ExpressInfoToCityTransferService expressInfoToCityTransferService;
    @Autowired
    private MedicalStaticPowerToCityTransferService medicalStaticPowerToCityTransferService;
    @Autowired
    private MedicalStaticPowerDataToCityTransferService medicalStaticPowerDataToCityTransferService;
    @Autowired
    private MedicalNewbornRecordTransferRepository medicalNewbornRecordTransferRepository;
    @ResponseBody
    @RequestMapping( value = "/addAndUpload", method = RequestMethod.POST )
    public JsonResult addAndUpload(@RequestParam( "files" ) CommonsMultipartFile[] files, Long areaId, Long businessTypeId, Integer fileType, String fileDesc, String collectTime, String remark, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        intelligenceImportCityService.addAndUpload(files, areaId, businessTypeId, fileType, fileDesc, collectTime, remark, super.getUsername(), request, response);
        return JsonResult.ok();
    }

    @ResponseBody
    @RequestMapping( value = "/updatetocity", method = RequestMethod.POST )
    public JsonResult updatetocity(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectAll();
            StaticFileToCityTransfer staticFileToCityTransfer = new StaticFileToCityTransfer();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    staticFileToCityTransfer.setId(id);
                    staticFileToCityTransfer.setXXZJBH(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        staticFileToCityTransfer.setXM(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getSex()) && list.get(i).getSex() != null) {
                        staticFileToCityTransfer.setXB(list.get(i).getSex());
                    }
                    if (!Empty.equals(list.get(i).getIdCardNo()) && list.get(i).getIdCardNo() != null) {
                        staticFileToCityTransfer.setCYZJHM(list.get(i).getIdCardNo());
                    }
                    if (!Empty.equals(list.get(i).getAddress()) && list.get(i).getAddress() != null) {
                        staticFileToCityTransfer.setSYDZ_DZMC(list.get(i).getAddress());
                    }
                    if (!Empty.equals(list.get(i).getAreaId()) && list.get(i).getAreaId() != null) {
                        staticFileToCityTransfer.setDJDW_GAJGJGDM(list.get(i).getAreaId());
                    }
                    staticFileToCityTransfer.setDJDW_GAJGMC("桐柏县公安局");
                    staticFileToCityTransfer.setDJR_XM("付岩峰");
                    if (!Empty.equals(list.get(i).getCollectTime()) && list.get(i).getCollectTime() != null) {
                        staticFileToCityTransfer.setDJSJ(list.get(i).getCollectTime());
                    }
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        String dhhm = "";
                        String yqdz = "";
                        String dz = "";
                        String gw = "";
                        String sfzjh = "";
                        for (int j = 0; j < arr.length; j++) {
                            if(arr[j].indexOf("手机") != -1 || arr[j].indexOf("电话") != -1) {
                                dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticFileToCityTransfer.setLXDH(dhhm);
                            }
                            if (arr[j].indexOf("用气地址") != -1) {
                                yqdz = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticFileToCityTransfer.setSYDZ_DZMC(yqdz);
                            }
                            if (arr[j].indexOf("身份号码") != -1 || arr[j].indexOf("身份") != -1  || arr[j].indexOf("身份证号") != -1) {
                                sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticFileToCityTransfer.setCYZJHM(sfzjh);
                            }
                            if (arr[j].indexOf("地址") != -1) {
                                dz = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticFileToCityTransfer.setSYDZ_DZMC(dz);
                            }
                            if (arr[j].indexOf("岗位") != -1) {
                                gw = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticFileToCityTransfer.setZW(gw);
                            }
                        }
                    }
                    staticFileToCityService.insert(staticFileToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping( value = "/updatewatertocity", method = RequestMethod.POST )
    public JsonResult updatewatertocity(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        List<StaticFileClass> list = intelligenceImportCityService.selectAllWater();
        int n = 5;
        long id = 0L;
        for (int i = 0; i < n; i++) {
            StaticWaterToCityTransfer staticWaterToCityTransfer = new StaticWaterToCityTransfer();
            MedicalStaticWaterToCityTransfer medicalStaticWaterToCityTransfer = new MedicalStaticWaterToCityTransfer();
            id = list.get(i).getId();
            staticWaterToCityTransfer.setId(id);
            staticWaterToCityTransfer.setXXZJBH(id);
            medicalStaticWaterToCityTransfer.setId(id);
            medicalStaticWaterToCityTransfer.setXxzjbh(id);
            if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                staticWaterToCityTransfer.setXM(list.get(i).getName());
                medicalStaticWaterToCityTransfer.setXm(list.get(i).getName());
            }
            if (!Empty.equals(list.get(i).getSex()) && list.get(i).getSex() != null) {
                staticWaterToCityTransfer.setXB(list.get(i).getSex());
                medicalStaticWaterToCityTransfer.setXb(list.get(i).getSex());
            }
            if (!Empty.equals(list.get(i).getIdCardNo()) && list.get(i).getIdCardNo() != null) {
                staticWaterToCityTransfer.setGMSFHM(list.get(i).getIdCardNo());
                medicalStaticWaterToCityTransfer.setGmsfhm(list.get(i).getIdCardNo());
            }
            if (!Empty.equals(list.get(i).getAddress()) && list.get(i).getAddress() != null) {
                staticWaterToCityTransfer.setYHDZ_DZMC(list.get(i).getAddress());
                medicalStaticWaterToCityTransfer.setXzzDzmc(list.get(i).getAddress());
            }
            if (!Empty.equals(list.get(i).getAreaId()) && list.get(i).getAreaId() != null) {
                staticWaterToCityTransfer.setDJDW_GAJGJGDM(list.get(i).getAreaId());
                medicalStaticWaterToCityTransfer.setDjdwGajgjgdm(list.get(i).getAreaId());
            }
            staticWaterToCityTransfer.setDJDW_GAJGMC("桐柏县公安局");
            staticWaterToCityTransfer.setDJR_XM("付岩峰");
            medicalStaticWaterToCityTransfer.setDjdwGajgmc("桐柏县公安局");
            medicalStaticWaterToCityTransfer.setDjrXm("付岩峰");
            if (!Empty.equals(list.get(i).getCollectTime()) && list.get(i).getCollectTime() != null) {
                staticWaterToCityTransfer.setDJSJ(list.get(i).getCollectTime());
            }
            if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                String details = list.get(i).getDetail();
                String[] arr = details.split(";");
                String dhhm = "";
                String yqdz = "";
                String dz = "";
                String bgh = "";
                String bycj = "";
                String sfzjh ="";
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j].indexOf("水牌号") != -1) {
                        dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                        staticWaterToCityTransfer.setYHCKBH(dhhm);
                        medicalStaticWaterToCityTransfer.setKhWpbzh(dhhm);
                    }
                    if (arr[j].indexOf("身份号码") != -1 || arr[j].indexOf("身份") != -1  || arr[j].indexOf("身份证号") != -1) {
                        sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                        medicalStaticWaterToCityTransfer.setGmsfhm(sfzjh);
                    }
                    if (arr[j].indexOf("地址") != -1) {
                        yqdz = arr[j].substring(arr[j].indexOf("=") + 1);
                        staticWaterToCityTransfer.setYHDZ_DZMC(yqdz);
                        medicalStaticWaterToCityTransfer.setXzzDzmc(yqdz);
                    } else if (arr[j].indexOf("户籍地址") != -1) {
                        yqdz = arr[j].substring(arr[j].indexOf("=") + 1);
                        staticWaterToCityTransfer.setYHDZ_DZMC(yqdz);
                        medicalStaticWaterToCityTransfer.setXzzDzmc(yqdz);
                    } else if (arr[j].indexOf("安装地址") != -1) {
                        yqdz = arr[j].substring(arr[j].indexOf("=") + 1);
                        staticWaterToCityTransfer.setYHDZ_DZMC(yqdz);
                        medicalStaticWaterToCityTransfer.setXzzDzmc(yqdz);
                    }
                    if (arr[j].indexOf("交费日期") != -1 && arr[j].indexOf("年") == -1) {
                        try {
                            dz = arr[j].substring(arr[j].indexOf("=") + 1);
                            SimpleDateFormat sdf = null;
                            if (dz.contains("-")) {
                                sdf = new SimpleDateFormat("yyyy-MM-dd");
                            } else if (dz.contains("/")) {
                                sdf = new SimpleDateFormat("yyyy/MM/dd");
                            } else if (dz.contains(".")) {
                                sdf = new SimpleDateFormat("yyyy.MM.dd");
                            } else {
                                sdf = new SimpleDateFormat("yyyyMMdd");
                            }
                            Date date = sdf.parse(dz);
                            staticWaterToCityTransfer.setSKRQ(date);
                            medicalStaticWaterToCityTransfer.setDrsj(date);
                        } catch (Exception e) {
                            staticWaterToCityTransfer.setSKRQ(new Date());
                            medicalStaticWaterToCityTransfer.setDrsj(new Date());
                        }
                    }
                    if ((arr[j].indexOf("开户日期") != -1 && arr[j].indexOf("年") == -1)||(arr[j].indexOf("开户") != -1 && arr[j].indexOf("年") == -1)) {
                        try {
                            dz = arr[j].substring(arr[j].indexOf("=") + 1);
                            SimpleDateFormat sdf = null;
                            if (dz.contains("-")) {
                                sdf = new SimpleDateFormat("yyyy-MM-dd");
                            } else if (dz.contains("/")) {
                                sdf = new SimpleDateFormat("yyyy/MM/dd");
                            } else if (dz.contains(".")) {
                                sdf = new SimpleDateFormat("yyyy.MM.dd");
                            } else {
                                sdf = new SimpleDateFormat("yyyyMMdd");
                            }
                            Date date = sdf.parse(dz);
                            medicalStaticWaterToCityTransfer.setKhrq(date);
                        } catch (Exception e) {
                            medicalStaticWaterToCityTransfer.setKhrq(new Date());
                        }
                    }
                    if (arr[j].indexOf("用水性质") != -1) {
                        bgh = arr[j].substring(arr[j].indexOf("=") + 1);
                        medicalStaticWaterToCityTransfer.setYsxz(bgh);
                    }
                    if (arr[j].indexOf("性别") != -1) {
                        bycj = arr[j].substring(arr[j].indexOf("=") + 1);
                        medicalStaticWaterToCityTransfer.setXb(bycj);
                    }
                    if(medicalStaticWaterToCityTransfer.getKhrq() == null || ("").equals(medicalStaticWaterToCityTransfer.getKhrq())){
                        medicalStaticWaterToCityTransfer.setKhrq(new Date());
                    }
                }
            }
            try {
                staticWaterToCityService.insert(medicalStaticWaterToCityTransfer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            intelligenceImportCityService.updateIfUpload(id);
        }
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping( value = "/updatepeopletocity", method = RequestMethod.POST )
    public JsonResult updatepeopletocity(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectAllPeople();
            StaticTrifficPeopleToCityTransfer staticTrifficPeopleToCityTransfer = new StaticTrifficPeopleToCityTransfer();
            MedicalStaticPeopleToCityTransfer medicalStaticPeopleToCityTransfer = new MedicalStaticPeopleToCityTransfer();
            int n = 1;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    staticTrifficPeopleToCityTransfer.setId(id);
                    staticTrifficPeopleToCityTransfer.setXXZJBH(id);
                    medicalStaticPeopleToCityTransfer.setId(id);
                    medicalStaticPeopleToCityTransfer.setXxzjbh(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        staticTrifficPeopleToCityTransfer.setXM(list.get(i).getName());
                        medicalStaticPeopleToCityTransfer.setXm(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getSex()) && list.get(i).getSex() != null) {
                        staticTrifficPeopleToCityTransfer.setXB(list.get(i).getSex());
                        if ("男".equals(list.get(i).getSex())) {
                            medicalStaticPeopleToCityTransfer.setXbdm("1");
                        } else if ("女".equals(list.get(i).getSex())) {
                            medicalStaticPeopleToCityTransfer.setXbdm("2");
                        } else {
                            medicalStaticPeopleToCityTransfer.setXbdm("9");
                        }
                    }
                    if (!Empty.equals(list.get(i).getNation()) && list.get(i).getNation() != null) {
                        staticTrifficPeopleToCityTransfer.setXB(list.get(i).getSex());
                        if ("汉".equals(list.get(i).getNation()) || "族".equals(list.get(i).getNation())) {
                            medicalStaticPeopleToCityTransfer.setMzdm("01");
                        } else if ("蒙古族".equals(list.get(i).getNation())) {
                            medicalStaticPeopleToCityTransfer.setMzdm("02");
                        } else if ("回族".equals(list.get(i).getNation())) {
                            medicalStaticPeopleToCityTransfer.setMzdm("03");
                        } else if ("藏族".equals(list.get(i).getNation())) {
                            medicalStaticPeopleToCityTransfer.setMzdm("04");
                        }
                    }
                    medicalStaticPeopleToCityTransfer.setCyzjdm("111");
                    if (!Empty.equals(list.get(i).getIdCardNo()) && list.get(i).getIdCardNo() != null) {
                        staticTrifficPeopleToCityTransfer.setGMSFHM(list.get(i).getIdCardNo());
                        medicalStaticPeopleToCityTransfer.setZjhm(list.get(i).getIdCardNo());
                    }
                    if (!Empty.equals(list.get(i).getAreaId()) && list.get(i).getAreaId() != null) {
                        staticTrifficPeopleToCityTransfer.setDJDW_GAJGJGDM(list.get(i).getAreaId());
                    }
                    staticTrifficPeopleToCityTransfer.setDJDW_GAJGMC("桐柏县公安局");
                    staticTrifficPeopleToCityTransfer.setDJR_XM("付岩峰");
                    if (!Empty.equals(list.get(i).getCollectTime()) && list.get(i).getCollectTime() != null) {
                        staticTrifficPeopleToCityTransfer.setDJSJ(list.get(i).getCollectTime());
                    }
                    medicalStaticPeopleToCityTransfer.setGjdm("CHN");
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        String xb = "";
                        String sfzhm = "";
                        String cph = "";
                        String danwei = "";
                        String dhhm = "";
                        String jszc = "";
                        String myysl = "";
                        String zgzh = "";
                        String hjdz = "";
                        for (int j = 0; j < arr.length; j++) {
                            if (arr[j].indexOf("性别") != -1) {
                                xb = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticTrifficPeopleToCityTransfer.setXB(xb);
                                if ("男".equals(xb)) {
                                    medicalStaticPeopleToCityTransfer.setXbdm("1");
                                } else if ("女".equals(xb)) {
                                    medicalStaticPeopleToCityTransfer.setXbdm("2");
                                } else {
                                    medicalStaticPeopleToCityTransfer.setXbdm("9");
                                }
                            }
                            if (arr[j].indexOf("身份号码") != -1 || arr[j].indexOf("身份") != -1  || arr[j].indexOf("身份证号") != -1) {
                                sfzhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticTrifficPeopleToCityTransfer.setGMSFHM(sfzhm);
                                medicalStaticPeopleToCityTransfer.setZjhm(sfzhm);
                            }
                            if (arr[j].indexOf("注册号") != -1) {
                                zgzh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStaticPeopleToCityTransfer.setCyzgzh(zgzh);
                            }
                            if (arr[j].indexOf("资格证号") != -1 ||arr[j].indexOf("从业资格") != -1) {
                                zgzh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStaticPeopleToCityTransfer.setCyzgzh(zgzh);
                            }
                            if (arr[j].indexOf("工作单位及岗位") != -1 || arr[j].indexOf("单位名称") != -1) {
                                danwei = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticTrifficPeopleToCityTransfer.setDWMC(danwei);
                                medicalStaticPeopleToCityTransfer.setDwmc(danwei);
                            }
                            if (arr[j].indexOf("工作单位及职务") != -1 || arr[j].indexOf("单位名称") != -1) {
                                danwei = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticTrifficPeopleToCityTransfer.setDWMC(danwei);
                                medicalStaticPeopleToCityTransfer.setDwmc(danwei);
                            }
                            if (arr[j].indexOf("行业类型") != -1||arr[j].indexOf("类型") != -1) {
                                jszc = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticTrifficPeopleToCityTransfer.setGZ(jszc);
                                medicalStaticPeopleToCityTransfer.setZyzgmc(jszc);
                            }
                            if (arr[j].indexOf("车牌号") != -1) {
                                cph = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticTrifficPeopleToCityTransfer.setJDCHPHM(cph);
                            }
                            if (arr[j].indexOf("电话号码") != -1 || arr[j].indexOf("手机") != -1) {
                                dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticTrifficPeopleToCityTransfer.setLXDH(dhhm);
                                medicalStaticPeopleToCityTransfer.setLxdh(dhhm);
                            }
                            if (arr[j].indexOf("户籍地址") != -1||arr[j].indexOf("户籍") != -1) {
                                hjdz = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStaticPeopleToCityTransfer.setHjdzDzmc(hjdz);
                            }
                            if (arr[j].indexOf("出生日期") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    myysl = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (myysl.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    } else if (myysl.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (myysl.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd");
                                    }
                                    Date date = sdf.parse(myysl);
                                    medicalStaticPeopleToCityTransfer.setCsrq(date);
                                } catch (Exception e) {
                                    medicalStaticPeopleToCityTransfer.setCsrq(new Date());
                                }
                            }
                            if (arr[j].indexOf("参加工作时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    myysl = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (myysl.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    } else if (myysl.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (myysl.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd");
                                    }
                                    Date date = sdf.parse(myysl);
                                    medicalStaticPeopleToCityTransfer.setDbdwRq(date);
                                } catch (Exception e) {
                                    medicalStaticPeopleToCityTransfer.setDbdwRq(new Date());
                                }
                            }
                            if (medicalStaticPeopleToCityTransfer.getDbdwRq() == null || "".equals(medicalStaticPeopleToCityTransfer.getDbdwRq())) {
                                medicalStaticPeopleToCityTransfer.setDbdwRq(new Date());
                            }
                            if (medicalStaticPeopleToCityTransfer.getCsrq() == null || "".equals(medicalStaticPeopleToCityTransfer.getCsrq())) {
                                medicalStaticPeopleToCityTransfer.setCsrq(new Date());
                            }
                        }
                    }
                    staticPeopleToCityService.insert(medicalStaticPeopleToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping( value = "/updatehealthytocity", method = RequestMethod.POST )
    public JsonResult updatehealthytocity(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectAllHealthy();
            StaticHealthyToCityTransfer staticHealthyToCityTransfer = new StaticHealthyToCityTransfer();
            int n = 2;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    staticHealthyToCityTransfer.setId(id);
                    staticHealthyToCityTransfer.setXXZJBH(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        staticHealthyToCityTransfer.setXM(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getIdCardNo()) && list.get(i).getIdCardNo() != null) {
                        staticHealthyToCityTransfer.setGMSFHM(list.get(i).getIdCardNo());
                    }
                    staticHealthyToCityTransfer.setXXLYMS("桐柏县公安局采集");
                    if (!Empty.equals(list.get(i).getCollectTime()) && list.get(i).getCollectTime() != null) {
                        staticHealthyToCityTransfer.setDJRQ(list.get(i).getCollectTime());
                    }
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        String xb = "";
                        String sfzhm = "";
                        String cph = "";
                        String danwei = "";
                        String dhhm = "";
                        String jszc = "";
                        for (int j = 0; j < arr.length; j++) {
                            if (arr[j].indexOf("健康证号") != -1 || arr[j].indexOf("健康证") != -1) {
                                xb = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticHealthyToCityTransfer.setJKZM_BDH(xb);
                            }
                            if (arr[j].indexOf("户籍地址") != -1 || arr[j].indexOf("户籍地") != -1) {
                                cph = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticHealthyToCityTransfer.setDZMC(cph);
                            }
                            if (arr[j].indexOf("身份证号码") != -1 || arr[j].indexOf("身份证") != -1 || arr[j].indexOf("身份证号") != -1)  {
                                sfzhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticHealthyToCityTransfer.setGMSFHM(sfzhm);
                            }
                            if (arr[j].indexOf("单位") != -1 || arr[j].indexOf("工作单位") != -1) {
                                danwei = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticHealthyToCityTransfer.setDWMC(danwei);
                            }
                            if (arr[j].indexOf("电话号码") != -1 || arr[j].indexOf("手机") != -1) {
                                dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticHealthyToCityTransfer.setLXDH(dhhm);
                            }
                            if (arr[j].indexOf("体检结论") != -1) {
                                jszc = arr[j].substring(arr[j].indexOf("=") + 1);
                                staticHealthyToCityTransfer.setBZZT(jszc);
                            }
                            if (staticHealthyToCityTransfer.getDWMC()== null || "".equals(staticHealthyToCityTransfer.getDWMC())){
                                staticHealthyToCityTransfer.setDWMC("暂无");
                            }
                        }
                    }
                    staticHealthyToCityService.insert(staticHealthyToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping( value = "/queryCarInfo", method = RequestMethod.POST )
    public JsonResult queryCarInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<GetLastTime> getLastTime = intelligenceImportCityService.selectLastTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastDate = formatter.format(getLastTime.get(0).getSCHUSJ());
        /*System.out.println("开始时间！"+lastDate);*/
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date now = new Date();
        String nowtime = formatter.format(now);
        /* System.out.println("结束时间！"+nowtime);*/
        PreparedStatement ps = null;
        Connection ct = null;
        ResultSet rs = null;

        String url = "jdbc:sqlserver://192.168.0.15:1433;databaseName=drykt";
        String user = "sa";  //超级管理员
        String password = "123";  //密码

        try {
            //1.加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("加载驱动成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try {
            //2.连接
            ct = DriverManager.getConnection(url, user, password);
            System.out.println("连接数据库成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接数据库失败！");
        }
        try {
            //在连接对象的基础上创建会话对象
            Statement stmt = ct.createStatement();
            String sqlStr = "select ID,CarNO,InTime,OutTime from Park_CarOut where InTime>='" + lastDate + "' and InTime<='" + nowtime + "'";
            //执行插入数据的SQL语句，返回受影响的行数
            ResultSet result = stmt.executeQuery(sqlStr);
            CarInfoTransfer carInfoTransfer = new CarInfoTransfer();
            while (result.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (result.getString("CarNO").indexOf("警") == -1) {
                    carInfoTransfer.setId(Long.parseLong(result.getString("ID")));
                    carInfoTransfer.setXXZJBH(Long.parseLong(result.getString("ID")));
                    if ("".equals(result.getString("CarNO"))) {
                        carInfoTransfer.setJDCHPHM("");
                    } else {
                        carInfoTransfer.setJDCHPHM(result.getString("CarNO"));
                    }
                    if (result.getString("InTime") == null) {
                        carInfoTransfer.setJC_SJ(null);
                    } else {
                        Date dateIn = sdf.parse(result.getString("InTime"));
                        carInfoTransfer.setJC_SJ(dateIn);
                    }
                    if (result.getString("OutTime") == null) {
                        carInfoTransfer.setCC_SJ(null);
                    } else {
                        Date dateOut = sdf.parse(result.getString("OutTime"));
                        carInfoTransfer.setCC_SJ(dateOut);
                    }
                    carInfoTransfer.setJCCM("桐柏县公安局停车场");
                    carInfoToCityService.insert(carInfoTransfer);

                }
            }
            intelligenceImportCityService.updateLastTime(now);
            //关闭会话对象
            stmt.close();
            //关闭连接对象
            ct.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("失败");
        }
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping( value = "/updatencms", method = RequestMethod.POST )
    public JsonResult updatencms(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectAllNcms();
            MedicalNcmsToCityTransfer medicalNcmsToCityTransfer = new MedicalNcmsToCityTransfer();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    medicalNcmsToCityTransfer.setId(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        medicalNcmsToCityTransfer.setXm(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getIdCardNo()) && list.get(i).getIdCardNo() != null) {
                        medicalNcmsToCityTransfer.setGmsfhm(list.get(i).getIdCardNo());
                    }
                    medicalNcmsToCityTransfer.setDrztms("桐柏县公安局采集");
                    medicalNcmsToCityTransfer.setDjdwGajgmc("桐柏县公安局");
                    medicalNcmsToCityTransfer.setDjrXm("付岩峰");
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        String xb = "";
                        String sfzhm = "";
                        String cph = "";
                        String danwei = "";
                        String dhhm = "";
                        String jszc = "";
                        String cbsj = "";
                        for (int j = 0; j < arr.length; j++) {
                            if (arr[j].indexOf("性别") != -1) {
                                xb = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNcmsToCityTransfer.setXb(xb);
                            }
                            if (arr[j].indexOf("村名") != -1) {
                                cph = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNcmsToCityTransfer.setHjdzDzmc(cph);
                            }
                            if (arr[j].indexOf("身份证号码") != -1 || arr[j].indexOf("身份证") != -1 || arr[j].indexOf("身份证号") != -1) {
                                sfzhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNcmsToCityTransfer.setGmsfhm(sfzhm);
                            }
                            if (arr[j].indexOf("与户主关系") != -1) {
                                danwei = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNcmsToCityTransfer.setYhzgx(danwei);
                            }
                            if (arr[j].indexOf("医疗证号") != -1 || arr[j].indexOf("医疗证") != -1 || arr[j].indexOf("医疗卡") != -1) {
                                dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNcmsToCityTransfer.setYlkh(dhhm);
                            }
                            if (arr[j].indexOf("出生日期") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    jszc = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (jszc.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    } else if (jszc.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (jszc.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd");
                                    } else if (jszc.contains("年")) {
                                        medicalNcmsToCityTransfer.setCsrq(null);
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd");
                                    }
                                    Date date = sdf.parse(jszc);
                                    medicalNcmsToCityTransfer.setCsrq(date);
                                } catch (Exception e) {
                                    medicalNcmsToCityTransfer.setCsrq(new Date());
                                }
                            }
                            if (arr[j].indexOf("参保时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    cbsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (cbsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    } else if (cbsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (cbsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd");
                                    } else if (cbsj.contains("年")) {
                                        medicalNcmsToCityTransfer.setCsrq(null);
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd");
                                    }
                                    Date date = sdf.parse(cbsj);
                                    medicalNcmsToCityTransfer.setCsrq(date);
                                } catch (Exception e) {
                                    medicalNcmsToCityTransfer.setCsrq(new Date());
                                }
                            }

                        }
                    }
                    staticNcmsToCityService.insert(medicalNcmsToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping( value = "/updatemedicalinsurance", method = RequestMethod.POST )
    public JsonResult updatemedicalinsurance(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectmedicalinsurance();
            MedicalInsuranceToCityTransfer medicalInsuranceToCityTransfer = new MedicalInsuranceToCityTransfer();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    medicalInsuranceToCityTransfer.setId(id);
                    medicalInsuranceToCityTransfer.setXxzjbh(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        medicalInsuranceToCityTransfer.setXm(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getNation()) && list.get(i).getNation() != null) {
                        medicalInsuranceToCityTransfer.setMz(list.get(i).getNation());
                    }
                    medicalInsuranceToCityTransfer.setDjdwGajgmc("桐柏县公安局");
                    medicalInsuranceToCityTransfer.setDjrXm("付岩峰");
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        String xb = "";
                        String sfzhm = "";
                        String danwei = "";
                        String dhhm = "";
                        String jszc = "";
                        String lxdh = "";
                        for (int j = 0; j < arr.length; j++) {
                            if (arr[j].indexOf("性别") != -1) {
                                xb = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalInsuranceToCityTransfer.setXb(xb);
                            }
                            if (arr[j].indexOf("户籍地址") != -1) {
                                jszc = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalInsuranceToCityTransfer.setHjdzDzmc(jszc);
                            }
                            if (arr[j].indexOf("手机") != -1 || arr[j].indexOf("电话") != -1) {
                                lxdh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalInsuranceToCityTransfer.setLxdh(lxdh);
                            }
                            if (arr[j].indexOf("村名") != -1) {
                                jszc = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalInsuranceToCityTransfer.setHjdzDzmc(jszc);
                            }
                            medicalInsuranceToCityTransfer.setCyzjmc("身份证");
                            if (arr[j].indexOf("身份证号码") != -1 || arr[j].indexOf("身份证") != -1 || arr[j].indexOf("身份证号") != -1)  {
                                sfzhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalInsuranceToCityTransfer.setZjhm(sfzhm);
                            }
                            if (arr[j].indexOf("邮政编码") != -1) {
                                danwei = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalInsuranceToCityTransfer.setTxdzYzbm(danwei);
                            }
                            if (arr[j].indexOf("医疗证号") != -1) {
                                dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalInsuranceToCityTransfer.setSbkh(dhhm);
                            }
                        }
                    }
                    staticInsuranceToCityService.insert(medicalInsuranceToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping( value = "/updateaccumulationfund", method = RequestMethod.POST )
    public JsonResult updateaccumulationfund(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectaccumulationfund();
            MedicalAccumulationFundToCityTransfer medicalAccumulationFundToCityTransfer = new MedicalAccumulationFundToCityTransfer();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    medicalAccumulationFundToCityTransfer.setId(id);
                    medicalAccumulationFundToCityTransfer.setXxzjbh(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        medicalAccumulationFundToCityTransfer.setXm(list.get(i).getName());
                    }
                    medicalAccumulationFundToCityTransfer.setDjdwGajgmc("桐柏县公安局");
                    medicalAccumulationFundToCityTransfer.setDjrXm("付岩峰");
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        String sfzhm = "";
                        String danwei = "";
                        String dhhm = "";
                        for (int j = 0; j < arr.length; j++) {
                            if (arr[j].indexOf(" ") != -1 || arr[j].indexOf("身份证") != -1 || arr[j].indexOf("身份证号") != -1)  {
                                sfzhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalAccumulationFundToCityTransfer.setZjhm(sfzhm);
                            }
                            if (arr[j].indexOf("证件类型") != -1) {
                                danwei = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalAccumulationFundToCityTransfer.setCyzjmc(danwei);
                            }
                            if (arr[j].indexOf("单位名称") != -1) {
                                dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalAccumulationFundToCityTransfer.setFwcs(dhhm);
                            }
                        }
                    }
                    staticAccumulationFundToCityService.insert(medicalAccumulationFundToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping( value = "/updateletterscalls", method = RequestMethod.POST )
    public JsonResult updateletterscalls(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectletterscalls();
            MedicalLettersCallsToCityTransfer medicalLettersCallsToCityTransfer = new MedicalLettersCallsToCityTransfer();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    medicalLettersCallsToCityTransfer.setId(id);
                    medicalLettersCallsToCityTransfer.setXxzjbh(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        medicalLettersCallsToCityTransfer.setXfrXm(list.get(i).getName());
                    }
                    medicalLettersCallsToCityTransfer.setDjdwGajgmc("桐柏县公安局");
                    medicalLettersCallsToCityTransfer.setDjrXm("付岩峰");
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        String cph = "";
                        String danwei = "";
                        String dhhm = "";
                        for (int j = 0; j < arr.length; j++) {
                            if (arr[j].indexOf("概况") != -1) {
                                danwei = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalLettersCallsToCityTransfer.setXfsyJyqk(danwei);
                            }
                            if (arr[j].indexOf("登记部门") != -1) {
                                dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalLettersCallsToCityTransfer.setSldwDwmc(dhhm);
                            }
                            if (arr[j].indexOf("信访日期") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    cph = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (cph.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    } else if (cph.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (cph.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd");
                                    }
                                    Date date = sdf.parse(cph);
                                    medicalLettersCallsToCityTransfer.setSfrq(date);
                                } catch (Exception e) {
                                    medicalLettersCallsToCityTransfer.setSfrq(new Date());
                                }
                            }
                        }
                    }
                    staticLettersCallsToCityService.insert(medicalLettersCallsToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 将有线电视上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updateTelevisionToCity", method = RequestMethod.POST )
    public JsonResult updateTelevisionToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectTelevisionToCitys();
            MedicalTelevisionToCityTransfer medicalTelevisionToCityTransfer = new MedicalTelevisionToCityTransfer();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    medicalTelevisionToCityTransfer.setId(id);
                    medicalTelevisionToCityTransfer.setXxzjbh(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        medicalTelevisionToCityTransfer.setXm(list.get(i).getName());
                    }
                    medicalTelevisionToCityTransfer.setDjdw("桐柏县公安局");
                    medicalTelevisionToCityTransfer.setDjrXm("付岩峰");
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        String yhzh = "";
                        String yhxm = "";
                        String sfzjh = "";
                        String xb = "";
                        String dhhm = "";
                        String cyxzz = "";
                        String sfsj = "";
                        String zzsj = "";
                        String drsj = "";
                        for (int j = 0; j < arr.length; j++) {
                            if (arr[j].indexOf("用户号") != -1 || arr[j].indexOf("账号") != -1) {
                                yhzh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalTelevisionToCityTransfer.setJfKh(yhzh);
                                medicalTelevisionToCityTransfer.setKh(yhzh);
                            }
                            if (arr[j].indexOf("用户姓名") != -1) {
                                yhxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalTelevisionToCityTransfer.setXm(yhxm);
                            }
                            if (arr[j].indexOf("性别") != -1) {
                                xb = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalTelevisionToCityTransfer.setXb(xb);
                            }
                            if (arr[j].indexOf("安装地址") != -1) {
                                cyxzz = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalTelevisionToCityTransfer.setJtzzDzmc(cyxzz);
                            }
                            if (arr[j].indexOf("家庭地址") != -1) {
                                cyxzz = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalTelevisionToCityTransfer.setJtzzDzmc(cyxzz);
                            }
                            if (arr[j].indexOf("通讯地址") != -1) {
                                cyxzz = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalTelevisionToCityTransfer.setJtzzDzmc(cyxzz);
                            }
                            if (arr[j].indexOf("手机") != -1 || arr[j].indexOf("电话") != -1) {
                                dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalTelevisionToCityTransfer.setGddh(dhhm);
                                medicalTelevisionToCityTransfer.setYddh(dhhm);

                            }
                            if (arr[j].indexOf("手机") != -1 || arr[j].indexOf("电话") != -1) {
                                dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalTelevisionToCityTransfer.setGddh(dhhm);
                                medicalTelevisionToCityTransfer.setYddh(dhhm);
                            }
                            if (arr[j].indexOf("身份证号") != -1 || arr[j].indexOf("身份证") != -1) {
                                sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalTelevisionToCityTransfer.setGmsfhm(sfzjh);
                            }
                            if (arr[j].indexOf("收费日期") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    sfsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    if (!"".equals(sfsj)) {
                                        SimpleDateFormat sdf = null;
                                        if (sfsj.contains("-")) {
                                            sdf = new SimpleDateFormat("yyyy-MM-dd");
                                        } else if (sfsj.contains("/")) {
                                            sdf = new SimpleDateFormat("yyyy/MM/dd");
                                        } else if (sfsj.contains(".")) {
                                            sdf = new SimpleDateFormat("yyyy.MM.dd");
                                        } else {
                                            sdf = new SimpleDateFormat("yyyyMMdd");
                                        }
                                        Date date = sdf.parse(sfsj);
                                        medicalTelevisionToCityTransfer.setAzrq(date);
                                    }
                                } catch (Exception e) {
                                    medicalTelevisionToCityTransfer.setAzrq(new Date());
                                }
                            }
                            if (arr[j].indexOf("终止日期") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    zzsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    if (!"".equals(zzsj)) {
                                        SimpleDateFormat sdf = null;
                                        if (zzsj.contains("-")) {
                                            sdf = new SimpleDateFormat("yyyy-MM-dd");
                                        } else if (zzsj.contains("/")) {
                                            sdf = new SimpleDateFormat("yyyy/MM/dd");
                                        } else if (zzsj.contains(".")) {
                                            sdf = new SimpleDateFormat("yyyy.MM.dd");
                                        } else {
                                            sdf = new SimpleDateFormat("yyyyMMdd");
                                        }
                                        Date date = sdf.parse(zzsj);
                                        medicalTelevisionToCityTransfer.setJzrq(date);
                                    }
                                } catch (Exception e) {
                                    medicalTelevisionToCityTransfer.setJzrq(new Date());
                                }
                            }
                            if (arr[j].indexOf("导入时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (drsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd");
                                    }
                                    Date date = sdf.parse(drsj);
                                    medicalTelevisionToCityTransfer.setDjsj(date);
                                } catch (Exception e) {
                                    medicalTelevisionToCityTransfer.setDjsj(new Date());
                                }
                            }
                            medicalTelevisionToCityTransfer.setXxrksj(new Date());
                            medicalTelevisionToCityTransfer.setDjsj(new Date());
                        }
                    }
                    medicalTelevisionToCityTransferService.insert(medicalTelevisionToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }


    /**
     * 将学生信息上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updateStudentToCity", method = RequestMethod.POST )
    public JsonResult updateStudentToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectStudentToCitys();
            MedicalStudentToCityTransfer medicalStudentToCityTransfer = new MedicalStudentToCityTransfer();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    medicalStudentToCityTransfer.setId(id);
                    medicalStudentToCityTransfer.setXxzjbh(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        medicalStudentToCityTransfer.setXm(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getNation())) {
                        medicalStudentToCityTransfer.setMz(list.get(i).getNation());
                    }
                    medicalStudentToCityTransfer.setDjdwGajgmc("桐柏县公安局");
                    medicalStudentToCityTransfer.setDjrXm("付岩峰");
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        String xjh = "";
                        String xsxm = "";
                        String sfzjh = "";
                        String xb = "";
                        String dhhm = "";
                        String cyxzz = "";
                        String xxmc = "";
                        String xxbsm = "";
                        String hkxz = "";
                        String drsj = "";
                        String cyxm = "";
                        String lxdh = "";
                        for (int j = 0; j < arr.length; j++) {
                            if (arr[j].indexOf("学籍号") != -1) {
                                xjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStudentToCityTransfer.setXuehao(xjh);
                            }
                            if (arr[j].indexOf("姓名") != -1) {
                                xsxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStudentToCityTransfer.setXm(xsxm);
                            }
                            if (arr[j].indexOf("性别") != -1) {
                                xb = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStudentToCityTransfer.setXb(xb);
                            }
                            if (arr[j].indexOf("成员现住址") != -1) {
                                cyxzz = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStudentToCityTransfer.setCsdDzmc(cyxzz);
                                medicalStudentToCityTransfer.setJtzzDzmc(cyxzz);
                                medicalStudentToCityTransfer.setHjdzDzmc(cyxzz);

                            }
                            //2019-06-03 联系电话数据库字段过程，上传市局报错
                               /* if (arr[j].indexOf("成员电话") != -1) {
                                    dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                    medicalStudentToCityTransfer.setFqLxdh(dhhm);
                                    medicalStudentToCityTransfer.setMqLxdh(dhhm);
                                }
                                if (arr[j].indexOf("联系电话") != -1) {
                                    lxdh = arr[j].substring(arr[j].indexOf("=") + 1);
                                    medicalStudentToCityTransfer.setLxdh(lxdh);
                                }*/
                            if (arr[j].indexOf("学校名称") != -1) {
                                xxmc = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStudentToCityTransfer.setXxmc(xxmc);
                            }
                            if (arr[j].indexOf("学校标识码") != -1) {
                                xxbsm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStudentToCityTransfer.setXuexdm(xxbsm);
                            }
                            if (arr[j].indexOf("身份证件号码") != -1 || arr[j].indexOf("身份证号") != -1 ||
                                    arr[j].indexOf("身份证") != -1) {
                                sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStudentToCityTransfer.setGmsfhm(sfzjh);
                            }
                            if (arr[j].indexOf("户口性质") != -1) {
                                hkxz = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStudentToCityTransfer.setHjlx(hkxz);
                                medicalStudentToCityTransfer.setSylbJyqk(hkxz);
                            }
                            if (arr[j].indexOf("成员姓名") != -1) {
                                cyxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStudentToCityTransfer.setFqXm(cyxm);
                                medicalStudentToCityTransfer.setMqXm(cyxm);
                            }
                            if (arr[j].indexOf("进校日期") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (drsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd");
                                    }
                                    Date date = sdf.parse(drsj);
                                    medicalStudentToCityTransfer.setJxrq(date);
                                } catch (Exception e) {
                                    medicalStudentToCityTransfer.setJxrq(new Date());
                                }
                            }
                            if (arr[j].indexOf("时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (drsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd");
                                    }
                                    Date date = sdf.parse(drsj);
                                    medicalStudentToCityTransfer.setJxrq(date);
                                } catch (Exception e) {
                                    medicalStudentToCityTransfer.setJxrq(new Date());
                                }
                            }
                            medicalStudentToCityTransfer.setXxrksj(new Date());
                            medicalStudentToCityTransfer.setDrsj(new Date());
                        }
                    }
                    medicalStudentToCityTransferService.insert(medicalStudentToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }


    /**
     * 将医院体检信息上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updatePhysicalExaminationToCity", method = RequestMethod.POST )
    public JsonResult updatePhysicalExaminationToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectPhysicalExamination();
            TYlbjTjxx tYlbjTjxx = new TYlbjTjxx();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    tYlbjTjxx.setId(id);
                    tYlbjTjxx.setXxzjbh(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        tYlbjTjxx.setXm(list.get(i).getName());
                    }
                    tYlbjTjxx.setYyDwmc("桐柏县人民医院");
                    tYlbjTjxx.setDjdwGajgmc("桐柏县公安局");
                    tYlbjTjxx.setDjrXm("付岩峰");
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        String xsxm = "";
                        String sfzjh = "";
                        String xb = "";
                        String dhhm = "";
                        String xxbsm = "";
                        String drsj = "";
                        String tjsj = "";
                        String lxdh = "";
                        for (int j = 0; j < arr.length; j++) {
                            if (arr[j].indexOf("姓名") != -1) {
                                xsxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                tYlbjTjxx.setXm(xsxm);
                            }
                            if (arr[j].indexOf("性别") != -1) {
                                xb = arr[j].substring(arr[j].indexOf("=") + 1);
                                tYlbjTjxx.setXb(xb);
                                if ("男".equals(xb)) {
                                    tYlbjTjxx.setXbdm("1");
                                } else if ("女".equals(xb)) {
                                    tYlbjTjxx.setXbdm("2");
                                } else {
                                    tYlbjTjxx.setXbdm("9");
                                }
                            }
                            if (arr[j].indexOf("体检编号") != -1) {
                                dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                                tYlbjTjxx.setZyh(dhhm);
                            }
                            if (arr[j].indexOf("手机") != -1 || arr[j].indexOf("电话") != -1) {
                                lxdh = arr[j].substring(arr[j].indexOf("=") + 1);
                                tYlbjTjxx.setLxdh(lxdh);
                            }
                            if (arr[j].indexOf("年龄") != -1) {
                                xxbsm = arr[j].substring(arr[j].indexOf("=") + 1);
                                tYlbjTjxx.setNl(xxbsm);
                            }
                            if (arr[j].indexOf("身份证") != -1) {
                                sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                tYlbjTjxx.setGmsfhm(sfzjh);
                            }

                            if (arr[j].indexOf("时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (drsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd");
                                    }
                                    Date date = sdf.parse(drsj);
                                    tYlbjTjxx.setDrsj(date);
                                } catch (Exception e) {
                                    tYlbjTjxx.setDrsj(new Date());
                                }
                            }
                            if (arr[j].indexOf("日期") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    tjsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (tjsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    } else if (tjsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (tjsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd");
                                    }
                                    Date date = sdf.parse(tjsj);
                                    tYlbjTjxx.setRyrq(date);
                                    tYlbjTjxx.setCyrq(date);
                                } catch (Exception e) {
                                    tYlbjTjxx.setRyrq(new Date());
                                    tYlbjTjxx.setCyrq(new Date());
                                }
                            }
                            Date now = new Date();
                            SimpleDateFormat sdf = null;
                            sdf = new SimpleDateFormat("yyyy-MM-dd");
                            tYlbjTjxx.setScrqzjsj(sdf.format(now));
                            tYlbjTjxx.setScrzyksj(sdf.format(now));
                            tYlbjTjxx.setXxrksj(new Date());
                            tYlbjTjxx.setDrsj(new Date());
                        }
                    }
                    tYlbjTjxxService.insert(tYlbjTjxx);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 将停车场信息上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updatePakingToCity", method = RequestMethod.POST )
    public JsonResult updatePakingToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectPaking();
            CarInfoTransfer carInfoTransfer = new CarInfoTransfer();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    carInfoTransfer.setId(id);
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        String xjh = "";
                        String sfzjh = "";
                        String xxbsm = "";
                        String drsj = "";
                        for (int j = 0; j < arr.length; j++) {
                            if (arr[j].indexOf("车牌") != -1) {
                                xxbsm = arr[j].substring(arr[j].indexOf("=") + 1);
                                if (!"".equals(xxbsm)) {
                                    xjh = xxbsm.substring(0, 7);
                                }
                                carInfoTransfer.setJDCHPHM(xjh);
                            }
                            if (arr[j].indexOf("工作站") != -1 || arr[j].indexOf("车场") != -1) {
                                sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                carInfoTransfer.setJCCM(sfzjh);
                            }
                            if (arr[j].indexOf("入场时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
                                    }
                                    Date date = sdf.parse(drsj);
                                    carInfoTransfer.setJC_SJ(date);
                                } catch (Exception e) {
                                    carInfoTransfer.setJC_SJ(new Date());
                                }
                            }
                            if (arr[j].indexOf("出场时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
                                    }
                                    Date date = sdf.parse(drsj);
                                    carInfoTransfer.setCC_SJ(date);
                                } catch (Exception e) {
                                    carInfoTransfer.setCC_SJ(new Date());
                                }
                            }
                        }
                    }
                    carInfoToCityService.insertRMYY(carInfoTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 将会员登记信息上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updateVipToCity", method = RequestMethod.POST )
    public JsonResult updateVipToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        List<StaticFileClass> list = intelligenceImportCityService.selectVip();
        VipInfoToCityTransfer vipInfoToCityTransfer = new VipInfoToCityTransfer();
        int n = 5;
        long id = 0L;
        for (int i = 0; i < n; i++) {
            id = list.get(i).getId();
            vipInfoToCityTransfer.setId(id);
            vipInfoToCityTransfer.setXxzjbh(id);
            if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                vipInfoToCityTransfer.setXm(list.get(i).getName());
            }
            if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                String details = list.get(i).getDetail();
                /*details.contains("电话号码");*/
                String[] arr = details.split(";");
                vipInfoToCityTransfer.setDjdwGajgmc("桐柏县公安局");
                vipInfoToCityTransfer.setDjrXm("付岩峰");
                for (int j = 0; j < arr.length; j++) {
                    String sfzjh = "";
                    String cyxzz = "";
                    String xxmc = "";
                    String xxbsm = "";
                    String hkxz = "";
                    String drsj = "";
                    String tjsj = "";
                    String cyxm = "";
                    int myysl = 0;
                    int bycj1 = 0;


                    if (arr[j].indexOf("汉语拼音") != -1) {
                        xxbsm = arr[j].substring(arr[j].indexOf("=") + 1);
                        vipInfoToCityTransfer.setXmhypy(xxbsm);
                    }
                    if (arr[j].indexOf("手机") != -1 || arr[j].indexOf("电话") != -1) {
                        String lxdh = "";
                        lxdh = arr[j].substring(arr[j].indexOf("=") + 1);
                        if (!"".equals(lxdh)) {
                            vipInfoToCityTransfer.setLxdh(lxdh);
                        } else {
                            vipInfoToCityTransfer.setLxdh("");
                        }
                    }
                    if (arr[j].indexOf("手机") != -1) {
                        String dhhm = "";
                        dhhm = arr[j].substring(arr[j].indexOf("=") + 1);
                        if (!"".equals(dhhm)) {
                            vipInfoToCityTransfer.setLxsj(dhhm);
                        } else {
                            vipInfoToCityTransfer.setLxsj("");
                        }
                    }

                    /*vipInfoToCityTransfer.setCyzjmc("身份证");*/
                    if (arr[j].indexOf("身份证") != -1) {
                        sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                        vipInfoToCityTransfer.setSfzh(sfzjh);
                    }

                    if (arr[j].indexOf("单位名称") != -1) {
                        xxmc = arr[j].substring(arr[j].indexOf("=") + 1);
                        vipInfoToCityTransfer.setBldzdzmc(xxmc);
                    }

                    try {
                        if (arr[j].indexOf("办理时间") != -1 && arr[j].indexOf("年") == -1) {
                            try {
                                drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                SimpleDateFormat sdf = null;
                                if (drsj.contains("-")) {
                                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                } else if (drsj.contains("/")) {
                                    sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                                } else if (drsj.contains(".")) {
                                    sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                                } else {
                                    sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
                                }
                                Date date = sdf.parse(drsj);
                                vipInfoToCityTransfer.setBlsj(date);
                            } catch (Exception e) {
                                vipInfoToCityTransfer.setBlsj(new Date());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                vipInfoToCityTransferService.insertVip(vipInfoToCityTransfer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            intelligenceImportCityService.updateIfUpload(id);
        }
        return JsonResult.ok();
    }

    /**
     * 将出租车轨迹信息上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updateCarGpsToCity", method = RequestMethod.POST )
    public JsonResult updateCarGpsToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectCarGps();
            CarGpsInfoToCityTransfer carGpsInfoToCityTransfer = new CarGpsInfoToCityTransfer();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    carGpsInfoToCityTransfer.setId(id);
                    carGpsInfoToCityTransfer.setXxzjbh(id);
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        carGpsInfoToCityTransfer.setDjdwGajgmc("桐柏县公安局");
                        carGpsInfoToCityTransfer.setDjrXm("付岩峰");
                        for (int j = 0; j < arr.length; j++) {
                            String sfzjh = "";
                            String xxmc = "";
                            String xxbsm = "";
                            String drsj = "";
                            String cyxm = "";
                            if (arr[j].indexOf("车牌号码") != -1) {
                                xxbsm = arr[j].substring(arr[j].indexOf("=") + 1);
                                carGpsInfoToCityTransfer.setCph(xxbsm);
                            }
                            if (arr[j].indexOf("经度") != -1) {
                                sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                carGpsInfoToCityTransfer.setJd(sfzjh);
                            }
                            if (arr[j].indexOf("纬度") != -1) {
                                xxmc = arr[j].substring(arr[j].indexOf("=") + 1);
                                carGpsInfoToCityTransfer.setWd(xxmc);
                            }
                            if (arr[j].indexOf("速度") != -1) {
                                cyxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                carGpsInfoToCityTransfer.setSd(cyxm);
                            }

                            if (arr[j].indexOf("时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                                    } else if (drsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
                                    }
                                    Date date = sdf.parse(drsj);
                                    carGpsInfoToCityTransfer.setDwsj(date);
                                } catch (Exception e) {
                                    carGpsInfoToCityTransfer.setDwsj(new Date());
                                }
                            }
                        }
                    }
                    carGpsInfoToCityTransferService.insertCarGps(carGpsInfoToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 将旅行社接待游客信息上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updateVisitorToCity", method = RequestMethod.POST )
    public JsonResult updateVisitorToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectVisitor();
            VisitorInfoToCityTransfer visitorInfoToCityTransfer = new VisitorInfoToCityTransfer();
            int n = 1;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    visitorInfoToCityTransfer.setId(id);
                    visitorInfoToCityTransfer.setXxzjbh(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        visitorInfoToCityTransfer.setXM(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getIdCardNo()) && list.get(i).getIdCardNo() != null) {
                        visitorInfoToCityTransfer.setSFZH(list.get(i).getIdCardNo());
                    }
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        visitorInfoToCityTransfer.setDjdwGajgmc("桐柏县公安局");
                        visitorInfoToCityTransfer.setDjrXm("付岩峰");
                        for (int j = 0; j < arr.length; j++) {
                            String sfzjh = "";
                            String xxmc = "";
                            String xxbsm = "";
                            String drsj = "";
                            String cyxm = "";
                            String dzmc = "";
                            if (arr[j].indexOf("汉语拼音") != -1) {
                                xxbsm = arr[j].substring(arr[j].indexOf("=") + 1);
                                visitorInfoToCityTransfer.setXMPY(xxbsm);
                            }
                            if (arr[j].indexOf("身份号码") != -1 || arr[j].indexOf("身份") != -1  || arr[j].indexOf("身份证号") != -1) {
                                sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                visitorInfoToCityTransfer.setSFZH(sfzjh);
                            }

                            if (arr[j].indexOf("联系电话") != -1 || arr[j].indexOf("手机号") != -1 || arr[j].indexOf("手机") != -1) {
                                xxmc = arr[j].substring(arr[j].indexOf("=") + 1);
                                visitorInfoToCityTransfer.setLXDH(xxmc);
                            }

                            if (arr[j].indexOf("旅行社名称") != -1 || arr[j].indexOf("旅行社") != -1) {
                                cyxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                visitorInfoToCityTransfer.setLXSMC(cyxm);
                            }
                           /* if (arr[j].indexOf("旅游地") != -1 || arr[j].indexOf("地") != -1 || arr[j].indexOf("目的地") != -1) {
                                dzmc = arr[j].substring(arr[j].indexOf("=") + 1);
                                visitorInfoToCityTransfer.setMDD_DZMC(dzmc);
                            }*/
                            if (arr[j].indexOf("出发时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                                    } else if (drsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
                                    }
                                    Date date = sdf.parse(drsj);
                                    visitorInfoToCityTransfer.setCFSJ(date);
                                } catch (Exception e) {
                                    visitorInfoToCityTransfer.setCFSJ(new Date());
                                }
                            }
                        }
                    }
                    visitorInfoToCityTransferService.insertVisitor(visitorInfoToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 将电动车车辆信息上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updateEconomicalToCity", method = RequestMethod.POST )
    public JsonResult updateEconomicalToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectEconomical();
            EconomicalInfoToCityTransfer economicalInfoToCityTransfer = new EconomicalInfoToCityTransfer();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    economicalInfoToCityTransfer.setId(id);
                    economicalInfoToCityTransfer.setXXZJBH(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        economicalInfoToCityTransfer.setXM(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        economicalInfoToCityTransfer.setGAJGMC("桐柏县公安局");
                        for (int j = 0; j < arr.length; j++) {
                            String xjh = "";
                            String xsxm = "";
                            String sfzjh = "";
                            String xb = "";
                            String xxmc = "";
                            String drsj = "";
                            String cyxm = "";
                            if (arr[j].indexOf("身份证号") != -1 || arr[j].indexOf("身份证") != -1 ) {
                                sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                economicalInfoToCityTransfer.setGMSFHM(sfzjh);
                            }
                            if (arr[j].indexOf("手机") != -1 || arr[j].indexOf("电话") != -1) {
                                xxmc = arr[j].substring(arr[j].indexOf("=") + 1);
                                economicalInfoToCityTransfer.setLXDH(xxmc);
                            }
                            if (arr[j].indexOf("号牌号码") != -1) {
                                cyxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                economicalInfoToCityTransfer.setHPHM(cyxm);
                            }
                            if (arr[j].indexOf("品牌") != -1) {
                                xjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                economicalInfoToCityTransfer.setDDC_PP(xjh);
                            }
                            if (arr[j].indexOf("电动机号") != -1) {
                                xsxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                economicalInfoToCityTransfer.setDDJH(xsxm);
                            }
                            if (arr[j].indexOf("车轮数量") != -1) {
                                xb = arr[j].substring(arr[j].indexOf("=") + 1);
                                economicalInfoToCityTransfer.setCLSL(xb);
                            }
                            if (arr[j].indexOf("购买日期") != -1 || arr[j].indexOf("时间") == -1 ||  arr[j].indexOf("日期") == -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (drsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
                                    }
                                    Date date = sdf.parse(drsj);
                                    economicalInfoToCityTransfer.setGM_RQ(date);
                                } catch (Exception e) {
                                    economicalInfoToCityTransfer.setGM_RQ(new Date());
                                }
                            }
                        }
                    }
                    economicalInfoToCityTransferService.insertEconomical(economicalInfoToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 将燃气缴费信息上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updateGasFeeToCity", method = RequestMethod.POST )
    public JsonResult updateGasFeeToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectGasFee();
            GasFeeInfoToCityTransfer gasFeeInfoToCityTransfer = new GasFeeInfoToCityTransfer();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    gasFeeInfoToCityTransfer.setID(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        gasFeeInfoToCityTransfer.setMETCARDNAME(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        for (int j = 0; j < arr.length; j++) {
                            String xsxm = "";
                            String cyxzz = "";
                            String cyxm = "";
                            String jfje ="";
                            String dz = "";
                            String drsj ="";
                            if (arr[j].indexOf("名称") != -1 || arr[j].indexOf("姓名") != -1) {
                                cyxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                gasFeeInfoToCityTransfer.setMETCARDNAME(cyxm);
                            }
                            if (arr[j].indexOf("用户号") != -1) {
                                xsxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                gasFeeInfoToCityTransfer.setMETCARDNO(xsxm);
                            }
                            if (arr[j].indexOf("用量") != -1) {
                                cyxzz = arr[j].substring(arr[j].indexOf("=") + 1);
                                gasFeeInfoToCityTransfer.setACCOUNT_CUBE(cyxzz);
                            }
                            if (arr[j].indexOf("缴") != -1 || arr[j].indexOf("金额") != -1) {
                                jfje = arr[j].substring(arr[j].indexOf("=") + 1);
                                gasFeeInfoToCityTransfer.setACTUALEARN(jfje);
                            }
                            if(arr[j].indexOf("地址") != -1){
                                dz = arr[j].substring(arr[j].indexOf("=") + 1);
                                gasFeeInfoToCityTransfer.setBALANCE(dz);
                            }
                            if ( arr[j].indexOf("时间") == -1 ||  arr[j].indexOf("日期") == -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (drsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
                                    }
                                    Date date = sdf.parse(drsj);
                                    gasFeeInfoToCityTransfer.setMETERED_TIME(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
                                } catch (Exception e) {
                                    gasFeeInfoToCityTransfer.setMETERED_TIME(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
                                }
                            }
                            Date now = new Date();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
                            String hehe = dateFormat.format(now);
                            gasFeeInfoToCityTransfer.setRZYKSJ(hehe);
                        }
                    }
                    gasFeeInfoToCityTransferService.insertGasFee(gasFeeInfoToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 将电动车轨迹信息上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updateEcoGpsToCity", method = RequestMethod.POST )
    public JsonResult updateEcoGpsToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectEcoGps();
            EcoGpsInfoToCityTransfer ecoGpsInfoToCityTransfer = new EcoGpsInfoToCityTransfer();
            int n = 5;
            long id = 0L;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    ecoGpsInfoToCityTransfer.setId(id);
                    ecoGpsInfoToCityTransfer.setXxzjbh(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        ecoGpsInfoToCityTransfer.setXm(list.get(i).getName());
                    }
                    ecoGpsInfoToCityTransfer.setSsqy("桐柏县");
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        for (int j = 0; j < arr.length; j++) {
                            String xjh = "";
                            String xsxm = "";
                            String sfzjh = "";
                            String cyxzz = "";
                            String drsj = "";
                            String cyxm = "";
                            if (arr[j].indexOf("经度") != -1) {
                                cyxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                ecoGpsInfoToCityTransfer.setJd(cyxm);
                            }

                            if (arr[j].indexOf("纬度") != -1) {
                                xsxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                ecoGpsInfoToCityTransfer.setWd(xsxm);
                            }

                            if (arr[j].indexOf("速度") != -1) {
                                cyxzz = arr[j].substring(arr[j].indexOf("=") + 1);
                                ecoGpsInfoToCityTransfer.setSd(cyxzz);
                            }

                            if (arr[j].indexOf("手机") != -1 || arr[j].indexOf("电话") != -1) {
                                xjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                ecoGpsInfoToCityTransfer.setLxdh(xjh);
                            }
                            if (arr[j].indexOf("身份证") != -1) {
                                sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                ecoGpsInfoToCityTransfer.setGmsfhm(sfzjh);
                            }
                            ecoGpsInfoToCityTransfer.setDjr_xm("付岩峰");
                            ecoGpsInfoToCityTransfer.setDjdw_gajgmc("桐柏县公安局");

                            if (arr[j].indexOf("时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    } else if (drsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd");
                                    }
                                    Date date = sdf.parse(drsj);
                                    ecoGpsInfoToCityTransfer.setDwsj(date);
                                } catch (Exception e) {
                                    ecoGpsInfoToCityTransfer.setDwsj(new Date());
                                }
                            }
                        }
                    }
                    ecoGpsInfoToCityTransferService.insertEcoGps(ecoGpsInfoToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 将快递信息上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updateExpressToCity", method = RequestMethod.POST )
    public JsonResult updateExpressToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectExpress();
            ExpressInfoToCityTransfer expressInfoToCityTransfer = new ExpressInfoToCityTransfer();
            long id = 0L;
            int n = 5;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    expressInfoToCityTransfer.setId(id);
                    expressInfoToCityTransfer.setXXZJBH(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        expressInfoToCityTransfer.setFAHR_XM(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        for (int j = 0; j < arr.length; j++) {
                            String xjh = "";
                            String xsxm = "";
                            String sfzjh = "";
                            String cyxzz = "";
                            String drsj = "";
                            String tjsj = "";
                            String cyxm = "";
                            if (arr[j].indexOf("运单号") != -1) {
                                cyxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                expressInfoToCityTransfer.setWAYBILL_NUM(cyxm);
                            }
                            if (arr[j].indexOf("收件公司") != -1) {
                                xsxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                expressInfoToCityTransfer.setWLZX_DWMC(xsxm);
                            }

                            if (arr[j].indexOf("寄件公司") != -1) {
                                cyxzz = arr[j].substring(arr[j].indexOf("=") + 1);
                                expressInfoToCityTransfer.setWLZGS_DWMC(cyxzz);
                            }
                            if (arr[j].indexOf("手机") != -1 || arr[j].indexOf("电话") != -1) {
                                xjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                expressInfoToCityTransfer.setSHHR_LXDH(xjh);
                            }
                            if (arr[j].indexOf("邮件人-证件号码") != -1) {
                                sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                expressInfoToCityTransfer.setFAHR_ZJHM(sfzjh);
                            }
                            expressInfoToCityTransfer.setDJR_XM("付岩峰");
                            expressInfoToCityTransfer.setDJDW_GAJGMC("桐柏县公安局");
                            if (arr[j].indexOf("发件时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                                    } else if (drsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
                                    }
                                    Date date = sdf.parse(drsj);
                                    expressInfoToCityTransfer.setFHSJ(date);
                                } catch (Exception e) {
                                    expressInfoToCityTransfer.setFHSJ(new Date());
                                }
                            }
                            if (arr[j].indexOf("收货时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    tjsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (tjsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    } else if (tjsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                                    } else if (tjsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
                                    }
                                    Date date1 = sdf.parse(tjsj);
                                    expressInfoToCityTransfer.setSHSJ(date1);
                                } catch (Exception e) {
                                    expressInfoToCityTransfer.setSHSJ(new Date());
                                }
                            }
                        }
                    }
                    expressInfoToCityTransferService.insertExpress(expressInfoToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 将电力用户信息上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updatePowerToCity", method = RequestMethod.POST )
    public JsonResult updatePowerToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectPower();
            MedicalStaticPowerToCityTransfer medicalStaticPowerToCityTransfer = new MedicalStaticPowerToCityTransfer();
            long id = 0L;
            int n = 5;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    medicalStaticPowerToCityTransfer.setID(id);
                    medicalStaticPowerToCityTransfer.setXXZJBH(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        medicalStaticPowerToCityTransfer.setXM(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        for (int j = 0; j < arr.length; j++) {
                            String kh = "";
                            String dh = "";
                            String sfzjh = "";
                            String dz = "";
                            String jfrq = "";
                            if (arr[j].indexOf("卡号") != -1 || arr[j].indexOf("用户号") != -1) {
                                kh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStaticPowerToCityTransfer.setKH_WPBZH(kh);
                            }
                            if (arr[j].indexOf("身") != -1) {
                                sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStaticPowerToCityTransfer.setGMSFHM(sfzjh);
                            }

                            if (arr[j].indexOf("地址") != -1) {
                                dz = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStaticPowerToCityTransfer.setYDDZ(dz);
                            }
                            if (arr[j].indexOf("手机") != -1 || arr[j].indexOf("电话") != -1) {
                                dh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStaticPowerToCityTransfer.setYDDH(dh);
                                medicalStaticPowerToCityTransfer.setFDDBR_YDDH(dh);
                            }
                            medicalStaticPowerToCityTransfer.setDJR_XM("付岩峰");
                            medicalStaticPowerToCityTransfer.setDJDW_GAJGMC("桐柏县公安局");
                            medicalStaticPowerToCityTransfer.setXXRKSJ(new Date());
                            if (arr[j].indexOf("时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    jfrq = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (jfrq.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    } else if (jfrq.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                                    } else if (jfrq.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
                                    }
                                    Date date = sdf.parse(jfrq);
                                    medicalStaticPowerToCityTransfer.setJFRQ(date);
                                } catch (Exception e) {
                                    medicalStaticPowerToCityTransfer.setJFRQ(new Date());
                                }
                            }
                        }
                    }
                    medicalStaticPowerToCityTransferService.insert(medicalStaticPowerToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    /**
     * 将电力缴费信息上传市局数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updatePowerDataToCity", method = RequestMethod.POST )
    public JsonResult updatePowerDataToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectPowerData();
            MedicalStaticPowerDataToCityTransfer medicalStaticPowerDataToCityTransfer = new MedicalStaticPowerDataToCityTransfer();
            long id = 0L;
            int n = 5;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    medicalStaticPowerDataToCityTransfer.setID(id);
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        medicalStaticPowerDataToCityTransfer.setHM(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        for (int j = 0; j < arr.length; j++) {
                            String xm= "";
                            String kh = "";
                            String dh = "";
                            String gddw = "";
                            String jfje = "";
                            String jfrq = "";
                            if (arr[j].indexOf("姓") != -1 || arr[j].indexOf("用户") != -1) {
                                xm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStaticPowerDataToCityTransfer.setHM(xm);
                            }
                            if (arr[j].indexOf("号") != -1 || arr[j].indexOf("卡号") != -1 ) {
                                kh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStaticPowerDataToCityTransfer.setHH(kh);
                            }
                            if (arr[j].indexOf("单位") != -1) {
                                gddw = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStaticPowerDataToCityTransfer.setGDDW(gddw);
                            }

                            if (arr[j].indexOf("地址") != -1) {
                                gddw = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStaticPowerDataToCityTransfer.setGDDW(gddw);
                            }
                            if (arr[j].indexOf("额") != -1) {
                                jfje = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalStaticPowerDataToCityTransfer.setJFJE(jfje);
                            }
                            medicalStaticPowerDataToCityTransfer.setSJLY("桐柏县公安局");
                            medicalStaticPowerDataToCityTransfer.setRKSJ(new Date());
                            if (arr[j].indexOf("时间") != -1 && arr[j].indexOf("年") == -1) {
                                try {
                                    jfrq = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (jfrq.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    } else if (jfrq.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                                    } else if (jfrq.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
                                    }
                                    Date date = sdf.parse(jfrq);
                                    medicalStaticPowerDataToCityTransfer.setJFSJ(date);
                                } catch (Exception e) {
                                    medicalStaticPowerDataToCityTransfer.setJFSJ(new Date());
                                }
                            }
                        }
                    }
                    medicalStaticPowerDataToCityTransferService.insert(medicalStaticPowerDataToCityTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }



    /**
     * 将新生儿信息上传市局数据库
     *
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping( value = "/updateNewbornToCity", method = RequestMethod.POST )
    public JsonResult updateNewbornToCity(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        try {
            List<StaticFileClass> list = intelligenceImportCityService.selectNewborn();
            MedicalNewbornRecordTransfer medicalNewbornRecordTransfer = new MedicalNewbornRecordTransfer();
            long id = 0L;
            int n = 5;
            for (int i = 0; i < n; i++) {
                try {
                    id = list.get(i).getId();
                    if (!Empty.equals(list.get(i).getName()) && list.get(i).getName() != null) {
                        medicalNewbornRecordTransfer.setXM(list.get(i).getName());
                    }
                    if (!Empty.equals(list.get(i).getDetail()) && list.get(i).getDetail() != null) {
                        String details = list.get(i).getDetail();
                        String[] arr = details.split(";");
                        for (int j = 0; j < arr.length; j++) {
                            String xjh = "";
                            String xsxm = "";
                            String sfzjh = "";
                            String xb = "";
                            String cyxzz = "";
                            String xxmc = "";
                            String xxbsm = "";
                            String hkxz = "";
                            String drsj = "";
                            String tjsj = "";
                            String cyxm = "";
                            int myysl = 0;
                            int bycj1 = 0;
                            if (arr[j].indexOf("性别") != -1) {
                                xb = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNewbornRecordTransfer.setXB_DMMS(xb);
                            }
                            if (arr[j].indexOf("母") != -1 && arr[j].indexOf("姓")!= -1) {
                                xsxm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNewbornRecordTransfer.setMQ_XM(xsxm);
                            }

                            if (arr[j].indexOf("父") != -1&& arr[j].indexOf("姓")!= -1) {
                                cyxzz = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNewbornRecordTransfer.setFQ_XM(cyxzz);
                            }
                            if (arr[j].indexOf("母") != -1 && arr[j].indexOf("民")!= -1) {
                                hkxz = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNewbornRecordTransfer.setMQ_MZ_DMMS(hkxz);
                            }

                            if (arr[j].indexOf("父") != -1&& arr[j].indexOf("民")!= -1) {
                                tjsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNewbornRecordTransfer.setMQ_MZ_DMMS(tjsj);
                            }
                            if ((arr[j].indexOf("母") != -1 && arr[j].indexOf("手机") != -1) || (arr[j].indexOf("母") != -1 && arr[j].indexOf("手机") != -1)){
                                xjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNewbornRecordTransfer.setMQ_LXDH(xjh);
                            }
                            if ((arr[j].indexOf("父") != -1 && arr[j].indexOf("手机") != -1) || (arr[j].indexOf("父") != -1 && arr[j].indexOf("手机") != -1)){
                                sfzjh = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNewbornRecordTransfer.setFQ_LXDH(sfzjh);
                            }
                            if ((arr[j].indexOf("母") != -1 && arr[j].indexOf("身份") != -1) ){
                                xxmc = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNewbornRecordTransfer.setMQ_GMSFZH(xxmc);
                            }
                            if ((arr[j].indexOf("父") != -1 && arr[j].indexOf("身份") != -1)){
                                xxbsm = arr[j].substring(arr[j].indexOf("=") + 1);
                                medicalNewbornRecordTransfer.setFQ_GMSFZH(xxbsm);
                            }
                            medicalNewbornRecordTransfer.setJSJGMC("桐柏县妇幼保健医院");
                            if (arr[j].indexOf("出生时间") != -1 || arr[j].indexOf("出生日期") != -1) {
                                try {
                                    drsj = arr[j].substring(arr[j].indexOf("=") + 1);
                                    SimpleDateFormat sdf = null;
                                    if (drsj.contains("-")) {
                                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                    } else if (drsj.contains("/")) {
                                        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                                    } else if (drsj.contains(".")) {
                                        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                                    } else {
                                        sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
                                    }
                                    Date date = sdf.parse(drsj);
                                    medicalNewbornRecordTransfer.setCSRQ(date);
                                } catch (Exception e) {
                                    medicalNewbornRecordTransfer.setCSRQ(new Date());
                                }
                            }
                        }
                    }
                    medicalNewbornRecordTransferRepository.save(medicalNewbornRecordTransfer);
                    intelligenceImportCityService.updateIfUpload(id);
                } catch (Exception e) {
                    intelligenceImportCityService.updateIfUpload(id);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

}
