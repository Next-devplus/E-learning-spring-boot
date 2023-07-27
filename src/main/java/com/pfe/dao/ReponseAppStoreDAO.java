package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.ReponseApp;

@Transactional
@Repository
public class ReponseAppStoreDAO implements IReponseAppStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all ReponseApps available in database and return it as List<ReponseApp>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ReponseApp> getReponseApps() {
		
		String hql = "FROM ReponseApp as atcl ORDER BY atcl.id";
		return (List<ReponseApp>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular ReponseApp detail by given ReponseApp id 
	 */
	@Override
	public ReponseApp getReponseApp(int ReponseAppId) {
		
		return entityManager.find(ReponseApp.class, ReponseAppId);
	}

	/**
	 * This method is responsible to create new ReponseApp in database
	 */
	@Override
	public ReponseApp createReponseApp(ReponseApp ReponseApp) {
		entityManager.persist(ReponseApp);
		ReponseApp b = getLastInsertedReponseApp();
		return b;
	}

	/**
	 * This method is responsible to update ReponseApp detail in database
	 */
	@Override
	public ReponseApp updateReponseApp(int ReponseAppId, ReponseApp ReponseApp) {
		
		//First We are taking ReponseApp detail from database by given ReponseApp id and 
		// then updating detail with provided ReponseApp object
		ReponseApp ReponseAppFromDB = getReponseApp(ReponseAppId);
		ReponseAppFromDB.setDescription(ReponseApp.getDescription());
		 
		 
		entityManager.flush();
		
		//again i am taking updated result of ReponseApp and returning the ReponseApp object
		ReponseApp updatedReponseApp = getReponseApp(ReponseAppId);
		
		return updatedReponseApp;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteReponseApp(int ReponseAppId) {
		ReponseApp ReponseApp = getReponseApp(ReponseAppId);
		entityManager.remove(ReponseApp);
		
		//we are checking here that whether entityManager contains earlier deleted ReponseApp or not
		// if contains then ReponseApp is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(ReponseApp);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of ReponseApp class
	 * @return ReponseApp
	 */
	private ReponseApp getLastInsertedReponseApp(){
		String hql = "from ReponseApp order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		ReponseApp ReponseApp = (ReponseApp)query.getSingleResult();
		return ReponseApp;
	}

}
