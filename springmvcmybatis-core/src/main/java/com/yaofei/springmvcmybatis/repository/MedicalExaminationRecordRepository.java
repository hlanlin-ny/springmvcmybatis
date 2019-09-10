package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.MedicalExaminationRecord;

import java.util.List;

/**
 * 医疗体检信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:40:13
 */
public interface MedicalExaminationRecordRepository extends BaseRepository<MedicalExaminationRecord> {

    List<MedicalExaminationRecord> queryBatch();

}
