package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.StaticFileClass;
import com.yaofei.springmvcmybatis.repository.StaticFileClassRepository;
import com.yaofei.springmvcmybatis.service.StaticFileClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("staticFileClassService")
public class StaticFileClassServiceImpl extends AbstractBaseService<StaticFileClass> implements StaticFileClassService {
	@Autowired
	private StaticFileClassRepository staticFileClassRepository;


	@Override
	public void saveAll(List<StaticFileClass> staticFileClass) {
		staticFileClassRepository.saveAll(staticFileClass);
	}

	@Override
	public void updateAll(List<StaticFileClass> staticFileClass) {
		staticFileClassRepository.updateAll(staticFileClass);
	}
}
