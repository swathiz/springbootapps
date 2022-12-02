package com.example.employee.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Dept {
	
	@Id
	@Column(name="deptid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptid;
	private String dept_name;
	
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(int deptid, String dept_name) {
		super();
		this.deptid = deptid;
		this.dept_name = dept_name;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public Dept(int deptid) {
		super();
		this.deptid = deptid;
	}
	
	
	
	
}
