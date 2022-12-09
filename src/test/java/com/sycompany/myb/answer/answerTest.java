package com.sycompany.myb.answer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.sycompany.myb.entity.Answer;
import com.sycompany.myb.entity.Question;
import com.sycompany.myb.repository.AnswerRepository;
import com.sycompany.myb.repository.QuestionRepository;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class answerTest {

	@Autowired
	private AnswerRepository answerRepository;
	
	// 질문에 답변이 달리는 것이기 때문에 두개 다 필요하다.
	@Autowired
	private QuestionRepository questionRepository;  
	
	
//	@Test
//	@DisplayName("답변생성테스트")
//	public void TestAnswer() {
//		
//		Optional<Question> q2 = questionRepository.findById(2);
//		Question qq = q2.get();  // 질문글 내용 가져오기
//		
//		Answer aa = new Answer();  // 빈 객체 생성
//		aa.setContent("답변드립니다."); // 제목 넣기
//		aa.setCreateTime(LocalDateTime.now());  // 답변 글 시간 작성
//		aa.setQuestion(qq);	// 질문글 넣고 거기에 답변달기
//		
//		answerRepository.save(aa);
//		
//	}
	
//	@Test
//	@DisplayName("답변생성테스트1")
//	public void TestAnswer2() {  // 답변있는지 조회하기
//		
//		Optional<Answer> a1 = answerRepository.findById(3);
//		Answer aa = a1.get();
//		
//		assertEquals("답변드립니다.", aa.getContent());
//		
//	}
//	

	@Test
	@Transactional
	@DisplayName("답변생성테스트3")
	public void TestAnswer3() {  // 질문에 달린 답변 조회하기
		
		Optional<Question> q2 = questionRepository.findById(2);
		Question qq = q2.get();  // 질문글 내용 가져오기
		
		List<Answer> answerList = qq.getAnswerList();
		
		assertEquals(1, answerList.size());  //답변개수 세알리기		
		assertEquals("답변드립니다.", answerList.get(0).getContent()); // 답변제목 조회하기
		
	}
	

}
