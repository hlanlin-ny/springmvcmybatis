package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.ControlApplyApplication;
import com.yaofei.springmvcmybatis.entity.ScheduleJob;
import com.yaofei.springmvcmybatis.repository.ControlApplyApplicationRepository;
import com.yaofei.springmvcmybatis.service.ControlApplyApplicationService;
import com.yaofei.springmvcmybatis.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service("controlApplyApplicationService")
public class ControlApplyApplicationServiceImpl extends AbstractBaseService<ControlApplyApplication> implements ControlApplyApplicationService {
	@Autowired
	private ControlApplyApplicationRepository controlApplyApplicationRepository;
	@Autowired
	private ScheduleJobService scheduleJobService;

	@Override
	public void addApplyApplication(String username, String ip, HttpServletRequest request,Long areaId,Long userId) throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ControlApplyApplication controlApplyApplication = new ControlApplyApplication();
		controlApplyApplication.setControlByName(request.getParameter("controlByName"));
		controlApplyApplication.setNickName(request.getParameter("nickName"));
		controlApplyApplication.setSex(request.getParameter("sex"));
		if(request.getParameter("bornTime")!=null|| !request.getParameter("bornTime").equals("")){
			controlApplyApplication.setBornTime(date.parse(request.getParameter("bornTime")));
		}
		controlApplyApplication.setNation(request.getParameter("nation"));
		controlApplyApplication.setCardType(request.getParameter("cardType"));
		controlApplyApplication.setCardNumber(request.getParameter("cardNumber"));
		controlApplyApplication.setAddress(request.getParameter("address"));
		controlApplyApplication.setWorkUnit(request.getParameter("workUnit"));
		controlApplyApplication.setControlReason(request.getParameter("controlReason"));
		controlApplyApplication.setRemark(request.getParameter("remark"));
		controlApplyApplication.setControlMeasureRequire(request.getParameter("controlMeasureRequire"));
		controlApplyApplication.setControlBeginTime(time.parse(request.getParameter("controlBeginTime")));
		controlApplyApplication.setControlDays(new Integer(request.getParameter("controlDays")));
		controlApplyApplication.setControlEndTime(time.parse(request.getParameter("controlEndTime")));
		controlApplyApplication.setControlUnit(request.getParameter("controlUnit"));
		controlApplyApplication.setFeedBackContact(request.getParameter("feedBackContact"));
		controlApplyApplication.setApplyUnit(request.getParameter("applyUnit"));
		controlApplyApplication.setApplyUnitContactTel(request.getParameter("applyUnitContactTel"));
		controlApplyApplication.setApplyName(request.getParameter("applyName"));
		controlApplyApplication.setApplyUnitPrincipal(request.getParameter("applyUnitPrincipal"));
		controlApplyApplication.setApplySafeOrgan(request.getParameter("applySafeOrgan"));
		controlApplyApplication.setCreatedBy(username);
		controlApplyApplication.setCreatedIp(ip);
		controlApplyApplication.setStatus("布控中");
		controlApplyApplicationRepository.save(controlApplyApplication);//保存临时布控信息
		ScheduleJob scheduleJob = new ScheduleJob();
		scheduleJob.setBeanName("controlWarningScheduleJob");
		scheduleJob.setMethodName("query");
		scheduleJob.setParams(request.getParameter("controlByName")+ ":" + request.getParameter("cardNumber")+":"+areaId+":"+username+":"+userId+":"+controlApplyApplication.getId());
		scheduleJob.setCronExpression("0 */3 * * * ?");
		scheduleJob.setStatus(0);
		scheduleJob.setRelateId(controlApplyApplication.getId());
		scheduleJob.setScheduleType("临时布控");
		scheduleJobService.save(scheduleJob);//创建定时任务，并获取定时任务Id
		controlApplyApplicationRepository.update(controlApplyApplication);//保存临时布控信息
	}

	@Override
	public List<ControlApplyApplication> queryNormalControl() {
		return controlApplyApplicationRepository.queryNormalControl();
	}

	@Override
	protected void deleteBefore(Object id) throws IOException {
		super.deleteBefore(id);
		scheduleJobService.relateDeleteControl(id);
	}

	@Override
	protected void deleteBatchBefore(Object[] ids) throws IOException {
		super.deleteBatchBefore(ids);
		scheduleJobService.relateDeleteControlBatch(ids);
	}
}
