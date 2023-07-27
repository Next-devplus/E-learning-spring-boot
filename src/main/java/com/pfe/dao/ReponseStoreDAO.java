package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Reponse;

@Transactional
@Repository
public class ReponseStoreDAO implements IReponseStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Reponses available in database and return it as List<Reponse>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Reponse> getReponses() {
		
		String hql = "FROM Reponse as atcl ORDER BY atcl.id";
		return (List<Reponse>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Reponse detail by given Reponse id 
	 */
	@Override
	public Reponse getReponse(int ReponseId) {
		
		return entityManager.find(Reponse.class, ReponseId);
	}

	/**
	 * This method is responsible to create new Reponse in database
	 */
	@Override
	public Reponse createReponse(Reponse Reponse) {
		entityManager.persist(Reponse);
		Reponse b = getLastInsertedReponse();
		return b;
	}

	/**
	 * This method is responsible to update Reponse detail in database
	 */
	@Override
	public Reponse updateReponse(int ReponseId, Reponse Reponse) {
		
		//First We are taking Reponse detail from database by given Reponse id and 
		// then updating detail with provided Reponse object
		Reponse ReponseFromDB = getReponse(ReponseId);
		ReponseFromDB.setDescription(Reponse.getDescription());
		 
		 
		entityManager.flush();
		
		//again i am taking updated result of Reponse and returning the Reponse object
		Reponse updatedReponse = getReponse(ReponseId);
		
		return updatedReponse;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteReponse(int ReponseId) {
		Reponse Reponse = getReponse(ReponseId);
		entityManager.remove(Reponse);
		
		//we are checking here that whether entityManager contains earlier deleted Reponse or not
		// if contains then Reponse is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Reponse);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Reponse class
	 * @return Reponse
	 */
	private Reponse getLastInsertedReponse(){
		String hql = "from Reponse order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Reponse Reponse = (Reponse)query.getSingleResult();
		return Reponse;
	}

}
