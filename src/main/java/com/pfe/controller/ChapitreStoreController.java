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

import com.pfe.entity.Chapitre;
import com.pfe.services.IChapitreStoreService;

@Controller
@RequestMapping("Chapitreservice")
public class ChapitreStoreController {
	
	@Autowired
	private IChapitreStoreService service;
	
	@GetMapping("Chapitres")
	public ResponseEntity<List<Chapitre>> getChapitres(){
		
		List<Chapitre> Chapitres = service.getChapitres();
		return new ResponseEntity<List<Chapitre>>(Chapitres, HttpStatus.OK);
		
	}
	
	@GetMapping("Chapitres/{id}")
	public ResponseEntity<Chapitre> getChapitre(@PathVariable("id") Integer id){
		Chapitre Chapitre = service.getChapitre(id);
		return new ResponseEntity<Chapitre>(Chapitre, HttpStatus.OK);
	}
	
	@PostMapping("Chapitres")
	public ResponseEntity<Chapitre> createChapitre(@RequestBody Chapitre Chapitre){
		Chapitre b = service.createChapitre(Chapitre);
		return new ResponseEntity<Chapitre>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Chapitres/{id}")
	public ResponseEntity<Chapitre> updateChapitre(@PathVariable("id") int id, @RequestBody Chapitre Chapitre){
		
		Chapitre b = service.updateChapitre(id, Chapitre);
		return new ResponseEntity<Chapitre>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Chapitres/{id}")
	public ResponseEntity<String> deleteChapitre(@PathVariable("id") int id){
		boolean isDeleted = service.deleteChapitre(id);
		if(isDeleted){
			String responseContent = "Chapitre has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Chapitre from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
