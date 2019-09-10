package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.IntelligenceOfficer;
import com.yaofei.springmvcmybatis.repository.IntelligenceOfficerRepository;
import com.yaofei.springmvcmybatis.service.IntelligenceOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("intelligenceOfficerService")
public class IntelligenceOfficerServiceImpl extends AbstractBaseService<IntelligenceOfficer> implements IntelligenceOfficerService {
	@Autowired
	private IntelligenceOfficerRepository intelligenceOfficerRepository;


	@Override
	public List<IntelligenceOfficer> queryOfficerNames(String areaId) {
		return intelligenceOfficerRepository.queryOfficerNames(areaId);
	}
}
