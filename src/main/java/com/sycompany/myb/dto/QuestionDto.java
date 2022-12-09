package com.sycompany.myb.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sycompany.myb.entity.Answer;

import lombok.Data;

@Data
public class QuestionDto {
	
	private Integer id; //질문게시판 번호
	private String subject; //질문게시판 제목
	private String content; // 질문게시판 내용
	private LocalDateTime createDate; // 질문 글 등록일시
	
	private List<Answer> answerList;

}
