package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Apprenant;

@Transactional
@Repository
public class ApprenantStoreDAO implements IApprenantStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Apprenants available in database and return it as List<Apprenant>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Apprenant> getApprenants() {
		
		String hql = "FROM Apprenant as atcl ORDER BY atcl.id";
		return (List<Apprenant>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Apprenant detail by given Apprenant id 
	 */
	@Override
	public Apprenant getApprenant(int ApprenantId) {
		
		return entityManager.find(Apprenant.class, ApprenantId);
	}

	/**
	 * This method is responsible to create new Apprenant in database
	 */
	@Override
	public Apprenant createApprenant(Apprenant Apprenant) {
		entityManager.persist(Apprenant);
		Apprenant b = getLastInsertedApprenant();
		return b;
	}

	/**
	 * This method is responsible to update Apprenant detail in database
	 */
	@Override
	public Apprenant updateApprenant(int ApprenantId, Apprenant Apprenant) {
		
		//First We are taking Apprenant detail from database by given Apprenant id and 
		// then updating detail with provided Apprenant object
		Apprenant ApprenantFromDB = getApprenant(ApprenantId);
		ApprenantFromDB.setNom(Apprenant.getNom());
		ApprenantFromDB.setPrenom(Apprenant.getPrenom());
		ApprenantFromDB.setUsername(Apprenant.getUsername());
		ApprenantFromDB.setPassword(Apprenant.getPassword());
		ApprenantFromDB.setEmail(Apprenant.getEmail());
		ApprenantFromDB.setNiveau(Apprenant.getNiveau());
		ApprenantFromDB.setTelephone(Apprenant.getTelephone());
		ApprenantFromDB.setPhoto(Apprenant.getPhoto());
		entityManager.flush();
		
		//again i am taking updated result of Apprenant and returning the Apprenant object
		Apprenant updatedApprenant = getApprenant(ApprenantId);
		
		return updatedApprenant;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteApprenant(int ApprenantId) {
		Apprenant Apprenant = getApprenant(ApprenantId);
		entityManager.remove(Apprenant);
		
		//we are checking here that whether entityManager contains earlier deleted Apprenant or not
		// if contains then Apprenant is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Apprenant);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Apprenant class
	 * @return Apprenant
	 */
	private Apprenant getLastInsertedApprenant(){
		String hql = "from Apprenant order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Apprenant Apprenant = (Apprenant)query.getSingleResult();
		return Apprenant;
	}

}
