package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.board.domain.Board;
import com.example.board.domain.Member;
import com.example.board.service.BoardService;

@SessionAttributes("member")
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService; 
	
	public Member setMember() {
		return new Member();
	}
	
	@RequestMapping("getBoardList")
	public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {
		if (member.getId()==null) {
			return "redirect:login";
		}
		List<Board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}
	
	@GetMapping("/insertBoard")	// inseretBoard페이지로 이동 
	public String insertBoard(@ModelAttribute("member") Member member) {
		if (member.getId()==null) {
			return "redirect:login";
		}
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")	// insertBoard 새글 등록
	public String insertBoard(@ModelAttribute("member") Member member,Board board) {
		if (member.getId()==null) {
			return "redirect:login";
		}
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")	// 글 상세보기
	public String getBoard(@ModelAttribute("member") Member member, Model model, Board board) {
		if (member.getId()==null) {
			return "redirect:login";
		}
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	@GetMapping("/updateBoard")	// 글 수정 페이지로 이동
	public String updateBoard(@ModelAttribute("member") Member member, Model model, Board board) {
		if (member.getId()==null) {
			return "redirect:login";
		}
		model.addAttribute("board", boardService.getBoard(board));
		return "updateBoard";
	}
	
	@PostMapping("/updateBoard")	// 글 수정
	public String updateBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId()==null) {
			return "redirect:login";
		}
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("/deleteBoard")	// 글 삭제
	public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId()==null) {
			return "redirect:login";
		}
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	@GetMapping("/hello")
	public void hello(Model model) {
		
		String str = "hello 타임리프";
		model.addAttribute("greeting", str);
	}
}
