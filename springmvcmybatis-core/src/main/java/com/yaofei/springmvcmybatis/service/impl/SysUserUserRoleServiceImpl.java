package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.SysUserUserRole;
import com.yaofei.springmvcmybatis.repository.SysUserUserRoleRepository;
import com.yaofei.springmvcmybatis.service.SysUserUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysUserUserRoleService")
public class SysUserUserRoleServiceImpl  extends AbstractBaseService<SysUserUserRole> implements SysUserUserRoleService {
	@Autowired
	private SysUserUserRoleRepository sysUserUserRoleRepository;

	@Override
	public void deleteByUserId(Long userId) {
		sysUserUserRoleRepository.deleteByUserId(userId);
	}

	@Override
	public List<SysUserUserRole> querySysUserUserRoleByUserId(Long id) {
		return sysUserUserRoleRepository.querySysUserUserRoleByUserId(id);
	}
}