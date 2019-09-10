package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.MedicalInsuranceToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalStudentToCityTransfer;
import java.util.List;
import java.util.Map;

/**
 * 学生信息登记上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-06 16:18:01
 */
public interface MedicalStudentToCityTransferService extends BaseService<MedicalStudentToCityTransfer> {

    void insert(MedicalStudentToCityTransfer medicalStudentToCityTransfer);
}
