package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 重点人员信息表
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-14 09:30:59
 */
public class ImportantPerson extends BaseEntity {
    private static final long serialVersionUID = 1L;

    //主键，自增ID
    private Long id;
    //区域id
    private Long areaId;
    //重点人员姓名
    private String name;
    //身份证号码
    private String idCardNo;
    //重点人员性别
    private String sex;
    //民族
    private String nation;
    //出生日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date bornTime;
    //地址
    private String address;
    //人员类别（涉恐人员、涉稳人员、在逃人员、涉毒人员、刑事犯罪前科人员、肇事肇祸精神病人、重点上访人员）
    private String personType;
    //布控人姓名
    private String controlName;
    //布控人单位
    private String controlPersonUnit;
    //布控单位
    private String controlUnit;
    //布控人手机号
    private String controlTel;
    //布控状态：已布控、未布控
    private  String status;
    //删除状态  0：正常   1：已删除
    private Boolean isDeleted;
    //创建人
    private String createdBy;
    //创建时间
    private Date createdTime;
    //创建人IP
    private String createdIp;
    //修改时间
    private Date modificationTime;
    //修改人
    private String modificationBy;
    //修改人IP
    private String modificationIp;
    //备注
    private String remark;

    /**
     * 设置：主键，自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：主键，自增ID
     */
    public Long getId() {
        return id;
    }


    /**
     * 设置：重点人员姓名
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：重点人员姓名
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：身份证号码
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }
    /**
     * 获取：身份证号码
     */
    public String getIdCardNo() {
        return idCardNo;
    }
    /**
     * 设置：重点人员性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * 获取：重点人员性别
     */
    public String getSex() {
        return sex;
    }
    /**
     * 设置：民族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }
    /**
     * 获取：民族
     */
    public String getNation() {
        return nation;
    }
    /**
     * 设置：出生日期
     */
    public void setBornTime(Date bornTime) {
        this.bornTime = bornTime;
    }
    /**
     * 获取：出生日期
     */
    public Date getBornTime() {
        return bornTime;
    }
    /**
     * 设置：地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * 获取：地址
     */
    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 设置：人员类别（涉恐人员、涉稳人员、在逃人员、涉毒人员、刑事犯罪前科人员、肇事肇祸精神病人、重点上访人员）
     */
    public void setPersonType(String personType) {
        this.personType = personType;
    }
    /**
     * 获取：人员类别（涉恐人员、涉稳人员、在逃人员、涉毒人员、刑事犯罪前科人员、肇事肇祸精神病人、重点上访人员）
     */
    public String getPersonType() {
        return personType;
    }

    public String getControlName() {
        return controlName;
    }

    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    public String getControlPersonUnit() {
        return controlPersonUnit;
    }

    public void setControlPersonUnit(String controlPersonUnit) {
        this.controlPersonUnit = controlPersonUnit;
    }

    public String getControlUnit() {
        return controlUnit;
    }

    public void setControlUnit(String controlUnit) {
        this.controlUnit = controlUnit;
    }

    public String getControlTel() {
        return controlTel;
    }

    public void setControlTel(String controlTel) {
        this.controlTel = controlTel;
    }

    /**
     * 设置：删除状态  0：正常   1：已删除
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    /**
     * 获取：删除状态  0：正常   1：已删除
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }
    /**
     * 设置：创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    /**
     * 获取：创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }
    /**
     * 设置：创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    /**
     * 获取：创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }
    /**
     * 设置：创建人IP
     */
    public void setCreatedIp(String createdIp) {
        this.createdIp = createdIp;
    }
    /**
     * 获取：创建人IP
     */
    public String getCreatedIp() {
        return createdIp;
    }
    /**
     * 设置：修改时间
     */
    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }
    /**
     * 获取：修改时间
     */
    public Date getModificationTime() {
        return modificationTime;
    }
    /**
     * 设置：修改人
     */
    public void setModificationBy(String modificationBy) {
        this.modificationBy = modificationBy;
    }
    /**
     * 获取：修改人
     */
    public String getModificationBy() {
        return modificationBy;
    }
    /**
     * 设置：修改人IP
     */
    public void setModificationIp(String modificationIp) {
        this.modificationIp = modificationIp;
    }
    /**
     * 获取：修改人IP
     */
    public String getModificationIp() {
        return modificationIp;
    }
    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 获取：区域id
     */
    public Long getAreaId() {return areaId;}
    /**
     * 设置：区域id
     */
    public void setAreaId(Long areaId) {this.areaId = areaId;}

    @Override
    public String toString() {
        return "ImportantPerson{" +
                "id=" + id +
                ", areaId=" + areaId +
                ", name='" + name + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", bornTime=" + bornTime +
                ", address='" + address + '\'' +
                ", personType='" + personType + '\'' +
                ", controlName='" + controlName + '\'' +
                ", controlUnit='" + controlUnit + '\'' +
                ", controlTel='" + controlTel + '\'' +
                ", isDeleted=" + isDeleted +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", createdIp='" + createdIp + '\'' +
                ", modificationTime=" + modificationTime +
                ", modificationBy='" + modificationBy + '\'' +
                ", modificationIp='" + modificationIp + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
