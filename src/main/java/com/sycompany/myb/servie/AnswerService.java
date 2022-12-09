package com.sycompany.myb.servie;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sycompany.myb.entity.Answer;
import com.sycompany.myb.entity.Question;
import com.sycompany.myb.repository.AnswerRepository;
import com.sycompany.myb.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {

	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	
	public void answerCreate(Integer id, String content) {
		
		Optional<Question> optQuestion = questionRepository.findById(id);
		Question question = optQuestion.get();
		
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateTime(LocalDateTime.now());
		answer.setQuestion(question);

		answerRepository.save(answer);
		
		
	}
}
