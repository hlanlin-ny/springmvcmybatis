package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.SysUserRole;
import com.yaofei.springmvcmybatis.entity.SysUserRolePermission;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.repository.SysUserRoleRepository;
import com.yaofei.springmvcmybatis.service.SysUserPermissionService;
import com.yaofei.springmvcmybatis.service.SysUserRolePermissionService;
import com.yaofei.springmvcmybatis.service.SysUserRoleService;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends AbstractBaseService<SysUserRole> implements SysUserRoleService {
    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;
    @Autowired
    private SysUserRolePermissionService sysUserRolePermissionService;
    @Autowired
    private SysUserPermissionService sysUserPermissionService;

    @Override
    public List<SysUserRole> queryListWithCustom(DataTablesRequest dataTablesRequest) {
        //翻译权限代码
        Map<Long, String> sysUserPermissionIdNameMap = sysUserPermissionService.querySysUserPermissionIdNameMap();
        StringBuilder stringBuilder;
        List<SysUserRolePermission> sysUserRolePermissions;
        List<SysUserRole> sysUserRoles = baseRepository.queryList(dataTablesRequest);
        for (SysUserRole sysUserRole : sysUserRoles) {
            stringBuilder = new StringBuilder();
            sysUserRolePermissions = sysUserRolePermissionService.querySysUserRolePermissionsByRoleId(sysUserRole.getId());
            for (SysUserRolePermission sysUserRolePermission : sysUserRolePermissions) {
                if(sysUserPermissionIdNameMap.containsKey(sysUserRolePermission.getUserPermissionId())) {
                    stringBuilder.append(sysUserPermissionIdNameMap.get(sysUserRolePermission.getUserPermissionId()));
                    stringBuilder.append("，");
                }
            }
            if (stringBuilder.length() > 1) {
                String permissionNames = stringBuilder.toString();
                sysUserRole.setPermissionNames(permissionNames.substring(0, permissionNames.length() - 1));
            } else {
                sysUserRole.setPermissionNames("");
            }
        }
        return sysUserRoles;
    }


    @Override
    public List<SysUserRole> queryAllUserRoles() {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        dataTablesRequest.setLength(10000);
        dataTablesRequest.setOrderString("id asc");
        return baseRepository.queryList(dataTablesRequest);
    }

    @Override
    public void saveUserRoleAndPermissions(SysUserRole sysUserRole) {
        // 检查名称是否存在
        checkIsUsernameHasExist(sysUserRole.getName(), null);

        sysUserRoleRepository.save(sysUserRole);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username=SecurityUtils.getSubject().getPrincipal().toString();
        SysUserRolePermission sysUserRolePermission;
        for (Long permissionId : sysUserRole.getPermissionIds()) {
            sysUserRolePermission = new SysUserRolePermission();
            sysUserRolePermission.setUserRoleId(sysUserRole.getId());
            sysUserRolePermission.setUserPermissionId(permissionId);
            sysUserRolePermission.setCreatedBy(username);
            sysUserRolePermission.setCreatedIp(request.getRemoteAddr());
            sysUserRolePermission.setModificationTime(new Date());
            sysUserRolePermission.setModificationBy(username);
            sysUserRolePermission.setModificationIp(request.getRemoteAddr());
            sysUserRolePermissionService.save(sysUserRolePermission);
        }
    }

    /**
     * 检查名称是否存在
     *
     * @param name
     * @param userId
     */
    private void checkIsUsernameHasExist(String name, Long userId) {
        long count = sysUserRoleRepository.queryTotalByNameAndId(name, userId);
        if (count > 0) {
            throw new BussinessException("名称已经存在，请使用其他名称！");
        }
    }

    @Override
    public void updateUserRoleAndPermissions(SysUserRole sysUserRole) {
        // 检查名称是否存在
        checkIsUsernameHasExist(sysUserRole.getName(), sysUserRole.getId());

        sysUserRolePermissionService.deleteByUserRoleId(sysUserRole.getId());
        SysUserRolePermission sysUserRolePermission;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String operatorUsername=SecurityUtils.getSubject().getPrincipal().toString();
        for (Long permissionId : sysUserRole.getPermissionIds()) {
            sysUserRolePermission = new SysUserRolePermission();
            sysUserRolePermission.setUserRoleId(sysUserRole.getId());
            sysUserRolePermission.setUserPermissionId(permissionId);
            sysUserRolePermission.setCreatedBy(operatorUsername);
            sysUserRolePermission.setCreatedIp(request.getRemoteAddr());
            sysUserRolePermission.setModificationTime(new Date());
            sysUserRolePermission.setModificationBy(operatorUsername);
            sysUserRolePermission.setModificationIp(request.getRemoteAddr());

            sysUserRolePermissionService.save(sysUserRolePermission);
        }
        sysUserRoleRepository.update(sysUserRole);
    }

    @Override
    public void deleteUserRoleAndPermissions(Long id) {
        sysUserRolePermissionService.deleteByUserRoleId(id);
        sysUserRoleRepository.delete(id);
    }

    @Override
    public void deleteUserRoleAndPermissionsInBatch(Long[] ids) {
        for (Long id : ids) {
            sysUserRolePermissionService.deleteByUserRoleId(id);
        }
        sysUserRoleRepository.deleteBatch(ids);
    }

    @Override
    public Set<String> queryAllRoleCodes() {
        return sysUserRoleRepository.queryAllRoleCodes();
    }

    @Override
    public Set<String> queryRoleCodesByUserId(Long id) {
        return sysUserRoleRepository.queryRoleCodesByUserId(id);
    }

    @Override
    public Map querySysUserRoleIdNameMap() {
        Map<Long, String> map = new HashMap<>();
        List<SysUserRole> sysUserRoles = queryAllUserRoles();
        for (SysUserRole sysUserRole : sysUserRoles) {
            map.put(sysUserRole.getId(), sysUserRole.getName());
        }
        return map;
    }
}
