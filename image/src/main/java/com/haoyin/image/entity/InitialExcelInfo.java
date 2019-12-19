package com.haoyin.image.entity;

import java.io.Serializable;
import java.util.List;

/**
 * initial 价格牌吊牌和合格证详情
 * @author admin
 *
 */
public class InitialExcelInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**  **/
	private Long id;
	
	/** 文件ID **/
	private String excelInfoId;
	
	/** 公司名称 **/
	private String customerName;

	/** 编号 **/
	private String itemNo;
	
	/** **/
	private String smlpc;
	
	/**颜色 **/
	private String colour;
	
	/** 大小 **/
	private String size;
	
	/** 币种 **/
	private String currency;
	
	/** 单价 **/
	private String unitPrice;
	
	/** SET PRICE **/
	private String setPrice;
	
	/** **/
	private String orderQty;
	
	/** **/
	private String barCode;
	
	/** **/
	private String Description;
	

	/** 产品名称 **/
	private String productName;
	
	/** 号型 **/
	private String type;

	/** **/
	private String artNo;
	
	/** 内部码 **/
	private String internalCode;
	
	/** 等级 **/
	private String grade;
	
	/** 产品标准 **/
	private String productStandard;
	private List<String> productStandardList;
	
	/** 安全类别 **/
	private String securityCategory;
	
	/** 类别 **/
	private String category;
	
	/** 成份(面料) **/
	private String fabricString;
	
	/** 面料1 **/
	private String fabricNameOne;
	/**面料材质1**/
	private String fabricInfoOne;
	/** 面料备注1 **/
	private String fabricRemarksOne;
	
	/** 面料2 **/
	private String fabricNameTwo;
	/**面料材质2**/
	private String fabricInfoTwo;
	/** 面料备注2 **/
	private String fabricRemarksTwo;
	
	/** 面料3 **/
	private String fabricNameThree;
	/**面料材质3**/
	private String fabricInfoThree;
	/** 面料备注3 **/
	private String fabricRemarksThree;
	
	/** 面料4 **/
	private String fabricNameFour;
	/**面料材质4**/
	private String fabricInfoFour;
	/** 面料备注4 **/
	private String fabricRemarksFour;
	
	/** 面料5 **/
	private String fabricNameFive;
	/**面料材质5**/
	private String fabricInfoFive;
	/** 面料备注5 **/
	private String fabricRemarksFive;
	
	/** 面料6 **/
	private String fabricNameSix;
	/**面料材质6**/
	private String fabricInfoSix;
	/** 面料备注6 **/
	private String fabricRemarksSix;
	
	/** 面料7 **/
	private String fabricNameSeven;
	/**面料材质7**/
	private String fabricInfoSeven;
	/** 面料备注7 **/
	private String fabricRemarksSeven;
	
	/** 面料8 **/
	private String fabricNameEight;
	/**面料材质8**/
	private String fabricInfoEight;
	/** 面料备注8 **/
	private String fabricRemarksEight;
	
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
	
	/** 详细地址 **/
	private String locationInfo;
	
	/** 电话 **/
	private String phone;
	
	/** 邮政编码 **/
	private String postalCode;
	
	/** 洗涤说明 **/
	private String washingInstructions;
		
	
	/** 生产日期 **/
	private String dateOfManufacture;
	
	
	/** 分识字段 **/
	private String ItemNoColourCurrency;

	/** 款色 **/
	private String itemNoColour;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getSmlpc() {
		return smlpc;
	}

	public void setSmlpc(String smlpc) {
		this.smlpc = smlpc;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
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

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
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

	public String getFabricNameOne() {
		return fabricNameOne;
	}

	public void setFabricNameOne(String fabricNameOne) {
		this.fabricNameOne = fabricNameOne;
	}

	public String getFabricInfoOne() {
		return fabricInfoOne;
	}

	public void setFabricInfoOne(String fabricInfoOne) {
		this.fabricInfoOne = fabricInfoOne;
	}

	public String getFabricRemarksOne() {
		return fabricRemarksOne;
	}

	public void setFabricRemarksOne(String fabricRemarksOne) {
		this.fabricRemarksOne = fabricRemarksOne;
	}

	public String getFabricNameTwo() {
		return fabricNameTwo;
	}

	public void setFabricNameTwo(String fabricNameTwo) {
		this.fabricNameTwo = fabricNameTwo;
	}

	public String getFabricInfoTwo() {
		return fabricInfoTwo;
	}

	public void setFabricInfoTwo(String fabricInfoTwo) {
		this.fabricInfoTwo = fabricInfoTwo;
	}

	public String getFabricRemarksTwo() {
		return fabricRemarksTwo;
	}

	public void setFabricRemarksTwo(String fabricRemarksTwo) {
		this.fabricRemarksTwo = fabricRemarksTwo;
	}

	public String getFabricNameThree() {
		return fabricNameThree;
	}

	public void setFabricNameThree(String fabricNameThree) {
		this.fabricNameThree = fabricNameThree;
	}

	public String getFabricInfoThree() {
		return fabricInfoThree;
	}

	public void setFabricInfoThree(String fabricInfoThree) {
		this.fabricInfoThree = fabricInfoThree;
	}

	public String getFabricRemarksThree() {
		return fabricRemarksThree;
	}

	public void setFabricRemarksThree(String fabricRemarksThree) {
		this.fabricRemarksThree = fabricRemarksThree;
	}

	public String getFabricNameFour() {
		return fabricNameFour;
	}

	public void setFabricNameFour(String fabricNameFour) {
		this.fabricNameFour = fabricNameFour;
	}

	public String getFabricInfoFour() {
		return fabricInfoFour;
	}

	public void setFabricInfoFour(String fabricInfoFour) {
		this.fabricInfoFour = fabricInfoFour;
	}

	public String getFabricRemarksFour() {
		return fabricRemarksFour;
	}

	public void setFabricRemarksFour(String fabricRemarksFour) {
		this.fabricRemarksFour = fabricRemarksFour;
	}

	public String getFabricNameFive() {
		return fabricNameFive;
	}

	public void setFabricNameFive(String fabricNameFive) {
		this.fabricNameFive = fabricNameFive;
	}

	public String getFabricInfoFive() {
		return fabricInfoFive;
	}

	public void setFabricInfoFive(String fabricInfoFive) {
		this.fabricInfoFive = fabricInfoFive;
	}

	public String getFabricRemarksFive() {
		return fabricRemarksFive;
	}

	public void setFabricRemarksFive(String fabricRemarksFive) {
		this.fabricRemarksFive = fabricRemarksFive;
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

	public String getLocationInfo() {
		return locationInfo;
	}

	public void setLocationInfo(String locationInfo) {
		this.locationInfo = locationInfo;
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


	public String getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(String dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public String getExcelInfoId() {
		return excelInfoId;
	}

	public void setExcelInfoId(String excelInfoId) {
		this.excelInfoId = excelInfoId;
	}

	public String getArtNo() {
		return artNo;
	}

	public void setArtNo(String artNo) {
		this.artNo = artNo;
	}

	public String getItemNoColourCurrency() {
		return ItemNoColourCurrency;
	}

	public void setItemNoColourCurrency(String itemNoColourCurrency) {
		ItemNoColourCurrency = itemNoColourCurrency;
	}

	public String getItemNoColour() {
		return itemNoColour;
	}

	public void setItemNoColour(String itemNoColour) {
		this.itemNoColour = itemNoColour;
	}

	public List<Fabric> getFabricList() {
		return fabricList;
	}

	public void setFabricList(List<Fabric> fabricList) {
		this.fabricList = fabricList;
	}

	public String getFabricNameSix() {
		return fabricNameSix;
	}

	public void setFabricNameSix(String fabricNameSix) {
		this.fabricNameSix = fabricNameSix;
	}

	public String getFabricInfoSix() {
		return fabricInfoSix;
	}

	public void setFabricInfoSix(String fabricInfoSix) {
		this.fabricInfoSix = fabricInfoSix;
	}

	public String getFabricRemarksSix() {
		return fabricRemarksSix;
	}

	public void setFabricRemarksSix(String fabricRemarksSix) {
		this.fabricRemarksSix = fabricRemarksSix;
	}

	public String getFabricNameSeven() {
		return fabricNameSeven;
	}

	public void setFabricNameSeven(String fabricNameSeven) {
		this.fabricNameSeven = fabricNameSeven;
	}

	public String getFabricInfoSeven() {
		return fabricInfoSeven;
	}

	public void setFabricInfoSeven(String fabricInfoSeven) {
		this.fabricInfoSeven = fabricInfoSeven;
	}

	public String getFabricRemarksSeven() {
		return fabricRemarksSeven;
	}

	public void setFabricRemarksSeven(String fabricRemarksSeven) {
		this.fabricRemarksSeven = fabricRemarksSeven;
	}

	public String getFabricNameEight() {
		return fabricNameEight;
	}

	public void setFabricNameEight(String fabricNameEight) {
		this.fabricNameEight = fabricNameEight;
	}

	public String getFabricInfoEight() {
		return fabricInfoEight;
	}

	public void setFabricInfoEight(String fabricInfoEight) {
		this.fabricInfoEight = fabricInfoEight;
	}

	public String getFabricRemarksEight() {
		return fabricRemarksEight;
	}

	public void setFabricRemarksEight(String fabricRemarksEight) {
		this.fabricRemarksEight = fabricRemarksEight;
	}

	public String getSetPrice() {
		return setPrice;
	}

	public void setSetPrice(String setPrice) {
		this.setPrice = setPrice;
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
