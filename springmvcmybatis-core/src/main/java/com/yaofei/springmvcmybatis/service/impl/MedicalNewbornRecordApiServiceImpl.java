package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;
import com.yaofei.springmvcmybatis.entity.*;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.repository.MedicalNewbornRecordTransferRepository;
import com.yaofei.springmvcmybatis.service.*;
import com.yaofei.springmvcmybatis.utils.SignatureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("medicalNewbornRecordApiService")
public class MedicalNewbornRecordApiServiceImpl implements MedicalNewbornRecordApiService {

    private static final String ES_ID_PREFIX = "medicalNewbornRecord_";
    @Value("${medicalNewbornRecord.record.business.type.id}")
    private Long medicalNewbornRecordBusinessTypeId;

    //医院
    @Autowired
    private HospitalUnitInformationService hospitalUnitInformationService;
    //医疗出（住）院
    @Autowired
    private MedicalNewbornRecordService medicalNewbornRecordService;
    //医院网点信息
    @Autowired
    private HospitalUserService hospitalUserService;
    @Autowired
    private IntelligenceBusinessTypeService intelligenceBusinessTypeService;
    @Autowired
    private SysAreaService sysAreaService;
    @Autowired
    private EsClientServiceCommonIndex esClientServiceCommonIndex;
    @Autowired
    private MedicalNewbornRecordTransferRepository medicalNewbornRecordTransferRepository;
    @Autowired
    private MedicalCheckinCheckoutRecordService medicalCheckinCheckoutRecordService;


    @Override
    public void add(String username, String sign, Integer nonce,MedicalNewbornRecord medicalNewbornRecord, HttpServletRequest request) throws Exception {
        //验签
        HospitalUser hospitalUser = checkHospitalUserSign(username, sign, nonce);

        MedicalNewbornRecordTransfer medicalNewbornRecordTransfer = copy(medicalNewbornRecord,username,hospitalUser,request);
        medicalNewbornRecordTransferRepository.save(medicalNewbornRecordTransfer);//保存记录传输

        medicalNewbornRecord.setAreaId(hospitalUser.getAreaId());   //区域ID
        medicalNewbornRecord.setUserId(hospitalUser.getId());      //用户ID
        medicalNewbornRecord.setHospitalName(hospitalUser.getHospitalName());
        medicalNewbornRecord.setBusinessTypeId(medicalNewbornRecordBusinessTypeId);  //设置业务类型
        medicalNewbornRecord.setCollectTime(new Date());     //设置手收集时间
        medicalNewbornRecord.setFileType(1);                 //设置文件类型
        medicalNewbornRecord.setCreatedBy(username);
        medicalNewbornRecord.setCreatedIp(request.getRemoteAddr());
        medicalNewbornRecordService.save(medicalNewbornRecord);         //保存记录
        //设置详情路径
        medicalNewbornRecord.setDetailsUrl(request.getRequestURL().toString().replace("add", "details.html?id=" + medicalNewbornRecord.getId()));
        // 把内容保存到es
        List<CommonIndex> commonIndexes = new ArrayList<>();
        CommonIndex commonIndex = getCommonIndex(hospitalUser, medicalNewbornRecord);
        commonIndexes.add(commonIndex);
        String indexName = esClientServiceCommonIndex.createIndex(commonIndexes);
        medicalNewbornRecord.setEsIndexName(indexName);

        medicalNewbornRecordService.update(medicalNewbornRecord);   //更新ES搜索下标和详情路径
        UpdatingFileClass updatingFileClass = new UpdatingFileClass();
            updatingFileClass.setId(medicalNewbornRecord.getId());
            updatingFileClass.setBusinessTypeId(medicalNewbornRecord.getBusinessTypeId());
            updatingFileClass.setName(medicalNewbornRecord.getName());
            updatingFileClass.setSex(medicalNewbornRecord.getSex());
            updatingFileClass.setIdCardNo(medicalNewbornRecord.getIdCardNum());
            updatingFileClass.setAddress(medicalNewbornRecord.getAddress());
            updatingFileClass.setDwmc("");
            updatingFileClass.setDetailsUrl(medicalNewbornRecord.getDetailsUrl());
            updatingFileClass.setCollectTime(medicalNewbornRecord.getCollectTime());
            updatingFileClass.setEsIndexName(medicalNewbornRecord.getEsIndexName());
            updatingFileClass.setDetail(medicalNewbornRecord.toString());
            updatingFileClass.setCreatedTime(medicalNewbornRecord.getCreatedTime());
            updatingFileClass.setCreatedBy(medicalNewbornRecord.getCreatedBy());
            updatingFileClass.setCreatedIp(medicalNewbornRecord.getCreatedIp());
            updatingFileClass.setModificationTime(medicalNewbornRecord.getModificationTime());
            updatingFileClass.setModificationBy(medicalNewbornRecord.getModificationBy());
            updatingFileClass.setModificationIp(medicalNewbornRecord.getModificationIp());
            updatingFileClass.setAreaId(medicalNewbornRecord.getAreaId());
            medicalCheckinCheckoutRecordService.insertCommon(updatingFileClass);
    }

    @Override
    public HospitalUser checkHospitalUserSign(String username, String sign, Integer nonce) throws Exception {
        //检查用户是否存在 存在进行验签
        HospitalUser hospitalUser = hospitalUserService.queryHospitalUsersByUserName(username);
        if (hospitalUser == null) {
            throw new BussinessException("用户权限验证失败");
        }
        //验签
        String newsign = SignatureUtil
                .encryptBASE64(SignatureUtil.hmacSHA1Encrypt(nonce.toString().getBytes("UTF-8"), hospitalUser.getSeckey()));
        if (!newsign.equals(sign)) {
            throw new BussinessException("用户签名验证失败");
        }
        return hospitalUser;
    }

    @Override
    public MedicalNewbornRecord queryMedicalNewbornRecord(Object id) {

        MedicalNewbornRecord medicalNewbornRecord = medicalNewbornRecordService.queryObject(id);
        HospitalUser hospitalUser = hospitalUserService.queryObject(medicalNewbornRecord.getUserId());
        HospitalUnitInformation hospitalUnitInformation = hospitalUnitInformationService.queryObject(hospitalUser.getHospitalId());
        medicalNewbornRecord.setHospitalName(hospitalUnitInformation.getHospitalName());
        return medicalNewbornRecord;
    }

    private CommonIndex getCommonIndex(HospitalUser hospitalUser, MedicalNewbornRecord medicalNewbornRecord) {
        CommonIndex commonIndex = new CommonIndex();
        commonIndex.setAreaId(medicalNewbornRecord.getAreaId());
        commonIndex.setCollectTime(medicalNewbornRecord.getCollectTime());
        commonIndex.setAreaName(sysAreaService.getParentString(medicalNewbornRecord.getAreaId()));
        commonIndex.setBusinessTypeId(medicalNewbornRecord.getBusinessTypeId());
        commonIndex.setBusinessTypeName(intelligenceBusinessTypeService.getParentString(medicalNewbornRecord.getBusinessTypeId()));

        commonIndex.setCreatedTime(new Date());
        commonIndex.setFileType(medicalNewbornRecord.getFileType());
        commonIndex.setId(ES_ID_PREFIX + medicalNewbornRecord.getId());
        commonIndex.setSuggest(medicalNewbornRecord.getName());
        //commonIndex.setTitle("新生儿姓名：" + medicalNewbornRecord.getName() + " 新生儿身份证号：" + medicalNewbornRecord.getIdCardNum());

        commonIndex.setName1(medicalNewbornRecord.getName());
        commonIndex.setIdCardNum1(medicalNewbornRecord.getIdCardNum());
        commonIndex.setLocation1(hospitalUser.getAddress());
        commonIndex.setDtTime(new Date());
        commonIndex.setName2("");
        commonIndex.setIdCardNum2("");
        commonIndex.setLocation2("");

        commonIndex.setContent(medicalNewbornRecord.toString());

        commonIndex.setUrl(medicalNewbornRecord.getDetailsUrl());

        HospitalUnitInformation hospitalUnitInformation = hospitalUnitInformationService.queryObject(hospitalUser.getHospitalId());
        //名称
        commonIndex.setInformationProvider(hospitalUnitInformation.getHospitalName() + " - " + hospitalUser.getBranchName());
        //地址
        commonIndex.setProviderAddress(hospitalUser.getAddress());
        //所属公安机关
        commonIndex.setPoliceOffice(hospitalUser.getPoliceOffice());
        //联系人
        commonIndex.setContactPerson(hospitalUser.getContactPerson());
        //联系电话
        commonIndex.setContactPhone(hospitalUser.getContactPhone());
        //紧急联系人
        commonIndex.setEmergencyContactPerson(hospitalUser.getEmergencyContactPerson());
        //紧急联系电话
        commonIndex.setEmergencyContactPhone(hospitalUser.getEmergencyContactPhone());
        return commonIndex;
    }

    public MedicalNewbornRecordTransfer copy(MedicalNewbornRecord medicalNewbornRecord,String username,HospitalUser hospitalUser,HttpServletRequest request){
        MedicalNewbornRecordTransfer medicalNewbornRecordTransfer = new MedicalNewbornRecordTransfer();
        medicalNewbornRecordTransfer.setAreaId(hospitalUser.getAreaId());   //区域ID
        medicalNewbornRecordTransfer.setUserId(hospitalUser.getId());      //用户ID
        medicalNewbornRecordTransfer.setHospitalName(hospitalUser.getHospitalName());
        medicalNewbornRecordTransfer.setBusinessTypeId(medicalNewbornRecordBusinessTypeId);  //设置业务类型
        medicalNewbornRecordTransfer.setCollectTime(new Date());     //设置手收集时间
        medicalNewbornRecordTransfer.setFileType(1);                 //设置文件类型
        medicalNewbornRecordTransfer.setCreatedBy(username);
        medicalNewbornRecordTransfer.setCreatedIp(request.getRemoteAddr());
        medicalNewbornRecordTransfer.setXM(medicalNewbornRecord.getName());
        medicalNewbornRecordTransfer.setXB(medicalNewbornRecord.getSex());
        medicalNewbornRecordTransfer.setXXZJBH(medicalNewbornRecord.getInfoKey());
        medicalNewbornRecordTransfer.setXB_DMMS(medicalNewbornRecord.getSexDetail());
        medicalNewbornRecordTransfer.setCSRQ(medicalNewbornRecord.getBornTime());
        medicalNewbornRecordTransfer.setGMSFZH(medicalNewbornRecord.getIdCardNum());
        medicalNewbornRecordTransfer.setJSJGMC(medicalNewbornRecord.getDeliverOrganization());
        medicalNewbornRecordTransfer.setJTZZ_DZMC(medicalNewbornRecord.getAddress());
        medicalNewbornRecordTransfer.setXXDJSJ(medicalNewbornRecord.getCheckInDatetime());
        medicalNewbornRecordTransfer.setMQ_XM(medicalNewbornRecord.getMotherName());
        medicalNewbornRecordTransfer.setMQ_MZ(medicalNewbornRecord.getMotherNation());
        medicalNewbornRecordTransfer.setMQ_MZ_DMMS(medicalNewbornRecord.getMotherNationDetail());
        medicalNewbornRecordTransfer.setMQ_GMSFZH(medicalNewbornRecord.getMotherIdcardnum());
        medicalNewbornRecordTransfer.setMQ_LXDH(medicalNewbornRecord.getMotherPhone());
        medicalNewbornRecordTransfer.setFQ_XM(medicalNewbornRecord.getFatherName());
        medicalNewbornRecordTransfer.setFQ_MZ(medicalNewbornRecord.getFatherNation());
        medicalNewbornRecordTransfer.setFQ_MZ_DMMS(medicalNewbornRecord.getFatherNationDetail());
        medicalNewbornRecordTransfer.setFQ_GMSFZH(medicalNewbornRecord.getFatherIdcardnum());
        medicalNewbornRecordTransfer.setFQ_LXDH(medicalNewbornRecord.getFatherPhone());
        medicalNewbornRecordTransfer.setBZ(medicalNewbornRecord.getRemark());
        return medicalNewbornRecordTransfer;
    }
}
