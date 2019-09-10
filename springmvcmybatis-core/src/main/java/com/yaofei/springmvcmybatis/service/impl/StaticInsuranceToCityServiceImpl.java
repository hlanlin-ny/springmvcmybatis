package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalInsuranceToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalNcmsToCityTransfer;
import com.yaofei.springmvcmybatis.repository.StaticInsuranceToCityRepository;
import com.yaofei.springmvcmybatis.repository.StaticNcmsToCityRepository;
import com.yaofei.springmvcmybatis.service.StaticInsuranceToCityService;
import com.yaofei.springmvcmybatis.service.StaticNcmsToCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staticInsuranceToCityService")
public class StaticInsuranceToCityServiceImpl extends AbstractBaseService<MedicalInsuranceToCityTransfer> implements StaticInsuranceToCityService {
	@Autowired
	private StaticInsuranceToCityRepository staticInsuranceToCityRepository;


	@Override
	public void insert(MedicalInsuranceToCityTransfer medicalInsuranceToCityTransfer) {
		staticInsuranceToCityRepository.insert(medicalInsuranceToCityTransfer);
	}
}
