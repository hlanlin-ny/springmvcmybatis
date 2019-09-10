package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalInsuranceCardRecord;
import com.yaofei.springmvcmybatis.entity.MedicalNewbornRecord;
import com.yaofei.springmvcmybatis.repository.MedicalInsuranceCardRecordRepository;
import com.yaofei.springmvcmybatis.service.MedicalInsuranceCardRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("medicalInsuranceCardRecordService")
public class MedicalInsuranceCardRecordServiceImpl extends AbstractBaseService<MedicalInsuranceCardRecord> implements MedicalInsuranceCardRecordService {
	@Autowired
	private MedicalInsuranceCardRecordRepository medicalInsuranceCardRecordRepository;

	@Override
	public List<MedicalInsuranceCardRecord> queryListAll(){
		return medicalInsuranceCardRecordRepository.queryListAll();

	}
}
