package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Paiement;

@Transactional
@Repository
public class PaiementStoreDAO implements IPaiementStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Paiements available in database and return it as List<Paiement>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Paiement> getPaiements() {
		
		String hql = "FROM Paiement as atcl ORDER BY atcl.id";
		return (List<Paiement>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Paiement detail by given Paiement id 
	 */
	@Override
	public Paiement getPaiement(int PaiementId) {
		
		return entityManager.find(Paiement.class, PaiementId);
	}

	/**
	 * This method is responsible to create new Paiement in database
	 */
	@Override
	public Paiement createPaiement(Paiement Paiement) {
		entityManager.persist(Paiement);
		Paiement b = getLastInsertedPaiement();
		return b;
	}

	/**
	 * This method is responsible to update Paiement detail in database
	 */
	@Override
	public Paiement updatePaiement(int PaiementId, Paiement Paiement) {
		
		//First We are taking Paiement detail from database by given Paiement id and 
		// then updating detail with provided Paiement object
		Paiement PaiementFromDB = getPaiement(PaiementId);
		PaiementFromDB.setDate(Paiement.getDate());
	 
		entityManager.flush();
		
		//again i am taking updated result of Paiement and returning the Paiement object
		Paiement updatedPaiement = getPaiement(PaiementId);
		
		return updatedPaiement;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deletePaiement(int PaiementId) {
		Paiement Paiement = getPaiement(PaiementId);
		entityManager.remove(Paiement);
		
		//we are checking here that whether entityManager contains earlier deleted Paiement or not
		// if contains then Paiement is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Paiement);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Paiement class
	 * @return Paiement
	 */
	private Paiement getLastInsertedPaiement(){
		String hql = "from Paiement order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Paiement Paiement = (Paiement)query.getSingleResult();
		return Paiement;
	}

}
