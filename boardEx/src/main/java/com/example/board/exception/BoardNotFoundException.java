package com.example.board.exception;

public class BoardNotFoundException extends BoardException {
	
	private static final long serialVersonUID = 1L;
	
	public BoardNotFoundException(String message) {
		super(message);
	}
	
}
