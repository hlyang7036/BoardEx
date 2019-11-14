package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.Board;
import com.example.board.repository.BoardRepositiry;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepositiry boardRepo;
	
	@Override
	public List<Board> getBoardList(Board board){
		return (List<Board>) boardRepo.findAll();
	}
	
	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	@Override
	public Board getBoard(Board board) {
		return null;
	}
	@Override
	public void updateBoard(Board board) {
		
	}
	@Override
	public void deleteBoard(Board board) {
		
	}
	
}
