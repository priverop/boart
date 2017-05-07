package es.boart.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
 
 
@Service("boartEmail")
public class BoartMailAPI {
	
	@Autowired
	private JavaMailSender boartMail; 
	
 
	public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
 
		SimpleMailMessage boartMsg = new SimpleMailMessage();
		boartMsg.setFrom(fromAddress);
		boartMsg.setTo(toAddress);
		boartMsg.setSubject(subject);
		boartMsg.setText(msgBody);
		System.out.println(boartMsg);
		System.out.println(boartMail);
		boartMail.send(boartMsg);
	}
}