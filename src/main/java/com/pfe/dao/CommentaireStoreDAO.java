package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Commentaire;

@Transactional
@Repository
public class CommentaireStoreDAO implements ICommentaireStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Commentaires available in database and return it as List<Commentaire>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Commentaire> getCommentaires() {
		
		String hql = "FROM Commentaire as atcl ORDER BY atcl.id";
		return (List<Commentaire>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Commentaire detail by given Commentaire id 
	 */
	@Override
	public Commentaire getCommentaire(int CommentaireId) {
		
		return entityManager.find(Commentaire.class, CommentaireId);
	}

	/**
	 * This method is responsible to create new Commentaire in database
	 */
	@Override
	public Commentaire createCommentaire(Commentaire Commentaire) {
		entityManager.persist(Commentaire);
		Commentaire b = getLastInsertedCommentaire();
		return b;
	}

	/**
	 * This method is responsible to update Commentaire detail in database
	 */
	@Override
	public Commentaire updateCommentaire(int CommentaireId, Commentaire Commentaire) {
		
		//First We are taking Commentaire detail from database by given Commentaire id and 
		// then updating detail with provided Commentaire object
		Commentaire CommentaireFromDB = getCommentaire(CommentaireId);
		CommentaireFromDB.setContenu(Commentaire.getContenu());
	 
		 
		entityManager.flush();
		
		//again i am taking updated result of Commentaire and returning the Commentaire object
		Commentaire updatedCommentaire = getCommentaire(CommentaireId);
		
		return updatedCommentaire;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteCommentaire(int CommentaireId) {
		Commentaire Commentaire = getCommentaire(CommentaireId);
		entityManager.remove(Commentaire);
		
		//we are checking here that whether entityManager contains earlier deleted Commentaire or not
		// if contains then Commentaire is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Commentaire);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Commentaire class
	 * @return Commentaire
	 */
	private Commentaire getLastInsertedCommentaire(){
		String hql = "from Commentaire order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Commentaire Commentaire = (Commentaire)query.getSingleResult();
		return Commentaire;
	}

}
