package com.pfe.services;

import java.util.List;

import com.pfe.entity.Question;

public interface IQuestionStoreService {
	
	List<Question> getQuestions();
	Question createQuestion(Question Question);
	Question updateQuestion(int QuestionId, Question Question);
	Question getQuestion(int QuestionId);
	boolean deleteQuestion(int QuestionId);

}
