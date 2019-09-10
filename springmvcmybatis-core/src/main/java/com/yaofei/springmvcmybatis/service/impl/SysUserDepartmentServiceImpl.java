package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.SysUserDepartment;
import com.yaofei.springmvcmybatis.repository.SysUserDepartmentRepository;
import com.yaofei.springmvcmybatis.service.SysUserDepartmentService;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysUserDepartmentService")
public class SysUserDepartmentServiceImpl extends AbstractBaseService<SysUserDepartment> implements SysUserDepartmentService {
    @Autowired
    private SysUserDepartmentRepository sysUserDepartmentRepository;

    @Override
    public List<SysUserDepartment> queryListOrderByOrderNum() {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        dataTablesRequest.setLength(10000);
        dataTablesRequest.setOrderString("order_num ASC,id DESC");
        return baseRepository.queryList(dataTablesRequest);
    }

    @Override
    public Map querySysUserDepartmentIdNameMap() {
        Map<Long, String> map = new HashMap<>();
        List<SysUserDepartment> sysUserDepartments = queryListOrderByOrderNum();
        for (SysUserDepartment sysUserDepartment : sysUserDepartments) {
            map.put(sysUserDepartment.getId(), sysUserDepartment.getName());
        }
        return map;
    }
}