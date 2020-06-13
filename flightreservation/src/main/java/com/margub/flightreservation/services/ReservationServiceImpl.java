package com.margub.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.margub.flightreservation.dto.ReservationRequest;
import com.margub.flightreservation.entities.Flight;
import com.margub.flightreservation.entities.Passenger;
import com.margub.flightreservation.entities.Reservation;
import com.margub.flightreservation.repos.IFlightRepository;
import com.margub.flightreservation.repos.IPassengerRepository;
import com.margub.flightreservation.repos.IReservationRepository;

@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	IFlightRepository flightRepository;
	
	@Autowired
	IPassengerRepository passengerRepository;
	
	@Autowired
	IReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest reservationRequest) {
		long flightId = reservationRequest.getFlightId();
		Flight flight = flightRepository.getOne(flightId);
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(reservationRequest.getPassengerFirstName());
		passenger.setLastName(reservationRequest.getPassengerLastName());
		passenger.setEmail(reservationRequest.getPassengerEmail());
		passenger.setPhone(reservationRequest.getPassangerPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

}
