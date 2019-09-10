package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalOutpatientRecord;
import com.yaofei.springmvcmybatis.entity.MedicalPatientRecord;
import com.yaofei.springmvcmybatis.repository.MedicalPatientRecordRepository;
import com.yaofei.springmvcmybatis.service.MedicalPatientRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("medicalPatientRecordService")
public class MedicalPatientRecordServiceImpl extends AbstractBaseService<MedicalPatientRecord> implements MedicalPatientRecordService {
	@Autowired
	private MedicalPatientRecordRepository medicalPatientRecordRepository;


	@Override
	public List<MedicalPatientRecord> queryListAll(){
		return medicalPatientRecordRepository.queryListAll();

	}
}
