package com.chainsys.movieapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapp.dao.impl.MovieListDAOImpl;
import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.model.Movie;

@WebServlet("/HomeMovies")
public class HomeMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieListDAOImpl obj = new MovieListDAOImpl();
		System.out.println("### List Movie Name By Released Date ###");
		try {
			List<Movie> list = obj.findAll();
			request.setAttribute("MOVIE_LIST", list);
		} catch (DbException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("HomeMovies.jsp");
		dispatcher.forward(request, response);
	}


}
