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

import com.pfe.entity.Certificat;
import com.pfe.services.ICertifStoreService;

@Controller
@RequestMapping("Certificatservice")
public class CertificatStoreController {
	
	@Autowired
	private ICertifStoreService service;
	
	@GetMapping("Certificats")
	public ResponseEntity<List<Certificat>> getCertifs(){
		
		List<Certificat> Certificats = service.getCertifs();
		return new ResponseEntity<List<Certificat>>(Certificats, HttpStatus.OK);
		
	}
	
	@GetMapping("Certificat/{id}")
	public ResponseEntity<Certificat> getCertif(@PathVariable("id") Integer id){
		Certificat Certificat = service.getCertif(id);
		return new ResponseEntity<Certificat>(Certificat, HttpStatus.OK);
	}
	
	@PostMapping("Certificat")
	public ResponseEntity<Certificat> createCertif(@RequestBody Certificat Certificat){
		Certificat b = service.createCertif(Certificat);
		return new ResponseEntity<Certificat>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("Certificat/{id}")
	public ResponseEntity<Certificat> updateCertif(@PathVariable("id") int id, @RequestBody Certificat Certificat){
		
		Certificat b = service.updateCertif(id, Certificat);
		return new ResponseEntity<Certificat>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("Certificat/{id}")
	public ResponseEntity<String> deleteCertif(@PathVariable("id") int id){
		boolean isDeleted = service.deleteCertif(id);
		if(isDeleted){
			String responseContent = "Certif has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Certif from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
