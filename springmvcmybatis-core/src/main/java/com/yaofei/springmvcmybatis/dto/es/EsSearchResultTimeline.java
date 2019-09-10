package com.yaofei.springmvcmybatis.dto.es;

import java.io.Serializable;
import java.util.List;

/**
 * Created by phoenix on 2017/8/4.
 */
public class EsSearchResultTimeline implements Serializable {
    private int pageIndex = 1;
    private long totalHits;
    private List<CommonIndexDate> commonIndexDates;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(long totalHits) {
        this.totalHits = totalHits;
    }

    public List<CommonIndexDate> getCommonIndexDates() {
        return commonIndexDates;
    }

    public void setCommonIndexDates(List<CommonIndexDate> commonIndexDates) {
        this.commonIndexDates = commonIndexDates;
    }
}
