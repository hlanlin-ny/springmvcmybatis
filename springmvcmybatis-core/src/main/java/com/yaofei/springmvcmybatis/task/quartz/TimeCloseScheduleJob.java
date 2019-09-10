package com.yaofei.springmvcmybatis.task.quartz;

import com.yaofei.springmvcmybatis.entity.ControlApplyApplication;
import com.yaofei.springmvcmybatis.service.ControlApplyApplicationService;
import com.yaofei.springmvcmybatis.service.ScheduleJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 测试定时任务(演示Demo，可删除)
 * <p/>
 * testTask为spring bean的名称
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2016年11月30日 下午1:34:24
 */
@Component("timeCloseScheduleJob")
public class TimeCloseScheduleJob {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ControlApplyApplicationService applyApplicationService;
    @Autowired
    private ScheduleJobService scheduleJobService;

    public void run() throws IOException {
        try {
            logger.info("我是进行定时任务监听关闭的方法");
            List<ControlApplyApplication> controlApplyApplications = applyApplicationService.queryNormalControl();
            if (controlApplyApplications.size() == 0) {
                logger.info("没有临时布控单");
            } else {
                for (ControlApplyApplication controlApplyApplication : controlApplyApplications) {
                    Long now = new Date().getTime();
                    Long taskTime = controlApplyApplication.getControlEndTime().getTime();
                    if (now >= taskTime) {//如果现在时间大于等于任务结束时间，删除定时任务和删除临时布控
                        scheduleJobService.relateDeleteControl(controlApplyApplication.getId());
                        controlApplyApplication.setStatus("失效");
                        applyApplicationService.update(controlApplyApplication);
                    } else {
                        logger.info(controlApplyApplication.getControlByName() + "的布控未结束");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
    }
}
