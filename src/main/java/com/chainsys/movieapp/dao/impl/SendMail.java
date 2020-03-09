package com.chainsys.movieapp.dao.impl;

import java.io.IOException;
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


public class SendMail 
{
	
	public static void send(final String from,final String password,String to,String sub,String Msg,String otp) throws IOException
	{  
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
	    	messageBodyPart3.setText("\n\t\tYour Reset Code : "+otp);
	    	BodyPart messageBodyPart4 = new MimeBodyPart(); 
	    	messageBodyPart4.setText("\n\t If you've any Query,Please Contact us via Email!...");
	    	BodyPart messageBodyPart5 = new MimeBodyPart(); 
	    	messageBodyPart5.setText("\n\t\tThank you");
	    	
	    	Multipart multipart = new MimeMultipart();  
	    	multipart.addBodyPart(messageBodyPart1);  
	    	multipart.addBodyPart(messageBodyPart2);
	    	multipart.addBodyPart(messageBodyPart3);
	    	multipart.addBodyPart(messageBodyPart4);
	    	multipart.addBodyPart(messageBodyPart5);
	    	
	    	message.setContent(multipart );  
	    	Transport.send(message);    
	     
	     	//logger.info("Enter the OTP");    
	}
    catch (MessagingException e) 
    {
    	throw new RuntimeException(e);
    }
	}
}  




