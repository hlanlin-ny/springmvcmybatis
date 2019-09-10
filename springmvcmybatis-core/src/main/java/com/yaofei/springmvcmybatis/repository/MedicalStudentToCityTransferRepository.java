package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.MedicalStaticPeopleToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalStudentToCityTransfer;

/**
 * 学生信息登记上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-06 16:18:01
 */
public interface MedicalStudentToCityTransferRepository extends BaseRepository<MedicalStudentToCityTransfer> {

    void insert(MedicalStudentToCityTransfer medicalStudentToCityTransfer);
}
