package com.haoyin.image.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class WebController {
	@Autowired
	private UserMaper mapper;

	@GetMapping("/index")
	public DemoUser selectAge(@RequestParam("age") int age) {

		return mapper.Select(age);
	}
}