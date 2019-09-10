package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.MedicalOutpatientRecord;
import com.yaofei.springmvcmybatis.entity.UpdatingFileClass;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * 医疗门诊信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:38:46
 */
public interface MedicalOutpatientRecordService extends BaseService<MedicalOutpatientRecord> {


    //导出excel表的信息
    HSSFWorkbook exportExcelInfo();
    List<MedicalOutpatientRecord> queryListAll();
    void insertCommon(UpdatingFileClass updatingFileClass);
}
