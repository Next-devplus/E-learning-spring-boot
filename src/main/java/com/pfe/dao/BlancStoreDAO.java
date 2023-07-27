package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Blanc;

@Transactional
@Repository
public class BlancStoreDAO implements IBlancStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Blancs available in database and return it as List<Blanc>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Blanc> getBlancs() {
		
		String hql = "FROM Blanc as atcl ORDER BY atcl.id";
		return (List<Blanc>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Blanc detail by given Blanc id 
	 */
	@Override
	public Blanc getBlanc(int BlancId) {
		
		return entityManager.find(Blanc.class, BlancId);
	}

	/**
	 * This method is responsible to create new Blanc in database
	 */
	@Override
	public Blanc createBlanc(Blanc Blanc) {
		entityManager.persist(Blanc);
		Blanc b = getLastInsertedBlanc();
		return b;
	}

	/**
	 * This method is responsible to update Blanc detail in database
	 */
	@Override
	public Blanc updateBlanc(int BlancId, Blanc Blanc) {
		
		//First We are taking Blanc detail from database by given Blanc id and 
		// then updating detail with provided Blanc object
		Blanc BlancFromDB = getBlanc(BlancId);
		BlancFromDB.setDate(Blanc.getDate());
		BlancFromDB.setExamen(Blanc.getExamen());
		 
		
		entityManager.flush();
		
		//again i am taking updated result of Blanc and returning the Blanc object
		Blanc updatedBlanc = getBlanc(BlancId);
		
		return updatedBlanc;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteBlanc(int BlancId) {
		Blanc Blanc = getBlanc(BlancId);
		entityManager.remove(Blanc);
		
		//we are checking here that whether entityManager contains earlier deleted Blanc or not
		// if contains then Blanc is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Blanc);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Blanc class
	 * @return Blanc
	 */
	private Blanc getLastInsertedBlanc(){
		String hql = "from Blanc order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Blanc Blanc = (Blanc)query.getSingleResult();
		return Blanc;
	}

}
