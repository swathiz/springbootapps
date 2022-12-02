package com.example.countries.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.countries.model.Country;


public interface CountryRepo extends JpaRepository<Country, Integer> {
	
	 @Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Country s WHERE s.id = ?1")
	Boolean isCountryExitsById(int i);

}
