package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.MedicalNewbornRecord;
import com.yaofei.springmvcmybatis.entity.MedicalPatientRecord;

import java.util.List;

/**
 * 医疗机构患者信息ZQH-22-113600001
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-16 11:40:26
 */
public interface MedicalPatientRecordService extends BaseService<MedicalPatientRecord> {

    List<MedicalPatientRecord> queryListAll();
}
