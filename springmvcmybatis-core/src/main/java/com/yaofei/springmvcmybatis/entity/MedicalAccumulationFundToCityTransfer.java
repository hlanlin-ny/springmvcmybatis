package com.yaofei.springmvcmybatis.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MedicalAccumulationFundToCityTransfer extends BaseEntity{
  private static final long serialVersionUID = 1L;

  private long id;
  private long xxzjbh;
  private String xm;
  private String xmhypy;
  private String xbdm;
  private String xb;
  private String cyzjdm;
  private String cyzjmc;
  private String zjhm;
  private String xzzDzmc;
  private String fwcs;
  private String bz;
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

  public String getXm() {
    return xm;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public String getXmhypy() {
    return xmhypy;
  }

  public void setXmhypy(String xmhypy) {
    this.xmhypy = xmhypy;
  }

  public String getXbdm() {
    return xbdm;
  }

  public void setXbdm(String xbdm) {
    this.xbdm = xbdm;
  }

  public String getXb() {
    return xb;
  }

  public void setXb(String xb) {
    this.xb = xb;
  }

  public String getCyzjdm() {
    return cyzjdm;
  }

  public void setCyzjdm(String cyzjdm) {
    this.cyzjdm = cyzjdm;
  }

  public String getCyzjmc() {
    return cyzjmc;
  }

  public void setCyzjmc(String cyzjmc) {
    this.cyzjmc = cyzjmc;
  }

  public String getZjhm() {
    return zjhm;
  }

  public void setZjhm(String zjhm) {
    this.zjhm = zjhm;
  }

  public String getXzzDzmc() {
    return xzzDzmc;
  }

  public void setXzzDzmc(String xzzDzmc) {
    this.xzzDzmc = xzzDzmc;
  }

  public String getFwcs() {
    return fwcs;
  }

  public void setFwcs(String fwcs) {
    this.fwcs = fwcs;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
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
}
