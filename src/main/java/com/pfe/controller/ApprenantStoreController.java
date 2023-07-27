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

import com.pfe.entity.Apprenant;
import com.pfe.services.IApprenantStoreService;

@Controller
@RequestMapping("Apprenantservice")
public class ApprenantStoreController {
	
	@Autowired
	private IApprenantStoreService service;
	
	@GetMapping("Apprenants")
	public ResponseEntity<List<Apprenant>> getApprenants(){
		
		List<Apprenant> Apprenants = service.getApprenants();
		return new ResponseEntity<List<Apprenant>>(Apprenants, HttpStatus.OK);
		
	}
	
	@GetMapping("Apprenants/{id}")
	public ResponseEntity<Apprenant> getApprenant(@PathVariable("id") Integer id){
		Apprenant Apprenant = service.getApprenant(id);
		return new ResponseEntity<Apprenant>(Apprenant, HttpStatus.OK);
	}
	
	@PostMapping("Apprenants")
	public ResponseEntity<Apprenant> createApprenant(@RequestBody Apprenant Apprenant){
		Apprenant b = service.createApprenant(Apprenant);
		return new ResponseEntity<Apprenant>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Apprenants/{id}")
	public ResponseEntity<Apprenant> updateApprenant(@PathVariable("id") int id, @RequestBody Apprenant Apprenant){
		
		Apprenant b = service.updateApprenant(id, Apprenant);
		return new ResponseEntity<Apprenant>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Apprenants/{id}")
	public ResponseEntity<String> deleteApprenant(@PathVariable("id") int id){
		boolean isDeleted = service.deleteApprenant(id);
		if(isDeleted){
			String responseContent = "Apprenant has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Apprenant from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
