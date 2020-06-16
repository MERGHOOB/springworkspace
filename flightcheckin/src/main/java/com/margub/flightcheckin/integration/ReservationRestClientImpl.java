package com.margub.flightcheckin.integration;

import org.springframework.web.client.RestTemplate;

import com.margub.flightcheckin.integration.dto.Reservation;
import com.margub.flightcheckin.integration.dto.ReservationUpdateRequest;

public class ReservationRestClientImpl implements IReservationRestClient {

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate
				.getForObject("http://localhost:8080/flightreservation/reservations/" + id, Reservation.class);

		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		return null;
	}

}
