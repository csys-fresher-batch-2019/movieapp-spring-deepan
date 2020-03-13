package com.chainsys.movieapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.movieapp.dao.TicketBookingDAO;
import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.exception.ServiceException;
import com.chainsys.movieapp.model.TicketBooking;

@Service
public class TicketBookingService {
	@Autowired
	TicketBookingDAO ticketBookingDAO;

	public int findTicketBooking(int movieTheatreId) throws ServiceException {
		int price = 0;
		try {
			price = ticketBookingDAO.findPriceByMovieTheatreId(movieTheatreId);
		} catch (DbException e) {
			throw new ServiceException(e);

		}
		return price;

	}

	public void cancelTicket(String bookedId) throws ServiceException {
		try {
			ticketBookingDAO.update(bookedId);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
	}

	public List<TicketBooking> findUserBookedDetails(int userId) throws ServiceException {
		List<TicketBooking> list = null;
		try {
			list = ticketBookingDAO.findAllByUserId(userId);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;

	}
}
