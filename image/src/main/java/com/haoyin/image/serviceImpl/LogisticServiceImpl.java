package com.haoyin.image.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoyin.image.entity.Delivery;
import com.haoyin.image.entity.DeliveryQuery;
import com.haoyin.image.entity.District;
import com.haoyin.image.exception.DaoException;
import com.haoyin.image.mapper.LogisticDAO;
import com.haoyin.image.service.LogisticService;

@Service
public class LogisticServiceImpl implements LogisticService{
	
	@Resource
	LogisticDAO logisticDAO;
	
	@Override
	public Long addDeliveryAddress(District district) {
	try {
			logisticDAO.insertDeliveryAddress(district);
			return  district.getId();
	} catch (DaoException e) {
		e.printStackTrace();
	}
	return null;
	}

	@Override
	public List<Delivery> queryDeliveryList(DeliveryQuery query) {
		try {
		return	logisticDAO.queryDeliveryList(query);
	} catch (DaoException e) {
		e.printStackTrace();
	}
		return null;
	}
	@Transactional
	@Override
	public void setAdreessDefault(DeliveryQuery query) {
		try{
			logisticDAO.setAdreessDefault(query);
		}catch (DaoException e) {
			e.printStackTrace();	
		}
	}
	@Transactional(readOnly=false)
	@Override
	public Boolean updateAddress(long addressId) {
		try{
			DeliveryQuery query=new DeliveryQuery();
			query.setId(addressId);
			query.setStatus(0);
			
			Integer rows=logisticDAO.setAdreessDefault(query);
			if(rows>0){
				return true;
			}
		}catch (DaoException e) {
			e.printStackTrace();
		}
		return false;
	}

}
