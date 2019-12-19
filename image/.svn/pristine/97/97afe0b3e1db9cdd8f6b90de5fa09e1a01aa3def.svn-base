package com.haoyin.image.entity;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartItem extends Paginator implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;

	/** 商品id */
	private String itemId;
	
	/** 商品名称 **/
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
	
	/** 加入人 **/
	private Long userId;

	/** 总价 **/
	private String totalPrice;
	
	
	/** 购物车ID集合 **/
	private List<String> cartList;
	
	/**  **/
	private String size;
	
	/** 商品状态1:(价格牌文件),2:(合格证文件),3:(不需要上传文件) **/
	private String type;
	
	/** 供应商单价 **/
	private String supplierPrice;
	
	/** 供应商总价 **/
	private String supplierPriceTotal;
	



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	public String getRePrice() {
		return rePrice;
	}

	public void setRePrice(String rePrice) {
		this.rePrice = rePrice;
	}

	public String getTotalPrice() {
		if(number!=null && !number.equals("") && rePrice != null && !rePrice.equals("")){
			try{
				BigDecimal b1 = new BigDecimal(number);
				BigDecimal b2 = new BigDecimal(rePrice);
				totalPrice=b1.multiply(b2).setScale(3, BigDecimal.ROUND_HALF_UP).toString();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<String> getCartList() {
		return cartList;
	}

	public void setCartList(List<String> cartList) {
		this.cartList = cartList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	public String getSupplierPrice() {
		return supplierPrice;
	}

	public void setSupplierPrice(String supplierPrice) {
		this.supplierPrice = supplierPrice;
	}

	public String getSupplierPriceTotal() {
		if(number!=null && !number.equals("") && supplierPrice != null && !supplierPrice.equals("")){
			try{
				BigDecimal b1 = new BigDecimal(number);
				BigDecimal b2 = new BigDecimal(supplierPrice);
				supplierPriceTotal=b1.multiply(b2).setScale(3, BigDecimal.ROUND_HALF_UP).toString();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return supplierPriceTotal;
	}

	public void setSupplierPriceTotal(String supplierPriceTotal) {
		this.supplierPriceTotal = supplierPriceTotal;
	}


}
