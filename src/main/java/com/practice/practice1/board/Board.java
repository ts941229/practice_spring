package com.practice.practice1.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SequenceGenerator(
		name = "board_seq_generator",
		sequenceName = "board_seq",
		initialValue = 1,
		allocationSize = 1
)
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_generator")
	private long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false, unique = true)
	private String author;

	@Column(nullable = false)
	private String content;
	
	private String write_date;
	
	private String edit_date;

}
