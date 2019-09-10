package com.yaofei.springmvcmybatis.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MedicalStaticWaterToCityTransfer extends BaseEntity {
  private static final long serialVersionUID = 1L;

  private long id;
  private long xxzjbh;
  private String khWpbzh;
  private String xm;
  private String xb;
  private String xzzDzmc;
  private String gmsfhm;
  private String ysxz;
  private String gddh;
  private String yddh;
  private String lxrXm;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date khrq;
  private long gsrkRs;
  private String yhlx;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date drsj;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date djsj;
  private long djdwGajgjgdm;
  private String djdwGajgmc;
  private String djrXm;
  private String djrGmsfhm;
  private String djrLxdh;
  private String xxlyXzqhdm;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date scXxrksj;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date xxrksj;
  private String bz;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getXxzjbh() {
    return xxzjbh;
  }

  public void setXxzjbh(long xxzjbh) {
    this.xxzjbh = xxzjbh;
  }

  public String getKhWpbzh() {
    return khWpbzh;
  }

  public void setKhWpbzh(String khWpbzh) {
    this.khWpbzh = khWpbzh;
  }

  public String getXm() {
    return xm;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public String getXb() {
    return xb;
  }

  public void setXb(String xb) {
    this.xb = xb;
  }

  public String getXzzDzmc() {
    return xzzDzmc;
  }

  public void setXzzDzmc(String xzzDzmc) {
    this.xzzDzmc = xzzDzmc;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getYsxz() {
    return ysxz;
  }

  public void setYsxz(String ysxz) {
    this.ysxz = ysxz;
  }

  public String getGddh() {
    return gddh;
  }

  public void setGddh(String gddh) {
    this.gddh = gddh;
  }

  public String getYddh() {
    return yddh;
  }

  public void setYddh(String yddh) {
    this.yddh = yddh;
  }

  public String getLxrXm() {
    return lxrXm;
  }

  public void setLxrXm(String lxrXm) {
    this.lxrXm = lxrXm;
  }

  public Date getKhrq() {
    return khrq;
  }

  public void setKhrq(Date khrq) {
    this.khrq = khrq;
  }

  public long getGsrkRs() {
    return gsrkRs;
  }

  public void setGsrkRs(long gsrkRs) {
    this.gsrkRs = gsrkRs;
  }

  public String getYhlx() {
    return yhlx;
  }

  public void setYhlx(String yhlx) {
    this.yhlx = yhlx;
  }

  public Date getDrsj() {
    return drsj;
  }

  public void setDrsj(Date drsj) {
    this.drsj = drsj;
  }

  public Date getDjsj() {
    return djsj;
  }

  public void setDjsj(Date djsj) {
    this.djsj = djsj;
  }

  public long getDjdwGajgjgdm() {
    return djdwGajgjgdm;
  }

  public void setDjdwGajgjgdm(long djdwGajgjgdm) {
    this.djdwGajgjgdm = djdwGajgjgdm;
  }

  public String getDjdwGajgmc() {
    return djdwGajgmc;
  }

  public void setDjdwGajgmc(String djdwGajgmc) {
    this.djdwGajgmc = djdwGajgmc;
  }

  public String getDjrXm() {
    return djrXm;
  }

  public void setDjrXm(String djrXm) {
    this.djrXm = djrXm;
  }

  public String getDjrGmsfhm() {
    return djrGmsfhm;
  }

  public void setDjrGmsfhm(String djrGmsfhm) {
    this.djrGmsfhm = djrGmsfhm;
  }

  public String getDjrLxdh() {
    return djrLxdh;
  }

  public void setDjrLxdh(String djrLxdh) {
    this.djrLxdh = djrLxdh;
  }

  public String getXxlyXzqhdm() {
    return xxlyXzqhdm;
  }

  public void setXxlyXzqhdm(String xxlyXzqhdm) {
    this.xxlyXzqhdm = xxlyXzqhdm;
  }

  public Date getScXxrksj() {
    return scXxrksj;
  }

  public void setScXxrksj(Date scXxrksj) {
    this.scXxrksj = scXxrksj;
  }

  public Date getXxrksj() {
    return xxrksj;
  }

  public void setXxrksj(Date xxrksj) {
    this.xxrksj = xxrksj;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }
}
