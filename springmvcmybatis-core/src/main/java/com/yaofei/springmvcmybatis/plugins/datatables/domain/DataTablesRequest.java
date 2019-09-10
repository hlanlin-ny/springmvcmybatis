package com.yaofei.springmvcmybatis.plugins.datatables.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:DataTableRequest.java
 * @Description: DataTable请求对象
 * <p/>
 * /**
 * =============== Request Paramerters ================
 * draw: 1
 * columns[0][data]: id
 * columns[0][name]:
 * columns[0][searchable]: true
 * columns[0][orderable]: true
 * columns[0][search][value]:
 * columns[0][search][regex]: false
 * columns[1][data]: firstName
 * columns[1][name]:
 * columns[1][searchable]: true
 * columns[1][orderable]: true
 * columns[1][search][value]:
 * columns[1][search][regex]: false
 * columns[2][data]: lastName
 * columns[2][name]:
 * columns[2][searchable]: true
 * columns[2][orderable]: true
 * columns[2][search][value]:
 * columns[2][search][regex]: false
 * order[0][column]: 0  // 因为是二维的表格，因此只有一维需要排序，所以order的下标未0. 该属性表示第几列需要排序。
 * order[0][dir]: asc // 排序方式ASC | DESC
 * start: 0     //其实记录位置
 * length: 10   //页面显示数量
 * search[value]: // search输入框中的值
 * search[regex]: false
 * _: 1399345292266
 * =============== Request Paramerters ================
 * <p/>
 * Created by f_yao on 2017/2/11.
 */
public class DataTablesRequest {

    private final static long MAX_LENGTH = 100000;

    /**
     * 按列顺序存储列名
     */
    private Map<Integer, String> colMap = new HashMap<Integer, String>();

    /**
     * 第多少次请求
     */
    private int draw;
    ///**
    // * 列
    // */
    //private List<Column> columns;
    /**
     * 排序
     */
    private List<Order> order;

    /**
     * 开始于第多少条
     */
    private long start = 0;
    /**
     * 请求条数
     */
    private long length = 1000;
    ///**
    // * 全局搜索条件
    // */
    //private Search search;

    /**
     * 拓展搜索 键值
     */
    private Map<String, String> extraSearch;

    /**
     * 排序字符串
     *
     * @return
     */
    private String orderString;

    public long getPage() {
        if (length == 0) {
            return 1;
        }

        long page = start / length;
        // if(start%length!=0){
        page += 1;
        // }
        // System.out.println("请求的页码："+page);
        return page;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    //public List<Column> getColumns() {
    //    return columns;
    //}
    //
    //public void setColumns(List<Column> columns) {
    //    this.columns = columns;
    //}

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        if (length > MAX_LENGTH) {
            length = MAX_LENGTH;
        }
        this.length = length;
    }

    //public Search getSearch() {
    //    return search;
    //}
    //
    //public void setSearch(Search search) {
    //    this.search = search;
    //}

    public Map<Integer, String> getColMap() {
        return colMap;
    }

    public void setColMap(Map<Integer, String> colMap) {
        this.colMap = colMap;
    }

    public Map<String, String> getExtraSearch() {
        return extraSearch;
    }

    public void setExtraSearch(Map<String, String> extraSearch) {
        this.extraSearch = extraSearch;
    }

    public String getOrderString() {
        return orderString;
    }

    public void setOrderString(String orderString) {
        this.orderString = orderString;
    }

    /**
     * 获取拓展搜索的值
     *
     * @param key
     * @return
     */
    public String getExtraSearch(String key) {
        if (extraSearch == null) {
            return null;
        }
        return extraSearch.get(key);
    }

    @Override
    public String toString() {
        return "DataTablesRequest{" +
                "colMap=" + colMap +
                ", order=" + order +
                ", start=" + start +
                ", length=" + length +
                ", extraSearch=" + extraSearch +
                ", orderString='" + orderString + '\'' +
                '}';
    }
}