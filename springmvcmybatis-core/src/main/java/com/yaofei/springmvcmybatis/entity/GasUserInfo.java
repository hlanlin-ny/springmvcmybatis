package com.yaofei.springmvcmybatis.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GasUserInfo extends BaseEntity{

  private long id;
  private String xxzjbh;
  private String xm;
  private String xbdm;
  private String xb;
  private String cyzjdm;
  private String cyzjhm;
  private String dwmc;
  private String yhlx;
  private String yhfh;
  private String sydzDzmc;
  private String lxdzDzmc;
  private String lxdzYzbm;
  private String lxdh;
  private String gddh;
  private String yddh;
  private String dzxx;
  private String fwcs;
  private String gzdwLxdh;
  private String zw;
  private String hzXm;
  private String yhzgx;
  private String khlx;
  private String yhzh;
  private String yyYhzh;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date zhjfrq;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date djrq;
  private String bz;
  private String drfk;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date drsj;
  private String drztms;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date djsj;
  private long djdwGajgjgdm;
  private String djdwGajgmc;
  private String djrXm;
  private String djrGmsfhm;
  private String djrLxdh;
  private String xxlyXzqhdm;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date xxrksj;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getXxzjbh() {
    return xxzjbh;
  }

  public void setXxzjbh(String xxzjbh) {
    this.xxzjbh = xxzjbh;
  }

  public String getXm() {
    return xm;
  }

  public void setXm(String xm) {
    this.xm = xm;
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

  public String getCyzjhm() {
    return cyzjhm;
  }

  public void setCyzjhm(String cyzjhm) {
    this.cyzjhm = cyzjhm;
  }

  public String getDwmc() {
    return dwmc;
  }

  public void setDwmc(String dwmc) {
    this.dwmc = dwmc;
  }

  public String getYhlx() {
    return yhlx;
  }

  public void setYhlx(String yhlx) {
    this.yhlx = yhlx;
  }

  public String getYhfh() {
    return yhfh;
  }

  public void setYhfh(String yhfh) {
    this.yhfh = yhfh;
  }

  public String getSydzDzmc() {
    return sydzDzmc;
  }

  public void setSydzDzmc(String sydzDzmc) {
    this.sydzDzmc = sydzDzmc;
  }

  public String getLxdzDzmc() {
    return lxdzDzmc;
  }

  public void setLxdzDzmc(String lxdzDzmc) {
    this.lxdzDzmc = lxdzDzmc;
  }

  public String getLxdzYzbm() {
    return lxdzYzbm;
  }

  public void setLxdzYzbm(String lxdzYzbm) {
    this.lxdzYzbm = lxdzYzbm;
  }

  public String getLxdh() {
    return lxdh;
  }

  public void setLxdh(String lxdh) {
    this.lxdh = lxdh;
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

  public String getDzxx() {
    return dzxx;
  }

  public void setDzxx(String dzxx) {
    this.dzxx = dzxx;
  }

  public String getFwcs() {
    return fwcs;
  }

  public void setFwcs(String fwcs) {
    this.fwcs = fwcs;
  }

  public String getGzdwLxdh() {
    return gzdwLxdh;
  }

  public void setGzdwLxdh(String gzdwLxdh) {
    this.gzdwLxdh = gzdwLxdh;
  }

  public String getZw() {
    return zw;
  }

  public void setZw(String zw) {
    this.zw = zw;
  }

  public String getHzXm() {
    return hzXm;
  }

  public void setHzXm(String hzXm) {
    this.hzXm = hzXm;
  }

  public String getYhzgx() {
    return yhzgx;
  }

  public void setYhzgx(String yhzgx) {
    this.yhzgx = yhzgx;
  }

  public String getKhlx() {
    return khlx;
  }

  public void setKhlx(String khlx) {
    this.khlx = khlx;
  }

  public String getYhzh() {
    return yhzh;
  }

  public void setYhzh(String yhzh) {
    this.yhzh = yhzh;
  }

  public String getYyYhzh() {
    return yyYhzh;
  }

  public void setYyYhzh(String yyYhzh) {
    this.yyYhzh = yyYhzh;
  }

  public Date getZhjfrq() {
    return zhjfrq;
  }

  public void setZhjfrq(Date zhjfrq) {
    this.zhjfrq = zhjfrq;
  }

  public Date getDjrq() {
    return djrq;
  }

  public void setDjrq(Date djrq) {
    this.djrq = djrq;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public String getDrfk() {
    return drfk;
  }

  public void setDrfk(String drfk) {
    this.drfk = drfk;
  }

  public Date getDrsj() {
    return drsj;
  }

  public void setDrsj(Date drsj) {
    this.drsj = drsj;
  }

  public String getDrztms() {
    return drztms;
  }

  public void setDrztms(String drztms) {
    this.drztms = drztms;
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

  public Date getXxrksj() {
    return xxrksj;
  }

  public void setXxrksj(Date xxrksj) {
    this.xxrksj = xxrksj;
  }
}
