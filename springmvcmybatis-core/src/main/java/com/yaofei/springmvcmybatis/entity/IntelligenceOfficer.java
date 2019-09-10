package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 情报员信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-12 11:31:29
 */
public class IntelligenceOfficer extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键，自增ID
	private Long id;
	//行政区划编号
	private Long areaId;
	private String areaName;
	//姓名
	private String name;
	//性别  0:男 1:女
	private Boolean sex;
	//身份证号
	private String idNumbers;
	//出生日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date birthDate;
	//住址
	private String adress;
	//入职时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date hireDate;
	//职业
	private String profession;
	//婚姻状况
	private Integer maritalStatus;
	//手机号
	private String phone;
	//QQ
	private String qq;
	//微信号
	private String wechat;
	//邮箱
	private String email;
	//信息员状态 0:启用 1,停用 2,失效
	private Integer status;
	//备注
	private String remark;
	//删除状态  0：正常   1：已删除
	private Boolean isDeleted = false;
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
	//信息员所属微信群
	private Integer belongwechat;
	private String wechatName;
	//是否已经升级为情报员
	private Boolean isOfficer = false;

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
	 * 设置：性别  0:男 1:女
	 */
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别  0:男 1:女
	 */
	public Boolean getSex() {
		return sex;
	}
	/**
	 * 设置：身份证号
	 */
	public void setIdNumbers(String idNumbers) {
		this.idNumbers = idNumbers;
	}
	/**
	 * 获取：身份证号
	 */
	public String getIdNumbers() {
		return idNumbers;
	}
	/**
	 * 设置：出生日期
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * 获取：出生日期
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * 设置：住址
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * 获取：住址
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * 设置：入职时间
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	/**
	 * 获取：入职时间
	 */
	public Date getHireDate() {
		return hireDate;
	}
	/**
	 * 设置：职业
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}
	/**
	 * 获取：职业
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * 设置：婚姻状况
	 */
	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	/**
	 * 获取：婚姻状况
	 */
	public Integer getMaritalStatus() {
		return maritalStatus;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：QQ
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * 获取：QQ
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * 设置：微信号
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	/**
	 * 获取：微信号
	 */
	public String getWechat() {
		return wechat;
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
	 * 设置：信息员状态 0:启用 1,停用 2,失效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：信息员状态 0:启用 1,停用 2,失效
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：信息员所属微信群
	 */
	public void setBelongweset(Integer belongwechat) {
		this.belongwechat = belongwechat;
	}
	/**
	 * 获取：信息员所属微信群
	 */
	public Integer getBelongwechat() {
		return belongwechat;
	}
	/**
	 * 设置：是否已经升级为情报员
	 */
	public void setIsOfficer(Boolean isOfficer) {
		this.isOfficer = isOfficer;
	}
	/**
	 * 获取：修改人IP
	 */
	public Boolean getIsOfficer() {
		return isOfficer;
	}
	public void setAreaName(String areaName){
		this.areaName = areaName;
	}
	public String getAreaName(){
		return areaName;
	}

	public void seWechatName(String wechatName){
		this.wechatName = wechatName;
	}
	public String getWechatName(){
		return wechatName;
	}
}
