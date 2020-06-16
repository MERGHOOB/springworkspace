package com.margub.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.margub.flightcheckin.integration.IReservationRestClient;
import com.margub.flightcheckin.integration.dto.Reservation;
import com.margub.flightcheckin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckinController {

	@Autowired
	IReservationRestClient reservationRestClient;

	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckin";
	}

	@RequestMapping("/startCheckin")
	public String startCheckin(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {

		Reservation reservation = reservationRestClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}

	@RequestMapping("/completeCheckin")
	public String completeCheckin(@RequestParam("reservationId") Long reservationId,
			@RequestParam("numberOfBags") int numberOfBags) {

		ReservationUpdateRequest request = new ReservationUpdateRequest();
		request.setId(reservationId);
		request.setNumberOfBags(numberOfBags);

		reservationRestClient.updateReservation(request);

		return "checkinConfirmation";
	}

}
