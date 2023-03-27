package com.practice.practice1.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;

@Entity
@Getter
@SequenceGenerator(
		name = "board_seq_generator",
		sequenceName = "board_seq",
		initialValue = 1,
		allocationSize = 1
)
public class Board {
	
	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "content")
	private String content;

}
