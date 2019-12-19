package com.haoyin.image.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMaper {
	
	@Select("select * from DEMO_USER where age = #{age}")
	DemoUser Select(int age);
}