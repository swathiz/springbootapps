package com.example.aadhar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aadhar_num {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int userid;
	private int aadhar_num;
	
	
	public Aadhar_num(int id, int userid, int aadhar_num) {
		super();
		this.id = id;
		this.userid = userid;
		this.aadhar_num = aadhar_num;
	}


	public Aadhar_num() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public int getAadhar_num() {
		return aadhar_num;
	}


	public void setAadhar_num(int aadhar_num) {
		this.aadhar_num = aadhar_num;
	}


	@Override
	public String toString() {
		return "Aadhar_num [id=" + id + ", userid=" + userid + ", aadhar_num=" + aadhar_num + "]";
	}
	
	
	

}
