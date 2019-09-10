package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Date;

public class MedicalInsuranceToCityTransfer  extends BaseEntity {
  private static final long serialVersionUID = 1L;
  private long id;
  private long xxzjbh;
  private String dwbh;
  private String xm;
  private String xmhypy;
  private String xbdm;
  private String xb;
  private String mzdm;
  private String mz;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
  private Date csrq;
  private String yhzh;
  private String zzmmdm;
  private String xldm;
  private String jyztdm;
  private String fwcs;
  private String xzzDzmc;
  private String xzzXzqhdm;
  private String hjdzDzmc;
  private String sbkh;
  private String cyzjdm;
  private String cyzjmc;
  private String zjhm;
  private String hjdzXzqhdm;
  private String hjdzXzqhmc;
  private String xzzXzqhmc;
  private String txdzDzmc;
  private String txdzYzbm;
  private String jtzzDzmc;
  private String jkzkJyqk;
  private String lxdh;
  private String whcd;
  private String zzmm;
  private String jyzt;
  private String grsfdm;
  private String grsf;
  private String cyxtdm;
  private String cyxt;
  private String zyjsdj;
  private String gz;
  private String tsgzmc;
  private String zw;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date cjgzsj;
  private String fdtxgnl;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date ltxrq;
  private String bldwDwmc;
  private String nmgyilPdbz;
  private String nmgylPdbz;
  private String yxDwmc;
  private String dkjgDwmc;
  private String bz;
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

  public Date getCsrq() {
    return csrq;
  }

  public void setCsrq(Date csrq) {
    this.csrq = csrq;
  }

  public String getYhzh() {
    return yhzh;
  }

  public void setYhzh(String yhzh) {
    this.yhzh = yhzh;
  }

  public String getZzmmdm() {
    return zzmmdm;
  }

  public void setZzmmdm(String zzmmdm) {
    this.zzmmdm = zzmmdm;
  }

  public String getXldm() {
    return xldm;
  }

  public void setXldm(String xldm) {
    this.xldm = xldm;
  }

  public String getJyztdm() {
    return jyztdm;
  }

  public void setJyztdm(String jyztdm) {
    this.jyztdm = jyztdm;
  }

  public String getFwcs() {
    return fwcs;
  }

  public void setFwcs(String fwcs) {
    this.fwcs = fwcs;
  }

  public String getXzzDzmc() {
    return xzzDzmc;
  }

  public void setXzzDzmc(String xzzDzmc) {
    this.xzzDzmc = xzzDzmc;
  }

  public String getXzzXzqhdm() {
    return xzzXzqhdm;
  }

  public void setXzzXzqhdm(String xzzXzqhdm) {
    this.xzzXzqhdm = xzzXzqhdm;
  }

  public String getHjdzDzmc() {
    return hjdzDzmc;
  }

  public void setHjdzDzmc(String hjdzDzmc) {
    this.hjdzDzmc = hjdzDzmc;
  }

  public String getSbkh() {
    return sbkh;
  }

  public void setSbkh(String sbkh) {
    this.sbkh = sbkh;
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

  public String getXzzXzqhmc() {
    return xzzXzqhmc;
  }

  public void setXzzXzqhmc(String xzzXzqhmc) {
    this.xzzXzqhmc = xzzXzqhmc;
  }

  public String getTxdzDzmc() {
    return txdzDzmc;
  }

  public void setTxdzDzmc(String txdzDzmc) {
    this.txdzDzmc = txdzDzmc;
  }

  public String getTxdzYzbm() {
    return txdzYzbm;
  }

  public void setTxdzYzbm(String txdzYzbm) {
    this.txdzYzbm = txdzYzbm;
  }

  public String getJtzzDzmc() {
    return jtzzDzmc;
  }

  public void setJtzzDzmc(String jtzzDzmc) {
    this.jtzzDzmc = jtzzDzmc;
  }

  public String getJkzkJyqk() {
    return jkzkJyqk;
  }

  public void setJkzkJyqk(String jkzkJyqk) {
    this.jkzkJyqk = jkzkJyqk;
  }

  public String getLxdh() {
    return lxdh;
  }

  public void setLxdh(String lxdh) {
    this.lxdh = lxdh;
  }

  public String getWhcd() {
    return whcd;
  }

  public void setWhcd(String whcd) {
    this.whcd = whcd;
  }

  public String getZzmm() {
    return zzmm;
  }

  public void setZzmm(String zzmm) {
    this.zzmm = zzmm;
  }

  public String getJyzt() {
    return jyzt;
  }

  public void setJyzt(String jyzt) {
    this.jyzt = jyzt;
  }

  public String getGrsfdm() {
    return grsfdm;
  }

  public void setGrsfdm(String grsfdm) {
    this.grsfdm = grsfdm;
  }

  public String getGrsf() {
    return grsf;
  }

  public void setGrsf(String grsf) {
    this.grsf = grsf;
  }

  public String getCyxtdm() {
    return cyxtdm;
  }

  public void setCyxtdm(String cyxtdm) {
    this.cyxtdm = cyxtdm;
  }

  public String getCyxt() {
    return cyxt;
  }

  public void setCyxt(String cyxt) {
    this.cyxt = cyxt;
  }

  public String getZyjsdj() {
    return zyjsdj;
  }

  public void setZyjsdj(String zyjsdj) {
    this.zyjsdj = zyjsdj;
  }

  public String getGz() {
    return gz;
  }

  public void setGz(String gz) {
    this.gz = gz;
  }

  public String getTsgzmc() {
    return tsgzmc;
  }

  public void setTsgzmc(String tsgzmc) {
    this.tsgzmc = tsgzmc;
  }

  public String getZw() {
    return zw;
  }

  public void setZw(String zw) {
    this.zw = zw;
  }

  public Date getCjgzsj() {
    return cjgzsj;
  }

  public void setCjgzsj(Date cjgzsj) {
    this.cjgzsj = cjgzsj;
  }

  public String getFdtxgnl() {
    return fdtxgnl;
  }

  public void setFdtxgnl(String fdtxgnl) {
    this.fdtxgnl = fdtxgnl;
  }

  public Date getLtxrq() {
    return ltxrq;
  }

  public void setLtxrq(Date ltxrq) {
    this.ltxrq = ltxrq;
  }

  public String getBldwDwmc() {
    return bldwDwmc;
  }

  public void setBldwDwmc(String bldwDwmc) {
    this.bldwDwmc = bldwDwmc;
  }

  public String getNmgyilPdbz() {
    return nmgyilPdbz;
  }

  public void setNmgyilPdbz(String nmgyilPdbz) {
    this.nmgyilPdbz = nmgyilPdbz;
  }

  public String getNmgylPdbz() {
    return nmgylPdbz;
  }

  public void setNmgylPdbz(String nmgylPdbz) {
    this.nmgylPdbz = nmgylPdbz;
  }

  public String getYxDwmc() {
    return yxDwmc;
  }

  public void setYxDwmc(String yxDwmc) {
    this.yxDwmc = yxDwmc;
  }

  public String getDkjgDwmc() {
    return dkjgDwmc;
  }

  public void setDkjgDwmc(String dkjgDwmc) {
    this.dkjgDwmc = dkjgDwmc;
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
