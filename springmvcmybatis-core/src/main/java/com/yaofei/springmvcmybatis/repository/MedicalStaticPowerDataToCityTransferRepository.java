package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.MedicalStaticPowerDataToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalStudentToCityTransfer;

/**
 * 电力缴费信息登记上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-06 16:18:01
 */
public interface MedicalStaticPowerDataToCityTransferRepository extends BaseRepository<MedicalStaticPowerDataToCityTransfer> {

    void insert(MedicalStaticPowerDataToCityTransfer medicalStaticPowerDataToCityTransfer);
}
