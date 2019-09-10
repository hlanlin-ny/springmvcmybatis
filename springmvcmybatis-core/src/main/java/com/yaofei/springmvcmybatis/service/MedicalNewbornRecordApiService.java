package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.HospitalUser;
import com.yaofei.springmvcmybatis.entity.MedicalNewbornRecord;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-28 14:58:13
 */
public interface MedicalNewbornRecordApiService {

    void add(String username, String sign, Integer nonce, MedicalNewbornRecord medicalNewbornRecord, HttpServletRequest request) throws Exception;

    public HospitalUser checkHospitalUserSign(String username, String sign, Integer nonce) throws Exception;

    MedicalNewbornRecord queryMedicalNewbornRecord(Object id);
}
