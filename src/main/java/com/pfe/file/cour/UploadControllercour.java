package com.pfe.file.cour;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
 
 
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller

public class UploadControllercour {
 
  @Autowired
  StorageServicecour storageServicec;
 
  List<String> files = new ArrayList<String>();
 
   
  @GetMapping("/downloadfileCour/{filename:.+}")
 	@ResponseBody
 	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
 		Resource file = storageServicec.loadFile(filename);
 		return ResponseEntity.ok()
 				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
 				.body(file);
 	}
  
 @GetMapping("/getfileCour")
  @ResponseBody
  public String[] getFile1(){
	  File folder=new File("File/Cour");
	  	    String[] filesInDir = folder.list();
 	     		return filesInDir;
  }
  
  
  
  
 @CrossOrigin(origins = "http://localhost:4200")
 //@PostMapping("/uploadCour")
// @PostMapping(value = "/uploadCour", consumes = { "multipart/form-data", MediaType.APPLICATION_JSON_VALUE })                                                                                                                 // 4.3
 @RequestMapping(value = "/uploadCour", method = RequestMethod.POST)
 public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
   String message = "";
   try {
     storageServicec.store(file);
     files.add(file.getOriginalFilename());

     message = "You successfully uploaded " + file.getOriginalFilename() + "!";
     return ResponseEntity.status(HttpStatus.OK).body(message);
   } catch (Exception e) {
     message = "FAIL to upload " + file.getOriginalFilename() + "!";
     return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
   }
 }
  
  
  
}
