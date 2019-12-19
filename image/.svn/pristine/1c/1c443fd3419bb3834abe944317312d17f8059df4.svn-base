package com.haoyin.image.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.haoyin.image.entity.Order;
import com.haoyin.image.entity.OrderItem;
import com.haoyin.image.entity.OrderItemInfo;
import com.haoyin.image.entity.OrderProcess;
import com.haoyin.image.entity.OrderQuery;
import com.haoyin.image.exception.DaoException;

@Mapper
public interface OrderDAO {
	List<Order> queryOrderForList1(OrderQuery query) throws DaoException;

	Order selectOrderById(Long orderId) throws DaoException;

	Order selectOrderByOrderNo(String orderNo) throws DaoException;

	Integer updateOrderPayStatus(Order order);

	Integer saveOrderProcess(OrderProcess process);

	Integer updateOrderStatusById(OrderQuery orderQuery) throws DaoException;
	
	
	/**
	 * 根据订单ID查询条目文件详情
	 */
	List<OrderItemInfo> selectItemInfoByOrderId(Long orderId) throws DaoException;
	
	/**
	 * 根据订单条目表ITEM_ID查询订单条目表
	 */
	OrderItem selectOrderItemByItemId(String itemId) throws DaoException;
	
}
