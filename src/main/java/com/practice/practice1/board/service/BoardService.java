package com.practice.practice1.board.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Board> findAll() {
		return boardRepository.findAll();
	}
	
	public Optional<Board> findById(Long board_seq) {
		return boardRepository.findById(board_seq);
	}
	
}
