package com.example.countries.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Country {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String countryname;
	
	
	
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCountryname() {
		return countryname;
	}


	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}


	public Country(int id, String countryname) {
		super();
		this.id = id;
		this.countryname = countryname;
	}


	@Override
	public String toString() {
		return "Country [id=" + id + ", countryname=" + countryname + "]";
	}
	
	

}
