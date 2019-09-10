package com.yaofei.springmvcmybatis.entity;

/**
 * Created by 87796 on 2017/8/21.
 */
public class IntelligenceStatistics extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /*
    信息员ID
     */
    private String intelligenceOfficerId;
    /*
    信息员姓名
     */
    private String name;

    private Boolean isOfficer;

    private String  idNumbers;

    /*
    一般级别的情报条数
     */
    private int sum1;

    /*
    重要级别的情报条数
     */
    private int sum2;

    /*
    非常重要级别的情报条数
     */
    private int sum3;

    /*
    情报总条数
     */
    private int counts;


    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public int getSum3() {
        return sum3;
    }

    public void setSum3(int sum3) {
        this.sum3 = sum3;
    }

    public int getSum2() {
        return sum2;
    }

    public void setSum2(int sum2) {
        this.sum2 = sum2;
    }

    public int getSum1() {
        return sum1;
    }

    public void setSum1(int sum1) {
        this.sum1 = sum1;
    }

    public Boolean getIsOfficer() {
        return isOfficer;
    }

    public void setIsOfficer(Boolean isOfficer) {
        this.isOfficer = isOfficer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntelligenceOfficerId() {
        return intelligenceOfficerId;
    }

    public void setIntelligenceOfficerId(String intelligenceOfficerId) {
        this.intelligenceOfficerId = intelligenceOfficerId;
    }

    public String getIdNumbers() {
        return idNumbers;
    }

    public void setIdNumbers(String idNumbers) {
        this.idNumbers = idNumbers;
    }
}
