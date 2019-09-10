package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.FileStaticClass;
import com.yaofei.springmvcmybatis.entity.UpdatingFileClass;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.FileStaticCountRepository;
import com.yaofei.springmvcmybatis.repository.UpdatingFileCountRepository;
import com.yaofei.springmvcmybatis.service.FileStaticCountService;
import com.yaofei.springmvcmybatis.service.UpdatingFileCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("updatingFileCountService")
public class UpdatingFileCountServiceImpl extends AbstractBaseService<UpdatingFileClass> implements UpdatingFileCountService {
	@Autowired
	private UpdatingFileCountRepository updatingFileCountRepository;


	@Override
	public List<UpdatingFileClass> queryCount(DataTablesRequest dataTablesRequest) {
		return updatingFileCountRepository.queryCount(dataTablesRequest);
	}
	@Override
	public List<UpdatingFileClass> querySum(DataTablesRequest dataTablesRequest) {
		return updatingFileCountRepository.querySum(dataTablesRequest);
	}
}
