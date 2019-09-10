package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MedicalNcmsToCityTransfer  extends BaseEntity{
  private static final long serialVersionUID = 1L;

  private long id;
  private String ybkhm;
  private String ylcblbdm;
  private String ylcblb;
  private String ybkh;
  private String cbdc;
  private String rylbdm;
  private String rylb;
  private String ryztdm;
  private String ryzt;
  private String grztdm;
  private String grzt;
  private String xm;
  private String xmhypy;
  private String xbdm;
  private String xb;
  @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+08:00")
  private Date csrq;
  private String gmsfhm;
  private String mzdm;
  private String mz;
  private String lxdh;
  private String hjdzXzqhdm;
  private String hjdzDzmc;
  private String hkxzdm;
  private String hkxz;
  private String yhzgx;
  private String hzXm;
  private String jtbh;
  private String jtlxdm;
  private String jtlx;
  private String jtzh;
  private String cbztdm;
  private String cbzt;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date cbrq;
  private String rbbz;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date tbrq;
  private String mztczh;
  private double grjfGrJyqk;
  private double grjfMzJyqk;
  private double grjfQtJyqk;
  private String tczh;
  private long lxcbN;
  private double mzJtJe;
  private double mzGrzyJe;
  private double mzGrmztcJe;
  private double mzMzrcjzJe;
  private String bz;
  private String drztms;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date drsj;
  private String drfk;
  private String bldwDwmc;
  private String blrXm;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date blrq;
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
  private String sfxh;
  private String rklx;
  private String xxcjdw;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date xxcjsl;
  private String ylkh;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getYbkhm() {
    return ybkhm;
  }

  public void setYbkhm(String ybkhm) {
    this.ybkhm = ybkhm;
  }

  public String getYlcblbdm() {
    return ylcblbdm;
  }

  public void setYlcblbdm(String ylcblbdm) {
    this.ylcblbdm = ylcblbdm;
  }

  public String getYlcblb() {
    return ylcblb;
  }

  public void setYlcblb(String ylcblb) {
    this.ylcblb = ylcblb;
  }

  public String getYbkh() {
    return ybkh;
  }

  public void setYbkh(String ybkh) {
    this.ybkh = ybkh;
  }

  public String getCbdc() {
    return cbdc;
  }

  public void setCbdc(String cbdc) {
    this.cbdc = cbdc;
  }

  public String getRylbdm() {
    return rylbdm;
  }

  public void setRylbdm(String rylbdm) {
    this.rylbdm = rylbdm;
  }

  public String getRylb() {
    return rylb;
  }

  public void setRylb(String rylb) {
    this.rylb = rylb;
  }

  public String getRyztdm() {
    return ryztdm;
  }

  public void setRyztdm(String ryztdm) {
    this.ryztdm = ryztdm;
  }

  public String getRyzt() {
    return ryzt;
  }

  public void setRyzt(String ryzt) {
    this.ryzt = ryzt;
  }

  public String getGrztdm() {
    return grztdm;
  }

  public void setGrztdm(String grztdm) {
    this.grztdm = grztdm;
  }

  public String getGrzt() {
    return grzt;
  }

  public void setGrzt(String grzt) {
    this.grzt = grzt;
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

  public Date getCsrq() {
    return csrq;
  }

  public void setCsrq(Date csrq) {
    this.csrq = csrq;
  }

  public String getGmsfhm() {
    return gmsfhm;
  }

  public void setGmsfhm(String gmsfhm) {
    this.gmsfhm = gmsfhm;
  }

  public String getMzdm() {
    return mzdm;
  }

  public void setMzdm(String mzdm) {
    this.mzdm = mzdm;
  }

  public String getMz() {
    return mz;
  }

  public void setMz(String mz) {
    this.mz = mz;
  }

  public String getLxdh() {
    return lxdh;
  }

  public void setLxdh(String lxdh) {
    this.lxdh = lxdh;
  }

  public String getHjdzXzqhdm() {
    return hjdzXzqhdm;
  }

  public void setHjdzXzqhdm(String hjdzXzqhdm) {
    this.hjdzXzqhdm = hjdzXzqhdm;
  }

  public String getHjdzDzmc() {
    return hjdzDzmc;
  }

  public void setHjdzDzmc(String hjdzDzmc) {
    this.hjdzDzmc = hjdzDzmc;
  }

  public String getHkxzdm() {
    return hkxzdm;
  }

  public void setHkxzdm(String hkxzdm) {
    this.hkxzdm = hkxzdm;
  }

  public String getHkxz() {
    return hkxz;
  }

  public void setHkxz(String hkxz) {
    this.hkxz = hkxz;
  }

  public String getYhzgx() {
    return yhzgx;
  }

  public void setYhzgx(String yhzgx) {
    this.yhzgx = yhzgx;
  }

  public String getHzXm() {
    return hzXm;
  }

  public void setHzXm(String hzXm) {
    this.hzXm = hzXm;
  }

  public String getJtbh() {
    return jtbh;
  }

  public void setJtbh(String jtbh) {
    this.jtbh = jtbh;
  }

  public String getJtlxdm() {
    return jtlxdm;
  }

  public void setJtlxdm(String jtlxdm) {
    this.jtlxdm = jtlxdm;
  }

  public String getJtlx() {
    return jtlx;
  }

  public void setJtlx(String jtlx) {
    this.jtlx = jtlx;
  }

  public String getJtzh() {
    return jtzh;
  }

  public void setJtzh(String jtzh) {
    this.jtzh = jtzh;
  }

  public String getCbztdm() {
    return cbztdm;
  }

  public void setCbztdm(String cbztdm) {
    this.cbztdm = cbztdm;
  }

  public String getCbzt() {
    return cbzt;
  }

  public void setCbzt(String cbzt) {
    this.cbzt = cbzt;
  }

  public Date getCbrq() {
    return cbrq;
  }

  public void setCbrq(Date cbrq) {
    this.cbrq = cbrq;
  }

  public String getRbbz() {
    return rbbz;
  }

  public void setRbbz(String rbbz) {
    this.rbbz = rbbz;
  }

  public Date getTbrq() {
    return tbrq;
  }

  public void setTbrq(Date tbrq) {
    this.tbrq = tbrq;
  }

  public String getMztczh() {
    return mztczh;
  }

  public void setMztczh(String mztczh) {
    this.mztczh = mztczh;
  }

  public double getGrjfGrJyqk() {
    return grjfGrJyqk;
  }

  public void setGrjfGrJyqk(double grjfGrJyqk) {
    this.grjfGrJyqk = grjfGrJyqk;
  }

  public double getGrjfMzJyqk() {
    return grjfMzJyqk;
  }

  public void setGrjfMzJyqk(double grjfMzJyqk) {
    this.grjfMzJyqk = grjfMzJyqk;
  }

  public double getGrjfQtJyqk() {
    return grjfQtJyqk;
  }

  public void setGrjfQtJyqk(double grjfQtJyqk) {
    this.grjfQtJyqk = grjfQtJyqk;
  }

  public String getTczh() {
    return tczh;
  }

  public void setTczh(String tczh) {
    this.tczh = tczh;
  }

  public long getLxcbN() {
    return lxcbN;
  }

  public void setLxcbN(long lxcbN) {
    this.lxcbN = lxcbN;
  }

  public double getMzJtJe() {
    return mzJtJe;
  }

  public void setMzJtJe(double mzJtJe) {
    this.mzJtJe = mzJtJe;
  }

  public double getMzGrzyJe() {
    return mzGrzyJe;
  }

  public void setMzGrzyJe(double mzGrzyJe) {
    this.mzGrzyJe = mzGrzyJe;
  }

  public double getMzGrmztcJe() {
    return mzGrmztcJe;
  }

  public void setMzGrmztcJe(double mzGrmztcJe) {
    this.mzGrmztcJe = mzGrmztcJe;
  }

  public double getMzMzrcjzJe() {
    return mzMzrcjzJe;
  }

  public void setMzMzrcjzJe(double mzMzrcjzJe) {
    this.mzMzrcjzJe = mzMzrcjzJe;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public String getDrztms() {
    return drztms;
  }

  public void setDrztms(String drztms) {
    this.drztms = drztms;
  }

  public Date getDrsj() {
    return drsj;
  }

  public void setDrsj(Date drsj) {
    this.drsj = drsj;
  }

  public String getDrfk() {
    return drfk;
  }

  public void setDrfk(String drfk) {
    this.drfk = drfk;
  }

  public String getBldwDwmc() {
    return bldwDwmc;
  }

  public void setBldwDwmc(String bldwDwmc) {
    this.bldwDwmc = bldwDwmc;
  }

  public String getBlrXm() {
    return blrXm;
  }

  public void setBlrXm(String blrXm) {
    this.blrXm = blrXm;
  }

  public Date getBlrq() {
    return blrq;
  }

  public void setBlrq(Date blrq) {
    this.blrq = blrq;
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

  public String getSfxh() {
    return sfxh;
  }

  public void setSfxh(String sfxh) {
    this.sfxh = sfxh;
  }

  public String getRklx() {
    return rklx;
  }

  public void setRklx(String rklx) {
    this.rklx = rklx;
  }

  public String getXxcjdw() {
    return xxcjdw;
  }

  public void setXxcjdw(String xxcjdw) {
    this.xxcjdw = xxcjdw;
  }

  public Date getXxcjsl() {
    return xxcjsl;
  }

  public void setXxcjsl(Date xxcjsl) {
    this.xxcjsl = xxcjsl;
  }

  public String getYlkh() {
    return ylkh;
  }

  public void setYlkh(String ylkh) {
    this.ylkh = ylkh;
  }
}
