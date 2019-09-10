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
public class CarInfoTransfer extends BaseEntity {
    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //信息主键编号
    private Long XXZJBH;
    //停车场出入口编号
    private String TCCCRKBH;
    //停车场编号
    private String TCCBH;
    //放行方式
    private String FXFS;
    //道闸方式
    private String DZFS;
    //过车编号
    private String GCBH;
    //车身颜色代码
    private String CSYSDM;
    //进出状态
    private String JCZT;
    //进出场名
    private String JCCM;
    //进场照片
    private String JC_ZP;
    //出场照片
    private String CC_ZP;
    //车牌颜色
    private String CPYS;
    //车辆类型
    private String JDCCLLXDM;
    //号牌号码
    private String JDCHPHM;
    //号牌种类代码
    private String JDCHPZLDM;
    //备注
    private String BZ;
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date GXSJ;
    //首次_信息入库时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date SC_XXRKSJ;
    //信息入库时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date XXRKSJ;

    //进入时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date JC_SJ;
    //出时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date CC_SJ;

    //进入时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date jcSj;
    //出时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date ccSj;

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

    public String getTCCCRKBH() {
        return TCCCRKBH;
    }

    public void setTCCCRKBH(String TCCCRKBH) {
        this.TCCCRKBH = TCCCRKBH;
    }

    public String getTCCBH() {
        return TCCBH;
    }

    public void setTCCBH(String TCCBH) {
        this.TCCBH = TCCBH;
    }

    public String getFXFS() {
        return FXFS;
    }

    public void setFXFS(String FXFS) {
        this.FXFS = FXFS;
    }

    public String getDZFS() {
        return DZFS;
    }

    public void setDZFS(String DZFS) {
        this.DZFS = DZFS;
    }

    public String getGCBH() {
        return GCBH;
    }

    public void setGCBH(String GCBH) {
        this.GCBH = GCBH;
    }

    public String getCSYSDM() {
        return CSYSDM;
    }

    public void setCSYSDM(String CSYSDM) {
        this.CSYSDM = CSYSDM;
    }

    public String getJCZT() {
        return JCZT;
    }

    public void setJCZT(String JCZT) {
        this.JCZT = JCZT;
    }

    public String getJCCM() {
        return JCCM;
    }

    public void setJCCM(String JCCM) {
        this.JCCM = JCCM;
    }

    public String getJC_ZP() {
        return JC_ZP;
    }

    public void setJC_ZP(String JC_ZP) {
        this.JC_ZP = JC_ZP;
    }

    public String getCC_ZP() {
        return CC_ZP;
    }

    public void setCC_ZP(String CC_ZP) {
        this.CC_ZP = CC_ZP;
    }

    public String getCPYS() {
        return CPYS;
    }

    public void setCPYS(String CPYS) {
        this.CPYS = CPYS;
    }

    public String getJDCCLLXDM() {
        return JDCCLLXDM;
    }

    public void setJDCCLLXDM(String JDCCLLXDM) {
        this.JDCCLLXDM = JDCCLLXDM;
    }

    public String getJDCHPHM() {
        return JDCHPHM;
    }

    public void setJDCHPHM(String JDCHPHM) {
        this.JDCHPHM = JDCHPHM;
    }

    public String getJDCHPZLDM() {
        return JDCHPZLDM;
    }

    public void setJDCHPZLDM(String JDCHPZLDM) {
        this.JDCHPZLDM = JDCHPZLDM;
    }

    public String getBZ() {
        return BZ;
    }

    public void setBZ(String BZ) {
        this.BZ = BZ;
    }

    public Date getGXSJ() {
        return GXSJ;
    }

    public void setGXSJ(Date GXSJ) {
        this.GXSJ = GXSJ;
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

    public Date getJC_SJ() {
        return JC_SJ;
    }

    public void setJC_SJ(Date JC_SJ) {
        this.JC_SJ = JC_SJ;
    }

    public Date getCC_SJ() {
        return CC_SJ;
    }

    public void setCC_SJ(Date CC_SJ) {
        this.CC_SJ = CC_SJ;
    }

    public Date getJcSj() {
        return jcSj;
    }

    public void setJcSj(Date jcSj) {
        this.jcSj = jcSj;
    }

    public Date getCcSj() {
        return ccSj;
    }

    public void setCcSj(Date ccSj) {
        this.ccSj = ccSj;
    }

    @Override
    public String toString() {
        return "CarInfoTransfer{" +
                "id=" + id +
                ", XXZJBH=" + XXZJBH +
                ", TCCCRKBH='" + TCCCRKBH + '\'' +
                ", TCCBH='" + TCCBH + '\'' +
                ", FXFS='" + FXFS + '\'' +
                ", DZFS='" + DZFS + '\'' +
                ", GCBH='" + GCBH + '\'' +
                ", CSYSDM='" + CSYSDM + '\'' +
                ", JCZT='" + JCZT + '\'' +
                ", JCCM='" + JCCM + '\'' +
                ", JC_ZP='" + JC_ZP + '\'' +
                ", CC_ZP='" + CC_ZP + '\'' +
                ", CPYS='" + CPYS + '\'' +
                ", JDCCLLXDM='" + JDCCLLXDM + '\'' +
                ", JDCHPHM='" + JDCHPHM + '\'' +
                ", JDCHPZLDM='" + JDCHPZLDM + '\'' +
                ", BZ='" + BZ + '\'' +
                ", GXSJ=" + GXSJ +
                ", SC_XXRKSJ=" + SC_XXRKSJ +
                ", XXRKSJ=" + XXRKSJ +
                ", JC_SJ=" + JC_SJ +
                ", CC_SJ=" + CC_SJ +
                '}';
    }
}
