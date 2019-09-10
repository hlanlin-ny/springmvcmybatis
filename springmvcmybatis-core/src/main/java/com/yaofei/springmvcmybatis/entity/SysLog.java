package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 系统日志表
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-02-20 16:46:23
 */
public class SysLog  extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键，自增ID
	private Long id;
	//用户名
	private String username;
	//用户姓名
	private String userRealName;
	//操作的类
	private String opertionClassName;
	//操作的方法
	private String opertionMethodName;
	//操作的参数
	private String opertionParamValue;
	//客户端ip
	private String clientIp;
	//创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date createdTime;

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
	 * 设置：用户姓名
	 */
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getUserRealName() {
		return userRealName;
	}
	/**
	 * 设置：操作的类
	 */
	public void setOpertionClassName(String opertionClassName) {
		this.opertionClassName = opertionClassName;
	}
	/**
	 * 获取：操作的类
	 */
	public String getOpertionClassName() {
		return opertionClassName;
	}
	/**
	 * 设置：操作的方法
	 */
	public void setOpertionMethodName(String opertionMethodName) {
		this.opertionMethodName = opertionMethodName;
	}
	/**
	 * 获取：操作的方法
	 */
	public String getOpertionMethodName() {
		return opertionMethodName;
	}
	/**
	 * 设置：操作的参数
	 */
	public void setOpertionParamValue(String opertionParamValue) {
		this.opertionParamValue = opertionParamValue;
	}
	/**
	 * 获取：操作的参数
	 */
	public String getOpertionParamValue() {
		return opertionParamValue;
	}
	/**
	 * 设置：客户端ip
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	/**
	 * 获取：客户端ip
	 */
	public String getClientIp() {
		return clientIp;
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

	@Override
	public String toString() {
		return "SysLog{" +
				"id=" + id +
				", username='" + username + '\'' +
				", userRealName='" + userRealName + '\'' +
				", opertionClassName='" + opertionClassName + '\'' +
				", opertionMethodName='" + opertionMethodName + '\'' +
				", opertionParamValue='" + opertionParamValue + '\'' +
				", clientIp='" + clientIp + '\'' +
				", createdTime=" + createdTime +
				'}';
	}
}
