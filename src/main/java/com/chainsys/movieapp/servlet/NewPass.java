package com.chainsys.movieapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.dao.impl.MovieListDAOImpl;
import com.chainsys.movieapp.service.SendMailSSL;

/**
 * Servlet implementation class NewPass
 */

@WebServlet("/NewPass")
public class NewPass extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(NewPass.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String otp = request.getParameter("otp");
		String otp1 = SendMailSSL.emailOTP();
		logger.info("otp:" + otp1 + " " + otp);
		PrintWriter out = response.getWriter();
		if (otp1.equals(otp)) {
			response.sendRedirect("UpdatePassword.jsp");

		} else
			out.println("Wrong OTP!");

	}

}
