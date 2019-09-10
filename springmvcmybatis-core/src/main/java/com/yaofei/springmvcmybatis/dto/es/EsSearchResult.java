package com.yaofei.springmvcmybatis.dto.es;

import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;

import java.io.Serializable;
import java.util.List;

/**
 * Created by phoenix on 2017/8/4.
 */
public class EsSearchResult implements Serializable {
    private int pageIndex = 1;
    private long totalHits;
    private List<CommonIndex> hitDatas;

    public long getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(long totalHits) {
        this.totalHits = totalHits;
    }

    public List<CommonIndex> getHitDatas() {
        return hitDatas;
    }

    public void setHitDatas(List<CommonIndex> hitDatas) {
        this.hitDatas = hitDatas;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public EsSearchResult() {
    }

    public EsSearchResult(int pageIndex, long totalHits, List<CommonIndex> hitDatas) {
        this.pageIndex = pageIndex;
        this.totalHits = totalHits;
        this.hitDatas = hitDatas;
    }
}
