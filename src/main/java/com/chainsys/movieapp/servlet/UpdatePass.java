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

/**
 * Servlet implementation class UpdatePass
 */
@WebServlet("/UpdatePass")
public class UpdatePass extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInformationImpl im = new UserInformationImpl();
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession(false);
		String email = (String) sess.getAttribute("email");

		String password = request.getParameter("pass");
		System.out.println(email + "-" + password);
		try {

			boolean msg = im.updatePassword(email, password);
			out.println("updated" + msg);
			response.sendRedirect("Login.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
