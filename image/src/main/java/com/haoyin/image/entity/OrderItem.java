package com.haoyin.image.entity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 订单条目表
 * @author admin
 *
 */
public class OrderItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2898872762472298778L;
	
	/** 条目ID **/
	private Long itemId;
	
	/** 订单ID */
	private Long orderId;

	/** 商品ID */
	private Long commodityId;
	
	/** 商品名称 **/
	private String commodityName;
	
	/** 数量 **/
	private String number;
	
	/** 单价 **/
	private String rePrice;
	
	/** 文件名称 **/
	private String fileName;
	
	/** 文件地址 **/
	private String fileUrl;

	/** 总价 **/
	private String totalPrice;
	
	/** 商品类型 **/
	private Integer type;
	

	/**添加人id*/
	private Long userId;

	/**图片地址*/
	private String   imageUrl;

	
	/** 商品大小 **/
	private String size;
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRePrice() {
		return rePrice;
	}

	public void setRePrice(String rePrice) {
		this.rePrice = rePrice;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}


	public String getTotalPrice() {
		Double quantity = 0.00;
		if(number != null && !number.equals("")) {
			quantity = Double.parseDouble(number);
		}
		Double jiage = 0.00;
		if(rePrice != null && !rePrice.equals("")) {
			jiage = Double.parseDouble(rePrice);
		}
		totalPrice = new BigDecimal(quantity*jiage).setScale(3, BigDecimal.ROUND_HALF_UP)+"";
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	
	
	

}
