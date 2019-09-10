package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.MedicalStaticWaterToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticFileToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticTrifficPeopleToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticWaterToCityTransfer;

/**
 * 静态文件上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-02-24 14:11:22
 */
public interface StaticWaterToCityService extends BaseService<MedicalStaticWaterToCityTransfer> {

    void insert(MedicalStaticWaterToCityTransfer medicalStaticWaterToCityTransfer);
}
