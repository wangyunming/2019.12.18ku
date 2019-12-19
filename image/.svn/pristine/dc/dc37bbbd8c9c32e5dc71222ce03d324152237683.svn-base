package com.haoyin.image.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haoyin.image.cookie.ShoppingCartCookieManager;

@Controller
public class CartController {
	
	@RequestMapping("/cart")
	public String CartNum(){
		ShoppingCartCookieManager.writeShoppingNumber(15);
		return "layout/site-nav-step";
	}
	
	
}
