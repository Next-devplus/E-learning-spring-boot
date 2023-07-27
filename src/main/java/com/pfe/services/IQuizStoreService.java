package com.pfe.services;

import java.util.List;

import com.pfe.entity.Quiz;

public interface IQuizStoreService {
	
	List<Quiz> getQuizs();
	Quiz createQuiz(Quiz Quiz);
	Quiz updateQuiz(int QuizId, Quiz Quiz);
	Quiz getQuiz(int QuizId);
	boolean deleteQuiz(int QuizId);

}
