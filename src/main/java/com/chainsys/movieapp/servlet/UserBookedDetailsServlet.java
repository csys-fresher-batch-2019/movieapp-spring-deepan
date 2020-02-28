package com.chainsys.movieapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.movieapp.dao.impl.TicketBookingDAOImpl;
import com.chainsys.movieapp.model.TicketBooking;
import com.chainsys.movieapp.util.DbException;

/**
 * Servlet implementation class UserBookedDetailsServlet
 */
@WebServlet("/UserBookedDetailsServlet")
public class UserBookedDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("USER_ID");

		if (userId == null) {
			response.sendRedirect("Login.jsp");
		} else {
			TicketBookingDAOImpl obj = new TicketBookingDAOImpl();
			List<TicketBooking> list = new ArrayList<TicketBooking>();
			try {
				list = obj.getUserBookedDetails(userId);
			} catch (DbException e) {
				e.printStackTrace();
			}
			request.setAttribute("UserBookedDetails", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UserBookedDetails.jsp");
			dispatcher.forward(request, response);
		}

	}
}