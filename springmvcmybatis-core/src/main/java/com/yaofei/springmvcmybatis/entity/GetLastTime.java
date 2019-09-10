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
public class GetLastTime extends BaseEntity {
    private static final long serialVersionUID = 1L;

    //id
    private Long id;
    //上次时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date SCHUSJ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSCHUSJ() {
        return SCHUSJ;
    }

    public void setSCHUSJ(Date SCHUSJ) {
        this.SCHUSJ = SCHUSJ;
    }

    @Override
    public String toString() {
        return "GetLastTime{" +
                "id=" + id +
                ", SCHUSJ=" + SCHUSJ +
                '}';
    }
}
