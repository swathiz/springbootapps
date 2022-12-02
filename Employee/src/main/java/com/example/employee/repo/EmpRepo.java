package com.example.employee.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.employee.model.Emp;


public interface EmpRepo extends JpaRepository<Emp, Integer> {

	@Query("SELECT e FROM Emp e WHERE e.dept.deptid = :deptid")
	List<Emp> getEmpByDept(int deptid);

}
