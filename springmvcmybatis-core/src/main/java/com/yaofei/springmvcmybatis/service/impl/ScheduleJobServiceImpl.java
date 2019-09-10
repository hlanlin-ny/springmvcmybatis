package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.ScheduleJob;
import com.yaofei.springmvcmybatis.plugins.quartz.QuartzJob;
import com.yaofei.springmvcmybatis.plugins.quartz.QuartzUtils;
import com.yaofei.springmvcmybatis.repository.ScheduleJobRepository;
import com.yaofei.springmvcmybatis.service.ScheduleJobService;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("scheduleJobService")
public class ScheduleJobServiceImpl extends AbstractBaseService<ScheduleJob> implements ScheduleJobService {
    @Autowired
    private ScheduleJobRepository scheduleJobRepository;
    @Autowired
    private Scheduler scheduler;

    @Override
    protected void saveAfter(ScheduleJob scheduleJob) {
        super.saveAfter(scheduleJob);
        QuartzUtils.createScheduleJob(scheduler, scheduleJob);
    }

    @Override
    protected void updateBefore(ScheduleJob scheduleJob) {
        super.updateBefore(scheduleJob);
        QuartzUtils.updateScheduleJob(scheduler, scheduleJob);
    }

    @Override
    protected void deleteBefore(Object id) throws IOException {
        super.deleteBefore(id);
        if(id instanceof Long){
            QuartzUtils.deleteScheduleJob(scheduler,(Long)id);
        }
        if(id instanceof  String){
            QuartzUtils.deleteScheduleJob(scheduler,Long.valueOf((String) id));
        }
    }

    @Override
    protected void deleteBatchBefore(Object[] ids) throws IOException {
        super.deleteBatchBefore(ids);
        for (Object jobId : ids) {
            if(jobId instanceof Long){
                QuartzUtils.deleteScheduleJob(scheduler,(Long)jobId);
            }
            if(jobId instanceof  String){
                QuartzUtils.deleteScheduleJob(scheduler,Long.valueOf((String) jobId));
            }

        }
    }

    @Override
    public void run(Long[] ids) {
        for (Long jobId : ids) {
            QuartzUtils.run(scheduler, queryObject(jobId));
        }
        updateStatusByIds(ids, QuartzJob.ScheduleStatus.NORMAL.getValue());
    }

    @Override
    public void updateToPause(Long[] ids) {
        for (Long jobId : ids) {
            QuartzUtils.pauseJob(scheduler, jobId);
        }
        updateStatusByIds(ids, QuartzJob.ScheduleStatus.PAUSE.getValue());
    }

    @Override
    public void updateToResume(Long[] ids) {
        for (Long jobId : ids) {
            QuartzUtils.resumeJob(scheduler, jobId);
        }
        updateStatusByIds(ids, QuartzJob.ScheduleStatus.NORMAL.getValue());
    }


    private int updateStatusByIds(Long[] ids, int status) {
        Map<String, Object> map = new HashMap<>();
        //map.put("list", ids);
        //map.put("status", status);
        //return scheduleJobRepository.updateStatusByIds(map);
        return scheduleJobRepository.updateStatusByIds(ids, status);
    }


    @Override
    public void relateDeleteBatch(Object[] relateIds) throws IOException{
        for (Object relateId : relateIds) {
            List<ScheduleJob> scheduleJobs = scheduleJobRepository.queryByRelateId(relateId);
            for(ScheduleJob scheduleJob:scheduleJobs){
                deleteBefore(scheduleJob.getId());
            }
        }
        scheduleJobRepository.relateDeleteBatch(relateIds);
    }

    @Override
    public void relateDelete(Object relateId) throws IOException{
       List<ScheduleJob> scheduleJobs = scheduleJobRepository.queryByRelateId(relateId);
        for(ScheduleJob scheduleJob:scheduleJobs){
            deleteBefore(scheduleJob.getId());
        }
        scheduleJobRepository.relateDelete(relateId);
    }

    @Override
    public void relateDeleteImportant(Object relateId) throws IOException {
        ScheduleJob scheduleJob = scheduleJobRepository.queryByRelateImportant(relateId);
        deleteBefore(scheduleJob.getId());
        scheduleJobRepository.relateDeleteImportant(relateId);
    }

    @Override
    public void relateDeleteControl(Object relateId) throws IOException {
        ScheduleJob scheduleJob = scheduleJobRepository.queryByRelateControl(relateId);
        deleteBefore(scheduleJob.getId());
        scheduleJobRepository.relateDeleteControl(relateId);
    }

    @Override
    public void relateDeleteImportantBatch(Object[] relateIds) throws IOException {
        for (Object relateId : relateIds) {
            ScheduleJob scheduleJob = scheduleJobRepository.queryByRelateImportant(relateId);
           deleteBefore(scheduleJob.getId());

        }
        scheduleJobRepository.relateDeleteImportantBatch(relateIds);
    }

    @Override
    public void relateDeleteControlBatch(Object[] relateIds) throws IOException {
        for (Object relateId : relateIds) {
            ScheduleJob scheduleJob = scheduleJobRepository.queryByRelateControl(relateId);
            deleteBefore(scheduleJob.getId());
        }
        scheduleJobRepository.relateDeleteControlBatch(relateIds);
    }
}
