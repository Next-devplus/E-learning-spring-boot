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

import com.pfe.entity.Commentaire;
import com.pfe.services.ICommentaireStoreService;

@Controller
@RequestMapping("Commentaireservice")
public class CommentaireStoreController {
	
	@Autowired
	private ICommentaireStoreService service;
	
	@GetMapping("ListeCommentaires")
	public ResponseEntity<List<Commentaire>> getCommentaires(){
		
		List<Commentaire> Commentaires = service.getCommentaires();
		return new ResponseEntity<List<Commentaire>>(Commentaires, HttpStatus.OK);
		
	}
	
	@GetMapping("GetCommentaires/{id}")
	public ResponseEntity<Commentaire> getCommentaire(@PathVariable("id") Integer id){
		Commentaire Commentaire = service.getCommentaire(id);
		return new ResponseEntity<Commentaire>(Commentaire, HttpStatus.OK);
	}
	
	@PostMapping("Commentaires")
	public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire Commentaire){
		Commentaire b = service.createCommentaire(Commentaire);
		return new ResponseEntity<Commentaire>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Commentaires/{id}")
	public ResponseEntity<Commentaire> updateCommentaire(@PathVariable("id") int id, @RequestBody Commentaire Commentaire){
		
		Commentaire b = service.updateCommentaire(id, Commentaire);
		return new ResponseEntity<Commentaire>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Commentaires/{id}")
	public ResponseEntity<String> deleteCommentaire(@PathVariable("id") int id){
		boolean isDeleted = service.deleteCommentaire(id);
		if(isDeleted){
			String responseContent = "Commentaire has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Commentaire from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
