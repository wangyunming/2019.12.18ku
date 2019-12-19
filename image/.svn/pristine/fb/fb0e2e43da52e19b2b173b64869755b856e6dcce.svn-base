package com.haoyin.image.service;



import java.util.List;

import com.haoyin.image.demo.DemoUser;
import com.haoyin.image.entity.ExcelInfo;
import com.haoyin.image.entity.InitialExcelInfo;



public interface FileUploadService {

	public List<DemoUser> findUserInfo(int age);
	
	/**
	 * 提交文件插入
	 */
	public boolean addExcelInfo(ExcelInfo info,List<InitialExcelInfo> infoList);
	
	/**
	 * 查询initil文件里面具体信息
	 */
	public List<InitialExcelInfo> queryExcelInitialInfo(ExcelInfo info);
	
}
