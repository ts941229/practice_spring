package com.practice.practice1.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.practice.practice1.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	public Optional<Board> findById(@Param("board_seq") Long board_seq);
}
