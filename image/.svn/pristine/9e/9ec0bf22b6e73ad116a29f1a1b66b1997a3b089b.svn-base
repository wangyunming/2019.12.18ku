package com.haoyin.image.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.ExcelInfo;
import com.haoyin.image.entity.FileQuery;
import com.haoyin.image.exception.DaoException;
import com.haoyin.image.exception.TransactionRuntimeException;
import com.haoyin.image.mapper.FileDAO;
import com.haoyin.image.service.FileService;


@Service
public class FileServiceImpl extends BaseService  implements FileService{
	@Autowired
	private FileDAO fileDao;
	@Override
	public PageInfo<ExcelInfo> selectFileList(FileQuery query) {
		try{
			PageHelper.startPage(query.getPageNum(), query.getPageSize());
			List<ExcelInfo> fileList=fileDao.selectFileList(query);
			return new PageInfo<>(fileList);
		}catch(DaoException e){
			return null;
		}
	
	}
	@Override
	public Boolean updateExcelStatus(ExcelInfo info) {
	 	return  executeTransaction(action->{
			try{
			Integer  status=fileDao.updateExcelStatus(info);
			if(status>0){
			return true;
			}
			return null;
			}catch (Exception e) {
			 throw new TransactionRuntimeException("文件状态更新失败!",e);
			}
		});
		
	}

}
