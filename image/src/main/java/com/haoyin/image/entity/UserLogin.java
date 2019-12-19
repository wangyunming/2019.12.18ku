package com.haoyin.image.entity;

import java.util.Date;

/**
 * 用户登录
 * 
 * @author Summer
 *
 *         2016年5月20日
 */
public class UserLogin implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/** 编号 */
	private Long id;

	/** 登录时间 */
	private Date gmtLogin;

	/** 登录用户 */
	private String loginUsername;

	/** 登录主机 */
	private String loginHost;

	/** 登录状态 */
	private Integer loginStatus;

	/** 备注 */
	private String remarks;

	/**
	 * @return the {@link #id}
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the {@link #id} to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the {@link #gmtLogin}
	 */
	public Date getGmtLogin() {
		return gmtLogin;
	}

	/**
	 * @param gmtLogin
	 *            the {@link #gmtLogin} to set
	 */
	public void setGmtLogin(Date gmtLogin) {
		this.gmtLogin = gmtLogin;
	}

	/**
	 * @return the {@link #loginUsername}
	 */
	public String getLoginUsername() {
		return loginUsername;
	}

	/**
	 * @param loginUsername
	 *            the {@link #loginUsername} to set
	 */
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	/**
	 * @return the {@link #loginHost}
	 */
	public String getLoginHost() {
		return loginHost;
	}

	/**
	 * @param loginHost
	 *            the {@link #loginHost} to set
	 */
	public void setLoginHost(String loginHost) {
		this.loginHost = loginHost;
	}

	/**
	 * @return the {@link #loginStatus}
	 */
	public Integer getLoginStatus() {
		return loginStatus;
	}

	/**
	 * @param loginStatus
	 *            the {@link #loginStatus} to set
	 */
	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}

	/**
	 * @return the {@link #remarks}
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks
	 *            the {@link #remarks} to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return new StringBuilder(UserLogin.class.getSimpleName()).append("\n id=").append(id).append(", gmtLogin=").append(gmtLogin).append(", loginUsername=")
				.append(loginUsername).append(", loginHost=").append(loginHost).append(", loginStatus=").append(loginStatus).append(", remarks=")
				.append(remarks).toString();
	}

}
