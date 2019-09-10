package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.SysUserRolePermission;
import com.yaofei.springmvcmybatis.repository.SysUserRolePermissionRepository;
import com.yaofei.springmvcmybatis.service.SysUserRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysUserRolePermissionService")
public class SysUserRolePermissionServiceImpl  extends AbstractBaseService<SysUserRolePermission> implements SysUserRolePermissionService {
	@Autowired
	private SysUserRolePermissionRepository sysUserRolePermissionRepository;

	@Override
	public List<SysUserRolePermission> querySysUserRolePermissionsByRoleId(Long userRoleId) {
		return sysUserRolePermissionRepository.querySysUserRolePermissionsByRoleId(userRoleId);
	}

	@Override
	public void deleteByUserRoleId(Long userRoleId) {
		sysUserRolePermissionRepository.deleteByUserRoleId(userRoleId);
	}
}
