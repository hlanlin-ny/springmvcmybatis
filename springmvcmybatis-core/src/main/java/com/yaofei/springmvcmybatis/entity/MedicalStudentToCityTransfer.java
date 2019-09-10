package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 学生信息登记上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-06 16:18:01
 */
public class MedicalStudentToCityTransfer extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//信息主键编号
	private Long xxzjbh;
	//姓名
	private String xm;
	//姓名汉语拼音
	private String xmhypy;
	//性别
	private String xb;
	//性别代码
	private String xbdm;
	//民族代码
	private String mzdm;
	//民族
	private String mz;
	//出生日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date csrq;
	//离校日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date lxrq;
	//公民身份号码
	private String gmsfhm;
	//学制
	private String xz;
	//生源类别
	private String sylbJyqk;
	//出生地_地址名称
	private String csdDzmc;
	//家庭住址
	private String jtzzDzmc;
	//户籍类型代码
	private String hjlxdm;
	//户籍类型
	private String hjlx;
	//户籍地址名称
	private String hjdzDzmc;
	//学校类型代码
	private String xuexdm;
	//学校名称
	private String xxmc;
	//学号
	private String xuehao;
	//血型代码
	private String xxdm;
	//血型
	private String xx;
	//班号
	private String bh;
	//社会工作
	private String shgzJyqk;
	//专长
	private String zc;
	//政治面貌代码
	private String zzmmdm;
	//政治面貌
	private String zzmm;
	//入学日期
	private Date rxrq;
	//进校日期
	private Date jxrq;
	//入学方式
	private String rxfsJyqk;
	//特殊学生
	private String tsxsJyqk;
	//就读方式
	private String jdfsJyqk;
	//学段
	private String xd;
	//联系电话
	private String lxdh;
	//QQ_服务标识号
	private String qqFwbzh;
	//电子邮箱
	private String dzxx;
	//离校原因
	private String lxyyJyqk;
	//离校方向
	private String lxfxJyqk;
	//备注
	private String bz;
	//父亲_姓名
	private String fqXm;
	//父亲_姓名汉语拼音
	private String fqXmhypy;
	//父亲_常用证件代码
	private String fqCyzjdm;
	//父亲_常用证件名称
	private String fqCyzjmc;
	//父亲_证件号码
	private String fqZjhm;
	//父亲_出生日期
	private String fqCsrq;
	//父亲_婚姻状况代码
	private String fqHyzkdm;
	//父亲_婚姻状况
	private String fqHyzk;
	//父亲_职业
	private String fqZy;
	//父亲_职务名称
	private String fqZwmc;
	//父亲_政治面貌代码
	private String fqZzmmdm;
	//父亲_政治面貌
	private String fqZzmm;
	//父亲_工作单位
	private String fqFwcs;
	//父亲_联系电话
	private String fqLxdh;
	//父亲_关系
	private String fqGxJyqk;
	//父亲_QQ号码
	private String fqQqFwbzh;
	//父亲_电子邮箱
	private String fqDzxx;
	//母亲_姓名
	private String mqXm;
	//母亲_姓名汉语拼音
	private String mqXmhypy;
	//母亲_常用证件代码
	private String mqCyzjdm;
	//母亲_常用证件名称
	private String mqCyzjmc;
	//母亲_证件号码
	private String mqZjhm;
	//母亲_出生日期
	private String mqCsrq;
	//母亲_婚姻状况代码
	private String mqHyzkdm;
	//母亲_婚姻状况
	private String mqHyzk;
	//母亲_职业
	private String mqZy;
	//母亲_职务名称
	private String mqZwmc;
	//母亲_政治面貌代码
	private String mqZzmmdm;
	//母亲_政治面貌
	private String mqZzmm;
	//母亲_工作单位
	private String mqFwcs;
	//母亲_联系电话
	private String mqLxdh;
	//母亲_关系
	private String mqGxJyqk;
	//母亲_QQ号码
	private String mqQqFwbzh;
	//母亲_电子邮箱
	private String mqDzxx;
	//备注2
	private String bz2;
	//导入时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date drsj;
	//导入外键批次号
	private String drfk;
	//导入主题描述
	private String drztms;
	//登记时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date djsj;
	//登记单位代码
	private String djdwGajgjgdm;
	//登记单位_公安机关名称
	private String djdwGajgmc;
	//登记人_姓名
	private String djrXm;
	//登记人_公民身份号码
	private String djrGmsfhm;
	//登记人_联系电话
	private String djrLxdh;
	//信息来源区划
	private String xxlyXzqhdm;
	//首次_信息入库时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date scXxrksj;
	//信息入库时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date xxrksj;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：信息主键编号
	 */
	public void setXxzjbh(Long xxzjbh) {
		this.xxzjbh = xxzjbh;
	}
	/**
	 * 获取：信息主键编号
	 */
	public Long getXxzjbh() {
		return xxzjbh;
	}
	/**
	 * 设置：姓名
	 */
	public void setXm(String xm) {
		this.xm = xm;
	}
	/**
	 * 获取：姓名
	 */
	public String getXm() {
		return xm;
	}
	/**
	 * 设置：姓名汉语拼音
	 */
	public void setXmhypy(String xmhypy) {
		this.xmhypy = xmhypy;
	}
	/**
	 * 获取：姓名汉语拼音
	 */
	public String getXmhypy() {
		return xmhypy;
	}
	/**
	 * 设置：性别
	 */
	public void setXb(String xb) {
		this.xb = xb;
	}
	/**
	 * 获取：性别
	 */
	public String getXb() {
		return xb;
	}
	/**
	 * 设置：性别代码
	 */
	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}
	/**
	 * 获取：性别代码
	 */
	public String getXbdm() {
		return xbdm;
	}
	/**
	 * 设置：民族代码
	 */
	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}
	/**
	 * 获取：民族代码
	 */
	public String getMzdm() {
		return mzdm;
	}
	/**
	 * 设置：民族
	 */
	public void setMz(String mz) {
		this.mz = mz;
	}
	/**
	 * 获取：民族
	 */
	public String getMz() {
		return mz;
	}
	/**
	 * 设置：出生日期
	 */
	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}
	/**
	 * 获取：出生日期
	 */
	public Date getCsrq() {
		return csrq;
	}
	/**
	 * 设置：离校日期
	 */
	public void setLxrq(Date lxrq) {
		this.lxrq = lxrq;
	}
	/**
	 * 获取：离校日期
	 */
	public Date getLxrq() {
		return lxrq;
	}
	/**
	 * 设置：公民身份号码
	 */
	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}
	/**
	 * 获取：公民身份号码
	 */
	public String getGmsfhm() {
		return gmsfhm;
	}
	/**
	 * 设置：学制
	 */
	public void setXz(String xz) {
		this.xz = xz;
	}
	/**
	 * 获取：学制
	 */
	public String getXz() {
		return xz;
	}
	/**
	 * 设置：生源类别
	 */
	public void setSylbJyqk(String sylbJyqk) {
		this.sylbJyqk = sylbJyqk;
	}
	/**
	 * 获取：生源类别
	 */
	public String getSylbJyqk() {
		return sylbJyqk;
	}
	/**
	 * 设置：出生地_地址名称
	 */
	public void setCsdDzmc(String csdDzmc) {
		this.csdDzmc = csdDzmc;
	}
	/**
	 * 获取：出生地_地址名称
	 */
	public String getCsdDzmc() {
		return csdDzmc;
	}
	/**
	 * 设置：家庭住址
	 */
	public void setJtzzDzmc(String jtzzDzmc) {
		this.jtzzDzmc = jtzzDzmc;
	}
	/**
	 * 获取：家庭住址
	 */
	public String getJtzzDzmc() {
		return jtzzDzmc;
	}
	/**
	 * 设置：户籍类型代码
	 */
	public void setHjlxdm(String hjlxdm) {
		this.hjlxdm = hjlxdm;
	}
	/**
	 * 获取：户籍类型代码
	 */
	public String getHjlxdm() {
		return hjlxdm;
	}
	/**
	 * 设置：户籍类型
	 */
	public void setHjlx(String hjlx) {
		this.hjlx = hjlx;
	}
	/**
	 * 获取：户籍类型
	 */
	public String getHjlx() {
		return hjlx;
	}
	/**
	 * 设置：户籍地址名称
	 */
	public void setHjdzDzmc(String hjdzDzmc) {
		this.hjdzDzmc = hjdzDzmc;
	}
	/**
	 * 获取：户籍地址名称
	 */
	public String getHjdzDzmc() {
		return hjdzDzmc;
	}
	/**
	 * 设置：学校类型代码
	 */
	public void setXuexdm(String xuexdm) {
		this.xuexdm = xuexdm;
	}
	/**
	 * 获取：学校类型代码
	 */
	public String getXuexdm() {
		return xuexdm;
	}
	/**
	 * 设置：学校名称
	 */
	public void setXxmc(String xxmc) {
		this.xxmc = xxmc;
	}
	/**
	 * 获取：学校名称
	 */
	public String getXxmc() {
		return xxmc;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：血型代码
	 */
	public void setXxdm(String xxdm) {
		this.xxdm = xxdm;
	}
	/**
	 * 获取：血型代码
	 */
	public String getXxdm() {
		return xxdm;
	}
	/**
	 * 设置：血型
	 */
	public void setXx(String xx) {
		this.xx = xx;
	}
	/**
	 * 获取：血型
	 */
	public String getXx() {
		return xx;
	}
	/**
	 * 设置：班号
	 */
	public void setBh(String bh) {
		this.bh = bh;
	}
	/**
	 * 获取：班号
	 */
	public String getBh() {
		return bh;
	}
	/**
	 * 设置：社会工作
	 */
	public void setShgzJyqk(String shgzJyqk) {
		this.shgzJyqk = shgzJyqk;
	}
	/**
	 * 获取：社会工作
	 */
	public String getShgzJyqk() {
		return shgzJyqk;
	}
	/**
	 * 设置：专长
	 */
	public void setZc(String zc) {
		this.zc = zc;
	}
	/**
	 * 获取：专长
	 */
	public String getZc() {
		return zc;
	}
	/**
	 * 设置：政治面貌代码
	 */
	public void setZzmmdm(String zzmmdm) {
		this.zzmmdm = zzmmdm;
	}
	/**
	 * 获取：政治面貌代码
	 */
	public String getZzmmdm() {
		return zzmmdm;
	}
	/**
	 * 设置：政治面貌
	 */
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	/**
	 * 获取：政治面貌
	 */
	public String getZzmm() {
		return zzmm;
	}
	/**
	 * 设置：入学日期
	 */
	public void setRxrq(Date rxrq) {
		this.rxrq = rxrq;
	}
	/**
	 * 获取：入学日期
	 */
	public Date getRxrq() {
		return rxrq;
	}
	/**
	 * 设置：进校日期
	 */
	public void setJxrq(Date jxrq) {
		this.jxrq = jxrq;
	}
	/**
	 * 获取：进校日期
	 */
	public Date getJxrq() {
		return jxrq;
	}
	/**
	 * 设置：入学方式
	 */
	public void setRxfsJyqk(String rxfsJyqk) {
		this.rxfsJyqk = rxfsJyqk;
	}
	/**
	 * 获取：入学方式
	 */
	public String getRxfsJyqk() {
		return rxfsJyqk;
	}
	/**
	 * 设置：特殊学生
	 */
	public void setTsxsJyqk(String tsxsJyqk) {
		this.tsxsJyqk = tsxsJyqk;
	}
	/**
	 * 获取：特殊学生
	 */
	public String getTsxsJyqk() {
		return tsxsJyqk;
	}
	/**
	 * 设置：就读方式
	 */
	public void setJdfsJyqk(String jdfsJyqk) {
		this.jdfsJyqk = jdfsJyqk;
	}
	/**
	 * 获取：就读方式
	 */
	public String getJdfsJyqk() {
		return jdfsJyqk;
	}
	/**
	 * 设置：学段
	 */
	public void setXd(String xd) {
		this.xd = xd;
	}
	/**
	 * 获取：学段
	 */
	public String getXd() {
		return xd;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLxdh() {
		return lxdh;
	}
	/**
	 * 设置：QQ_服务标识号
	 */
	public void setQqFwbzh(String qqFwbzh) {
		this.qqFwbzh = qqFwbzh;
	}
	/**
	 * 获取：QQ_服务标识号
	 */
	public String getQqFwbzh() {
		return qqFwbzh;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setDzxx(String dzxx) {
		this.dzxx = dzxx;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getDzxx() {
		return dzxx;
	}
	/**
	 * 设置：离校原因
	 */
	public void setLxyyJyqk(String lxyyJyqk) {
		this.lxyyJyqk = lxyyJyqk;
	}
	/**
	 * 获取：离校原因
	 */
	public String getLxyyJyqk() {
		return lxyyJyqk;
	}
	/**
	 * 设置：离校方向
	 */
	public void setLxfxJyqk(String lxfxJyqk) {
		this.lxfxJyqk = lxfxJyqk;
	}
	/**
	 * 获取：离校方向
	 */
	public String getLxfxJyqk() {
		return lxfxJyqk;
	}
	/**
	 * 设置：备注
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}
	/**
	 * 获取：备注
	 */
	public String getBz() {
		return bz;
	}
	/**
	 * 设置：父亲_姓名
	 */
	public void setFqXm(String fqXm) {
		this.fqXm = fqXm;
	}
	/**
	 * 获取：父亲_姓名
	 */
	public String getFqXm() {
		return fqXm;
	}
	/**
	 * 设置：父亲_姓名汉语拼音
	 */
	public void setFqXmhypy(String fqXmhypy) {
		this.fqXmhypy = fqXmhypy;
	}
	/**
	 * 获取：父亲_姓名汉语拼音
	 */
	public String getFqXmhypy() {
		return fqXmhypy;
	}
	/**
	 * 设置：父亲_常用证件代码
	 */
	public void setFqCyzjdm(String fqCyzjdm) {
		this.fqCyzjdm = fqCyzjdm;
	}
	/**
	 * 获取：父亲_常用证件代码
	 */
	public String getFqCyzjdm() {
		return fqCyzjdm;
	}
	/**
	 * 设置：父亲_常用证件名称
	 */
	public void setFqCyzjmc(String fqCyzjmc) {
		this.fqCyzjmc = fqCyzjmc;
	}
	/**
	 * 获取：父亲_常用证件名称
	 */
	public String getFqCyzjmc() {
		return fqCyzjmc;
	}
	/**
	 * 设置：父亲_证件号码
	 */
	public void setFqZjhm(String fqZjhm) {
		this.fqZjhm = fqZjhm;
	}
	/**
	 * 获取：父亲_证件号码
	 */
	public String getFqZjhm() {
		return fqZjhm;
	}
	/**
	 * 设置：父亲_出生日期
	 */
	public void setFqCsrq(String fqCsrq) {
		this.fqCsrq = fqCsrq;
	}
	/**
	 * 获取：父亲_出生日期
	 */
	public String getFqCsrq() {
		return fqCsrq;
	}
	/**
	 * 设置：父亲_婚姻状况代码
	 */
	public void setFqHyzkdm(String fqHyzkdm) {
		this.fqHyzkdm = fqHyzkdm;
	}
	/**
	 * 获取：父亲_婚姻状况代码
	 */
	public String getFqHyzkdm() {
		return fqHyzkdm;
	}
	/**
	 * 设置：父亲_婚姻状况
	 */
	public void setFqHyzk(String fqHyzk) {
		this.fqHyzk = fqHyzk;
	}
	/**
	 * 获取：父亲_婚姻状况
	 */
	public String getFqHyzk() {
		return fqHyzk;
	}
	/**
	 * 设置：父亲_职业
	 */
	public void setFqZy(String fqZy) {
		this.fqZy = fqZy;
	}
	/**
	 * 获取：父亲_职业
	 */
	public String getFqZy() {
		return fqZy;
	}
	/**
	 * 设置：父亲_职务名称
	 */
	public void setFqZwmc(String fqZwmc) {
		this.fqZwmc = fqZwmc;
	}
	/**
	 * 获取：父亲_职务名称
	 */
	public String getFqZwmc() {
		return fqZwmc;
	}
	/**
	 * 设置：父亲_政治面貌代码
	 */
	public void setFqZzmmdm(String fqZzmmdm) {
		this.fqZzmmdm = fqZzmmdm;
	}
	/**
	 * 获取：父亲_政治面貌代码
	 */
	public String getFqZzmmdm() {
		return fqZzmmdm;
	}
	/**
	 * 设置：父亲_政治面貌
	 */
	public void setFqZzmm(String fqZzmm) {
		this.fqZzmm = fqZzmm;
	}
	/**
	 * 获取：父亲_政治面貌
	 */
	public String getFqZzmm() {
		return fqZzmm;
	}
	/**
	 * 设置：父亲_工作单位
	 */
	public void setFqFwcs(String fqFwcs) {
		this.fqFwcs = fqFwcs;
	}
	/**
	 * 获取：父亲_工作单位
	 */
	public String getFqFwcs() {
		return fqFwcs;
	}
	/**
	 * 设置：父亲_联系电话
	 */
	public void setFqLxdh(String fqLxdh) {
		this.fqLxdh = fqLxdh;
	}
	/**
	 * 获取：父亲_联系电话
	 */
	public String getFqLxdh() {
		return fqLxdh;
	}
	/**
	 * 设置：父亲_关系
	 */
	public void setFqGxJyqk(String fqGxJyqk) {
		this.fqGxJyqk = fqGxJyqk;
	}
	/**
	 * 获取：父亲_关系
	 */
	public String getFqGxJyqk() {
		return fqGxJyqk;
	}
	/**
	 * 设置：父亲_QQ号码
	 */
	public void setFqQqFwbzh(String fqQqFwbzh) {
		this.fqQqFwbzh = fqQqFwbzh;
	}
	/**
	 * 获取：父亲_QQ号码
	 */
	public String getFqQqFwbzh() {
		return fqQqFwbzh;
	}
	/**
	 * 设置：父亲_电子邮箱
	 */
	public void setFqDzxx(String fqDzxx) {
		this.fqDzxx = fqDzxx;
	}
	/**
	 * 获取：父亲_电子邮箱
	 */
	public String getFqDzxx() {
		return fqDzxx;
	}
	/**
	 * 设置：母亲_姓名
	 */
	public void setMqXm(String mqXm) {
		this.mqXm = mqXm;
	}
	/**
	 * 获取：母亲_姓名
	 */
	public String getMqXm() {
		return mqXm;
	}
	/**
	 * 设置：母亲_姓名汉语拼音
	 */
	public void setMqXmhypy(String mqXmhypy) {
		this.mqXmhypy = mqXmhypy;
	}
	/**
	 * 获取：母亲_姓名汉语拼音
	 */
	public String getMqXmhypy() {
		return mqXmhypy;
	}
	/**
	 * 设置：母亲_常用证件代码
	 */
	public void setMqCyzjdm(String mqCyzjdm) {
		this.mqCyzjdm = mqCyzjdm;
	}
	/**
	 * 获取：母亲_常用证件代码
	 */
	public String getMqCyzjdm() {
		return mqCyzjdm;
	}
	/**
	 * 设置：母亲_常用证件名称
	 */
	public void setMqCyzjmc(String mqCyzjmc) {
		this.mqCyzjmc = mqCyzjmc;
	}
	/**
	 * 获取：母亲_常用证件名称
	 */
	public String getMqCyzjmc() {
		return mqCyzjmc;
	}
	/**
	 * 设置：母亲_证件号码
	 */
	public void setMqZjhm(String mqZjhm) {
		this.mqZjhm = mqZjhm;
	}
	/**
	 * 获取：母亲_证件号码
	 */
	public String getMqZjhm() {
		return mqZjhm;
	}
	/**
	 * 设置：母亲_出生日期
	 */
	public void setMqCsrq(String mqCsrq) {
		this.mqCsrq = mqCsrq;
	}
	/**
	 * 获取：母亲_出生日期
	 */
	public String getMqCsrq() {
		return mqCsrq;
	}
	/**
	 * 设置：母亲_婚姻状况代码
	 */
	public void setMqHyzkdm(String mqHyzkdm) {
		this.mqHyzkdm = mqHyzkdm;
	}
	/**
	 * 获取：母亲_婚姻状况代码
	 */
	public String getMqHyzkdm() {
		return mqHyzkdm;
	}
	/**
	 * 设置：母亲_婚姻状况
	 */
	public void setMqHyzk(String mqHyzk) {
		this.mqHyzk = mqHyzk;
	}
	/**
	 * 获取：母亲_婚姻状况
	 */
	public String getMqHyzk() {
		return mqHyzk;
	}
	/**
	 * 设置：母亲_职业
	 */
	public void setMqZy(String mqZy) {
		this.mqZy = mqZy;
	}
	/**
	 * 获取：母亲_职业
	 */
	public String getMqZy() {
		return mqZy;
	}
	/**
	 * 设置：母亲_职务名称
	 */
	public void setMqZwmc(String mqZwmc) {
		this.mqZwmc = mqZwmc;
	}
	/**
	 * 获取：母亲_职务名称
	 */
	public String getMqZwmc() {
		return mqZwmc;
	}
	/**
	 * 设置：母亲_政治面貌代码
	 */
	public void setMqZzmmdm(String mqZzmmdm) {
		this.mqZzmmdm = mqZzmmdm;
	}
	/**
	 * 获取：母亲_政治面貌代码
	 */
	public String getMqZzmmdm() {
		return mqZzmmdm;
	}
	/**
	 * 设置：母亲_政治面貌
	 */
	public void setMqZzmm(String mqZzmm) {
		this.mqZzmm = mqZzmm;
	}
	/**
	 * 获取：母亲_政治面貌
	 */
	public String getMqZzmm() {
		return mqZzmm;
	}
	/**
	 * 设置：母亲_工作单位
	 */
	public void setMqFwcs(String mqFwcs) {
		this.mqFwcs = mqFwcs;
	}
	/**
	 * 获取：母亲_工作单位
	 */
	public String getMqFwcs() {
		return mqFwcs;
	}
	/**
	 * 设置：母亲_联系电话
	 */
	public void setMqLxdh(String mqLxdh) {
		this.mqLxdh = mqLxdh;
	}
	/**
	 * 获取：母亲_联系电话
	 */
	public String getMqLxdh() {
		return mqLxdh;
	}
	/**
	 * 设置：母亲_关系
	 */
	public void setMqGxJyqk(String mqGxJyqk) {
		this.mqGxJyqk = mqGxJyqk;
	}
	/**
	 * 获取：母亲_关系
	 */
	public String getMqGxJyqk() {
		return mqGxJyqk;
	}
	/**
	 * 设置：母亲_QQ号码
	 */
	public void setMqQqFwbzh(String mqQqFwbzh) {
		this.mqQqFwbzh = mqQqFwbzh;
	}
	/**
	 * 获取：母亲_QQ号码
	 */
	public String getMqQqFwbzh() {
		return mqQqFwbzh;
	}
	/**
	 * 设置：母亲_电子邮箱
	 */
	public void setMqDzxx(String mqDzxx) {
		this.mqDzxx = mqDzxx;
	}
	/**
	 * 获取：母亲_电子邮箱
	 */
	public String getMqDzxx() {
		return mqDzxx;
	}
	/**
	 * 设置：备注2
	 */
	public void setBz2(String bz2) {
		this.bz2 = bz2;
	}
	/**
	 * 获取：备注2
	 */
	public String getBz2() {
		return bz2;
	}
	/**
	 * 设置：导入时间
	 */
	public void setDrsj(Date drsj) {
		this.drsj = drsj;
	}
	/**
	 * 获取：导入时间
	 */
	public Date getDrsj() {
		return drsj;
	}
	/**
	 * 设置：导入外键批次号
	 */
	public void setDrfk(String drfk) {
		this.drfk = drfk;
	}
	/**
	 * 获取：导入外键批次号
	 */
	public String getDrfk() {
		return drfk;
	}
	/**
	 * 设置：导入主题描述
	 */
	public void setDrztms(String drztms) {
		this.drztms = drztms;
	}
	/**
	 * 获取：导入主题描述
	 */
	public String getDrztms() {
		return drztms;
	}
	/**
	 * 设置：登记时间
	 */
	public void setDjsj(Date djsj) {
		this.djsj = djsj;
	}
	/**
	 * 获取：登记时间
	 */
	public Date getDjsj() {
		return djsj;
	}
	/**
	 * 设置：登记单位代码
	 */
	public void setDjdwGajgjgdm(String djdwGajgjgdm) {
		this.djdwGajgjgdm = djdwGajgjgdm;
	}
	/**
	 * 获取：登记单位代码
	 */
	public String getDjdwGajgjgdm() {
		return djdwGajgjgdm;
	}
	/**
	 * 设置：登记单位_公安机关名称
	 */
	public void setDjdwGajgmc(String djdwGajgmc) {
		this.djdwGajgmc = djdwGajgmc;
	}
	/**
	 * 获取：登记单位_公安机关名称
	 */
	public String getDjdwGajgmc() {
		return djdwGajgmc;
	}
	/**
	 * 设置：登记人_姓名
	 */
	public void setDjrXm(String djrXm) {
		this.djrXm = djrXm;
	}
	/**
	 * 获取：登记人_姓名
	 */
	public String getDjrXm() {
		return djrXm;
	}
	/**
	 * 设置：登记人_公民身份号码
	 */
	public void setDjrGmsfhm(String djrGmsfhm) {
		this.djrGmsfhm = djrGmsfhm;
	}
	/**
	 * 获取：登记人_公民身份号码
	 */
	public String getDjrGmsfhm() {
		return djrGmsfhm;
	}
	/**
	 * 设置：登记人_联系电话
	 */
	public void setDjrLxdh(String djrLxdh) {
		this.djrLxdh = djrLxdh;
	}
	/**
	 * 获取：登记人_联系电话
	 */
	public String getDjrLxdh() {
		return djrLxdh;
	}
	/**
	 * 设置：信息来源区划
	 */
	public void setXxlyXzqhdm(String xxlyXzqhdm) {
		this.xxlyXzqhdm = xxlyXzqhdm;
	}
	/**
	 * 获取：信息来源区划
	 */
	public String getXxlyXzqhdm() {
		return xxlyXzqhdm;
	}
	/**
	 * 设置：首次_信息入库时间
	 */
	public void setScXxrksj(Date scXxrksj) {
		this.scXxrksj = scXxrksj;
	}
	/**
	 * 获取：首次_信息入库时间
	 */
	public Date getScXxrksj() {
		return scXxrksj;
	}
	/**
	 * 设置：信息入库时间
	 */
	public void setXxrksj(Date xxrksj) {
		this.xxrksj = xxrksj;
	}
	/**
	 * 获取：信息入库时间
	 */
	public Date getXxrksj() {
		return xxrksj;
	}
}
