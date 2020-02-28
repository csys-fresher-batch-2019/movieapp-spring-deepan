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

import com.chainsys.movieapp.dao.impl.MovieListDAOImpl;
import com.chainsys.movieapp.model.MovieList;

@WebServlet("/MovieDetailsServlet")
public class MovieDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MovieListDAOImpl obj = new MovieListDAOImpl();
		String movieName = request.getParameter("movieName");
		System.out.println(movieName);
		List<MovieList> list = new ArrayList<MovieList>();
		try {

			list = obj.allMovieDetails(movieName);
			request.setAttribute("MOVIE_LIST", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("MovieDetails.jsp");
		dispatcher.forward(request, response);
	}

}
