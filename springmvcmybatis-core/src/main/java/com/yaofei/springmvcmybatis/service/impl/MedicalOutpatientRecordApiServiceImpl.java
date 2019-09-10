package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;
import com.yaofei.springmvcmybatis.entity.*;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.repository.MedicalOutpatientRecordTransferRepository;
import com.yaofei.springmvcmybatis.service.*;
import com.yaofei.springmvcmybatis.utils.SignatureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("medicalOutpatientRecordApiService")
public class MedicalOutpatientRecordApiServiceImpl implements MedicalOutpatientRecordApiService {

	private static final String ES_ID_PREFIX = "medicalOutpatientRecord_";
	@Value("${medicalOutpatient.record.business.type.id}")
	private Long medicalOutpatientRecordBusinessTypeId;

	//医院
	@Autowired
	private HospitalUnitInformationService hospitalUnitInformationService;
	//医疗门诊
	@Autowired
	private MedicalOutpatientRecordService medicalOutpatientRecordService;
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
	private MedicalOutpatientRecordTransferRepository medicalOutpatientRecordTransferRepository;


	@Override
	public void add(String username, String sign, Integer nonce, MedicalOutpatientRecord medicalOutpatientRecord, HttpServletRequest request) throws Exception {
		HospitalUser hospitalUser = checkHospitalUserrSign(username, sign, nonce);
		//设置传输对象
        MedicalOutpatientRecordTransfer medicalOutpatientRecordTransfer = copy(medicalOutpatientRecord,hospitalUser,request,username);
		medicalOutpatientRecordTransferRepository.save(medicalOutpatientRecordTransfer);
		medicalOutpatientRecord.setAreaId(hospitalUser.getAreaId());
		medicalOutpatientRecord.setUserId(hospitalUser.getId());
		medicalOutpatientRecord.setHospitalName(hospitalUser.getHospitalName());
		medicalOutpatientRecord.setBusinessTypeId(medicalOutpatientRecordBusinessTypeId);
		medicalOutpatientRecord.setCollectTime(new Date());
		medicalOutpatientRecord.setFileType(1);
		medicalOutpatientRecord.setCreatedBy(username);
		medicalOutpatientRecord.setCreatedIp(request.getRemoteAddr());
		medicalOutpatientRecordService.save(medicalOutpatientRecord);

		//更新
		medicalOutpatientRecord.setDetailsUrl(request.getRequestURL().toString().replace("add", "details.html?id=" + medicalOutpatientRecord.getId()));
		medicalOutpatientRecordTransfer.setDetailsUrl(request.getRequestURL().toString().replace("add", "details.html?id=" + medicalOutpatientRecord.getId()));

		// 把内容保存到es
		List<CommonIndex> commonIndexes = new ArrayList<>();
		CommonIndex commonIndex = getCommonIndex(hospitalUser, medicalOutpatientRecord);
		commonIndexes.add(commonIndex);
		String indexName = esClientServiceCommonIndex.createIndex(commonIndexes);
		medicalOutpatientRecord.setEsIndexName(indexName);
		medicalOutpatientRecordTransfer.setEsIndexName(indexName);
		medicalOutpatientRecordService.update(medicalOutpatientRecord);
		medicalOutpatientRecordTransferRepository.update(medicalOutpatientRecordTransfer);
		UpdatingFileClass updatingFileClass = new UpdatingFileClass();
			updatingFileClass.setId(medicalOutpatientRecord.getId());
			updatingFileClass.setBusinessTypeId(medicalOutpatientRecord.getBusinessTypeId());
			updatingFileClass.setName(medicalOutpatientRecord.getName());
			updatingFileClass.setSex(medicalOutpatientRecord.getSex());
			updatingFileClass.setIdCardNo(medicalOutpatientRecord.getIdCardNum());
			updatingFileClass.setAddress(medicalOutpatientRecord.getAddress());
			updatingFileClass.setDwmc(medicalOutpatientRecord.getOrganization());
			updatingFileClass.setDetailsUrl(medicalOutpatientRecord.getDetailsUrl());
			updatingFileClass.setCollectTime(medicalOutpatientRecord.getCollectTime());
			updatingFileClass.setEsIndexName(medicalOutpatientRecord.getEsIndexName());
			updatingFileClass.setDetail(medicalOutpatientRecord.toString());
			updatingFileClass.setCreatedTime(medicalOutpatientRecord.getCreatedTime());
			updatingFileClass.setCreatedBy(medicalOutpatientRecord.getCreatedBy());
			updatingFileClass.setCreatedIp(medicalOutpatientRecord.getCreatedIp());
			updatingFileClass.setModificationTime(medicalOutpatientRecord.getModificationTime());
			updatingFileClass.setModificationBy(medicalOutpatientRecord.getModificationBy());
			updatingFileClass.setModificationIp(medicalOutpatientRecord.getModificationIp());
			updatingFileClass.setAreaId(medicalOutpatientRecord.getAreaId());
			medicalOutpatientRecordService.insertCommon(updatingFileClass);
	}

		@Override
		public HospitalUser checkHospitalUserrSign(String username, String sign, Integer nonce) throws Exception {
			HospitalUser hospitalUser = hospitalUserService.queryHospitalUsersByUserName(username);
			if (hospitalUser == null) {
				throw new BussinessException("用户权限验证失败");
			}

			String newsign = SignatureUtil
					.encryptBASE64(SignatureUtil.hmacSHA1Encrypt(nonce.toString().getBytes("UTF-8"), hospitalUser.getSeckey()));
			if (!newsign.equals(sign)) {
				throw new BussinessException("用户签名验证失败");
			}
			return hospitalUser;
		}

	@Override
	public MedicalOutpatientRecord queryMedicalOutpatientRecord(Object id) {
		MedicalOutpatientRecord medicalOutpatientRecord = medicalOutpatientRecordService.queryObject(id);
		HospitalUser hospitalUser = hospitalUserService.queryObject(medicalOutpatientRecord.getUserId());
		HospitalUnitInformation hospitalUnitInformation = hospitalUnitInformationService.queryObject(hospitalUser.getHospitalId());
		medicalOutpatientRecord.setHospitalName(hospitalUnitInformation.getHospitalName());
		return medicalOutpatientRecord;
	}

	private CommonIndex getCommonIndex(HospitalUser hospitalUser, MedicalOutpatientRecord medicalOutpatientRecord) {
		CommonIndex commonIndex = new CommonIndex();
		commonIndex.setAreaId(medicalOutpatientRecord.getAreaId());
		commonIndex.setCollectTime(medicalOutpatientRecord.getCollectTime());
		commonIndex.setAreaName(sysAreaService.getParentString(medicalOutpatientRecord.getAreaId()));
		commonIndex.setBusinessTypeId(medicalOutpatientRecord.getBusinessTypeId());
		commonIndex.setBusinessTypeName(intelligenceBusinessTypeService.getParentString(medicalOutpatientRecord.getBusinessTypeId()));

		commonIndex.setCreatedTime(new Date());
		commonIndex.setFileType(medicalOutpatientRecord.getFileType());
		commonIndex.setId(ES_ID_PREFIX + medicalOutpatientRecord.getId());
		commonIndex.setSuggest(medicalOutpatientRecord.getName());
		//commonIndex.setTitle("医疗门诊人姓名：" + medicalOutpatientRecord.getName() + " 医疗门诊人身份证号：" + medicalOutpatientRecord.getIdCardNum());
		commonIndex.setName1(medicalOutpatientRecord.getName());
		commonIndex.setIdCardNum1(medicalOutpatientRecord.getIdCardNum());
		commonIndex.setLocation1(hospitalUser.getAddress());
		commonIndex.setDtTime(new Date());
		commonIndex.setName2("");
		commonIndex.setIdCardNum2("");
		commonIndex.setLocation2("");

		commonIndex.setContent(medicalOutpatientRecord.toString());

		commonIndex.setUrl(medicalOutpatientRecord.getDetailsUrl());

		HospitalUnitInformation hospitalUnitInformation = hospitalUnitInformationService.queryObject(hospitalUser.getHospitalId());
		//名称
		commonIndex.setInformationProvider(hospitalUnitInformation.getHospitalName() + " - " + hospitalUser.getHospitalName());
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

	public MedicalOutpatientRecordTransfer copy(MedicalOutpatientRecord medicalOutpatientRecord,HospitalUser hospitalUser,HttpServletRequest request,String username){
		MedicalOutpatientRecordTransfer medicalOutpatientRecordTransfer = new MedicalOutpatientRecordTransfer();
		medicalOutpatientRecordTransfer.setAreaId(hospitalUser.getAreaId());
		medicalOutpatientRecordTransfer.setUserId(hospitalUser.getId());
		medicalOutpatientRecordTransfer.setHospitalName(hospitalUser.getHospitalName());
		medicalOutpatientRecordTransfer.setBusinessTypeId(medicalOutpatientRecordBusinessTypeId);
		medicalOutpatientRecordTransfer.setCollectTime(new Date());
		medicalOutpatientRecordTransfer.setFileType(1);
		medicalOutpatientRecordTransfer.setCreatedBy(username);
		medicalOutpatientRecordTransfer.setCreatedIp(request.getRemoteAddr());
		medicalOutpatientRecordTransfer.setName(medicalOutpatientRecord.getName());
		medicalOutpatientRecordTransfer.setXXZJBH(medicalOutpatientRecord.getInfoKey());
		medicalOutpatientRecordTransfer.setXMHYPY(medicalOutpatientRecord.getNameSpell());
		medicalOutpatientRecordTransfer.setXB(medicalOutpatientRecord.getSex());
		medicalOutpatientRecordTransfer.setXBDM(medicalOutpatientRecord.getSexCode());
		medicalOutpatientRecordTransfer.setCSRQ(medicalOutpatientRecord.getBornTime());
		medicalOutpatientRecordTransfer.setNL(medicalOutpatientRecord.getAge());
		medicalOutpatientRecordTransfer.setIdCardNo(medicalOutpatientRecord.getIdCardNum());
		medicalOutpatientRecordTransfer.setPhone(medicalOutpatientRecord.getPhone());
		medicalOutpatientRecordTransfer.setAddress(medicalOutpatientRecord.getAddress());
		medicalOutpatientRecordTransfer.setProfession(medicalOutpatientRecord.getProfession());
		medicalOutpatientRecordTransfer.setWorkUnit(medicalOutpatientRecord.getOrganization());
		medicalOutpatientRecordTransfer.setYY_DWMC(hospitalUser.getHospitalName());
		medicalOutpatientRecordTransfer.setDiagnoseDatetime(medicalOutpatientRecord.getDiagnoseDatetime());
		medicalOutpatientRecordTransfer.setDiagnoseNo(medicalOutpatientRecord.getDiagnoseNo());
		medicalOutpatientRecordTransfer.setDiagnoseDepartment(medicalOutpatientRecord.getDiagnoseDepartment());
		medicalOutpatientRecordTransfer.setCostType(medicalOutpatientRecord.getCostType());
		medicalOutpatientRecordTransfer.setRYLBDM(medicalOutpatientRecord.getCostTypeCode());
		medicalOutpatientRecordTransfer.setCost(medicalOutpatientRecord.getCost());
		medicalOutpatientRecordTransfer.setMedicareCardNo(medicalOutpatientRecord.getMedicareCardNo());
		medicalOutpatientRecordTransfer.setDiagnoseResult(medicalOutpatientRecord.getDiagnoseResult());
		medicalOutpatientRecordTransfer.setBZ(medicalOutpatientRecord.getRemark());
		return medicalOutpatientRecordTransfer;
	}
}
