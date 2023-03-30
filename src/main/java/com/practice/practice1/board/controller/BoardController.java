package com.practice.practice1.board.controller;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.practice1.board.Board;
import com.practice.practice1.board.BoardDTO;
import com.practice.practice1.board.service.BoardService;
import com.practice.practice1.global.Util;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/boardList")
	public String getBoardListPage(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		Page<Board> boardList = boardService.findAll(pageable);
		
		int totalPage = boardList.getTotalPages();
		System.out.println("totalPage : "+totalPage);

		
		
		model.addAttribute("boardList", boardList);
		
//		for(Board board : boardService.findAll()) {
//			System.out.println("title : "+board.getTitle());
//			System.out.println("author : "+board.getAuthor());
//			System.out.println("content : "+board.getContent());
//		}
		
		return "/board/board_list";
	}
	
	@GetMapping("/boardContent/{board_seq}")
	public String getBoardContentPage(@PathVariable("board_seq") Long board_seq, Model model) {
		
		model.addAttribute("board", boardService.findById(board_seq).get());
		
		return "/board/board_content";
	}
	
	@GetMapping("/boardWrite")
	public String getBoardWritePage() {
		return "/board/board_write";
	}
	
	@PostMapping("/write")
	public String writeBoard(@ModelAttribute("board") BoardDTO boardDTO, Model model) {
		
//		System.out.println("title : "+boardDTO.getTitle());
//		System.out.println("author : "+boardDTO.getAuthor());
//		System.out.println("content : "+boardDTO.getContent());
		
		Board board = new Board();
		
		board.setTitle(boardDTO.getTitle());
		board.setAuthor(boardDTO.getAuthor());
		board.setContent(boardDTO.getContent());
		board.setBoard_date(Util.getInstance().DateFormat(new Date()));
		
		boardService.save(board);
		
		return "redirect:/board/boardList";
	}
	
	@GetMapping("/boardEdit/{board_id}")
	public String getBoardEditPage(@PathVariable("board_id") Long board_id, Model model) {
		
		model.addAttribute("board", boardService.findById(board_id).get());
		
		return "/board/board_edit";
	}
	
	@PutMapping("/edit")
	public String editBoard(@ModelAttribute("board") Board board) {
		
		boardService.save(board);
		
		return "redirect:/board/boardList";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBoard(@PathVariable("id") Long Id) {
		
		boardService.delete(boardService.findById(Id).get());
		
		return "redirect:/board/boardList";
	}
	
	
	
}
