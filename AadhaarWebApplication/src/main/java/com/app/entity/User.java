package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String email;
	private String password;
	private String address;
	private String phoneNum;
	private String dob;
	private String status;
	private String aadhaarNum;
	private Boolean newCardRequest;
	private Boolean duplicateCardRequest;
	
	
	public Boolean getNewCardRequest() {
		return newCardRequest;
	}
	public void setNewCardRequest(Boolean newCardRequest) {
		this.newCardRequest = newCardRequest;
	}
	public Boolean getDuplicateCardRequest() {
		return duplicateCardRequest;
	}
	public void setDuplicateCardRequest(Boolean duplicateCardRequest) {
		this.duplicateCardRequest = duplicateCardRequest;
	}
	public String getAadhaarNum() {
		return aadhaarNum;
	}
	public void setAadhaarNum(String aadhaarNum) {
		this.aadhaarNum = aadhaarNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", phoneNum=" + phoneNum + ", dob=" + dob + ", status=" + status + ", aadhaarNum="
				+ aadhaarNum + ", newCardRequest=" + newCardRequest + ", duplicateCardRequest=" + duplicateCardRequest
				+ "]";
	}
	

	
	
	
}