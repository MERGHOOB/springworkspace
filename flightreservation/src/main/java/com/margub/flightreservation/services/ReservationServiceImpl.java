package com.margub.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.margub.flightreservation.dto.ReservationRequest;
import com.margub.flightreservation.entities.Flight;
import com.margub.flightreservation.entities.Passenger;
import com.margub.flightreservation.entities.Reservation;
import com.margub.flightreservation.repos.IFlightRepository;
import com.margub.flightreservation.repos.IPassengerRepository;
import com.margub.flightreservation.repos.IReservationRepository;
import com.margub.flightreservation.utils.mail.EmailUtil;
import com.margub.flightreservation.utils.pdf.PDFGenerator;

@Service
public class ReservationServiceImpl implements IReservationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	private static final String UNDERSCORE = "_";

	private static final String RESERVATION_FOLDER_PATH = "C:\\margub\\training\\Documents\\reservations\\";

	@Autowired
	IFlightRepository flightRepository;

	@Autowired
	IPassengerRepository passengerRepository;

	@Autowired
	IReservationRepository reservationRepository;

	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest reservationRequest) {
		
		LOGGER.info("inside bookFlight() at service layer");
		
		long flightId = reservationRequest.getFlightId();
		LOGGER.info("Fetching flight for flight id: " + flightId);

		Flight flight = flightRepository.getOne(flightId);

		Passenger passenger = new Passenger();
		passenger.setFirstName(reservationRequest.getPassengerFirstName());
		passenger.setLastName(reservationRequest.getPassengerLastName());
		passenger.setEmail(reservationRequest.getPassengerEmail());
		passenger.setPhone(reservationRequest.getPassengerPhone());

		LOGGER.info("Saving the passenger: " + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);

		LOGGER.info("Saving the reservation: " + reservation);

		Reservation savedReservation = reservationRepository.save(reservation);

		String pdFpath = getPDFpath(savedReservation);
		LOGGER.info("Generating the Itinerary");
		pdfGenerator.generateItinerary(savedReservation, pdFpath);

		LOGGER.info("Emailing the itenary");
		emailUtil.sendItinerary(savedReservation.getPassenger().getEmail(), pdFpath);

		LOGGER.info("Successfully saved the reservationa and emailed");;
		return savedReservation;
	}

	private String getPDFpath(Reservation savedReservation) {
		return RESERVATION_FOLDER_PATH + savedReservation.getFlight().getDepartureCity() + UNDERSCORE
				+ savedReservation.getFlight().getArrivalCity() + UNDERSCORE + savedReservation.getId() + ".pdf";
	}

}
