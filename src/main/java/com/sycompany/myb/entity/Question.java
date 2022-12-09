package com.sycompany.myb.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id; //질문게시판 번호
	
	@Column(length = 300)
	private String subject; //질문게시판 제목
	
	@Column(length = 1000)
	private String content; // 질문게시판 내용
	
	//@Column(updatable = false)
	private LocalDateTime createDate; // 질문 글 등록일시
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)  // 1:n
	private List<Answer> answerList;
	
}
