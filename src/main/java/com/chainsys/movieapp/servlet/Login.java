package com.chainsys.movieapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.movieapp.dao.impl.UserInformationImpl;
import com.chainsys.movieapp.model.UserInformation;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInformationImpl uii = new UserInformationImpl();
		UserInformation ui = new UserInformation();
		ui.setEmailId(request.getParameter("EmailId"));
		ui.setEpassword(request.getParameter("Password"));
		PrintWriter out = response.getWriter();
		Integer userId = null;
		try {
			userId = uii.login(ui.getEmailId(), ui.getEpassword());
			System.out.println(userId);
			if (userId == null) {
				response.sendRedirect("Login.jsp?errorMessage=Invalid Login");

			} else {
				out.println("login success");
				HttpSession session = request.getSession();
				session.setAttribute("USER_ID", userId);
				response.sendRedirect("HomeMovies.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}