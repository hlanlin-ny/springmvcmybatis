package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 医疗住（出）院信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:39:28
 */
public class MedicalCheckinCheckoutRecordTransfer extends BaseEntity {
	private static final long serialVersionUID = 1L;

	//主键，自增ID
	private Long id;
	//信息主键编号
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
	private String name;
	//姓名拼音
	private String XMHYPY;
	//性别
	private String XB;
	//性别代码
	private String XBDM;
	//出生日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date CSRQ;
	//年龄
	private Integer NL;
	//身份证号码
	private String idCardNo;
	//联系电话
	private String phone;
	//家庭地址
	private String address;
	//职业
	private String profession;
	//工作单位
	private String workUnit;
	//户主姓名
	private String HZ_XM;
	//家庭人口数
	private Integer JTRK_RS;
	//家庭类别
	private String JTLBDM;
	//家庭类型代码
	private String JTLB;
	//医院单位名称
	private String yyDwmc;
	private String YY_DWMC;
	//医保证号
	private String YBZ_ZJHM;
	//住院号
	private String hospitalizationNo;
	//住院科室
	private String hospitalizationDepartment;
	//床号
	private String CH;
	//入院途径
	private String RYTJ_JYQK;
	//医生名字
	private String YS_XM;
	//入院诊断
	private String RYZD_JYQK;
	//出院诊断
	private String CYZD_JYQK;
	//救助对象
	private String JZDX_PDBZ;
	//救助对象类别
	private String JZDXLB;
	//救助金额
	private BigDecimal JZJ_JE;
	//经办人姓名
	private String JBR_XM;
	//住院时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date hospitalizationDatetime;
	//出院时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date leavehospitalDatetime;
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
	 * 设置：行政区划编号
	 */
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：行政区划编号
	 */
	public Long getAreaId() {
		return areaId;
	}
	/**
	 * 设置：情报业务分类ID
	 */
	public void setBusinessTypeId(Long businessTypeId) {
		this.businessTypeId = businessTypeId;
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

	public void setHospitalName(String HospitalName) {
		this.HospitalName = HospitalName;
	}

	public Long getXXZJBH() {
		return XXZJBH;
	}

	public void setXXZJBH(Long XXZJBH) {
		this.XXZJBH = XXZJBH;
	}

	public Long getBusinessTypeId() {
		return businessTypeId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getXMHYPY() {
		return XMHYPY;
	}

	public void setXMHYPY(String XMHYPY) {
		this.XMHYPY = XMHYPY;
	}

	public String getXB() {
		return XB;
	}

	public void setXB(String XB) {
		this.XB = XB;
	}

	public String getXBDM() {
		return XBDM;
	}

	public void setXBDM(String XBDM) {
		this.XBDM = XBDM;
	}

	public Date getCSRQ() {
		return CSRQ;
	}

	public void setCSRQ(Date CSRQ) {
		this.CSRQ = CSRQ;
	}

	public Integer getNL() {
		return NL;
	}

	public void setNL(Integer NL) {
		this.NL = NL;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getHZ_XM() {
		return HZ_XM;
	}

	public void setHZ_XM(String HZ_XM) {
		this.HZ_XM = HZ_XM;
	}

	public Integer getJTRK_RS() {
		return JTRK_RS;
	}

	public void setJTRK_RS(Integer JTRK_RS) {
		this.JTRK_RS = JTRK_RS;
	}

	public String getJTLBDM() {
		return JTLBDM;
	}

	public void setJTLBDM(String JTLBDM) {
		this.JTLBDM = JTLBDM;
	}

	public String getJTLB() {
		return JTLB;
	}

	public void setJTLB(String JTLB) {
		this.JTLB = JTLB;
	}

	public String getYY_DWMC() {
		return YY_DWMC;
	}

	public void setYY_DWMC(String YY_DWMC) {
		this.YY_DWMC = YY_DWMC;
	}

	public String getYBZ_ZJHM() {
		return YBZ_ZJHM;
	}

	public void setYBZ_ZJHM(String YBZ_ZJHM) {
		this.YBZ_ZJHM = YBZ_ZJHM;
	}

	public String getHospitalizationNo() {
		return hospitalizationNo;
	}

	public void setHospitalizationNo(String hospitalizationNo) {
		this.hospitalizationNo = hospitalizationNo;
	}

	public String getHospitalizationDepartment() {
		return hospitalizationDepartment;
	}

	public void setHospitalizationDepartment(String hospitalizationDepartment) {
		this.hospitalizationDepartment = hospitalizationDepartment;
	}

	public String getCH() {
		return CH;
	}

	public void setCH(String CH) {
		this.CH = CH;
	}

	public String getRYTJ_JYQK() {
		return RYTJ_JYQK;
	}

	public void setRYTJ_JYQK(String RYTJ_JYQK) {
		this.RYTJ_JYQK = RYTJ_JYQK;
	}

	public String getYS_XM() {
		return YS_XM;
	}

	public void setYS_XM(String YS_XM) {
		this.YS_XM = YS_XM;
	}

	public String getRYZD_JYQK() {
		return RYZD_JYQK;
	}

	public void setRYZD_JYQK(String RYZD_JYQK) {
		this.RYZD_JYQK = RYZD_JYQK;
	}

	public String getCYZD_JYQK() {
		return CYZD_JYQK;
	}

	public void setCYZD_JYQK(String CYZD_JYQK) {
		this.CYZD_JYQK = CYZD_JYQK;
	}

	public String getJZDX_PDBZ() {
		return JZDX_PDBZ;
	}

	public void setJZDX_PDBZ(String JZDX_PDBZ) {
		this.JZDX_PDBZ = JZDX_PDBZ;
	}

	public String getJZDXLB() {
		return JZDXLB;
	}

	public void setJZDXLB(String JZDXLB) {
		this.JZDXLB = JZDXLB;
	}

	public BigDecimal getJZJ_JE() {
		return JZJ_JE;
	}

	public void setJZJ_JE(BigDecimal JZJ_JE) {
		this.JZJ_JE = JZJ_JE;
	}

	public String getJBR_XM() {
		return JBR_XM;
	}

	public void setJBR_XM(String JBR_XM) {
		this.JBR_XM = JBR_XM;
	}

	public Date getHospitalizationDatetime() {
		return hospitalizationDatetime;
	}

	public void setHospitalizationDatetime(Date hospitalizationDatetime) {
		this.hospitalizationDatetime = hospitalizationDatetime;
	}

	public Date getLeavehospitalDatetime() {
		return leavehospitalDatetime;
	}

	public void setLeavehospitalDatetime(Date leavehospitalDatetime) {
		this.leavehospitalDatetime = leavehospitalDatetime;
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

	public String getYyDwmc() {
		return yyDwmc;
	}

	public void setYyDwmc(String yyDwmc) {
		this.yyDwmc = yyDwmc;
	}

	@Override
	public String toString() {
		return    "医疗人员姓名='" + name + '\'' +
				", 医疗人员身份证='" + idCardNo + '\'' +
				", 医疗人员手机号='" + phone + '\'' +
				", 医疗人员姓名拼音='" + XMHYPY + '\'' +
				", 医疗人员性别='" + XB + '\'' +
				", 医疗人员出生日期=" + CSRQ +
				", 医疗人员年龄=" + NL +
				", 家庭住址='" + address + '\'' +
				", 工作职位='" + profession + '\'' +
				", 工作单位='" + workUnit + '\'' +
				", 医院名称='" + HospitalName + '\'' +
				", 医院单位名称='" + YY_DWMC + '\'' +
				", 户主姓名='" + HZ_XM + '\'' +
				", 家庭人口数='" + JTRK_RS + '\'' +
				", 医保证号='" + YBZ_ZJHM + '\'' +
				", 住院科室='" + hospitalizationDepartment + '\'' +
				", 床号='" + CH + '\'' +
				", 入院途径='" + RYTJ_JYQK + '\'' +
				", 医生名字='" + YS_XM + '\'' +
				", 入院诊断='" + RYTJ_JYQK + '\'' +
				", 出院诊断='" + CYZD_JYQK + '\'' +
				", 救助对象='" + JZDX_PDBZ + '\'' +
				", 救助对象金额='" + JZJ_JE + '\'' +
				", 救助对象类别='" + JZDXLB + '\'' +
				", 经办人='" + JBR_XM + '\'' +
				", 住院时间='" + DateTimeUtil.formatDateTime(hospitalizationDatetime)  + '\'' +
				", 出院时间='" + DateTimeUtil.formatDateTime(leavehospitalDatetime)  + '\'' +
				", 备注='" + BZ + '\'' +
				", 上报时间='" + DateTimeUtil.formatDateTime(collectTime)  + '\'';
	}
}