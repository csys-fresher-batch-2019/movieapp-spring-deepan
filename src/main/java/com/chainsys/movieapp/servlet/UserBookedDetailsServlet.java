package com.chainsys.movieapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.movieapp.model.TicketBooking;
import com.chainsys.movieapp.service.TicketBookingService;

/**
 * Servlet implementation class UserBookedDetailsServlet
 */
@WebServlet("/UserBookedDetailsServlet")
public class UserBookedDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	TicketBookingService ticketBookingService;
	private static final Logger logger = LoggerFactory.getLogger(UpdatePass.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("USER_ID");

		if (userId == null) {
			response.sendRedirect("Login.jsp");
		} else {
			// TicketBookingDAOImpl obj = new TicketBookingDAOImpl();
			List<TicketBooking> list = null;
			try {
				list = ticketBookingService.findUserBookedDetails(userId);
				System.out.println("servlet"+list);
				request.setAttribute("UserBookedDetails", list);
				RequestDispatcher dispatcher = request.getRequestDispatcher("UserBookedDetails.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				logger.debug(e.getMessage());
			}
			
		}

	}
}