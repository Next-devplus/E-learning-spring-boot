package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Categorie;

@Transactional
@Repository
public class CategorieStoreDAO implements ICategorieStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Categories available in database and return it as List<Categorie>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> getCategories() {
		
		String hql = "FROM Categorie as atcl ORDER BY atcl.id";
		return (List<Categorie>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Categorie detail by given Categorie id 
	 */
	@Override
	public Categorie getCategorie(int CategorieId) {
		
		return entityManager.find(Categorie.class, CategorieId);
	}

	/**
	 * This method is responsible to create new Categorie in database
	 */
	@Override
	public Categorie createCategorie(Categorie Categorie) {
		entityManager.persist(Categorie);
		Categorie b = getLastInsertedCategorie();
		return b;
	}

	/**
	 * This method is responsible to update Categorie detail in database
	 */
	@Override
	public Categorie updateCategorie(int CategorieId, Categorie Categorie) {
		
		//First We are taking Categorie detail from database by given Categorie id and 
		// then updating detail with provided Categorie object
		Categorie CategorieFromDB = getCategorie(CategorieId);
		CategorieFromDB.setNom(Categorie.getNom());
	 
		
		entityManager.flush();
		
		//again i am taking updated result of Categorie and returning the Categorie object
		Categorie updatedCategorie = getCategorie(CategorieId);
		
		return updatedCategorie;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteCategorie(int CategorieId) {
		Categorie Categorie = getCategorie(CategorieId);
		entityManager.remove(Categorie);
		
		//we are checking here that whether entityManager contains earlier deleted Categorie or not
		// if contains then Categorie is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Categorie);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Categorie class
	 * @return Categorie
	 */
	private Categorie getLastInsertedCategorie(){
		String hql = "from Categorie order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Categorie Categorie = (Categorie)query.getSingleResult();
		return Categorie;
	}

}
