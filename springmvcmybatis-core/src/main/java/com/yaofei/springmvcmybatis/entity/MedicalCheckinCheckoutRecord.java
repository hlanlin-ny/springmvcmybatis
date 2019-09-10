package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 医疗住（出）院信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:39:28
 */
public class MedicalCheckinCheckoutRecord extends BaseEntity {
	private static final long serialVersionUID = 1L;

	//主键，自增ID
	private Long id;
	//信息编号主键
	private Long infoKey;
	//行政区划编号
	private Long areaId;
	//情报业务分类ID
	private Long businessTypeId;
	//文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）
	private Integer fileType;
	//详情页面url
	private String detailsUrl;
	//收集时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date collectTime;
	//插入es的时候用的es的索引名称
	private String esIndexName;
	//所属用户编号
	private Long userId;
	//姓名
	private String name;
	//姓名拼音
	private String nameSpell;
	//性别
	private String sex;
	//性别代码
	private String sexCode;
	//出生日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date bornTime;
	//年龄
	private Integer age;
	//身份证号码
	private String idCardNum;
	//联系电话
	private String phone;
	//家庭地址
	private String address;
	//职业
	private String profession;
	//工作单位
	private String organization;
	//户主姓名
	private String houseHeadName;
	//家庭人口数
	private Integer familyPopulation;
	//家庭类别
	private String familyType;
	//家庭类型代码
	private String familyTypeCode;
	//医院单位名称
	private String hospitalUnitName;
	//医保证号
	private String medicalGuaranteeNumber;
	//住院号
	private String hospitalizationNo;
	//住院科室
	private String hospitalizationDepartment;
	//床号
	private String bedNumber;
	//入院途径
	private String hospitalWay;
	//医生名字
	private String doctorName;
	//入院诊断
	private String admittingDiagnosis;
	//出院诊断
	private String dischargeDiagnosis;
	//救助对象
	private String subjectSalvage;
	//救助对象类别
	private String subjectSalvageType;
	//救助金额
	private BigDecimal subjectSalvageCost;
	//经办人姓名
	private String responsiblePersonName;
	//住院时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date hospitalizationDatetime;
	//出院时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date leavehospitalDatetime;
	//备注
	private String remark;
	//删除状态  0：正常   1：已删除
	private Boolean isDeleted;
	//创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date createdTime;
	//创建人
	private String createdBy;
	//创建IP
	private String createdIp;
	//修改时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date modificationTime;
	//修改人
	private String modificationBy;
	//修改人IP
	private String modificationIp;

	/**
	 * 设置：主键，自增ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键，自增ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：行政区划编号
	 */
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：行政区划编号
	 */
	public Long getAreaId() {
		return areaId;
	}
	/**
	 * 设置：情报业务分类ID
	 */
	public void setBusinessTypeId(Long businessTypeId) {
		this.businessTypeId = businessTypeId;
	}
	/**
	 * 获取：情报业务分类ID
	 */
	public Long getBusinessTypeId() {
		return businessTypeId;
	}
	/**
	 * 设置：文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）
	 */
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取：文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）
	 */
	public Integer getFileType() {
		return fileType;
	}
	/**
	 * 设置：详情页面url
	 */
	public void setDetailsUrl(String detailsUrl) {
		this.detailsUrl = detailsUrl;
	}
	/**
	 * 获取：详情页面url
	 */
	public String getDetailsUrl() {
		return detailsUrl;
	}
	/**
	 * 设置：收集时间
	 */
	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}
	/**
	 * 获取：收集时间
	 */
	public Date getCollectTime() {
		return collectTime;
	}
	/**
	 * 设置：插入es的时候用的es的索引名称
	 */
	public void setEsIndexName(String esIndexName) {
		this.esIndexName = esIndexName;
	}
	/**
	 * 获取：插入es的时候用的es的索引名称
	 */
	public String getEsIndexName() {
		return esIndexName;
	}
	/**
	 * 设置：所属用户编号
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：所属用户编号
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Long getInfoKey() {
		return infoKey;
	}

	public void setInfoKey(Long infoKey) {
		this.infoKey = infoKey;
	}

	public String getName() {
		return name;
	}

	public String getNameSpell() {
		return nameSpell;
	}

	public void setNameSpell(String nameSpell) {
		this.nameSpell = nameSpell;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSexCode() {
		return sexCode;
	}

	public void setSexCode(String sexCode) {
		this.sexCode = sexCode;
	}

	public Date getBornTime() {
		return bornTime;
	}

	public void setBornTime(Date bornTime) {
		this.bornTime = bornTime;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIdCardNum() {
		return idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getHouseHeadName() {
		return houseHeadName;
	}

	public void setHouseHeadName(String houseHeadName) {
		this.houseHeadName = houseHeadName;
	}

	public Integer getFamilyPopulation() {
		return familyPopulation;
	}

	public void setFamilyPopulation(Integer familyPopulation) {
		this.familyPopulation = familyPopulation;
	}

	public String getFamilyType() {
		return familyType;
	}

	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}

	public String getFamilyTypeCode() {
		return familyTypeCode;
	}

	public void setFamilyTypeCode(String familyTypeCode) {
		this.familyTypeCode = familyTypeCode;
	}

	public String getHospitalUnitName() {
		return hospitalUnitName;
	}

	public void setHospitalUnitName(String hospitalUnitName) {
		this.hospitalUnitName = hospitalUnitName;
	}

	public String getMedicalGuaranteeNumber() {
		return medicalGuaranteeNumber;
	}

	public void setMedicalGuaranteeNumber(String medicalGuaranteeNumber) {
		this.medicalGuaranteeNumber = medicalGuaranteeNumber;
	}

	public String getHospitalizationNo() {
		return hospitalizationNo;
	}

	public void setHospitalizationNo(String hospitalizationNo) {
		this.hospitalizationNo = hospitalizationNo;
	}

	public String getHospitalizationDepartment() {
		return hospitalizationDepartment;
	}

	public void setHospitalizationDepartment(String hospitalizationDepartment) {
		this.hospitalizationDepartment = hospitalizationDepartment;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}

	public String getHospitalWay() {
		return hospitalWay;
	}

	public void setHospitalWay(String hospitalWay) {
		this.hospitalWay = hospitalWay;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getAdmittingDiagnosis() {
		return admittingDiagnosis;
	}

	public void setAdmittingDiagnosis(String admittingDiagnosis) {
		this.admittingDiagnosis = admittingDiagnosis;
	}

	public String getDischargeDiagnosis() {
		return dischargeDiagnosis;
	}

	public void setDischargeDiagnosis(String dischargeDiagnosis) {
		this.dischargeDiagnosis = dischargeDiagnosis;
	}

	public String getSubjectSalvage() {
		return subjectSalvage;
	}

	public void setSubjectSalvage(String subjectSalvage) {
		this.subjectSalvage = subjectSalvage;
	}

	public String getSubjectSalvageType() {
		return subjectSalvageType;
	}

	public void setSubjectSalvageType(String subjectSalvageType) {
		this.subjectSalvageType = subjectSalvageType;
	}

	public BigDecimal getSubjectSalvageCost() {
		return subjectSalvageCost;
	}

	public void setSubjectSalvageCost(BigDecimal subjectSalvageCost) {
		this.subjectSalvageCost = subjectSalvageCost;
	}

	public String getResponsiblePersonName() {
		return responsiblePersonName;
	}

	public void setResponsiblePersonName(String responsiblePersonName) {
		this.responsiblePersonName = responsiblePersonName;
	}

	public Date getHospitalizationDatetime() {
		return hospitalizationDatetime;
	}

	public void setHospitalizationDatetime(Date hospitalizationDatetime) {
		this.hospitalizationDatetime = hospitalizationDatetime;
	}

	public Date getLeavehospitalDatetime() {
		return leavehospitalDatetime;
	}

	public void setLeavehospitalDatetime(Date leavehospitalDatetime) {
		this.leavehospitalDatetime = leavehospitalDatetime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取：姓名
	 */

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * 获取：删除状态  0：正常   1：已删除
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * 设置：创建IP
	 */
	public void setCreatedIp(String createdIp) {
		this.createdIp = createdIp;
	}
	/**
	 * 获取：创建IP
	 */
	public String getCreatedIp() {
		return createdIp;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModificationTime() {
		return modificationTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setModificationBy(String modificationBy) {
		this.modificationBy = modificationBy;
	}
	/**
	 * 获取：修改人
	 */
	public String getModificationBy() {
		return modificationBy;
	}
	/**
	 * 设置：修改人IP
	 */
	public void setModificationIp(String modificationIp) {
		this.modificationIp = modificationIp;
	}
	/**
	 * 获取：修改人IP
	 */
	public String getModificationIp() {
		return modificationIp;
	}


	private Date collectTimeBegin;
	private Date collectTimeEnd;

	//医院名字
	private String HospitalName;

	public Date getCollectTimeBegin() {
		return collectTimeBegin;
	}

	public void setCollectTimeBegin(Date collectTimeBegin) {
		this.collectTimeBegin = collectTimeBegin;
	}

	public Date getCollectTimeEnd() {
		return collectTimeEnd;
	}

	public void setCollectTimeEnd(Date collectTimeEnd) {
		this.collectTimeEnd = collectTimeEnd;
	}

	public String getHospitalName() {
		return HospitalName;
	}

	public void setHospitalName(String HospitalName) {
		this.HospitalName = HospitalName;
	}

	@Override
	public String toString() {
		return    "医疗人员姓名='" + name + '\'' +
				", 医疗人员身份证='" + idCardNum + '\'' +
				", 医疗人员手机号='" + phone + '\'' +
				", 医疗人员姓名拼音='" + nameSpell + '\'' +
				", 医疗人员性别='" + sex + '\'' +
				", 医疗人员出生日期=" + bornTime +
				", 医疗人员年龄=" + age +
				", 家庭住址='" + address + '\'' +
				", 工作职位='" + profession + '\'' +
				", 工作单位='" + organization + '\'' +
				", 医院名称='" + HospitalName + '\'' +
				", 医院单位名称='" + hospitalUnitName + '\'' +
				", 户主姓名='" + houseHeadName + '\'' +
				", 家庭人口数='" + familyPopulation + '\'' +
				", 医保证号='" + medicalGuaranteeNumber + '\'' +
				", 住院科室='" + hospitalizationDepartment + '\'' +
				", 床号='" + bedNumber + '\'' +
				", 入院途径='" + hospitalWay + '\'' +
				", 医生名字='" + doctorName + '\'' +
				", 入院诊断='" + admittingDiagnosis + '\'' +
				", 出院诊断='" + dischargeDiagnosis + '\'' +
				", 救助对象='" + subjectSalvage + '\'' +
				", 救助对象金额='" + subjectSalvageCost + '\'' +
				", 救助对象类别='" + subjectSalvageType + '\'' +
				", 经办人='" + responsiblePersonName + '\'' +
				", 住院时间='" + DateTimeUtil.formatDateTime(hospitalizationDatetime)  + '\'' +
				", 出院时间='" + DateTimeUtil.formatDateTime(leavehospitalDatetime)  + '\'' +
				", 备注='" + remark + '\'' +
				", 上报时间='" + DateTimeUtil.formatDateTime(collectTime)  + '\'';
	}
}