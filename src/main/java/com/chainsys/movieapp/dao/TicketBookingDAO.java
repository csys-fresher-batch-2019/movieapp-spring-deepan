package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.util.DbException;
import com.chainsys.movieapp.model.TicketBooking;


public interface TicketBookingDAO {
	
    void save(TicketBooking list) throws DbException;
    void deleteBookingDetailsByUserId(int userId) throws DbException;
    int findPriceByMovieTheatreId(int movieTheatreId) throws DbException;
    List<TicketBooking> findAllByUserId(int userId) throws DbException;
    void updateBookedStatusByBookedId(String bookedId)throws DbException;


}
