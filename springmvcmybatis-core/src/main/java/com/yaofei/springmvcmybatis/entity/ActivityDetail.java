package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by 87796 on 2017/9/20.
 */
public class ActivityDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //发生时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date occurTime;
    //行政区划编号
    private Long areaId;
    //行政区划名字
    private String areaName;
    //发生详细地址
    private String providerAddress;
    //消息归属
    private String informationProvider;
    //所属公安机关
    private String policeOffice;
    //活动相关信息
    private String activityInformation;
    //登记姓名
    private String registerName;
    //登记身份证号码
    private String registerIDcardNo;
    //登记出生日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date registerBornDate;
    //动态信息类别
    private String dynamicInformationType;
    //动态信息提供单位
    private String dynamicInformationProvider;
    /*预警详情*/
    //预警接收单位
    private String acceptProvider;
    //预警级别
    private String warningLevel;
    //预警时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date warningTime;
    //关联id
    private Long relateImportantId;
    //关联被布控人员id
    private Long relateControlId;
    //签收状态
    private String claimStatus;
    //删除状态  0：正常   1：已删除
    private Boolean isDeleted;
    //创建人
    private String createdBy;
    //创建人IP
    private String createdIp;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date createdTime;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date modificationTime;
    //修改人
    private String modificationBy;
    //修改人IP
    private String modificationIp;
    //备注
    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public String getInformationProvider() {
        return informationProvider;
    }

    public void setInformationProvider(String informationProvider) {
        this.informationProvider = informationProvider;
    }

    public String getPoliceOffice() {
        return policeOffice;
    }

    public void setPoliceOffice(String policeOffice) {
        this.policeOffice = policeOffice;
    }

    public String getActivityInformation() {
        return activityInformation;
    }

    public void setActivityInformation(String activityInformation) {
        this.activityInformation = activityInformation;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getRegisterIDcardNo() {
        return registerIDcardNo;
    }

    public void setRegisterIDcardNo(String registerIDcardNo) {
        this.registerIDcardNo = registerIDcardNo;
    }

    public Date getRegisterBornDate() {
        return registerBornDate;
    }

    public void setRegisterBornDate(Date registerBornDate) {
        this.registerBornDate = registerBornDate;
    }

    public String getDynamicInformationType() {
        return dynamicInformationType;
    }

    public void setDynamicInformationType(String dynamicInformationType) {
        this.dynamicInformationType = dynamicInformationType;
    }

    public String getDynamicInformationProvider() {
        return dynamicInformationProvider;
    }

    public void setDynamicInformationProvider(String dynamicInformationProvider) {
        this.dynamicInformationProvider = dynamicInformationProvider;
    }

    public String getAcceptProvider() {
        return acceptProvider;
    }

    public void setAcceptProvider(String acceptProvider) {
        this.acceptProvider = acceptProvider;
    }

    public String getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(String warningLevel) {
        this.warningLevel = warningLevel;
    }

    public Date getWarningTime() {
        return warningTime;
    }

    public void setWarningTime(Date warningTime) {
        this.warningTime = warningTime;
    }

    public Long getRelateImportantId() {
        return relateImportantId;
    }

    public void setRelateImportantId(Long relateImportantId) {
        this.relateImportantId = relateImportantId;
    }

    public Long getRelateControlId() {
        return relateControlId;
    }

    public void setRelateControlId(Long relateControlId) {
        this.relateControlId = relateControlId;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedIp() {
        return createdIp;
    }

    public void setCreatedIp(String createdIp) {
        this.createdIp = createdIp;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getModificationBy() {
        return modificationBy;
    }

    public void setModificationBy(String modificationBy) {
        this.modificationBy = modificationBy;
    }

    public String getModificationIp() {
        return modificationIp;
    }

    public void setModificationIp(String modificationIp) {
        this.modificationIp = modificationIp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ActivityDetail{" +
                "id=" + id +
                ", occurTime=" + occurTime +
                ", areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", providerAddress='" + providerAddress + '\'' +
                ", informationProvider='" + informationProvider + '\'' +
                ", policeOffice='" + policeOffice + '\'' +
                ", activityInformation='" + activityInformation + '\'' +
                ", registerName='" + registerName + '\'' +
                ", registerIDcardNo='" + registerIDcardNo + '\'' +
                ", registerBornDate=" + registerBornDate +
                ", dynamicInformationType='" + dynamicInformationType + '\'' +
                ", dynamicInformationProvider='" + dynamicInformationProvider + '\'' +
                ", acceptProvider='" + acceptProvider + '\'' +
                ", warningLevel='" + warningLevel + '\'' +
                ", warningTime=" + warningTime +
                ", relateImportantId=" + relateImportantId +
                ", relateControlId=" + relateControlId +
                ", isDeleted=" + isDeleted +
                ", createdBy='" + createdBy + '\'' +
                ", createdIp='" + createdIp + '\'' +
                ", createdTime=" + createdTime +
                ", modificationTime=" + modificationTime +
                ", modificationBy='" + modificationBy + '\'' +
                ", modificationIp='" + modificationIp + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
