package com.haoyin.image.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.InvoiceInformation;
import com.haoyin.image.entity.Order;
import com.haoyin.image.entity.OrderInvoice;
import com.haoyin.image.entity.OrderQuery;
import com.haoyin.image.exception.DaoException;
import com.haoyin.image.mapper.InvoiceDAO;
import com.haoyin.image.mapper.OrderDAO;
import com.haoyin.image.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	
	@Resource
	InvoiceDAO InvoiceDao;
	@Resource
	OrderDAO orderDao;
	
	@Override
	public Boolean addInvoiceInfomation(InvoiceInformation info) {
		try{
			Boolean  rows=InvoiceDao.insertInvoiceInformation(info);
			return rows;
		}catch(DaoException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageInfo<OrderInvoice> queryInvoiceInfo(OrderQuery query) {
		try{
			PageHelper.startPage(query.getPageNum(), query.getPageSize());
			List<OrderInvoice> selectInvoiceInfo = InvoiceDao.selectInvoiceInfo(query);
			return new PageInfo<>(selectInvoiceInfo);
		}catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer updateInvoiceInformation(InvoiceInformation info) {
		try {
			return InvoiceDao.updateInvoiceInformation(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer deleteInvoiceInformation(Long id) {
		try {
			return InvoiceDao.deleteInvoiceInformation(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Order> queryOrderForMakeInformation(OrderQuery query) {
		try {
			return InvoiceDao.queryOrderForMakeInformation(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean addMakeInvoice(InvoiceInformation info) {
		try{
			String[] split = info.getIds().split(",");
			OrderQuery orderQuery = new OrderQuery();
			for (int i = 0; i < split.length; i++) {
				if (split[i]!=null && split[i]!=""&&split[i]!=",") {
					orderQuery.setOrderId(Long.parseLong(split[i]));
					orderQuery.setInvoiceStatus(1);
					orderDao.updateOrderStatusById(orderQuery);
				}
			}
			Boolean  rows=InvoiceDao.addMakeInvoice(info);
			return rows;
		}catch(DaoException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageInfo<InvoiceInformation> selectMakeInvoice(OrderQuery query) {
		try{
			PageHelper.startPage(query.getPageNum(), query.getPageSize());
			List<InvoiceInformation> selectInvoiceInfo = InvoiceDao.selectMakeInvoice(query);
			return new PageInfo<>(selectInvoiceInfo);
		}catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
		
}
