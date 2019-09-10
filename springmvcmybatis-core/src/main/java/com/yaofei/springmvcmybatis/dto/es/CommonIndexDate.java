package com.yaofei.springmvcmybatis.dto.es;

import com.yaofei.springmvcmybatis.dto.es.index.CommonIndexTimeline;

import java.util.List;

/**
 * Created by phoenix on 2017/9/22.
 */
public class CommonIndexDate {
    private String date;
    private String dateBackgroundColor;
    private List<CommonIndexTimeline> hitDatas;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateBackgroundColor() {
        return dateBackgroundColor;
    }

    public void setDateBackgroundColor(String dateBackgroundColor) {
        this.dateBackgroundColor = dateBackgroundColor;
    }

    public List<CommonIndexTimeline> getHitDatas() {
        return hitDatas;
    }

    public void setHitDatas(List<CommonIndexTimeline> hitDatas) {
        this.hitDatas = hitDatas;
    }
}
