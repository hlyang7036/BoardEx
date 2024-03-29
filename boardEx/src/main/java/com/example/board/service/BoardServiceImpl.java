package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.board.domain.Board;
import com.example.board.repository.BoardRepositiry;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepositiry boardRepo;
	
	@Override
	public List<Board> getBoardList(Board board){
		return (List<Board>) boardRepo.findAllByOrderBySeqDesc();
	}
	
	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	@Override
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}
	@Override
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
	}
	@Override
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
	}
}
