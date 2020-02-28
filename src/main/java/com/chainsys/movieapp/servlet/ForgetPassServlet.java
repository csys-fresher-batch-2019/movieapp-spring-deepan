package com.chainsys.movieapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.movieapp.dao.impl.SendMailSSL;

@WebServlet("/ForgetPassServlet")
public class ForgetPassServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("emailId");
		HttpSession sess = request.getSession();
		sess.setAttribute("email", email);
		try {
			SendMailSSL.sendEmail(email);
			response.sendRedirect("Otp.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// out.print("<form action='NewPass'>");
		// out.print("Enter OTP : <input type='text' name='otp' />");
		// out.print("<input type='submit' value='submit'></button></form>");

	}

}
