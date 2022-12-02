package com.example.aadhar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	
	


	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String dob;
	private String city;
	private String email;
	private String ph;
	private String gender;
	
	
	public Users(int id, String name, String dob, String city, String email, String ph, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.city = city;
		this.email = email;
		this.ph = ph;
		this.gender = gender;
	}


	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPh() {
		return ph;
	}


	public void setPh(String ph) {
		this.ph = ph;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", dob=" + dob + ", city=" + city + ", email=" + email + ", ph="
				+ ph + ", gender=" + gender + "]";
	}
	
	
}
