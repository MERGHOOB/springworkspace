package com.margub.flightreservation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/showReg")
	public String showRegisterationPage() {
		
		
		return "login/registerUser";
	}
}