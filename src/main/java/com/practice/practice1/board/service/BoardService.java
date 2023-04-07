package com.practice.practice1.board.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Board> findAll(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	public Page<Board> findByTitleContaining(String keyword, Pageable pageable){
		return boardRepository.findByTitleContaining(keyword, pageable);
	}
	
	public Page<Board> findByTitleContainingOrContentContaining(String keyword, Pageable pageable) {
		return boardRepository.findByTitleContainingOrContentContaining(keyword, pageable);
	}
	
	public Page<Board> findByContentContaining(String keyword, Pageable pageable) {
		return boardRepository.findByContentContaining(keyword, pageable);
	}
	
	public Page<Board> findByAuthorContaining(String keyword, Pageable pageable) {
		return boardRepository.findByAuthorContaining(keyword, pageable);
	}
	
	public Optional<Board> findById(Long board_seq) {
		return boardRepository.findById(board_seq);
	}
	
	public void delete(Board board) {
		boardRepository.delete(board);
	}

	
}
