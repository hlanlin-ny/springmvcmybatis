package com.yaofei.springmvcmybatis.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MedicalStaticPowerToCityTransfer extends BaseEntity {
 private static final long serialVersionUID = 1L;

 private long ID;
 private long XXZJBH;
 private String KH_WPBZH;  //	卡号
 private String XM;  //姓名
 private String GDDH;  //固定电话
 private String YDDH;  //移动电话
 private String XB;  //性别
 private String GMSFHM;  //	公民身份号码
 private String YDLBDM;  //	用电类别代码
 private String YDLB;  //用电类别
 private String HYFLDM;  //	行业类别代码
 private String KHZTDM;  //	客户状态代码
 private String KHZT;  //客户状态
 private String KHLBDM;  //	客户类别代码
 private String KHLB;  //客户类别
 private String YDDZ;  //用电地址
 private String FDDZ;  //法定地址
 private String XZZ_XZQHDM;  //		现住址区划代码
 private String XZZ_XZQHMC;  //		现住址区划名称
 private String XZZ_DZMC;  //	现住址_地址名称
 @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00" )
 private Date JFRQ;  //		缴费日期
 @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00" )
 private Date QSRQ;  //		起始日期
 @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00" )
 private Date JSRQ;  //		结束日期
 private String DWMC;  //单位名称
 private String DWZCDZ_DZMC;  //		单位注册地址名称
 private String SYDZ_DZMC;  //	使用地址
 private String LXR_XM;  //	联系人_姓名
 private String LXR_LXDH;  //	联系人_联系电话
 private String FDDBR_XM;  //	法定代表人_姓名
 private String FDDBR_GMSFHM;  //		法定代表人_身份证明号码
 private String FDDBR_YDDH;  //		法人_移动电话
 private String DJSJ;  //登记时间
 private String DJDW_GAJGJGDM;  //		登记单位_公安机关机构代码
 private String DJDW_GAJGMC;  //		登记单位_公安机关名称
 private String DJR_XM;  //	登记人_姓名
 private String DJR_GMSFHM;  //		登记人_公民身份号码
 private String DJR_LXDH;  //	登记人_联系电话
 private String XXLY_XZQHDM;  //		信息来源_行政区划代码
 @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00" )
 private Date XXRKSJ;  //			信息入库时间
 private String BZ;  //备注

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getXXZJBH() {
        return XXZJBH;
    }

    public void setXXZJBH(long XXZJBH) {
        this.XXZJBH = XXZJBH;
    }

    public String getKH_WPBZH() {
        return KH_WPBZH;
    }

    public void setKH_WPBZH(String KH_WPBZH) {
        this.KH_WPBZH = KH_WPBZH;
    }

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
    }

    public String getGDDH() {
        return GDDH;
    }

    public void setGDDH(String GDDH) {
        this.GDDH = GDDH;
    }

    public String getYDDH() {
        return YDDH;
    }

    public void setYDDH(String YDDH) {
        this.YDDH = YDDH;
    }

    public String getXB() {
        return XB;
    }

    public void setXB(String XB) {
        this.XB = XB;
    }

    public String getGMSFHM() {
        return GMSFHM;
    }

    public void setGMSFHM(String GMSFHM) {
        this.GMSFHM = GMSFHM;
    }

    public String getYDLBDM() {
        return YDLBDM;
    }

    public void setYDLBDM(String YDLBDM) {
        this.YDLBDM = YDLBDM;
    }

    public String getYDLB() {
        return YDLB;
    }

    public void setYDLB(String YDLB) {
        this.YDLB = YDLB;
    }

    public String getHYFLDM() {
        return HYFLDM;
    }

    public void setHYFLDM(String HYFLDM) {
        this.HYFLDM = HYFLDM;
    }

    public String getKHZTDM() {
        return KHZTDM;
    }

    public void setKHZTDM(String KHZTDM) {
        this.KHZTDM = KHZTDM;
    }

    public String getKHZT() {
        return KHZT;
    }

    public void setKHZT(String KHZT) {
        this.KHZT = KHZT;
    }

    public String getKHLBDM() {
        return KHLBDM;
    }

    public void setKHLBDM(String KHLBDM) {
        this.KHLBDM = KHLBDM;
    }

    public String getKHLB() {
        return KHLB;
    }

    public void setKHLB(String KHLB) {
        this.KHLB = KHLB;
    }

    public String getYDDZ() {
        return YDDZ;
    }

    public void setYDDZ(String YDDZ) {
        this.YDDZ = YDDZ;
    }

    public String getFDDZ() {
        return FDDZ;
    }

    public void setFDDZ(String FDDZ) {
        this.FDDZ = FDDZ;
    }

    public String getXZZ_XZQHDM() {
        return XZZ_XZQHDM;
    }

    public void setXZZ_XZQHDM(String XZZ_XZQHDM) {
        this.XZZ_XZQHDM = XZZ_XZQHDM;
    }

    public String getXZZ_XZQHMC() {
        return XZZ_XZQHMC;
    }

    public void setXZZ_XZQHMC(String XZZ_XZQHMC) {
        this.XZZ_XZQHMC = XZZ_XZQHMC;
    }

    public String getXZZ_DZMC() {
        return XZZ_DZMC;
    }

    public void setXZZ_DZMC(String XZZ_DZMC) {
        this.XZZ_DZMC = XZZ_DZMC;
    }

    public Date getJFRQ() {
        return JFRQ;
    }

    public void setJFRQ(Date JFRQ) {
        this.JFRQ = JFRQ;
    }

    public Date getQSRQ() {
        return QSRQ;
    }

    public void setQSRQ(Date QSRQ) {
        this.QSRQ = QSRQ;
    }

    public Date getJSRQ() {
        return JSRQ;
    }

    public void setJSRQ(Date JSRQ) {
        this.JSRQ = JSRQ;
    }

    public String getDWMC() {
        return DWMC;
    }

    public void setDWMC(String DWMC) {
        this.DWMC = DWMC;
    }

    public String getDWZCDZ_DZMC() {
        return DWZCDZ_DZMC;
    }

    public void setDWZCDZ_DZMC(String DWZCDZ_DZMC) {
        this.DWZCDZ_DZMC = DWZCDZ_DZMC;
    }

    public String getSYDZ_DZMC() {
        return SYDZ_DZMC;
    }

    public void setSYDZ_DZMC(String SYDZ_DZMC) {
        this.SYDZ_DZMC = SYDZ_DZMC;
    }

    public String getLXR_XM() {
        return LXR_XM;
    }

    public void setLXR_XM(String LXR_XM) {
        this.LXR_XM = LXR_XM;
    }

    public String getLXR_LXDH() {
        return LXR_LXDH;
    }

    public void setLXR_LXDH(String LXR_LXDH) {
        this.LXR_LXDH = LXR_LXDH;
    }

    public String getFDDBR_XM() {
        return FDDBR_XM;
    }

    public void setFDDBR_XM(String FDDBR_XM) {
        this.FDDBR_XM = FDDBR_XM;
    }

    public String getFDDBR_GMSFHM() {
        return FDDBR_GMSFHM;
    }

    public void setFDDBR_GMSFHM(String FDDBR_GMSFHM) {
        this.FDDBR_GMSFHM = FDDBR_GMSFHM;
    }

    public String getFDDBR_YDDH() {
        return FDDBR_YDDH;
    }

    public void setFDDBR_YDDH(String FDDBR_YDDH) {
        this.FDDBR_YDDH = FDDBR_YDDH;
    }

    public String getDJSJ() {
        return DJSJ;
    }

    public void setDJSJ(String DJSJ) {
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

    public Date getXXRKSJ() {
        return XXRKSJ;
    }

    public void setXXRKSJ(Date XXRKSJ) {
        this.XXRKSJ = XXRKSJ;
    }

    public String getBZ() {
        return BZ;
    }

    public void setBZ(String BZ) {
        this.BZ = BZ;
    }
}
