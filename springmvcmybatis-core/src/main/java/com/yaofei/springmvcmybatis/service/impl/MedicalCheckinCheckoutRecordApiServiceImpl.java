package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;
import com.yaofei.springmvcmybatis.entity.*;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.repository.MedicalCheckinCheckoutRecordTransferRepository;
import com.yaofei.springmvcmybatis.service.*;
import com.yaofei.springmvcmybatis.utils.SignatureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service( "medicalCheckinCheckoutRecordApiService" )
public class MedicalCheckinCheckoutRecordApiServiceImpl implements MedicalCheckinCheckoutRecordApiService {

    private static final String ES_ID_PREFIX = "medicalCheckinCheckoutRecord_";
    @Value( "${medicalCheckinCheckout.record.business.type.id}" )
    private Long medicalCheckinCheckoutecordBusinessTypeId;

    //医院
    @Autowired
    private HospitalUnitInformationService hospitalUnitInformationService;
    //医疗出（住）院
    @Autowired
    private MedicalCheckinCheckoutRecordService medicalCheckinCheckoutRecordService;
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
    private MedicalCheckinCheckoutRecordTransferRepository medicalCheckinCheckoutRecordTransferRepository;


    @Override
    public void add(String username, String sign, Integer nonce, MedicalCheckinCheckoutRecord medicalCheckinCheckoutRecord, HttpServletRequest request) throws Exception {
        //验签
        HospitalUser hospitalUser = checkHospitalUserSign(username, sign, nonce);

        MedicalCheckinCheckoutRecordTransfer medicalCheckinCheckoutRecordTransfer = copy(medicalCheckinCheckoutRecord, username, hospitalUser, request);
        medicalCheckinCheckoutRecordTransferRepository.save(medicalCheckinCheckoutRecordTransfer);//保存记录传输

        medicalCheckinCheckoutRecord.setAreaId(hospitalUser.getAreaId());   //区域ID
        medicalCheckinCheckoutRecord.setUserId(hospitalUser.getId());      //用户ID
        medicalCheckinCheckoutRecord.setHospitalName(hospitalUser.getHospitalName());
        medicalCheckinCheckoutRecord.setBusinessTypeId(medicalCheckinCheckoutecordBusinessTypeId);  //设置业务类型
        medicalCheckinCheckoutRecord.setCollectTime(new Date());     //设置手收集时间
        medicalCheckinCheckoutRecord.setFileType(1);                 //设置文件类型
        medicalCheckinCheckoutRecord.setCreatedBy(username);
        medicalCheckinCheckoutRecord.setCreatedIp(request.getRemoteAddr());
        medicalCheckinCheckoutRecordService.save(medicalCheckinCheckoutRecord);         //保存记录
        //设置详情路径
        medicalCheckinCheckoutRecord.setDetailsUrl(request.getRequestURL().toString().replace("add", "details.html?id=" + medicalCheckinCheckoutRecord.getId()));

        // 把内容保存到es
        List<CommonIndex> commonIndexes = new ArrayList<>();
        CommonIndex commonIndex = getCommonIndex(hospitalUser, medicalCheckinCheckoutRecord);
        commonIndexes.add(commonIndex);
        String indexName = esClientServiceCommonIndex.createIndex(commonIndexes);
        medicalCheckinCheckoutRecord.setEsIndexName(indexName);

        medicalCheckinCheckoutRecordService.update(medicalCheckinCheckoutRecord);   //更新ES搜索下标和详情路径
        //将数据同步到共通表中
        UpdatingFileClass updatingFileClass = new UpdatingFileClass();
        updatingFileClass.setId(medicalCheckinCheckoutRecord.getId());
        updatingFileClass.setBusinessTypeId(medicalCheckinCheckoutRecord.getBusinessTypeId());
        updatingFileClass.setName(medicalCheckinCheckoutRecord.getName());
        updatingFileClass.setSex(medicalCheckinCheckoutRecord.getSex());
        updatingFileClass.setIdCardNo(medicalCheckinCheckoutRecord.getIdCardNum());
        updatingFileClass.setAddress(medicalCheckinCheckoutRecord.getAddress());
        updatingFileClass.setDwmc(medicalCheckinCheckoutRecord.getOrganization());
        updatingFileClass.setDetailsUrl(medicalCheckinCheckoutRecord.getDetailsUrl());
        updatingFileClass.setCollectTime(medicalCheckinCheckoutRecord.getCollectTime());
        updatingFileClass.setEsIndexName(medicalCheckinCheckoutRecord.getEsIndexName());
        updatingFileClass.setDetail(medicalCheckinCheckoutRecord.toString());
        updatingFileClass.setCreatedTime(medicalCheckinCheckoutRecord.getCreatedTime());
        updatingFileClass.setCreatedBy(medicalCheckinCheckoutRecord.getCreatedBy());
        updatingFileClass.setCreatedIp(medicalCheckinCheckoutRecord.getCreatedIp());
        updatingFileClass.setModificationTime(medicalCheckinCheckoutRecord.getModificationTime());
        updatingFileClass.setModificationBy(medicalCheckinCheckoutRecord.getModificationBy());
        updatingFileClass.setModificationIp(medicalCheckinCheckoutRecord.getModificationIp());
        updatingFileClass.setAreaId(medicalCheckinCheckoutRecord.getAreaId());
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
    public MedicalCheckinCheckoutRecord queryMedicalCheckinCheckoutRecord(Object id) {

        MedicalCheckinCheckoutRecord medicalCheckinCheckoutRecord = medicalCheckinCheckoutRecordService.queryObject(id);
        HospitalUser hospitalUser = hospitalUserService.queryObject(medicalCheckinCheckoutRecord.getUserId());
        HospitalUnitInformation hospitalUnitInformation = hospitalUnitInformationService.queryObject(hospitalUser.getHospitalId());
        medicalCheckinCheckoutRecord.setHospitalName(hospitalUnitInformation.getHospitalName());
        return medicalCheckinCheckoutRecord;
    }

    private CommonIndex getCommonIndex(HospitalUser hospitalUser, MedicalCheckinCheckoutRecord medicalCheckinCheckoutRecord) {
        CommonIndex commonIndex = new CommonIndex();
        commonIndex.setAreaId(medicalCheckinCheckoutRecord.getAreaId());
        commonIndex.setCollectTime(medicalCheckinCheckoutRecord.getCollectTime());
        commonIndex.setAreaName(sysAreaService.getParentString(medicalCheckinCheckoutRecord.getAreaId()));
        commonIndex.setBusinessTypeId(medicalCheckinCheckoutRecord.getBusinessTypeId());
        commonIndex.setBusinessTypeName(intelligenceBusinessTypeService.getParentString(medicalCheckinCheckoutRecord.getBusinessTypeId()));

        commonIndex.setCreatedTime(new Date());
        commonIndex.setFileType(medicalCheckinCheckoutRecord.getFileType());
        commonIndex.setId(ES_ID_PREFIX + medicalCheckinCheckoutRecord.getId());
        commonIndex.setSuggest(medicalCheckinCheckoutRecord.getName());
        //commonIndex.setTitle("医疗住（出）院人姓名：" + medicalCheckinCheckoutRecord.getName() + " 医疗住（出）院人身份证号：" + medicalCheckinCheckoutRecord.getIdCardNum());


        commonIndex.setName1(medicalCheckinCheckoutRecord.getName());
        commonIndex.setIdCardNum1(medicalCheckinCheckoutRecord.getIdCardNum());
        commonIndex.setLocation1(hospitalUser.getAddress());
        commonIndex.setDtTime(new Date());
        commonIndex.setName2("");
        commonIndex.setIdCardNum2("");
        commonIndex.setLocation2("");

        commonIndex.setContent(medicalCheckinCheckoutRecord.toString());

        commonIndex.setUrl(medicalCheckinCheckoutRecord.getDetailsUrl());

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

    public MedicalCheckinCheckoutRecordTransfer copy(MedicalCheckinCheckoutRecord medicalCheckinCheckoutRecord, String username, HospitalUser hospitalUser, HttpServletRequest request) {
        MedicalCheckinCheckoutRecordTransfer medicalCheckinCheckoutRecordTransfer = new MedicalCheckinCheckoutRecordTransfer();
        medicalCheckinCheckoutRecordTransfer.setAreaId(hospitalUser.getAreaId());   //区域ID
        medicalCheckinCheckoutRecordTransfer.setUserId(hospitalUser.getId());      //用户ID
        medicalCheckinCheckoutRecordTransfer.setHospitalName(hospitalUser.getHospitalName());
        medicalCheckinCheckoutRecordTransfer.setBusinessTypeId(medicalCheckinCheckoutecordBusinessTypeId);  //设置业务类型
        medicalCheckinCheckoutRecordTransfer.setCollectTime(new Date());     //设置手收集时间
        medicalCheckinCheckoutRecordTransfer.setFileType(1);                 //设置文件类型
        medicalCheckinCheckoutRecordTransfer.setCreatedBy(username);
        medicalCheckinCheckoutRecordTransfer.setCreatedIp(request.getRemoteAddr());
        medicalCheckinCheckoutRecordTransfer.setName(medicalCheckinCheckoutRecord.getName());
        medicalCheckinCheckoutRecordTransfer.setXMHYPY(medicalCheckinCheckoutRecord.getNameSpell());
        medicalCheckinCheckoutRecordTransfer.setXB(medicalCheckinCheckoutRecord.getSex());
        medicalCheckinCheckoutRecordTransfer.setXBDM(medicalCheckinCheckoutRecord.getSexCode());
        medicalCheckinCheckoutRecordTransfer.setCSRQ(medicalCheckinCheckoutRecord.getBornTime());
        medicalCheckinCheckoutRecordTransfer.setNL(medicalCheckinCheckoutRecord.getAge());
        medicalCheckinCheckoutRecordTransfer.setIdCardNo(medicalCheckinCheckoutRecord.getIdCardNum());
        medicalCheckinCheckoutRecordTransfer.setPhone(medicalCheckinCheckoutRecord.getPhone());
        medicalCheckinCheckoutRecordTransfer.setAddress(medicalCheckinCheckoutRecord.getAddress());
        medicalCheckinCheckoutRecordTransfer.setProfession(medicalCheckinCheckoutRecord.getProfession());
        medicalCheckinCheckoutRecordTransfer.setWorkUnit(medicalCheckinCheckoutRecord.getOrganization());
        medicalCheckinCheckoutRecordTransfer.setHZ_XM(medicalCheckinCheckoutRecord.getHouseHeadName());
        medicalCheckinCheckoutRecordTransfer.setJTRK_RS(medicalCheckinCheckoutRecord.getFamilyPopulation());
        medicalCheckinCheckoutRecordTransfer.setJTLB(medicalCheckinCheckoutRecord.getFamilyType());
        medicalCheckinCheckoutRecordTransfer.setJTLBDM(medicalCheckinCheckoutRecord.getFamilyTypeCode());
        medicalCheckinCheckoutRecordTransfer.setYY_DWMC(hospitalUser.getHospitalName());
        medicalCheckinCheckoutRecordTransfer.setYBZ_ZJHM(medicalCheckinCheckoutRecord.getMedicalGuaranteeNumber());
        medicalCheckinCheckoutRecordTransfer.setHospitalizationNo(medicalCheckinCheckoutRecord.getHospitalizationNo());
        medicalCheckinCheckoutRecordTransfer.setHospitalizationDepartment(medicalCheckinCheckoutRecord.getHospitalizationDepartment());
        medicalCheckinCheckoutRecordTransfer.setCH(medicalCheckinCheckoutRecord.getBedNumber());
        medicalCheckinCheckoutRecordTransfer.setRYTJ_JYQK(medicalCheckinCheckoutRecord.getHospitalWay());
        medicalCheckinCheckoutRecordTransfer.setYS_XM(medicalCheckinCheckoutRecord.getDoctorName());
        medicalCheckinCheckoutRecordTransfer.setRYZD_JYQK(medicalCheckinCheckoutRecord.getAdmittingDiagnosis());
        medicalCheckinCheckoutRecordTransfer.setCYZD_JYQK(medicalCheckinCheckoutRecord.getDischargeDiagnosis());
        medicalCheckinCheckoutRecordTransfer.setJZDX_PDBZ(medicalCheckinCheckoutRecord.getSubjectSalvage());
        medicalCheckinCheckoutRecordTransfer.setJZDXLB(medicalCheckinCheckoutRecord.getSubjectSalvageType());
        medicalCheckinCheckoutRecordTransfer.setJZJ_JE(medicalCheckinCheckoutRecord.getSubjectSalvageCost());
        medicalCheckinCheckoutRecordTransfer.setJBR_XM(medicalCheckinCheckoutRecord.getResponsiblePersonName());
        medicalCheckinCheckoutRecordTransfer.setHospitalizationDatetime(medicalCheckinCheckoutRecord.getHospitalizationDatetime());
        medicalCheckinCheckoutRecordTransfer.setLeavehospitalDatetime(medicalCheckinCheckoutRecord.getLeavehospitalDatetime());
        medicalCheckinCheckoutRecordTransfer.setBZ(medicalCheckinCheckoutRecord.getRemark());
        return medicalCheckinCheckoutRecordTransfer;
    }
}
