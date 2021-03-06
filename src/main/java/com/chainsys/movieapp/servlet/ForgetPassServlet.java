package com.chainsys.movieapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.service.SendMailSSL;

@WebServlet("/ForgetPassServlet")
public class ForgetPassServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ForgetPassServlet.class);


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("emailId");
		HttpSession sess = request.getSession();
		sess.setAttribute("email", email);
		try {
			SendMailSSL.sendEmail(email);
			response.sendRedirect("Otp.jsp");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		// out.print("<form action='NewPass'>");
		// out.print("Enter OTP : <input type='text' name='otp' />");
		// out.print("<input type='submit' value='submit'></button></form>");

	}

}
