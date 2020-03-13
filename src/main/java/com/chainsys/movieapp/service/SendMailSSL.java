package com.chainsys.movieapp.service;

import java.io.IOException;
import java.util.Random;

public class SendMailSSL {
	public static String otp = null;
	static Random rnd = new Random();

	public static String generatorOTP(int length) {

		int number = rnd.nextInt(999999);
		otp = String.format("%06d", number);
		return (otp);

	}

	public static String emailOTP() {

		return otp;

	}

	public static void sendEmail(String email) throws IOException {
		otp = generatorOTP(4);
		SendMail.send("movieappservice@gmail.com", "Deepan@123", email, "Password Reset Request", "Hello user", otp);
		emailOTP();
	}

}
