package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.HospitalUser;
import com.yaofei.springmvcmybatis.entity.MedicalPatientRecord;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-28 10:38:13
 */
public interface MedicalPatientRecordApiService {

    void add(String username, String sign, Integer nonce, MedicalPatientRecord medicalPatientRecord, HttpServletRequest request) throws Exception;

    public HospitalUser checkHospitalUserrSign(String username, String sign, Integer nonce) throws Exception;

    MedicalPatientRecord queryMedicalPatientRecord(Object id);
}
