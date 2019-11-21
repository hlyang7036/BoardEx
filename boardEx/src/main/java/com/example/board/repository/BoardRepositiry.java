package com.example.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.domain.Board;

public interface BoardRepositiry extends JpaRepository<Board, Long> {
	List<Board> findAllByOrderBySeqDesc();
}
