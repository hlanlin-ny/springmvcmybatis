package com.yaofei.springmvcmybatis.task.quartz;

import com.yaofei.springmvcmybatis.dto.es.EsSearchResult;
import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;
import com.yaofei.springmvcmybatis.entity.*;
import com.yaofei.springmvcmybatis.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 87796 on 2017/9/20.
 */
@Component("importantPersonSearchJob")
public class ImportantPersonScheduleJob {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ImportantPersonService importantPersonService;

    @Autowired
    private ActivityDetailService activityDetailService;

    @Autowired
    private WarningDispostionService warningDispostionService;

    @Autowired
    private SearchService searchService;
    @Autowired
    private IntelligenceBusinessTypeService intelligenceBusinessTypeService;

    public void query(String param) {
        try {
            String[] params = param.split(":");
            if (params != null && params.length >= 6 && StringUtils.isNotBlank(params[1].trim())) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH;mm:ss");
                //查询搜索结果   通过姓名和身份证
                List<MedicalCheckinCheckoutRecordTransfer> medicalCheckinCheckoutRecordTransfer = searchService.selectMarder(params[1], params[0]);
                /*EsSearchResult esSearchResult = searchService.querySearchResultNow(1, null, params[1],
                        true, 1, 10, Long.valueOf(params[4]), Long.valueOf(params[2]), params[3], null, null, null);*/
                if (medicalCheckinCheckoutRecordTransfer.size() != 0) {//说明找到了相关数据
                    Long id = Long.valueOf(params[5]);//重点人员id
                    ImportantPerson importantPerson = importantPersonService.queryObject(id);
                   /* List<CommonIndex> commonIndexes = esSearchResult.getHitDatas();*/
                    for (MedicalCheckinCheckoutRecordTransfer commonIndex : medicalCheckinCheckoutRecordTransfer) {
                        ActivityDetail activityDetail = activityDetailService.queryAlikeByImportant(commonIndex.getYyDwmc(), importantPerson.getName());
                        if (activityDetail != null) {
                            return;
                        } else {
                            warning(commonIndex, importantPerson);//开始预警
                        }
                    }
                } else {//说明没有在搜索引擎上查找到相关数据
                    //logger.info("没有" + importantPerson.getName() + "的相关活动信息，当前时间为：" + simpleDateFormat.format(new Date()));
                    List<MedicalOutpatientRecordTransfer> medicalPatientRecordTransfer = searchService.selectPatient(params[1], params[0]);
                    Long id = Long.valueOf(params[5]);//重点人员id
                    ImportantPerson importantPerson = importantPersonService.queryObject(id);
                    /* List<CommonIndex> commonIndexes = esSearchResult.getHitDatas();*/
                    for (MedicalOutpatientRecordTransfer commonIndex : medicalPatientRecordTransfer) {
                        ActivityDetail activityDetail = activityDetailService.queryAlikeByImportant(commonIndex.getYyDwmc(), importantPerson.getName());
                        if (activityDetail != null) {
                            return;
                        } else {
                            warning1(commonIndex, importantPerson);//开始预警
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
    }

    public void warning(MedicalCheckinCheckoutRecordTransfer commonIndex, ImportantPerson importantPerson) {
        ActivityDetail activityDetail = new ActivityDetail();
        activityDetail.setAreaId(commonIndex.getAreaId());
        activityDetail.setAreaName("桐柏县");
        activityDetail.setRelateImportantId(importantPerson.getId());
        activityDetail.setOccurTime(commonIndex.getCollectTime());//收集时间也就是发生时间
        activityDetail.setProviderAddress(commonIndex.getYyDwmc());//活动发生地
        activityDetail.setInformationProvider(commonIndex.getYyDwmc());//信息提供单位
        activityDetail.setPoliceOffice("桐柏县公安局");//所属公安机关
        activityDetail.setActivityInformation(commonIndex.getHospitalizationDepartment());//活动发生详情
        activityDetail.setRegisterName(importantPerson.getName());//登记人姓名
        activityDetail.setRegisterIDcardNo(importantPerson.getIdCardNo());//登记人身份证号
        activityDetail.setRegisterBornDate(importantPerson.getBornTime());//登记人出生日期
        IntelligenceBusinessType intelligenceBusinessType = intelligenceBusinessTypeService.queryBusinessTypeName(3L);
        activityDetail.setDynamicInformationType(intelligenceBusinessType.getName());//业务类型 也就是动态信息类别
        activityDetail.setDynamicInformationProvider(commonIndex.getYyDwmc());//动态信息提供单位
        activityDetail.setAcceptProvider(importantPerson.getControlUnit());
        activityDetail.setWarningTime(new Date());
        activityDetail.setCreatedBy(importantPerson.getCreatedBy());
        activityDetail.setCreatedIp(importantPerson.getCreatedIp());
        activityDetail.setClaimStatus("未签收");
        activityDetailService.save(activityDetail);
        WarningDispostion warningDispostion = new WarningDispostion();
        warningDispostion.setName(importantPerson.getName());
        warningDispostion.setIdCardNo(importantPerson.getIdCardNo());
        warningDispostion.setWarningPersonType(importantPerson.getPersonType());
        warningDispostion.setWarningTime(new Date());
        warningDispostion.setInformationType(intelligenceBusinessType.getName());
        warningDispostion.setIssueProvider(importantPerson.getControlPersonUnit());
        warningDispostion.setInformationProvider(commonIndex.getYyDwmc());
        warningDispostion.setProviderAddress(commonIndex.getYyDwmc());
        warningDispostion.setPoliceOffice("桐柏县公安局");
        warningDispostion.setAcceptProvider(importantPerson.getControlUnit());
        warningDispostion.setDispositionStatus("未处置");
        warningDispostion.setFeedBackStatus("未反馈");
        warningDispostion.setClaimStatus("未签收");
        warningDispostion.setCreatedBy(importantPerson.getCreatedBy());
        warningDispostion.setCreatedIp(importantPerson.getCreatedIp());
        warningDispostion.setRelateId(activityDetail.getId());
        warningDispostionService.save(warningDispostion);
    }

    public void warning1(MedicalOutpatientRecordTransfer commonIndex, ImportantPerson importantPerson) {
        ActivityDetail activityDetail = new ActivityDetail();
        activityDetail.setAreaId(commonIndex.getAreaId());
        activityDetail.setAreaName("桐柏县");
        activityDetail.setRelateImportantId(importantPerson.getId());
        activityDetail.setOccurTime(commonIndex.getCollectTime());//收集时间也就是发生时间
        activityDetail.setProviderAddress(commonIndex.getYyDwmc());//活动发生地
        activityDetail.setInformationProvider(commonIndex.getYyDwmc());//信息提供单位
        activityDetail.setPoliceOffice("桐柏县公安局");//所属公安机关
        activityDetail.setActivityInformation(commonIndex.getDiagnoseDepartment());//活动发生详情
        activityDetail.setRegisterName(importantPerson.getName());//登记人姓名
        activityDetail.setRegisterIDcardNo(importantPerson.getIdCardNo());//登记人身份证号
        activityDetail.setRegisterBornDate(importantPerson.getBornTime());//登记人出生日期
        IntelligenceBusinessType intelligenceBusinessType = intelligenceBusinessTypeService.queryBusinessTypeName(2L);
        activityDetail.setDynamicInformationType(intelligenceBusinessType.getName());//业务类型 也就是动态信息类别
        activityDetail.setDynamicInformationProvider(commonIndex.getYyDwmc());//动态信息提供单位
        activityDetail.setAcceptProvider(importantPerson.getControlUnit());
        activityDetail.setWarningTime(new Date());
        activityDetail.setCreatedBy(importantPerson.getCreatedBy());
        activityDetail.setCreatedIp(importantPerson.getCreatedIp());
        activityDetail.setClaimStatus("未签收");
        activityDetailService.save(activityDetail);
        WarningDispostion warningDispostion = new WarningDispostion();
        warningDispostion.setName(importantPerson.getName());
        warningDispostion.setIdCardNo(importantPerson.getIdCardNo());
        warningDispostion.setWarningPersonType(importantPerson.getPersonType());
        warningDispostion.setWarningTime(new Date());
        warningDispostion.setInformationType(intelligenceBusinessType.getName());
        warningDispostion.setIssueProvider(importantPerson.getControlPersonUnit());
        warningDispostion.setInformationProvider(commonIndex.getYyDwmc());
        warningDispostion.setProviderAddress(commonIndex.getYyDwmc());
        warningDispostion.setPoliceOffice("桐柏县公安局");
        warningDispostion.setAcceptProvider(importantPerson.getControlUnit());
        warningDispostion.setDispositionStatus("未处置");
        warningDispostion.setFeedBackStatus("未反馈");
        warningDispostion.setClaimStatus("未签收");
        warningDispostion.setCreatedBy(importantPerson.getCreatedBy());
        warningDispostion.setCreatedIp(importantPerson.getCreatedIp());
        warningDispostion.setRelateId(activityDetail.getId());
        warningDispostionService.save(warningDispostion);
    }
}






