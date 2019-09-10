package com.yaofei.springmvcmybatis.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MedicalStaticPeopleToCityTransfer extends BaseEntity {
  private static final long serialVersionUID = 1L;

  private long id;
  private long xxzjbh;
  private String cyzjdm;
  private String zjhm;
  private String xm;
  private String xbdm;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
  private Date csrq;
  private String mzdm;
  private String xldm;
  private String hyzkdm;
  private String gjdm;
  private String zyzgmc;
  private String cyzgzzt;
  private String cyzglbhzqc;
  private String cyzgzh;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date cyzgzCclzrq;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date cyzgzbzRq;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date cyzgzhzRq;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date cyzgzkhzqJzrq;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date cyzgzyxqJzrq;
  private long cyzgzbhzCs;
  private String fzjgDwmc;
  private String hjdzXzqhdm;
  private String hjdzXzqhmc;
  private String hjdzDzmc;
  private String xzzXzqhdm;
  private String xzzXzqhmc;
  private String xzzDzmc;
  private String lxdh;
  private String dwmc;
  private String gzdwLxdh;
  private String gzdwXzqhdm;
  private String gzdwfzrGmsfhm;
  private String gzdwfzrXm;
  private String gzdwfzrLxdh;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date dbdwRq;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date lkbdwRq;
  private String hylbdm;
  private String bz;
  private String xxlyXzqhdm;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date cjgzSj;
  private String ygxzdm;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date djsj;
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

  public String getCyzjdm() {
    return cyzjdm;
  }

  public void setCyzjdm(String cyzjdm) {
    this.cyzjdm = cyzjdm;
  }

  public String getZjhm() {
    return zjhm;
  }

  public void setZjhm(String zjhm) {
    this.zjhm = zjhm;
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

  public Date getCsrq() {
    return csrq;
  }

  public void setCsrq(Date csrq) {
    this.csrq = csrq;
  }

  public String getMzdm() {
    return mzdm;
  }

  public void setMzdm(String mzdm) {
    this.mzdm = mzdm;
  }

  public String getXldm() {
    return xldm;
  }

  public void setXldm(String xldm) {
    this.xldm = xldm;
  }

  public String getHyzkdm() {
    return hyzkdm;
  }

  public void setHyzkdm(String hyzkdm) {
    this.hyzkdm = hyzkdm;
  }

  public String getGjdm() {
    return gjdm;
  }

  public void setGjdm(String gjdm) {
    this.gjdm = gjdm;
  }

  public String getZyzgmc() {
    return zyzgmc;
  }

  public void setZyzgmc(String zyzgmc) {
    this.zyzgmc = zyzgmc;
  }

  public String getCyzgzzt() {
    return cyzgzzt;
  }

  public void setCyzgzzt(String cyzgzzt) {
    this.cyzgzzt = cyzgzzt;
  }

  public String getCyzglbhzqc() {
    return cyzglbhzqc;
  }

  public void setCyzglbhzqc(String cyzglbhzqc) {
    this.cyzglbhzqc = cyzglbhzqc;
  }

  public String getCyzgzh() {
    return cyzgzh;
  }

  public void setCyzgzh(String cyzgzh) {
    this.cyzgzh = cyzgzh;
  }

  public Date getCyzgzCclzrq() {
    return cyzgzCclzrq;
  }

  public void setCyzgzCclzrq(Date cyzgzCclzrq) {
    this.cyzgzCclzrq = cyzgzCclzrq;
  }

  public Date getCyzgzbzRq() {
    return cyzgzbzRq;
  }

  public void setCyzgzbzRq(Date cyzgzbzRq) {
    this.cyzgzbzRq = cyzgzbzRq;
  }

  public Date getCyzgzhzRq() {
    return cyzgzhzRq;
  }

  public void setCyzgzhzRq(Date cyzgzhzRq) {
    this.cyzgzhzRq = cyzgzhzRq;
  }

  public Date getCyzgzkhzqJzrq() {
    return cyzgzkhzqJzrq;
  }

  public void setCyzgzkhzqJzrq(Date cyzgzkhzqJzrq) {
    this.cyzgzkhzqJzrq = cyzgzkhzqJzrq;
  }

  public Date getCyzgzyxqJzrq() {
    return cyzgzyxqJzrq;
  }

  public void setCyzgzyxqJzrq(Date cyzgzyxqJzrq) {
    this.cyzgzyxqJzrq = cyzgzyxqJzrq;
  }

  public long getCyzgzbhzCs() {
    return cyzgzbhzCs;
  }

  public void setCyzgzbhzCs(long cyzgzbhzCs) {
    this.cyzgzbhzCs = cyzgzbhzCs;
  }

  public String getFzjgDwmc() {
    return fzjgDwmc;
  }

  public void setFzjgDwmc(String fzjgDwmc) {
    this.fzjgDwmc = fzjgDwmc;
  }

  public String getHjdzXzqhdm() {
    return hjdzXzqhdm;
  }

  public void setHjdzXzqhdm(String hjdzXzqhdm) {
    this.hjdzXzqhdm = hjdzXzqhdm;
  }

  public String getHjdzXzqhmc() {
    return hjdzXzqhmc;
  }

  public void setHjdzXzqhmc(String hjdzXzqhmc) {
    this.hjdzXzqhmc = hjdzXzqhmc;
  }

  public String getHjdzDzmc() {
    return hjdzDzmc;
  }

  public void setHjdzDzmc(String hjdzDzmc) {
    this.hjdzDzmc = hjdzDzmc;
  }

  public String getXzzXzqhdm() {
    return xzzXzqhdm;
  }

  public void setXzzXzqhdm(String xzzXzqhdm) {
    this.xzzXzqhdm = xzzXzqhdm;
  }

  public String getXzzXzqhmc() {
    return xzzXzqhmc;
  }

  public void setXzzXzqhmc(String xzzXzqhmc) {
    this.xzzXzqhmc = xzzXzqhmc;
  }

  public String getXzzDzmc() {
    return xzzDzmc;
  }

  public void setXzzDzmc(String xzzDzmc) {
    this.xzzDzmc = xzzDzmc;
  }

  public String getLxdh() {
    return lxdh;
  }

  public void setLxdh(String lxdh) {
    this.lxdh = lxdh;
  }

  public String getDwmc() {
    return dwmc;
  }

  public void setDwmc(String dwmc) {
    this.dwmc = dwmc;
  }

  public String getGzdwLxdh() {
    return gzdwLxdh;
  }

  public void setGzdwLxdh(String gzdwLxdh) {
    this.gzdwLxdh = gzdwLxdh;
  }

  public String getGzdwXzqhdm() {
    return gzdwXzqhdm;
  }

  public void setGzdwXzqhdm(String gzdwXzqhdm) {
    this.gzdwXzqhdm = gzdwXzqhdm;
  }

  public String getGzdwfzrGmsfhm() {
    return gzdwfzrGmsfhm;
  }

  public void setGzdwfzrGmsfhm(String gzdwfzrGmsfhm) {
    this.gzdwfzrGmsfhm = gzdwfzrGmsfhm;
  }

  public String getGzdwfzrXm() {
    return gzdwfzrXm;
  }

  public void setGzdwfzrXm(String gzdwfzrXm) {
    this.gzdwfzrXm = gzdwfzrXm;
  }

  public String getGzdwfzrLxdh() {
    return gzdwfzrLxdh;
  }

  public void setGzdwfzrLxdh(String gzdwfzrLxdh) {
    this.gzdwfzrLxdh = gzdwfzrLxdh;
  }

  public Date getDbdwRq() {
    return dbdwRq;
  }

  public void setDbdwRq(Date dbdwRq) {
    this.dbdwRq = dbdwRq;
  }

  public Date getLkbdwRq() {
    return lkbdwRq;
  }

  public void setLkbdwRq(Date lkbdwRq) {
    this.lkbdwRq = lkbdwRq;
  }

  public String getHylbdm() {
    return hylbdm;
  }

  public void setHylbdm(String hylbdm) {
    this.hylbdm = hylbdm;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public String getXxlyXzqhdm() {
    return xxlyXzqhdm;
  }

  public void setXxlyXzqhdm(String xxlyXzqhdm) {
    this.xxlyXzqhdm = xxlyXzqhdm;
  }

  public Date getCjgzSj() {
    return cjgzSj;
  }

  public void setCjgzSj(Date cjgzSj) {
    this.cjgzSj = cjgzSj;
  }

  public String getYgxzdm() {
    return ygxzdm;
  }

  public void setYgxzdm(String ygxzdm) {
    this.ygxzdm = ygxzdm;
  }

  public Date getDjsj() {
    return djsj;
  }

  public void setDjsj(Date djsj) {
    this.djsj = djsj;
  }

  public Date getXxrksj() {
    return xxrksj;
  }

  public void setXxrksj(Date xxrksj) {
    this.xxrksj = xxrksj;
  }
}
