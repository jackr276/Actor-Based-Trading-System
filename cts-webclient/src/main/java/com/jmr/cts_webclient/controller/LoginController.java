package com.jmr.cts_webclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jmr.cts_webclient.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController{

	@Autowired
	private LoginService ls;

	@GetMapping("/login")
	public String showLoginPage(ModelMap model){
		//Give back the login page
		return "login";
	}

	/**
	 * We should get a post request response
	 */
	@PostMapping("/login")
	public String showLoginPage(ModelMap model,
								@RequestParam String name, @RequestParam String password){



		return "welcome";

	}

}



