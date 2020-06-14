package com.margub.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.margub.flightreservation.dto.ReservationUpdateRequest;
import com.margub.flightreservation.entities.Reservation;
import com.margub.flightreservation.repos.IReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	IReservationRepository reservationRepository;

	/**
	 * Find reservation rest service
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {

		System.out.println("id is one: " + id);
		return reservationRepository.getOne(id);
	}

	/**
	 * Update Reservation service
	 */

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepository.getOne(request.getId());
		reservation.setCheckedIn(request.getCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());

		return reservationRepository.save(reservation);
	}
}
