package com.yaofei.springmvcmybatis.dto.es;

import java.io.Serializable;
import java.util.List;

/**
 * Created by phoenix on 2017/8/4.
 */
public class EsSearchResponse implements Serializable {
    private long totalHits;
    private List<String> jsonStringList;

    public long getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(long totalHits) {
        this.totalHits = totalHits;
    }

    public List<String> getJsonStringList() {
        return jsonStringList;
    }

    public void setJsonStringList(List<String> jsonStringList) {
        this.jsonStringList = jsonStringList;
    }

    public EsSearchResponse() {
    }

    public EsSearchResponse(long totalHits, List<String> jsonStringList) {
        this.totalHits = totalHits;
        this.jsonStringList = jsonStringList;
    }
}
