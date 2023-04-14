package com.practice.practice1.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.practice1.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
