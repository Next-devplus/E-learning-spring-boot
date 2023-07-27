package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Chapitre;

@Transactional
@Repository
public class ChapitreStoreDAO implements IChapitreStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Chapitres available in database and return it as List<Chapitre>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Chapitre> getChapitres() {
		
		String hql = "FROM Chapitre as atcl ORDER BY atcl.id";
		return (List<Chapitre>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Chapitre detail by given Chapitre id 
	 */
	@Override
	public Chapitre getChapitre(int ChapitreId) {
		
		return entityManager.find(Chapitre.class, ChapitreId);
	}

	/**
	 * This method is responsible to create new Chapitre in database
	 */
	@Override
	public Chapitre createChapitre(Chapitre Chapitre) {
		entityManager.persist(Chapitre);
		Chapitre b = getLastInsertedChapitre();
		return b;
	}

	/**
	 * This method is responsible to update Chapitre detail in database
	 */
	@Override
	public Chapitre updateChapitre(int ChapitreId, Chapitre Chapitre) {
		
		//First We are taking Chapitre detail from database by given Chapitre id and 
		// then updating detail with provided Chapitre object
		Chapitre ChapitreFromDB = getChapitre(ChapitreId);
		ChapitreFromDB.setContenu(Chapitre.getContenu());
		 
 
	 
		 
		
		entityManager.flush();
		
		//again i am taking updated result of Chapitre and returning the Chapitre object
		Chapitre updatedChapitre = getChapitre(ChapitreId);
		
		return updatedChapitre;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteChapitre(int ChapitreId) {
		Chapitre Chapitre = getChapitre(ChapitreId);
		entityManager.remove(Chapitre);
		
		//we are checking here that whether entityManager contains earlier deleted Chapitre or not
		// if contains then Chapitre is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Chapitre);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Chapitre class
	 * @return Chapitre
	 */
	private Chapitre getLastInsertedChapitre(){
		String hql = "from Chapitre order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Chapitre Chapitre = (Chapitre)query.getSingleResult();
		return Chapitre;
	}

}
