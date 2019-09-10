package com.yaofei.springmvcmybatis.entity;

import java.util.Date;


/**
 * 医院单位信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:36:52
 */
public class HospitalUnitInformation extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键 自增ID
	private Long id;
	//医院名称
	private String hospitalName;
	//医院地址（详细地址）
	private String hospitalAddress;
	//所属区县(所属行政区划)
	private String area;
	//所属行政区划
	private Long areaId;
	//所属公安机关
	private String policeOffice;
	//联系人
	private String contact;
	//联系电话
	private String tel;
	//紧急联系人
	private String emergencyContact;
	//紧急联系电话
	private String emergencyTel;
	//备注
	private String remark;
	//删除状态  0：正常   1：已删除
	private Boolean isDeleted;
	//创建人
	private String createdBy;
	//创建IP
	private String createdIp;
	//创建时间
	private Date createdTime;
	//修改时间
	private Date modificationTime;
	//修改人
	private String modificationBy;
	//修改人IP
	private String modificationIp;

	/**
	 * 设置：主键 自增ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键 自增ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：医院名称
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	/**
	 * 获取：医院名称
	 */
	public String getHospitalName() {
		return hospitalName;
	}
	/**
	 * 设置：医院地址（详细地址）
	 */
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	/**
	 * 获取：医院地址（详细地址）
	 */
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	/**
	 * 设置：所属区县(所属行政区划)
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：所属区县(所属行政区划)
	 */
	public String getArea() {
		return area;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	/**
	 * 设置：所属公安机关
	 */
	public void setPoliceOffice(String policeOffice) {
		this.policeOffice = policeOffice;
	}
	/**
	 * 获取：所属公安机关
	 */
	public String getPoliceOffice() {
		return policeOffice;
	}
	/**
	 * 设置：联系人
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：联系人
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置：联系电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：联系电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：紧急联系人
	 */
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	/**
	 * 获取：紧急联系人
	 */
	public String getEmergencyContact() {
		return emergencyContact;
	}
	/**
	 * 设置：紧急联系电话
	 */
	public void setEmergencyTel(String emergencyTel) {
		this.emergencyTel = emergencyTel;
	}
	/**
	 * 获取：紧急联系电话
	 */
	public String getEmergencyTel() {
		return emergencyTel;
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
}
