package com.haoyin.image.entity;

import java.io.Serializable;
import java.util.List;

public class Certificate implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	/** 公司名称 **/
	private String customerName;
	
	/** **/
	private String smlpc;
	
	/** 货品编号 **/
	private String itemNo;
	
	/** 数量 **/
	private String orderQty;
	
	/** 产品名称 **/
	private String productName;
	
	/** 号型 **/
	private String type;
	
	/** 内部码 **/
	private String internalCode;
	
	/** 货号 **/
	private String artNo;
	
	/** 等级 **/
	private String grade;
	
	/** 产品标准 **/
	private String productStandard;
	private List<String> productStandardList;
	
	/** 安全类别 **/
	private String securityCategory;
	
	/** 类别 **/
	private String category;
	
	/** 成份 **/
	private String fabricString;
	
	/** (面料/备注)集合 **/
	private List<Fabric> fabricList;
	
	/** 检测员 **/
	private String inspector;
	
	/** 产地 **/
	private String placeOfOrigin;
	
	/** 经销商 **/
	private String distributor;
	
	/** 地址 **/
	private String location;
	
	private String locationInfo;
	
	/** 电话 **/
	private String phone;
	
	/** 邮政编码 **/
	private String postalCode;
	
	/** 洗涤说明 **/
	private String washingInstructions;
	
	/** 颜色 **/
	private String colour;
	
	/** 款色 **/
	private String itemNoColour;
	
	/** 生产日期 **/
	private String dateOfManufacture;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getProductStandard() {
		return productStandard;
	}

	public void setProductStandard(String productStandard) {
		this.productStandard = productStandard;
	}

	public String getSecurityCategory() {
		return securityCategory;
	}

	public void setSecurityCategory(String securityCategory) {
		this.securityCategory = securityCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public List<Fabric> getFabricList() {
		return fabricList;
	}

	public void setFabricList(List<Fabric> fabricList) {
		this.fabricList = fabricList;
	}

	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public String getPlaceOfOrigin() {
		return placeOfOrigin;
	}

	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getWashingInstructions() {
		return washingInstructions;
	}

	public void setWashingInstructions(String washingInstructions) {
		this.washingInstructions = washingInstructions;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getItemNoColour() {
		return itemNoColour;
	}

	public void setItemNoColour(String itemNoColour) {
		this.itemNoColour = itemNoColour;
	}

	public String getLocationInfo() {
		return locationInfo;
	}

	public void setLocationInfo(String locationInfo) {
		this.locationInfo = locationInfo;
	}

	public String getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(String dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public String getArtNo() {
		return artNo;
	}

	public void setArtNo(String artNo) {
		this.artNo = artNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSmlpc() {
		return smlpc;
	}

	public void setSmlpc(String smlpc) {
		this.smlpc = smlpc;
	}

	public String getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}

	public String getFabricString() {
		return fabricString;
	}

	public void setFabricString(String fabricString) {
		this.fabricString = fabricString;
	}

	public List<String> getProductStandardList() {
		return productStandardList;
	}

	public void setProductStandardList(List<String> productStandardList) {
		this.productStandardList = productStandardList;
	}
	
	
	
	
}
