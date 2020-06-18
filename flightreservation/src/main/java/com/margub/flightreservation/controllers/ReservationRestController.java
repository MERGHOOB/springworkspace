package com.margub.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

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

		LOGGER.info("inside findReservation for id: " + id);
		return reservationRepository.getOne(id);
	}

	/**
	 * Update Reservation service
	 */

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {

		LOGGER.info("inside updateReservation() for request: " + request);

		Reservation reservation = reservationRepository.getOne(request.getId());
		reservation.setCheckedIn(request.getCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());

		LOGGER.info("saving updated reservation");
		return reservationRepository.save(reservation);
	}
}
