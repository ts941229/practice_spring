package com.practice.practice1.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/boardList")
	public String getBoardListPage() {
		return "/board/board_list";
	}
	
	@GetMapping("/boardContent")
	public String getBoardContentPage() {
		return "/board/board_content";
	}
	
	@GetMapping("/boardWrite")
	public String getBoardWritePage() {
		return "/board/board_write";
	}
	
	@PostMapping("/write")
	public String writeBoard(@RequestParam("title") String title,
										@RequestParam("author") String author, 
										@RequestParam("content") String content, Model model) {
		
//		System.out.println("title : " + title);
//		System.out.println("author : " + author);
//		System.out.println("content : " + content);
		
		model.addAttribute("title", title);
		model.addAttribute("author", author);
		model.addAttribute("content", content);
		
		return "/board/board_list";
	}
	
	@GetMapping("/boardEdit")
	public String getBoardEditPage() {
		return "/board/board_edit";
	}

}
