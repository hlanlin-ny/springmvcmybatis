package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.ScheduleJobLog;
import com.yaofei.springmvcmybatis.repository.ScheduleJobLogRepository;
import com.yaofei.springmvcmybatis.service.ScheduleJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl extends AbstractBaseService<ScheduleJobLog> implements ScheduleJobLogService {
	@Override
	protected void updateBefore(ScheduleJobLog scheduleJobLogEntity) {

	}
}
