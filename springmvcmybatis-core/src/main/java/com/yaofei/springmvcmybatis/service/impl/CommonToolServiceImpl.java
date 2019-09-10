package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.CommonTool;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.CommonToolRepository;
import com.yaofei.springmvcmybatis.service.CommonToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commonToolService")
public class CommonToolServiceImpl extends AbstractBaseService<CommonTool> implements CommonToolService {
    @Autowired
    private CommonToolRepository commonToolRepository;

    @Override
    public List<CommonTool> queryAllByAreaId(Long areaId) {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        Map<String, String> extraSearch = new HashMap<>();
        extraSearch.put("areaId", areaId.toString());
        dataTablesRequest.setExtraSearch(extraSearch);
        dataTablesRequest.setOrderString("id asc");
        return commonToolRepository.queryList(dataTablesRequest);
    }
}
