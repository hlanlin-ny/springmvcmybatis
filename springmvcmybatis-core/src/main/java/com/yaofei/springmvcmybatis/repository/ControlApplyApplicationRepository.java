package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.ControlApplyApplication;

import java.util.List;

/**
 * 临时布控申请单
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-29 10:17:52
 */
public interface ControlApplyApplicationRepository extends BaseRepository<ControlApplyApplication> {


    public List<ControlApplyApplication> queryNormalControl();
}
