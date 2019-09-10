package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.ActivityDetail;

/**
 * Created by 87796 on 2017/9/21.
 */
public interface ActivityDetailService {

    int save(ActivityDetail activityDetail);

    ActivityDetail queryByRelateId(Long relateId);

    int update(ActivityDetail activityDetail);

    public ActivityDetail queryAlikeByImportant(String providerAddress,String name);

    public ActivityDetail queryAlikeByControl(String providerAddress,String name);
}
