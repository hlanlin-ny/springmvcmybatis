package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.IntelligenceBusinessType;
import com.yaofei.springmvcmybatis.entity.SysArea;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.SysAreaRepository;
import com.yaofei.springmvcmybatis.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysAreaService")
public class SysAreaServiceImpl extends AbstractBaseService<SysArea> implements SysAreaService {
    @Autowired
    private SysAreaRepository sysAreaRepository;

    @Override
    public List<SysArea> queryListOrderByOrderNum() {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        dataTablesRequest.setLength(10000);
        dataTablesRequest.setOrderString("order_num ASC,id DESC");
        return baseRepository.queryList(dataTablesRequest);
    }

    @Override
    public Map querySysAreaIdNameMap() {
        Map<Long, String> map = new HashMap<>();
        map.put(0L, "中国");
        List<SysArea> sysUserDepartments = queryListOrderByOrderNum();
        for (SysArea sysArea : sysUserDepartments) {
            map.put(sysArea.getId(), sysArea.getName());
        }
        return map;
    }

    @Override
    public String getParentString(Long areaId) {
        List<SysArea> sysAreas = sysAreaRepository.getParentList(areaId);
        String parentString = "";
        for (SysArea sysArea : sysAreas) {
            parentString += sysArea.getName() + " > ";
        }
        if (parentString.length() > 3) {
            parentString = parentString.substring(0, parentString.length() - 3);
        }
        return parentString;
    }
}
