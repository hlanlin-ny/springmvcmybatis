package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.IntelligenceImportCity;
import com.yaofei.springmvcmybatis.entity.StaticFileClass;
import com.yaofei.springmvcmybatis.entity.StaticFileToCityTransfer;
import com.yaofei.springmvcmybatis.repository.StaticFileClassRepository;
import com.yaofei.springmvcmybatis.repository.StaticFileToCityRepository;
import com.yaofei.springmvcmybatis.service.StaticFileClassService;
import com.yaofei.springmvcmybatis.service.StaticFileToCityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("staticFileToCityService")
public class StaticFileToCityServiceImpl extends AbstractBaseService<StaticFileToCityTransfer> implements StaticFileToCityService {
	@Autowired
	private StaticFileToCityRepository staticFileToCityRepository;


	@Override
	public void insert(StaticFileToCityTransfer staticFileToCityTransfer) {
		staticFileToCityRepository.insert(staticFileToCityTransfer);
	}
}
