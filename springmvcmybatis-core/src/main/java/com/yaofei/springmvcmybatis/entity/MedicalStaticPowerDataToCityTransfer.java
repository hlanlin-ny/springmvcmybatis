package com.yaofei.springmvcmybatis.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.crypto.Data;
import java.util.Date;

public class MedicalStaticPowerDataToCityTransfer extends BaseEntity {
  private static final long serialVersionUID = 1L;

  private long ID;//ID
  private String GDDW;//供电单位
  private String HH;//户号
  private String HM;//户名
  @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00" )
  private Date SFSJ;//收费年月
  @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00" )
  private Date JFSJ;//缴费时间
  private String JFJE;//缴费金额
  @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00" )
  private Date RKSJ;//入库时间
  private String SJLY;//数据来源
  @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00" )
  private Date LYSJ;//来源时间

  public long getID() {
    return ID;
  }

  public void setID(long ID) {
    this.ID = ID;
  }

  public String getGDDW() {
    return GDDW;
  }

  public void setGDDW(String GDDW) {
    this.GDDW = GDDW;
  }

  public String getHH() {
    return HH;
  }

  public void setHH(String HH) {
    this.HH = HH;
  }

  public String getHM() {
    return HM;
  }

  public void setHM(String HM) {
    this.HM = HM;
  }

  public Date getSFSJ() {
    return SFSJ;
  }

  public void setSFSJ(Date SFSJ) {
    this.SFSJ = SFSJ;
  }

  public Date getJFSJ() {
    return JFSJ;
  }

  public void setJFSJ(Date JFSJ) {
    this.JFSJ = JFSJ;
  }

  public String getJFJE() {
    return JFJE;
  }

  public void setJFJE(String JFJE) {
    this.JFJE = JFJE;
  }

  public Date getRKSJ() {
    return RKSJ;
  }

  public void setRKSJ(Date RKSJ) {
    this.RKSJ = RKSJ;
  }

  public String getSJLY() {
    return SJLY;
  }

  public void setSJLY(String SJLY) {
    this.SJLY = SJLY;
  }

  public Date getLYSJ() {
    return LYSJ;
  }

  public void setLYSJ(Date LYSJ) {
    this.LYSJ = LYSJ;
  }
}
