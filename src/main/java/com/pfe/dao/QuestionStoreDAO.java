package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Question;

@Transactional
@Repository
public class QuestionStoreDAO implements IQuestionStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Questions available in database and return it as List<Question>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestions() {
		
		String hql = "FROM Question as atcl ORDER BY atcl.id";
		return (List<Question>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Question detail by given Question id 
	 */
	@Override
	public Question getQuestion(int QuestionId) {
		
		return entityManager.find(Question.class, QuestionId);
	}

	/**
	 * This method is responsible to create new Question in database
	 */
	@Override
	public Question createQuestion(Question Question) {
		entityManager.persist(Question);
		Question b = getLastInsertedQuestion();
		return b;
	}

	/**
	 * This method is responsible to update Question detail in database
	 */
	@Override
	public Question updateQuestion(int QuestionId, Question Question) {
		
		//First We are taking Question detail from database by given Question id and 
		// then updating detail with provided Question object
		Question QuestionFromDB = getQuestion(QuestionId);
		QuestionFromDB.setDescription(Question.getDescription());
		 
		entityManager.flush();
		
		//again i am taking updated result of Question and returning the Question object
		Question updatedQuestion = getQuestion(QuestionId);
		
		return updatedQuestion;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteQuestion(int QuestionId) {
		Question Question = getQuestion(QuestionId);
		entityManager.remove(Question);
		
		//we are checking here that whether entityManager contains earlier deleted Question or not
		// if contains then Question is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Question);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Question class
	 * @return Question
	 */
	private Question getLastInsertedQuestion(){
		String hql = "from Question order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Question Question = (Question)query.getSingleResult();
		return Question;
	}

}
