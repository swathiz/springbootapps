package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.countries.model.Country;
import com.example.countries.service.CountryService;



@RestController
public class CountryController {
	
	@Autowired
	private CountryService cService;
	
	@PostMapping("/countries")
	public Country addCountry(@RequestBody Country c) {
		cService.addCountry(c);
		return c;
		
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountry(){
		return cService.getAllCountry();
	}

}
