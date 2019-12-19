package com.haoyin.image.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 订单条目下的文件详情
 * @author admin
 *
 */
public class OrderItemInfo implements Serializable{

	private static final long serialVersionUID = -2898872762472298778L;
	
	private Long id;
	
	/** 条目ID **/
	private Long itemId;
	
	private Long itemInfoId;
	
	/** 商品ID **/
	private Long commodityId;
	
	/** 商品名称 **/
	private String commodityName;
	
	/** 批次号 **/
	private String batch;
	
	/** 商品编号 **/
	private String commodityCode;
	
	/** 号型 **/
	private String spec;
	
	/** size **/
	private String size;
	
	/** 币种 **/
	private String currency;
	
	/** 颜色 **/
	private String color;
	
	/** 数量 **/
	private String number;
	
	/** 单价 **/
	private String rePrice;
	
	/** 总价 **/
	private String totalPrice;
	
	/** 商品类型1:(价格牌文件),2:(合格证文件),3:(不需要上传文件) **/
	private Integer type;
	
	/** 文件路径 **/
	private String fileUrl;
	
	/** 文件名称 **/
	private String fileName;
	
	/** 本身的数组 **/
	private List<OrderItemInfo> infoList;
	
	/**快递单号**/
	private String trackingNum;
	
	
	
	public String getTrackingNum() {
		return trackingNum;
	}

	public void setTrackingNum(String trackingNum) {
		this.trackingNum = trackingNum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
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

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
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

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public List<OrderItemInfo> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<OrderItemInfo> infoList) {
		this.infoList = infoList;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Long getItemInfoId() {
		return itemInfoId;
	}

	public void setItemInfoId(Long itemInfoId) {
		this.itemInfoId = itemInfoId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	} 
	

	
}
