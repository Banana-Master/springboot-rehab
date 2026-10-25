package com.example.springbootrehab.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.springbootrehab.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {
	@Override
	ArrayList<Member> findAll();
}
