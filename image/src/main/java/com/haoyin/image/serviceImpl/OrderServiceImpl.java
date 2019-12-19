package com.haoyin.image.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.Order;
import com.haoyin.image.entity.OrderItem;
import com.haoyin.image.entity.OrderItemInfo;
import com.haoyin.image.entity.OrderQuery;
import com.haoyin.image.exception.DaoException;
import com.haoyin.image.mapper.OrderDAO;
import com.haoyin.image.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Resource
	OrderDAO oderDao;
	
	@Override
	public PageInfo<Order> queryOrderForList1(OrderQuery query) {
		
		try {
			PageHelper.startPage(query.getPageNum(), query.getPageSize());
			List<Order>   orderList=oderDao.queryOrderForList1(query);
			return new PageInfo<>(orderList);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Order queryOrderById(Long orderId) {
		try{
		return	oderDao.selectOrderById(orderId);
		}catch(DaoException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Order queryOrderByOrderNo(String orderNo) {
		try{
			return	oderDao.selectOrderByOrderNo(orderNo);
		}catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public Boolean updateOrderStatus(OrderQuery orderQuery) {
		try{
			int rows=oderDao.updateOrderStatusById(orderQuery);
			if(rows>0){
				return true;
			}
			return false;
		}catch (DaoException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
   /**
	 * 根据订单ID查询条目文件详情
	 */
	public List<OrderItemInfo> selectItemInfoByOrderId(Long orderId) {
		try{
		return	oderDao.selectItemInfoByOrderId(orderId);
		}catch(DaoException e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据订单条目表ITEM_ID查询订单条目表
	 */
	public OrderItem selectOrderItemByItemId(String itemId) {
		try{
		return	oderDao.selectOrderItemByItemId(itemId);
		}catch(DaoException e){
			e.printStackTrace();
		}
		return null;
	}
	

}
