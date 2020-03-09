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

import com.chainsys.movieapp.dao.TicketBookingDAO;
import com.chainsys.movieapp.dao.impl.TicketBookingDAOImpl;
import com.chainsys.movieapp.util.DbException;

@WebServlet("/CancelTicketServlet")
public class CancelTicketServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(CancelTicketServlet.class);

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookedId = request.getParameter("bookedId");
		logger.info(bookedId);

		TicketBookingDAO impl = new TicketBookingDAOImpl();
		try {
			impl.updateBookedStatusByBookedId(bookedId);
		} catch (DbException e) {
			logger.debug(e.getMessage());
		}

		PrintWriter out = response.getWriter();
		out.print("Your Ticeket is successfully cancelled");
		response.sendRedirect("HomeMovies.jsp");
	}

}
