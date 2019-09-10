package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalStudentToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalTelevisionToCityTransfer;
import com.yaofei.springmvcmybatis.repository.MedicalTelevisionToCityTransferRepository;
import com.yaofei.springmvcmybatis.service.MedicalTelevisionToCityTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("medicalTelevisionToCityTransferService")
public class MedicalTelevisionToCityTransferServiceImpl extends AbstractBaseService<MedicalTelevisionToCityTransfer> implements MedicalTelevisionToCityTransferService {
	@Autowired
	private MedicalTelevisionToCityTransferRepository medicalTelevisionToCityTransferRepository;

	@Override
	public void insert(MedicalTelevisionToCityTransfer MedicalTelevisionToCityTransfer) {
		medicalTelevisionToCityTransferRepository.insert(MedicalTelevisionToCityTransfer);
	}
}
