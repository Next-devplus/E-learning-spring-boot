package com.pfe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.entity.Categorie;
import com.pfe.entity.Module;

@Transactional
@Repository
public class ModuleStoreDAO implements IModuleStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Modules available in database and return it as List<Module>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getModules() {
		
		String hql = "FROM Module as atcl ORDER BY atcl.id";
		return (List<Module>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Module detail by given Module id 
	 */
	@Override
	public Module getModule(int ModuleId) {
		
		return entityManager.find(Module.class, ModuleId);
	}

	/**
	 * This method is responsible to create new Module in database
	 */
	@Override
	public Module createModule(Module Module) {
		entityManager.persist(Module);
		Module b = getLastInsertedModule();
		return b;
	}

	/**
	 * This method is responsible to update Module detail in database
	 */
	@Override
	public Module updateModule(int ModuleId, Module Module) {
		
		//First We are taking Module detail from database by given Module id and 
		// then updating detail with provided Module object
		Module ModuleFromDB = getModule(ModuleId);
		ModuleFromDB.setNom(Module.getNom());
		ModuleFromDB.setPlan(Module.getPlan());
		ModuleFromDB.setPrix(Module.getPrix());
		ModuleFromDB.setDescription(Module.getDescription());

		 
		
		entityManager.flush();
		
		//again i am taking updated result of Module and returning the Module object
		Module updatedModule = getModule(ModuleId);
		
		return updatedModule;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteModule(int ModuleId) {
		Module Module = getModule(ModuleId);
		entityManager.remove(Module);
		
		//we are checking here that whether entityManager contains earlier deleted Module or not
		// if contains then Module is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Module);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Module class
	 * @return Module
	 */
	private Module getLastInsertedModule(){
		String hql = "from Module order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Module Module = (Module)query.getSingleResult();
		return Module;
	}

}
