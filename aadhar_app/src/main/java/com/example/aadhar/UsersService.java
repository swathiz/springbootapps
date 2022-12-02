package com.example.aadhar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

	@Autowired
	private UsersRepo repo;
	
	private Aadhar_numRepo repo1;
	
	public Users addUser(Users u) {
		return repo.save(u);
	}
	
	public List<Users> getAllUsers(){
		return repo.findAll();
	}
	
	public boolean deleteUser(int id) {
		
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		else
			return false;
	}
	
	public Users getUsersById(int id) {
		if(repo.findById(id).isPresent()) 
			return repo.findById(id).get();
		else 
			return null;
		
	}
	
	public Aadhar_num addAadhar(Aadhar_num a) {
		return repo1.save(a);
	}
}
