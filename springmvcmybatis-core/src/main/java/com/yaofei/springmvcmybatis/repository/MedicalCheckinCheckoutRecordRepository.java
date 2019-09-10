package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.MedicalCheckinCheckoutRecord;
import com.yaofei.springmvcmybatis.entity.UpdatingFileClass;

import java.util.List;

/**
 * 医疗住（出）院信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:39:28
 */
public interface MedicalCheckinCheckoutRecordRepository extends BaseRepository<MedicalCheckinCheckoutRecord> {

    List<MedicalCheckinCheckoutRecord> queryBatch();
    List<MedicalCheckinCheckoutRecord> queryListAll();

    void insertCommon(UpdatingFileClass updatingFileClass);
}
