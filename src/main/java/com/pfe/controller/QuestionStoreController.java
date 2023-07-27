package com.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.entity.Question;
import com.pfe.entity.Choix;
import com.pfe.services.IQuestionStoreService;
import com.pfe.services.IChoixStoreService;

@Controller
@RequestMapping("Questionservice")
public class QuestionStoreController {
	
	@Autowired
	private IQuestionStoreService service;
	private IChoixStoreService serviceChoix;
	@GetMapping("ListQuestions")
	public ResponseEntity<List<Question>> getQuestions(){
		
		List<Question> Questions = service.getQuestions();
		return new ResponseEntity<List<Question>>(Questions, HttpStatus.OK);
		
	}
	
	@GetMapping("GetQuestions/{id}")
	public ResponseEntity<Question> getQuestion(@PathVariable("id") Integer id){
		
	 
		Question Question = service.getQuestion(id);
		 //Choix  Choix = serviceChoix.getChoix(id);
		
		return new ResponseEntity<Question>(Question, HttpStatus.OK);
		// ResponseEntity<Choix>(Choix, HttpStatus.OK);
		 
	}
	
	@PostMapping("Ajout")
	public ResponseEntity<Question> createQuestion(@RequestBody Question Question){
		Question b = service.createQuestion(Question);
		return new ResponseEntity<Question>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Questions/{id}")
	public ResponseEntity<Question> updateQuestion(@PathVariable("id") int id, @RequestBody Question Question){
		
		Question b = service.updateQuestion(id, Question);
		return new ResponseEntity<Question>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Questions/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable("id") int id){
		boolean isDeleted = service.deleteQuestion(id);
		if(isDeleted){
			String responseContent = "Question has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Question from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
