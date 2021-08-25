package com.lister.employeeonboardingsystem.services;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {
	
	
	   
	    private JavaMailSender mailSender;
     public void sendMail(String to, String subject, String body)
	    {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
        message.setSubject(subject);
	        message.setText(body);
	        mailSender.send(message);
    }

    
	}


