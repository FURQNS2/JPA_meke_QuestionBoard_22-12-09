package com.sycompany.myb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sycompany.myb.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

	// 정확히 검색한 글자가 일치하는 것만 찾음
	public List<Question> findBySubject(String Subject);
	
	// 검색어랑 비슷한 글 전부 가져옴
	public List<Question> findBySubjectLike(String Subject);
	
	public List<Question> findBySubjectOrderByIdDesc(String Subject);
}
