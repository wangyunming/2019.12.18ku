package com.haoyin.image.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.Order;
import com.haoyin.image.entity.OrderItem;
import com.haoyin.image.entity.OrderItemInfo;
import com.haoyin.image.entity.OrderQuery;
import com.haoyin.image.exception.DaoException;

public interface OrderService {
  PageInfo<Order>	  queryOrderForList1(OrderQuery query);

   Order     queryOrderById(Long orderId);

   Order queryOrderByOrderNo(String orderNo);
   //更新订单状态
   Boolean updateOrderStatus(OrderQuery orderQuery);
   
   /**
	 * 根据订单ID查询条目文件详情
	 */
	List<OrderItemInfo> selectItemInfoByOrderId(Long orderId);
	
	
	/**
	 * 根据订单条目表ITEM_ID查询订单条目表
	 */
	OrderItem selectOrderItemByItemId(String itemId) throws DaoException;
   
   
}
