package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.ScheduleJob;
import com.yaofei.springmvcmybatis.service.ScheduleJobService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 定时任务表
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-02-21 21:13:29
 */
@Controller
@RequestMapping("admin/schedulejob")
public class ScheduleJobController extends BaseCRUDController<ScheduleJob> {
    @Autowired
    private ScheduleJobService scheduleJobService;

    ///**
    // * 批量更新定时任务状态
    // */
    //@RequiresPermissions("sysuser:queryList")
    //@ResponseBody
    //@RequestMapping(value = "/batch/updateStatusByIds", method = RequestMethod.POST)
    //private JsonResult updateStatusByIds(Long[] ids, int status) {
    //    scheduleJobService.updateStatusByIds(ids,status);
    //    return JsonResult.ok();
    //}

    /**
     * 暂停运行
     */
    @RequiresPermissions("schedulejob:pause")
    @ResponseBody
    @RequestMapping(value = "/batch/pause", method = RequestMethod.POST)
    public JsonResult pause(@RequestBody Long[] ids) {
        scheduleJobService.updateToPause(ids);
        return JsonResult.ok();
    }

    /**
     * 恢复运行
     */
    @RequiresPermissions("schedulejob:resume")
    @ResponseBody
    @RequestMapping(value = "/batch/resume", method = RequestMethod.POST)
    public JsonResult resume(@RequestBody Long[] ids) {
        scheduleJobService.updateToResume(ids);
        return JsonResult.ok();
    }

    /**
     * 立即执行
     */
    @RequiresPermissions("schedulejob:run")
    @ResponseBody
    @RequestMapping(value = "/batch/run", method = RequestMethod.POST)
    public JsonResult run(@RequestBody Long[] ids) {
        scheduleJobService.run(ids);
        return JsonResult.ok();
    }


}