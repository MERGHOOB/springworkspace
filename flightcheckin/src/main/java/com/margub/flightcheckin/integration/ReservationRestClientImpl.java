package com.margub.flightcheckin.integration;

import org.springframework.web.client.RestTemplate;

import com.margub.flightcheckin.integration.dto.Reservation;
import com.margub.flightcheckin.integration.dto.ReservationUpdateRequest;

public class ReservationRestClientImpl implements IReservationRestClient {

	private static final String FLIGHT_RESERVATION_APP_URL = "http://localhost:8080/flightreservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate
				.getForObject(FLIGHT_RESERVATION_APP_URL + id, Reservation.class);

		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation updatedReservation = restTemplate
				.postForObject(FLIGHT_RESERVATION_APP_URL, request, Reservation.class);

		return updatedReservation;
	}

}
