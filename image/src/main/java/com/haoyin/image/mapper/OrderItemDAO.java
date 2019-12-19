package com.haoyin.image.mapper;

import java.util.List;

import com.haoyin.image.entity.OrderItem;
import com.haoyin.image.exception.DaoException;

public interface OrderItemDAO {
	List<OrderItem> selectItemForListByOrderId(Long id) throws DaoException;
}
