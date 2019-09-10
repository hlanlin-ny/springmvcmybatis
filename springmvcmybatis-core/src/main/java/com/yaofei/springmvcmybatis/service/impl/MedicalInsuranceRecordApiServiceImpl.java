package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;
import com.yaofei.springmvcmybatis.entity.*;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.repository.MedicalInsuranceCardRecordTransferRepository;
import com.yaofei.springmvcmybatis.service.*;
import com.yaofei.springmvcmybatis.utils.SignatureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("medicalInsuranceCardRecordApiService")
public class MedicalInsuranceRecordApiServiceImpl implements MedicalInsuranceCardRecordApiService {

    private static final String ES_ID_PREFIX = "medicalInsuranceCardRecord_";
    @Value("${medicalInsuranceCardRecord.record.business.type.id}")
    private Long medicalInsuranceCardRecordBusinessTypeId;
    @Autowired
    private MedicalCheckinCheckoutRecordService medicalCheckinCheckoutRecordService;

    //医院
    @Autowired
    private HospitalUnitInformationService hospitalUnitInformationService;
    //医保证
    @Autowired
    private MedicalInsuranceCardRecordService medicalInsuranceCardRecordService;
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
    private MedicalInsuranceCardRecordTransferRepository MedicalInsuranceCardRecordTransferRepository;


    @Override
    public void add(String username, String sign, Integer nonce, MedicalInsuranceCardRecord medicalInsuranceCardRecord, HttpServletRequest request) throws Exception {
        //验签
        HospitalUser hospitalUser = checkHospitalUserSign(username, sign, nonce);

        MedicalInsuranceCardRecordTransfer medicalInsuranceCardRecordTransfer = copy(medicalInsuranceCardRecord,username,hospitalUser,request);
        MedicalInsuranceCardRecordTransferRepository.save(medicalInsuranceCardRecordTransfer);//保存记录传输

        medicalInsuranceCardRecord.setAreaId(hospitalUser.getAreaId());   //区域ID
        medicalInsuranceCardRecord.setUserId(hospitalUser.getId());      //用户ID
        medicalInsuranceCardRecord.setHospitalName(hospitalUser.getHospitalName());
        medicalInsuranceCardRecord.setBusinessTypeId(medicalInsuranceCardRecordBusinessTypeId);  //设置业务类型
        medicalInsuranceCardRecord.setCollectTime(new Date());     //设置手收集时间
        medicalInsuranceCardRecord.setFileType(1);                 //设置文件类型
        medicalInsuranceCardRecord.setCreatedBy(username);
        medicalInsuranceCardRecord.setCreatedIp(request.getRemoteAddr());
        medicalInsuranceCardRecordService.save(medicalInsuranceCardRecord);         //保存记录

        //设置详情路径
        medicalInsuranceCardRecord.setDetailsUrl(request.getRequestURL().toString().replace("add", "details.html?id=" + medicalInsuranceCardRecord.getId()));

        // 把内容保存到es
        List<CommonIndex> commonIndexes = new ArrayList<>();
        CommonIndex commonIndex = getCommonIndex(hospitalUser, medicalInsuranceCardRecord);
        commonIndexes.add(commonIndex);
        String indexName = esClientServiceCommonIndex.createIndex(commonIndexes);
        medicalInsuranceCardRecord.setEsIndexName(indexName);

        medicalInsuranceCardRecordService.update(medicalInsuranceCardRecord);   //更新ES搜索下标和详情路径

        UpdatingFileClass updatingFileClass = new UpdatingFileClass();

            updatingFileClass.setId(medicalInsuranceCardRecord.getId());
            updatingFileClass.setBusinessTypeId(medicalInsuranceCardRecord.getBusinessTypeId());
            updatingFileClass.setName("");
            updatingFileClass.setSex("");
            updatingFileClass.setIdCardNo("");
            updatingFileClass.setAddress("");
            updatingFileClass.setDwmc("");
            updatingFileClass.setDetailsUrl(medicalInsuranceCardRecord.getDetailsUrl());
            updatingFileClass.setCollectTime(medicalInsuranceCardRecord.getCollectTime());
            updatingFileClass.setEsIndexName(medicalInsuranceCardRecord.getEsIndexName());
            updatingFileClass.setDetail(medicalInsuranceCardRecord.toString());
            updatingFileClass.setCreatedTime(medicalInsuranceCardRecord.getCreatedTime());
            updatingFileClass.setCreatedBy(medicalInsuranceCardRecord.getCreatedBy());
            updatingFileClass.setCreatedIp(medicalInsuranceCardRecord.getCreatedIp());
            updatingFileClass.setModificationTime(medicalInsuranceCardRecord.getModificationTime());
            updatingFileClass.setModificationBy(medicalInsuranceCardRecord.getModificationBy());
            updatingFileClass.setModificationIp(medicalInsuranceCardRecord.getModificationIp());
            updatingFileClass.setAreaId(medicalInsuranceCardRecord.getAreaId());
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
    public MedicalInsuranceCardRecord queryMedicalInsuranceCardRecord(Object id) {

        MedicalInsuranceCardRecord medicalInsuranceCardRecord = medicalInsuranceCardRecordService.queryObject(id);
        HospitalUser hospitalUser = hospitalUserService.queryObject(medicalInsuranceCardRecord.getUserId());
        HospitalUnitInformation hospitalUnitInformation = hospitalUnitInformationService.queryObject(hospitalUser.getHospitalId());
        medicalInsuranceCardRecord.setHospitalName(hospitalUnitInformation.getHospitalName());
        return medicalInsuranceCardRecord;
    }

    private CommonIndex getCommonIndex(HospitalUser hospitalUser, MedicalInsuranceCardRecord medicalInsuranceCardRecord) {
        CommonIndex commonIndex = new CommonIndex();
        commonIndex.setAreaId(medicalInsuranceCardRecord.getAreaId());
        commonIndex.setCollectTime(medicalInsuranceCardRecord.getCollectTime());
        commonIndex.setAreaName(sysAreaService.getParentString(medicalInsuranceCardRecord.getAreaId()));
        commonIndex.setBusinessTypeId(medicalInsuranceCardRecord.getBusinessTypeId());
        commonIndex.setBusinessTypeName(intelligenceBusinessTypeService.getParentString(medicalInsuranceCardRecord.getBusinessTypeId()));

        commonIndex.setCreatedTime(new Date());
        commonIndex.setFileType(medicalInsuranceCardRecord.getFileType());
        commonIndex.setId(ES_ID_PREFIX + medicalInsuranceCardRecord.getId());
        commonIndex.setSuggest(medicalInsuranceCardRecord.getMedicalType());
        //commonIndex.setTitle("医疗类型：" + medicalInsuranceCardRecord.getMedicalType()+"，确诊疾病："+medicalInsuranceCardRecord.getDiagnosisHospitalization());
        //commonIndex.setName1(medicalInsuranceCardRecord.get());
        //commonIndex.setIdCardNum1("");
        //commonIndex.setLocation1(hospitalUser.getAddress());
        //commonIndex.setDtTime(new Date());
        //commonIndex.setName2("");
        //commonIndex.setIdCardNum2("");
        //commonIndex.setLocation2("");

        commonIndex.setContent(medicalInsuranceCardRecord.toString());

        commonIndex.setUrl(medicalInsuranceCardRecord.getDetailsUrl());

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

    public MedicalInsuranceCardRecordTransfer copy(MedicalInsuranceCardRecord medicalInsuranceCardRecord,String username,HospitalUser hospitalUser,HttpServletRequest request){
        MedicalInsuranceCardRecordTransfer medicalInsuranceCardRecordTransfer = new MedicalInsuranceCardRecordTransfer();
        medicalInsuranceCardRecordTransfer.setAreaId(hospitalUser.getAreaId());   //区域ID
        medicalInsuranceCardRecordTransfer.setUserId(hospitalUser.getId());      //用户ID
        medicalInsuranceCardRecordTransfer.setHospitalName(hospitalUser.getHospitalName());
        medicalInsuranceCardRecordTransfer.setBusinessTypeId(medicalInsuranceCardRecordBusinessTypeId);  //设置业务类型
        medicalInsuranceCardRecordTransfer.setCollectTime(new Date());     //设置手收集时间
        medicalInsuranceCardRecordTransfer.setFileType(1);                 //设置文件类型
        medicalInsuranceCardRecordTransfer.setCreatedBy(username);
        medicalInsuranceCardRecordTransfer.setCreatedIp(request.getRemoteAddr());
        medicalInsuranceCardRecordTransfer.setYLLB(medicalInsuranceCardRecord.getMedicalType());
        medicalInsuranceCardRecordTransfer.setXXZJBH(medicalInsuranceCardRecord.getInfoKey());
        medicalInsuranceCardRecordTransfer.setYLLBDM(medicalInsuranceCardRecord.getMedicalTypeCode());
        medicalInsuranceCardRecordTransfer.setYLF_JE(medicalInsuranceCardRecord.getCost());
        medicalInsuranceCardRecordTransfer.setRYRQ(medicalInsuranceCardRecord.getHospitalizationDatetime());
        medicalInsuranceCardRecordTransfer.setCYRQ(medicalInsuranceCardRecord.getLeavehospitalDatetime());
        medicalInsuranceCardRecordTransfer.setRYJB_JYQK(medicalInsuranceCardRecord.getHospitalizationIllness());
        medicalInsuranceCardRecordTransfer.setQZJB_JYQK(medicalInsuranceCardRecord.getDiagnosisHospitalization());
        medicalInsuranceCardRecordTransfer.setBFZ_JYQK(medicalInsuranceCardRecord.getComplicationDetail());
        medicalInsuranceCardRecordTransfer.setCYYY_JYQK(medicalInsuranceCardRecord.getLeavehospitalReason());
        medicalInsuranceCardRecordTransfer.setYS_XM(medicalInsuranceCardRecord.getDoctor());
        medicalInsuranceCardRecordTransfer.setZYH(medicalInsuranceCardRecord.getHospitalizationNo());
        medicalInsuranceCardRecordTransfer.setKS_DWMC(medicalInsuranceCardRecord.getHospitalizationDepartment());
        medicalInsuranceCardRecordTransfer.setBLRQ(medicalInsuranceCardRecord.getTakeDatetime());
        medicalInsuranceCardRecordTransfer.setJBR_XM(medicalInsuranceCardRecord.getResponsiblePersonName());
        medicalInsuranceCardRecordTransfer.setYYBH(medicalInsuranceCardRecord.getHospitalNumber());
        medicalInsuranceCardRecordTransfer.setGRBH(medicalInsuranceCardRecord.getPersonNumber());
        medicalInsuranceCardRecordTransfer.setDWBH(medicalInsuranceCardRecord.getOrganizationNumber());
        medicalInsuranceCardRecordTransfer.setBXBZ(medicalInsuranceCardRecord.getReimbursementSign());
        medicalInsuranceCardRecordTransfer.setBXBZ_JYQK(medicalInsuranceCardRecord.getReimbursementSignDetail());
        medicalInsuranceCardRecordTransfer.setJSZT(medicalInsuranceCardRecord.getAccountEndStatus());
        medicalInsuranceCardRecordTransfer.setJSZT_JYQK(medicalInsuranceCardRecord.getAccountEndStatusDetail());
        medicalInsuranceCardRecordTransfer.setBZ(medicalInsuranceCardRecord.getRemark());
        return medicalInsuranceCardRecordTransfer;
    }
}
