package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 医保刷卡记录信息ZQH-22-143600002 传输
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-16 11:41:03
 */
public class MedicalInsuranceCardRecordTransfer extends BaseEntity {
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
	//医疗类型
	private String YLLB;
	//医疗类型代码
	private String YLLBDM;
	//医疗费用金额
	private BigDecimal YLF_JE;
	//住院时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date RYRQ;
	//出院时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date CYRQ;
	//入院疾病
	private String RYJB_JYQK;
	//确诊疾病
	private String QZJB_JYQK;
	//并发症简要情况
	private String BFZ_JYQK;
	//出院原因
	private String CYYY_JYQK;
	//医生姓名
	private String YS_XM;
	//住院号
	private String ZYH;
	//住院科室
	private String KS_DWMC;
	//办理日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date BLRQ;
	//经办人姓名
	private String JBR_XM;
	//医院编号
	private String YYBH;
	//个人编号
	private String GRBH;
	//单位编号
	private String DWBH;
	//报销标志
	private String BXBZ;
	//报销标志_简要情况
	private String BXBZ_JYQK;
	//结算状态
	private String JSZT;
	//结算状态_简要情况
	private String JSZT_JYQK;
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

	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public String getDetailsUrl() {
		return detailsUrl;
	}

	public void setDetailsUrl(String detailsUrl) {
		this.detailsUrl = detailsUrl;
	}

	public Date getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

	public String getEsIndexName() {
		return esIndexName;
	}

	public void setEsIndexName(String esIndexName) {
		this.esIndexName = esIndexName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getYLLB() {
		return YLLB;
	}

	public void setYLLB(String YLLB) {
		this.YLLB = YLLB;
	}

	public String getYLLBDM() {
		return YLLBDM;
	}

	public void setYLLBDM(String YLLBDM) {
		this.YLLBDM = YLLBDM;
	}

	public BigDecimal getYLF_JE() {
		return YLF_JE;
	}

	public void setYLF_JE(BigDecimal YLF_JE) {
		this.YLF_JE = YLF_JE;
	}

	public Date getRYRQ() {
		return RYRQ;
	}

	public void setRYRQ(Date RYRQ) {
		this.RYRQ = RYRQ;
	}

	public Date getCYRQ() {
		return CYRQ;
	}

	public void setCYRQ(Date CYRQ) {
		this.CYRQ = CYRQ;
	}

	public String getRYJB_JYQK() {
		return RYJB_JYQK;
	}

	public void setRYJB_JYQK(String RYJB_JYQK) {
		this.RYJB_JYQK = RYJB_JYQK;
	}

	public String getQZJB_JYQK() {
		return QZJB_JYQK;
	}

	public void setQZJB_JYQK(String QZJB_JYQK) {
		this.QZJB_JYQK = QZJB_JYQK;
	}

	public String getBFZ_JYQK() {
		return BFZ_JYQK;
	}

	public void setBFZ_JYQK(String BFZ_JYQK) {
		this.BFZ_JYQK = BFZ_JYQK;
	}

	public String getCYYY_JYQK() {
		return CYYY_JYQK;
	}

	public void setCYYY_JYQK(String CYYY_JYQK) {
		this.CYYY_JYQK = CYYY_JYQK;
	}

	public String getYS_XM() {
		return YS_XM;
	}

	public void setYS_XM(String YS_XM) {
		this.YS_XM = YS_XM;
	}

	public String getZYH() {
		return ZYH;
	}

	public void setZYH(String ZYH) {
		this.ZYH = ZYH;
	}

	public String getKS_DWMC() {
		return KS_DWMC;
	}

	public void setKS_DWMC(String KS_DWMC) {
		this.KS_DWMC = KS_DWMC;
	}

	public Date getBLRQ() {
		return BLRQ;
	}

	public void setBLRQ(Date BLRQ) {
		this.BLRQ = BLRQ;
	}

	public String getJBR_XM() {
		return JBR_XM;
	}

	public void setJBR_XM(String JBR_XM) {
		this.JBR_XM = JBR_XM;
	}

	public String getYYBH() {
		return YYBH;
	}

	public void setYYBH(String YYBH) {
		this.YYBH = YYBH;
	}

	public String getGRBH() {
		return GRBH;
	}

	public void setGRBH(String GRBH) {
		this.GRBH = GRBH;
	}

	public String getDWBH() {
		return DWBH;
	}

	public void setDWBH(String DWBH) {
		this.DWBH = DWBH;
	}

	public String getBXBZ() {
		return BXBZ;
	}

	public void setBXBZ(String BXBZ) {
		this.BXBZ = BXBZ;
	}

	public String getBXBZ_JYQK() {
		return BXBZ_JYQK;
	}

	public void setBXBZ_JYQK(String BXBZ_JYQK) {
		this.BXBZ_JYQK = BXBZ_JYQK;
	}

	public String getJSZT() {
		return JSZT;
	}

	public void setJSZT(String JSZT) {
		this.JSZT = JSZT;
	}

	public String getJSZT_JYQK() {
		return JSZT_JYQK;
	}

	public void setJSZT_JYQK(String JSZT_JYQK) {
		this.JSZT_JYQK = JSZT_JYQK;
	}

	public String getBZ() {
		return BZ;
	}

	public void setBZ(String BZ) {
		this.BZ = BZ;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedIp() {
		return createdIp;
	}

	public void setCreatedIp(String createdIp) {
		this.createdIp = createdIp;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	public String getModificationBy() {
		return modificationBy;
	}

	public void setModificationBy(String modificationBy) {
		this.modificationBy = modificationBy;
	}

	public String getModificationIp() {
		return modificationIp;
	}

	public void setModificationIp(String modificationIp) {
		this.modificationIp = modificationIp;
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

	public void setHospitalName(String HospitalName) {
		this.HospitalName = HospitalName;
	}

	@Override
	public String toString() {
		return  "医疗类型='" + YLLB + '\'' +
				", 医疗类型代码='" + YLLBDM + '\'' +
				", 医疗费用金额=" + YLF_JE +
				", 住院时间='" + DateTimeUtil.formatDateTime(RYRQ)  + '\'' +
				", 出院时间='" + DateTimeUtil.formatDateTime(CYRQ)  + '\'' +
				", 入院疾病='" + RYJB_JYQK + '\'' +
				", 确诊疾病='" + QZJB_JYQK + '\'' +
				", 并发症简要情况='" + BFZ_JYQK + '\'' +
				", 出院原因='" + CYYY_JYQK + '\'' +
				", 医生_姓名='" + YS_XM + '\'' +
				", 住院号='" + ZYH + '\'' +
				", 科室_单位名称='" + KS_DWMC + '\'' +
				", 办理日期='" + DateTimeUtil.formatDateTime(BLRQ)  + '\'' +
				", 经办人_姓名='" + JBR_XM + '\'' +
				", 医院编号='" + YYBH + '\'' +
				", 个人编号='" + GRBH + '\'' +
				", 单位编号='" + DWBH + '\'' +
				", 报销标志='" + BXBZ + '\'' +
				", 报销标志_简要情况='" + BXBZ_JYQK + '\'' +
				", 结算状态='" + JSZT + '\'' +
				", 结算状态_简要情况='" + JSZT_JYQK + '\'' +
				", 备注='" + BZ + '\'' +
				", 医院名称='" + HospitalName + '\'' ;
	}
}
