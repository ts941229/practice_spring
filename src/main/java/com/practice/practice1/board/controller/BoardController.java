package com.practice.practice1.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.practice1.board.Board;
import com.practice.practice1.board.BoardDTO;
import com.practice.practice1.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
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
	public String writeBoard(@ModelAttribute("board") BoardDTO boardDTO, Model model) {
		
		System.out.println("title : "+boardDTO.getTitle());
		System.out.println("author : "+boardDTO.getAuthor());
		System.out.println("content : "+boardDTO.getContent());
		
		Board board = new Board();
		
		board.setTitle(boardDTO.getTitle());
		board.setAuthor(boardDTO.getAuthor());
		board.setContent(boardDTO.getContent());
		
		boardService.save(board);
		
		return "/board/board_list";
	}
	
	@GetMapping("/boardEdit")
	public String getBoardEditPage() {
		return "/board/board_edit";
	}

}
