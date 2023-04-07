package com.practice.practice1.board.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.practice1.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	public Optional<Board> findById(@Param("board_seq") Long board_seq);
	
	@Query("select b from Board b where b.title like %:keyword% or b.content like %:keyword%")
	public Page<Board> findByTitleContainingOrContentContaining(@Param("keyword") String keyword, Pageable pageable);
	
	public Page<Board> findByTitleContaining(String keyword, Pageable pageable);
	
	@Query("select b from Board b where b.content like %:keyword%")
	public Page<Board> findByContentContaining(@Param("keyword") String keyword, Pageable pageable);
	
	public Page<Board> findByAuthorContaining(String keyword, Pageable pageable);
	
}
