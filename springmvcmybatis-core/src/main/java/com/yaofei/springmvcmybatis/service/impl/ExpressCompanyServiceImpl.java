package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.ExpressCompany;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.ExpressCompanyRepository;
import com.yaofei.springmvcmybatis.service.ExpressCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("expressCompanyService")
public class ExpressCompanyServiceImpl extends AbstractBaseService<ExpressCompany> implements ExpressCompanyService {
	@Autowired
	private ExpressCompanyRepository expressCompanyRepository;

	@Override
	public List<ExpressCompany> queryExpressCompanysByAreaId(Long areaId) {
		DataTablesRequest dataTablesRequest = new DataTablesRequest();
		Map<String, String> extraSearch = new HashMap<>();
		if (areaId != null) {
			extraSearch.put("areaId", areaId.toString());
		}
		dataTablesRequest.setExtraSearch(extraSearch);
		dataTablesRequest.setLength(10000);
		dataTablesRequest.setOrderString("id asc");
		return expressCompanyRepository.queryList(dataTablesRequest);
	}
}
