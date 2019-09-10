package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;



/**
 * 系统用户权限表
 * 
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public class SysUserPermission  extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键，自增ID
	private Long id;
	//父权限ID，一级权限为0
	private Long parentId;
	//父权限名称，一级权限为根菜单
	@NotEmpty()
	private String parentName;
	//权限名称
	private String name;
	//类型   0：目录   1：菜单   2：按钮
	@NotNull
	private Integer type;
	//权限URL
	private String url;
	//	权限代码。(多个用逗号分隔，如：user:list,user:create)
	private String permissionCode;
	//权限图标
	private String icon;
	//排序
	@NotNull
	private Integer orderNum;
	//状态  0：正常   1：删除
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
	 * 设置：父权限ID，一级权限为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父权限ID，一级权限为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：父权限名称，一级权限为根菜单
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	/**
	 * 获取：父权限名称，一级权限为根菜单
	 */
	public String getParentName() {
		return parentName;
	}
	/**
	 * 设置：权限名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：权限名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：类型   0：目录   1：菜单   2：按钮
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型   0：目录   1：菜单   2：按钮
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：权限URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：权限URL
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：	权限代码。(多个用逗号分隔，如：user:list,user:create)
	 */
	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}
	/**
	 * 获取：	权限代码。(多个用逗号分隔，如：user:list,user:create)
	 */
	public String getPermissionCode() {
		return permissionCode;
	}
	/**
	 * 设置：权限图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：权限图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：0：正常   1：删除
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * 获取：0：正常   1：删除
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedTime(Date registerTime) {
		this.createdTime = registerTime;
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
	 * ztree属性
	 */
	private Boolean open;

	public Boolean isOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	@Override
	public String toString() {
		return "SysUserPermission{" +
				"id=" + id +
				", parentId=" + parentId +
				", parentName='" + parentName + '\'' +
				", name='" + name + '\'' +
				", type=" + type +
				", url='" + url + '\'' +
				", permissionCode='" + permissionCode + '\'' +
				", icon='" + icon + '\'' +
				", orderNum=" + orderNum +
				", isDeleted=" + isDeleted +
				", createdTime=" + createdTime +
				", createdBy='" + createdBy + '\'' +
				", createdIp='" + createdIp + '\'' +
				", modificationTime=" + modificationTime +
				", modificationBy='" + modificationBy + '\'' +
				", modificationIp='" + modificationIp + '\'' +
				", remark='" + remark + '\'' +
				", open=" + open +
				'}';
	}
}
