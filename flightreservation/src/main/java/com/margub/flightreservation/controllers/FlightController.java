package com.margub.flightreservation.controllers;

import java.util.Date;
import java.util.List;

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
	
	@Autowired
	IFlightRepository flightRepository;

	@RequestMapping("/findFlights")
	public String findFlights(
								@RequestParam("from") String from, 
								@RequestParam("to") String to,
								@RequestParam("departureDate")
								@DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
								ModelMap modelMap) 
	{
	
		System.out.println("Departure Date: +" + departureDate);
		
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		modelMap.addAttribute("flights", flights);
		
		

		return "displayFlights";
	}

}
