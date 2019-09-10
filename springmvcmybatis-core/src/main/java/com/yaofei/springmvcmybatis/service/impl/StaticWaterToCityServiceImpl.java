package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalStaticWaterToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticFileToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticWaterToCityTransfer;
import com.yaofei.springmvcmybatis.repository.StaticFileToCityRepository;
import com.yaofei.springmvcmybatis.repository.StaticWaterToCityRepository;
import com.yaofei.springmvcmybatis.service.StaticFileToCityService;
import com.yaofei.springmvcmybatis.service.StaticWaterToCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staticWaterToCityService")
public class StaticWaterToCityServiceImpl extends AbstractBaseService<MedicalStaticWaterToCityTransfer> implements StaticWaterToCityService {
	@Autowired
	private StaticWaterToCityRepository staticWaterToCityRepository;


	@Override
	public void insert(MedicalStaticWaterToCityTransfer medicalStaticWaterToCityTransfer) {
		staticWaterToCityRepository.insert(medicalStaticWaterToCityTransfer);
	}
}
