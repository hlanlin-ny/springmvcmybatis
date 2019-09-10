package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalNcmsToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticWaterToCityTransfer;
import com.yaofei.springmvcmybatis.repository.StaticNcmsToCityRepository;
import com.yaofei.springmvcmybatis.repository.StaticWaterToCityRepository;
import com.yaofei.springmvcmybatis.service.StaticNcmsToCityService;
import com.yaofei.springmvcmybatis.service.StaticWaterToCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staticNcmsToCityService")
public class StaticNcmsToCityServiceImpl extends AbstractBaseService<MedicalNcmsToCityTransfer> implements StaticNcmsToCityService {
	@Autowired
	private StaticNcmsToCityRepository staticNcmsToCityRepository;


	@Override
	public void insert(MedicalNcmsToCityTransfer medicalNcmsToCityTransfer) {
		staticNcmsToCityRepository.insert(medicalNcmsToCityTransfer);
	}
}
