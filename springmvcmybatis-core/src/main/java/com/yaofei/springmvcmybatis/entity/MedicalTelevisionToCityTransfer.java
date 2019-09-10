package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 有线电视用户登记信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-07 07:47:48
 */
public class MedicalTelevisionToCityTransfer extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//信息主键编号
	private Long xxzjbh;
	//姓名
	private String xm;
	//性别
	private String xb;
	//公民身份号码
	private String gmsfhm;
	//出生日期
	private String csrq;
	//固定电话
	private String gddh;
	//移动电话
	private String yddh;
	//家庭地址名称
	private String jtzzDzmc;
	//卡号
	private String kh;
	//职业
	private String zy;
	//工作单位
	private String fwcs;
	//安装日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date azrq;
	//截止日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date jzrq;
	//缴费_卡号
	private String jfKh;
	//登记时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date djsj;
	//登记单位
	private String djdw;
	//登记人_姓名
	private String djrXm;
	//登记人_公民身份号码
	private String djrGmsfhm;
	//登记人_联系电话
	private String djrLxdh;
	//信息来源区划
	private String xxlyXzqhdm;
	//信息入库时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date xxrksj;
	//备注
	private String bz;
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
	 * 设置：出生日期
	 */
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	/**
	 * 获取：出生日期
	 */
	public String getCsrq() {
		return csrq;
	}
	/**
	 * 设置：固定电话
	 */
	public void setGddh(String gddh) {
		this.gddh = gddh;
	}
	/**
	 * 获取：固定电话
	 */
	public String getGddh() {
		return gddh;
	}
	/**
	 * 设置：移动电话
	 */
	public void setYddh(String yddh) {
		this.yddh = yddh;
	}
	/**
	 * 获取：移动电话
	 */
	public String getYddh() {
		return yddh;
	}
	/**
	 * 设置：家庭地址名称
	 */
	public void setJtzzDzmc(String jtzzDzmc) {
		this.jtzzDzmc = jtzzDzmc;
	}
	/**
	 * 获取：家庭地址名称
	 */
	public String getJtzzDzmc() {
		return jtzzDzmc;
	}
	/**
	 * 设置：卡号
	 */
	public void setKh(String kh) {
		this.kh = kh;
	}
	/**
	 * 获取：卡号
	 */
	public String getKh() {
		return kh;
	}
	/**
	 * 设置：职业
	 */
	public void setZy(String zy) {
		this.zy = zy;
	}
	/**
	 * 获取：职业
	 */
	public String getZy() {
		return zy;
	}
	/**
	 * 设置：工作单位
	 */
	public void setFwcs(String fwcs) {
		this.fwcs = fwcs;
	}
	/**
	 * 获取：工作单位
	 */
	public String getFwcs() {
		return fwcs;
	}
	/**
	 * 设置：安装日期
	 */
	public void setAzrq(Date azrq) {
		this.azrq = azrq;
	}
	/**
	 * 获取：安装日期
	 */
	public Date getAzrq() {
		return azrq;
	}
	/**
	 * 设置：截止日期
	 */
	public void setJzrq(Date jzrq) {
		this.jzrq = jzrq;
	}
	/**
	 * 获取：截止日期
	 */
	public Date getJzrq() {
		return jzrq;
	}
	/**
	 * 设置：缴费_卡号
	 */
	public void setJfKh(String jfKh) {
		this.jfKh = jfKh;
	}
	/**
	 * 获取：缴费_卡号
	 */
	public String getJfKh() {
		return jfKh;
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

	/**
	 * 设置：登记单位
	 */
	public void setDjdw(String djdw) {
		this.djdw = djdw;
	}
	/**
	 * 获取：登记单位
	 */
	public String getDjdw() {
		return djdw;
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

}
