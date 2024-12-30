package com.jmr.actor_webclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LandingController{
	@RequestMapping("/")
	public String index(Model model){
		return "welcome";
	}


}

