package com.haoyin.image;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.haoyin.image.service.DubboService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageApplicationTests {

	@Autowired
	DubboService dubboService;
	
	@Test
	public void contextLoads() {
	}
	@Test
	public void dubboTest(){
	 boolean result=dubboService.testService("92", 5);
	 System.out.println(result);
	}
}
