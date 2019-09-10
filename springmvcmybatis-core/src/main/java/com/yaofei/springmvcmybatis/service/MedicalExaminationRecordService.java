package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.MedicalExaminationRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 医疗体检信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:40:13
 */
public interface MedicalExaminationRecordService extends BaseService<MedicalExaminationRecord> {

    //导出excel表的信息
    HSSFWorkbook exportExcelInfo();
}
