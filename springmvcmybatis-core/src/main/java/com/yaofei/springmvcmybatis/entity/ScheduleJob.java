package com.yaofei.springmvcmybatis.entity;

import java.util.Date;

/**
 * 定时任务表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-02-21 21:13:29
 */
public class ScheduleJob  extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * 任务调度参数key
	 */
	public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";

	//主键，自增ID
	private Long id;
	//spring bean名称
	private String beanName;
	//方法名
	private String methodName;
	//参数
	private String params;
	//CRON表达式
	private String cronExpression;
	//任务状态  任务状态。0：正常；1：暂停
	private Integer status;
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
	//关联id
	private Long relateId;
	//定时任务类别
	private String scheduleType;
	//无参构造器
	public ScheduleJob(){}
	//有参构造器
	public ScheduleJob(String beanName, String methodName, String params, Integer status, String remark, String cronExpression, String createdBy, String createdIp, Long relateId, String scheduleType) {
		this.beanName = beanName;
		this.methodName = methodName;
		this.params = params;
		this.status = status;
		this.remark = remark;
		this.cronExpression = cronExpression;
		this.createdBy = createdBy;
		this.createdIp = createdIp;
		this.relateId = relateId;
		this.scheduleType = scheduleType;
	}

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
	 * 设置：spring bean名称
	 */
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	/**
	 * 获取：spring bean名称
	 */
	public String getBeanName() {
		return beanName;
	}
	/**
	 * 设置：方法名
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	/**
	 * 获取：方法名
	 */
	public String getMethodName() {
		return methodName;
	}
	/**
	 * 设置：参数
	 */
	public void setParams(String params) {
		this.params = params;
	}
	/**
	 * 获取：参数
	 */
	public String getParams() {
		return params;
	}
	/**
	 * 设置：CRON表达式
	 */
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	/**
	 * 获取：CRON表达式
	 */
	public String getCronExpression() {
		return cronExpression;
	}
	/**
	 * 设置：任务状态。0：正常；1：暂停
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：任务状态。0：正常；1：暂停
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
	public void setcreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getcreatedTime() {
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

	/**
	 * 获取：关联Id
	 */
	public Long getRelateId() { return relateId; }
	/**
	 * 设置：关联Id
	 */
	public void setRelateId(Long relateId) { this.relateId = relateId; }
	/**
	 * 获取：定时任务类别
	 */
	public String getScheduleType() { return scheduleType; }
	/**
	 * 设置：定时任务类别
	 */
	public void setScheduleType(String scheduleType) { this.scheduleType = scheduleType; }

}
