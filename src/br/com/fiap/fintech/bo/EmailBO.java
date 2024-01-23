package br.com.fiap.fintech.bo;

import java.util.Properties;

import br.com.fiap.fintech.exception.EmailException;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailBO {

	public void enviarEmail(String destinatario, String assunto, String mensagem) throws EmailException{
		final String username = "email@gmail.com";
		final String password = "senha";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message email = new MimeMessage(session);
			email.setFrom(new InternetAddress(username));
			email.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(destinatario));
			email.setSubject(assunto);
			email.setText(mensagem);

			Transport.send(email);

		} catch (MessagingException e) {
			throw new EmailException("Erro ao enviar o e-mail");
		}
	}
}