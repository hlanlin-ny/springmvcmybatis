package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.MedicalPatientRecord;

import java.util.List;

/**
 * 医疗机构患者信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-16 11:40:26
 */
public interface MedicalPatientRecordRepository extends BaseRepository<MedicalPatientRecord> {
	List<MedicalPatientRecord> queryListAll();
}
