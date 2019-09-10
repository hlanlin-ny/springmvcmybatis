package com.yaofei.springmvcmybatis.dto.exprotsearchresult;

import java.util.List;

/**
 * Created by phoenix on 2017/9/18.
 */
public class Track {
    private String name;
    private List<TrackDetail> details;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TrackDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TrackDetail> details) {
        this.details = details;
    }
}
