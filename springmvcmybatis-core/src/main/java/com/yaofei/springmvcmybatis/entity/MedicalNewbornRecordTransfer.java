package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;

import java.util.Date;

/**
 * 新生儿出生信息ZQH-22-113600005 传输
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-16 13:24:41
 */
public class MedicalNewbornRecordTransfer extends BaseEntity {
	private static final long serialVersionUID = 1L;

	//主键，自增ID
	private Long id;
	//信息编号主键
	private Long XXZJBH;
	//行政区划编号
	private Long areaId;
	//情报业务分类ID
	private Long businessTypeId;
	//文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）
	private Integer fileType;
	//详情页面url
	private String detailsUrl;
	//收集时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date collectTime;
	//插入es的时候用的es的索引名称
	private String esIndexName;
	//所属用户编号
	private Long userId;
	//姓名
	private String XM;
	//性别
	private String XB;
	//性别描述
	private String XB_DMMS;
	//出生日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date CSRQ;
	//身份证号码
	private String GMSFZH;
	//接生机构名称
	private String JSJGMC;
	//家庭地址
	private String JTZZ_DZMC;
	//信息登记时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date XXDJSJ;
	//母亲姓名
	private String MQ_XM;
	//母亲民族
	private String MQ_MZ;
	//母亲民族描述
	private String MQ_MZ_DMMS;
	//母亲身份证号
	private String MQ_GMSFZH;
	//母亲联系电话
	private String MQ_LXDH;
	//父亲姓名
	private String FQ_XM;
	//父亲民族
	private String FQ_MZ;
	//父亲民族描述
	private String FQ_MZ_DMMS;
	//父亲身份证号
	private String FQ_GMSFZH;
	//父亲联系电话
	private String FQ_LXDH;
	//备注
	private String BZ;
	//删除状态  0：正常   1：已删除
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


	public Long getXXZJBH() {
		return XXZJBH;
	}

	public void setXXZJBH(Long XXZJBH) {
		this.XXZJBH = XXZJBH;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getXM() {
		return XM;
	}

	public void setXM(String XM) {
		this.XM = XM;
	}

	public String getXB() {
		return XB;
	}

	public void setXB(String XB) {
		this.XB = XB;
	}

	public String getXB_DMMS() {
		return XB_DMMS;
	}

	public void setXB_DMMS(String XB_DMMS) {
		this.XB_DMMS = XB_DMMS;
	}

	public Date getCSRQ() {
		return CSRQ;
	}

	public void setCSRQ(Date CSRQ) {
		this.CSRQ = CSRQ;
	}

	public String getGMSFZH() {
		return GMSFZH;
	}

	public void setGMSFZH(String GMSFZH) {
		this.GMSFZH = GMSFZH;
	}

	public String getJSJGMC() {
		return JSJGMC;
	}

	public void setJSJGMC(String JSJGMC) {
		this.JSJGMC = JSJGMC;
	}

	public String getJTZZ_DZMC() {
		return JTZZ_DZMC;
	}

	public void setJTZZ_DZMC(String JTZZ_DZMC) {
		this.JTZZ_DZMC = JTZZ_DZMC;
	}

	public Date getXXDJSJ() {
		return XXDJSJ;
	}

	public void setXXDJSJ(Date XXDJSJ) {
		this.XXDJSJ = XXDJSJ;
	}

	public String getMQ_XM() {
		return MQ_XM;
	}

	public void setMQ_XM(String MQ_XM) {
		this.MQ_XM = MQ_XM;
	}

	public String getMQ_MZ() {
		return MQ_MZ;
	}

	public void setMQ_MZ(String MQ_MZ) {
		this.MQ_MZ = MQ_MZ;
	}

	public String getMQ_MZ_DMMS() {
		return MQ_MZ_DMMS;
	}

	public void setMQ_MZ_DMMS(String MQ_MZ_DMMS) {
		this.MQ_MZ_DMMS = MQ_MZ_DMMS;
	}

	public String getMQ_GMSFZH() {
		return MQ_GMSFZH;
	}

	public void setMQ_GMSFZH(String MQ_GMSFZH) {
		this.MQ_GMSFZH = MQ_GMSFZH;
	}

	public String getMQ_LXDH() {
		return MQ_LXDH;
	}

	public void setMQ_LXDH(String MQ_LXDH) {
		this.MQ_LXDH = MQ_LXDH;
	}

	public String getFQ_XM() {
		return FQ_XM;
	}

	public void setFQ_XM(String FQ_XM) {
		this.FQ_XM = FQ_XM;
	}

	public String getFQ_MZ() {
		return FQ_MZ;
	}

	public void setFQ_MZ(String FQ_MZ) {
		this.FQ_MZ = FQ_MZ;
	}

	public String getFQ_MZ_DMMS() {
		return FQ_MZ_DMMS;
	}

	public void setFQ_MZ_DMMS(String FQ_MZ_DMMS) {
		this.FQ_MZ_DMMS = FQ_MZ_DMMS;
	}

	public String getFQ_GMSFZH() {
		return FQ_GMSFZH;
	}

	public void setFQ_GMSFZH(String FQ_GMSFZH) {
		this.FQ_GMSFZH = FQ_GMSFZH;
	}

	public String getFQ_LXDH() {
		return FQ_LXDH;
	}

	public void setFQ_LXDH(String FQ_LXDH) {
		this.FQ_LXDH = FQ_LXDH;
	}

	public String getBZ() {
		return BZ;
	}

	public void setBZ(String BZ) {
		this.BZ = BZ;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEsIndexName() {
		return esIndexName;
	}

	public void setEsIndexName(String esIndexName) {
		this.esIndexName = esIndexName;
	}

	public Date getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

	public String getDetailsUrl() {
		return detailsUrl;
	}

	public void setDetailsUrl(String detailsUrl) {
		this.detailsUrl = detailsUrl;
	}

	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getBusinessTypeId() {
		return businessTypeId;
	}

	public void setBusinessTypeId(Long businessTypeId) {
		this.businessTypeId = businessTypeId;
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

	private Date collectTimeBegin;
	private Date collectTimeEnd;

	//医院名字
	private String HospitalName;

	public Date getCollectTimeBegin() {
		return collectTimeBegin;
	}

	public void setCollectTimeBegin(Date collectTimeBegin) {
		this.collectTimeBegin = collectTimeBegin;
	}

	public Date getCollectTimeEnd() {
		return collectTimeEnd;
	}

	public void setCollectTimeEnd(Date collectTimeEnd) {
		this.collectTimeEnd = collectTimeEnd;
	}

	public String getHospitalName() {
		return HospitalName;
	}

	public void setHospitalName(String hospitalName) {
		HospitalName = hospitalName;
	}

	@Override
	public String toString() {
		return ", 新生儿姓名='" + XM + '\'' +
				", 新生儿性别='" + XB + '\'' +
				", 性别详情='" + XB_DMMS + '\'' +
				", 出生日期='" + DateTimeUtil.formatDateTime(CSRQ)  + '\'' +
				", 身份证='" + GMSFZH + '\'' +
				", 接生机构='" + JSJGMC + '\'' +
				", 家庭地址='" + JTZZ_DZMC + '\'' +
				", 信息登记时间='" + DateTimeUtil.formatDateTime(XXDJSJ)  + '\'' +
				", 母亲姓名='" + MQ_XM + '\'' +
				", 母亲民族='" + MQ_XM + '\'' +
				", 母亲民族详情='" + MQ_MZ_DMMS + '\'' +
				", 母亲身份证号码='" + MQ_GMSFZH + '\'' +
				", 母亲电话号码='" + MQ_LXDH + '\'' +
				", 父亲电话号码='" + FQ_XM + '\'' +
				", 父亲民族='" + FQ_MZ + '\'' +
				", 父亲民族详情='" + FQ_MZ_DMMS + '\'' +
				", 父亲身份证号码='" + FQ_GMSFZH + '\'' +
				", 父亲电话号码='" + FQ_LXDH + '\'' +
				", 备注='" + BZ + '\'' +
				", 医院名称='" + HospitalName + '\'';
	}
}
