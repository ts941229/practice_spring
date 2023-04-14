package com.practice.practice1.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.practice1.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	
	@Autowired
	private final MemberService memberService;
	
	@GetMapping("/member-regist")
	public String registForm() {
		return "/member/member_regist";
	}
	
	@GetMapping("/member-login")
	public String loginForm() {
		return "/member/member_login";
	}
	
}
