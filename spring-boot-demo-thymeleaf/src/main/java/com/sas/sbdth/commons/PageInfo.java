package com.sas.sbdth.commons;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 分页对象
 * 
 */
public class PageInfo {

	/**
	 * 当前页码，从0开始
	 */
	private int index;

	/**
	 * 每页记录数
	 */
	private int pageSize;

	/**
	 * 总记录数
	 */
	private long total;

	/**
	 * 构造方法
	 * 
	 * @param index
	 *            当前页码，从0开始
	 * @param pageSize
	 *            每页记录数
	 * @param total
	 *            总记录数
	 */
	public PageInfo(int index, int pageSize, int total) {
		this.index = index;
		this.pageSize = pageSize;
		this.total = total;
	}

	/**
	 * 获取总页数
	 * 
	 * @return 总页数
	 */
	public int getPageCount() {
		return (int) Math.ceil((double) total / (double) pageSize);
	}

	/**
	 * 是否有下一页
	 * 
	 * @return true,如果有下一页，否则为false
	 */
	public boolean isHasNext() {
		return index >= 1 && index < getPageCount() ;
	}

	/**
	 * 是否有上一页
	 * 
	 * @return true,如果有上一页，否则为false
	 */
	public boolean isHasPrev() {
		return index > 1 && index <= getPageCount();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
