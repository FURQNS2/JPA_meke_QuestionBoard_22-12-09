package com.sycompany.myb.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sycompany.myb.entity.Question;

import lombok.Data;

@Data
public class AnswerDto {


	private Integer id;   //답변 게시판 번호
	
	private String content;
	
	private LocalDateTime createTime;   // 답변게시판 등록일
	
	private Question question; // 질문게시판에 id를 가져와야 함
	
}
