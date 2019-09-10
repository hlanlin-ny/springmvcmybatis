package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.ControlApplyApplication;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * 临时布控申请单
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-29 10:17:52
 */
public interface ControlApplyApplicationService extends BaseService<ControlApplyApplication> {

    public void addApplyApplication(String username,String ip,HttpServletRequest request,Long areaId,Long userId) throws ParseException;

    public List<ControlApplyApplication> queryNormalControl();
}
