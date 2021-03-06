package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 系统搜索预警通知日志表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-24 17:13:53
 */
public class SysSearchwarningLog extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键，自增ID
	private Long id;
	//
	private Long searchwarningConfigId;
	//记录条数
	private Long recordCount;
	//通知人
	private String noticeTo;
	//备注
	private String remark;
	//删除状态  0：正常   1：已删除
	private Boolean isDeleted = false;
	//创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
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

	private String noticeToName;
	private String keywords;

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
	 * 设置：
	 */
	public void setSearchwarningConfigId(Long searchwarningConfigId) {
		this.searchwarningConfigId = searchwarningConfigId;
	}
	/**
	 * 获取：
	 */
	public Long getSearchwarningConfigId() {
		return searchwarningConfigId;
	}
	/**
	 * 设置：记录条数
	 */
	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}
	/**
	 * 获取：记录条数
	 */
	public Long getRecordCount() {
		return recordCount;
	}
	/**
	 * 设置：通知人
	 */
	public void setNoticeTo(String noticeTo) {
		this.noticeTo = noticeTo;
	}
	/**
	 * 获取：通知人
	 */
	public String getNoticeTo() {
		return noticeTo;
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

	public String getNoticeToName() {
		return noticeToName;
	}

	public void setNoticeToName(String noticeToName) {
		this.noticeToName = noticeToName;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}
