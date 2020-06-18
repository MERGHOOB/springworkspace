package com.margub.flightreservation.utils.mail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	JavaMailSender mailSender;

	public void sendItinerary(String toAddress, String filePath) {

		MimeMessage message = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(toAddress);

			helper.setSubject("Itinerary for your flight");

			helper.setText("Please find your itinerary attached");
			helper.setText("Thank you");

			helper.addAttachment("Itinerary", new File(filePath));

			mailSender.send(message);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
