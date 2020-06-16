package com.margub.flightcheckin.integration;

import com.margub.flightcheckin.integration.dto.Reservation;
import com.margub.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface IReservationRestClient {
	
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}
