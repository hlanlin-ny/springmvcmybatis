package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.FileStaticClass;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.FileStaticCountRepository;
import com.yaofei.springmvcmybatis.service.FileStaticCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fileStaticCountService")
public class FileStaticCountServiceImpl extends AbstractBaseService<FileStaticClass> implements FileStaticCountService {
	@Autowired
	private FileStaticCountRepository staticFileCountRepository;


	@Override
	public List<FileStaticClass> queryCount(DataTablesRequest dataTablesRequest) {
		return staticFileCountRepository.queryCount(dataTablesRequest);
	}
	@Override
	public List<FileStaticClass> querySum(DataTablesRequest dataTablesRequest) {
		return staticFileCountRepository.querySum(dataTablesRequest);
	}
}
