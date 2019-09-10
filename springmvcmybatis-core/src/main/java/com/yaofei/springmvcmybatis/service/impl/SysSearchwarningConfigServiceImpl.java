package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.SysSearchwarningConfig;
import com.yaofei.springmvcmybatis.plugins.quartz.QuartzJob;
import com.yaofei.springmvcmybatis.plugins.quartz.WarnQuartzUtils;
import com.yaofei.springmvcmybatis.repository.SysSearchwarningConfigRepository;
import com.yaofei.springmvcmybatis.service.SysSearchwarningConfigService;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service("sysSearchwarningConfigService")
public class SysSearchwarningConfigServiceImpl extends AbstractBaseService<SysSearchwarningConfig> implements SysSearchwarningConfigService {
	@Autowired
	private SysSearchwarningConfigRepository sysSearchwarningConfigRepository;

	@Autowired
	private Scheduler scheduler;

	@Override
	protected void saveAfter(SysSearchwarningConfig sysSearchwarningConfig) {
		super.saveAfter(sysSearchwarningConfig);
		WarnQuartzUtils.createScheduleJob(scheduler, sysSearchwarningConfig);
	}

	@Override
	protected void updateBefore(SysSearchwarningConfig sysSearchwarningConfig) {
		super.updateBefore(sysSearchwarningConfig);
		WarnQuartzUtils.updateScheduleJob(scheduler, sysSearchwarningConfig);
	}

	@Override
	protected void deleteBefore(Object id) throws IOException {
		super.deleteBefore(id);
		WarnQuartzUtils.deleteScheduleJob(scheduler, Long.valueOf(id.toString()));
	}

	@Override
	protected void deleteBatchBefore(Object[] ids) throws IOException {
		super.deleteBatchBefore(ids);
		for (Object jobId : ids) {
			WarnQuartzUtils.deleteScheduleJob(scheduler, Long.valueOf(jobId.toString()));
		}
	}

	@Override
	public void run(Long[] ids) {
		for (Long jobId : ids) {
			WarnQuartzUtils.run(scheduler, queryObject(jobId));
		}
	}

	@Override
	public void updateToPause(Long[] ids) {
		for (Long jobId : ids) {
			WarnQuartzUtils.pauseJob(scheduler, jobId);
		}
		updateStatusByIds(ids, QuartzJob.ScheduleStatus.PAUSE.getValue());
	}

	@Override
	public void updateToResume(Long[] ids) {
		for (Long jobId : ids) {
			WarnQuartzUtils.resumeJob(scheduler, jobId);
		}
		updateStatusByIds(ids, QuartzJob.ScheduleStatus.NORMAL.getValue());
	}

	private int updateStatusByIds(Long[] ids, int status) {
		Map<String, Object> map = new HashMap<>();
		return sysSearchwarningConfigRepository.updateStatusByIds(ids, status);
	}
}
