package com.haoyin.image.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.haoyin.image.entity.ExcelInfo;
import com.haoyin.image.entity.FileQuery;
import com.haoyin.image.exception.DaoException;



@Mapper
public interface FileDAO {
	List<ExcelInfo> selectFileList(FileQuery query) throws DaoException;

	Integer updateExcelStatus(ExcelInfo info) throws DaoException;
}
