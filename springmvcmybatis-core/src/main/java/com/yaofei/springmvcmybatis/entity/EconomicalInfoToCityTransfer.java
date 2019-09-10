package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EconomicalInfoToCityTransfer extends BaseEntity {
  private static final long serialVersionUID = 1L;
  private long id;
  private long XXZJBH;
  private String dwbh;
  private String XM;
  private String GMSFHM;
  private String ZS_DZMC;
  private String GAJGMC;
  private String HPHM;
  private String LXDH;
  private String BQH;
  private String DDC_PP;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date KSSJ;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date JSSJ;
  private String CSYSDM;
  private String DDJH;
  private String CJH;
  private String CLSL;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date GM_RQ;
  private String BXGSMCDM;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date LRSJ;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date xxrksj;
  private String BXPZH;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date scrqzjsj;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date scrzyksj;

  private String zsDzmc;
  private String ddcPp;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date gmRq;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getXXZJBH() {
    return XXZJBH;
  }

  public void setXXZJBH(long XXZJBH) {
    this.XXZJBH = XXZJBH;
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

  public String getGMSFHM() {
    return GMSFHM;
  }

  public void setGMSFHM(String GMSFHM) {
    this.GMSFHM = GMSFHM;
  }

  public String getZS_DZMC() {
    return ZS_DZMC;
  }

  public void setZS_DZMC(String ZS_DZMC) {
    this.ZS_DZMC = ZS_DZMC;
  }

  public String getGAJGMC() {
    return GAJGMC;
  }

  public void setGAJGMC(String GAJGMC) {
    this.GAJGMC = GAJGMC;
  }

  public String getHPHM() {
    return HPHM;
  }

  public void setHPHM(String HPHM) {
    this.HPHM = HPHM;
  }

  public String getLXDH() {
    return LXDH;
  }

  public void setLXDH(String LXDH) {
    this.LXDH = LXDH;
  }

  public String getBQH() {
    return BQH;
  }

  public void setBQH(String BQH) {
    this.BQH = BQH;
  }

  public String getDDC_PP() {
    return DDC_PP;
  }

  public void setDDC_PP(String DDC_PP) {
    this.DDC_PP = DDC_PP;
  }

  public Date getKSSJ() {
    return KSSJ;
  }

  public void setKSSJ(Date KSSJ) {
    this.KSSJ = KSSJ;
  }

  public Date getJSSJ() {
    return JSSJ;
  }

  public void setJSSJ(Date JSSJ) {
    this.JSSJ = JSSJ;
  }

  public String getCSYSDM() {
    return CSYSDM;
  }

  public void setCSYSDM(String CSYSDM) {
    this.CSYSDM = CSYSDM;
  }

  public String getDDJH() {
    return DDJH;
  }

  public void setDDJH(String DDJH) {
    this.DDJH = DDJH;
  }

  public String getCJH() {
    return CJH;
  }

  public void setCJH(String CJH) {
    this.CJH = CJH;
  }

  public String getCLSL() {
    return CLSL;
  }

  public void setCLSL(String CLSL) {
    this.CLSL = CLSL;
  }

  public Date getGM_RQ() {
    return GM_RQ;
  }

  public void setGM_RQ(Date GM_RQ) {
    this.GM_RQ = GM_RQ;
  }

  public String getBXGSMCDM() {
    return BXGSMCDM;
  }

  public void setBXGSMCDM(String BXGSMCDM) {
    this.BXGSMCDM = BXGSMCDM;
  }

  public Date getLRSJ() {
    return LRSJ;
  }

  public void setLRSJ(Date LRSJ) {
    this.LRSJ = LRSJ;
  }

  public Date getXxrksj() {
    return xxrksj;
  }

  public void setXxrksj(Date xxrksj) {
    this.xxrksj = xxrksj;
  }

  public String getBXPZH() {
    return BXPZH;
  }

  public void setBXPZH(String BXPZH) {
    this.BXPZH = BXPZH;
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

  public String getZsDzmc() {
    return zsDzmc;
  }

  public void setZsDzmc(String zsDzmc) {
    this.zsDzmc = zsDzmc;
  }

  public String getDdcPp() {
    return ddcPp;
  }

  public void setDdcPp(String ddcPp) {
    this.ddcPp = ddcPp;
  }

  public Date getGmRq() {
    return gmRq;
  }

  public void setGmRq(Date gmRq) {
    this.gmRq = gmRq;
  }
}
