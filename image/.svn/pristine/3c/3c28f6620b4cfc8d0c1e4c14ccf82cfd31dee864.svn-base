package com.haoyin.image.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.InvoiceInformation;
import com.haoyin.image.entity.Order;
import com.haoyin.image.entity.OrderInvoice;
import com.haoyin.image.entity.OrderQuery;

public interface InvoiceService {

	//添加发票信息
	Boolean addInvoiceInfomation(InvoiceInformation info);
	//查询发票信息
	PageInfo<OrderInvoice> queryInvoiceInfo(OrderQuery query);
	//修改发票信息
	Integer updateInvoiceInformation(InvoiceInformation info);
	//删除发票信息
	Integer deleteInvoiceInformation(Long id);
	//查询待开票订单信息
	List<Order> queryOrderForMakeInformation(OrderQuery query);
	//添加申请开票信息(按订单开票)
	Boolean addMakeInvoice(InvoiceInformation info);
	//查询申请开票信息
	PageInfo<InvoiceInformation> selectMakeInvoice(OrderQuery query);
}
