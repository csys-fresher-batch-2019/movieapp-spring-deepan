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
import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.movieapp.service.TicketBookingService;

@WebServlet("/CancelTicketServlet")
public class CancelTicketServlet extends HttpServlet {
	@Autowired
	TicketBookingService ticketBookingService;
	private static final Logger logger = LoggerFactory.getLogger(CancelTicketServlet.class);

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookedId = request.getParameter("bookedId");

		//TicketBookingDAO impl = new TicketBookingDAOImpl();
		try {
			//impl.update(bookedId);
			ticketBookingService.cancelTicket(bookedId);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}

		PrintWriter out = response.getWriter();
		out.print("Your Ticket is successfully cancelled");
		response.sendRedirect("UserBookedDetailsServlet");
	}

}
