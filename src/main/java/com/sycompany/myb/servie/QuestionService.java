package com.sycompany.myb.servie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.stereotype.Service;

import com.sycompany.myb.repository.AnswerRepository;
import com.sycompany.myb.repository.QuestionRepository;

import com.sycompany.myb.dto.QuestionDto;
import com.sycompany.myb.entity.Question;
import com.sycompany.myb.exception.DataNotFoundException;

import lombok.RequiredArgsConstructor;
import oracle.net.aso.q;

@Service
@RequiredArgsConstructor
public class QuestionService {

	public final QuestionRepository questionRepository;
	public final AnswerRepository answerRepository;
	
	public List<QuestionDto> getQuestionList(){  //전체 글 불러서 리스트 만들어주기
		
		List<Question> questionList = questionRepository.findAll();
			
		List<QuestionDto> questionDtos = new ArrayList<QuestionDto>();
		
		for(int i=0; i<questionList.size(); i++) {
			Question question = questionList.get(i);
			QuestionDto questionDto = new QuestionDto();
			questionDto.setId(question.getId());
			questionDto.setContent(question.getContent());
			questionDto.setSubject(question.getSubject());
			questionDto.setCreateDate(question.getCreateDate());
			questionDto.setAnswerList(question.getAnswerList());
			
			questionDtos.add(questionDto);
		}
		return questionDtos;
		
//		Question question = null;
//		List<QuestionDto> questionDtos = null;
//		QuestionDto questionDto = null;
//		
//		for(int i=0; i<=questionList.size(); i++) {
//			
//			question = questionList.get(i);
//			
//			questionDto = new QuestionDto(); // 빈 Dto 만들기
//			questionDto.setId(Integer.parseInt(question.getId().toString()));
//			questionDto.setContent(question.getContent().toString());
//			questionDto.setSubject(question.getSubject().toString());
//						
//			//questionDto.setAnswerList(question.getAnswerList().toString());
//			
//			questionDtos.add(i, questionDto);
//		}
		//return questionDtos;
		//return questionList;
	}
	
	public QuestionDto getQuestion(Integer id){  // 질문글에 해당하는 답변들 가져오기
		
		Optional<Question> optQuestion = questionRepository.findById(id);  //DB테이블에 든 값 조회하기
		
		QuestionDto questionDto = new QuestionDto();  //빈 객체 생성
				
		if(optQuestion.isPresent()) {
			Question question = optQuestion.get(); // DB테이블컬럼명에 든 값 가져오기
			questionDto.setId(question.getId());
			questionDto.setContent(question.getContent());
			questionDto.setSubject(question.getSubject());
			questionDto.setCreateDate(question.getCreateDate());
			questionDto.setAnswerList(question.getAnswerList());
			
			return questionDto;
			
		} else {
			throw new DataNotFoundException("해당 질문이 없습니다.");
		}
		
	}
	
	public Question questionCreat(String subject, String content) {
		
		Question q = new Question();
		
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		
		return questionRepository.save(q); 
		
	}
}
