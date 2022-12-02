package com.example.quizapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.quizapp.exceptions.GeneralException;


@Controller
public class QuizController {
	
	@Autowired
//	ProductRepository repo;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String showIndexPage() {
		return "index";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String showUserPage(@RequestParam("username") String username, @RequestParam("password") String password) throws GeneralException {
		if(username.equals("user")&&password.equals("1234")) {
			return "takequiz";
		}else {
			throw new GeneralException("invalid username or password");
		}	
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String showAdminPage(@RequestParam("username") String username, @RequestParam("password") String password) throws GeneralException {
		if(username.equals("admin")&&password.equals("1234")) {
			return "admin_mainpage";
		}else {
			throw new GeneralException("invalid username or password");
		}
		
	}
	
	
	
	

}
