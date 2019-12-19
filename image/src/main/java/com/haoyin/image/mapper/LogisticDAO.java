package com.haoyin.image.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.haoyin.image.entity.Delivery;
import com.haoyin.image.entity.DeliveryQuery;
import com.haoyin.image.entity.District;
import com.haoyin.image.exception.DaoException;

@Mapper
public interface LogisticDAO {
	Integer insertDeliveryAddress(District district) throws DaoException;

	List<Delivery> queryDeliveryList(DeliveryQuery query) throws DaoException;

	Integer setAdreessDefault(DeliveryQuery query) throws DaoException;
	
	
	/**
	 * 根据ID查询收货信息
	 * @param query
	 * @return
	 * @throws DaoException
	 */
	Delivery selectDeliveryById(DeliveryQuery query) throws DaoException;
	
}
