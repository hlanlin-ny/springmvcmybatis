package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.IntelligenceStatistics;
import com.yaofei.springmvcmybatis.repository.IntelligenceStatisticsRepository;
import com.yaofei.springmvcmybatis.service.IntelligenceStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("intelligenceStatisticsService")
public class IntelligenceServiceStatisticsImpl extends AbstractBaseService<IntelligenceStatistics> implements IntelligenceStatisticsService {
	@Autowired
	private IntelligenceStatisticsRepository intelligenceStatisticsRepository;

}
