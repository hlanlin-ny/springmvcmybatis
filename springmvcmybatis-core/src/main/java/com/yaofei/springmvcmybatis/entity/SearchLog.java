package com.yaofei.springmvcmybatis.entity;

import java.util.Date;


/**
 * 搜索日志表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-03 17:46:20
 */
public class SearchLog extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键，自增ID
	private Long id;
	//用户ID
	private Long userId;
	//行政区划ID
	private Long areaId;
	//数据源类型1：结构化数据；2：文件数据
	private Integer datasourceType;
	//情报业务分类ID
	private Long intelligenceBusinessTypeId;
	//关键词
	private String keyword;
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
	 * 设置：行政区划ID
	 */
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：行政区划ID
	 */
	public Long getAreaId() {
		return areaId;
	}
	/**
	 * 设置：数据源类型1：结构化数据；2：文件数据
	 */
	public void setDatasourceType(Integer datasourceType) {
		this.datasourceType = datasourceType;
	}
	/**
	 * 获取：数据源类型1：结构化数据；2：文件数据
	 */
	public Integer getDatasourceType() {
		return datasourceType;
	}
	/**
	 * 设置：情报业务分类ID
	 */
	public void setIntelligenceBusinessTypeId(Long intelligenceBusinessTypeId) {
		this.intelligenceBusinessTypeId = intelligenceBusinessTypeId;
	}
	/**
	 * 获取：情报业务分类ID
	 */
	public Long getIntelligenceBusinessTypeId() {
		return intelligenceBusinessTypeId;
	}
	/**
	 * 设置：关键词
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * 获取：关键词
	 */
	public String getKeyword() {
		return keyword;
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
}
