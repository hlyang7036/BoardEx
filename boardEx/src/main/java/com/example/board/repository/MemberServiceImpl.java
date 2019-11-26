package com.example.board.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.board.domain.Member;

public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public Member getMember(Member member) {
		Optional<Member> findMember = memberRepo.findById(member.getId());
		if (findMember.isPresent()) 
			return findMember.get();
		
		else return null;
	}
}
	