package com.practice.practice1.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@SequenceGenerator(
		name = "board_seq_generator",
		sequenceName = "board_seq",
		initialValue = 1,
		allocationSize = 1
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
	
	@Builder
	protected Board(long id, String title, String author, String content, String write_date, String edit_date) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
		this.write_date = write_date;
		this.edit_date = edit_date;
	}

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
