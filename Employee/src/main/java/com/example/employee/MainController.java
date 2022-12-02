package com.example.employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.employee.model.Dept;
import com.example.employee.model.Emp;
import com.example.employee.service.DeptService;
import com.example.employee.service.EmpService;



@RestController
@RequestMapping(value="/employeeapp")
public class MainController {
	
	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private EmpService empService;
	
	@Autowired
	private DeptService deptService;

//***********EMPLOYEE***********
	@GetMapping("/employes")
	public List<Emp> getAllEmp(){
//		Emp e = empService.getAllEmp().orElseThrow(() -> new NotFoundException("Not found"));
//		return ResponseEntity.ok().body(e);
		return empService.getAllEmp();
	}
	
	@PostMapping("/employes")
	public void addEmp(@RequestBody Emp e) {
		empService.addEmp(e);
	}
	
	@DeleteMapping("/employes")
	public void deleteAllEmp() {
		empService.deleteAllEmp();
	}
	
	@GetMapping("/employee/{id}")
	public List<Emp> getEmpByDept(@PathVariable int id){
		return empService.getEmpById(id);
	}
	

	//*************DEPARTMENT*******************
	
	@PostMapping("/departments")
	public void addDept(@RequestBody Dept d) {
		deptService.addDept(d);
	}
	
		
	@GetMapping("/departments")
	public  List<Dept> getAllDept(){
		return deptService.getAllDept();
	}
	
	@DeleteMapping("/department/{id}")
	public ResponseEntity<Dept> deleteDept(@PathVariable  int id ){
		
		deptService.deleteDept(id);
		return new ResponseEntity<Dept>(HttpStatus.OK);
	}
	

	
	//**************COUNTRIES**************
	
	@GetMapping("/countries")
	public List<Object> getCountries(){
		String countriesurl = "http://localhost:8087/countries";
		Object[] obs = restTemplate.getForObject(countriesurl, Object[].class);
		return Arrays.asList(obs);
		
	}
	

	
	
}
