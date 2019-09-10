package com.yaofei.springmvcmybatis.entity;

import java.util.Date;


/**
 * 医院网点信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-10-11 10:14:33
 */
public class HospitalUser extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//行政区划编号
	private Long areaId;
	//所属医院编号
	private Long hospitalId;
	//所属公安机关
	private String policeOffice;
	//医院网点名称
	private String branchName;
	//姓名
	private String realName;
	//用户名
	private String username;
	//密码
	private String password;
	//密码盐值
	private String passwordSalt;
	//密钥
	private String seckey;
	//邮箱
	private String email;
	//地址
	private String address;
	//联系人
	private String contactPerson;
	//联系电话
	private String contactPhone;
	//紧急联系人
	private String emergencyContactPerson;
	//紧急联系电话
	private String emergencyContactPhone;
	//激活状态  0：未激活   1：已激活
	private Boolean activated;
	//锁定状态  0：正常   1：锁定
	private Boolean locked;
	//禁用状态  0：正常 1：已禁用
	private Boolean disabled;
	//备注
	private String remark;
	//删除状态  0：正常   1：已删除
	private Boolean isDeleted;
	//创建时间
	private Date createdTime;
	//创建人
	private String createdBy;
	//创建IP
	private String createdIp;
	//修改时间
	private Date modificationTime;
	//修改人
	private String modificationBy;
	//修改人IP
	private String modificationIp;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
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
	 * 设置：所属医院编号
	 */
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	/**
	 * 获取：所属医院编号
	 */
	public Long getHospitalId() {
		return hospitalId;
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
	 * 设置：医院网点名称
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/**
	 * 获取：医院网点名称
	 */
	public String getBranchName() {
		return branchName;
	}
	/**
	 * 设置：姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 获取：姓名
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：密码盐值
	 */
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	/**
	 * 获取：密码盐值
	 */
	public String getPasswordSalt() {
		return passwordSalt;
	}
	/**
	 * 设置：密钥
	 */
	public void setSeckey(String seckey) {
		this.seckey = seckey;
	}
	/**
	 * 获取：密钥
	 */
	public String getSeckey() {
		return seckey;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
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
	 * 设置：紧急联系人
	 */
	public void setEmergencyContactPerson(String emergencyContactPerson) {
		this.emergencyContactPerson = emergencyContactPerson;
	}
	/**
	 * 获取：紧急联系人
	 */
	public String getEmergencyContactPerson() {
		return emergencyContactPerson;
	}
	/**
	 * 设置：紧急联系电话
	 */
	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}
	/**
	 * 获取：紧急联系电话
	 */
	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}
	/**
	 * 设置：激活状态  0：未激活   1：已激活
	 */
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}
	/**
	 * 获取：激活状态  0：未激活   1：已激活
	 */
	public Boolean getActivated() {
		return activated;
	}
	/**
	 * 设置：锁定状态  0：正常   1：锁定
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	/**
	 * 获取：锁定状态  0：正常   1：锁定
	 */
	public Boolean getLocked() {
		return locked;
	}
	/**
	 * 设置：禁用状态  0：正常 1：已禁用
	 */
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	/**
	 * 获取：禁用状态  0：正常 1：已禁用
	 */
	public Boolean getDisabled() {
		return disabled;
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


	private String hospitalName;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
}
