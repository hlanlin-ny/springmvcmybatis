package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EcoGpsInfoToCityTransfer extends BaseEntity {
  private static final long serialVersionUID = 1L;
  private long id;
  private String drfk;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date drsj;
  private String drztms;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date dwsj;
  private String ssqy;
  private String hphm;
  private String cph;
  private String clid;
  private long xxzjbh;
  private String lxdh;
  private String csys;
  private String cjh;
  private String ddjh;
  private String ddc_pp;
  private long clsl;
  private String xm;
  private String gmsfhm;
  private String zs_dzmc;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date xxrksj;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date sc_xxrksj;
  private String xxly_xzqhdm;
  private String djr_lxdh;
  private String djr_gmsfhm;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private String djr_xm;
  private String djdw_gajgmc;
  private String djdw_gajgjgdm;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date djsj;
  private String bz;
  private String dsbs;
  private String sd;
  private String sjly;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date scrqzjsj;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date scrzyksj;
  private String wd;
  private String jd;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public Date getDwsj() {
    return dwsj;
  }

  public void setDwsj(Date dwsj) {
    this.dwsj = dwsj;
  }

  public String getSsqy() {
    return ssqy;
  }

  public void setSsqy(String ssqy) {
    this.ssqy = ssqy;
  }

  public String getHphm() {
    return hphm;
  }

  public void setHphm(String hphm) {
    this.hphm = hphm;
  }

  public String getClid() {
    return clid;
  }

  public void setClid(String clid) {
    this.clid = clid;
  }

  public long getXxzjbh() {
    return xxzjbh;
  }

  public void setXxzjbh(long xxzjbh) {
    this.xxzjbh = xxzjbh;
  }

  public String getLxdh() {
    return lxdh;
  }

  public void setLxdh(String lxdh) {
    this.lxdh = lxdh;
  }

  public String getCsys() {
    return csys;
  }

  public void setCsys(String csys) {
    this.csys = csys;
  }

  public String getCjh() {
    return cjh;
  }

  public void setCjh(String cjh) {
    this.cjh = cjh;
  }

  public String getDdjh() {
    return ddjh;
  }

  public void setDdjh(String ddjh) {
    this.ddjh = ddjh;
  }

  public String getDdc_pp() {
    return ddc_pp;
  }

  public void setDdc_pp(String ddc_pp) {
    this.ddc_pp = ddc_pp;
  }

  public long getClsl() {
    return clsl;
  }

  public void setClsl(long clsl) {
    this.clsl = clsl;
  }

  public String getXm() {
    return xm;
  }

  public void setXm(String xm) {
    this.xm = xm;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getZs_dzmc() {
    return zs_dzmc;
  }

  public void setZs_dzmc(String zs_dzmc) {
    this.zs_dzmc = zs_dzmc;
  }

  public Date getXxrksj() {
    return xxrksj;
  }

  public void setXxrksj(Date xxrksj) {
    this.xxrksj = xxrksj;
  }

  public Date getSc_xxrksj() {
    return sc_xxrksj;
  }

  public void setSc_xxrksj(Date sc_xxrksj) {
    this.sc_xxrksj = sc_xxrksj;
  }

  public String getXxly_xzqhdm() {
    return xxly_xzqhdm;
  }

  public void setXxly_xzqhdm(String xxly_xzqhdm) {
    this.xxly_xzqhdm = xxly_xzqhdm;
  }

  public String getDjr_lxdh() {
    return djr_lxdh;
  }

  public void setDjr_lxdh(String djr_lxdh) {
    this.djr_lxdh = djr_lxdh;
  }

  public String getDjr_gmsfhm() {
    return djr_gmsfhm;
  }

  public void setDjr_gmsfhm(String djr_gmsfhm) {
    this.djr_gmsfhm = djr_gmsfhm;
  }

  public String getDjr_xm() {
    return djr_xm;
  }

  public void setDjr_xm(String djr_xm) {
    this.djr_xm = djr_xm;
  }

  public String getDjdw_gajgmc() {
    return djdw_gajgmc;
  }

  public void setDjdw_gajgmc(String djdw_gajgmc) {
    this.djdw_gajgmc = djdw_gajgmc;
  }

  public String getDjdw_gajgjgdm() {
    return djdw_gajgjgdm;
  }

  public void setDjdw_gajgjgdm(String djdw_gajgjgdm) {
    this.djdw_gajgjgdm = djdw_gajgjgdm;
  }

  public Date getDjsj() {
    return djsj;
  }

  public void setDjsj(Date djsj) {
    this.djsj = djsj;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public String getDsbs() {
    return dsbs;
  }

  public void setDsbs(String dsbs) {
    this.dsbs = dsbs;
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

  public String getSd() {
    return sd;
  }

  public void setSd(String sd) {
    this.sd = sd;
  }

  public String getWd() {
    return wd;
  }

  public void setWd(String wd) {
    this.wd = wd;
  }

  public String getJd() {
    return jd;
  }

  public void setJd(String jd) {
    this.jd = jd;
  }

  public String getCph() {
    return cph;
  }

  public void setCph(String cph) {
    this.cph = cph;
  }
}
