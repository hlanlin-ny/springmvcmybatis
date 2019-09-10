package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.HospitalUser;
import com.yaofei.springmvcmybatis.entity.MedicalInsuranceCardRecord;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-28 14:58:13
 */
public interface MedicalInsuranceCardRecordApiService {

    void add(String username, String sign, Integer nonce, MedicalInsuranceCardRecord medicalInsuranceCardRecord, HttpServletRequest request) throws Exception;

    public HospitalUser checkHospitalUserSign(String username, String sign, Integer nonce) throws Exception;

    MedicalInsuranceCardRecord queryMedicalInsuranceCardRecord(Object id);
}
