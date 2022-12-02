package com.example.aadhar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UsersService service;
	
	@PostMapping("/")
	public ResponseEntity<Users> addUser(@RequestBody Users u){
		Users user = service.addUser(u);
		if(user!=null) 
			return new ResponseEntity<Users>(user,HttpStatus.CREATED);
		else
			return new ResponseEntity<Users>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping("/")
	public List<Users> getAllUsers(){
		return service.getAllUsers();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable  int id ){
		
		if(service.deleteUser(id))
			return new ResponseEntity<Object>("User Deleted", HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No User Found",HttpStatus.NOT_FOUND);
	}
	
	
}
