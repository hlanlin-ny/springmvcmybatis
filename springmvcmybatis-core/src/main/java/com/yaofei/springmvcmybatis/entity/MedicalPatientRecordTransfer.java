package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;

import java.util.Date;


/**
 * 医疗机构患者信息 传输
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-16 11:39:46
 */
public class MedicalPatientRecordTransfer extends BaseEntity {
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
	//医院编号
	private String YYBH;
	//姓名
	private String HZ_XM;
	//姓名拼音
	private String HZ_XMHYPY;
	//性别
	private String HZ_XB;
	//性别代码1 - 男性2 - 女性
	private String HZ_XBDM;
	//出生日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date HZ_CSRQ;
	//患者_常用证件代码
	private  String HZ_CYZJDM;
	//患者_常用证件名称
	private  String HZ_CYZJMC;
	//身份证号码
	private String HZ_ZJHM;
	//家庭地址
	private String HZ_XZZ_DZMC;
	//联系电话
	private String HZ_LXDH;
	//联系人
	private String LXR_XM;
	//联系人姓名拼音
	private String LXR_XMHYPY;
	//常用证件代码
	private String LXR_CYZJDM;
	//常用证件名称
	private String LXR_CYZJMC;
	//常用证件号码
	private String LXR_ZJHM;
	//联系人现居地址
	private String LXR_XZZ_DZMC;
	//联系电话
	private String LXR_LXDH;
	//与患者的关系
	private String LXR_YHZGX_JYQK;
	//医院单位名称
	private String YY_DWMC;
	private String yyDwmc;
	//血型
	private String XX;
	//血型代码
	private String XXDM;
	//住院原因
	private String ZYYY_JYQK;
	//住院日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date ZYRQ;
	//出院时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date CYRQ;
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

	public String getYYBH() {
		return YYBH;
	}

	public void setYYBH(String YYBH) {
		this.YYBH = YYBH;
	}

	public String getHZ_XM() {
		return HZ_XM;
	}

	public void setHZ_XM(String HZ_XM) {
		this.HZ_XM = HZ_XM;
	}

	public String getHZ_XMHYPY() {
		return HZ_XMHYPY;
	}

	public void setHZ_XMHYPY(String HZ_XMHYPY) {
		this.HZ_XMHYPY = HZ_XMHYPY;
	}

	public String getHZ_XB() {
		return HZ_XB;
	}

	public void setHZ_XB(String HZ_XB) {
		this.HZ_XB = HZ_XB;
	}

	public String getHZ_XBDM() {
		return HZ_XBDM;
	}

	public void setHZ_XBDM(String HZ_XBDM) {
		this.HZ_XBDM = HZ_XBDM;
	}

	public Date getHZ_CSRQ() {
		return HZ_CSRQ;
	}

	public void setHZ_CSRQ(Date HZ_CSRQ) {
		this.HZ_CSRQ = HZ_CSRQ;
	}

	public String getHZ_CYZJDM() {
		return HZ_CYZJDM;
	}

	public void setHZ_CYZJDM(String HZ_CYZJDM) {
		this.HZ_CYZJDM = HZ_CYZJDM;
	}

	public String getHZ_CYZJMC() {
		return HZ_CYZJMC;
	}

	public void setHZ_CYZJMC(String HZ_CYZJMC) {
		this.HZ_CYZJMC = HZ_CYZJMC;
	}

	public String getHZ_ZJHM() {
		return HZ_ZJHM;
	}

	public void setHZ_ZJHM(String HZ_ZJHM) {
		this.HZ_ZJHM = HZ_ZJHM;
	}

	public String getHZ_XZZ_DZMC() {
		return HZ_XZZ_DZMC;
	}

	public void setHZ_XZZ_DZMC(String HZ_XZZ_DZMC) {
		this.HZ_XZZ_DZMC = HZ_XZZ_DZMC;
	}

	public String getHZ_LXDH() {
		return HZ_LXDH;
	}

	public void setHZ_LXDH(String HZ_LXDH) {
		this.HZ_LXDH = HZ_LXDH;
	}

	public String getLXR_XM() {
		return LXR_XM;
	}

	public void setLXR_XM(String LXR_XM) {
		this.LXR_XM = LXR_XM;
	}

	public String getLXR_XMHYPY() {
		return LXR_XMHYPY;
	}

	public void setLXR_XMHYPY(String LXR_XMHYPY) {
		this.LXR_XMHYPY = LXR_XMHYPY;
	}

	public String getLXR_CYZJDM() {
		return LXR_CYZJDM;
	}

	public void setLXR_CYZJDM(String LXR_CYZJDM) {
		this.LXR_CYZJDM = LXR_CYZJDM;
	}

	public String getLXR_CYZJMC() {
		return LXR_CYZJMC;
	}

	public void setLXR_CYZJMC(String LXR_CYZJMC) {
		this.LXR_CYZJMC = LXR_CYZJMC;
	}

	public String getLXR_ZJHM() {
		return LXR_ZJHM;
	}

	public void setLXR_ZJHM(String LXR_ZJHM) {
		this.LXR_ZJHM = LXR_ZJHM;
	}

	public String getLXR_XZZ_DZMC() {
		return LXR_XZZ_DZMC;
	}

	public void setLXR_XZZ_DZMC(String LXR_XZZ_DZMC) {
		this.LXR_XZZ_DZMC = LXR_XZZ_DZMC;
	}

	public String getLXR_LXDH() {
		return LXR_LXDH;
	}

	public void setLXR_LXDH(String LXR_LXDH) {
		this.LXR_LXDH = LXR_LXDH;
	}

	public String getLXR_YHZGX_JYQK() {
		return LXR_YHZGX_JYQK;
	}

	public void setLXR_YHZGX_JYQK(String LXR_YHZGX_JYQK) {
		this.LXR_YHZGX_JYQK = LXR_YHZGX_JYQK;
	}

	public String getYY_DWMC() {
		return YY_DWMC;
	}

	public void setYY_DWMC(String YY_DWMC) {
		this.YY_DWMC = YY_DWMC;
	}

	public String getXX() {
		return XX;
	}

	public void setXX(String XX) {
		this.XX = XX;
	}

	public String getXXDM() {
		return XXDM;
	}

	public void setXXDM(String XXDM) {
		this.XXDM = XXDM;
	}

	public String getZYYY_JYQK() {
		return ZYYY_JYQK;
	}

	public void setZYYY_JYQK(String ZYYY_JYQK) {
		this.ZYYY_JYQK = ZYYY_JYQK;
	}

	public Date getZYRQ() {
		return ZYRQ;
	}

	public void setZYRQ(Date ZYRQ) {
		this.ZYRQ = ZYRQ;
	}

	public Date getCYRQ() {
		return CYRQ;
	}

	public void setCYRQ(Date CYRQ) {
		this.CYRQ = CYRQ;
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

	public void setHospitalName(String hospitalName) {
		HospitalName = hospitalName;
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

	public String getYyDwmc() {
		return yyDwmc;
	}

	public void setYyDwmc(String yyDwmc) {
		this.yyDwmc = yyDwmc;
	}

	@Override
	public String toString() {
		return "姓名='" + HZ_XM + '\'' +
				", 性别='" + HZ_XB + '\'' +
				", 出生日期='" + DateTimeUtil.formatDateTime(HZ_CSRQ)  + '\'' +
				", 身份证号码='" + HZ_ZJHM + '\'' +
				", 家庭地址='" + HZ_XZZ_DZMC + '\'' +
				", 联系电话='" + HZ_LXDH + '\'' +
				", 联系人='" + LXR_XM + '\'' +
				", 常用证件号码='" + LXR_ZJHM + '\'' +
				", 联系人现居地址	='" + LXR_XZZ_DZMC + '\'' +
				", 联系电话='" + LXR_LXDH + '\'' +
				", 与患者的关系='" + LXR_YHZGX_JYQK + '\'' +
				", 血型='" + XX + '\'' +
				", 住院原因='" + ZYYY_JYQK + '\'' +
				", 住院日期='" + DateTimeUtil.formatDateTime(ZYRQ)  + '\'' +
				", 出院时间='" + DateTimeUtil.formatDateTime(CYRQ)  + '\'' +
				", 医院单位名称='" + YY_DWMC + '\'' +
				", 备注='" + BZ + '\'' ;
	}
}
