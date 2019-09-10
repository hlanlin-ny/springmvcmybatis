package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CarGpsInfoToCityTransfer extends BaseEntity {
  private static final long serialVersionUID = 1L;
  private long id;
  private long xxzjbh;
  private String clid;
  private String cph;
  private String czdh;
  private String ssqy;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date dwsj;
  private String jd;
  private String wd;
  private String sd;
  private String drztms;
  private String drfk;
  private String bz;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date drsj;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date djsj;
  private String djdwGajgjgdm;
  private String djdwGajgmc;
  private String djrXm;
  private String djrGmsfhm;
  private String djrLxdh;
  private String xxlyXzqhdm;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date scXxrksj;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date xxrksj;
  private String sjly;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date scrqzjsj;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date scrzyksj;

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

  public String getClid() {
    return clid;
  }

  public void setClid(String clid) {
    this.clid = clid;
  }

  public String getCph() {
    return cph;
  }

  public void setCph(String cph) {
    this.cph = cph;
  }

  public String getCzdh() {
    return czdh;
  }

  public void setCzdh(String czdh) {
    this.czdh = czdh;
  }

  public String getSsqy() {
    return ssqy;
  }

  public void setSsqy(String ssqy) {
    this.ssqy = ssqy;
  }

  public Date getDwsj() {
    return dwsj;
  }

  public void setDwsj(Date dwsj) {
    this.dwsj = dwsj;
  }

  public String getJd() {
    return jd;
  }

  public void setJd(String jd) {
    this.jd = jd;
  }

  public String getWd() {
    return wd;
  }

  public void setWd(String wd) {
    this.wd = wd;
  }

  public String getSd() {
    return sd;
  }

  public void setSd(String sd) {
    this.sd = sd;
  }

  public String getDrztms() {
    return drztms;
  }

  public void setDrztms(String drztms) {
    this.drztms = drztms;
  }

  public String getDrfk() {
    return drfk;
  }

  public void setDrfk(String drfk) {
    this.drfk = drfk;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
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

  public String getDjdwGajgjgdm() {
    return djdwGajgjgdm;
  }

  public void setDjdwGajgjgdm(String djdwGajgjgdm) {
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

  public String getSjly() {
    return sjly;
  }

  public void setSjly(String sjly) {
    this.sjly = sjly;
  }

  public Date getScrqzjsj() {
    return scrqzjsj;
  }

  public void setScrqzjsj(Date scrqzjsj) {
    this.scrqzjsj = scrqzjsj;
  }

  public Date getScrzyksj() {
    return scrzyksj;
  }

  public void setScrzyksj(Date scrzyksj) {
    this.scrzyksj = scrzyksj;
  }
}
