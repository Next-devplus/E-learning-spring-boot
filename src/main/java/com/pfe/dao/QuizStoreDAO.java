package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Quiz;

@Transactional
@Repository
public class QuizStoreDAO implements IQuizStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Quizs available in database and return it as List<Quiz>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Quiz> getQuizs() {
		
		String hql = "FROM Quiz as atcl ORDER BY atcl.id";
		return (List<Quiz>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Quiz detail by given Quiz id 
	 */
	@Override
	public Quiz getQuiz(int QuizId) {
		
		return entityManager.find(Quiz.class, QuizId);
	}

	/**
	 * This method is responsible to create new Quiz in database
	 */
	@Override
	public Quiz createQuiz(Quiz Quiz) {
		entityManager.persist(Quiz);
		Quiz b = getLastInsertedQuiz();
		return b;
	}

	/**
	 * This method is responsible to update Quiz detail in database
	 */
	@Override
	public Quiz updateQuiz(int QuizId, Quiz Quiz) {
		
		//First We are taking Quiz detail from database by given Quiz id and 
		// then updating detail with provided Quiz object
		Quiz QuizFromDB = getQuiz(QuizId);
		QuizFromDB.setNote(Quiz.getNote());
		 
		 
		entityManager.flush();
		
		//again i am taking updated result of Quiz and returning the Quiz object
		Quiz updatedQuiz = getQuiz(QuizId);
		
		return updatedQuiz;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteQuiz(int QuizId) {
		Quiz Quiz = getQuiz(QuizId);
		entityManager.remove(Quiz);
		
		//we are checking here that whether entityManager contains earlier deleted Quiz or not
		// if contains then Quiz is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Quiz);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Quiz class
	 * @return Quiz
	 */
	private Quiz getLastInsertedQuiz(){
		String hql = "from Quiz order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Quiz Quiz = (Quiz)query.getSingleResult();
		return Quiz;
	}

}
