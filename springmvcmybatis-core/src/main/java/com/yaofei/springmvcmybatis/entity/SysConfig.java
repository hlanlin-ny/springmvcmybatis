package com.yaofei.springmvcmybatis.entity;

import java.util.Date;

/**
 * 系统配置信息表
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-02-20 16:46:23
 */
public class SysConfig extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键，自增ID
	private Long id;
	//key
	private String itemKey;
	//value
	private String itemValue;
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

	public SysConfig() {
	}

	public SysConfig(String itemKey, String itemValue, String remark, String createdBy, String createdIp) {
		this.itemKey = itemKey;
		this.itemValue = itemValue;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdIp = createdIp;
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
	 * 设置：key
	 */
	public void setItemKey(String itemKey) {
		this.itemKey = itemKey;
	}
	/**
	 * 获取：key
	 */
	public String getItemKey() {
		return itemKey;
	}
	/**
	 * 设置：value
	 */
	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}
	/**
	 * 获取：value
	 */
	public String getItemValue() {
		return itemValue;
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

	@Override
	public String toString() {
		return "SysConfig{" +
				"id=" + id +
				", itemKey='" + itemKey + '\'' +
				", itemValue='" + itemValue + '\'' +
				", remark='" + remark + '\'' +
				", isDeleted=" + isDeleted +
				", createdTime=" + createdTime +
				", createdBy='" + createdBy + '\'' +
				", createdIp='" + createdIp + '\'' +
				", modificationTime=" + modificationTime +
				", modificationBy='" + modificationBy + '\'' +
				", modificationIp='" + modificationIp + '\'' +
				'}';
	}
}
