package com.yaofei.springmvcmybatis.entity;

import java.util.Date;


/**
 * 系统行政区划表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-07-31 08:07:18
 */
public class SysArea extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键，自增ID
	private Long id;
	//父ID，一级为0
	private Long parentId;
	//名称
	private String name;
	//编码
	private String code;
	//类型：1省份、2市、3区县
	private Integer type;
	//排序
	private Integer orderNum;
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
	 * 设置：父ID，一级为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父ID，一级为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 设置：类型：1省份、2市、3区县
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型：1省份、2市、3区县
	 */
	public Integer getType() {
		return type;
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

	//父部门名称，一级部门为根部门
	private String parentName;

	/**
	 * 设置：父部门名称，一级部门为根部门
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	/**
	 * 获取：父部门名称，一级部门为根部门
	 */
	public String getParentName() {
		return parentName;
	}
}
