package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 搜索预警配置表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-24 17:12:36
 */
public class SysSearchwarningConfig extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 任务调度参数key
	 */
	public static final String JOB_WARN_KEY = "JOB_WARN_KEY";
	//主键，自增ID
	private Long id;
	private Long areaId;
	//关键字
	private String keywords;
	//情报类型
	private String businesstypeid;
	private String businesstypename;
	//文件类型
	private String filetype;
	private String filetypename;
	//查询数据开始时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date startTime;
	//通知人
	private String noticeTo;
	private String noticeToName;
	//抄送人们，多个抄送人ID用逗号隔开
	private String noticeBccs;
	//是否精确匹配  0：否   1：是
	private Boolean isExactMatching;
	//任务状态  任务状态。0：正常；1：暂停
	private Integer status;
	//提醒频率，单位分钟
	private String noticeFrequency;
	//cron表达式
	private String cronExpression;
	private String cronFrequency;
	//备注
	private String remark;
	//删除状态  0：正常   1：已删除
	private Boolean isDeleted = false;
	//创建时间
	private Date createdTime;
	//创建人
	private String createdBy;
	//创建人名称
	private String userName;
	//创建IP
	private String createdIp;
	//修改时间
	private Date modificationTime;
	//修改人
	private String modificationBy;
	//修改人IP
	private String modificationIp;

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
	 * 设置：关键字
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	/**
	 * 获取：关键字
	 */
	public String getKeywords() {
		return keywords;
	}
	/**
	 * 设置：情报类型
	 */
	public void setBusinesstypeid(String businesstypeid) {
		this.businesstypeid = businesstypeid;
	}
	/**
	 * 获取：情报类型
	 */
	public String getBusinesstypeid() {
		return businesstypeid;
	}
	/**
	 * 设置：文件类型
	 */
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	/**
	 * 获取：文件类型
	 */
	public String getFiletype() {
		return filetype;
	}
	/**
	 * 设置：查询数据开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：查询数据开始时间
	 */
	public Date getStartTime() {
		return startTime;
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
	 * 设置：抄送人们，多个抄送人ID用逗号隔开
	 */
	public void setNoticeBccs(String noticeBccs) {
		this.noticeBccs = noticeBccs;
	}
	/**
	 * 获取：抄送人们，多个抄送人ID用逗号隔开
	 */
	public String getNoticeBccs() {
		return noticeBccs;
	}
	/**
	 * 设置：是否精确匹配  0：否   1：是
	 */
	public void setIsExactMatching(Boolean isExactMatching) {
		this.isExactMatching = isExactMatching;
	}
	/**
	 * 获取：是否精确匹配  0：否   1：是
	 */
	public Boolean getIsExactMatching() {
		return isExactMatching;
	}
	/**
	 * 设置：状态  0：使用   1：禁用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态  0：使用   1：禁用
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：提醒频率，单位分钟
	 */
	public void setNoticeFrequency(String noticeFrequency) {
		this.noticeFrequency = noticeFrequency;
	}
	/**
	 * 获取：提醒频率，单位分钟
	 */
	public String getNoticeFrequency() {
		return noticeFrequency;
	}
	/**
	 * 设置：cron表达式
	 */
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	/**
	 * 获取：cron表达式
	 */
	public String getCronExpression() {
		return cronExpression;
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

	public String getBusinesstypename() {
		return businesstypename;
	}

	public void setBusinesstypename(String businesstypename) {
		this.businesstypename = businesstypename;
	}

	public String getFiletypename() {
		return filetypename;
	}

	public void setFiletypename(String filetypename) {
		this.filetypename = filetypename;
	}

	public String getCronFrequency() {
		return cronFrequency;
	}

	public void setCronFrequency(String cronFrequency) {
		this.cronFrequency = cronFrequency;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String toString(){
		return "关键字："+this.getKeywords()+",数据开始时间："+(new SimpleDateFormat("yyyy-MM-dd")).format(this.getStartTime())+",频率：每"+
				this.getCronFrequency()+"分钟搜索一次，情报类型："+this.getBusinesstypename()+
				"文件类型："+this.getFiletypename();
	}
}
