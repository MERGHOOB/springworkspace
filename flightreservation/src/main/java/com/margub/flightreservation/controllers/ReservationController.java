package com.margub.flightreservation.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.margub.flightreservation.dto.ReservationRequest;
import com.margub.flightreservation.entities.Flight;
import com.margub.flightreservation.entities.Reservation;
import com.margub.flightreservation.repos.IFlightRepository;
import com.margub.flightreservation.services.IReservationService;

@Controller
public class ReservationController {

	@Autowired
	IFlightRepository flightRepository;
	
	@Autowired
	IReservationService reservationService;
	
	@RequestMapping	("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") long flightId, ModelMap modelMap) {
		
		Flight flight = flightRepository.getOne(flightId);
		modelMap.addAttribute("flight", flight);
		
		return "completeReservation";
	}
	
	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and the reservation id is " + reservation.getId());
		return  "reservationConfirmation";
	}
	
	
}
