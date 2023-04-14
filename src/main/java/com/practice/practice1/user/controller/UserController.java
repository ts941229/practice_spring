package com.practice.practice1.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.practice1.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private final UserService userService;
	
	@GetMapping("/user-regist")
	public String registForm() {
		return "/user/user_regist";
	}
	
	@GetMapping("/user-login")
	public String loginForm() {
		return "/user/user_login";
	}
	
}
