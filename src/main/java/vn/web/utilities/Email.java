package vn.web.utilities;

import java.lang.annotation.Annotation;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import vn.web.models.UserModel;

public class Email {

	public String getRandom() {
		Random random = new Random();
		int number = random.nextInt(999999);
		return String.format("%06d", number);
	}

	public boolean sendEmailToActive(UserModel user) {
		boolean check = false;

		String toEmail = user.getEmail();
		String fromEmail = "22110218@student.hcmute.edu.vn";
		String password = "SPK22110218@";

		try {
			// Config email properties (use TLS or SSL as needed)
			Properties props = configEmail(new Properties());

			// Create the email session with authentication
			Session session = Session.getInstance(props, new Authenticator() {
				@Override
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(fromEmail, password);
				}
			});

			// Compose the email
			Message message = new MimeMessage(session);
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			message.setFrom(new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject("Confirm code");
			message.setText("Your code is: " + user.getCode());
			// Send the email
			Transport.send(message);
			check = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}
	
	public boolean sendForgotPasswordByEmail(UserModel user) {
		boolean check = false;

		String toEmail = user.getEmail();
		String fromEmail = "";
		String password = "";

		try {
			// Config email properties (use TLS or SSL as needed)
			Properties props = configEmail(new Properties());

			// Create the email session with authentication
			Session session = Session.getInstance(props, new Authenticator() {
				@Override
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(fromEmail, password);
				}
			});

			// Compose the email
			Message message = new MimeMessage(session);
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			message.setFrom(new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject("Your password");
			message.setText("Your password is: " + user.getPassword());
			// Send the email
			Transport.send(message);
			check = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	public Properties configEmail(Properties props) {
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		return props;
	}
}
