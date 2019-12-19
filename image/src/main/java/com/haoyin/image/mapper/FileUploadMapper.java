package com.haoyin.image.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.haoyin.image.demo.DemoUser;
import com.haoyin.image.entity.ExcelInfo;
import com.haoyin.image.entity.InitialExcelInfo;

@Mapper
public interface FileUploadMapper {


	List<DemoUser> selectUserInfo(int age);
	
	/**
	 * 添加EXCEL文件信息
	 * @param info
	 * @return
	 */
	public Integer insertExcelInfo(ExcelInfo info);
	
	
	/**
	 * 添加EXCEL里面initial合格证和价格牌详细信息
	 */
	public Integer inserInitialInfo(List<InitialExcelInfo> info);
	
	
	/**
	 * 查询initil文件里面具体信息
	 */
	public List<InitialExcelInfo> selectExcelInitialInfo(ExcelInfo info);
	
	
}
