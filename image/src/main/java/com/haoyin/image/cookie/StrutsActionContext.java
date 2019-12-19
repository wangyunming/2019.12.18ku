package com.haoyin.image.cookie;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class StrutsActionContext {
private final static Logger log = LoggerFactory.getLogger(StrutsActionContext.class);
	
	private static  ConcurrentHashMap<String,Object> ActionContext=new ConcurrentHashMap<>();
	
	private StrutsActionContext() {}

	@SuppressWarnings("unchecked")
	public static <T> T getValue(Class<T> clazz) {
		return (T) getValue(clazz.getName() + ".actionContext");
	}

	@SuppressWarnings("unchecked")
	public static <T> T getValue(String name) {
		return (T) ActionContext.get(name);
	}

	public static void putValue(Object obj) {
		putValue(obj, obj.getClass().getName() + ".actionContext");
	}

	public static void putValue(Object obj, String name) {
		ActionContext.put(name, obj);
		log.debug("add key: {}, value: {} to ActionContext", name, obj);
	}
}
