package com.example.employee.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DepartmentServiceAspect {
	
	@Before(value = "execution(* com.example.employee.service.DeptService.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Before method:" + joinPoint.getSignature());
		String str = joinPoint.getSignature().toString();
		
		System.out.println(str.replace("List com.example.employee.service.DeptService.", ""));

		System.out.println("Working on Department Service method i.e - " + str.replace("List com.example.employee.service.DeptService.", ""));
	}
	
	@After(value = "execution(* com.example.employee.service.DeptService.*(..)) ")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("After method:" + joinPoint.getSignature());
		String str = joinPoint.getSignature().toString();

		System.out.println("Successfully worked with Department Service method i.e - " + str.replace("List com.example.employee.service.DeptService.", ""));
	}

}
