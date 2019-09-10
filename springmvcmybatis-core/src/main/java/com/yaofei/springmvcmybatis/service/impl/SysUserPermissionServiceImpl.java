package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.SysUserPermission;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.repository.SysUserPermissionRepository;
import com.yaofei.springmvcmybatis.service.SysUserPermissionService;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("sysUserPermissionService")
public class SysUserPermissionServiceImpl extends AbstractBaseService<SysUserPermission> implements SysUserPermissionService {
    @Autowired
    private SysUserPermissionRepository sysUserPermissionRepository;

    @Override
    public List<SysUserPermission> queryNotButtonList() {
        return sysUserPermissionRepository.queryNotButtonList();
    }

    @Override
    public List<SysUserPermission> queryAllNodesOrderByOderNum() {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        dataTablesRequest.setLength(10000);
        dataTablesRequest.setOrderString("order_num ASC,id ASC");
        return baseRepository.queryList(dataTablesRequest);
    }

    @Override
    public Set<String> queryAllPermissionCodes() {
        return sysUserPermissionRepository.queryAllPermissionCodes();
    }

    @Override
    public Set<String> queryPermissionCodesByUserId(Long id) {
        return sysUserPermissionRepository.queryPermissionCodesByUserId(id);
    }

    @Override
    public Map querySysUserPermissionIdNameMap() {
        Map<Long, String> map = new HashMap<>();
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        dataTablesRequest.setLength(10000);
        dataTablesRequest.setOrderString("id asc");
        List<SysUserPermission> sysUserPermissions = baseRepository.queryList(dataTablesRequest);
        for (SysUserPermission sysUserPermission : sysUserPermissions) {
            map.put(sysUserPermission.getId(), sysUserPermission.getName());
        }
        return map;
    }

    @Override
    protected void saveBefore(SysUserPermission sysUserPermission) {
        super.saveBefore(sysUserPermission);
        checkIsPermissionCodeHasExist(sysUserPermission.getPermissionCode(),null);
    }

    @Override
    protected void updateBefore(SysUserPermission sysUserPermission) {
        super.updateBefore(sysUserPermission);
        checkIsPermissionCodeHasExist(sysUserPermission.getPermissionCode(),sysUserPermission.getId());
    }

    /**
     * 检查权限代码是否存在
     */
    private void checkIsPermissionCodeHasExist(String permissionCode, Long id) {
        long count = sysUserPermissionRepository.queryTotalByPermissionAndId(permissionCode, id);
        if (count > 0) {
            throw new BussinessException("权限代码已经存在，请使用其他权限代码！");
        }
    }
}