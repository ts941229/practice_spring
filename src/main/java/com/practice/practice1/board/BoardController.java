package com.practice.practice1.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping("/board_list")
	public String getBoardListPage() {
		return "/board/board_list";
	}

}
