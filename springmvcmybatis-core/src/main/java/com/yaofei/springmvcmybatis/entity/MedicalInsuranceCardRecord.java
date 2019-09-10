package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 医保刷卡记录信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-16 11:40:38
 */
public class MedicalInsuranceCardRecord extends BaseEntity {
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
	//医疗类型
	private String medicalType;
	//医疗类型代码
	private String medicalTypeCode;
	//医疗费用金额
	private BigDecimal cost;
	//住院时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date hospitalizationDatetime;
	//出院时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date leavehospitalDatetime;
	//入院疾病
	private String hospitalizationIllness;
	//确诊疾病
	private String diagnosisHospitalization;
	//并发症简要情况
	private String complicationDetail;
	//出院原因
	private String leavehospitalReason;
	//医生姓名
	private String doctor;
	//住院号
	private String hospitalizationNo;
	//住院科室
	private String hospitalizationDepartment;
	//办理日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date takeDatetime;
	//经办人姓名
	private String responsiblePersonName;
	//医院编号
	private String hospitalNumber;
	//个人编号
	private String personNumber;
	//单位编号
	private String organizationNumber;
	//报销标志
	private String reimbursementSign;
	//报销标志_简要情况
	private String reimbursementSignDetail;
	//结算状态
	private String accountEndStatus;
	//结算状态_简要情况
	private String accountEndStatusDetail;
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

	public Long getInfoKey() {
		return infoKey;
	}

	public void setInfoKey(Long infoKey) {
		this.infoKey = infoKey;
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
	 * 设置：医疗类型
	 */
	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}
	/**
	 * 获取：医疗类型
	 */
	public String getMedicalType() {
		return medicalType;
	}
	/**
	 * 设置：医疗类型代码
	 */
	public void setMedicalTypeCode(String medicalTypeCode) {
		this.medicalTypeCode = medicalTypeCode;
	}
	/**
	 * 获取：医疗类型代码
	 */
	public String getMedicalTypeCode() {
		return medicalTypeCode;
	}
	/**
	 * 设置：医疗费用金额
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	/**
	 * 获取：医疗费用金额
	 */
	public BigDecimal getCost() {
		return cost;
	}
	/**
	 * 设置：住院时间
	 */
	public void setHospitalizationDatetime(Date hospitalizationDatetime) {
		this.hospitalizationDatetime = hospitalizationDatetime;
	}
	/**
	 * 获取：住院时间
	 */
	public Date getHospitalizationDatetime() {
		return hospitalizationDatetime;
	}
	/**
	 * 设置：出院时间
	 */
	public void setLeavehospitalDatetime(Date leavehospitalDatetime) {
		this.leavehospitalDatetime = leavehospitalDatetime;
	}
	/**
	 * 获取：出院时间
	 */
	public Date getLeavehospitalDatetime() {
		return leavehospitalDatetime;
	}
	/**
	 * 设置：入院疾病
	 */
	public void setHospitalizationIllness(String hospitalizationIllness) {
		this.hospitalizationIllness = hospitalizationIllness;
	}
	/**
	 * 获取：入院疾病
	 */
	public String getHospitalizationIllness() {
		return hospitalizationIllness;
	}
	/**
	 * 设置：确诊疾病
	 */
	public void setDiagnosisHospitalization(String diagnosisHospitalization) {
		this.diagnosisHospitalization = diagnosisHospitalization;
	}
	/**
	 * 获取：确诊疾病
	 */
	public String getDiagnosisHospitalization() {
		return diagnosisHospitalization;
	}
	/**
	 * 设置：并发症简要情况
	 */
	public void setComplicationDetail(String complicationDetail) {
		this.complicationDetail = complicationDetail;
	}
	/**
	 * 获取：并发症简要情况
	 */
	public String getComplicationDetail() {
		return complicationDetail;
	}
	/**
	 * 设置：出院原因
	 */
	public void setLeavehospitalReason(String leavehospitalReason) {
		this.leavehospitalReason = leavehospitalReason;
	}
	/**
	 * 获取：出院原因
	 */
	public String getLeavehospitalReason() {
		return leavehospitalReason;
	}
	/**
	 * 设置：医生姓名
	 */
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	/**
	 * 获取：医生姓名
	 */
	public String getDoctor() {
		return doctor;
	}
	/**
	 * 设置：住院号
	 */
	public void setHospitalizationNo(String hospitalizationNo) {
		this.hospitalizationNo = hospitalizationNo;
	}
	/**
	 * 获取：住院号
	 */
	public String getHospitalizationNo() {
		return hospitalizationNo;
	}
	/**
	 * 设置：住院科室
	 */
	public void setHospitalizationDepartment(String hospitalizationDepartment) {
		this.hospitalizationDepartment = hospitalizationDepartment;
	}
	/**
	 * 获取：住院科室
	 */
	public String getHospitalizationDepartment() {
		return hospitalizationDepartment;
	}
	/**
	 * 设置：办理日期
	 */
	public void setTakeDatetime(Date takeDatetime) {
		this.takeDatetime = takeDatetime;
	}
	/**
	 * 获取：办理日期
	 */
	public Date getTakeDatetime() {
		return takeDatetime;
	}
	/**
	 * 设置：经办人姓名
	 */
	public void setResponsiblePersonName(String responsiblePersonName) {
		this.responsiblePersonName = responsiblePersonName;
	}
	/**
	 * 获取：经办人姓名
	 */
	public String getResponsiblePersonName() {
		return responsiblePersonName;
	}
	/**
	 * 设置：医院编号
	 */
	public void setHospitalNumber(String hospitalNumber) {
		this.hospitalNumber = hospitalNumber;
	}
	/**
	 * 获取：医院编号
	 */
	public String getHospitalNumber() {
		return hospitalNumber;
	}
	/**
	 * 设置：个人编号
	 */
	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}
	/**
	 * 获取：个人编号
	 */
	public String getPersonNumber() {
		return personNumber;
	}
	/**
	 * 设置：单位编号
	 */
	public void setOrganizationNumber(String organizationNumber) {
		this.organizationNumber = organizationNumber;
	}
	/**
	 * 获取：单位编号
	 */
	public String getOrganizationNumber() {
		return organizationNumber;
	}
	/**
	 * 设置：报销标志
	 */
	public void setReimbursementSign(String reimbursementSign) {
		this.reimbursementSign = reimbursementSign;
	}
	/**
	 * 获取：报销标志
	 */
	public String getReimbursementSign() {
		return reimbursementSign;
	}
	/**
	 * 设置：报销标志_简要情况
	 */
	public void setReimbursementSignDetail(String reimbursementSignDetail) {
		this.reimbursementSignDetail = reimbursementSignDetail;
	}
	/**
	 * 获取：报销标志_简要情况
	 */
	public String getReimbursementSignDetail() {
		return reimbursementSignDetail;
	}
	/**
	 * 设置：结算状态
	 */
	public void setAccountEndStatus(String accountEndStatus) {
		this.accountEndStatus = accountEndStatus;
	}
	/**
	 * 获取：结算状态
	 */
	public String getAccountEndStatus() {
		return accountEndStatus;
	}
	/**
	 * 设置：结算状态_简要情况
	 */
	public void setAccountEndStatusDetail(String accountEndStatusDetail) {
		this.accountEndStatusDetail = accountEndStatusDetail;
	}
	/**
	 * 获取：结算状态_简要情况
	 */
	public String getAccountEndStatusDetail() {
		return accountEndStatusDetail;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：删除状态  0：正常   1：已删除
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

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date collectTimeBegin;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
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
		return  "医疗类型='" + medicalType + '\'' +
				 ", 医疗类型代码='" + medicalTypeCode + '\'' +
				 ", 医疗费用金额=" + cost +
				", 住院时间='" + DateTimeUtil.formatDateTime(hospitalizationDatetime)  + '\'' +
				", 出院时间='" + DateTimeUtil.formatDateTime(leavehospitalDatetime)  + '\'' +
				", 入院疾病='" + hospitalizationIllness + '\'' +
				", 确诊疾病='" + diagnosisHospitalization + '\'' +
				", 并发症简要情况='" + complicationDetail + '\'' +
				", 出院原因='" + leavehospitalReason + '\'' +
				", 医生_姓名='" + doctor + '\'' +
				", 住院号='" + hospitalizationNo + '\'' +
				", 科室_单位名称='" + hospitalizationDepartment + '\'' +
				", 办理日期='" + DateTimeUtil.formatDateTime(takeDatetime)  + '\'' +
				", 经办人_姓名='" + responsiblePersonName + '\'' +
				", 医院编号='" + hospitalNumber + '\'' +
				", 个人编号='" + personNumber + '\'' +
				", 单位编号='" + organizationNumber + '\'' +
				", 报销标志='" + reimbursementSign + '\'' +
				", 报销标志_简要情况='" + reimbursementSignDetail + '\'' +
				", 结算状态='" + accountEndStatus + '\'' +
				", 结算状态_简要情况='" + accountEndStatusDetail + '\'' +
				", 备注='" + remark + '\'' +
				", 医院名称='" + HospitalName + '\'' ;
	}
}
