package com.yaofei.springmvcmybatis.plugins.datatables.domain;

/**
 * 
 * @ClassName:Search.java
 * @Description:
 * @Since: 2016年8月28日
 */
public class Search {
	/**
	 * 当前列搜索的值
	 */
	private String value;
	/**
	 * 当前列搜索是否使用正则
	 */
	private Boolean regex;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getRegex() {
		return regex;
	}

	public void setRegex(Boolean regex) {
		this.regex = regex;
	}

	@Override
	public String toString() {
		return "Search{" +
				"value='" + value + '\'' +
				", regex=" + regex +
				'}';
	}
}
