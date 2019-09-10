package com.yaofei.springmvcmybatis.entity;

import javax.validation.constraints.NotNull;
import java.util.Date;



/**
 * 系统用户角色关系表
 * 
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public class SysUserUserRole  extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键，自增ID
	private Long id;
	//用户ID
	@NotNull
	private Long userId;
	//用户角色ID
	@NotNull
	private Long userRoleId;
	//状态  0：禁用   1：正常
	private Boolean isDeleted;
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
	//备注
	private String remark;

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
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户角色ID
	 */
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	/**
	 * 获取：用户角色ID
	 */
	public Long getUserRoleId() {
		return userRoleId;
	}
	/**
	 * 设置：状态  0：禁用   1：正常
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * 获取：状态  0：禁用   1：正常
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

	@Override
	public String toString() {
		return "SysUserUserRole{" +
				"id=" + id +
				", userId=" + userId +
				", userRoleId=" + userRoleId +
				", isDeleted=" + isDeleted +
				", createdBy='" + createdBy + '\'' +
				", createdIp='" + createdIp + '\'' +
				", modificationTime=" + modificationTime +
				", modificationBy='" + modificationBy + '\'' +
				", modificationIp='" + modificationIp + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}
