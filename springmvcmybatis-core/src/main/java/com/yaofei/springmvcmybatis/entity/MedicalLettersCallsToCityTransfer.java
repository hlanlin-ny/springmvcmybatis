package com.yaofei.springmvcmybatis.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MedicalLettersCallsToCityTransfer  extends BaseEntity{
  private static final long serialVersionUID = 1L;

  private long id;
  private long xxzjbh;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date sfrq;
  private String xfrXm;
  private String xfrXmhypy;
  private String xfrGmsfhm;
  private String xfrLxdh;
  private String xfsyJyqk;
  private String gjxwJyqk;
  private String sldwDwmc;
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

  public Date getSfrq() {
    return sfrq;
  }

  public void setSfrq(Date sfrq) {
    this.sfrq = sfrq;
  }

  public String getXfrXm() {
    return xfrXm;
  }

  public void setXfrXm(String xfrXm) {
    this.xfrXm = xfrXm;
  }

  public String getXfrXmhypy() {
    return xfrXmhypy;
  }

  public void setXfrXmhypy(String xfrXmhypy) {
    this.xfrXmhypy = xfrXmhypy;
  }

  public String getXfrGmsfhm() {
    return xfrGmsfhm;
  }

  public void setXfrGmsfhm(String xfrGmsfhm) {
    this.xfrGmsfhm = xfrGmsfhm;
  }

  public String getXfrLxdh() {
    return xfrLxdh;
  }

  public void setXfrLxdh(String xfrLxdh) {
    this.xfrLxdh = xfrLxdh;
  }

  public String getXfsyJyqk() {
    return xfsyJyqk;
  }

  public void setXfsyJyqk(String xfsyJyqk) {
    this.xfsyJyqk = xfsyJyqk;
  }

  public String getGjxwJyqk() {
    return gjxwJyqk;
  }

  public void setGjxwJyqk(String gjxwJyqk) {
    this.gjxwJyqk = gjxwJyqk;
  }

  public String getSldwDwmc() {
    return sldwDwmc;
  }

  public void setSldwDwmc(String sldwDwmc) {
    this.sldwDwmc = sldwDwmc;
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
