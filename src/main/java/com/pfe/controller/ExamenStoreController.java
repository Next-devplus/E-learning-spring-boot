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

import com.pfe.entity.Examen;
import com.pfe.services.IExamenStoreService;

@Controller
@RequestMapping("Examenservice")
public class ExamenStoreController {
	
	@Autowired
	private IExamenStoreService service;
	
	@GetMapping("Examens")
	public ResponseEntity<List<Examen>> getExamens(){
		
		List<Examen> Examens = service.getExamens();
		return new ResponseEntity<List<Examen>>(Examens, HttpStatus.OK);
		
	}
	
	@GetMapping("getExamens/{id}")
	public ResponseEntity<Examen> getExamen(@PathVariable("id") Integer id){
		Examen Examen = service.getExamen(id);
		return new ResponseEntity<Examen>(Examen, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<Examen> createExamen(@RequestBody Examen Examen){
		Examen b = service.createExamen(Examen);
		return new ResponseEntity<Examen>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Examen> updateExamen(@PathVariable("id") int id, @RequestBody Examen Examen){
		
		Examen b = service.updateExamen(id, Examen);
		return new ResponseEntity<Examen>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Delete/{id}")
	public ResponseEntity<String> deleteExamen(@PathVariable("id") int id){
		boolean isDeleted = service.deleteExamen(id);
		if(isDeleted){
			String responseContent = "Examen has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Examen from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
