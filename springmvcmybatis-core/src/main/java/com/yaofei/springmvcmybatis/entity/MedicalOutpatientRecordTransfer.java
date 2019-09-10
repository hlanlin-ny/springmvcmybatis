package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 医疗门诊信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:38:46
 */
public class MedicalOutpatientRecordTransfer extends BaseEntity {
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
	//医院单位名称
	private String YY_DWMC;
	private String yyDwmc;
	//就诊时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date diagnoseDatetime;
	//门诊号
	private String diagnoseNo;
	//科室名称
	private String diagnoseDepartment;
	//人员费用类别（自费、医保（城镇医保、农村医保）等）
	private String costType;
	//人员类别代码
	private String RYLBDM;
	//医保证号（含城镇医保、农村医保、费医保病人填就诊卡卡号（自费人员、外地人员））
	private String medicareCardNo;
	//医院诊断结果
	private String diagnoseResult;
	//费用金额
	private BigDecimal cost;
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
	 * 获取：情报业务分类ID
	 */
	public Long getBusinessTypeId() {
		return businessTypeId;
	}
	/**
	 * 设置：文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）
	 */
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取：文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）
	 */
	public Integer getFileType() {
		return fileType;
	}
	/**
	 * 设置：详情页面url
	 */
	public void setDetailsUrl(String detailsUrl) {
		this.detailsUrl = detailsUrl;
	}
	/**
	 * 获取：详情页面url
	 */
	public String getDetailsUrl() {
		return detailsUrl;
	}
	/**
	 * 设置：收集时间
	 */
	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}
	/**
	 * 获取：收集时间
	 */
	public Date getCollectTime() {
		return collectTime;
	}
	/**
	 * 设置：插入es的时候用的es的索引名称
	 */
	public void setEsIndexName(String esIndexName) {
		this.esIndexName = esIndexName;
	}
	/**
	 * 获取：插入es的时候用的es的索引名称
	 */
	public String getEsIndexName() {
		return esIndexName;
	}
	/**
	 * 设置：所属用户编号
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：所属用户编号
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}

	public Long getXXZJBH() {
		return XXZJBH;
	}

	public void setXXZJBH(Long XXZJBH) {
		this.XXZJBH = XXZJBH;
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

	public String getYY_DWMC() {
		return YY_DWMC;
	}

	public void setYY_DWMC(String YY_DWMC) {
		this.YY_DWMC = YY_DWMC;
	}

	public Date getDiagnoseDatetime() {
		return diagnoseDatetime;
	}

	public void setDiagnoseDatetime(Date diagnoseDatetime) {
		this.diagnoseDatetime = diagnoseDatetime;
	}

	public String getDiagnoseNo() {
		return diagnoseNo;
	}

	public void setDiagnoseNo(String diagnoseNo) {
		this.diagnoseNo = diagnoseNo;
	}

	public String getDiagnoseDepartment() {
		return diagnoseDepartment;
	}

	public void setDiagnoseDepartment(String diagnoseDepartment) {
		this.diagnoseDepartment = diagnoseDepartment;
	}

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

	public String getRYLBDM() {
		return RYLBDM;
	}

	public void setRYLBDM(String RYLBDM) {
		this.RYLBDM = RYLBDM;
	}

	public String getMedicareCardNo() {
		return medicareCardNo;
	}

	public void setMedicareCardNo(String medicareCardNo) {
		this.medicareCardNo = medicareCardNo;
	}

	public String getDiagnoseResult() {
		return diagnoseResult;
	}

	public void setDiagnoseResult(String diagnoseResult) {
		this.diagnoseResult = diagnoseResult;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getBZ() {
		return BZ;
	}

	public void setBZ(String BZ) {
		this.BZ = BZ;
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

	public String getYyDwmc() {
		return yyDwmc;
	}

	public void setYyDwmc(String yyDwmc) {
		this.yyDwmc = yyDwmc;
	}

	@Override
	public String toString() {
		return "  门诊人员姓名='" + name + '\'' +
				", 门诊人员姓名拼音='" + XMHYPY + '\'' +
				", 门诊人员性别='" + XB + '\'' +
				", 门诊人员出生日期=" + CSRQ +
				", 门诊人员年龄=" + NL +
				", 门诊人员身份证号='" + idCardNo + '\'' +
				", 门诊人员手机号='" + phone + '\'' +
				", 门诊人员住址='" + address + '\'' +
				", 门诊人员职业='" + profession + '\'' +
				", 门诊人员单位名称='" + workUnit + '\'' +
				", 医院名称='" + HospitalName + '\''+
				", 医院单位名称='" + YY_DWMC + '\'' +
				", 门诊时间=" + DateTimeUtil.formatDateTime(diagnoseDatetime) +
				", 门诊号='" + diagnoseNo + '\'' +
				", 门诊科室='" + diagnoseDepartment + '\'' +
				", 费用类型='" + costType + '\'' +
				", 医保证号='" + medicareCardNo + '\'' +
				", 门诊结果='" + diagnoseResult + '\'' +
				", 费用=" + cost +
				", 备注='" + BZ + '\'';

	}
}
