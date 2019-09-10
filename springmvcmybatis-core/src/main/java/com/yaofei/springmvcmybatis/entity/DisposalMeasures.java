package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 处置措施表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-23 09:26:15
 */
public class DisposalMeasures extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键 自增id
	private Long id;
	//发布人
	private String issuerName;
	//处置时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date dispositionTime;
	//首次反馈时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date firstFeedTime;
	//发布单位
	private String issuerProvider;
	//备注
	private String remark;
	//指令要求
	private String instructReuqest;
	//研判结果
	private String result;
	//关联importantPerson id
	private Long relateId;
	//删除状态  0：正常   1：已删除
	private Boolean isDeleted;
	//创建人
	private String createdBy;
	//创建IP
	private String createdIp;
	//创建时间
	private Date createdTime;
	//修改时间
	private Date modificationTime;
	//修改人
	private String modificationBy;
	//修改人IP
	private String modificationIp;

	/**
	 * 设置：主键 自增id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键 自增id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：发布人
	 */
	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}
	/**
	 * 获取：发布人
	 */
	public String getIssuerName() {
		return issuerName;
	}
	/**
	 * 设置：处置时限
	 */
	public void setDispositionTime(Date dispositionTime) {
		this.dispositionTime = dispositionTime;
	}
	/**
	 * 获取：处置时限
	 */
	public Date getDispositionTime() {
		return dispositionTime;
	}
	/**
	 * 设置：首次反馈时间
	 */
	public void setFirstFeedTime(Date firstFeedTime) {
		this.firstFeedTime = firstFeedTime;
	}
	/**
	 * 获取：首次反馈时间
	 */
	public Date getFirstFeedTime() {
		return firstFeedTime;
	}
	/**
	 * 设置：发布单位
	 */
	public void setIssuerProvider(String issuerProvider) {
		this.issuerProvider = issuerProvider;
	}
	/**
	 * 获取：发布单位
	 */
	public String getIssuerProvider() {
		return issuerProvider;
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
	 * 设置：指令要求
	 */
	public void setInstructReuqest(String instructReuqest) {
		this.instructReuqest = instructReuqest;
	}
	/**
	 * 获取：指令要求
	 */
	public String getInstructReuqest() {
		return instructReuqest;
	}
	/**
	 * 设置：研判结果
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * 获取：研判结果
	 */
	public String getResult() {
		return result;
	}
	/**
	 * 设置：关联importantPerson id
	 */
	public void setRelateId(Long relateId) {
		this.relateId = relateId;
	}
	/**
	 * 获取：关联importantPerson id
	 */
	public Long getRelateId() {
		return relateId;
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
