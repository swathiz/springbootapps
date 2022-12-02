package com.example;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.countries.model.Country;
import com.example.countries.repo.CountryRepo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
 
@SpringBootTest
public class CountryRepoTest {
	
	@Autowired
    private CountryRepo cr;
	
	 @Test
	    void isPersonExitsById() {
		 Country country = new Country(1, "Bhubaneswar");
	        cr.save(country);
	        Boolean actualResult = cr.isCountryExitsById(1);
	        assertThat(actualResult).isTrue();
	    }

}
