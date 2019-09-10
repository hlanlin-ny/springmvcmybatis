package com.yaofei.springmvcmybatis.entity;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.List;


/**
 * 系统用户角色表
 * 
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public class SysUserRole  extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键，自增ID
	private Long id;
	//角色名称
	@NotEmpty()
	private String name;
	//角色代码
	@NotEmpty()
	private String roleCode;
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
	 * 设置：角色名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：角色名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：角色代码
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	/**
	 * 获取：角色代码
	 */
	public String getRoleCode() {
		return roleCode;
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






	//供界面使用
	//权限名称
	private String permissionNames;
	/**
	 * 设置：权限名称
	 */
	public void setPermissionNames(String permissionNames) {
		this.permissionNames = permissionNames;
	}
	/**
	 * 获取：权限名称
	 */
	public String getPermissionNames() {
		return permissionNames;
	}
	//权限ID
	private List<Long> permissionIds;
	/**
	 * 设置：权限ID
	 */
	public List<Long> getPermissionIds() {
		return permissionIds;
	}
	/**
	 * 获取：权限ID
	 */
	public void setPermissionIds(List<Long> permissionIds) {
		this.permissionIds = permissionIds;
	}

	@Override
	public String toString() {
		return "SysUserRole{" +
				"id=" + id +
				", name='" + name + '\'' +
				", roleCode='" + roleCode + '\'' +
				", isDeleted=" + isDeleted +
				", createdBy='" + createdBy + '\'' +
				", createdIp='" + createdIp + '\'' +
				", modificationTime=" + modificationTime +
				", modificationBy='" + modificationBy + '\'' +
				", modificationIp='" + modificationIp + '\'' +
				", remark='" + remark + '\'' +
				", permissionNames='" + permissionNames + '\'' +
				", permissionIds=" + permissionIds +
				'}';
	}
}
