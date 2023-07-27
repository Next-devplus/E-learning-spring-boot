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

import com.pfe.entity.ReponseApp;
import com.pfe.services.IReponseAppStoreService;

@Controller
@RequestMapping("ReponseAppservice")
public class ReponseAppStoreController {
	
	@Autowired
	private IReponseAppStoreService service;
	
	@GetMapping("ReponseApps")
	public ResponseEntity<List<ReponseApp>> getReponseApps(){
		
		List<ReponseApp> ReponseApps = service.getReponseApps();
		return new ResponseEntity<List<ReponseApp>>(ReponseApps, HttpStatus.OK);
		
	}
	
	@GetMapping("ReponseApps/{id}")
	public ResponseEntity<ReponseApp> getReponseApp(@PathVariable("id") Integer id){
		ReponseApp ReponseApp = service.getReponseApp(id);
		return new ResponseEntity<ReponseApp>(ReponseApp, HttpStatus.OK);
	}
	
	@PostMapping("ReponseApps")
	public ResponseEntity<ReponseApp> createReponseApp(@RequestBody ReponseApp ReponseApp){
		ReponseApp b = service.createReponseApp(ReponseApp);
		return new ResponseEntity<ReponseApp>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("ReponseApps/{id}")
	public ResponseEntity<ReponseApp> updateReponseApp(@PathVariable("id") int id, @RequestBody ReponseApp ReponseApp){
		
		ReponseApp b = service.updateReponseApp(id, ReponseApp);
		return new ResponseEntity<ReponseApp>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("ReponseApps/{id}")
	public ResponseEntity<String> deleteReponseApp(@PathVariable("id") int id){
		boolean isDeleted = service.deleteReponseApp(id);
		if(isDeleted){
			String responseContent = "ReponseApp has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting ReponseApp from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
