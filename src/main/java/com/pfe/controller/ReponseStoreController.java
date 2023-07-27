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

import com.pfe.entity.Reponse;
import com.pfe.services.IReponseStoreService;

@Controller
@RequestMapping("Reponseservice")
public class ReponseStoreController {
	
	@Autowired
	private IReponseStoreService service;
	
	@GetMapping("Reponses")
	public ResponseEntity<List<Reponse>> getReponses(){
		
		List<Reponse> Reponses = service.getReponses();
		return new ResponseEntity<List<Reponse>>(Reponses, HttpStatus.OK);
		
	}
	
	@GetMapping("Reponses/{id}")
	public ResponseEntity<Reponse> getReponse(@PathVariable("id") Integer id){
		Reponse Reponse = service.getReponse(id);
		return new ResponseEntity<Reponse>(Reponse, HttpStatus.OK);
	}
	
	@PostMapping("Reponses")
	public ResponseEntity<Reponse> createReponse(@RequestBody Reponse Reponse){
		Reponse b = service.createReponse(Reponse);
		return new ResponseEntity<Reponse>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Reponses/{id}")
	public ResponseEntity<Reponse> updateReponse(@PathVariable("id") int id, @RequestBody Reponse Reponse){
		
		Reponse b = service.updateReponse(id, Reponse);
		return new ResponseEntity<Reponse>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Reponses/{id}")
	public ResponseEntity<String> deleteReponse(@PathVariable("id") int id){
		boolean isDeleted = service.deleteReponse(id);
		if(isDeleted){
			String responseContent = "Reponse has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Reponse from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
