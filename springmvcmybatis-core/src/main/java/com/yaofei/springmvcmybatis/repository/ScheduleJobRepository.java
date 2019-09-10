package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.ScheduleJob;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 定时任务表
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-02-21 21:13:29
 */
public interface ScheduleJobRepository extends BaseRepository<ScheduleJob> {

    int updateStatusByIds(@Param("ids") Long[] ids, @Param("status") int status);

    //int updateStatusByIds(Map<String, Object> map);
    void batchAdd(List<ScheduleJob> scheduleJobs);

    void relateDeleteBatch(Object[] relateId);

    void relateDeleteImportantBatch(Object[] relateId);

    void relateDeleteControlBatch(Object[] relateId);

    void relateDelete(Object relateId);

    void relateDeleteImportant(Object relateId);

    void relateDeleteControl(Object relateId);

    List<ScheduleJob> queryByRelateId(Object relateId);

    ScheduleJob queryByRelateImportant(Object relateId);

    ScheduleJob queryByRelateControl(Object relateId);
}
