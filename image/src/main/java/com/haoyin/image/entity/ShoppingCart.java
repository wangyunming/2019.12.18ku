package com.haoyin.image.entity;

import java.io.Serializable;

/**
 * 购物车
 * @author admin
 *
 */
public class ShoppingCart implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	/** 商品类型 **/
	private Long commodityTypeId;
	
	/** 数量 **/
	private Integer number;
	
	/** 文件地址 **/
	private String fileUrl;
	
	/** 加入人 **/
	private Long userId;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCommodityTypeId() {
		return commodityTypeId;
	}

	public void setCommodityTypeId(Long commodityTypeId) {
		this.commodityTypeId = commodityTypeId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


}
