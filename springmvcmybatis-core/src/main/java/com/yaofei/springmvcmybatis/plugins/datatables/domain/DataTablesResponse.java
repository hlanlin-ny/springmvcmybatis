package com.yaofei.springmvcmybatis.plugins.datatables.domain;

import java.util.List;

/**
 * @param <T>
 * @ClassName:DataTable.java
 * @Description: Jq DateTable 插件适配类
 * @Since: 2016年8月28日
 */
public class DataTablesResponse<T> {

    /**
     * 必要。上面提到了，Datatables发送的draw是多少那么服务器就返回多少。
     * 这里注意，作者出于安全的考虑，强烈要求把这个转换为整形，即数字后再返回，而不是纯粹的接受然后返回，这是 为了防止跨站脚本（XSS）攻击。
     */
    private int draw; // 表示请求次数 空时写0，其他时候，加1 (datatables传给你的是什么，你返回的就是什么)
    /**
     * 必要。即没有过滤的记录数（数据库里总共记录数）
     */
    private long recordsTotal; //总条数
    /**
     * 必要。过滤后的记录数（如果有接收到前台的过滤条件，则返回的是过滤后的记录数）
     */
    private long recordsFiltered; // 过滤后的总记录数
    /**
     * 必要。表中中需要显示的数据。这是一个对象数组，也可以只是数组， 区别在于 纯数组前台就不需要用 columns绑定数据，会自动按照顺序去显示
     * ，而对象数组则需要使用 columns绑定数据才能正常显示。 注意这个 data的名称可以由 ajaxOption 的
     * ajax.dataSrcOption 控制
     */
    private List<T> data; //data 与datatales 加载的“dataSrc"对应

    private String error = "";

    public DataTablesResponse(int draw, Long recordsTotal, List<T> data) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsTotal;
        this.data = data;
    }

    public DataTablesResponse(int draw, Long recordsTotal, Long recordsFiltered, List<T> data) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }


    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getDraw() {
        return this.draw;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsTotal() {
        return this.recordsTotal;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public long getRecordsFiltered() {
        return this.recordsFiltered;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return this.data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    /** -------------可选参数-----------------*/

    ///**
    // * 自动绑定到 tr节点上
    // */
    //private String dt_rowId;
    //
    ///**
    // * 自动把这个类名添加到 tr
    // */
    //private String dt_rowClass;
    //
    ///**
    // * 使用 jQuery.data() 方法把数据绑定到row中，方便之后用来检索（比如加入一个点击事件）
    // */
    //private Object dt_rowData;
    //
    ///**
    // * 自动绑定数据到 tr上，使用 jQuery.attr() 方法，对象的键用作属性，值用作属性的值。 注意这个 需要 Datatables
    // * 1.10.5+的版本才支持
    // */
    //private Object dt_rowAttr;

    /*-------------可选参数-----------------*/

    @Override
    public String toString() {
        return "DataTablesResponse{" +
                "draw=" + draw +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
