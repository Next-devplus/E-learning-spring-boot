package com.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.entity.Categorie;
import com.pfe.entity.Formateur;
import com.pfe.entity.Module;
import com.pfe.services.IModuleStoreService;

@Controller
@RequestMapping("Moduleservice")
public class ModuleStoreController {
	
	@Autowired
	private IModuleStoreService service;
	
	@GetMapping("Modules")
	public ResponseEntity<List<Module>> getModules(){
		
		List<Module> Modules = service.getModules();
		return new ResponseEntity<List<Module>>(Modules, HttpStatus.OK);
		
	}
	
	@GetMapping("Modules/{id}")
	public ResponseEntity<Module> getModule(@PathVariable("id") Integer id){
		Module Module = service.getModule(id);
		return new ResponseEntity<Module>(Module, HttpStatus.OK);
	}
	
	@PostMapping("Modules")
	public ResponseEntity<Module> createModule(@RequestBody Module Module){
		Module b = service.createModule(Module);
		return new ResponseEntity<Module>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Modules/{id}")
	public ResponseEntity<Module> updateModule(@PathVariable("id") int id, @RequestBody Module Module){
		
		Module b = service.updateModule(id, Module);
		return new ResponseEntity<Module>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Modules/{id}")
	public ResponseEntity<String> deleteModule(@PathVariable("id") int id){
		boolean isDeleted = service.deleteModule(id);
		if(isDeleted){
			String responseContent = "Module has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Module from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
