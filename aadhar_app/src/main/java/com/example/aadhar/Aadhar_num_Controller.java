package com.example.aadhar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class Aadhar_num_Controller {
	
	@Autowired
	private UsersService service;
	
	@PostMapping("/add_aadhar")
	public ResponseEntity<Aadhar_num> addAadhar(@RequestBody Aadhar_num a){
		Aadhar_num adh = service.addAadhar(a);
		if(adh!=null)  
			return new ResponseEntity<Aadhar_num>(adh,HttpStatus.CREATED);
		else
			return new ResponseEntity<Aadhar_num>(adh, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
