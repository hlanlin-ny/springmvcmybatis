package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;

import java.util.Date;


/**
 * 新生儿出生信息ZQH-22-113600005
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-16 13:24:29
 */
public class MedicalNewbornRecord extends BaseEntity {
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
	//性别
	private String sex;
	//性别描述
	private String sexDetail;
	//出生日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date bornTime;
	//身份证号码
	private String idCardNum;
	//接生机构名称
	private String deliverOrganization;
	//家庭地址
	private String address;
	//信息登记时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date checkInDatetime;
	//母亲姓名
	private String motherName;
	//母亲民族
	private String motherNation;
	//母亲民族描述
	private String motherNationDetail;
	//母亲身份证号
	private String motherIdcardnum;
	//母亲联系电话
	private String motherPhone;
	//父亲姓名
	private String fatherName;
	//父亲民族
	private String fatherNation;
	//父亲民族描述
	private String fatherNationDetail;
	//父亲身份证号
	private String fatherIdcardnum;
	//父亲联系电话
	private String fatherPhone;
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
	 * 设置：性别描述
	 */
	public void setSexDetail(String sexDetail) {
		this.sexDetail = sexDetail;
	}
	/**
	 * 获取：性别描述
	 */
	public String getSexDetail() {
		return sexDetail;
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
	 * 设置：接生机构名称
	 */
	public void setDeliverOrganization(String deliverOrganization) {
		this.deliverOrganization = deliverOrganization;
	}
	/**
	 * 获取：接生机构名称
	 */
	public String getDeliverOrganization() {
		return deliverOrganization;
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
	 * 设置：信息登记时间
	 */
	public void setCheckInDatetime(Date checkInDatetime) {
		this.checkInDatetime = checkInDatetime;
	}
	/**
	 * 获取：信息登记时间
	 */
	public Date getCheckInDatetime() {
		return checkInDatetime;
	}
	/**
	 * 设置：母亲姓名
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	/**
	 * 获取：母亲姓名
	 */
	public String getMotherName() {
		return motherName;
	}
	/**
	 * 设置：母亲民族
	 */
	public void setMotherNation(String motherNation) {
		this.motherNation = motherNation;
	}
	/**
	 * 获取：母亲民族
	 */
	public String getMotherNation() {
		return motherNation;
	}
	/**
	 * 设置：母亲民族描述
	 */
	public void setMotherNationDetail(String motherNationDetail) {
		this.motherNationDetail = motherNationDetail;
	}
	/**
	 * 获取：母亲民族描述
	 */
	public String getMotherNationDetail() {
		return motherNationDetail;
	}
	/**
	 * 设置：母亲身份证号
	 */
	public void setMotherIdcardnum(String motherIdcardnum) {
		this.motherIdcardnum = motherIdcardnum;
	}
	/**
	 * 获取：母亲身份证号
	 */
	public String getMotherIdcardnum() {
		return motherIdcardnum;
	}
	/**
	 * 设置：母亲联系电话
	 */
	public void setMotherPhone(String motherPhone) {
		this.motherPhone = motherPhone;
	}
	/**
	 * 获取：母亲联系电话
	 */
	public String getMotherPhone() {
		return motherPhone;
	}
	/**
	 * 设置：父亲姓名
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	/**
	 * 获取：父亲姓名
	 */
	public String getFatherName() {
		return fatherName;
	}
	/**
	 * 设置：父亲民族
	 */
	public void setFatherNation(String fatherNation) {
		this.fatherNation = fatherNation;
	}
	/**
	 * 获取：父亲民族
	 */
	public String getFatherNation() {
		return fatherNation;
	}
	/**
	 * 设置：父亲民族描述
	 */
	public void setFatherNationDetail(String fatherNationDetail) {
		this.fatherNationDetail = fatherNationDetail;
	}
	/**
	 * 获取：父亲民族描述
	 */
	public String getFatherNationDetail() {
		return fatherNationDetail;
	}
	/**
	 * 设置：父亲身份证号
	 */
	public void setFatherIdcardnum(String fatherIdcardnum) {
		this.fatherIdcardnum = fatherIdcardnum;
	}
	/**
	 * 获取：父亲身份证号
	 */
	public String getFatherIdcardnum() {
		return fatherIdcardnum;
	}
	/**
	 * 设置：父亲联系电话
	 */
	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}
	/**
	 * 获取：父亲联系电话
	 */
	public String getFatherPhone() {
		return fatherPhone;
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
		return ", 新生儿姓名='" + name + '\'' +
				", 新生儿性别='" + sex + '\'' +
				", 性别详情='" + sexDetail + '\'' +
				", 出生日期='" + DateTimeUtil.formatDateTime(bornTime)  + '\'' +
				", 身份证='" + idCardNum + '\'' +
				", 接生机构='" + deliverOrganization + '\'' +
				", 家庭地址='" + address + '\'' +
				", 信息登记时间='" + DateTimeUtil.formatDateTime(checkInDatetime)  + '\'' +
				", 母亲姓名='" + motherName + '\'' +
				", 母亲民族='" + motherNation + '\'' +
				", 母亲民族详情='" + motherNationDetail + '\'' +
				", 母亲身份证号码='" + motherIdcardnum + '\'' +
				", 母亲电话号码='" + motherPhone + '\'' +
				", 父亲电话号码='" + fatherName + '\'' +
				", 父亲民族='" + fatherNation + '\'' +
				", 父亲民族详情='" + fatherNationDetail + '\'' +
				", 父亲身份证号码='" + fatherIdcardnum + '\'' +
				", 父亲电话号码='" + fatherPhone + '\'' +
				", 备注='" + remark + '\'' +
				", 医院名称='" + HospitalName + '\'';
	}
}
