package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.MedicalLettersCallsToCityTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalNcmsToCityTransfer;

/**
 * 静态文件上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-02-24 14:11:22
 */
public interface StaticLettersCallsToCityRepository extends BaseRepository<MedicalLettersCallsToCityTransfer> {

    void insert(MedicalLettersCallsToCityTransfer medicalLettersCallsToCityTransfer);
}
