package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.IQuestionStoreDAO;
import com.pfe.entity.Question;

@Service
public class QuestionStoreService implements IQuestionStoreService {
	
	@Autowired
	private IQuestionStoreDAO dao;

	@Override
	public List<Question> getQuestions() {
		return dao.getQuestions();
	}

	@Override
	public Question createQuestion(Question Question) {
		return dao.createQuestion(Question);
	}

	@Override
	public Question updateQuestion(int QuestionId, Question Question) {
		return dao.updateQuestion(QuestionId, Question);
	}

	@Override
	public Question getQuestion(int QuestionId) {
		return dao.getQuestion(QuestionId);
	}

	@Override
	public boolean deleteQuestion(int QuestionId) {
		return dao.deleteQuestion(QuestionId);
	}

}
