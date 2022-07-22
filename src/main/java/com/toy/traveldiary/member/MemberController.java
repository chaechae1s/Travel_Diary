package com.toy.traveldiary.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/signin")
	public String signin() {
		return "member/signin";
	}
	
	@PostMapping("/signup")
	public String signup(Member member) {
		memberService.save(member);
		return "member/signin";
	}
	
	
}
