package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.MedicalCheckinCheckoutRecord;
import com.yaofei.springmvcmybatis.entity.UpdatingFileClass;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * 医疗住（出）院信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:39:28
 */
public interface MedicalCheckinCheckoutRecordService extends BaseService<MedicalCheckinCheckoutRecord> {

    //导出excel表的信息
    HSSFWorkbook exportExcelInfo();
    List<MedicalCheckinCheckoutRecord> queryListAll();
    void insertCommon(UpdatingFileClass updatingFileClass);

}
