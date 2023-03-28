package com.practice.practice1.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.practice1.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
