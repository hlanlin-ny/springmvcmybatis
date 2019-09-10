package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.ActivityDetail;
import com.yaofei.springmvcmybatis.repository.ActivityDetailRepository;
import com.yaofei.springmvcmybatis.service.ActivityDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 87796 on 2017/9/21.
 */
@Service("activityDetail")
public class ActivityDetailServiceImpl implements ActivityDetailService {

    @Autowired
    private ActivityDetailRepository activityDetailRepository;

    @Override
    public int save(ActivityDetail activityDetail) {
        return activityDetailRepository.save(activityDetail);
    }

    @Override
    public ActivityDetail queryByRelateId(Long relateId) {
        return activityDetailRepository.queryByRelateId(relateId);
    }

    @Override
    public int update(ActivityDetail activityDetail) {
        return activityDetailRepository.update(activityDetail);
    }

    @Override
    public ActivityDetail queryAlikeByImportant(String providerAddress,String name) {
        return activityDetailRepository.queryAlikeByImportant(providerAddress, name);
    }

    @Override
    public ActivityDetail queryAlikeByControl(String providerAddress, String name) {
        return activityDetailRepository.queryAlikeByControl(providerAddress,name);
    }
}
