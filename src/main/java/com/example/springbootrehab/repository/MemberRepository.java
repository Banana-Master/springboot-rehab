package com.example.springbootrehab.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springbootrehab.entity.Member;

public interface MemberRepository extends CrudRepository<Member, String> {
}
