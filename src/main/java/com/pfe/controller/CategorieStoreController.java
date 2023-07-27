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
import com.pfe.services.ICategorieStoreService;

@Controller
@RequestMapping("Categorieservice")
public class CategorieStoreController {
	
	@Autowired
	private ICategorieStoreService service;
	
	@GetMapping("Categories")
	public ResponseEntity<List<Categorie>> getCategories(){
		
		List<Categorie> Categories = service.getCategories();
		return new ResponseEntity<List<Categorie>>(Categories, HttpStatus.OK);
		
	}
	
	@GetMapping("Categories/{id}")
	public ResponseEntity<Categorie> getCategorie(@PathVariable("id") Integer id){
		Categorie Categorie = service.getCategorie(id);
		return new ResponseEntity<Categorie>(Categorie, HttpStatus.OK);
	}
	
	@PostMapping("Categories")
	public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie Categorie){
		Categorie b = service.createCategorie(Categorie);
		return new ResponseEntity<Categorie>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Categories/{id}")
	public ResponseEntity<Categorie> updateCategorie(@PathVariable("id") int id, @RequestBody Categorie Categorie){
		
		Categorie b = service.updateCategorie(id, Categorie);
		return new ResponseEntity<Categorie>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Categories/{id}")
	public ResponseEntity<String> deleteCategorie(@PathVariable("id") int id){
		boolean isDeleted = service.deleteCategorie(id);
		if(isDeleted){
			String responseContent = "Categorie has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Categorie from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
