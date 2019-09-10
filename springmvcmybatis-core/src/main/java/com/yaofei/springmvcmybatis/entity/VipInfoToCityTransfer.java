package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VipInfoToCityTransfer extends BaseEntity {
  private static final long serialVersionUID = 1L;
  private long id;
  private long xxzjbh;
  private String dwbh;
  private String xm;
  private String sfzh;
  private String xmhypy;
  private String xzddzmc;
  private String lxsj;
  private String lxdh;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
  private Date blsj;
  private String bldzdzmc;
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

  public String getDwbh() {
    return dwbh;
  }

  public void setDwbh(String dwbh) {
    this.dwbh = dwbh;
  }

  public String getXm() {
    return xm;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public String getSfzh() {
    return sfzh;
  }

  public void setSfzh(String sfzh) {
    this.sfzh = sfzh;
  }

  public String getXmhypy() {
    return xmhypy;
  }

  public void setXmhypy(String xmhypy) {
    this.xmhypy = xmhypy;
  }

  public String getXzddzmc() {
    return xzddzmc;
  }

  public void setXzddzmc(String xzddzmc) {
    this.xzddzmc = xzddzmc;
  }

  public String getLxsj() {
    return lxsj;
  }

  public void setLxsj(String lxsj) {
    this.lxsj = lxsj;
  }

  public String getLxdh() {
    return lxdh;
  }

  public void setLxdh(String lxdh) {
    this.lxdh = lxdh;
  }

  public Date getBlsj() {
    return blsj;
  }

  public void setBlsj(Date blsj) {
    this.blsj = blsj;
  }

  public String getBldzdzmc() {
    return bldzdzmc;
  }

  public void setBldzdzmc(String bldzdzmc) {
    this.bldzdzmc = bldzdzmc;
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
