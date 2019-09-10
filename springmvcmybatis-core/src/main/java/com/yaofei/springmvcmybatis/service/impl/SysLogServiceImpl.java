package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.SysLog;
import com.yaofei.springmvcmybatis.repository.SysLogRepository;
import com.yaofei.springmvcmybatis.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysLogService")
public class SysLogServiceImpl extends AbstractBaseService<SysLog> implements SysLogService {
	@Autowired
	private SysLogRepository sysLogRepository;
}