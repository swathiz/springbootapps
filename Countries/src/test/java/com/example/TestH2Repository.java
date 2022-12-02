package com.example;

import com.example.countries.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestH2Repository extends JpaRepository<Country,Integer> {
}
