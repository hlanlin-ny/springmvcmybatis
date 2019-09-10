package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalNewbornRecord;
import com.yaofei.springmvcmybatis.entity.MedicalOutpatientRecord;
import com.yaofei.springmvcmybatis.repository.MedicalNewbornRecordRepository;
import com.yaofei.springmvcmybatis.service.MedicalNewbornRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("medicalNewbornRecordService")
public class MedicalNewbornRecordServiceImpl extends AbstractBaseService<MedicalNewbornRecord> implements MedicalNewbornRecordService {
	@Autowired
	private MedicalNewbornRecordRepository medicalNewbornRecordRepository;


	@Override
	public List<MedicalNewbornRecord> queryListAll(){
		return medicalNewbornRecordRepository.queryListAll();

	}
}
