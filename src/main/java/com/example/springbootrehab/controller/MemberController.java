package com.example.springbootrehab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springbootrehab.dto.MemberForm;
import com.example.springbootrehab.entity.Member;
import com.example.springbootrehab.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		log.info(form.toString());
		// System.out.println(form.toString());
		Member member = form.toEntity();
		log.info(member.toString());
		// System.out.println(member.toString());
		Member saved = memberRepository.save(member);
		log.info(saved.toString());
		// System.out.println(saved.toString());
		return "";
	}

	@GetMapping("/members/{id}")
	public String join(@PathVariable Long id, Model model) {
		Member memberEntity = memberRepository.findById(id).orElse(null);
		model.addAttribute("member", memberEntity);
		return "members/show";
	}

	@GetMapping("/members")
	public String index(Model model) {
		List<Member> memberEntityList = memberRepository.findAll();
		model.addAttribute("memberList", memberEntityList);
		return "members/index";
	}
}
