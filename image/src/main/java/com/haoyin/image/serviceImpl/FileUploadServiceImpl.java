package com.haoyin.image.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoyin.image.demo.DemoUser;
import com.haoyin.image.entity.ExcelInfo;
import com.haoyin.image.entity.InitialExcelInfo;
import com.haoyin.image.mapper.FileUploadMapper;
import com.haoyin.image.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService{
	
	@Autowired
	private FileUploadMapper fileUploadMapper;

	@Override
	public List<DemoUser> findUserInfo(int age) {
		// TODO Auto-generated method stub
		return fileUploadMapper.selectUserInfo(age);
	}

	@Transactional
	public boolean addExcelInfo(ExcelInfo info,List<InitialExcelInfo> infoList) {
		try {
			fileUploadMapper.insertExcelInfo(info);
			for(int i=0;i<infoList.size();i++) {
				infoList.get(i).setExcelInfoId(info.getId());
			}
			fileUploadMapper.inserInitialInfo(infoList);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
			
	}
	
	/**
	 * 查询initil文件里面具体信息
	 */
	public List<InitialExcelInfo> queryExcelInitialInfo(ExcelInfo info) {
		return fileUploadMapper.selectExcelInitialInfo(info);
	}

}
