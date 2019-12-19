package com.haoyin.image.entity;


/**
 * 商品类别
 * @author admin
 *
 */
public class CommodityType {

	private Long id;
	
	/** 商品名称 **/
	private String commodityName;

	/** 大小 **/
	private String size;
	
	/** 单价 **/
	private String rePrice;
	
	/** 图片地址 **/
	private String imageUrl;
	
	/** 创建时间 **/
	private String createTime;
	
	/** 类型 **/
	private Integer type;
	
	/** 供应商单价 **/
	private String supplierPrice;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getRePrice() {
		return rePrice;
	}

	public void setRePrice(String rePrice) {
		this.rePrice = rePrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSupplierPrice() {
		return supplierPrice;
	}

	public void setSupplierPrice(String supplierPrice) {
		this.supplierPrice = supplierPrice;
	}
	
	
}
