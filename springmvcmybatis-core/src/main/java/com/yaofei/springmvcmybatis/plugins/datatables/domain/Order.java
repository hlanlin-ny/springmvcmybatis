package com.yaofei.springmvcmybatis.plugins.datatables.domain;

/**
 * 
 * @ClassName:Order.java
 * @Description:  排序信息
 * @Since: 2016年8月28日
 */
public class Order {
	/**
	 * 按哪一列
	 */
	private int column;
	/**
	 * 排序方式
	 */
	private String dir;

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "Order{" +
				"column=" + column +
				", dir='" + dir + '\'' +
				'}';
	}
}
