package com.haoyin.image.entity;

import java.util.Date;

/**
 * 用户配送地址
 * 
 * @author Summer.xia
 * 
 */
public class Delivery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/** 地址 ID */
	private Long id;

	/** 用户ID */
	private Long userId;
	
	/** 机构id */
	private Long orgId;

	/** 联系人 */
	private String linkman;

	/** 地址 - 省份 */
	private String province;

	/** 市/区 ID */
	private Long cityId;

	/** 地址 - 城市 */
	private String city;

	/** 区/镇 */
	private String district;

	/** 地址 */
	private String address;

	/** 联系电话 */
	private String telephone;

	/** 手机号码 */
	private String mobileTel;

	/** 电子邮件 */
	private String email;

	/** 邮政编码 */
	private String postalcode;

	/** 是否默认 */
	private Integer isDefault;

	/** 备注 */
	private String remark;

	/** 创建时间 */
	private Date createGmt;

	/** 修改时间 */
	private Date modifiedGmt;

	/** 状态 */
	private Integer status;

	/**
	 * @return <code>the {@link #id}</code>
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            <code>the {@link #id} to set</code>
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return <code>the {@link #userId}</code>
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            <code>the {@link #userId} to set</code>
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the {@link #province}
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province
	 *            the {@link #province} to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the cityId
	 */
	public Long getCityId() {
		return cityId;
	}

	/**
	 * @param cityId
	 *            the cityId to set
	 */
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the {@link #city}
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the {@link #city} to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the {@link #district}
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district
	 *            the {@link #district} to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return <code>the {@link #address}</code>
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            <code>the {@link #address} to set</code>
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return <code>the {@link #linkman}</code>
	 */
	public String getLinkman() {
		return linkman;
	}

	/**
	 * @param linkman
	 *            <code>the {@link #linkman} to set</code>
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	/**
	 * @return <code>the {@link #telephone}</code>
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            <code>the {@link #telephone} to set</code>
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return <code>the {@link #mobileTel}</code>
	 */
	public String getMobileTel() {
		return mobileTel;
	}

	/**
	 * @param mobileTel
	 *            <code>the {@link #mobileTel} to set</code>
	 */
	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}

	/**
	 * @return <code>the {@link #email}</code>
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            <code>the {@link #email} to set</code>
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return <code>the {@link #postalcode}</code>
	 */
	public String getPostalcode() {
		return postalcode;
	}

	/**
	 * @param postalcode
	 *            <code>the {@link #postalcode} to set</code>
	 */
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	/**
	 * @return the {@link isDefault}
	 */
	public Integer getIsDefault() {
		return null == isDefault ? 0 : isDefault;
	}

	/**
	 * @param isDefault
	 *            the {@link isDefault} to set
	 */
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * @return <code>the {@link #remark}</code>
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            <code>the {@link #remark} to set</code>
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return <code>the {@link #createGmt}</code>
	 */
	public Date getCreateGmt() {
		return createGmt;
	}

	/**
	 * @param createGmt
	 *            <code>the {@link #createGmt} to set</code>
	 */
	public void setCreateGmt(Date createGmt) {
		this.createGmt = createGmt;
	}

	/**
	 * @return <code>the {@link #modifiedGmt}</code>
	 */
	public Date getModifiedGmt() {
		return modifiedGmt;
	}

	/**
	 * @param modifiedGmt
	 *            <code>the {@link #modifiedGmt} to set</code>
	 */
	public void setModifiedGmt(Date modifiedGmt) {
		this.modifiedGmt = modifiedGmt;
	}

	/**
	 * @return <code>the {@link #status}</code>
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            <code>the {@link #status} to set</code>
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Delivery)) {
			return false;
		}
		return obj == this;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((linkman == null) ? 0 : linkman.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((mobileTel == null) ? 0 : mobileTel.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((postalcode == null) ? 0 : postalcode.hashCode());
		result = prime * result + ((isDefault == null) ? 0 : isDefault.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((createGmt == null) ? 0 : createGmt.hashCode());
		result = prime * result + ((modifiedGmt == null) ? 0 : modifiedGmt.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return new StringBuilder(getClass().getSimpleName()).append(" [").append("id = ").append(id)
				.append(", userId = ").append(userId).append(", linkman = ").append(linkman).append(", address = ")
				.append(province).append(city).append(address).append(", telephone = ").append(telephone)
				.append(", mobileTel = ").append(mobileTel).append(", email = ").append(email)
				.append(", postalcode = ").append(postalcode).append(", isDefault = ").append(isDefault)
				.append(", remark = ").append(remark).append(", createGmt = ").append(createGmt)
				.append(", modifiedGmt = ").append(modifiedGmt).append(", status = ").append(status).append(" ]")
				.toString();
	}
}
