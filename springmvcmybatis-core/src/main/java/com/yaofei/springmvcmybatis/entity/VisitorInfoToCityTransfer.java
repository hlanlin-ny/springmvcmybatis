package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VisitorInfoToCityTransfer extends BaseEntity {
  private static final long serialVersionUID = 1L;
  private long id;
  private long xxzjbh;
  private String dwbh;
  private String XM;
  private String SFZH;
  private String XMPY;
  private String LXSMC;
  private String MDD_DZMC;
  private String LXDH;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
  private Date CFSJ;
  private String DRFK;
  private String DRZTMS;
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

  public String getXM() {
    return XM;
  }

  public void setXM(String XM) {
    this.XM = XM;
  }

  public String getSFZH() {
    return SFZH;
  }

  public void setSFZH(String SFZH) {
    this.SFZH = SFZH;
  }

  public String getXMPY() {
    return XMPY;
  }

  public void setXMPY(String XMPY) {
    this.XMPY = XMPY;
  }

  public String getLXSMC() {
    return LXSMC;
  }

  public void setLXSMC(String LXSMC) {
    this.LXSMC = LXSMC;
  }

  public String getMDD_DZMC() {
    return MDD_DZMC;
  }

  public void setMDD_DZMC(String MDD_DZMC) {
    this.MDD_DZMC = MDD_DZMC;
  }

  public String getLXDH() {
    return LXDH;
  }

  public void setLXDH(String LXDH) {
    this.LXDH = LXDH;
  }

  public Date getCFSJ() {
    return CFSJ;
  }

  public void setCFSJ(Date CFSJ) {
    this.CFSJ = CFSJ;
  }

  public String getDRFK() {
    return DRFK;
  }

  public void setDRFK(String DRFK) {
    this.DRFK = DRFK;
  }

  public String getDRZTMS() {
    return DRZTMS;
  }

  public void setDRZTMS(String DRZTMS) {
    this.DRZTMS = DRZTMS;
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

}
