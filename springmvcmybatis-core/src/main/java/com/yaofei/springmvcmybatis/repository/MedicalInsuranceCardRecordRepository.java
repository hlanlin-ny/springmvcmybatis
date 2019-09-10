package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.MedicalInsuranceCardRecord;

import java.util.List;

/**
 * 医保刷卡记录信息ZQH-22-143600002
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-16 11:40:38
 */
public interface MedicalInsuranceCardRecordRepository extends BaseRepository<MedicalInsuranceCardRecord> {
	List<MedicalInsuranceCardRecord> queryListAll();
}
