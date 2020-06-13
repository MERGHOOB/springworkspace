package com.margub.flightreservation.services;

import com.margub.flightreservation.dto.ReservationRequest;
import com.margub.flightreservation.entities.Reservation;

public interface IReservationService {

    Reservation bookFlight(ReservationRequest reservationRequest);
	
}
