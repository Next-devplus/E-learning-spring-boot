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

import com.pfe.entity.Formateur;
import com.pfe.services.IFormateurStoreService;

@Controller
@RequestMapping("Formateurservice")
public class FormateurStoreController {
	
	@Autowired
	private IFormateurStoreService service;
	
	@GetMapping("Formateurs")
	public ResponseEntity<List<Formateur>> getFormateurs(){
		
		List<Formateur> Formateurs = service.getFormateurs();
		return new ResponseEntity<List<Formateur>>(Formateurs, HttpStatus.OK);
		
	}
	
	@GetMapping("Formateurs/{id}")
	public ResponseEntity<Formateur> getFormateur(@PathVariable("id") Integer id){
		Formateur Formateur = service.getFormateur(id);
		return new ResponseEntity<Formateur>(Formateur, HttpStatus.OK);
	}
	
	@PostMapping("Formateurs")
	public ResponseEntity<Formateur> createFormateur(@RequestBody Formateur Formateur){
		Formateur b = service.createFormateur(Formateur);
		return new ResponseEntity<Formateur>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Formateurs/{id}")
	public ResponseEntity<Formateur> updateFormateur(@PathVariable("id") int id, @RequestBody Formateur Formateur){
		
		Formateur b = service.updateFormateur(id, Formateur);
		return new ResponseEntity<Formateur>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Formateurs/{id}")
	public ResponseEntity<String> deleteFormateur(@PathVariable("id") int id){
		boolean isDeleted = service.deleteFormateur(id);
		if(isDeleted){
			String responseContent = "Formateur has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Formateur from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
