package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Question;

public interface IQuestionStoreDAO {
	
	List<Question> getQuestions();
	Question getQuestion(int QuestionId);
	Question createQuestion(Question Question);
	Question updateQuestion(int QuestionId,Question Question);
	boolean deleteQuestion(int QuestionId);

}
