package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.HospitalUser;
import com.yaofei.springmvcmybatis.entity.MedicalExaminationRecord;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 18:01:13
 */
public interface MedicalExaminationRecordApiService{

    void add(String username, String sign, Integer nonce, MedicalExaminationRecord medicalExaminationRecord, HttpServletRequest request) throws Exception;

    public HospitalUser checkHospitalUserSign(String username, String sign, Integer nonce) throws Exception;

    MedicalExaminationRecord queryMedicalExaminationRecord(Object id);
}
