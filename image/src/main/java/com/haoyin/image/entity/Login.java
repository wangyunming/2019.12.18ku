package com.haoyin.image.entity;

import org.hibernate.validator.constraints.Length;


/**
 * @author Summer
 *
 * @date 2016年3月4日
 */
public class Login implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@javax.validation.constraints.NotBlank
	private String username;

	@javax.validation.constraints.NotBlank
	@Length(min = 6, max = 18)
	private String password;

	@Length(min = 4, max = 4)
	private String captche;

	private boolean isRememberMe = Boolean.FALSE;

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
	 * @return the {@link #isRememberMe}
	 */
	public boolean isRememberMe() {
		return isRememberMe;
	}

	/**
	 * @param isRememberMe
	 *            the {@link #isRememberMe} to set
	 */
	public void setRememberMe(boolean isRememberMe) {
		this.isRememberMe = isRememberMe;
	}

	/**
	 * @return the {@link #captche}
	 */
	public String getCaptche() {
		return captche;
	}

	/**
	 * @param captche
	 *            the {@link #captche} to set
	 */
	public void setCaptche(String captche) {
		this.captche = captche;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Login login = (Login) o;
		if (username != null ? !username.equals(login.username) : login.username != null) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return username != null ? username.hashCode() : 0;
	}

	@Override
	public String toString() {
		return new StringBuilder(Login.class.getSimpleName()).append("\n username=").append(username).append(", password=").append(password)
				.append(", isRememberMe=").append(isRememberMe).append(", captcha=").append(captche).toString();
	}

}
