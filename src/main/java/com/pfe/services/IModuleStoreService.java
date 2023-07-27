package com.pfe.services;

import java.util.List;

import com.pfe.entity.Categorie;
import com.pfe.entity.Formateur;
import com.pfe.entity.Module;

public interface IModuleStoreService {
	
	List<Module> getModules();
	Module createModule(Module Module);
	Module updateModule(int ModuleId, Module Module);
	Module getModule(int ModuleId);
	boolean deleteModule(int ModuleId);

}
