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

import com.pfe.entity.Quiz;
import com.pfe.services.IQuizStoreService;

@Controller
@RequestMapping("Quizservice")
public class QuizStoreController {
	
	@Autowired
	private IQuizStoreService service;
	
	@GetMapping("Quizs")
	public ResponseEntity<List<Quiz>> getQuizs(){
		
		List<Quiz> Quizs = service.getQuizs();
		return new ResponseEntity<List<Quiz>>(Quizs, HttpStatus.OK);
		
	}
	
	@GetMapping("Quizs/{id}")
	public ResponseEntity<Quiz> getQuiz(@PathVariable("id") Integer id){
		Quiz Quiz = service.getQuiz(id);
		return new ResponseEntity<Quiz>(Quiz, HttpStatus.OK);
	}
	
	@PostMapping("Quizs")
	public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz Quiz){
		Quiz b = service.createQuiz(Quiz);
		return new ResponseEntity<Quiz>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Quizs/{id}")
	public ResponseEntity<Quiz> updateQuiz(@PathVariable("id") int id, @RequestBody Quiz Quiz){
		
		Quiz b = service.updateQuiz(id, Quiz);
		return new ResponseEntity<Quiz>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Quizs/{id}")
	public ResponseEntity<String> deleteQuiz(@PathVariable("id") int id){
		boolean isDeleted = service.deleteQuiz(id);
		if(isDeleted){
			String responseContent = "Quiz has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Quiz from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
