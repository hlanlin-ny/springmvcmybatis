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
public class StaticTrifficPeopleToCityTransfer extends BaseEntity {
    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //信息主键编号
    private Long XXZJBH;
    //姓名
    private String XM;
    //姓名汉语拼音
    private String XMHYPY;
    //性别代码
    private String XBDM;
    //性别
    private String XB;
    //公民身份号码
    private String GMSFHM;
    //单位名称
    private String DWMC;
    //机动车号牌号码
    private String JDCHPHM;
    //户籍地址名称
    private String HJDZ_DZMC;
    //居住地_地址名称
    private String JZD_DZMC;
    //联系电话
    private String LXDH;
    //从业时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date CYSJ;
    //工种
    private String GZ;
    //备注
    private String BZ;
    //导入主题描述
    private String DRZTMS;
    //导入时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date DRSJ;
    //导入外键批次号
    private String DRFK;
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
    //首次_信息入库时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date SC_XXRKSJ;
    //信息入库时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date XXRKSJ;

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

    public String getXMHYPY() {
        return XMHYPY;
    }

    public void setXMHYPY(String XMHYPY) {
        this.XMHYPY = XMHYPY;
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

    public String getGMSFHM() {
        return GMSFHM;
    }

    public void setGMSFHM(String GMSFHM) {
        this.GMSFHM = GMSFHM;
    }

    public String getDWMC() {
        return DWMC;
    }

    public void setDWMC(String DWMC) {
        this.DWMC = DWMC;
    }

    public String getJDCHPHM() {
        return JDCHPHM;
    }

    public void setJDCHPHM(String JDCHPHM) {
        this.JDCHPHM = JDCHPHM;
    }

    public String getHJDZ_DZMC() {
        return HJDZ_DZMC;
    }

    public void setHJDZ_DZMC(String HJDZ_DZMC) {
        this.HJDZ_DZMC = HJDZ_DZMC;
    }

    public String getJZD_DZMC() {
        return JZD_DZMC;
    }

    public void setJZD_DZMC(String JZD_DZMC) {
        this.JZD_DZMC = JZD_DZMC;
    }

    public String getLXDH() {
        return LXDH;
    }

    public void setLXDH(String LXDH) {
        this.LXDH = LXDH;
    }

    public Date getCYSJ() {
        return CYSJ;
    }

    public void setCYSJ(Date CYSJ) {
        this.CYSJ = CYSJ;
    }

    public String getGZ() {
        return GZ;
    }

    public void setGZ(String GZ) {
        this.GZ = GZ;
    }

    public String getBZ() {
        return BZ;
    }

    public void setBZ(String BZ) {
        this.BZ = BZ;
    }

    public String getDRZTMS() {
        return DRZTMS;
    }

    public void setDRZTMS(String DRZTMS) {
        this.DRZTMS = DRZTMS;
    }

    public Date getDRSJ() {
        return DRSJ;
    }

    public void setDRSJ(Date DRSJ) {
        this.DRSJ = DRSJ;
    }

    public String getDRFK() {
        return DRFK;
    }

    public void setDRFK(String DRFK) {
        this.DRFK = DRFK;
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


    @Override
    public String toString() {
        return "StaticTrifficPeopleToCityTransfer{" +
                "id=" + id +
                ", XXZJBH=" + XXZJBH +
                ", XM='" + XM + '\'' +
                ", XMHYPY='" + XMHYPY + '\'' +
                ", XBDM='" + XBDM + '\'' +
                ", XB='" + XB + '\'' +
                ", GMSFHM='" + GMSFHM + '\'' +
                ", DWMC='" + DWMC + '\'' +
                ", JDCHPHM='" + JDCHPHM + '\'' +
                ", HJDZ_DZMC='" + HJDZ_DZMC + '\'' +
                ", JZD_DZMC='" + JZD_DZMC + '\'' +
                ", LXDH='" + LXDH + '\'' +
                ", CYSJ=" + CYSJ +
                ", GZ='" + GZ + '\'' +
                ", BZ='" + BZ + '\'' +
                ", DRZTMS='" + DRZTMS + '\'' +
                ", DRSJ=" + DRSJ +
                ", DRFK='" + DRFK + '\'' +
                ", DJSJ=" + DJSJ +
                ", DJDW_GAJGJGDM=" + DJDW_GAJGJGDM +
                ", DJDW_GAJGMC='" + DJDW_GAJGMC + '\'' +
                ", DJR_XM='" + DJR_XM + '\'' +
                ", DJR_GMSFHM='" + DJR_GMSFHM + '\'' +
                ", DJR_LXDH='" + DJR_LXDH + '\'' +
                ", XXLY_XZQHDM='" + XXLY_XZQHDM + '\'' +
                ", SC_XXRKSJ=" + SC_XXRKSJ +
                ", XXRKSJ=" + XXRKSJ +
                '}';
    }
}
