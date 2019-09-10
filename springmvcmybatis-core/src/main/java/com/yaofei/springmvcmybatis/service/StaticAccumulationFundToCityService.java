package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.MedicalAccumulationFundToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalNcmsToCityTransfer;

/**
 * 静态文件上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-02-24 14:11:22
 */
public interface StaticAccumulationFundToCityService extends BaseService<MedicalAccumulationFundToCityTransfer> {

    void insert(MedicalAccumulationFundToCityTransfer medicalAccumulationFundToCityTransfer);
}
