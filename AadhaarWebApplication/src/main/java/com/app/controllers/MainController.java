package com.app.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.entity.Admin;

import com.app.entity.User;
import com.app.exceptions.AdminNotFoundException;
import com.app.exceptions.UserNotFoundException;
import com.app.repositories.AuthenticationAdminRepository;
import com.app.repositories.AuthenticationUserRepository;

import com.app.services.AuthenticationAdminService;
import com.app.services.AuthenticationUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainController {
	Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	AuthenticationUserService userAuthService;

	@Autowired
	AuthenticationAdminService adminAuthService;

	@Autowired
	AuthenticationUserRepository userAuthRepo;

	@Autowired
	AuthenticationAdminRepository adminAuthRepo;

//	Boolean submitted = false;

	// *****************
	// ADMIN
	// *****************

	// Admin Signup
	@RequestMapping(value = "/admin/signup", method = RequestMethod.POST)
	public Admin createAdmin(@RequestBody Admin admin) {
		return adminAuthRepo.save(admin);
	}

	// Admin Login
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public String adminLogin(@RequestBody Admin admin) {
		String mail = admin.getEmail();
		String pwd = admin.getPassword();
		if (mail.equals("admin@mail.com") && pwd.equals("admin")) {
			return "Admin Logged in.";
		} else {
			return "Invalid Username or Password.";
		}
	}

	// List All Users
	@GetMapping("/admin/listUsers")
	public Iterable<User> list() {
		return userAuthRepo.findAll();
	}

	// User Delete
	@PostMapping("/admin/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		Optional<User> optProduct = userAuthRepo.findById(id);
		if (optProduct.isEmpty()) {
//			return "Invalid username or Password.";
			throw new UserNotFoundException();
		}
		User u = new User();
		u = optProduct.get();
		if (u.getStatus() == "Alive") {
			return "Cannot delete Aadhaar.";
		} else {
			userAuthRepo.deleteById(id);
			return "Aadhaar deleted.";
		}
	}

	// Admin Issue New Card
	@RequestMapping(value = "/admin/newCard/{id}", method = RequestMethod.POST)
	public ResponseEntity<User> issueNewCard(@PathVariable("id") Integer id, @RequestBody User user) {
		Optional<User> optProduct = userAuthRepo.findById(id);
		if (optProduct.isEmpty()) {
			throw new UserNotFoundException();
		}

		User u = new User();
		u = optProduct.get();

		Random generator = new Random(System.currentTimeMillis());
		Long num = generator.nextLong() % 1000000000;
		String aadhNum = String.valueOf(num);

		if ((u.getNewCardRequest() == true) && (u.getAadhaarNum() == null)) {
			u.setNewCardRequest(null);
			u.setAadhaarNum(aadhNum);
		}
		final User updatedUser = userAuthRepo.save(u);
		return ResponseEntity.ok(updatedUser);

	}

	// Admin Issue New Card
	@RequestMapping(value = "/admin/dupCard/{id}", method = RequestMethod.POST)
	public ResponseEntity<User> issueDupCard(@PathVariable("id") Integer id, @RequestBody User user) {
		Optional<User> optProduct = userAuthRepo.findById(id);
		if (optProduct.isEmpty()) {
			throw new UserNotFoundException();
		}

		User u = new User();
		u = optProduct.get();

		Random generator = new Random(System.currentTimeMillis());
		Long num = generator.nextLong() % 1000000000;
		String aadhNum = String.valueOf(num);

		if ((u.getDuplicateCardRequest() == true)) {
			u.setDuplicateCardRequest(null);
			u.setAadhaarNum(aadhNum);
		}
		final User updatedUser = userAuthRepo.save(u);
		return ResponseEntity.ok(updatedUser);

	}

	// *****************
	// USER
	// *****************

	// User Signup
	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return userAuthRepo.save(user);
	}

	// User Login
	@RequestMapping(value = "/user/login/{id}", method = RequestMethod.POST)
	public String userLogin(@PathVariable("id") Integer id, @RequestBody User user) {
		Optional<User> optProduct = userAuthRepo.findById(id);
		if (optProduct.isEmpty()) {
//			return "Invalid username or Password.";
			throw new UserNotFoundException();
		}

		User u = new User();
		u = optProduct.get();

		String mail = user.getEmail();
		String pwd = user.getPassword();
		if (mail.equals(u.getEmail()) && pwd.equals(u.getPassword())) {
			return "User Logged in.";
		} else {
			return "Invalid Username or Password.";
		}

	}

	// User Update
	@RequestMapping(value = "/user/update/{id}", method = RequestMethod.POST)
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		Optional<User> optProduct = userAuthRepo.findById(id);
		if (optProduct.isEmpty()) {
			throw new UserNotFoundException();
		}

		User u = new User();
		u = optProduct.get();

		u.setAddress(user.getAddress());
		u.setPhoneNum(user.getPhoneNum());
		u.setDob(user.getDob());
		final User updatedUser = userAuthRepo.save(u);
		return ResponseEntity.ok(updatedUser);

	}

	// User Apply New Card
	@RequestMapping(value = "/user/newCard/{id}", method = RequestMethod.POST)
	public ResponseEntity<User> newCard(@PathVariable("id") Integer id, @RequestBody User user) {
		Optional<User> optProduct = userAuthRepo.findById(id);
		if (optProduct.isEmpty()) {
			throw new UserNotFoundException();
		}

		User u = new User();
		u = optProduct.get();

//		u.setNewCardRequest(user.getNewCardRequest());
		u.setNewCardRequest(true);
		final User updatedUser = userAuthRepo.save(u);
		return ResponseEntity.ok(updatedUser);

	}

	// User Apply New Card
	@RequestMapping(value = "/user/dupCard/{id}", method = RequestMethod.POST)
	public ResponseEntity<User> dupCard(@PathVariable("id") Integer id, @RequestBody User user) {
		Optional<User> optProduct = userAuthRepo.findById(id);
		if (optProduct.isEmpty()) {
			throw new UserNotFoundException();
		}

		User u = new User();
		u = optProduct.get();

		u.setDuplicateCardRequest(user.getDuplicateCardRequest());
		final User updatedUser = userAuthRepo.save(u);
		return ResponseEntity.ok(updatedUser);

	}

}