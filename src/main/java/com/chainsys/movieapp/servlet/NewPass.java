package com.chainsys.movieapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapp.dao.impl.SendMailSSL;

/**
 * Servlet implementation class NewPass
 */

@WebServlet("/NewPass")
public class NewPass extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String otp = request.getParameter("otp");
		String otp1 = SendMailSSL.emailOTP();
		System.out.println("otp:" + otp1 + " " + otp);
		PrintWriter out = response.getWriter();
		if (otp1.equals(otp)) {
			response.sendRedirect("UpdatePassword.jsp");

		} else
			out.println("Wrong OTP!");

	}

}
