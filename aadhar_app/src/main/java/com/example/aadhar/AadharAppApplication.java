package com.example.aadhar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.aadhar")
public class AadharAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AadharAppApplication.class, args);
	}

}
