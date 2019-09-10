package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.*;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.*;
import com.yaofei.springmvcmybatis.service.WarningDispostionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("warningDispostionService")
public class WarningDispostionServiceImpl extends AbstractBaseService<WarningDispostion> implements WarningDispostionService {
    @Autowired
    private WarningDispostionRepository warningDispostionRepository;
    @Autowired
    private ActivityDetailRepository activityDetailRepository;
    @Autowired
    private ImportantPersonRepository importantPersonRepository;
    @Autowired
    private DisposalMeasuresRepository disposalMeasuresRepository;
    @Autowired
    private DispositionResultRepository dispositionResultRepository;
    @Autowired
    private ControlApplyApplicationRepository controlApplyApplicationRepository;


    @Override
    public void claim(Long id) {
        warningDispostionRepository.claim(id);
        WarningDispostion warningDispostion = warningDispostionRepository.queryObject(id);
        Long acId = warningDispostion.getRelateId();
        activityDetailRepository.claim(acId);
    }

    @Override
    public List<Object> detail(Long id) {
        List<Object> lists = new ArrayList<Object>();
        WarningDispostion warningDispostion = warningDispostionRepository.queryObject(id);
        ActivityDetail activityDetail = activityDetailRepository.queryByRelateId(warningDispostion.getRelateId());
        if (activityDetail.getRelateControlId() == null) {
            ImportantPerson importantPerson = importantPersonRepository.queryObject(activityDetail.getRelateImportantId());
            lists.add(activityDetail);
            lists.add(importantPerson);
            lists.add("重点人员");
        } else {
            ControlApplyApplication controlApplyApplication = controlApplyApplicationRepository.queryObject(activityDetail.getRelateControlId());
            lists.add(activityDetail);
            lists.add(controlApplyApplication);
            lists.add("临时布控");
        }
        return lists;
    }

    //预警人员信息+活动发生详情
    @Override
    public List<Object> queryDisposition(Long id) {
        List<Object> lists = new ArrayList<Object>();
        ActivityDetail activityDetail = activityDetailRepository.queryByRelateId(id);
        if (activityDetail.getRelateControlId() == null) {
            ImportantPerson importantPerson = importantPersonRepository.queryObject(activityDetail.getRelateImportantId());
            lists.add(activityDetail);
            lists.add(importantPerson);
            lists.add("重点人员");
        } else {
            ControlApplyApplication controlApplyApplication = controlApplyApplicationRepository.queryObject(activityDetail.getRelateControlId());
            lists.add(activityDetail);
            lists.add(controlApplyApplication);
            lists.add("临时布控");
        }
        return lists;
    }

    @Override
    public WarningDispostion queryByRelateId(Long id) {
        return warningDispostionRepository.queryByRelateId(id);
    }


    //处置措施+预警人员信息+活动发生详情
    @Override
    public List<Object> queryFeedBack(Long id) {
        List<Object> lists = new ArrayList<Object>();
        ActivityDetail activityDetail = activityDetailRepository.queryByRelateId(id);
        if (activityDetail.getRelateControlId() == null) {
            ImportantPerson importantPerson = importantPersonRepository.queryObject(activityDetail.getRelateImportantId());
            lists.add(activityDetail);
            lists.add(importantPerson);
            lists.add("重点人员");
        } else {
            ControlApplyApplication controlApplyApplication = controlApplyApplicationRepository.queryObject(activityDetail.getRelateControlId());
            lists.add(activityDetail);
            lists.add(controlApplyApplication);
            lists.add("临时布控");
        }
        DisposalMeasures disposalMeasures = disposalMeasuresRepository.query(activityDetail.getId());
        lists.add(disposalMeasures);
        return lists;
    }

    @Override
    public boolean saveList(HttpServletRequest request, String name) throws ParseException {
        Long relateId = Long.parseLong(request.getParameter("relateId"));
        Date time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("time"));
        String status = request.getParameter("status");
        String result = request.getParameter("result");
        DispositionResult dispositionResult = new DispositionResult();
        dispositionResult.setRelateId(relateId);
        dispositionResult.setDispositionResult(result);
        dispositionResult.setDispositionTime(time);
        dispositionResult.setDispositionStatus(status);
        dispositionResult.setCreatedBy(name);
        dispositionResult.setCreatedIp(request.getRemoteAddr());
        int n = dispositionResultRepository.save(dispositionResult);
        if (n != 1) {
            return false;
        }
        warningDispostionRepository.updateDispostionStatus(relateId, time);
        return true;
    }

    @Override
    public boolean saveDisposition(HttpServletRequest request, String name) throws Exception {
        String issuerName = request.getParameter("issuerName");
        String dispositionTime = request.getParameter("dispositionTime");
        String issueProvider = request.getParameter("issueProvider");
        String remark = request.getParameter("remark");
        String result = request.getParameter("result");
        String ip = request.getRemoteAddr();
        String relateId = request.getParameter("relateId");
        DisposalMeasures disposalMeasures = new DisposalMeasures();
        disposalMeasures.setIssuerName(issuerName);
        disposalMeasures.setDispositionTime(new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dispositionTime).getTime()));
        disposalMeasures.setIssuerProvider(issueProvider);
        disposalMeasures.setRemark(remark);
        disposalMeasures.setResult(result);
        disposalMeasures.setCreatedBy(name);
        disposalMeasures.setCreatedIp(ip);
        disposalMeasures.setRelateId(Long.parseLong(relateId));
        disposalMeasures.setModificationTime(new Date());
        int n = disposalMeasuresRepository.save(disposalMeasures);//处置措施表
        if (n != 1) {
            throw new Exception("处置失败");
        }
        n = warningDispostionRepository.updateDispostionStatus(Long.parseLong(relateId), new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dispositionTime).getTime()));
        if (n != 1) {
            throw new Exception("处置失败");
        }
        return true;
    }

    @Override
    public List<WarningDispostion> compare() {
        Date time = new Date();
        Date newTime = new Date(time.getTime() - 300000);
        List<WarningDispostion> warningDispostions = warningDispostionRepository.queryByTime(newTime, time);
        return warningDispostions;
    }

    @Override
    public int queryUnclaim() {
        return warningDispostionRepository.queryUnClaim();
    }

    @Override
    protected void queryListAfter(DataTablesRequest dataTablesRequest, List<WarningDispostion> result) {
        super.queryListAfter(dataTablesRequest, result);
        for (WarningDispostion warningDispostion : result) {
            ActivityDetail activityDetail = activityDetailRepository.queryObject(warningDispostion.getRelateId());
            if(activityDetail != null){
                if (  activityDetail.getRelateControlId() != null) {
                    ControlApplyApplication controlApplyApplication = controlApplyApplicationRepository.queryObject(activityDetail.getRelateControlId());
                    if(controlApplyApplication!=null){
                        warningDispostion.setTel(controlApplyApplication.getFeedBackContact());
                    }
                } else {
                    ImportantPerson importantPerson = importantPersonRepository.queryObject(activityDetail.getRelateImportantId());
                    if(importantPerson!=null){
                        warningDispostion.setTel(importantPerson.getControlTel());
                    }
                }
            }
        }
    }
}
