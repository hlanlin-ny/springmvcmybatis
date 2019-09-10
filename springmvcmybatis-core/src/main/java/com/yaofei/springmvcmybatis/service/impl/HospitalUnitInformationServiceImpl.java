package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.HospitalUnitInformation;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.HospitalUnitInformationRepository;
import com.yaofei.springmvcmybatis.service.HospitalUnitInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("hospitalUnitInformationService")
public class HospitalUnitInformationServiceImpl extends AbstractBaseService<HospitalUnitInformation> implements HospitalUnitInformationService {
	@Autowired
	private HospitalUnitInformationRepository hospitalUnitInformationRepository;


	@Override
	public List<HospitalUnitInformation> queryHospitalByAreaId(Long areaId) {
		DataTablesRequest dataTablesRequest = new DataTablesRequest();
		Map<String, String> extraSearch = new HashMap<>();
		if (areaId != null) {
			extraSearch.put("areaId", areaId.toString());
		}
		dataTablesRequest.setExtraSearch(extraSearch);
		dataTablesRequest.setLength(10000);
		dataTablesRequest.setOrderString("id asc");
		return hospitalUnitInformationRepository.queryList(dataTablesRequest);
	}

}
