package com.chainsys.movieapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.dao.impl.BookedMail;
import com.chainsys.movieapp.dao.impl.UserInformationImpl;
import com.chainsys.movieapp.exception.DbException;

@WebServlet("/BookedMailSend")
public class BookedMailSend extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(BookedMailSend.class);

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		HttpSession ses = request.getSession(false);
		Integer userId = (Integer) ses.getAttribute("USER_ID");
		logger.info(""+userId);
		String seat = (String) ses.getAttribute("no_of_seats");
		logger.info(seat);
		Integer totalAmount = (Integer) ses.getAttribute("tot_amt");
		logger.info(""+totalAmount);
		Integer movieTheatreId = (Integer) ses.getAttribute("movieTheatreId");
		logger.info(""+movieTheatreId);
		Integer m = movieTheatreId;
		Integer ns = Integer.parseInt(seat);
		logger.info(""+ns);
		
		UserInformationImpl ui = new UserInformationImpl();
		String Email = null;
		try {
			Email = ui.findEmailIdByUserId(userId);
			logger.info(Email);
		} catch (DbException e) {

			logger.debug(e.getMessage());
		}
		String s = request.getParameter("mail");
		if (s.equals("yes")) {
			try {

				
				BookedMail.send("movieappservice@gmail.com", "Deepan@123", Email, "Booking Details",
						"Successfully booked", 1, userId, m, ns, totalAmount);
				logger.info(Email + " Mail sent Successfully");
				response.sendRedirect("HomeMovies.jsp");

			} catch (Exception e) {
				logger.debug(e.getMessage());
			}

		} else

			response.sendRedirect("index.jsp");

	}

}
