package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ExpressInfoToCityTransfer extends BaseEntity {
  private static final long serialVersionUID = 1L;
  private long id;
  private long XXZJBH;
  private String SHHR_XM;
  private String shhr_XM;
  private String SHHR_XMHYPY;
  private String shhr_XMHYPY;
  private String SHHR_ZJHM;
  private String shhr_ZJHM;
  private String SHHR_LXDH;
  private String shhr_LXDH;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date SHSJ;
  private String SHHR_XZZ_XZQHDM;
  private String shhr_XZZ_XZQHDM;
  private String SHHR_XZZ_XZQHMC;
  private String SHHR_XZZ_DZMC;
  private String HW_WPMC;
  private String HWWBZ_JYQK;
  private String YF_JE;
  private String WLZX_DWMC;
  private String WLZGS_DWMC;
  private String shhr_XZZ_XZQHMC;
  private String shhr_XZZ_DZMC;
  private String hw_WPMC;
  private String hwwbz_JYQK;
  private String yf_JE;
  private String wlzx_DWMC;
  private String wlzgs_DWMC;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date FHSJ;
  private String FAHR_XM;
  private String FAHR_XMHYPY;
  private String FAHR_ZJHM;
  private String FAHR_LXDH;
  private String FAHR_XZZ_XZQHDM;
  private String FAHR_XZZ_XZQHMC;
  private String FAHR_XZZ_DZMC;
  private String YHFS_JYQK;
  private String THFS_JYQK;
  private String BZ;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date DJSJ;
  private String DJDW_GAJGJGDM;
  private String DJDW_GAJGMC;
  private String DJR_XM;
  private String DJR_GMSFHM;
  private String DJR_LXDH;
  private String XXLY_XZQHDM;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date SC_XXRKSJ;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date XXRKSJ;
  private String DRZTMS;
  private String DRFK;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date DRSJ;
  private String SJLY;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date SCRQZJSJ;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
  private Date SCRZYKSJ;
  private String WAYBILL_NUM;
  private String ORDER_CODE;
  private String YDH;

  public String getYDH() {
    return YDH;
  }

  public void setYDH(String YDH) {
    this.YDH = YDH;
  }

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

  public String getSHHR_XM() {
    return SHHR_XM;
  }

  public void setSHHR_XM(String SHHR_XM) {
    this.SHHR_XM = SHHR_XM;
  }

  public String getSHHR_XMHYPY() {
    return SHHR_XMHYPY;
  }

  public void setSHHR_XMHYPY(String SHHR_XMHYPY) {
    this.SHHR_XMHYPY = SHHR_XMHYPY;
  }

  public String getSHHR_ZJHM() {
    return SHHR_ZJHM;
  }

  public void setSHHR_ZJHM(String SHHR_ZJHM) {
    this.SHHR_ZJHM = SHHR_ZJHM;
  }

  public String getSHHR_LXDH() {
    return SHHR_LXDH;
  }

  public void setSHHR_LXDH(String SHHR_LXDH) {
    this.SHHR_LXDH = SHHR_LXDH;
  }

  public Date getSHSJ() {
    return SHSJ;
  }

  public void setSHSJ(Date SHSJ) {
    this.SHSJ = SHSJ;
  }

  public String getSHHR_XZZ_XZQHDM() {
    return SHHR_XZZ_XZQHDM;
  }

  public void setSHHR_XZZ_XZQHDM(String SHHR_XZZ_XZQHDM) {
    this.SHHR_XZZ_XZQHDM = SHHR_XZZ_XZQHDM;
  }

  public String getSHHR_XZZ_XZQHMC() {
    return SHHR_XZZ_XZQHMC;
  }

  public void setSHHR_XZZ_XZQHMC(String SHHR_XZZ_XZQHMC) {
    this.SHHR_XZZ_XZQHMC = SHHR_XZZ_XZQHMC;
  }

  public String getSHHR_XZZ_DZMC() {
    return SHHR_XZZ_DZMC;
  }

  public void setSHHR_XZZ_DZMC(String SHHR_XZZ_DZMC) {
    this.SHHR_XZZ_DZMC = SHHR_XZZ_DZMC;
  }

  public String getHW_WPMC() {
    return HW_WPMC;
  }

  public void setHW_WPMC(String HW_WPMC) {
    this.HW_WPMC = HW_WPMC;
  }

  public String getHWWBZ_JYQK() {
    return HWWBZ_JYQK;
  }

  public void setHWWBZ_JYQK(String HWWBZ_JYQK) {
    this.HWWBZ_JYQK = HWWBZ_JYQK;
  }

  public String getYF_JE() {
    return YF_JE;
  }

  public void setYF_JE(String YF_JE) {
    this.YF_JE = YF_JE;
  }

  public String getWLZX_DWMC() {
    return WLZX_DWMC;
  }

  public void setWLZX_DWMC(String WLZX_DWMC) {
    this.WLZX_DWMC = WLZX_DWMC;
  }

  public String getWLZGS_DWMC() {
    return WLZGS_DWMC;
  }

  public void setWLZGS_DWMC(String WLZGS_DWMC) {
    this.WLZGS_DWMC = WLZGS_DWMC;
  }

  public Date getFHSJ() {
    return FHSJ;
  }

  public void setFHSJ(Date FHSJ) {
    this.FHSJ = FHSJ;
  }

  public String getFAHR_XM() {
    return FAHR_XM;
  }

  public void setFAHR_XM(String FAHR_XM) {
    this.FAHR_XM = FAHR_XM;
  }

  public String getFAHR_XMHYPY() {
    return FAHR_XMHYPY;
  }

  public void setFAHR_XMHYPY(String FAHR_XMHYPY) {
    this.FAHR_XMHYPY = FAHR_XMHYPY;
  }

  public String getFAHR_ZJHM() {
    return FAHR_ZJHM;
  }

  public void setFAHR_ZJHM(String FAHR_ZJHM) {
    this.FAHR_ZJHM = FAHR_ZJHM;
  }

  public String getFAHR_LXDH() {
    return FAHR_LXDH;
  }

  public void setFAHR_LXDH(String FAHR_LXDH) {
    this.FAHR_LXDH = FAHR_LXDH;
  }

  public String getFAHR_XZZ_XZQHDM() {
    return FAHR_XZZ_XZQHDM;
  }

  public void setFAHR_XZZ_XZQHDM(String FAHR_XZZ_XZQHDM) {
    this.FAHR_XZZ_XZQHDM = FAHR_XZZ_XZQHDM;
  }

  public String getFAHR_XZZ_XZQHMC() {
    return FAHR_XZZ_XZQHMC;
  }

  public void setFAHR_XZZ_XZQHMC(String FAHR_XZZ_XZQHMC) {
    this.FAHR_XZZ_XZQHMC = FAHR_XZZ_XZQHMC;
  }

  public String getFAHR_XZZ_DZMC() {
    return FAHR_XZZ_DZMC;
  }

  public void setFAHR_XZZ_DZMC(String FAHR_XZZ_DZMC) {
    this.FAHR_XZZ_DZMC = FAHR_XZZ_DZMC;
  }

  public String getYHFS_JYQK() {
    return YHFS_JYQK;
  }

  public void setYHFS_JYQK(String YHFS_JYQK) {
    this.YHFS_JYQK = YHFS_JYQK;
  }

  public String getTHFS_JYQK() {
    return THFS_JYQK;
  }

  public void setTHFS_JYQK(String THFS_JYQK) {
    this.THFS_JYQK = THFS_JYQK;
  }

  public String getBZ() {
    return BZ;
  }

  public void setBZ(String BZ) {
    this.BZ = BZ;
  }

  public Date getDJSJ() {
    return DJSJ;
  }

  public void setDJSJ(Date DJSJ) {
    this.DJSJ = DJSJ;
  }

  public String getDJDW_GAJGJGDM() {
    return DJDW_GAJGJGDM;
  }

  public void setDJDW_GAJGJGDM(String DJDW_GAJGJGDM) {
    this.DJDW_GAJGJGDM = DJDW_GAJGJGDM;
  }

  public String getDJDW_GAJGMC() {
    return DJDW_GAJGMC;
  }

  public void setDJDW_GAJGMC(String DJDW_GAJGMC) {
    this.DJDW_GAJGMC = DJDW_GAJGMC;
  }

  public String getDJR_XM() {
    return DJR_XM;
  }

  public void setDJR_XM(String DJR_XM) {
    this.DJR_XM = DJR_XM;
  }

  public String getDJR_GMSFHM() {
    return DJR_GMSFHM;
  }

  public void setDJR_GMSFHM(String DJR_GMSFHM) {
    this.DJR_GMSFHM = DJR_GMSFHM;
  }

  public String getDJR_LXDH() {
    return DJR_LXDH;
  }

  public void setDJR_LXDH(String DJR_LXDH) {
    this.DJR_LXDH = DJR_LXDH;
  }

  public String getXXLY_XZQHDM() {
    return XXLY_XZQHDM;
  }

  public void setXXLY_XZQHDM(String XXLY_XZQHDM) {
    this.XXLY_XZQHDM = XXLY_XZQHDM;
  }

  public Date getSC_XXRKSJ() {
    return SC_XXRKSJ;
  }

  public void setSC_XXRKSJ(Date SC_XXRKSJ) {
    this.SC_XXRKSJ = SC_XXRKSJ;
  }

  public Date getXXRKSJ() {
    return XXRKSJ;
  }

  public void setXXRKSJ(Date XXRKSJ) {
    this.XXRKSJ = XXRKSJ;
  }

  public String getDRZTMS() {
    return DRZTMS;
  }

  public void setDRZTMS(String DRZTMS) {
    this.DRZTMS = DRZTMS;
  }

  public String getDRFK() {
    return DRFK;
  }

  public void setDRFK(String DRFK) {
    this.DRFK = DRFK;
  }

  public Date getDRSJ() {
    return DRSJ;
  }

  public void setDRSJ(Date DRSJ) {
    this.DRSJ = DRSJ;
  }

  public String getSJLY() {
    return SJLY;
  }

  public void setSJLY(String SJLY) {
    this.SJLY = SJLY;
  }

  public Date getSCRQZJSJ() {
    return SCRQZJSJ;
  }

  public void setSCRQZJSJ(Date SCRQZJSJ) {
    this.SCRQZJSJ = SCRQZJSJ;
  }

  public Date getSCRZYKSJ() {
    return SCRZYKSJ;
  }

  public void setSCRZYKSJ(Date SCRZYKSJ) {
    this.SCRZYKSJ = SCRZYKSJ;
  }

  public String getWAYBILL_NUM() {
    return WAYBILL_NUM;
  }

  public void setWAYBILL_NUM(String WAYBILL_NUM) {
    this.WAYBILL_NUM = WAYBILL_NUM;
  }

  public String getORDER_CODE() {
    return ORDER_CODE;
  }

  public void setORDER_CODE(String ORDER_CODE) {
    this.ORDER_CODE = ORDER_CODE;
  }
}
