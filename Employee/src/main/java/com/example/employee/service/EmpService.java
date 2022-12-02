package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.EmployeeApplication;
import com.example.employee.exception.NotFoundException;
import com.example.employee.model.Emp;
import com.example.employee.repo.DeptRepo;
import com.example.employee.repo.EmpRepo;

@Service
public class EmpService {
	
	final static Logger logger = 
			LogManager.getLogger(EmpService.class.getName());
	
	@Autowired
	private EmpRepo repo1;
	
	public void addEmp(Emp e) {
		
		 repo1.save(e);
	}

	public List<Emp> getAllEmp() {
		return repo1.findAll();
	}
	
	
	public void deleteEmp(int id)
	{
		logger.error("Unable to locate the employee with"+id);
		if(!repo1.existsById(id)){
			  throw new NotFoundException("Employee Not Found");
		}
		repo1.deleteById(id);
	}
	
	public void deleteAllEmp() {
		repo1.deleteAll();
	}

	public List<Emp> getEmpById(int id) {
		logger.error("Unable to locate the employess under Department with"+id);
		if(!repo1.existsById(id)){
			  throw new NotFoundException("Employee Not Found");
		}
		
		return repo1.getEmpByDept(id);
	}

	
	

}
