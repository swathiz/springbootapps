package com.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Admin;
import com.app.entity.User;
import com.app.exceptions.AdminNotFoundException;
import com.app.exceptions.UserNotFoundException;
import com.app.repositories.AuthenticationAdminRepository;
import com.app.repositories.AuthenticationUserRepository;

@Service
public class AuthenticationAdminService {
	
	@Autowired
	AuthenticationAdminRepository adminAuthRepo;
	
	Admin admin;
	
	
//	public String getPassword() {
//		String pwd = admin.getPassword();
//		return pwd;
//	}
	
	public Admin GetAdminByName(int id) {
		Optional<Admin> adminfound = adminAuthRepo.findById(id);
		if(adminfound.isPresent()) {
			return adminfound.get();
		}
		else {
			throw new AdminNotFoundException();
		}
	}
	
	
	
	public Boolean isValidPassword(String cmp, String actual) {
		return ((cmp.equals(actual)) ?  true :  false);	
	}


	
	
	

}