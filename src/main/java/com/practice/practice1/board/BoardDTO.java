package com.practice.practice1.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	
	private long id;
	private String title;
	private String author;
	private String content;
	private String write_date;
	private String edit_date;
	
}
