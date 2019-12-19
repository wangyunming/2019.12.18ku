package com.haoyin.image.util.alipay;

import java.io.Serializable;
import java.util.Map;

/**
 * 返回结果
 * 
 * @author Summer.xia
 */
public interface PayResult extends Serializable {

	/**
	 * 请求是否成功。
	 * 
	 * @return 如果成功，则返回<code>true</code>
	 */
	boolean isSuccess();

	/**
	 * 设置请求成功标志。
	 * 
	 * @param success
	 *            成功标志
	 */
	void setSuccess(boolean success);

	/**
	 * 获取返回码
	 * 
	 * @return 返回码
	 */
	String getResultCode();

	/**
	 * 设置返回码
	 * 
	 * @param code
	 */
	void setResultCode(String code);

	/**
	 * 设置model对象。
	 * 
	 * @param clazz
	 *            数据类型
	 * @param model
	 *            model对象
	 */
	void setModel(Class<?> clazz, Object model);

	/**
	 * <p>
	 * 获取特定类型的 model 对象
	 * </p>
	 * 
	 * @param <T>
	 * @param clazz
	 *            数据类型 KEY
	 * @return
	 */
	<T> T getModel(Class<T> clazz);
	
	/**
	 * 取得所有model对象。
	 * 
	 * @return model对象表
	 */
	Map<Class<?>, Object> getModels();

}
