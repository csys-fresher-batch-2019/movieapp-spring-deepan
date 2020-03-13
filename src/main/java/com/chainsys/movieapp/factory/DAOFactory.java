package com.chainsys.movieapp.factory;

import com.chainsys.movieapp.dao.GetTotalAmountDAO;
import com.chainsys.movieapp.dao.MovieDAO;
import com.chainsys.movieapp.dao.MovieTheatreDAO;
import com.chainsys.movieapp.dao.SubMovieTheatreDAO;
import com.chainsys.movieapp.dao.TheatreListDAO;
import com.chainsys.movieapp.dao.TicketBookingDAO;
import com.chainsys.movieapp.dao.UserInformationDAO;
import com.chainsys.movieapp.dao.impl.MovieTheatreBookingDAOImpl;
import com.chainsys.movieapp.dao.impl.MovieDAOImpl;
import com.chainsys.movieapp.dao.impl.MovieTheatreDAOImpl;
import com.chainsys.movieapp.dao.impl.SubMovieTheatreImpl;
import com.chainsys.movieapp.dao.impl.TheatreListDAOImpl;
import com.chainsys.movieapp.dao.impl.TicketBookingDAOImpl;
import com.chainsys.movieapp.dao.impl.UserInformationDAOImpl;

public class DAOFactory {
	
	public static MovieDAO getMovieListDAO()
	{
	return new MovieDAOImpl();
	}
	
	public static TheatreListDAO getTheatreListDAO()
	{
		return new TheatreListDAOImpl();
	}
	
	public static MovieTheatreDAO getMovieTheatreDAO()
	{
		return new MovieTheatreDAOImpl();
	}
	
	public static UserInformationDAO getUserInformationDAO()
	{
		return new UserInformationDAOImpl();
	}
	
	public static TicketBookingDAO getTicketBookingDAO()
	{
		return new TicketBookingDAOImpl();
	}
	public static GetTotalAmountDAO getJoinGetTotAmtDAO()
	{
		return new MovieTheatreBookingDAOImpl();
	}
	public static SubMovieTheatreDAO getSubMovieTheatreDAO()
	{
		return new SubMovieTheatreImpl();
	}

}
