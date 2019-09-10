package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.LogisticsRecord;
import com.yaofei.springmvcmybatis.entity.LogisticsUser;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesResponse;
import org.apache.poi.ss.formula.functions.T;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by phoenix on 2017/8/11.
 */
public interface LogisticsRecordApiService {
    LogisticsUser checkLogisticsUerRight(String username, String password);

    LogisticsUser checkLogisticsUerSign(String username, String sign, Integer nonce) throws Exception;

    DataTablesResponse<T> queryList(String username, String sign, Integer nonce, HttpServletRequest request) throws Exception;

    void add(String username, String sign, Integer nonce, LogisticsRecord logisticsRecord, HttpServletRequest request) throws Exception;

    void update(String username, String sign, Integer nonce, LogisticsRecord logisticsRecord, HttpServletRequest request) throws Exception;

    void delete(String username, String sign, Integer nonce, Object id) throws Exception;

    void changePassword(String username, String password, String newPassword);

    LogisticsRecord queryLogisticsRecord(Object id);
}