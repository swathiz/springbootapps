package com.app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Admin;
import com.app.entity.User;
@Repository
public interface AuthenticationAdminRepository extends CrudRepository<Admin, Integer>{

	User save(User user);
//	public Optional<Admin> findAdminByName(String name);

}