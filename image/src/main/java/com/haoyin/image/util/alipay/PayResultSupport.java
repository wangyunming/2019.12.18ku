package com.haoyin.image.util.alipay;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PayResultSupport implements PayResult, Serializable {

	private static final long serialVersionUID = -5427837161273573297L;

	private boolean success = false;

	private String resultCode;

	private Map<Class<?>, Object> models = new HashMap<Class<?>, Object>(0);

	@Override
	public boolean isSuccess() {
		return success;
	}

	@Override
	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String getResultCode() {
		return resultCode;
	}

	@Override
	public void setResultCode(String code) {
		this.resultCode = code;

	}

	@Override
	public void setModel(Class<?> clazz, Object model) {
		models.put(clazz, model);
	}

	@Override
	public Map<Class<?>, Object> getModels() {
		return models;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getModel(Class<T> clazz) {
		return (T) models.get(clazz);
	}

}
