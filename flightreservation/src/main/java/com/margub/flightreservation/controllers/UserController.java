package com.margub.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.margub.flightreservation.entities.User;
import com.margub.flightreservation.repos.IUserRepository;

@Controller
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	IUserRepository userRepository;

	@RequestMapping("/showReg")
	public String showRegisterationPage() {

		LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user) {

		LOGGER.info("Inside registerUser()" + user);

		userRepository.save(user);

		return "login/login";
	}

	@RequestMapping("/showLogin")
	public String showLoginPage() {

		LOGGER.info("Inside showLoginPage()");

		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {

		LOGGER.info("inside login() and email is: " + email);

		User user = userRepository.findByEmail(email);

		if (user.getPassword().equals(password)) {

			return "findFlights";
		} else {

			String message = "Inavlid UserName or Password! Please try again";
			modelMap.addAttribute("msg", message);
			return "login/login";
		}

	}

}
