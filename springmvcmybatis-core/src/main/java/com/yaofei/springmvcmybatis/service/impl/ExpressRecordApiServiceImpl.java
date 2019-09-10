package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;
import com.yaofei.springmvcmybatis.entity.ExpressCompany;
import com.yaofei.springmvcmybatis.entity.ExpressRecord;
import com.yaofei.springmvcmybatis.entity.ExpressUser;
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
@Service("expressRecordApiService")
public class ExpressRecordApiServiceImpl implements ExpressRecordApiService {

    private static final String ES_ID_PREFIX = "ExpressRecord_";
    @Value("${express.record.business.type.id}")
    private Long expressRecordBusinessTypeId;

    @Autowired
    private ExpressCompanyService expressCompanyService;
    @Autowired
    private ExpressUserService expressUserService;
    @Autowired
    private ExpressRecordService expressRecordService;
    @Autowired
    private IntelligenceBusinessTypeService intelligenceBusinessTypeService;
    @Autowired
    private SysAreaService sysAreaService;
    @Autowired
    private EsClientServiceCommonIndex esClientServiceCommonIndex;

    @Override
    public ExpressUser checkExpressUerRight(String username, String password) {
        ExpressUser expressUser = expressUserService.queryExpressUsersByUserName(username);
        if (expressUser == null) {
            throw new BussinessException("用户权限验证失败");
        }
        String passwordSha256 = new Sha256Hash(password, expressUser.getPasswordSalt(), 2).toString();
        if (!passwordSha256.equals(expressUser.getPassword())) {
            throw new BussinessException("用户权限验证失败");
        }
        return expressUser;
    }

    @Override
    public ExpressUser checkExpressUerSign(String username, String sign, Integer nonce) throws Exception {
        ExpressUser expressUser = expressUserService.queryExpressUsersByUserName(username);
        if (expressUser == null) {
            throw new BussinessException("用户权限验证失败");
        }

        String newsign = SignatureUtil
                .encryptBASE64(SignatureUtil.hmacSHA1Encrypt(nonce.toString().getBytes("UTF-8"), expressUser.getSeckey()));
        if (!newsign.equals(sign)) {
            throw new BussinessException("用户签名验证失败");
        }
        return expressUser;
    }

    @Override
    public DataTablesResponse<T> queryList(String username, String sign, Integer nonce, HttpServletRequest request) throws Exception {
        checkExpressUerSign(username, sign, nonce);
        //对请求参数解析，生成 排序条件、列搜索对象、全局搜索对象
        DataTablesRequest dataTablesRequest = DataTablesUtils.getDataTableRequest(request);

        //查询列表数据
        List<T> currentPageData = expressRecordService.queryList(dataTablesRequest);
        long recordsTotal = expressRecordService.queryTotal(dataTablesRequest);

        //dataTable 相应参数
        DataTablesResponse<T> dataTablesResponse = new DataTablesResponse<>(dataTablesRequest.getDraw(), recordsTotal, currentPageData);
        return dataTablesResponse;
    }

    @Override
    public void add(String username, String sign, Integer nonce, ExpressRecord expressRecord, HttpServletRequest request) throws Exception {
        ExpressUser expressUser = checkExpressUerSign(username, sign, nonce);
        expressRecord.setAreaId(expressUser.getAreaId());
        expressRecord.setUserId(expressUser.getId());
        expressRecord.setBusinessTypeId(expressRecordBusinessTypeId);
        expressRecord.setCollectTime(new Date());
        expressRecord.setFileType(1);
        expressRecord.setCreatedBy(username);
        expressRecord.setCreatedIp(request.getRemoteAddr());
        expressRecordService.save(expressRecord);

        //更新
        expressRecord.setDetailsUrl(request.getRequestURL().toString().replace("add", "details.html?id=" + expressRecord.getId()));

        // 把内容保存到es
        List<CommonIndex> commonIndexes = new ArrayList<>();
        CommonIndex commonIndex = getCommonIndex(expressUser, expressRecord);
        commonIndexes.add(commonIndex);
        String indexName = esClientServiceCommonIndex.createIndex(commonIndexes);
        expressRecord.setEsIndexName(indexName);

        expressRecordService.update(expressRecord);
    }

    @Override
    public void update(String username, String sign, Integer nonce, ExpressRecord expressRecordNew, HttpServletRequest request) throws Exception {
        ExpressUser expressUser = checkExpressUerSign(username, sign, nonce);
        ExpressRecord expressRecord = expressRecordService.queryObject(expressRecordNew.getId());
        if (!expressRecord.getUserId().equals(expressUser.getId()) || !expressRecord.getAreaId().equals(expressUser.getAreaId())) {
            throw new BussinessException("非法操作");
        }
        expressRecord.setAreaId(expressUser.getAreaId());
        expressRecord.setUserId(expressUser.getId());
        //expressRecord.setBusinessTypeId(10L);
        expressRecord.setCollectTime(new Date());
        //expressRecord.setFileType(0);
        expressRecord.setModificationBy(username);
        expressRecord.setModificationIp(request.getRemoteAddr());
        //更新
        expressRecord.setSenderName(expressRecordNew.getSenderName());
        expressRecord.setSenderPhone(expressRecordNew.getSenderPhone());
        expressRecord.setSenderIdCardNum(expressRecordNew.getSenderIdCardNum());
        expressRecord.setReceiverName(expressRecordNew.getReceiverName());
        expressRecord.setReceiverPhone(expressRecordNew.getReceiverPhone());
        expressRecord.setReceiverAddress(expressRecordNew.getReceiverAddress());
        expressRecord.setGoodsName(expressRecordNew.getGoodsName());
        expressRecord.setRemark(expressRecordNew.getRemark());
        // 把内容保存到es
        List<CommonIndex> commonIndexes = new ArrayList<>();
        CommonIndex commonIndex = getCommonIndex(expressUser, expressRecord);
        commonIndexes.add(commonIndex);
        String indexName = esClientServiceCommonIndex.updateIndex(expressRecord.getEsIndexName(), commonIndexes);
        expressRecord.setEsIndexName(indexName);

        expressRecordService.update(expressRecord);
    }

    @Override
    public void delete(String username, String sign, Integer nonce, Object id) throws Exception {
        ExpressUser expressUser = checkExpressUerSign(username, sign, nonce);
        ExpressRecord expressRecord = expressRecordService.queryObject(id);
        if (!expressRecord.getUserId().equals(expressUser.getId()) || !expressRecord.getAreaId().equals(expressUser.getAreaId())) {
            throw new BussinessException("非法操作");
        }
        esClientServiceCommonIndex.deleteIndex(expressRecord.getEsIndexName(), ES_ID_PREFIX + expressRecord.getId().toString());
        expressRecordService.delete(id);
    }

    @Override
    public void changePassword(String username, String password, String newPassword) {
        ExpressUser expressUser = checkExpressUerRight(username, password);
        expressUser.setPassword(newPassword);
        expressUserService.update(expressUser);
    }

    @Override
    public ExpressRecord queryExpressRecord(Object id) {
        ExpressRecord logisticsRecord = expressRecordService.queryObject(id);
        ExpressUser expressUser = expressUserService.queryObject(logisticsRecord.getUserId());
        logisticsRecord.setBranchName(expressUser.getBranchName());
        return logisticsRecord;
    }

    private CommonIndex getCommonIndex(ExpressUser expressUser, ExpressRecord expressRecord) {
        CommonIndex commonIndex = new CommonIndex();
        commonIndex.setAreaId(expressRecord.getAreaId());
        commonIndex.setCollectTime(expressRecord.getCollectTime());
        commonIndex.setAreaName(sysAreaService.getParentString(expressRecord.getAreaId()));
        commonIndex.setBusinessTypeId(expressRecord.getBusinessTypeId());
        commonIndex.setBusinessTypeName(intelligenceBusinessTypeService.getParentString(expressRecord.getBusinessTypeId()));

        commonIndex.setCreatedTime(new Date());
        commonIndex.setFileType(expressRecord.getFileType());
        commonIndex.setId(ES_ID_PREFIX + expressRecord.getId());
        commonIndex.setSuggest(expressRecord.getSenderName());
        //commonIndex.setTitle("快递发件人姓名：" + expressRecord.getSenderName() + " 发件人身份证号：" + expressRecord.getSenderIdCardNum());

        commonIndex.setName1(expressRecord.getSenderName());
        commonIndex.setIdCardNum1(expressRecord.getSenderIdCardNum());
        commonIndex.setLocation1(expressUser.getAddress());
        commonIndex.setDtTime(new Date());
        commonIndex.setName2(expressRecord.getReceiverName());
        commonIndex.setIdCardNum2("");
        commonIndex.setLocation2(expressRecord.getReceiverAddress());

        commonIndex.setContent(expressRecord.toString());

        commonIndex.setUrl(expressRecord.getDetailsUrl());

        ExpressCompany expressCompany = expressCompanyService.queryObject(expressUser.getCompanyId());
        //名称
        commonIndex.setInformationProvider(expressCompany.getName() + " - " + expressUser.getBranchName());
        //地址
        commonIndex.setProviderAddress(expressUser.getAddress());
        //所属公安机关
        commonIndex.setPoliceOffice(expressUser.getPoliceOffice());
        //联系人
        commonIndex.setContactPerson(expressUser.getContactPerson());
        //联系电话
        commonIndex.setContactPhone(expressUser.getContactPhone());
        //紧急联系人
        commonIndex.setEmergencyContactPerson(expressUser.getEmergencyContactPerson());
        //紧急联系电话
        commonIndex.setEmergencyContactPhone(expressUser.getEmergencyContactPhone());
        return commonIndex;
    }
}