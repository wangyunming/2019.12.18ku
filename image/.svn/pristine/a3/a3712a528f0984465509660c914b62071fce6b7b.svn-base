package com.haoyin.image.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.haoyin.image.entity.InvoiceInformation;
import com.haoyin.image.entity.Order;
import com.haoyin.image.entity.OrderInvoice;
import com.haoyin.image.entity.OrderQuery;
import com.haoyin.image.exception.DaoException;

@Mapper
public interface InvoiceDAO {

	//添加发票信息
	Boolean insertInvoiceInformation(InvoiceInformation info) throws DaoException;
	//查询发票信息
	List<OrderInvoice> selectInvoiceInfo(OrderQuery query) throws DaoException;
	//修改发票信息
	Integer updateInvoiceInformation(InvoiceInformation info) throws DaoException;
	//删除发票信息
	Integer deleteInvoiceInformation(Long id) throws DaoException;
	//查询待开票订单
	List<Order> queryOrderForMakeInformation(OrderQuery query) throws DaoException;
	//添加申请开票信息(按订单开票)
	Boolean addMakeInvoice(InvoiceInformation info) throws DaoException;
	//查询申请开票信息
	List<InvoiceInformation> selectMakeInvoice(OrderQuery query) throws DaoException;
}
