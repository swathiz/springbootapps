 package com.example.employee.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.model.Dept;
import com.example.employee.model.Emp;



public interface DeptRepo extends JpaRepository<Dept, Integer> {
	
	
}
