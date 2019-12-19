package com.haoyin.image.serviceImpl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.at.interfaces.sync.MPMSOrderService;
import com.haoyin.image.service.DubboService;

@Service
public class DubboServiceImpl implements DubboService{
	@Reference(group="feedback")
	MPMSOrderService mpmsOrderService;
	
	public Boolean testService(String orderNo,Integer status){
	 return 	mpmsOrderService.updateSupplierOrderStatus(orderNo,status );
	}
}
