package com.sycompany.myb.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sycompany.myb.dto.QuestionDto;
import com.sycompany.myb.entity.Question;
import com.sycompany.myb.repository.AnswerRepository;
import com.sycompany.myb.repository.QuestionRepository;
import com.sycompany.myb.servie.AnswerService;
import com.sycompany.myb.servie.QuestionService;

import lombok.RequiredArgsConstructor;
import oracle.net.aso.q;

@RequiredArgsConstructor
@Controller
public class MainController {

	
//	private final QuestionRepository questionRepository;
//	private final AnswerRepository answerRepository;
	
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	@RequestMapping("")
	public String index() {  // 첫화면 리스트로 보내기
		return "redirect:list";
	}
	
	@RequestMapping("/question_List") // 리스트로 보내기
	public String questionList() {
		return "question_List";
	}
	
	@RequestMapping("/list")
	public String list(Model model) { // 리스트에 보일값들 view로 보내기
	
		//List<Question> questionList =  questionRepository.findAll();
		
//		List<QuestionDto> questionList = questionService.getQuestionList();
		
		model.addAttribute("questionList", questionService.getQuestionList());		
		
		return "question_List";
	}
	
	@RequestMapping("/questionView/{id}")    // 따로 id값을 작성해줘야 인식함
	public String questionView(@PathVariable("id") Integer id, Model model) {
		
		QuestionDto question = questionService.getQuestion(id);
		
		model.addAttribute("question", question);
		
		return "question_view";
	}
	
	
	@RequestMapping("/answerCreate/{id}")
	public String answerCreate(@PathVariable("id") Integer id, @RequestParam String content) {
			
		answerService.answerCreate(id, content);
		
		return String.format("redirect:/questionView/%s", id);
	}
	
	
	
	@RequestMapping("/question_form")
	public String questionCreate() {
		
		return "question_form";
	}
	
	@RequestMapping("/questionCreate")
	public String questionCreateOk(@RequestParam String subject, @RequestParam String content) {
		
		questionService.questionCreat(subject, content);
		
		return "redirect:list";
	}
}
