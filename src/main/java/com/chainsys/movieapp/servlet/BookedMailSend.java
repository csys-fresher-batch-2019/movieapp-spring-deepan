package com.chainsys.movieapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.movieapp.dao.impl.BookedMail;
import com.chainsys.movieapp.dao.impl.UserInformationImpl;
import com.chainsys.movieapp.model.TicketBooking;
import com.chainsys.movieapp.util.DbException;

@WebServlet("/BookedMailSend")
public class BookedMailSend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TicketBooking tb = new TicketBooking();

		HttpSession ses = request.getSession(false);
		Integer userId = (Integer) ses.getAttribute("USER_ID");
		System.out.println(userId);
		String seat = (String) ses.getAttribute("no_of_seats");
		System.out.println(seat);
		Integer totalAmount = (Integer) ses.getAttribute("tot_amt");
		System.out.println(totalAmount);
		Integer movieTheatreId = (Integer) ses.getAttribute("movieTheatreId");
		System.out.println(movieTheatreId);
		Integer m = movieTheatreId;
		Integer ns = Integer.parseInt(seat);
		System.out.println(ns);
		
		UserInformationImpl ui = new UserInformationImpl();
		String Email = null;
		try {
			Email = ui.getEmailId(userId);
			System.out.println(Email);
		} catch (DbException e) {

			e.printStackTrace();
		}
		String s = request.getParameter("mail");
		if (s.equals("yes")) {
			try {

				System.out.println();
				BookedMail.send("movieappservice@gmail.com", "Deepan@123", Email, "Booking Details",
						"Successfully booked", 1, userId, m, ns, totalAmount);
				System.out.println(Email + " Mail sent Successfully");
				response.sendRedirect("HomeMovies.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else

			response.sendRedirect("index.jsp");

	}

}
