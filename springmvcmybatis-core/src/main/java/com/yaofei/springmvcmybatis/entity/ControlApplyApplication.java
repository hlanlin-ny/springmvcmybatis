package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 临时布控申请单
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-29 10:17:52
 */
public class ControlApplyApplication extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键，自增ID
	private Long id;
	//被布控人姓名
	private String controlByName;
	//绰号
	private String nickName;
	//性别
	private String sex;
	//出生日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date bornTime;
	//民族
	private String nation;
	//证件类型
	private String cardType;
	//证件号码
	private String cardNumber;
	//地址
	private String address;
	//工作单位
	private String workUnit;
	//布控事由
	private String controlReason;
	//布控措施要求
	private String controlMeasureRequire;
	//布控指令类型
	private String controlRequireType;
	//布控开始时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date controlBeginTime;
	//布控结束时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date controlEndTime;
	//布控天数
	private Integer controlDays;
	//布控单位
	private String controlUnit;
	//反馈联系方式
	private String feedBackContact;
	//申请单位
	private String applyUnit;
	//申请单位联系电话
	private String applyUnitContactTel;
	//申请人姓名
	private String applyName;
	//申请单位负责人姓名
	private String applyUnitPrincipal;
	//申请公安机关负责人签字
	private String applySafeOrgan;
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
	//布控单状态
	private String status;


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
	 * 设置：被布控人姓名
	 */
	public void setControlByName(String controlByName) {
		this.controlByName = controlByName;
	}
	/**
	 * 获取：被布控人姓名
	 */
	public String getControlByName() {
		return controlByName;
	}
	/**
	 * 设置：绰号
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：绰号
	 */
	public String getNickName() {
		return nickName;
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
	 * 设置：民族
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}
	/**
	 * 获取：民族
	 */
	public String getNation() {
		return nation;
	}
	/**
	 * 设置：证件类型
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * 获取：证件类型
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * 设置：证件号码
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * 获取：证件号码
	 */
	public String getCardNumber() {
		return cardNumber;
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
	 * 设置：工作单位
	 */
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}
	/**
	 * 获取：工作单位
	 */
	public String getWorkUnit() {
		return workUnit;
	}
	/**
	 * 设置：布控事由
	 */
	public void setControlReason(String controlReason) {
		this.controlReason = controlReason;
	}
	/**
	 * 获取：布控事由
	 */
	public String getControlReason() {
		return controlReason;
	}
	/**
	 * 设置：布控措施要求
	 */
	public void setControlMeasureRequire(String controlMeasureRequire) {
		this.controlMeasureRequire = controlMeasureRequire;
	}
	/**
	 * 获取：布控措施要求
	 */
	public String getControlMeasureRequire() {
		return controlMeasureRequire;
	}
	/**
	 * 设置：布控指令类型
	 */
	public void setControlRequireType(String controlRequireType) {
		this.controlRequireType = controlRequireType;
	}
	/**
	 * 获取：布控指令类型
	 */
	public String getControlRequireType() {
		return controlRequireType;
	}
	/**
	 * 设置：布控开始时间
	 */
	public void setControlBeginTime(Date controlBeginTime) {
		this.controlBeginTime = controlBeginTime;
	}
	/**
	 * 获取：布控开始时间
	 */
	public Date getControlBeginTime() {
		return controlBeginTime;
	}
	/**
	 * 设置：布控结束时间
	 */
	public void setControlEndTime(Date controlEndTime) {
		this.controlEndTime = controlEndTime;
	}
	/**
	 * 获取：布控结束时间
	 */
	public Date getControlEndTime() {
		return controlEndTime;
	}
	/**
	 * 设置：布控天数
	 */
	public void setControlDays(Integer controlDays) {
		this.controlDays = controlDays;
	}
	/**
	 * 获取：布控天数
	 */
	public Integer getControlDays() {
		return controlDays;
	}
	/**
	 * 设置：布控单位
	 */
	public void setControlUnit(String controlUnit) {
		this.controlUnit = controlUnit;
	}
	/**
	 * 获取：布控单位
	 */
	public String getControlUnit() {
		return controlUnit;
	}
	/**
	 * 设置：反馈联系方式
	 */
	public void setFeedBackContact(String feedBackContact) {
		this.feedBackContact = feedBackContact;
	}
	/**
	 * 获取：反馈联系方式
	 */
	public String getFeedBackContact() {
		return feedBackContact;
	}
	/**
	 * 设置：申请单位
	 */
	public void setApplyUnit(String applyUnit) {
		this.applyUnit = applyUnit;
	}
	/**
	 * 获取：申请单位
	 */
	public String getApplyUnit() {
		return applyUnit;
	}
	/**
	 * 设置：申请单位联系电话
	 */
	public void setApplyUnitContactTel(String applyUnitContactTel) {
		this.applyUnitContactTel = applyUnitContactTel;
	}
	/**
	 * 获取：申请单位联系电话
	 */
	public String getApplyUnitContactTel() {
		return applyUnitContactTel;
	}
	/**
	 * 设置：申请人姓名
	 */
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	/**
	 * 获取：申请人姓名
	 */
	public String getApplyName() {
		return applyName;
	}
	/**
	 * 设置：申请单位负责人姓名
	 */
	public void setApplyUnitPrincipal(String applyUnitPrincipal) {
		this.applyUnitPrincipal = applyUnitPrincipal;
	}
	/**
	 * 获取：申请单位负责人姓名
	 */
	public String getApplyUnitPrincipal() {
		return applyUnitPrincipal;
	}
	/**
	 * 设置：申请公安机关负责人签字
	 */
	public void setApplySafeOrgan(String applySafeOrgan) {
		this.applySafeOrgan = applySafeOrgan;
	}
	/**
	 * 获取：申请公安机关负责人签字
	 */
	public String getApplySafeOrgan() {
		return applySafeOrgan;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
