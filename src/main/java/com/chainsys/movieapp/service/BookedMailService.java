package com.chainsys.movieapp.service;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookedMailService {
	

	private static final Logger logger = LoggerFactory.getLogger(BookedMailService.class);
	public static void send(final String from,final String password,String to,String sub,String Msg,int bookedId,int userId,int movieTheatreId,int bookedSeats,int amount) throws Exception
	{  
		logger.info("Mail send");
		Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() 
        {    
        	protected PasswordAuthentication getPasswordAuthentication() 
        	{    
        		return new PasswordAuthentication(from,password);  
        	}      
        });    
        try
        {
        	

	        MimeMessage message = new MimeMessage(session);    
	    	message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
	    	message.setSubject(sub);    
	    	BodyPart messageBodyPart1 = new MimeBodyPart();  
	    	messageBodyPart1.setText("Welcome to Movie  booking App!!\n\t");  
	        BodyPart messageBodyPart2 = new MimeBodyPart(); 
	    	messageBodyPart2.setText(Msg+"\n\t");
	    	BodyPart messageBodyPart3 = new MimeBodyPart(); 
	    	messageBodyPart3.setText("\n\t\tYour Booked Id : "+bookedId);
            BodyPart messageBodyPart4 = new MimeBodyPart(); 
	    	messageBodyPart4.setText("\n\t\tYour User Id : "+userId);
	    	BodyPart messageBodyPart5 = new MimeBodyPart(); 
	    	messageBodyPart5.setText("\n\t\tYour Movie_Theatre Id : "+movieTheatreId);
	    	BodyPart messageBodyPart6 = new MimeBodyPart(); 
	    	messageBodyPart6.setText("\n\t\tYour Booked Seats : "+bookedSeats);
	    	BodyPart messageBodyPart7 = new MimeBodyPart(); 
	    	messageBodyPart7.setText("\n\t\tYour Total Amount : "+amount);
	    	BodyPart messageBodyPart8 = new MimeBodyPart(); 
	    	messageBodyPart8.setText("\n\t If you've any Query,Please Contact us via Email!...");
	    	BodyPart messageBodyPart9 = new MimeBodyPart(); 
	    	messageBodyPart9.setText("\n\t\tThank you");
	    	
	    	Multipart multipart = new MimeMultipart();  
	    	multipart.addBodyPart(messageBodyPart1);  
	    	multipart.addBodyPart(messageBodyPart2);
	    	multipart.addBodyPart(messageBodyPart3);
	  	    multipart.addBodyPart(messageBodyPart4);
	    	multipart.addBodyPart(messageBodyPart5);
	    	multipart.addBodyPart(messageBodyPart6);  
	    	multipart.addBodyPart(messageBodyPart7);
	    	multipart.addBodyPart(messageBodyPart8);
	    	multipart.addBodyPart(messageBodyPart9);
	    	
	    	message.setContent(multipart );  
	    	Transport.send(message);    
   
	}
    catch (MessagingException e) 
    {
    	logger.debug(e.getMessage());
    	throw new RuntimeException(e);
    }
	}
	

}
