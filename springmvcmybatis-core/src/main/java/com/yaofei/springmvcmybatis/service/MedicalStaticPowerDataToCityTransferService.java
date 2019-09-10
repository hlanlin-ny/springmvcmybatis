package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.MedicalStaticPowerDataToCityTransfer;

/**
 * 电力缴费信息登记上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-06 16:18:01
 */
public interface MedicalStaticPowerDataToCityTransferService extends BaseService<MedicalStaticPowerDataToCityTransfer> {

    void insert(MedicalStaticPowerDataToCityTransfer medicalStaticPowerDataToCityTransfer);
}
