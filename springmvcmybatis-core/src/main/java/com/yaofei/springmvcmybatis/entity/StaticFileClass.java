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
public class StaticFileClass extends BaseEntity {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //行政区划编号
    private Long areaId;
    //情报业务分类ID
    private Long businessTypeId;
    //文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）
    private Integer fileType;
    //收集时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date collectTime;
    //插入es的时候用的es的索引名称
    private String esIndexName;
    //姓名
    private String name;
    //性别
    private String sex;
    //身份证号码
    private String idCardNo;
    //联系电话
    private String tel;
    //户籍地址
    private String address;
    //民族
    private String nation;
    //职业
    private String profession;
    //详情
    private String detail;
    //详情路径
    private String detailsUrl;
    //备注
    private String remark;
    //删除状态  0：正常   1：已删除
    private Boolean isDeleted;
    //创建时间
    private Date createdTime;
    //创建人
    private String createdBy;
    //创建IP
    private String createdIp;
    //修改时间
    private Date modificationTime;
    //修改人
    private String modificationBy;
    //修改人IP
    private String modificationIp;
    //未上传数据量
    private Long wsc;
    //已上传数据量
    private Long ysc;
    //未上传数据总量
    private Long wsczl;
    //已上传数据总量
    private Long ysczl;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取：性别
     */
    public String getSex() {
        return sex;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 设置：户籍地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：户籍地址
     */
    public String getAddress() {
        return address;
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
     * 设置：职业
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * 获取：职业
     */
    public String getProfession() {
        return profession;
    }

    /**
     * 设置：详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取：详情
     */
    public String getDetail() {
        return detail;
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
     * 设置：创建IP
     */
    public void setCreatedIp(String createdIp) {
        this.createdIp = createdIp;
    }

    /**
     * 获取：创建IP
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

    public String getDetailsUrl() {
        return detailsUrl;
    }

    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }

    public Long getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(Long businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public String getEsIndexName() {
        return esIndexName;
    }

    public void setEsIndexName(String esIndexName) {
        this.esIndexName = esIndexName;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getWsc() {
        return wsc;
    }

    public void setWsc(Long wsc) {
        this.wsc = wsc;
    }

    public Long getYsc() {
        return ysc;
    }

    public void setYsc(Long ysc) {
        this.ysc = ysc;
    }

    public Long getWsczl() {
        return wsczl;
    }

    public void setWsczl(Long wsczl) {
        this.wsczl = wsczl;
    }

    public Long getYsczl() {
        return ysczl;
    }

    public void setYsczl(Long ysczl) {
        this.ysczl = ysczl;
    }

    @Override
    public String toString() {
        return "StaticFileClass{" +
                "姓名='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                ", 身份证号码='" + idCardNo + '\'' +
                ", 电话='" + tel + '\'' +
                ", 户籍地址='" + address + '\'' +
                ", 民族='" + nation + '\'' +
                ", 职业='" + profession + '\'' +
                ", 详情='" + detail + '\'' +
                '}';
    }
}
