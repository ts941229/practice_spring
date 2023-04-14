package com.practice.practice1.board.controller;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/board-list")
	public String boardListForm(Model model, @PageableDefault(page = 0, size = 5, sort = "id", direction = Direction.DESC) Pageable pageable) {

		Page<Board> boardList = boardService.findAll(pageable);
		
		int pageSize = 5;
		int nowPage = boardList.getPageable().getPageNumber() + 1;
		// 시작페이지 : ((현재 페이지 - 1) / 페이지 사이즈) * 페이지 사이즈 + 1 
		int startPage = Math.max(((nowPage - 1) / pageSize) * pageSize + 1, 0);
		// 끝페이지 : (시작 페이지 + 페이지 사이즈 - 1)
		int endPage = Math.min(startPage + pageSize - 1, boardList.getTotalPages());
		int prev = startPage-pageSize;
		int next = startPage+pageSize;
		
		// 데이터가 없을 때
		if(endPage==0) {endPage = 1;}
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		
		return "/board/board_list";
	}
	
	@GetMapping("/board-search")
	public String boardSearchForm(@RequestParam("board_search") String keyword, @RequestParam("search_category") String search_category, Model model, @PageableDefault(sort = "id", size = 5, direction = Direction.DESC) Pageable pageable) {
		
		Page<Board> searchList = null;
	
		switch(search_category) {
			case "1" : searchList = boardService.findByTitleContainingOrContentContaining(keyword, pageable); break;
			case "2" : searchList = boardService.findByTitleContaining(keyword, pageable); break;
			case "3" : searchList = boardService.findByContentContaining(keyword, pageable); break;
			case "4" : searchList = boardService.findByAuthorContaining(keyword, pageable); break;
		}
		
		int pageSize = 5;
		int nowPage = searchList.getPageable().getPageNumber() + 1;
		// 시작페이지 : ((현재 페이지 - 1) / 페이지 사이즈) * 페이지 사이즈 + 1 
		int startPage = Math.max(((nowPage - 1) / pageSize) * pageSize + 1, 0);
		// 끝페이지 : (시작 페이지 + 페이지 사이즈 - 1)
		int endPage = Math.min(startPage + pageSize - 1, searchList.getTotalPages());
		int prev = startPage-pageSize;
		int next = startPage+pageSize;
		
		// 데이터가 없을 때
		if(endPage==0) {endPage = 1;}
		
		model.addAttribute("searchList", searchList);
		model.addAttribute("keyword", keyword);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		model.addAttribute("search_category", search_category);
		
		return "/board/board_search";
	}
	
	@GetMapping("/board-content/{board_seq}")
	public String boardContentForm(@PathVariable("board_seq") Long board_seq, Model model) {
		
		model.addAttribute("board", boardService.findById(board_seq).get());
		
		return "/board/board_content";
	}
	
	@GetMapping("/board-write")
	public String getBoardWritePage() {
		return "/board/board_write";
	}
	
	@PostMapping("/write")
	public String writeBoard(@ModelAttribute("board") BoardDTO boardDTO, Model model) {
		
		Board board = new Board();
		
		board.setTitle(boardDTO.getTitle());
		board.setAuthor(boardDTO.getAuthor());
		board.setContent(boardDTO.getContent());
		board.setBoard_date(Util.getInstance().DateFormat(new Date()));
		
		boardService.save(board);
		
		return "redirect:/board/board-list";
	}
	
	@GetMapping("/board-edit/{board_id}")
	public String boardEditForm(@PathVariable("board_id") Long board_id, Model model) {
		
		model.addAttribute("board", boardService.findById(board_id).get());
		
		return "/board/board_edit";
	}
	
	@PutMapping("/edit")
	public String editBoard(@ModelAttribute("board") Board board) {
		
		boardService.save(board);
		
		return "redirect:/board/board-list";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBoard(@PathVariable("id") Long Id) {
		
		boardService.delete(boardService.findById(Id).get());
		
		return "redirect:/board/board-list";
	}
	
	
}
