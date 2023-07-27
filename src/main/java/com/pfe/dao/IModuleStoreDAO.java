package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Categorie;
import com.pfe.entity.Module;

public interface IModuleStoreDAO {
	
	List<Module> getModules();
	Module getModule(int ModuleId);
	Module createModule(Module Module);
	Module updateModule(int ModuleId,Module Module);
	boolean deleteModule(int ModuleId);

}
