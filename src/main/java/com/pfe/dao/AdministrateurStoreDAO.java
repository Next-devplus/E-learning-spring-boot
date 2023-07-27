package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Administrateur;
 

@Transactional
@Repository
public class AdministrateurStoreDAO implements IAdministrateurStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Administrateurs available in database and return it as List<Administrateur>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Administrateur> getAdministrateurs() {
		
		String hql = "FROM Administrateur as atcl ORDER BY atcl.id";
		return (List<Administrateur>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Administrateur detail by given Administrateur id 
	 */
	@Override
	public Administrateur getAdministrateur(int AdministrateurId) {
		
		return entityManager.find(Administrateur.class, AdministrateurId);
	}

	/**
	 * This method is responsible to create new Administrateur in database
	 */
	@Override
	public Administrateur createAdministrateur(Administrateur Administrateur) {
		entityManager.persist(Administrateur);
		Administrateur b = getLastInsertedAdministrateur();
		return b;
	}

	/**
	 * This method is responsible to update Administrateur detail in database
	 */
	@Override
	public Administrateur updateAdministrateur(int AdministrateurId, Administrateur Administrateur) {
		
		//First We are taking Administrateur detail from database by given Administrateur id and 
		// then updating detail with provided Administrateur object
		Administrateur AdministrateurFromDB = getAdministrateur(AdministrateurId);
		AdministrateurFromDB.setNom(Administrateur.getNom());
		AdministrateurFromDB.setPrenom(Administrateur.getPrenom());
		AdministrateurFromDB.setUsername(Administrateur.getUsername());
		AdministrateurFromDB.setPassword(Administrateur.getPassword());
	 
	 
	 
		
		//again i am taking updated result of Administrateur and returning the Administrateur object
		Administrateur updatedAdministrateur = getAdministrateur(AdministrateurId);
		
		return updatedAdministrateur;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteAdministrateur(int AdministrateurId) {
		Administrateur Administrateur = getAdministrateur(AdministrateurId);
		entityManager.remove(Administrateur);
		
		//we are checking here that whether entityManager contains earlier deleted Administrateur or not
		// if contains then Administrateur is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Administrateur);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Administrateur class
	 * @return Administrateur
	 */
	private Administrateur getLastInsertedAdministrateur(){
		String hql = "from Administrateur order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Administrateur Administrateur = (Administrateur)query.getSingleResult();
		return Administrateur;
	}
	
	
	 

}
