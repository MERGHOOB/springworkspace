package com.margub.flightreservation.utils.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

	public void generateItinerary(Reservation reservation, String filePath) {

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));

			document.open();

			document.add(generateTable(reservation));

			document.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	private PdfPTable generateTable(Reservation reservation) {

		int maxColumnInTable = 2;
		PdfPTable table = new PdfPTable(maxColumnInTable);

		PdfPCell flightItenaryCell = new PdfPCell(new Phrase("Flight Itinerary"));
		flightItenaryCell.setColspan(maxColumnInTable);

		table.addCell(flightItenaryCell);

		// ---------------Flight details

		PdfPCell flightDetailsCell = new PdfPCell(new Phrase("Flight Details"));
		flightDetailsCell.setColspan(maxColumnInTable);

		table.addCell(flightDetailsCell);
		
		// Adding flight details taking updating value from reservation
		
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

		return table;
	}

}
