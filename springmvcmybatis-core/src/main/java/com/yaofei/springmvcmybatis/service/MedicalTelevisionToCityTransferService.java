package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.MedicalTelevisionToCityTransfer;
import java.util.List;
import java.util.Map;

/**
 * 有线电视用户登记信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-07 07:47:48
 */
public interface MedicalTelevisionToCityTransferService extends BaseService<MedicalTelevisionToCityTransfer> {

    void insert(MedicalTelevisionToCityTransfer medicalTelevisionToCityTransfer);
}
