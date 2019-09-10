package com.yaofei.springmvcmybatis.dto.es.index;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by phoenix on 2017/8/2.
 */
public class CommonIndex extends BaseIndex implements Comparable {
    //行政区划编号
    private Long areaId;
    //行政区划名字
    private String areaName;
    //情报业务类型ID
    private Long businessTypeId;
    //情报业务类型名称
    private String businessTypeName;
    //名称
    private String informationProvider;
    //地址
    private String providerAddress;
    //所属公安机关
    private String policeOffice;
    //联系人
    private String contactPerson;
    //联系电话
    private String contactPhone;
    //紧急联系人
    private String emergencyContactPerson;
    //紧急联系电话
    private String emergencyContactPhone;
    //文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）
    private Integer fileType;
    ////标题
    //private String title;

    //姓名1
    private String name1;
    //身份证号码1
    private String idCardNum1;
    //地点1
    private String location1;
    //时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date dtTime;
    //姓名1
    private String name2;
    //身份证号码1
    private String idCardNum2;
    //地点2
    private String location2;

    //详细内容
    private String content;

    //详情链接地址
    private String url;
    //收集时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date collectTime;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date createdTime;
    //自动提示
    private String suggest;



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

    public Long getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(Long businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
    }

    public String getInformationProvider() {
        return informationProvider;
    }

    public void setInformationProvider(String informationProvider) {
        this.informationProvider = informationProvider;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public String getPoliceOffice() {
        return policeOffice;
    }

    public void setPoliceOffice(String policeOffice) {
        this.policeOffice = policeOffice;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getEmergencyContactPerson() {
        return emergencyContactPerson;
    }

    public void setEmergencyContactPerson(String emergencyContactPerson) {
        this.emergencyContactPerson = emergencyContactPerson;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    //public String getTitle() {
    //    return title;
    //}
    //
    //public void setTitle(String title) {
    //    this.title = title;
    //}


    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getIdCardNum1() {
        return idCardNum1;
    }

    public void setIdCardNum1(String idCardNum1) {
        this.idCardNum1 = idCardNum1;
    }

    public String getLocation1() {
        return location1;
    }

    public void setLocation1(String location1) {
        this.location1 = location1;
    }

    public Date getDtTime() {
        return dtTime;
    }

    public void setDtTime(Date dtTime) {
        this.dtTime = dtTime;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getIdCardNum2() {
        return idCardNum2;
    }

    public void setIdCardNum2(String idCardNum2) {
        this.idCardNum2 = idCardNum2;
    }

    public String getLocation2() {
        return location2;
    }

    public void setLocation2(String location2) {
        this.location2 = location2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }


    @Override
    public int compareTo(Object o) {
        CommonIndex sdto = (CommonIndex)o;
       Long oterBusinessTypeId  = sdto.getBusinessTypeId();
        if(oterBusinessTypeId==null){
            return -1;
        }
        if(this.getBusinessTypeId()==null){
            return 1;
        }
        // note: enum-type's comparation depend on types' list order of enum method
        // so, if compared property is enum-type ,then its comparationfollow ObjEnum.objType order
        return this.getBusinessTypeId().compareTo(oterBusinessTypeId);
    }
}
