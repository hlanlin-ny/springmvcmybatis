package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.elasticsearch.search.DocValueFormat;

import java.util.Date;


/**
 * 静态文件上传类
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-02-06 11:28:17
 */
public class StaticWaterToCityTransfer extends BaseEntity {
    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //信息主键编号
    private Long XXZJBH;
    //帐户ID
    private String ZHID;
    //帐户编号
    private String ZHBM;
    //帐户名称
    private String ZHMC;
    //用户地址
    private String YHDZ_DZMC;
    //用户磁卡编号
    private String YHCKBH;
    //姓名
    private String XM;
    //性别
    private String XB;
    //公民身份号码
    private String GMSFHM;
    //实收金额
    private double SHJE;
    //实交金额
    private double SJJE;
    //开票日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date KPRQ;
    //收款日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date SKRQ;
    //每月用水量
    private int MYYSL;
    //收款单位
    private String SKDW;
    //收款方式
    private String SKFS;
    //开户银行
    private String YX_DWMC;
    //银行帐号
    private String YHZH;
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
    //备注
    private String BZ;

    public StaticWaterToCityTransfer() {
    }

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

    public String getZHID() {
        return ZHID;
    }

    public void setZHID(String ZHID) {
        this.ZHID = ZHID;
    }

    public String getZHBM() {
        return ZHBM;
    }

    public void setZHBM(String ZHBM) {
        this.ZHBM = ZHBM;
    }

    public String getZHMC() {
        return ZHMC;
    }

    public void setZHMC(String ZHMC) {
        this.ZHMC = ZHMC;
    }

    public String getYHDZ_DZMC() {
        return YHDZ_DZMC;
    }

    public void setYHDZ_DZMC(String YHDZ_DZMC) {
        this.YHDZ_DZMC = YHDZ_DZMC;
    }

    public String getYHCKBH() {
        return YHCKBH;
    }

    public void setYHCKBH(String YHCKBH) {
        this.YHCKBH = YHCKBH;
    }

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
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

    public double getSHJE() {
        return SHJE;
    }

    public void setSHJE(double SHJE) {
        this.SHJE = SHJE;
    }

    public double getSJJE() {
        return SJJE;
    }

    public void setSJJE(double SJJE) {
        this.SJJE = SJJE;
    }

    public Date getKPRQ() {
        return KPRQ;
    }

    public void setKPRQ(Date KPRQ) {
        this.KPRQ = KPRQ;
    }

    public Date getSKRQ() {
        return SKRQ;
    }

    public void setSKRQ(Date SKRQ) {
        this.SKRQ = SKRQ;
    }

    public int getMYYSL() {
        return MYYSL;
    }

    public void setMYYSL(int MYYSL) {
        this.MYYSL = MYYSL;
    }

    public String getSKDW() {
        return SKDW;
    }

    public void setSKDW(String SKDW) {
        this.SKDW = SKDW;
    }

    public String getSKFS() {
        return SKFS;
    }

    public void setSKFS(String SKFS) {
        this.SKFS = SKFS;
    }

    public String getYX_DWMC() {
        return YX_DWMC;
    }

    public void setYX_DWMC(String YX_DWMC) {
        this.YX_DWMC = YX_DWMC;
    }

    public String getYHZH() {
        return YHZH;
    }

    public void setYHZH(String YHZH) {
        this.YHZH = YHZH;
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

    public String getBZ() {
        return BZ;
    }

    public void setBZ(String BZ) {
        this.BZ = BZ;
    }

    @Override
    public String toString() {
        return "StaticWaterToCityTransfer{" +
                "id=" + id +
                ", XXZJBH='" + XXZJBH + '\'' +
                ", ZHID='" + ZHID + '\'' +
                ", ZHBM='" + ZHBM + '\'' +
                ", ZHMC='" + ZHMC + '\'' +
                ", YHDZ_DZMC='" + YHDZ_DZMC + '\'' +
                ", YHCKBH='" + YHCKBH + '\'' +
                ", XM='" + XM + '\'' +
                ", XB='" + XB + '\'' +
                ", GMSFHM='" + GMSFHM + '\'' +
                ", SHJE=" + SHJE +
                ", SJJE=" + SJJE +
                ", KPRQ=" + KPRQ +
                ", SKRQ=" + SKRQ +
                ", MYYSL='" + MYYSL + '\'' +
                ", SKDW='" + SKDW + '\'' +
                ", SKFS='" + SKFS + '\'' +
                ", YX_DWMC='" + YX_DWMC + '\'' +
                ", YHZH='" + YHZH + '\'' +
                ", DJSJ=" + DJSJ +
                ", DJDW_GAJGJGDM='" + DJDW_GAJGJGDM + '\'' +
                ", DJDW_GAJGMC='" + DJDW_GAJGMC + '\'' +
                ", DJR_XM='" + DJR_XM + '\'' +
                ", DJR_GMSFHM='" + DJR_GMSFHM + '\'' +
                ", DJR_LXDH='" + DJR_LXDH + '\'' +
                ", XXLY_XZQHDM='" + XXLY_XZQHDM + '\'' +
                ", SC_XXRKSJ=" + SC_XXRKSJ +
                ", XXRKSJ=" + XXRKSJ +
                ", BZ='" + BZ + '\'' +
                '}';
    }
}
