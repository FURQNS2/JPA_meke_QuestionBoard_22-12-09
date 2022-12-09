package com.sycompany.myb.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;   //답변 게시판 번호
	
	@Column(length = 1000)
	private String content;
	
	@Column(updatable = false)
	private LocalDateTime createTime;   // 답변게시판 등록일
	
	@ManyToOne  // n:1  질문하나에 답변여러개(질문-부모, 답변-자식 부모자식 관계)
	private Question question; // 질문게시판에 id를 가져와야 함
	
	
}
