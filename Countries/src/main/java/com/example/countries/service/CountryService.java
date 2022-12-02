package com.example.countries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.countries.model.Country;
import com.example.countries.repo.CountryRepo;



@Service
public class CountryService {
	
	@Autowired
	private CountryRepo crepo;
	
	public void addCountry(Country c) {	
		 crepo.save(c);
	}
	
	public List<Country> getAllCountry() {
		return crepo.findAll();
	}
	
	

}
