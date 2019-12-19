package com.haoyin.image.entity;

/**
 * 分页处理器
 * 
 * @author Summer
 *
 *         2016年5月7日
 */
public class Paginator implements java.io.Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	/** 默认页码 */
	private static final int DEFAULT_PAGE_NUMBER = 1;

	/** 默认页大小 */
	private static final int DEFAULT_PAGE_SIZE = 10;

	/** 每页最大纪录数 */
	private static final int MAX_PAGE_SIZE = Integer.MAX_VALUE;

	/** 页码 */
	private int pageNum = DEFAULT_PAGE_NUMBER;

	/** 每页大小 */
	private int pageSize = MAX_PAGE_SIZE;

	private String action;

	/**
	 * Default constructor
	 */
	public Paginator() {
	}

	public Paginator(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	/**
	 * @return the {@link #pageNum}
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum
	 *            the {@link #pageNum} to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = (pageNum > 0) ? pageNum : DEFAULT_PAGE_NUMBER;
	}

	/**
	 * @return the {@link #pageSize}
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the {@link #pageSize} to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = (pageSize > 0) ? pageSize : DEFAULT_PAGE_SIZE;
	}

	/**
	 * @return the {@link #action}
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the {@link #action} to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	public enum Direction {
		/** 升序 */
		ASC,
		/** 降序 */
		DESC
	}

}
