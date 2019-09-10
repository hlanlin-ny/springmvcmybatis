package com.yaofei.springmvcmybatis.entity;

import java.util.Date;


/**
 * 信息员微信群
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-17 09:46:13
 */
public class SysWechat extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private Long id;
	//群名称
	private String name;
	//描述
	private String desc;
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
	 * 设置：唯一标识
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：唯一标识
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：群名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：群名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：描述
	 */
	public String getDesc() {
		return desc;
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
