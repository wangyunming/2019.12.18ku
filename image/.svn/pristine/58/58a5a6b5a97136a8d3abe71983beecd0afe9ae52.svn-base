package com.haoyin.image.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haoyin.image.entity.DeliveryQuery;
import com.haoyin.image.entity.District;
import com.haoyin.image.entity.JSONResult;
import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.service.LogisticService;

@Controller
public class LogisticController {
	
	@Resource
	LogisticService logisticService;
	
	@RequestMapping("/logistic-ajax/ajax-save-address.html")
	public @ResponseBody JSONResult logistic(District district){
		JSONResult jsonResult=new JSONResult();
		DeliveryQuery query=new DeliveryQuery();
		query.setUserId(getUser().getId());
		query.setIsDefault(0);
		logisticService.setAdreessDefault(query);//把其他的收货地址默认状态都改为不默认
		district.setUserId(getUser().getId());
		Long deliverId=logisticService.addDeliveryAddress(district);
		if(deliverId!=null){
			jsonResult.setSuccess(true);
			jsonResult.setObj(deliverId);
		}
		return jsonResult;
	}
	@RequestMapping("/logistic-ajax/ajax-setIsDefault-address.html")
	@ResponseBody
	public String setIsDefault(String addressId){
		DeliveryQuery query=new DeliveryQuery();
		query.setUserId(getUser().getId());
		query.setIsDefault(0);
		logisticService.setAdreessDefault(query);
		query.setId(Long.parseLong(addressId));
		query.setIsDefault(1);
		logisticService.setAdreessDefault(query);
		return "success";
	}
	
	@PostMapping("/logistic-ajax/ajax-invalid-address.html")
	@ResponseBody
	public Boolean invalidAddress(String addressId){
	Boolean result=logisticService.updateAddress(Long.parseLong(addressId));
	return result;
	}
	
	
 	UserProfile getUser(){
		return (UserProfile) SecurityUtils.getSubject().getSession(false).getAttribute("uus");
	} 
}
