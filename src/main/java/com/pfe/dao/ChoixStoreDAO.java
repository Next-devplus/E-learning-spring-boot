package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Choix;

@Transactional
@Repository
public class ChoixStoreDAO implements IChoixStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Choixs available in database and return it as List<Choix>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Choix> getChoixs() {
		
		String hql = "FROM Choix as atcl ORDER BY atcl.id";
		return (List<Choix>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Choix detail by given Choix id 
	 */
	@Override
	public Choix getChoix(int ChoixId) {
		
		return entityManager.find(Choix.class, ChoixId);
	}

	/**
	 * This method is responsible to create new Choix in database
	 */
	@Override
	public Choix createChoix(Choix Choix) {
		entityManager.persist(Choix);
		Choix b = getLastInsertedChoix();
		return b;
	}

	/**
	 * This method is responsible to update Choix detail in database
	 */
	@Override
	public Choix updateChoix(int ChoixId, Choix Choix) {
		
		//First We are taking Choix detail from database by given Choix id and 
		// then updating detail with provided Choix object
		Choix ChoixFromDB = getChoix(ChoixId);
		ChoixFromDB.setDescription(Choix.getDescription());
	 
		 
		
		entityManager.flush();
		
		//again i am taking updated result of Choix and returning the Choix object
		Choix updatedChoix = getChoix(ChoixId);
		
		return updatedChoix;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteChoix(int ChoixId) {
		Choix Choix = getChoix(ChoixId);
		entityManager.remove(Choix);
		
		//we are checking here that whether entityManager contains earlier deleted Choix or not
		// if contains then Choix is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Choix);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Choix class
	 * @return Choix
	 */
	private Choix getLastInsertedChoix(){
		String hql = "from Choix order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Choix Choix = (Choix)query.getSingleResult();
		return Choix;
	}

}
