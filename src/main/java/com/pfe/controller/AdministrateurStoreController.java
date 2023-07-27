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

import com.pfe.entity.Administrateur;
import com.pfe.services.IAdministrateurStoreService;

@Controller
@RequestMapping("Administrateurservice")
public class AdministrateurStoreController {
	
	@Autowired
	private IAdministrateurStoreService service;
	
	@GetMapping("Administrateurs")
	public ResponseEntity<List<Administrateur>> getAdministrateurs(){
		
		List<Administrateur> Administrateurs = service.getAdministrateurs();
		return new ResponseEntity<List<Administrateur>>(Administrateurs, HttpStatus.OK);
		
	}
	
	@GetMapping("Administrateurs/{id}")
	public ResponseEntity<Administrateur> getAdministrateur(@PathVariable("id") Integer id){
		Administrateur Administrateur = service.getAdministrateur(id);
		return new ResponseEntity<Administrateur>(Administrateur, HttpStatus.OK);
	}
	
	@PostMapping("Administrateurs")
	public ResponseEntity<Administrateur> createAdministrateur(@RequestBody Administrateur Administrateur){
		Administrateur b = service.createAdministrateur(Administrateur);
		return new ResponseEntity<Administrateur>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Administrateurs/{id}")
	public ResponseEntity<Administrateur> updateAdministrateur(@PathVariable("id") int id, @RequestBody Administrateur Administrateur){
		
		Administrateur b = service.updateAdministrateur(id, Administrateur);
		return new ResponseEntity<Administrateur>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Administrateurs/{id}")
	public ResponseEntity<String> deleteAdministrateur(@PathVariable("id") int id){
		boolean isDeleted = service.deleteAdministrateur(id);
		if(isDeleted){
			String responseContent = "Administrateur has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Administrateur from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
