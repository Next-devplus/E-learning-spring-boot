package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Examen;

@Transactional
@Repository
public class ExamenStoreDAO implements IExamenStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Examens available in database and return it as List<Examen>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Examen> getExamens() {
		
		String hql = "FROM Examen as atcl ORDER BY atcl.id";
		return (List<Examen>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Examen detail by given Examen id 
	 */
	@Override
	public Examen getExamen(int ExamenId) {
		
		return entityManager.find(Examen.class, ExamenId);
	}

	/**
	 * This method is responsible to create new Examen in database
	 */
	@Override
	public Examen createExamen(Examen Examen) {
		entityManager.persist(Examen);
		Examen b = getLastInsertedExamen();
		return b;
	}

	/**
	 * This method is responsible to update Examen detail in database
	 */
	@Override
	public Examen updateExamen(int ExamenId, Examen Examen) {
		
		//First We are taking Examen detail from database by given Examen id and 
		// then updating detail with provided Examen object
		Examen ExamenFromDB = getExamen(ExamenId);
		ExamenFromDB.setNote(Examen.getNote());
		ExamenFromDB.setModule(Examen.getModule());
	 
	 
		
		//again i am taking updated result of Examen and returning the Examen object
		Examen updatedExamen = getExamen(ExamenId);
		
		return updatedExamen;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteExamen(int ExamenId) {
		Examen Examen = getExamen(ExamenId);
		entityManager.remove(Examen);
		
		//we are checking here that whether entityManager contains earlier deleted Examen or not
		// if contains then Examen is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Examen);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Examen class
	 * @return Examen
	 */
	private Examen getLastInsertedExamen(){
		String hql = "from Examen order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Examen Examen = (Examen)query.getSingleResult();
		return Examen;
	}

}
