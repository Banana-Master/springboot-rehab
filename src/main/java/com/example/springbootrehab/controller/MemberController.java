package com.example.springbootrehab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springbootrehab.dto.MemberForm;
import com.example.springbootrehab.entity.Member;
import com.example.springbootrehab.repository.MemberRepository;

@Controller
public class MemberController {
	@Autowired
	private MemberRepository memberRepository;

	@GetMapping("/signup")
	public String memberSignupForm() {
		return "members/new";
	}


	@PostMapping("/join")
	public String memberSignup(MemberForm form) {
		System.out.println(form.toString());
		Member member = form.toEntity();
		System.out.println(member.toString());
		Member saved = memberRepository.save(member);
		System.out.println(saved.toString());
		return "";
	}
}
