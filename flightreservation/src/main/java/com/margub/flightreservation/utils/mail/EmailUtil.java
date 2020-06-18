package com.margub.flightreservation.utils.mail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

	@Autowired
	JavaMailSender mailSender;

	public void sendItinerary(String toAddress, String filePath) {

		LOGGER.info("inside sendItinerary()");

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
			LOGGER.error("Exception inside in sendItinerary()", e);
		}
	}
}
