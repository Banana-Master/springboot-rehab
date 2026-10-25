package com.example.springbootrehab.dto;

import com.example.springbootrehab.entity.Member;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberForm {
	private String email;
	private String password;

	public Member toEntity() {
		return new Member(null, email, password);
	}
}
