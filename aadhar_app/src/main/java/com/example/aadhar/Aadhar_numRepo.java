package com.example.aadhar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Aadhar_numRepo extends JpaRepository<Aadhar_num, Integer>{
	public List<Aadhar_num> findByAadhar_num(int aadhar_num);

}
