package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.LogisticsCompany;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.LogisticsCompanyRepository;
import com.yaofei.springmvcmybatis.service.LogisticsCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("logisticsCompanyService")
public class LogisticsCompanyServiceImpl extends AbstractBaseService<LogisticsCompany> implements LogisticsCompanyService {
	@Autowired
	private LogisticsCompanyRepository logisticsCompanyRepository;

	@Override
	public List<LogisticsCompany> queryLogisticsCompanysByAreaId(Long areaId) {
		DataTablesRequest dataTablesRequest = new DataTablesRequest();
		Map<String, String> extraSearch = new HashMap<>();
		if (areaId != null) {
			extraSearch.put("areaId", areaId.toString());
		}
		dataTablesRequest.setExtraSearch(extraSearch);
		dataTablesRequest.setLength(10000);
		dataTablesRequest.setOrderString("id asc");
		return logisticsCompanyRepository.queryList(dataTablesRequest);
	}
}
