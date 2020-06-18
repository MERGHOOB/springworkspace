package com.margub.flightreservation.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.margub.flightreservation.entities.Flight;
import com.margub.flightreservation.repos.IFlightRepository;

@Controller
public class FlightController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@Autowired
	IFlightRepository flightRepository;

	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
			ModelMap modelMap) {

		LOGGER.info("inside findFlights() from: " + from + " to: " + to + "departure date: " + departureDate);

		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		modelMap.addAttribute("flights", flights);

		LOGGER.info("Fligts found are: " + flights);
		return "displayFlights";
	}

}
