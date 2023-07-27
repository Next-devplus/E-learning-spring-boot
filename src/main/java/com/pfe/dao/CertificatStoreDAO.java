package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Certificat;

@Transactional
@Repository
public class CertificatStoreDAO implements ICertificatStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Certifs available in database and return it as List<Certif>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Certificat> getCertifs() {
		
		String hql = "FROM Certificat as atcl ORDER BY atcl.id";
		return (List<Certificat>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Certif detail by given Certif id 
	 */
	@Override
	public Certificat getCertif(int CertifId) {
		
		return entityManager.find(Certificat.class, CertifId);
	}

	/**
	 * This method is responsible to create new Certif in database
	 */
	@Override
	public Certificat createCertif(Certificat Certif) {
		entityManager.persist(Certif);
		Certificat b = getLastInsertedCertif();
		return b;
	}

	/**
	 * This method is responsible to update Certif detail in database
	 */
	@Override
	public Certificat updateCertif(int CertifId, Certificat Certif) {
		
		//First We are taking Certif detail from database by given Certif id and 
		// then updating detail with provided Certif object
		Certificat CertifFromDB = getCertif(CertifId);
		CertifFromDB.setDuree(Certif.getDuree());
		CertifFromDB.setExamen(Certif.getExamen());
		CertifFromDB.setApprenant(Certif.getApprenant());
		 
		
		entityManager.flush();
		
		//again i am taking updated result of Certif and returning the Certif object
		Certificat updatedCertif = getCertif(CertifId);
		
		return updatedCertif;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteCertif(int CertifId) {
		Certificat Certif = getCertif(CertifId);
		entityManager.remove(Certif);
		
		//we are checking here that whether entityManager contains earlier deleted Certif or not
		// if contains then Certif is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Certif);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Certif class
	 * @return Certif
	 */
	private Certificat getLastInsertedCertif(){
		String hql = "from Certif order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Certificat Certif = (Certificat)query.getSingleResult();
		return Certif;
	}

}
