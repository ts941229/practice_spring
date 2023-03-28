package com.practice.practice1.board.service;

import org.springframework.stereotype.Service;

import com.practice.practice1.board.Board;
import com.practice.practice1.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	public void save(Board board) {
		boardRepository.save(board);
	}
	
}
