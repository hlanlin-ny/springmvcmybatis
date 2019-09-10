package com.yaofei.springmvcmybatis.dto.es;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

/**
 * Created by phoenix on 2017/8/4.
 */
public class EsSearchRequest implements Serializable {
    private Integer datasourceType;
    private List<Long> intelligenceBusinessTypeIds;
    @NotBlank()
    @Length(min = 1, max = 250, message = "查询关键字必须在1至250个字符之间")
    private String keyword;
    private List<Integer> fileTypes;
    private int pageIndex;
    private String startTime;
    private String endTime;
    private int pageSize;
    private boolean preciseQuery = false;

    public Integer getDatasourceType() {
        return datasourceType;
    }

    public void setDatasourceType(Integer datasourceType) {
        this.datasourceType = datasourceType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Long> getIntelligenceBusinessTypeIds() {
        return intelligenceBusinessTypeIds;
    }

    public void setIntelligenceBusinessTypeIds(List<Long> intelligenceBusinessTypeIds) {
        this.intelligenceBusinessTypeIds = intelligenceBusinessTypeIds;
    }

    public List<Integer> getFileTypes() {
        return fileTypes;
    }

    public void setFileTypes(List<Integer> fileTypes) {
        this.fileTypes = fileTypes;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isPreciseQuery() {
        return preciseQuery;
    }

    public void setPreciseQuery(boolean preciseQuery) {
        this.preciseQuery = preciseQuery;
    }

    public EsSearchRequest() {
    }

    @Override
    public String toString() {
        return "SearchRequest{" +
                "datasourceType=" + datasourceType +
                ", intelligenceBusinessTypeIds=" + intelligenceBusinessTypeIds +
                ", keyword='" + keyword + '\'' +
                ", fileTypes='" + fileTypes + '\'' +
                ", pageIndex=" + pageIndex +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", pageSize=" + pageSize +
                '}';
    }
}
