package com.sycompany.myb.question;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.sycompany.myb.entity.Question;
import com.sycompany.myb.repository.QuestionRepository;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class questiontest {

	@Autowired
	private QuestionRepository questionRepository;
	
//	@Test
//	@DisplayName("질문")
//	public void testQuestion01() {
//		Question q1 = new Question(); // 빈 객체
//		q1.setSubject("안녕하세요.");
//		q1.setContent("반갑습니다.");
//		q1.setCreateDate(LocalDateTime.now());  // 현재 시간 저장
//		//속성값이 초기화된 Question 객체가 만들어짐
//		questionRepository.save(q1);  // 첫번째 질문 생성 저장
//		
//		Question q2 = new Question(); // 빈 객체
//		q2.setSubject("질문있습니다.");
//		q2.setContent("cute합니다.");
//		q2.setCreateDate(LocalDateTime.now());  // 현재 시간 저장
//		//속성값이 초기화된 Question 객체가 만들어짐
//		questionRepository.save(q2);  // 두번째 질문 생성 저장
//	}
//	
//	@Test
//	@DisplayName("조회테스트")
//	public void testQuestion2() {
//		List<Question> qall = questionRepository.findAll();   //전체글 가져오기
//		assertEquals(2, qall.size());  // 전체 글의 개수를 가져와 기대하고 있는 글의 개수인 2와 비교확인
//	
//		Question q1 = qall.get(0); // 첫번재 글 가져오기		
//		assertEquals("안녕하세요.", q1.getSubject());
//		
//		Optional<Question> q2 = questionRepository.findById(2);
//		//Optional<Question> q3 = questionRepository.findById(3);
//		
//		if(q2.isPresent()) { //안에 내용있는지 묻기
//			Question qq = q2.get();   // Id 2번 글 전부 가져오기
//			assertEquals("질문있습니다.", qq.getSubject());  // Id 2번 글에 제목만 가져와서 참인지 확인하기
//		
//		}
//		
////		if(q3.isEmpty()) { // 안에 내용 없는지 묻기
////			System.out.println("q3 내용x");
////		}		
//		
//	}
	
	
//	@Test
//	@DisplayName("제목조회테스트")
//	public void testQuestionSubject() {  // 검색 단어
//		List<Question> questionList = questionRepository.findBySubjectLike("%질문%");   //전체글 가져오기
//		assertEquals("질문있습니다.", questionList.get(0).getSubject());  //Question 테이블에 조회된 값들 중 첫번째 값을 가져와서 확인해라 
//			
//	}
	
//	@Test
//	@DisplayName("수정테스트")
//	public void testQuestion5() {  // 검색 단어
//		Optional<Question> q1 = questionRepository.findById(1);   //전체글 가져오기
//
//		if(q1.isPresent()) {
//			 Question qq = q1.get();
//			 qq.setSubject("감사합니다!");
//			 questionRepository.save(qq);
//		}
//	}
	
	@Test
	@DisplayName("지우기테스트")
	public void testQuestion6() {  // 검색 단어
		Optional<Question> q1 = questionRepository.findById(1);   //전체글 가져오기

		if(q1.isPresent()) {
			 Question qq = q1.get();			 
			 questionRepository.delete(qq);
		}
			
	}
}
