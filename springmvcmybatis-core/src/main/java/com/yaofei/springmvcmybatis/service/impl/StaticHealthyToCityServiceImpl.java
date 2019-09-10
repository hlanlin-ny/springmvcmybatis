package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.StaticHealthyToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticWaterToCityTransfer;
import com.yaofei.springmvcmybatis.repository.StaticHealthyToCityRepository;
import com.yaofei.springmvcmybatis.repository.StaticWaterToCityRepository;
import com.yaofei.springmvcmybatis.service.StaticHealthyToCityService;
import com.yaofei.springmvcmybatis.service.StaticWaterToCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staticHealthyToCityService")
public class StaticHealthyToCityServiceImpl extends AbstractBaseService<StaticHealthyToCityTransfer> implements StaticHealthyToCityService {
	@Autowired
	private StaticHealthyToCityRepository staticHealthyToCityRepository;


	@Override
	public void insert(StaticHealthyToCityTransfer staticHealthyToCityTransfer) {
		staticHealthyToCityRepository.insert(staticHealthyToCityTransfer);
	}
}
