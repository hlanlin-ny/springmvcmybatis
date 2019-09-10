package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.MedicalNewbornRecord;
import com.yaofei.springmvcmybatis.entity.MedicalOutpatientRecord;

import java.util.List;

/**
 * 新生儿出生信息ZQH-22-113600005
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-16 13:24:29
 */
public interface MedicalNewbornRecordService extends BaseService<MedicalNewbornRecord> {

    List<MedicalNewbornRecord> queryListAll();
}
