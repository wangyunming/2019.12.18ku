package com.haoyin.image.entity;

import org.apache.commons.lang.StringUtils;

/**
 * @author Summer
 *
 *         2016年3月21日
 */
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/** 用户 ID */
	private Long userId;

	/** 用户名 */
	private String username;

	/** 密码 */
	private String password;

	/** 加密salt */
	private String salt;

	/** 状态 */
	private Integer status;

	public User() {
	}

	public User(long userId, int status) {
		this.userId = userId;
		this.status = status;
	}

	/**
	 * @return the {@link #userId}
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the {@link #userId} to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the {@link #username}
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the {@link #username} to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the {@link #password}
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the {@link #password} to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the {@link #salt}
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt
	 *            the {@link #salt} to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * @return the credentials salt, if user's salt is null, and return username + password
	 */
	public String getCredentialsSalt() {
		if (null == salt || salt.length() < 1) {
			return this.username + this.password;
		}

		return salt;
	}

	/**
	 * @return the {@link #status}
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the {@link #status} to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the locked status
	 */
	public boolean isLocked() {
		if (null == status) {
			return false;
		}
		return status == 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User ul = (User) o;
		if (!StringUtils.equals(this.username, ul.username)) {
			return false;
		}
		if (!StringUtils.equals(this.salt, ul.salt)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (null == username ? 0 : username.hashCode());
		result = prime * result + (null == salt ? 0 : salt.hashCode());
		result = prime * result + (null == status ? 0 : status.hashCode());

		return result;
	}

	@Override
	public String toString() {
		return new StringBuilder(User.class.getSimpleName()).append("\n userId=").append(userId).append(", username=").append(username).append(", password=")
				.append(password).append(", salt=").append(salt).append(", status=").append(status).toString();
	}

}
