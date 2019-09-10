package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;
import com.yaofei.springmvcmybatis.entity.HospitalUnitInformation;
import com.yaofei.springmvcmybatis.entity.HospitalUser;
import com.yaofei.springmvcmybatis.entity.MedicalExaminationRecord;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.service.*;
import com.yaofei.springmvcmybatis.utils.SignatureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("medicalExaminationRecordApiService")
public class MedicalExaminationRecordApiServiceImpl implements MedicalExaminationRecordApiService {

	private static final String ES_ID_PREFIX = "medicalExaminationRecord_";
	@Value("${medicalExamination.record.business.type.id}")
	private Long medicalExaminationRecordBusinessTypeId;

	//医院
	@Autowired
	private HospitalUnitInformationService hospitalUnitInformationService;
	//医疗体检
	@Autowired
	private MedicalExaminationRecordService medicalExaminationRecordService;
	//医院网点信息
	@Autowired
	private HospitalUserService hospitalUserService;
	@Autowired
	private IntelligenceBusinessTypeService intelligenceBusinessTypeService;
	@Autowired
	private SysAreaService sysAreaService;
	@Autowired
	private EsClientServiceCommonIndex esClientServiceCommonIndex;


	@Override
	public void add(String username, String sign, Integer nonce, MedicalExaminationRecord medicalExaminationRecord, HttpServletRequest request) throws Exception {

		HospitalUser hospitalUser = checkHospitalUserSign(username, sign, nonce);
		medicalExaminationRecord.setAreaId(hospitalUser.getAreaId());
		medicalExaminationRecord.setUserId(hospitalUser.getId());
		medicalExaminationRecord.setBusinessTypeId(medicalExaminationRecordBusinessTypeId);
		medicalExaminationRecord.setCollectTime(new Date());
		medicalExaminationRecord.setFileType(1);
		medicalExaminationRecord.setCreatedBy(username);
		medicalExaminationRecord.setCreatedIp(request.getRemoteAddr());
		medicalExaminationRecordService.save(medicalExaminationRecord);

		//更新
		medicalExaminationRecord.setDetailsUrl(request.getRequestURL().toString().replace("add", "details.html?id=" + medicalExaminationRecord.getId()));

		// 把内容保存到es
		List<CommonIndex> commonIndexes = new ArrayList<>();
		CommonIndex commonIndex = getCommonIndex(hospitalUser, medicalExaminationRecord);
		commonIndexes.add(commonIndex);
		String indexName = esClientServiceCommonIndex.createIndex(commonIndexes);
		medicalExaminationRecord.setEsIndexName(indexName);

		medicalExaminationRecordService.update(medicalExaminationRecord);
	}

		@Override
		public HospitalUser checkHospitalUserSign(String username, String sign, Integer nonce) throws Exception {
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
	public MedicalExaminationRecord queryMedicalExaminationRecord(Object id) {
		MedicalExaminationRecord medicalExaminationRecord = medicalExaminationRecordService.queryObject(id);
		HospitalUser hospitalUser = hospitalUserService.queryObject(medicalExaminationRecord.getUserId());
		HospitalUnitInformation hospitalUnitInformation = hospitalUnitInformationService.queryObject(hospitalUser.getHospitalId());
		medicalExaminationRecord.setHospitalName(hospitalUnitInformation.getHospitalName());
		return medicalExaminationRecord;
	}

	private CommonIndex getCommonIndex(HospitalUser hospitalUser, MedicalExaminationRecord medicalExaminationRecord) {
		CommonIndex commonIndex = new CommonIndex();
		commonIndex.setAreaId(medicalExaminationRecord.getAreaId());
		commonIndex.setCollectTime(medicalExaminationRecord.getCollectTime());
		commonIndex.setAreaName(sysAreaService.getParentString(medicalExaminationRecord.getAreaId()));
		commonIndex.setBusinessTypeId(medicalExaminationRecord.getBusinessTypeId());
		commonIndex.setBusinessTypeName(intelligenceBusinessTypeService.getParentString(medicalExaminationRecord.getBusinessTypeId()));
		commonIndex.setCreatedTime(new Date());
		commonIndex.setFileType(medicalExaminationRecord.getFileType());
		commonIndex.setId(ES_ID_PREFIX + medicalExaminationRecord.getId());
		commonIndex.setSuggest(medicalExaminationRecord.getName());
		//commonIndex.setTitle("医疗体检人姓名：" + medicalExaminationRecord.getName() + " 医疗体检人身份证号：" + medicalExaminationRecord.getIdCardNum());


		commonIndex.setName1(medicalExaminationRecord.getName());
		commonIndex.setIdCardNum1(medicalExaminationRecord.getIdCardNum());
		commonIndex.setLocation1(hospitalUser.getAddress());
		commonIndex.setDtTime(new Date());
		commonIndex.setName2("");
		commonIndex.setIdCardNum2("");
		commonIndex.setLocation2("");

		commonIndex.setContent(medicalExaminationRecord.toString());

		commonIndex.setUrl(medicalExaminationRecord.getDetailsUrl());

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
}
