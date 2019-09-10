package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 情报信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-12 11:31:52
 */
public class Intelligence extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键，自增ID
	private Long id;
	//行政区划编号
	private Long areaId;
	private String areaName;
	//协查标题
	private String title;
	//上报人
	private String intelligenceOfficerId;
	private String intelligenceOfficerName;
	//上报时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date reportingTime;
	//信息描述
	private String infoDesc;
	//发现时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date foundTime;
	//情报级别 0，一般；1，重要；2，非常重要
	private Integer level;
	//奖励状态：0，未奖励；1，已奖励
	private Boolean awardsStatus;
	//奖励描述
	private String awardsDesc;
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
	public void setAreaName(String areaName){
		this.areaName = areaName;
	}
	/**
	 * 获取：行政区划编号
	 */
	public Long getAreaId() {
		return areaId;
	}
	public String getAreaName(){
		return areaName;
	}
	/**
	 * 设置：协查标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：协查标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：上报人
	 */
	public void setIntelligenceOfficerId(String intelligenceOfficerId) {
		this.intelligenceOfficerId = intelligenceOfficerId;
	}
	public void setIntelligenceOfficerName(String intelligenceOfficerName){
		this.intelligenceOfficerName = intelligenceOfficerName;
	}
	/**
	 * 获取：上报人
	 */
	public String getIntelligenceOfficerId() {
		return intelligenceOfficerId;
	}
	public String getIntelligenceOfficerName(){
		return intelligenceOfficerName;
	}
	/**
	 * 设置：上报时间
	 */
	public void setReportingTime(Date reportingTime) {
		this.reportingTime = reportingTime;
	}
	/**
	 * 获取：上报时间
	 */
	public Date getReportingTime() {
		return reportingTime;
	}
	/**
	 * 设置：
	 */
	public void setInfoDesc(String infoDesc) {
		this.infoDesc = infoDesc;
	}
	/**
	 * 获取：
	 */
	public String getInfoDesc() {
		return infoDesc;
	}
	/**
	 * 设置：发现时间
	 */
	public void setFoundTime(Date foundTime) {
		this.foundTime = foundTime;
	}
	/**
	 * 获取：发现时间
	 */
	public Date getFoundTime() {
		return foundTime;
	}
	/**
	 * 设置：情报级别 0，一般；1，重要；2，非常重要
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：情报级别 0，一般；1，重要；2，非常重要
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：奖励状态：0，未奖励；1，已奖励
	 */
	public void setAwardsStatus(Boolean awardsStatus) {
		this.awardsStatus = awardsStatus;
	}
	/**
	 * 获取：奖励状态：0，未奖励；1，已奖励
	 */
	public Boolean getAwardsStatus() {
		return awardsStatus;
	}
	/**
	 * 设置：奖励描述
	 */
	public void setAwardsDesc(String awardsDesc) {
		this.awardsDesc = awardsDesc;
	}
	/**
	 * 获取：奖励描述
	 */
	public String getAwardsDesc() {
		return awardsDesc;
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
}
