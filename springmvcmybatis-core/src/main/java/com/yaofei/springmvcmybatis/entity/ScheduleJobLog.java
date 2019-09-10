package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 定时任务日志
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-02-21 21:13:29
 */
public class ScheduleJobLog  extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键，自增ID
	private Long id;
	//任务ID
	private Long scheduleJobId;
	//spring bean名称
	private String beanName;
	//方法名
	private String methodName;
	//参数
	private String params;
	//任务状态    0：成功    1：失败
	private Integer status;
	//失败信息
	private String error;
	//耗时(单位：毫秒)
	private Integer times;
	//创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date createdTime;
	//创建人
	private String createdBy;
	//创建IP
	private String createdIp;

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
	 * 设置：任务ID
	 */
	public void setScheduleJobId(Long scheduleJobId) {
		this.scheduleJobId = scheduleJobId;
	}
	/**
	 * 获取：任务ID
	 */
	public Long getScheduleJobId() {
		return scheduleJobId;
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
	 * 设置：任务状态    0：成功    1：失败
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：任务状态    0：成功    1：失败
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：失败信息
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * 获取：失败信息
	 */
	public String getError() {
		return error;
	}
	/**
	 * 设置：耗时(单位：毫秒)
	 */
	public void setTimes(Integer times) {
		this.times = times;
	}
	/**
	 * 获取：耗时(单位：毫秒)
	 */
	public Integer getTimes() {
		return times;
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
}
