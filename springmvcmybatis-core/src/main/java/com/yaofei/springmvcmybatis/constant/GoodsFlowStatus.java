package com.yaofei.springmvcmybatis.constant;

/**
 * Created by phoenix on 2017/4/22.
 */
public enum GoodsFlowStatus {

    INSTOCK("设备入库", 1), OUTSTOCK("设备出库", 2), MARKER("设备贴签", 3), SETUP("设备安装", 4), SERVICE("设备服务", 5);

    private String name;
    private int index;

    private GoodsFlowStatus(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
