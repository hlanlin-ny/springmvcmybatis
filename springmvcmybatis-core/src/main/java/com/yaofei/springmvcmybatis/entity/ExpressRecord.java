package com.yaofei.springmvcmybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;

import java.util.Date;


/**
 * 快递记录表
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
public class ExpressRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    //主键，自增ID
    private Long id;
    //行政区划编号
    private Long areaId;
    //情报业务分类ID
    private Long businessTypeId;
    //文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）
    private Integer fileType;
    //文件上传路径
    private String detailsUrl;
    //收集时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date collectTime;
    //插入es的时候用的es的索引名称
    private String esIndexName;
    //所属用户编号
    private Long userId;
    //发件人身份证号码
    private String senderIdCardNum;
    //发件人姓名
    private String senderName;
    //发件人电话
    private String senderPhone;
    //收件人姓名
    private String receiverName;
    //收件人电话
    private String receiverPhone;
    //收件人地址
    private String receiverAddress;
    //货物名称
    private String goodsName;
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
     * 设置：行政区划编号
     */
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取：行政区划编号
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * 设置：情报业务分类ID
     */
    public void setBusinessTypeId(Long businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    /**
     * 获取：情报业务分类ID
     */
    public Long getBusinessTypeId() {
        return businessTypeId;
    }

    /**
     * 设置：文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）
     */
    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    /**
     * 获取：文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）
     */
    public Integer getFileType() {
        return fileType;
    }

    /**
     * 设置：文件上传路径
     */
    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }

    /**
     * 获取：文件上传路径
     */
    public String getDetailsUrl() {
        return detailsUrl;
    }

    /**
     * 设置：收集时间
     */
    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    /**
     * 获取：收集时间
     */
    public Date getCollectTime() {
        return collectTime;
    }

    /**
     * 设置：插入es的时候用的es的索引名称
     */
    public void setEsIndexName(String esIndexName) {
        this.esIndexName = esIndexName;
    }

    /**
     * 获取：插入es的时候用的es的索引名称
     */
    public String getEsIndexName() {
        return esIndexName;
    }

    /**
     * 设置：所属用户编号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取：所属用户编号
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置：发件人身份证号码
     */
    public void setSenderIdCardNum(String senderIdCardNum) {
        this.senderIdCardNum = senderIdCardNum;
    }

    /**
     * 获取：发件人身份证号码
     */
    public String getSenderIdCardNum() {
        return senderIdCardNum;
    }

    /**
     * 设置：发件人姓名
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    /**
     * 获取：发件人姓名
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * 设置：发件人电话
     */
    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    /**
     * 获取：发件人电话
     */
    public String getSenderPhone() {
        return senderPhone;
    }

    /**
     * 设置：收件人姓名
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取：收件人姓名
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 设置：收件人电话
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * 获取：收件人电话
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * 设置：收件人地址
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * 获取：收件人地址
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * 设置：货物名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取：货物名称
     */
    public String getGoodsName() {
        return goodsName;
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

    private Date collectTimeBegin;
    private Date collectTimeEnd;

    public Date getCollectTimeBegin() {
        return collectTimeBegin;
    }

    public void setCollectTimeBegin(Date collectTimeBegin) {
        this.collectTimeBegin = collectTimeBegin;
    }

    public Date getCollectTimeEnd() {
        return collectTimeEnd;
    }

    public void setCollectTimeEnd(Date collectTimeEnd) {
        this.collectTimeEnd = collectTimeEnd;
    }

    //上报网点
    private String branchName;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return "发件人姓名='" + senderName + '\'' +
                ", 发件人身份证号='" + senderIdCardNum + '\'' +
                ", 发件人手机='" + senderPhone + '\'' +
                ", 收件人姓名='" + receiverName + '\'' +
                ", 收件人手机='" + receiverPhone + '\'' +
                ", 收件人地址='" + receiverAddress + '\'' +
                ", 货物名称='" + goodsName + '\'' +
                ", 备注='" + remark + '\'' +
                ", 上报时间='" + DateTimeUtil.formatDateTime(collectTime)  + '\'';
    }
}
