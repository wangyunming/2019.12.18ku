package com.haoyin.image.service;

import java.util.List;

import org.springframework.ui.Model;

import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.CommodityInfo;
import com.haoyin.image.entity.CommodityType;
import com.haoyin.image.entity.Order;
import com.haoyin.image.entity.OrderItem;
import com.haoyin.image.entity.OrderItemInfo;
import com.haoyin.image.entity.ShoppingCartForm;
import com.haoyin.image.entity.ShoppingCartItem;
import com.haoyin.image.exception.DaoException;

public interface OrderProcessService {

	
	/**
	 * 查询商品类别
	 * @return
	 */
	List<CommodityType> selectCommodityTypeList();
	
	/**
	 * 根据ID查询商品类别
	 * @param query
	 * @return
	 */
	CommodityType selectCommodityTypeById(CommodityType query);
	
	/**
	 * 插入购物车
	 */
	boolean insertShoppingCartItem(ShoppingCartItem query);
	
	/**
	 * 插入文件商品信息
	 */
	boolean insertFileCommodityInfoList(List<CommodityInfo> query);

	PageInfo<ShoppingCartItem> queryCartList(ShoppingCartItem shoppingCartItem);

	boolean updateShoppingCart(ShoppingCartForm cartForm);
	/*
	 * 根据Id删除购物车商品
	 */
	boolean delShoppingCartItemByItemId(Long shoppingCartId);
	/**
	 * 查询购物车数量
	 * @param itemQuery
	 * @return
	 */
	int queryCartListCount(ShoppingCartItem itemQuery);
	
	/**
	 * 查询购物车
	 */
	List<ShoppingCartItem> selectShoppingCartList(ShoppingCartItem shoppingCartItem);
	
	/**
	 * 插入购物车
	 */
	boolean insertOrder(Long deliveryId, Order order,String[] itemId);
	
	
	/**
	 * 根据条目ID查询订单条目商品信息
	 */
	OrderItem selectOrderByItemId(OrderItem orderItem);
	
	
	/**
	 * 重新上传插入
	 */
	boolean insertReOrderItem(OrderItem order,OrderItem orderItem,List<OrderItemInfo> infoList);
	
	/**
	 * 插入订单条目
	 */
	boolean insertOrderItemInfoforList(List<OrderItemInfo> query);
	
	
	/**
	 * 根据ID删除订单条目
	 */
	boolean deleteOrderItemByItemId(Long id);
	
	/**
	 * 根据ID删除订单条目文件详情
	 */
	boolean deleteOrderItemInfoByItemId(Long id);
	
	
	/**
	 * 删除订单
	 */
	boolean removeOrderById(Long orderId);
	
	/**
	 * 继续支付
	 */
	boolean goOnInsertOrder(Long deliveryId, Order order);
	
}
