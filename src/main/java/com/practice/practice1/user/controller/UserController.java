package com.practice.practice1.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/userRegist")
	public String registForm() {
		return "/user/user_regist";
	}
	
	@GetMapping("/userLogin")
	public String loginForm() {
		return "/user/user_login";
	}
	
}