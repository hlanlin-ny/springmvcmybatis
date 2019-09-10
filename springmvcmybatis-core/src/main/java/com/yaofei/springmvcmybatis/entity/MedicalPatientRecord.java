package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;

import java.util.Date;


/**
 * 医疗机构患者信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-16 11:40:26
 */
public class MedicalPatientRecord extends BaseEntity {
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
	//医院编号
	private String hospitalNumber;
	//姓名
	private String name;
	//姓名拼音
	private String nameSpell;
	//性别
	private String sex;
	//性别代码1 - 男性2 - 女性
	private String sexCode;
	//出生日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date bornTime;
	//患者_常用证件代码
	private  String idCardNumCode;
	//患者_常用证件名称
	private  String idCardNumName;
	//身份证号码
	private String idCardNum;
	//家庭地址
	private String address;
	//联系电话
	private String phone;
	//联系人
	private String contactPerson;
	//联系人姓名拼音
	private String contactPersonSpell;
	//常用证件代码
	private String contactCardCode;
	//常用证件名称
	private String contactCardName;
	//常用证件号码
	private String contactCardNumber;
	//联系人现居地址
	private String contactAddress;
	//联系电话
	private String contactPhone;
	//与患者的关系
	private String relation;
	//医院单位名称
	private String hospitalUnitName;
	//血型
	private String bloodType;
	//血型代码
	private String bloodTypeCode;
	//住院原因
	private String hospitalizedReason;
	//住院日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date hospitalizedDatetime;
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

	public Long getInfoKey() {
		return infoKey;
	}

	public void setInfoKey(Long infoKey) {
		this.infoKey = infoKey;
	}

	public String getHospitalNumber() {
		return hospitalNumber;
	}

	public void setHospitalNumber(String hospitalNumber) {
		this.hospitalNumber = hospitalNumber;
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
	/**
	 * 设置：姓名拼音
	 */
	public void setNameSpell(String nameSpell) {
		this.nameSpell = nameSpell;
	}
	/**
	 * 获取：姓名拼音
	 */
	public String getNameSpell() {
		return nameSpell;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：性别代码1 - 男性2 - 女性
	 */
	public void setSexCode(String sexCode) {
		this.sexCode = sexCode;
	}
	/**
	 * 获取：性别代码1 - 男性2 - 女性
	 */
	public String getSexCode() {
		return sexCode;
	}
	/**
	 * 设置：出生日期
	 */
	public void setBornTime(Date bornTime) {
		this.bornTime = bornTime;
	}
	/**
	 * 获取：出生日期
	 */
	public Date getBornTime() {
		return bornTime;
	}

	public String getIdCardNumCode() {
		return idCardNumCode;
	}

	public void setIdCardNumCode(String idCardNumCode) {
		this.idCardNumCode = idCardNumCode;
	}

	public String getIdCardNumName() {
		return idCardNumName;
	}

	public void setIdCardNumName(String idCardNumName) {
		this.idCardNumName = idCardNumName;
	}

	/**
	 * 设置：身份证号码
	 */
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	/**
	 * 获取：身份证号码
	 */
	public String getIdCardNum() {
		return idCardNum;
	}
	/**
	 * 设置：家庭地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：家庭地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：联系人
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	/**
	 * 获取：联系人
	 */
	public String getContactPerson() {
		return contactPerson;
	}
	/**
	 * 设置：联系人姓名拼音
	 */
	public void setContactPersonSpell(String contactPersonSpell) {
		this.contactPersonSpell = contactPersonSpell;
	}
	/**
	 * 获取：联系人姓名拼音
	 */
	public String getContactPersonSpell() {
		return contactPersonSpell;
	}
	/**
	 * 设置：常用证件代码
	 */
	public void setContactCardCode(String contactCardCode) {
		this.contactCardCode = contactCardCode;
	}
	/**
	 * 获取：常用证件代码
	 */
	public String getContactCardCode() {
		return contactCardCode;
	}
	/**
	 * 设置：常用证件名称
	 */
	public void setContactCardName(String contactCardName) {
		this.contactCardName = contactCardName;
	}
	/**
	 * 获取：常用证件名称
	 */
	public String getContactCardName() {
		return contactCardName;
	}
	/**
	 * 设置：常用证件号码
	 */
	public void setContactCardNumber(String contactCardNumber) {
		this.contactCardNumber = contactCardNumber;
	}
	/**
	 * 获取：常用证件号码
	 */
	public String getContactCardNumber() {
		return contactCardNumber;
	}
	/**
	 * 设置：联系人现居地址
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	/**
	 * 获取：联系人现居地址
	 */
	public String getContactAddress() {
		return contactAddress;
	}
	/**
	 * 设置：联系电话
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * 设置：与患者的关系
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}
	/**
	 * 获取：与患者的关系
	 */
	public String getRelation() {
		return relation;
	}
	/**
	 * 设置：医院单位名称
	 */
	public void setHospitalUnitName(String hospitalUnitName) {
		this.hospitalUnitName = hospitalUnitName;
	}
	/**
	 * 获取：医院单位名称
	 */
	public String getHospitalUnitName() {
		return hospitalUnitName;
	}
	/**
	 * 设置：血型
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	/**
	 * 获取：血型
	 */
	public String getBloodType() {
		return bloodType;
	}
	/**
	 * 设置：血型代码
	 */
	public void setBloodTypeCode(String bloodTypeCode) {
		this.bloodTypeCode = bloodTypeCode;
	}
	/**
	 * 获取：血型代码
	 */
	public String getBloodTypeCode() {
		return bloodTypeCode;
	}
	/**
	 * 设置：住院原因
	 */
	public void setHospitalizedReason(String hospitalizedReason) {
		this.hospitalizedReason = hospitalizedReason;
	}
	/**
	 * 获取：住院原因
	 */
	public String getHospitalizedReason() {
		return hospitalizedReason;
	}
	/**
	 * 设置：住院日期
	 */
	public void setHospitalizedDatetime(Date hospitalizedDatetime) {
		this.hospitalizedDatetime = hospitalizedDatetime;
	}
	/**
	 * 获取：住院日期
	 */
	public Date getHospitalizedDatetime() {
		return hospitalizedDatetime;
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

	public void setHospitalName(String hospitalName) {
		HospitalName = hospitalName;
	}


	@Override
	public String toString() {
		return "姓名='" + name + '\'' +
				", 性别='" + sex + '\'' +
				", 出生日期='" + DateTimeUtil.formatDateTime(bornTime)  + '\'' +
				", 身份证号码='" + idCardNum + '\'' +
				", 家庭地址='" + address + '\'' +
				", 联系电话='" + phone + '\'' +
				", 联系人='" + contactPerson + '\'' +
				", 常用证件号码='" + contactCardNumber + '\'' +
				", 联系人现居地址	='" + contactAddress + '\'' +
				", 联系电话='" + contactPhone + '\'' +
				", 与患者的关系='" + relation + '\'' +
				", 血型='" + bloodType + '\'' +
				", 住院原因='" + hospitalizedReason + '\'' +
				", 住院日期='" + DateTimeUtil.formatDateTime(hospitalizedDatetime)  + '\'' +
				", 出院时间='" + DateTimeUtil.formatDateTime(leavehospitalDatetime)  + '\'' +
				", 医院单位名称='" + hospitalUnitName + '\'' +
				", 备注='" + remark + '\'' ;
	}
}
