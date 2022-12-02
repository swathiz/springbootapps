package com.app.repositories;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Admin;
import com.app.entity.User;

@Repository
public interface AuthenticationUserRepository extends CrudRepository<User, Integer>{

	

//	public Optional<User> findUserByName(String name);

//	public Admin save(Admin admin);
	

//	@Modifying
//	@Query("update User u set u.address= :address, u.phoneNum = :phoneNum where u.id = :id")
//	void update(@Param(value = "id") int id, @Param(value = "address") String address, @Param(value = "phoneNum") String phoneNum);

}