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
public class StaticHealthyToCityTransfer extends BaseEntity {
    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //信息主键编号
    private Long XXZJBH;
    //健康证明表单号
    private String JKZM_BDH;
    //个人编号
    private String GRBH;
    //姓名
    private String XM;
    //公民身份号码
    private String GMSFHM;
    //出生日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date CSRQ;
    //体检日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date TJRQ;
    //住所地址名称
    private String DZMC;
    //联系电话
    private String LXDH;
    //工作单位名称
    private String DWMC;
    //工作单位负责人_身份号码
    private String GZDWFZR_GMSFHM;
    //工作单位负责人_姓名
    private String GZDWFZR_XM;
    //工作单位负责人_联系电话
    private String GZDWFZR_LXDH;
    //行业类别代码
    private String HYLBDM;
    //登记日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date DJRQ;
    //签发单位
    private String QF_DWMC;
    //签发日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date QFRQ;
    //办证状态
    private String BZZT;
    //备注
    private String BZ;
    //信息来源描述
    private String XXLYMS;
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

    public String getJKZM_BDH() {
        return JKZM_BDH;
    }

    public void setJKZM_BDH(String JKZM_BDH) {
        this.JKZM_BDH = JKZM_BDH;
    }

    public String getGRBH() {
        return GRBH;
    }

    public void setGRBH(String GRBH) {
        this.GRBH = GRBH;
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

    public Date getCSRQ() {
        return CSRQ;
    }

    public void setCSRQ(Date CSRQ) {
        this.CSRQ = CSRQ;
    }

    public Date getTJRQ() {
        return TJRQ;
    }

    public void setTJRQ(Date TJRQ) {
        this.TJRQ = TJRQ;
    }

    public String getDZMC() {
        return DZMC;
    }

    public void setDZMC(String DZMC) {
        this.DZMC = DZMC;
    }

    public String getLXDH() {
        return LXDH;
    }

    public void setLXDH(String LXDH) {
        this.LXDH = LXDH;
    }

    public String getDWMC() {
        return DWMC;
    }

    public void setDWMC(String DWMC) {
        this.DWMC = DWMC;
    }

    public String getGZDWFZR_GMSFHM() {
        return GZDWFZR_GMSFHM;
    }

    public void setGZDWFZR_GMSFHM(String GZDWFZR_GMSFHM) {
        this.GZDWFZR_GMSFHM = GZDWFZR_GMSFHM;
    }

    public String getGZDWFZR_XM() {
        return GZDWFZR_XM;
    }

    public void setGZDWFZR_XM(String GZDWFZR_XM) {
        this.GZDWFZR_XM = GZDWFZR_XM;
    }

    public String getGZDWFZR_LXDH() {
        return GZDWFZR_LXDH;
    }

    public void setGZDWFZR_LXDH(String GZDWFZR_LXDH) {
        this.GZDWFZR_LXDH = GZDWFZR_LXDH;
    }

    public String getHYLBDM() {
        return HYLBDM;
    }

    public void setHYLBDM(String HYLBDM) {
        this.HYLBDM = HYLBDM;
    }

    public Date getDJRQ() {
        return DJRQ;
    }

    public void setDJRQ(Date DJRQ) {
        this.DJRQ = DJRQ;
    }

    public String getQF_DWMC() {
        return QF_DWMC;
    }

    public void setQF_DWMC(String QF_DWMC) {
        this.QF_DWMC = QF_DWMC;
    }

    public Date getQFRQ() {
        return QFRQ;
    }

    public void setQFRQ(Date QFRQ) {
        this.QFRQ = QFRQ;
    }

    public String getBZZT() {
        return BZZT;
    }

    public void setBZZT(String BZZT) {
        this.BZZT = BZZT;
    }

    public String getBZ() {
        return BZ;
    }

    public void setBZ(String BZ) {
        this.BZ = BZ;
    }

    public String getXXLYMS() {
        return XXLYMS;
    }

    public void setXXLYMS(String XXLYMS) {
        this.XXLYMS = XXLYMS;
    }

    public Date getXXRKSJ() {
        return XXRKSJ;
    }

    public void setXXRKSJ(Date XXRKSJ) {
        this.XXRKSJ = XXRKSJ;
    }

    @Override
    public String toString() {
        return "StaticHealthyToCityTransfer{" +
                "id=" + id +
                ", XXZJBH=" + XXZJBH +
                ", JKZM_BDH='" + JKZM_BDH + '\'' +
                ", GRBH='" + GRBH + '\'' +
                ", XM='" + XM + '\'' +
                ", GMSFHM='" + GMSFHM + '\'' +
                ", CSRQ=" + CSRQ +
                ", TJRQ=" + TJRQ +
                ", DZMC='" + DZMC + '\'' +
                ", LXDH='" + LXDH + '\'' +
                ", DWMC='" + DWMC + '\'' +
                ", GZDWFZR_GMSFHM='" + GZDWFZR_GMSFHM + '\'' +
                ", GZDWFZR_XM='" + GZDWFZR_XM + '\'' +
                ", GZDWFZR_LXDH='" + GZDWFZR_LXDH + '\'' +
                ", HYLBDM='" + HYLBDM + '\'' +
                ", DJRQ=" + DJRQ +
                ", QF_DWMC='" + QF_DWMC + '\'' +
                ", QFRQ=" + QFRQ +
                ", BZZT='" + BZZT + '\'' +
                ", BZ='" + BZ + '\'' +
                ", XXLYMS='" + XXLYMS + '\'' +
                ", XXRKSJ=" + XXRKSJ +
                '}';
    }
}
