package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.MedicalCheckinCheckoutRecord;
import com.yaofei.springmvcmybatis.entity.MedicalOutpatientRecord;
import com.yaofei.springmvcmybatis.entity.UpdatingFileClass;

import java.util.List;

/**
 * 医疗门诊信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:38:46
 */
public interface MedicalOutpatientRecordRepository extends BaseRepository<MedicalOutpatientRecord> {

    List<MedicalOutpatientRecord> queryBatch();
    List<MedicalOutpatientRecord> queryListAll();
}
