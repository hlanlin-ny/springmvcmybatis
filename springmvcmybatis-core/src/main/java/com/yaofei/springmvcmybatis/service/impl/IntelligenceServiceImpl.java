package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.Intelligence;
import com.yaofei.springmvcmybatis.repository.IntelligenceRepository;
import com.yaofei.springmvcmybatis.service.IntelligenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("intelligenceService")
public class IntelligenceServiceImpl extends AbstractBaseService<Intelligence> implements IntelligenceService {
	@Autowired
	private IntelligenceRepository intelligenceRepository;

}
