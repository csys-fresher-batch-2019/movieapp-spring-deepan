package com.chainsys.movieapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.dao.impl.MovieListDAOImpl;
import com.chainsys.movieapp.dao.impl.UserInformationDAOImpl;

/**
 * Servlet implementation class UpdatePass
 */
@WebServlet("/UpdatePass")
public class UpdatePass extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(UpdatePass.class);


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInformationDAOImpl im = new UserInformationDAOImpl();
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession(false);
		String email = (String) sess.getAttribute("email");

		String password = request.getParameter("pass");
		logger.info(email + "-" + password);
		try {

			boolean msg = im.update(email, password);
			out.println("updated" + msg);
			response.sendRedirect("Login.jsp");

		} catch (Exception e) {
			logger.debug(e.getMessage());
		}

	}

}
