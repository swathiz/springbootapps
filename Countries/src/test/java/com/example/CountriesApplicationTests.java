package com.example;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.AfterMethod;

import com.example.countries.model.Country;
import com.example.countries.repo.CountryRepo;

import static org.testng.Assert.assertEquals;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CountriesApplicationTests {

	@LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";

    private static RestTemplate restTemplate;
    

    @Autowired
    private TestH2Repository h2Repository;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/countries");
    }
    private Country country;

    @Test
    public void testAddCountry() {
        country = new Country(1,"Iran");
        Country response = restTemplate.postForObject(baseUrl, country, Country.class);
        assertEquals("Iran", response.getCountryname());
//        assertEquals(1, h2Repository.findAll().size());
    }
    
    @AfterMethod
    public void tearDown() {
        country = null;
    }

//    @Test
//    @Sql(statements = "INSERT INTO Country (countryname) VALUES ('Bali')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//    @Sql(statements = "DELETE FROM Country WHERE countryname='Bali'", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//    public void testGetCountries() {
//        List<Country> countries = restTemplate.getForObject(baseUrl, List.class);
//        assertEquals(1, countries.size());
//        assertEquals(1, h2Repository.findAll().size());
//    }
    
//   
    
}
