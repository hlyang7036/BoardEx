package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.domain.Board;

public interface BoardRepositiry extends JpaRepository<Board, Long> {

}
