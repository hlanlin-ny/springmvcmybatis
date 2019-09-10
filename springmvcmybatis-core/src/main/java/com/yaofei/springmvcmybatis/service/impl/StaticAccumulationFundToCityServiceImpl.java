package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalAccumulationFundToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalNcmsToCityTransfer;
import com.yaofei.springmvcmybatis.repository.StaticAccumulationFundToCityRepository;
import com.yaofei.springmvcmybatis.repository.StaticNcmsToCityRepository;
import com.yaofei.springmvcmybatis.service.StaticAccumulationFundToCityService;
import com.yaofei.springmvcmybatis.service.StaticNcmsToCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staticAccumulationFundToCityService")
public class StaticAccumulationFundToCityServiceImpl extends AbstractBaseService<MedicalAccumulationFundToCityTransfer> implements StaticAccumulationFundToCityService {
	@Autowired
	private StaticAccumulationFundToCityRepository staticAccumulationFundToCityRepository;


	@Override
	public void insert(MedicalAccumulationFundToCityTransfer medicalAccumulationFundToCityTransfer) {
		staticAccumulationFundToCityRepository.insert(medicalAccumulationFundToCityTransfer);
	}
}
