package com.chainsys.movieapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.movieapp.model.Movie;
import com.chainsys.movieapp.service.MovieService;

@WebServlet("/HomeMovies")
public class HomeMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 @Autowired
 
  MovieService movieService;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		System.out.println("### List Movie Name By Released Date ###");
		try {
			List<Movie> list = movieService.findAllMovies();
			request.setAttribute("MOVIE_LIST", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("HomeMovies.jsp");
		dispatcher.forward(request, response);
	}


}
