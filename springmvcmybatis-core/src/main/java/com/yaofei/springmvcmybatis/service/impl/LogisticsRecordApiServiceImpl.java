package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;
import com.yaofei.springmvcmybatis.entity.LogisticsCompany;
import com.yaofei.springmvcmybatis.entity.LogisticsRecord;
import com.yaofei.springmvcmybatis.entity.LogisticsUser;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.plugins.datatables.DataTablesUtils;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesResponse;
import com.yaofei.springmvcmybatis.service.*;
import com.yaofei.springmvcmybatis.utils.SignatureUtil;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by phoenix on 2017/8/11.
 */
@Service("logisticsRecordApiService")
public class LogisticsRecordApiServiceImpl implements LogisticsRecordApiService {

    private static final String ES_ID_PREFIX = "LogisticsRecord_";
    @Value("${logistics.record.business.type.id}")
    private Long logisticsRecordBusinessTypeId;

    @Autowired
    private LogisticsCompanyService logisticsCompanyService;
    @Autowired
    private LogisticsUserService logisticsUserService;
    @Autowired
    private LogisticsRecordService logisticsRecordService;
    @Autowired
    private IntelligenceBusinessTypeService intelligenceBusinessTypeService;
    @Autowired
    private SysAreaService sysAreaService;
    @Autowired
    private EsClientServiceCommonIndex esClientServiceCommonIndex;

    @Override
    public LogisticsUser checkLogisticsUerRight(String username, String password) {
        LogisticsUser logisticsUser = logisticsUserService.queryLogisticsUsersByUserName(username);
        if (logisticsUser == null) {
            throw new BussinessException("用户权限验证失败");
        }
        String passwordSha256 = new Sha256Hash(password, logisticsUser.getPasswordSalt(), 2).toString();
        if (!passwordSha256.equals(logisticsUser.getPassword())) {
            throw new BussinessException("用户权限验证失败");
        }
        return logisticsUser;
    }

    @Override
    public LogisticsUser checkLogisticsUerSign(String username, String sign, Integer nonce) throws Exception {
        LogisticsUser logisticsUser = logisticsUserService.queryLogisticsUsersByUserName(username);
        if (logisticsUser == null) {
            throw new BussinessException("用户权限验证失败");
        }

        String newsign = SignatureUtil
                .encryptBASE64(SignatureUtil.hmacSHA1Encrypt(nonce.toString().getBytes("UTF-8"), logisticsUser.getSeckey()));
        if (!newsign.equals(sign)) {
            throw new BussinessException("用户签名验证失败");
        }
        return logisticsUser;
    }

    @Override
    public DataTablesResponse<T> queryList(String username, String sign, Integer nonce, HttpServletRequest request) throws Exception {
        checkLogisticsUerSign(username, sign, nonce);
        //对请求参数解析，生成 排序条件、列搜索对象、全局搜索对象
        DataTablesRequest dataTablesRequest = DataTablesUtils.getDataTableRequest(request);

        //查询列表数据
        List<T> currentPageData = logisticsRecordService.queryList(dataTablesRequest);
        long recordsTotal = logisticsRecordService.queryTotal(dataTablesRequest);

        //dataTable 相应参数
        DataTablesResponse<T> dataTablesResponse = new DataTablesResponse<>(dataTablesRequest.getDraw(), recordsTotal, currentPageData);
        return dataTablesResponse;
    }

    @Override
    public void add(String username, String sign, Integer nonce, LogisticsRecord logisticsRecord, HttpServletRequest request) throws Exception {
        LogisticsUser logisticsUser = checkLogisticsUerSign(username, sign, nonce);
        logisticsRecord.setAreaId(logisticsUser.getAreaId());
        logisticsRecord.setUserId(logisticsUser.getId());
        logisticsRecord.setBusinessTypeId(logisticsRecordBusinessTypeId);
        logisticsRecord.setCollectTime(new Date());
        logisticsRecord.setFileType(1);
        logisticsRecord.setCreatedBy(username);
        logisticsRecord.setCreatedIp(request.getRemoteAddr());
        logisticsRecordService.save(logisticsRecord);

        //更新
        logisticsRecord.setDetailsUrl(request.getRequestURL().toString().replace("add", "details.html?id=" + logisticsRecord.getId()));

        // 把内容保存到es
        List<CommonIndex> commonIndexes = new ArrayList<>();
        CommonIndex commonIndex = getCommonIndex(logisticsUser, logisticsRecord);
        commonIndexes.add(commonIndex);
        String indexName = esClientServiceCommonIndex.createIndex(commonIndexes);
        logisticsRecord.setEsIndexName(indexName);

        logisticsRecordService.update(logisticsRecord);
    }

    @Override
    public void update(String username, String sign, Integer nonce, LogisticsRecord logisticsRecordNew, HttpServletRequest request) throws Exception {
        LogisticsUser logisticsUser = checkLogisticsUerSign(username, sign, nonce);
        LogisticsRecord logisticsRecord = logisticsRecordService.queryObject(logisticsRecordNew.getId());
        if (!logisticsRecord.getUserId().equals(logisticsUser.getId()) || !logisticsRecord.getAreaId().equals(logisticsUser.getAreaId())) {
            throw new BussinessException("非法操作");
        }
        logisticsRecord.setAreaId(logisticsUser.getAreaId());
        logisticsRecord.setUserId(logisticsUser.getId());
        //logisticsRecord.setBusinessTypeId(10L);
        logisticsRecord.setCollectTime(new Date());
        //logisticsRecord.setFileType(0);
        logisticsRecord.setModificationBy(username);
        logisticsRecord.setModificationIp(request.getRemoteAddr());
        //更新
        logisticsRecord.setSenderName(logisticsRecordNew.getSenderName());
        logisticsRecord.setSenderPhone(logisticsRecordNew.getSenderPhone());
        logisticsRecord.setSenderIdCardNum(logisticsRecordNew.getSenderIdCardNum());
        logisticsRecord.setReceiverName(logisticsRecordNew.getReceiverName());
        logisticsRecord.setReceiverPhone(logisticsRecordNew.getReceiverPhone());
        logisticsRecord.setReceiverAddress(logisticsRecordNew.getReceiverAddress());
        logisticsRecord.setGoodsName(logisticsRecordNew.getGoodsName());
        logisticsRecord.setRemark(logisticsRecordNew.getRemark());
        // 把内容保存到es
        List<CommonIndex> commonIndexes = new ArrayList<>();
        CommonIndex commonIndex = getCommonIndex(logisticsUser, logisticsRecord);
        commonIndexes.add(commonIndex);
        String indexName = esClientServiceCommonIndex.updateIndex(logisticsRecord.getEsIndexName(), commonIndexes);
        logisticsRecord.setEsIndexName(indexName);

        logisticsRecordService.update(logisticsRecord);
    }

    @Override
    public void delete(String username, String sign, Integer nonce, Object id) throws Exception {
        LogisticsUser logisticsUser = checkLogisticsUerSign(username, sign, nonce);
        LogisticsRecord logisticsRecord = logisticsRecordService.queryObject(id);
        if (!logisticsRecord.getUserId().equals(logisticsUser.getId()) || !logisticsRecord.getAreaId().equals(logisticsUser.getAreaId())) {
            throw new BussinessException("非法操作");
        }
        esClientServiceCommonIndex.deleteIndex(logisticsRecord.getEsIndexName(), ES_ID_PREFIX + logisticsRecord.getId().toString());
        logisticsRecordService.delete(id);
    }

    @Override
    public void changePassword(String username, String password, String newPassword) {
        LogisticsUser logisticsUser = checkLogisticsUerRight(username, password);
        logisticsUser.setPassword(newPassword);
        logisticsUserService.update(logisticsUser);
    }

    @Override
    public LogisticsRecord queryLogisticsRecord(Object id) {
        LogisticsRecord logisticsRecord = logisticsRecordService.queryObject(id);
        LogisticsUser logisticsUser = logisticsUserService.queryObject(logisticsRecord.getUserId());
        logisticsRecord.setBranchName(logisticsUser.getBranchName());
        return logisticsRecord;
    }

    private CommonIndex getCommonIndex(LogisticsUser logisticsUser, LogisticsRecord logisticsRecord) {
        CommonIndex commonIndex = new CommonIndex();
        commonIndex.setAreaId(logisticsRecord.getAreaId());
        commonIndex.setCollectTime(logisticsRecord.getCollectTime());
        commonIndex.setAreaName(sysAreaService.getParentString(logisticsRecord.getAreaId()));
        commonIndex.setBusinessTypeId(logisticsRecord.getBusinessTypeId());
        commonIndex.setBusinessTypeName(intelligenceBusinessTypeService.getParentString(logisticsRecord.getBusinessTypeId()));

        commonIndex.setCreatedTime(new Date());
        commonIndex.setFileType(logisticsRecord.getFileType());
        commonIndex.setId(ES_ID_PREFIX + logisticsRecord.getId());
        commonIndex.setSuggest(logisticsRecord.getSenderName());
        //commonIndex.setTitle("物流发件人姓名：" + logisticsRecord.getSenderName() + "   发件人身份证号：" + logisticsRecord.getSenderIdCardNum());

        commonIndex.setName1(logisticsRecord.getSenderName());
        commonIndex.setIdCardNum1(logisticsRecord.getSenderIdCardNum());
        commonIndex.setLocation1(logisticsUser.getAddress());
        commonIndex.setDtTime(new Date());
        commonIndex.setName2(logisticsRecord.getReceiverName());
        commonIndex.setIdCardNum2("");
        commonIndex.setLocation2(logisticsRecord.getReceiverAddress());

        commonIndex.setContent(logisticsRecord.toString());

        commonIndex.setUrl(logisticsRecord.getDetailsUrl());

        LogisticsCompany logisticsCompany = logisticsCompanyService.queryObject(logisticsUser.getCompanyId());
        //名称
        commonIndex.setInformationProvider(logisticsCompany.getName() + " - " + logisticsUser.getBranchName());
        //地址
        commonIndex.setProviderAddress(logisticsUser.getAddress());
        //所属公安机关
        commonIndex.setPoliceOffice(logisticsUser.getPoliceOffice());
        //联系人
        commonIndex.setContactPerson(logisticsUser.getContactPerson());
        //联系电话
        commonIndex.setContactPhone(logisticsUser.getContactPhone());
        //紧急联系人
        commonIndex.setEmergencyContactPerson(logisticsUser.getEmergencyContactPerson());
        //紧急联系电话
        commonIndex.setEmergencyContactPhone(logisticsUser.getEmergencyContactPhone());

        return commonIndex;
    }
}