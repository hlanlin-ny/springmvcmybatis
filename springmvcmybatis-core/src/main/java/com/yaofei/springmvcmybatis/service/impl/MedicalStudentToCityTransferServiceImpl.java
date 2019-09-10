package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalStaticPeopleToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalStudentToCityTransfer;
import com.yaofei.springmvcmybatis.repository.MedicalStudentToCityTransferRepository;
import com.yaofei.springmvcmybatis.service.MedicalStudentToCityTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("medicalStudentToCityTransferService")
public class MedicalStudentToCityTransferServiceImpl extends AbstractBaseService<MedicalStudentToCityTransfer> implements MedicalStudentToCityTransferService {
	@Autowired
	private MedicalStudentToCityTransferRepository medicalStudentToCityTransferRepository;

	@Override
	public void insert(MedicalStudentToCityTransfer medicalStudentToCityTransfer) {
		medicalStudentToCityTransferRepository.insert(medicalStudentToCityTransfer);
	}

}
