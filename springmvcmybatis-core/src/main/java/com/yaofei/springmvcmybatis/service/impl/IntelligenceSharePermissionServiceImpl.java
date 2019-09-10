package com.yaofei.springmvcmybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.yaofei.springmvcmybatis.repository.IntelligenceSharePermissionRepository;
import com.yaofei.springmvcmybatis.entity.IntelligenceSharePermission;
import com.yaofei.springmvcmybatis.service.IntelligenceSharePermissionService;

@Service("intelligenceSharePermissionService")
public class IntelligenceSharePermissionServiceImpl extends AbstractBaseService<IntelligenceSharePermission> implements IntelligenceSharePermissionService {
	@Autowired
	private IntelligenceSharePermissionRepository intelligenceSharePermissionRepository;

}
