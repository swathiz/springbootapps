package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.exception.NotFoundException;
import com.example.employee.model.Dept;
import com.example.employee.model.Emp;
import com.example.employee.repo.DeptRepo;
import com.example.employee.repo.EmpRepo;


@Service
public class DeptService {
	
	final static Logger logger = 
			LogManager.getLogger(DeptService.class.getName());
	
	@Autowired
	private DeptRepo repo;
	
	@Autowired
	private EmpRepo repo1;
	

	public List<Dept> getAllDept() {
		
		return repo.findAll();
	}
	
	public Optional<Dept> getDept(int id) {
		logger.error("Unable to locate the Department with"+id);
		if(!repo.existsById(id)){
			  throw new NotFoundException("Department Not Found");
		}
		return repo.findById(id);
	}
	
	public void addDept(Dept d) {
		repo.save(d);
	}
	
	public void deleteDept(int id)
	{
		logger.error("Unable to locate the employee with"+id);
		if(!repo.existsById(id)){
			  throw new NotFoundException("Department Not Found");
		}
		repo.deleteById(id);
	}
	
	
	public void updateDept(Dept d, int id) {
		if(id==d.getDeptid()) {
			repo.save(d);
		}
	}
	

}
