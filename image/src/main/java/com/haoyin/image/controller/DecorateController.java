package com.haoyin.image.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DecorateController {
	@RequestMapping("/layout/site-nav.ftl")
	public String decorate(){
		return "layout/main";
	}
	@RequestMapping("/layout/direct-nav.ftl")
	public String direct(){
		return "layout/step";
	}
}
