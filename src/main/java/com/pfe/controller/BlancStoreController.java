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

import com.pfe.entity.Blanc;
import com.pfe.services.IBlancStoreService;

@Controller
@RequestMapping("Blancservice")
public class BlancStoreController {
	
	@Autowired
	private IBlancStoreService service;
	
	@GetMapping("Blancs")
	public ResponseEntity<List<Blanc>> getBlancs(){
		
		List<Blanc> Blancs = service.getBlancs();
		return new ResponseEntity<List<Blanc>>(Blancs, HttpStatus.OK);
		
	}
	
	@GetMapping("Blancs/{id}")
	public ResponseEntity<Blanc> getBlanc(@PathVariable("id") Integer id){
		Blanc Blanc = service.getBlanc(id);
		return new ResponseEntity<Blanc>(Blanc, HttpStatus.OK);
	}
	
	@PostMapping("Blancs")
	public ResponseEntity<Blanc> createBlanc(@RequestBody Blanc Blanc){
		Blanc b = service.createBlanc(Blanc);
		return new ResponseEntity<Blanc>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Blancs/{id}")
	public ResponseEntity<Blanc> updateBlanc(@PathVariable("id") int id, @RequestBody Blanc Blanc){
		
		Blanc b = service.updateBlanc(id, Blanc);
		return new ResponseEntity<Blanc>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Blancs/{id}")
	public ResponseEntity<String> deleteBlanc(@PathVariable("id") int id){
		boolean isDeleted = service.deleteBlanc(id);
		if(isDeleted){
			String responseContent = "Blanc has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Blanc from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
