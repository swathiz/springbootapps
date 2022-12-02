package com.example.employee;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.employee.model.Dept;
import com.example.employee.repo.DeptRepo;
import com.example.employee.service.DeptService;


@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeApplicationTests {

	@Autowired
	private DeptService service;

	@MockBean
	private DeptRepo repository;
	
	@Test
	public void getDeptTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Dept(1, "HR"), new Dept(2,"Service")).collect(Collectors.toList()));
		assertEquals(2, service.getAllDept().size());
	}

}
