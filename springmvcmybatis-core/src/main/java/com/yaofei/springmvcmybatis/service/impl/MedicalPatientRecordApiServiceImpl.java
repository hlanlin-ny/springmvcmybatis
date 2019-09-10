package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;
import com.yaofei.springmvcmybatis.entity.*;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.repository.MedicalCheckinCheckoutRecordRepository;
import com.yaofei.springmvcmybatis.repository.MedicalPatientRecordTransferRepository;
import com.yaofei.springmvcmybatis.service.*;
import com.yaofei.springmvcmybatis.utils.SignatureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("medicalPatientRecordApiService")
public class MedicalPatientRecordApiServiceImpl implements MedicalPatientRecordApiService {

	private static final String ES_ID_PREFIX = "medicalPatientRecord_";
	@Value("${medicalPatient.record.business.type.id}")
	private Long medicalPatientRecordBusinessTypeId;

	//医院
	@Autowired
	private HospitalUnitInformationService hospitalUnitInformationService;
	//医疗门诊
	@Autowired
	private MedicalPatientRecordService medicalPatientRecordService;
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
	private MedicalPatientRecordTransferRepository medicalPatientRecordTransferRepository;@Autowired
	private MedicalCheckinCheckoutRecordRepository medicalCheckinCheckoutRecordRepository;


	@Override
	public void add(String username, String sign, Integer nonce, MedicalPatientRecord medicalPatientRecord, HttpServletRequest request) throws Exception {
		HospitalUser hospitalUser = checkHospitalUserrSign(username, sign, nonce);
		//设置传输对象
        MedicalPatientRecordTransfer medicalPatientRecordTransfer = copy(medicalPatientRecord,hospitalUser,request,username);
		medicalPatientRecordTransferRepository.save(medicalPatientRecordTransfer);
		medicalPatientRecord.setAreaId(hospitalUser.getAreaId());
		medicalPatientRecord.setUserId(hospitalUser.getId());
		medicalPatientRecord.setHospitalName(hospitalUser.getHospitalName());
		medicalPatientRecord.setBusinessTypeId(medicalPatientRecordBusinessTypeId);
		medicalPatientRecord.setCollectTime(new Date());
		medicalPatientRecord.setFileType(1);
		medicalPatientRecord.setCreatedBy(username);
		medicalPatientRecord.setCreatedIp(request.getRemoteAddr());
		medicalPatientRecordService.save(medicalPatientRecord);

		//更新
		medicalPatientRecord.setDetailsUrl(request.getRequestURL().toString().replace("add", "details.html?id=" + medicalPatientRecord.getId()));

		// 把内容保存到es
		List<CommonIndex> commonIndexes = new ArrayList<>();
		CommonIndex commonIndex = getCommonIndex(hospitalUser, medicalPatientRecord);
		commonIndexes.add(commonIndex);
		String indexName = esClientServiceCommonIndex.createIndex(commonIndexes);

		medicalPatientRecord.setEsIndexName(indexName);
		medicalPatientRecordService.update(medicalPatientRecord);
		UpdatingFileClass updatingFileClass = new UpdatingFileClass();
			updatingFileClass.setId(medicalPatientRecord.getId());
			updatingFileClass.setBusinessTypeId(medicalPatientRecord.getBusinessTypeId());
			updatingFileClass.setName(medicalPatientRecord.getName());
			updatingFileClass.setSex(medicalPatientRecord.getSex());
			updatingFileClass.setIdCardNo(medicalPatientRecord.getIdCardNum());
			updatingFileClass.setAddress(medicalPatientRecord.getAddress());
			updatingFileClass.setDwmc("");
			updatingFileClass.setDetailsUrl(medicalPatientRecord.getDetailsUrl());
			updatingFileClass.setCollectTime(medicalPatientRecord.getCollectTime());
			updatingFileClass.setEsIndexName(medicalPatientRecord.getEsIndexName());
			updatingFileClass.setDetail(medicalPatientRecord.toString());
			updatingFileClass.setCreatedTime(medicalPatientRecord.getCreatedTime());
			updatingFileClass.setCreatedBy(medicalPatientRecord.getCreatedBy());
			updatingFileClass.setCreatedIp(medicalPatientRecord.getCreatedIp());
			updatingFileClass.setModificationTime(medicalPatientRecord.getModificationTime());
			updatingFileClass.setModificationBy(medicalPatientRecord.getModificationBy());
			updatingFileClass.setModificationIp(medicalPatientRecord.getModificationIp());
			updatingFileClass.setAreaId(medicalPatientRecord.getAreaId());
			medicalCheckinCheckoutRecordRepository.insertCommon(updatingFileClass);
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
	public MedicalPatientRecord queryMedicalPatientRecord(Object id) {
		MedicalPatientRecord medicalPatientRecord = medicalPatientRecordService.queryObject(id);
		HospitalUser hospitalUser = hospitalUserService.queryObject(medicalPatientRecord.getUserId());
		HospitalUnitInformation hospitalUnitInformation = hospitalUnitInformationService.queryObject(hospitalUser.getHospitalId());
		medicalPatientRecord.setHospitalName(hospitalUnitInformation.getHospitalName());
		return medicalPatientRecord;
	}

	private CommonIndex getCommonIndex(HospitalUser hospitalUser, MedicalPatientRecord medicalPatientRecord) {
		CommonIndex commonIndex = new CommonIndex();
		commonIndex.setAreaId(medicalPatientRecord.getAreaId());
		commonIndex.setCollectTime(medicalPatientRecord.getCollectTime());
		commonIndex.setAreaName(sysAreaService.getParentString(medicalPatientRecord.getAreaId()));
		commonIndex.setBusinessTypeId(medicalPatientRecord.getBusinessTypeId());
		commonIndex.setBusinessTypeName(intelligenceBusinessTypeService.getParentString(medicalPatientRecord.getBusinessTypeId()));

		commonIndex.setCreatedTime(new Date());
		commonIndex.setFileType(medicalPatientRecord.getFileType());
		commonIndex.setId(ES_ID_PREFIX + medicalPatientRecord.getId());
		commonIndex.setSuggest(medicalPatientRecord.getName());
		//commonIndex.setTitle("患者姓名：" + medicalPatientRecord.getName() + " 患者身份证号：" + medicalPatientRecord.getIdCardNum());

		commonIndex.setName1(medicalPatientRecord.getName());
		commonIndex.setIdCardNum1(medicalPatientRecord.getIdCardNum());
		commonIndex.setLocation1(hospitalUser.getAddress());
		commonIndex.setDtTime(new Date());
		commonIndex.setName2("");
		commonIndex.setIdCardNum2("");
		commonIndex.setLocation2("");

		commonIndex.setContent(medicalPatientRecord.toString());

		commonIndex.setUrl(medicalPatientRecord.getDetailsUrl());

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

	public MedicalPatientRecordTransfer copy(MedicalPatientRecord medicalPatientRecord,HospitalUser hospitalUser,HttpServletRequest request,String username){
		MedicalPatientRecordTransfer medicalPatientRecordTransfer = new MedicalPatientRecordTransfer();
		medicalPatientRecordTransfer.setAreaId(hospitalUser.getAreaId());
		medicalPatientRecordTransfer.setUserId(hospitalUser.getId());
		medicalPatientRecordTransfer.setHospitalName(hospitalUser.getHospitalName());
		medicalPatientRecordTransfer.setBusinessTypeId(medicalPatientRecordBusinessTypeId);
		medicalPatientRecordTransfer.setCollectTime(new Date());
		medicalPatientRecordTransfer.setFileType(1);
		medicalPatientRecordTransfer.setCreatedBy(username);
		medicalPatientRecordTransfer.setCreatedIp(request.getRemoteAddr());
		medicalPatientRecordTransfer.setXXZJBH(medicalPatientRecord.getInfoKey());
		medicalPatientRecordTransfer.setHZ_XM(medicalPatientRecord.getName());
		medicalPatientRecordTransfer.setHZ_XMHYPY(medicalPatientRecord.getNameSpell());
		medicalPatientRecordTransfer.setHZ_XB(medicalPatientRecord.getSex());
		medicalPatientRecordTransfer.setHZ_XBDM(medicalPatientRecord.getSexCode());
		medicalPatientRecordTransfer.setHZ_CSRQ(medicalPatientRecord.getBornTime());
		medicalPatientRecordTransfer.setHZ_CYZJDM(medicalPatientRecord.getIdCardNumCode());
		medicalPatientRecordTransfer.setHZ_CYZJMC(medicalPatientRecord.getIdCardNumName());
		medicalPatientRecordTransfer.setHZ_ZJHM(medicalPatientRecord.getIdCardNum());
		medicalPatientRecordTransfer.setHZ_LXDH(medicalPatientRecord.getPhone());
		medicalPatientRecordTransfer.setHZ_XZZ_DZMC(medicalPatientRecord.getAddress());
		medicalPatientRecordTransfer.setLXR_XM(medicalPatientRecord.getContactPerson());
		medicalPatientRecordTransfer.setLXR_XMHYPY(medicalPatientRecord.getContactPersonSpell());
		medicalPatientRecordTransfer.setLXR_CYZJDM(medicalPatientRecord.getContactCardCode());
		medicalPatientRecordTransfer.setLXR_CYZJMC(medicalPatientRecord.getContactCardName());
		medicalPatientRecordTransfer.setLXR_ZJHM(medicalPatientRecord.getContactCardNumber());
		medicalPatientRecordTransfer.setLXR_XZZ_DZMC(medicalPatientRecord.getContactAddress());
		medicalPatientRecordTransfer.setLXR_LXDH(medicalPatientRecord.getContactPhone());
		medicalPatientRecordTransfer.setLXR_YHZGX_JYQK(medicalPatientRecord.getRelation());
		medicalPatientRecordTransfer.setYYBH(medicalPatientRecord.getHospitalNumber());
		medicalPatientRecordTransfer.setXX(medicalPatientRecord.getBloodType());
		medicalPatientRecordTransfer.setXXDM(medicalPatientRecord.getBloodTypeCode());
		medicalPatientRecordTransfer.setZYYY_JYQK(medicalPatientRecord.getHospitalizedReason());
		medicalPatientRecordTransfer.setZYRQ(medicalPatientRecord.getHospitalizedDatetime());
		medicalPatientRecordTransfer.setCYRQ(medicalPatientRecord.getLeavehospitalDatetime());
		medicalPatientRecordTransfer.setBZ(medicalPatientRecord.getRemark());
		medicalPatientRecordTransfer.setYY_DWMC(hospitalUser.getHospitalName());

		return medicalPatientRecordTransfer;
	}
}
