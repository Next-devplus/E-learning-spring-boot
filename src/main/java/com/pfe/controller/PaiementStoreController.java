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

import com.pfe.entity.Paiement;
import com.pfe.services.IPaiementStoreService;

@Controller
@RequestMapping("Paiementservice")
public class PaiementStoreController {
	
	@Autowired
	private IPaiementStoreService service;
	
	@GetMapping("Paiements")
	public ResponseEntity<List<Paiement>> getPaiements(){
		
		List<Paiement> Paiements = service.getPaiements();
		return new ResponseEntity<List<Paiement>>(Paiements, HttpStatus.OK);
		
	}
	
	@GetMapping("Paiements/{id}")
	public ResponseEntity<Paiement> getPaiement(@PathVariable("id") Integer id){
		Paiement Paiement = service.getPaiement(id);
		return new ResponseEntity<Paiement>(Paiement, HttpStatus.OK);
	}
	
	@PostMapping("Paiements")
	public ResponseEntity<Paiement> createPaiement(@RequestBody Paiement Paiement){
		Paiement b = service.createPaiement(Paiement);
		return new ResponseEntity<Paiement>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Paiements/{id}")
	public ResponseEntity<Paiement> updatePaiement(@PathVariable("id") int id, @RequestBody Paiement Paiement){
		
		Paiement b = service.updatePaiement(id, Paiement);
		return new ResponseEntity<Paiement>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Paiements/{id}")
	public ResponseEntity<String> deletePaiement(@PathVariable("id") int id){
		boolean isDeleted = service.deletePaiement(id);
		if(isDeleted){
			String responseContent = "Paiement has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Paiement from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
