package com.jmr.cts_webclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;

import org.springframework.boot.web.servlet.error.ErrorController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController{

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model){
		Integer status = (Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		String error = (String)request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
		//Grab the date
		Timestamp currentSqlTimestamp = new Timestamp(System.currentTimeMillis());

		//Add into the model
		model.addAttribute("status", status);
		model.addAttribute("error", error);
		model.addAttribute("timestamp", currentSqlTimestamp.toString());

		return "error";
	}
	
	public String getErrorPath(){
		return "/error";
	}

}
