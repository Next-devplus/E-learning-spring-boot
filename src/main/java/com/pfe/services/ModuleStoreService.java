package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.IModuleStoreDAO;
import com.pfe.entity.Categorie;
import com.pfe.entity.Formateur;
import com.pfe.entity.Module;
 

@Service
public class ModuleStoreService implements IModuleStoreService {
	
	@Autowired
	private IModuleStoreDAO dao;

	@Override
	public List<Module> getModules() {
		return dao.getModules();
	}


	@Override
	public Module createModule(Module Module) {
		return dao.createModule(Module);
	}

	@Override
	public Module updateModule(int ModuleId, Module Module) {
		return dao.updateModule(ModuleId, Module);
	}

	@Override
	public Module getModule(int ModuleId) {
		return dao.getModule(ModuleId);
	}

	@Override
	public boolean deleteModule(int ModuleId) {
		return dao.deleteModule(ModuleId);
	}

}
