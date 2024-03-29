package com.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.board.domain.Member;
import com.example.board.service.MemberService;

@SessionAttributes("member")
@Controller
public class LoginController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/login")
	public void login() {
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member findMember = memberService.getMember(member);
		
			if (findMember!= null && findMember.getPassword().equals(member.getPassword())) {
				model.addAttribute("member", findMember);
				return "forward:getBoardList";
			} else {
				return "redirect:login";
			}
	}
	
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
		
	}
}
