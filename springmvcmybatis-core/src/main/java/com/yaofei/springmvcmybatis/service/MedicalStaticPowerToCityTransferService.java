package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.MedicalStaticPowerToCityTransfer;

/**
 * 电力用户信息登记上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-06 16:18:01
 */
public interface MedicalStaticPowerToCityTransferService extends BaseService<MedicalStaticPowerToCityTransfer> {

    void insert(MedicalStaticPowerToCityTransfer medicalStaticPowerToCityTransfer);
}
