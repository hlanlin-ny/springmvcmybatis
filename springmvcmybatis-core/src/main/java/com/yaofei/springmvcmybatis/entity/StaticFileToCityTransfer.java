package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 静态文件上传类
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-02-06 11:28:17
 */
public class StaticFileToCityTransfer extends BaseEntity {
    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //信息主键编号
    private Long XXZJBH;
    //姓名
    private String XM;
    //性别代码
    private String XBDM;
    //性别
    private String XB;
    //常用证件代码
    private String CYZJDM;
    //常用证件号码
    private String CYZJHM;
    //单位名称
    private String DWMC;
    //用户类型
    private String YHLX;
    //用户房号
    private String YHFH;
    //使用地址名称
    private String SYDZ_DZMC;
    //联系地址名称
    private String LXDZ_DZMC;
    //联系地址_邮政编码
    private String LXDZ_YZBM;
    //联系电话
    private String LXDH;
    //固定电话
    private String GDDH;
    //移动电话
    private String YDDH;
    //电子邮箱
    private String DZXX;
    //工作单位
    private String FWCS;
    //工作单位_联系电话
    private String GZDW_LXDH;
    //职务
    private String ZW;
    //户主_姓名
    private String HZ_XM;
    //与户主关系
    private String YHZGX;
    //客户类型
    private String KHLX;
    //银行账号
    private String YHZH;
    //原有_银行账号
    private String YY_YHZH;
    //最后缴费日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date ZHJFRQ;
    //登记日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date DJRQ;
    //备注
    private String BZ;
    //导入外键批次号
    private String DRFK;
    //导入时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date DRSJ;
    //导入主题描述
    private String DRZTMS;
    //登记时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date DJSJ;
    //登记单位_公安机关机构代码
    private Long DJDW_GAJGJGDM;
    //登记单位_公安机关名称
    private String DJDW_GAJGMC;
    //登记人_姓名
    private String DJR_XM;
    //登记人_公民身份号码
    private String DJR_GMSFHM;
    //登记人_联系电话
    private String DJR_LXDH;
    //信息来源_行政区划代码
    private String XXLY_XZQHDM;
    //信息入库时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date XXRKSJ;

    private String SJLY;

    private Date SCRQZJSJ;

    private Date SCRZYKSJ;

    private String USER_SERIAL;

    private String STREET;

    private String NEIGHBORHOOD;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getXXZJBH() {
        return XXZJBH;
    }

    public void setXXZJBH(Long XXZJBH) {
        this.XXZJBH = XXZJBH;
    }

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
    }

    public String getXBDM() {
        return XBDM;
    }

    public void setXBDM(String XBDM) {
        this.XBDM = XBDM;
    }

    public String getXB() {
        return XB;
    }

    public void setXB(String XB) {
        this.XB = XB;
    }

    public String getCYZJDM() {
        return CYZJDM;
    }

    public void setCYZJDM(String CYZJDM) {
        this.CYZJDM = CYZJDM;
    }

    public String getCYZJHM() {
        return CYZJHM;
    }

    public void setCYZJHM(String CYZJHM) {
        this.CYZJHM = CYZJHM;
    }

    public String getDWMC() {
        return DWMC;
    }

    public void setDWMC(String DWMC) {
        this.DWMC = DWMC;
    }

    public String getYHLX() {
        return YHLX;
    }

    public void setYHLX(String YHLX) {
        this.YHLX = YHLX;
    }

    public String getYHFH() {
        return YHFH;
    }

    public void setYHFH(String YHFH) {
        this.YHFH = YHFH;
    }

    public String getSYDZ_DZMC() {
        return SYDZ_DZMC;
    }

    public void setSYDZ_DZMC(String SYDZ_DZMC) {
        this.SYDZ_DZMC = SYDZ_DZMC;
    }

    public String getLXDZ_DZMC() {
        return LXDZ_DZMC;
    }

    public void setLXDZ_DZMC(String LXDZ_DZMC) {
        this.LXDZ_DZMC = LXDZ_DZMC;
    }

    public String getLXDZ_YZBM() {
        return LXDZ_YZBM;
    }

    public void setLXDZ_YZBM(String LXDZ_YZBM) {
        this.LXDZ_YZBM = LXDZ_YZBM;
    }

    public String getLXDH() {
        return LXDH;
    }

    public void setLXDH(String LXDH) {
        this.LXDH = LXDH;
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

    public String getDZXX() {
        return DZXX;
    }

    public void setDZXX(String DZXX) {
        this.DZXX = DZXX;
    }

    public String getFWCS() {
        return FWCS;
    }

    public void setFWCS(String FWCS) {
        this.FWCS = FWCS;
    }

    public String getGZDW_LXDH() {
        return GZDW_LXDH;
    }

    public void setGZDW_LXDH(String GZDW_LXDH) {
        this.GZDW_LXDH = GZDW_LXDH;
    }

    public String getZW() {
        return ZW;
    }

    public void setZW(String ZW) {
        this.ZW = ZW;
    }

    public String getHZ_XM() {
        return HZ_XM;
    }

    public void setHZ_XM(String HZ_XM) {
        this.HZ_XM = HZ_XM;
    }

    public String getYHZGX() {
        return YHZGX;
    }

    public void setYHZGX(String YHZGX) {
        this.YHZGX = YHZGX;
    }

    public String getKHLX() {
        return KHLX;
    }

    public void setKHLX(String KHLX) {
        this.KHLX = KHLX;
    }

    public String getYHZH() {
        return YHZH;
    }

    public void setYHZH(String YHZH) {
        this.YHZH = YHZH;
    }

    public String getYY_YHZH() {
        return YY_YHZH;
    }

    public void setYY_YHZH(String YY_YHZH) {
        this.YY_YHZH = YY_YHZH;
    }

    public Date getZHJFRQ() {
        return ZHJFRQ;
    }

    public void setZHJFRQ(Date ZHJFRQ) {
        this.ZHJFRQ = ZHJFRQ;
    }

    public Date getDJRQ() {
        return DJRQ;
    }

    public void setDJRQ(Date DJRQ) {
        this.DJRQ = DJRQ;
    }

    public String getBZ() {
        return BZ;
    }

    public void setBZ(String BZ) {
        this.BZ = BZ;
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

    public String getDRZTMS() {
        return DRZTMS;
    }

    public void setDRZTMS(String DRZTMS) {
        this.DRZTMS = DRZTMS;
    }

    public Date getDJSJ() {
        return DJSJ;
    }

    public void setDJSJ(Date DJSJ) {
        this.DJSJ = DJSJ;
    }

    public Long getDJDW_GAJGJGDM() {
        return DJDW_GAJGJGDM;
    }

    public void setDJDW_GAJGJGDM(Long DJDW_GAJGJGDM) {
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

    public String getSJLY() {
        return SJLY;
    }

    public StaticFileToCityTransfer setSJLY(String SJLY) {
        this.SJLY = SJLY;
        return this;
    }

    public Date getSCRQZJSJ() {
        return SCRQZJSJ;
    }

    public StaticFileToCityTransfer setSCRQZJSJ(Date SCRQZJSJ) {
        this.SCRQZJSJ = SCRQZJSJ;
        return this;
    }

    public Date getSCRZYKSJ() {
        return SCRZYKSJ;
    }

    public StaticFileToCityTransfer setSCRZYKSJ(Date SCRZYKSJ) {
        this.SCRZYKSJ = SCRZYKSJ;
        return this;
    }

    public String getUSER_SERIAL() {
        return USER_SERIAL;
    }

    public StaticFileToCityTransfer setUSER_SERIAL(String USER_SERIAL) {
        this.USER_SERIAL = USER_SERIAL;
        return this;
    }

    public String getSTREET() {
        return STREET;
    }

    public StaticFileToCityTransfer setSTREET(String STREET) {
        this.STREET = STREET;
        return this;
    }

    public String getNEIGHBORHOOD() {
        return NEIGHBORHOOD;
    }

    public StaticFileToCityTransfer setNEIGHBORHOOD(String NEIGHBORHOOD) {
        this.NEIGHBORHOOD = NEIGHBORHOOD;
        return this;
    }

    @Override
    public String toString() {
        return "StaticFileToCityTransfer{" +
                "id=" + id +
                ", XXZJBH=" + XXZJBH +
                ", XM='" + XM + '\'' +
                ", XBDM='" + XBDM + '\'' +
                ", XB='" + XB + '\'' +
                ", CYZJDM='" + CYZJDM + '\'' +
                ", CYZJHM='" + CYZJHM + '\'' +
                ", DWMC='" + DWMC + '\'' +
                ", YHLX='" + YHLX + '\'' +
                ", YHFH='" + YHFH + '\'' +
                ", SYDZ_DZMC='" + SYDZ_DZMC + '\'' +
                ", LXDZ_DZMC='" + LXDZ_DZMC + '\'' +
                ", LXDZ_YZBM='" + LXDZ_YZBM + '\'' +
                ", LXDH='" + LXDH + '\'' +
                ", GDDH='" + GDDH + '\'' +
                ", YDDH='" + YDDH + '\'' +
                ", DZXX='" + DZXX + '\'' +
                ", FWCS='" + FWCS + '\'' +
                ", GZDW_LXDH='" + GZDW_LXDH + '\'' +
                ", ZW='" + ZW + '\'' +
                ", HZ_XM='" + HZ_XM + '\'' +
                ", YHZGX='" + YHZGX + '\'' +
                ", KHLX='" + KHLX + '\'' +
                ", YHZH='" + YHZH + '\'' +
                ", YY_YHZH='" + YY_YHZH + '\'' +
                ", ZHJFRQ=" + ZHJFRQ +
                ", DJRQ=" + DJRQ +
                ", BZ='" + BZ + '\'' +
                ", DRFK='" + DRFK + '\'' +
                ", DRSJ=" + DRSJ +
                ", DRZTMS='" + DRZTMS + '\'' +
                ", DJSJ=" + DJSJ +
                ", DJDW_GAJGJGDM=" + DJDW_GAJGJGDM +
                ", DJDW_GAJGMC='" + DJDW_GAJGMC + '\'' +
                ", DJR_XM='" + DJR_XM + '\'' +
                ", DJR_GMSFHM='" + DJR_GMSFHM + '\'' +
                ", DJR_LXDH='" + DJR_LXDH + '\'' +
                ", XXLY_XZQHDM='" + XXLY_XZQHDM + '\'' +
                ", XXRKSJ=" + XXRKSJ +
                ", SJLY='" + SJLY + '\'' +
                ", SCRQZJSJ=" + SCRQZJSJ +
                ", SCRZYKSJ=" + SCRZYKSJ +
                ", USER_SERIAL='" + USER_SERIAL + '\'' +
                ", STREET='" + STREET + '\'' +
                ", NEIGHBORHOOD='" + NEIGHBORHOOD + '\'' +
                '}';
    }
}
