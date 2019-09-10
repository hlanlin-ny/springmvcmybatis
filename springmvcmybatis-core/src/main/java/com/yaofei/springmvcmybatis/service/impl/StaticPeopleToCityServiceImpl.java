package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.MedicalNcmsToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalStaticPeopleToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticTrifficPeopleToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticWaterToCityTransfer;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.StaticPeopleToCityRepository;
import com.yaofei.springmvcmybatis.repository.StaticWaterToCityRepository;
import com.yaofei.springmvcmybatis.service.StaticPeopleToCityService;
import com.yaofei.springmvcmybatis.service.StaticWaterToCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("staticPeopleToCityService")
public class StaticPeopleToCityServiceImpl extends AbstractBaseService<MedicalStaticPeopleToCityTransfer> implements StaticPeopleToCityService {
	@Autowired
	private StaticPeopleToCityRepository staticPeopleToCityRepository;


	@Override
	public void insert(MedicalStaticPeopleToCityTransfer medicalStaticPeopleToCityTransfer) {
		staticPeopleToCityRepository.insert(medicalStaticPeopleToCityTransfer);
	}

	@Override
	public List<MedicalStaticPeopleToCityTransfer> queryListPeople(DataTablesRequest dataTablesRequest) {
		return staticPeopleToCityRepository.queryList(dataTablesRequest);
	}
}
