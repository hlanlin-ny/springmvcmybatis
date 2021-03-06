package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalStaticPowerDataToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalStudentToCityTransfer;
import com.yaofei.springmvcmybatis.repository.MedicalStaticPowerDataToCityTransferRepository;
import com.yaofei.springmvcmybatis.repository.MedicalStudentToCityTransferRepository;
import com.yaofei.springmvcmybatis.service.MedicalStaticPowerDataToCityTransferService;
import com.yaofei.springmvcmybatis.service.MedicalStudentToCityTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("medicalStaticPowerDataToCityTransferService")
public class MedicalStaticPowerDataToCityTransferServiceImpl extends AbstractBaseService<MedicalStaticPowerDataToCityTransfer> implements MedicalStaticPowerDataToCityTransferService {
	@Autowired
	private MedicalStaticPowerDataToCityTransferRepository medicalStaticPowerDataToCityTransferRepository;

	@Override
	public void insert(MedicalStaticPowerDataToCityTransfer medicalStaticPowerDataToCityTransfer) {
		medicalStaticPowerDataToCityTransferRepository.insert(medicalStaticPowerDataToCityTransfer);
	}

}
