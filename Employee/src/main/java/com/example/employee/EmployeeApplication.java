package com.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

//import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
@OpenAPIDefinition(info=@Info(title = "Employee API",description = "Note: https://www.baeldung.com/spring-rest-openapi-documentation[for swagger docs] and https://www.baeldung.com/spring-boot-logging [for logging docs] and https://www.javainuse.com/spring/spring-boot-aop[for aop]"))
public class EmployeeApplication {

	private static Logger LOGGER = LogManager.getLogger(EmployeeApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
		
		LOGGER.info("This is information");
		LOGGER.debug("This is debug");
		LOGGER.error("This is error");
	}


}
