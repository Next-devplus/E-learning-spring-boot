package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Formateur;

@Transactional
@Repository
public class FormateurStoreDAO implements IFormateurStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Formateurs available in database and return it as List<Formateur>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Formateur> getFormateurs() {
		
		String hql = "FROM Formateur as atcl ORDER BY atcl.id";
		return (List<Formateur>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Formateur detail by given Formateur id 
	 */
	@Override
	public Formateur getFormateur(int FormateurId) {
		
		return entityManager.find(Formateur.class, FormateurId);
	}

	/**
	 * This method is responsible to create new Formateur in database
	 */
	@Override
	public Formateur createFormateur(Formateur Formateur) {
		entityManager.persist(Formateur);
		Formateur b = getLastInsertedFormateur();
		return b;
	}

	/**
	 * This method is responsible to update Formateur detail in database
	 */
	@Override
	public Formateur updateFormateur(int FormateurId, Formateur Formateur) {
		
		//First We are taking Formateur detail from database by given Formateur id and 
		// then updating detail with provided Formateur object
		Formateur FormateurFromDB = getFormateur(FormateurId);
		FormateurFromDB.setNom(Formateur.getNom());
		FormateurFromDB.setPrenom(Formateur.getPrenom());
		FormateurFromDB.setUsername(Formateur.getUsername());
		FormateurFromDB.setPassword(Formateur.getPassword());
		FormateurFromDB.setEmail(Formateur.getEmail());
		FormateurFromDB.setGrade(Formateur.getGrade());
		FormateurFromDB.setPhoto(Formateur.getPhoto());
		entityManager.flush();
		
		//again i am taking updated result of Formateur and returning the Formateur object
		Formateur updatedFormateur = getFormateur(FormateurId);
		
		return updatedFormateur;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteFormateur(int FormateurId) {
		Formateur Formateur = getFormateur(FormateurId);
		entityManager.remove(Formateur);
		
		//we are checking here that whether entityManager contains earlier deleted Formateur or not
		// if contains then Formateur is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Formateur);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Formateur class
	 * @return Formateur
	 */
	private Formateur getLastInsertedFormateur(){
		String hql = "from Formateur order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Formateur Formateur = (Formateur)query.getSingleResult();
		return Formateur;
	}

}
