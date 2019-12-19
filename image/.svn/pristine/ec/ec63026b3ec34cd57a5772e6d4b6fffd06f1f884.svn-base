package com.haoyin.image.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Summer
 *
 *         2016年5月6日
 */
public class JSONResult {

	private boolean success = false;

	private Object obj;

	private String message;
	
	private String params;

	private Map<String, Object> objects = new HashMap<String, Object>();

	public JSONResult() {
	}

	public JSONResult(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public JSONResult(boolean success, Object obj, String message) {
		this(success, message);
		this.obj = obj;
	}

	/**
	 * @return the {@link #success}
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the {@link #success} to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the {@link #objects}
	 */
	public Map<String, Object> getObjects() {
		return objects;
	}

	/**
	 * @param objects
	 *            the {@link #objects} to set
	 */
	public void setObjects(Map<String, Object> objects) {
		this.objects = objects;
	}

	/**
	 * @return the {@link #obj}
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * @param obj
	 *            the {@link #obj} to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}

	/**
	 * @return the {@link #message}
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the {@link #message} to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Set bcak object and success is true.
	 * 
	 * @param obj
	 */
	public void setObjAndSuccess(Object obj) {
		this.success = (null != obj);
		this.obj = obj;
	}

	/**
	 * Set objects key and value
	 * 
	 * @param key
	 * @param object
	 */
	public void setObjects(String key, Object object) {
		objects.put(key, object);
	}

	public static JSONResult success(String message) {
		return new JSONResult(true, message);
	}

	public static JSONResult success(String message, Object object) {
		return new JSONResult(true, object, message);
	}

	public static JSONResult error(String message) {
		return new JSONResult(false, message);
	}
	
	/**
	 * @return the {@link #params}
	 */
	public String getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the {@link #params} to set
	 */
	public void setParams(String params) {
		this.params = params;
	}
	


}
