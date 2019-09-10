package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.ScheduleJob;

import java.io.IOException;

/**
 * 定时任务表
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-02-21 21:13:29
 */
public interface ScheduleJobService extends BaseService<ScheduleJob> {
    /**
     * 立即执行
     */
    void run(Long[] ids);

    /**
     * 暂停运行
     */
    void updateToPause(Long[] ids);

    /**
     * 恢复运行
     */
    void updateToResume(Long[] ids);

    /**
     * 批量关联删除
     * */
    void relateDeleteBatch(Object[] relateIds) throws IOException;

    /**
     * 关联删除
     * */
    void relateDelete(Object relateId) throws IOException;

    /**
     * 关联删除重点人员预警
     * */
    void relateDeleteImportant(Object relateId) throws IOException;

    /**
     * 批量关联删除重点人员预警
     * */
    void relateDeleteImportantBatch(Object[] relateId) throws IOException;

    /**
     * 关联删除临时布控
     * */
    void relateDeleteControl(Object relateId) throws IOException;

    /**
     * 批量关联删除临时布控
     * */
    void relateDeleteControlBatch(Object[] relateId) throws IOException;
}
