package com.yaofei.springmvcmybatis.plugins.quartz;

import com.yaofei.springmvcmybatis.component.SpringContextUtils;
import com.yaofei.springmvcmybatis.entity.ScheduleJob;
import com.yaofei.springmvcmybatis.entity.ScheduleJobLog;
import com.yaofei.springmvcmybatis.service.ScheduleJobLogService;
import org.apache.commons.lang3.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 定时任务
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2016年11月30日 下午12:44:21
 */
public class QuartzJob extends QuartzJobBean {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get(ScheduleJob.JOB_PARAM_KEY);

        //获取spring bean
        ScheduleJobLogService scheduleJobLogService = (ScheduleJobLogService) SpringContextUtils.getBean("scheduleJobLogService");

        //数据库保存执行记录
        ScheduleJobLog scheduleJobLog = new ScheduleJobLog();
        scheduleJobLog.setScheduleJobId(scheduleJob.getId());
        scheduleJobLog.setBeanName(scheduleJob.getBeanName());
        scheduleJobLog.setMethodName(scheduleJob.getMethodName());
        scheduleJobLog.setParams(scheduleJob.getParams());
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            scheduleJobLog.setCreatedBy(inetAddress.getHostAddress().toString());
            scheduleJobLog.setCreatedIp(inetAddress.getHostAddress().toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        //任务开始时间
        long startTime = System.currentTimeMillis();

        try {
            //执行任务
            logger.info("任务准备执行，任务ID：" + scheduleJob.getId());
            QuartzRunnable task = new QuartzRunnable(scheduleJob.getBeanName(), scheduleJob.getMethodName(), scheduleJob.getParams());
            Future<?> future = executorService.submit(task);
            future.get();

            //任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            scheduleJobLog.setTimes((int) times);
            //任务状态    0：成功    1：失败
            scheduleJobLog.setStatus(0);

            logger.info("任务执行完毕，任务ID：" + scheduleJob.getId() + "  总共耗时：" + times + "毫秒");
        } catch (Exception e) {
            logger.error("任务执行失败，任务ID：" + scheduleJob.getId(), e);

            //任务执行总时长
            long times = System.currentTimeMillis() - startTime;
            scheduleJobLog.setTimes((int) times);

            //任务状态    0：成功    1：失败
            scheduleJobLog.setStatus(1);
            scheduleJobLog.setError(StringUtils.substring(e.toString(), 0, 2000));
        } finally {
            scheduleJobLogService.save(scheduleJobLog);
        }
    }

    /**
     * 定时任务状态
     *
     * @author yaofei
     * @email f_yao@ctrip.com
     * @date 2016年12月3日 上午12:07:22
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 暂停
         */
        PAUSE(1);

        private int value;

        private ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
