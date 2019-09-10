package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.SysSearchwarningLog;
import com.yaofei.springmvcmybatis.repository.SysSearchwarningLogRepository;
import com.yaofei.springmvcmybatis.service.SysSearchwarningLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("sysSearchwarningLogService")
public class SysSearchwarningLogServiceImpl extends AbstractBaseService<SysSearchwarningLog> implements SysSearchwarningLogService {
	@Autowired
	private SysSearchwarningLogRepository sysSearchwarningLogRepository;
	public Date queryLastNoticeTime(Long confId){
		return sysSearchwarningLogRepository.queryLastNoticeTime(confId);
	};

}
