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

import com.pfe.entity.Choix;
import com.pfe.services.IChoixStoreService;

@Controller
@RequestMapping("Choixservice")
public class ChoixStoreController {
	
	@Autowired
	private IChoixStoreService service;
	
	@GetMapping("Choixs")
	public ResponseEntity<List<Choix>> getChoixs(){
		
		List<Choix> Choixs = service.getChoixs();
		return new ResponseEntity<List<Choix>>(Choixs, HttpStatus.OK);
		
	}
	
	@GetMapping("Choixs/{id}")
	public ResponseEntity<Choix> getChoix(@PathVariable("id") Integer id){
		Choix Choix = service.getChoix(id);
		return new ResponseEntity<Choix>(Choix, HttpStatus.OK);
	}
	
	@PostMapping("Choixs")
	public ResponseEntity<Choix> createChoix(@RequestBody Choix Choix){
		Choix b = service.createChoix(Choix);
		return new ResponseEntity<Choix>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Choixs/{id}")
	public ResponseEntity<Choix> updateChoix(@PathVariable("id") int id, @RequestBody Choix Choix){
		
		Choix b = service.updateChoix(id, Choix);
		return new ResponseEntity<Choix>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Choixs/{id}")
	public ResponseEntity<String> deleteChoix(@PathVariable("id") int id){
		boolean isDeleted = service.deleteChoix(id);
		if(isDeleted){
			String responseContent = "Choix has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Choix from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
