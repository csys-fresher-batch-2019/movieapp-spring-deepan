package com.chainsys.movieapp.factory;

import com.chainsys.movieapp.dao.JoinGetTotAmtDAO;
import com.chainsys.movieapp.dao.MovieListDAO;
import com.chainsys.movieapp.dao.MovieTheatreDAO;
import com.chainsys.movieapp.dao.SubMovieTheatreDAO;
import com.chainsys.movieapp.dao.TheatreListDAO;
import com.chainsys.movieapp.dao.TicketBookingDAO;
import com.chainsys.movieapp.dao.UserInformationDAO;
import com.chainsys.movieapp.dao.impl.JoinGetTotAmtDAOImpl;
import com.chainsys.movieapp.dao.impl.MovieListDAOImpl;
import com.chainsys.movieapp.dao.impl.MovieTheatreDAOImpl;
import com.chainsys.movieapp.dao.impl.SubMovieTheatreImpl;
import com.chainsys.movieapp.dao.impl.TheatreListDAOImpl;
import com.chainsys.movieapp.dao.impl.TicketBookingDAOImpl;
import com.chainsys.movieapp.dao.impl.UserInformationImpl;

public class DAOFactory {
	
	public static MovieListDAO getMovieListDAO()
	{
	return new MovieListDAOImpl();
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
		return new UserInformationImpl();
	}
	
	public static TicketBookingDAO getTicketBookingDAO()
	{
		return new TicketBookingDAOImpl();
	}
	public static JoinGetTotAmtDAO getJoinGetTotAmtDAO()
	{
		return new JoinGetTotAmtDAOImpl();
	}
	public static SubMovieTheatreDAO getSubMovieTheatreDAO()
	{
		return new SubMovieTheatreImpl();
	}

}
