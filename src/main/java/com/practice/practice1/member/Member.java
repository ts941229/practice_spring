package com.practice.practice1.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;

@Getter
@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq", allocationSize = 1, initialValue = 1)
public class Member {

	@Id
	@GeneratedValue(generator = "member_seq_generator", strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
}
