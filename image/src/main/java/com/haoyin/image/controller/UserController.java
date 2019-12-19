package com.haoyin.image.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haoyin.image.entity.JSONResult;
import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.entity.UserRole;
import com.haoyin.image.security.PasswordHashed;
import com.haoyin.image.service.UserProfileService;



@Controller
public class UserController {
	@Autowired 
	private  UserProfileService  userProfileService;
	@RequestMapping("/admin/add.html")
	public String add(){
		return "screen/user/add";
	}
	@RequestMapping("/user/save")
	public @ResponseBody JSONResult save(@Valid UserProfile profile,BindingResult result, String roleIds){
		if (result.hasErrors() || null == roleIds) {
			return JSONResult.error("参数错误");
		}

		PasswordHashed ph = PasswordHashed.getInstance();
		profile.setPassword(ph.encryptToHex(profile.getPassword()));
		profile.setSalt(ph.getCredentialsSalt());

		List<UserRole> roleList = new ArrayList<UserRole>();
		if (!StringUtils.isEmpty(roleIds)) {
			String[] array = roleIds.split(",");

			for (String s : array) {
				UserRole role = new UserRole();
				role.setRoleId(NumberUtils.toLong(s));
				roleList.add(role);
			}
			profile.setUserRoleList(roleList);
		}

		boolean created = userProfileService.createUser(profile);
		if (!created) {
			return JSONResult.error("参数错误");
		}

		return JSONResult.success("success");
	}
}
