package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 医疗门诊信息
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-15 17:32:46
 */
public class MedicalOutpatientRecord extends BaseEntity {
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
	//医院单位名称
	private String hospitalUnitName;
	//就诊时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date diagnoseDatetime;
	//门诊号
	private String diagnoseNo;
	//科室名称
	private String diagnoseDepartment;
	//人员费用类别（自费、医保（城镇医保、农村医保）等）
	private String costType;
	//人员类别代码
	private String costTypeCode;
	//医保证号（含城镇医保、农村医保、费医保病人填就诊卡卡号（自费人员、外地人员））
	private String medicareCardNo;
	//医院诊断结果
	private String diagnoseResult;
	//费用金额
	private BigDecimal cost;
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
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}

	public Long getInfoKey() {
		return infoKey;
	}

	public void setInfoKey(Long infoKey) {
		this.infoKey = infoKey;
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

	public String getHospitalUnitName() {
		return hospitalUnitName;
	}

	public void setHospitalUnitName(String hospitalUnitName) {
		this.hospitalUnitName = hospitalUnitName;
	}

	public Date getDiagnoseDatetime() {
		return diagnoseDatetime;
	}

	public void setDiagnoseDatetime(Date diagnoseDatetime) {
		this.diagnoseDatetime = diagnoseDatetime;
	}

	public String getDiagnoseNo() {
		return diagnoseNo;
	}

	public void setDiagnoseNo(String diagnoseNo) {
		this.diagnoseNo = diagnoseNo;
	}

	public String getDiagnoseDepartment() {
		return diagnoseDepartment;
	}

	public void setDiagnoseDepartment(String diagnoseDepartment) {
		this.diagnoseDepartment = diagnoseDepartment;
	}

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

	public String getCostTypeCode() {
		return costTypeCode;
	}

	public void setCostTypeCode(String costTypeCode) {
		this.costTypeCode = costTypeCode;
	}

	public String getMedicareCardNo() {
		return medicareCardNo;
	}

	public void setMedicareCardNo(String medicareCardNo) {
		this.medicareCardNo = medicareCardNo;
	}

	public String getDiagnoseResult() {
		return diagnoseResult;
	}

	public void setDiagnoseResult(String diagnoseResult) {
		this.diagnoseResult = diagnoseResult;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public void setHospitalName(String hospitalName) {
		HospitalName = hospitalName;
	}

	@Override
	public String toString() {
		return "  门诊人员姓名='" + name + '\'' +
				", 门诊人员姓名拼音='" + nameSpell + '\'' +
				", 门诊人员性别='" + sex + '\'' +
				", 门诊人员出生日期=" + DateTimeUtil.formatDateTime(bornTime)+
				", 门诊人员年龄=" + age +
				", 门诊人员身份证号='" + idCardNum + '\'' +
				", 门诊人员手机号='" + phone + '\'' +
				", 门诊人员住址='" + address + '\'' +
				", 门诊人员职业='" + profession + '\'' +
				", 门诊人员单位名称='" + organization + '\'' +
				", 医院名称='" + HospitalName + '\''+
				", 医院单位名称='" + hospitalUnitName + '\'' +
				", 门诊时间=" + DateTimeUtil.formatDateTime(diagnoseDatetime) +
				", 门诊号='" + diagnoseNo + '\'' +
				", 门诊科室='" + diagnoseDepartment + '\'' +
				", 费用类型='" + costType + '\'' +
				", 医保证号='" + medicareCardNo + '\'' +
				", 门诊结果='" + diagnoseResult + '\'' +
				", 费用=" + cost +
				", 备注='" + remark + '\'';

	}
}
