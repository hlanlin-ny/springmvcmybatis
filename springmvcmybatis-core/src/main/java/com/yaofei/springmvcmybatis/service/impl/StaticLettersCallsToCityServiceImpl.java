package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalLettersCallsToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalNcmsToCityTransfer;
import com.yaofei.springmvcmybatis.repository.StaticLettersCallsToCityRepository;
import com.yaofei.springmvcmybatis.repository.StaticNcmsToCityRepository;
import com.yaofei.springmvcmybatis.service.StaticLettersCallsToCityService;
import com.yaofei.springmvcmybatis.service.StaticNcmsToCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staticLettersCallsToCityService")
public class StaticLettersCallsToCityServiceImpl extends AbstractBaseService<MedicalLettersCallsToCityTransfer> implements StaticLettersCallsToCityService {
	@Autowired
	private StaticLettersCallsToCityRepository staticLettersCallsToCityRepository;


	@Override
	public void insert(MedicalLettersCallsToCityTransfer medicalLettersCallsToCityTransfer) {
		staticLettersCallsToCityRepository.insert(medicalLettersCallsToCityTransfer);
	}
}
