package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 预警处置详情
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-21 11:14:23
 */
public class WarningDispostion extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//主键 自增id
	private Long id;
	//预警人员姓名
	private String name;
	//身份证号码
	private String idCardNo;
	//预警人员类别
	private String warningPersonType;
	//预警级别：一般，重要，紧急
	private String warningLevel;
	//预警时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date warningTime;
	//信息类别
	private String informationType;
	//指令发布单位
	private String issueProvider;
	//所属社会场所
	private String informationProvider;
	//活动发生区域
	private String providerAddress;
	//所属公安机关
	private String policeOffice;
	//预警接受单位
	private String acceptProvider;
	//处置状态 ： 未处置   处置完成
	private String dispositionStatus;
	//处置时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date dispositionTime;
	//反馈状态：未反馈，已反馈
	private String feedBackStatus;
	//反馈时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date feedBackTime;
	//反馈结果
	private String feedBackResult;
	//签收状态  已签收 未签收
	private String claimStatus;
	//删除状态  0：正常   1：已删除
	private Boolean isDeleted;
	//创建人
	private String createdBy;
	//创建IP
	private String createdIp;
	//创建时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date createdTime;
	//修改时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date modificationTime;
	//修改人
	private String modificationBy;
	//修改人IP
	private String modificationIp;
	//备注
	private String remark;
	//
	private Long relateId;

	//临时属性
	private String tel;

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
	 * 设置：重点人员姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：重点人员姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：身份证号码
	 */
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	/**
	 * 获取：身份证号码
	 */
	public String getIdCardNo() {
		return idCardNo;
	}

	public String getWarningPersonType() {
		return warningPersonType;
	}

	public void setWarningPersonType(String warningPersonType) {
		this.warningPersonType = warningPersonType;
	}

	/**
	 * 设置：预警级别：一般，重要，紧急
	 */
	public void setWarningLevel(String warningLevel) {
		this.warningLevel = warningLevel;
	}
	/**
	 * 获取：预警级别：一般，重要，紧急
	 */
	public String getWarningLevel() {
		return warningLevel;
	}
	/**
	 * 设置：预警时间
	 */
	public void setWarningTime(Date warningTime) {
		this.warningTime = warningTime;
	}
	/**
	 * 获取：预警时间
	 */
	public Date getWarningTime() {
		return warningTime;
	}
	/**
	 * 设置：信息类别
	 */
	public void setInformationType(String informationType) {
		this.informationType = informationType;
	}
	/**
	 * 获取：信息类别
	 */
	public String getInformationType() {
		return informationType;
	}
	/**
	 * 设置：指令发布单位
	 */
	public void setIssueProvider(String issueProvider) {
		this.issueProvider = issueProvider;
	}
	/**
	 * 获取：指令发布单位
	 */
	public String getIssueProvider() {
		return issueProvider;
	}
	/**
	 * 设置：所属社会场所
	 */
	public void setInformationProvider(String informationProvider) {
		this.informationProvider = informationProvider;
	}
	/**
	 * 获取：所属社会场所
	 */
	public String getInformationProvider() {
		return informationProvider;
	}
	/**
	 * 设置：活动发生区域
	 */
	public void setProviderAddress(String providerAddress) {
		this.providerAddress = providerAddress;
	}
	/**
	 * 获取：活动发生区域
	 */
	public String getProviderAddress() {
		return providerAddress;
	}
	/**
	 * 设置：所属公安机关
	 */
	public void setPoliceOffice(String policeOffice) {
		this.policeOffice = policeOffice;
	}
	/**
	 * 获取：所属公安机关
	 */
	public String getPoliceOffice() {
		return policeOffice;
	}
	/**
	 * 设置：预警接受单位
	 */
	public void setAcceptProvider(String acceptProvider) {
		this.acceptProvider = acceptProvider;
	}
	/**
	 * 获取：预警接受单位
	 */
	public String getAcceptProvider() {
		return acceptProvider;
	}
	/**
	 * 设置：处置状态 ： 未处置  处置中 处置完成
	 */
	public void setDispositionStatus(String dispositionStatus) {
		this.dispositionStatus = dispositionStatus;
	}
	/**
	 * 获取：处置状态 ： 未处置  处置中 处置完成
	 */
	public String getDispositionStatus() {
		return dispositionStatus;
	}
	/**
	 * 设置：处置时限
	 */
	public void setDispositionTimeLimit(Date dispositionTime) {
		this.dispositionTime = dispositionTime;
	}
	/**
	 * 获取：处置时限
	 */
	public Date getDispositionTime() {
		return dispositionTime;
	}
	/**
	 * 设置：反馈状态：未反馈，已反馈
	 */
	public void setFeedBackStatus(String feedBackStatus) {
		this.feedBackStatus = feedBackStatus;
	}
	/**
	 * 获取：反馈状态：未反馈，已反馈
	 */
	public String getFeedBackStatus() {
		return feedBackStatus;
	}
	/**
	 * 设置：反馈时限
	 */
	public void setFeedBackTime(Date feedBackTime) {
		this.feedBackTime = feedBackTime;
	}
	/**
	 * 获取：反馈时限
	 */
	public Date getFeedBackTime() {
		return feedBackTime;
	}
	/**
	 * 设置：反馈结果
	 */
	public void setFeedBackResult(String feedBackResult) {
		this.feedBackResult = feedBackResult;
	}
	/**
	 * 获取：反馈结果
	 */
	public String getFeedBackResult() {
		return feedBackResult;
	}

	public void setDispositionTime(Date dispositionTime) {
		this.dispositionTime = dispositionTime;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
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
	 * 设置：
	 */
	public void setRelateId(Long relateId) {
		this.relateId = relateId;
	}
	/**
	 * 获取：
	 */
	public Long getRelateId() {
		return relateId;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
