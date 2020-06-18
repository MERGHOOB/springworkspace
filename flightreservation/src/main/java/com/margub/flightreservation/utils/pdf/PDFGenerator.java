package com.margub.flightreservation.utils.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.margub.flightreservation.entities.Reservation;

@Component
public class PDFGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);

	public void generateItinerary(Reservation reservation, String filePath) {

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));

			document.open();

			document.add(generateTableForFlight(reservation));

			document.close();

		} catch (FileNotFoundException | DocumentException e) {
			LOGGER.error("exception in generateItinerary()", e);
		}
	}

	private PdfPTable generateTableForFlight(Reservation reservation) {

		int maxColumnInTable = 2;
		PdfPTable table = new PdfPTable(maxColumnInTable);

		PdfPCell flightItenaryCell = new PdfPCell(new Phrase("Flight Itinerary"));
		flightItenaryCell.setColspan(maxColumnInTable);

		table.addCell(flightItenaryCell);

		updateFlightDetails(reservation, maxColumnInTable, table);
		updatePassengerDetails(reservation, maxColumnInTable, table);

		return table;
	}

	private void updatePassengerDetails(Reservation reservation, int maxColumnInTable, PdfPTable table) {

		PdfPCell passengerItineraryCell = new PdfPCell(new Phrase("Passenger Details"));
		passengerItineraryCell.setColspan(maxColumnInTable);

		table.addCell(passengerItineraryCell);

		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());

		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());

		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());

		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());
	}

	private void updateFlightDetails(Reservation reservation, int maxColumnInTable, PdfPTable table) {

		PdfPCell flightDetailsCell = new PdfPCell(new Phrase("Flight Details"));
		flightDetailsCell.setColspan(maxColumnInTable);

		table.addCell(flightDetailsCell);

		table.addCell("Airline");
		table.addCell(reservation.getFlight().getOperatingAirlines());

		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());

		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());

		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());

		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());

		table.addCell("Departure time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
	}

}
