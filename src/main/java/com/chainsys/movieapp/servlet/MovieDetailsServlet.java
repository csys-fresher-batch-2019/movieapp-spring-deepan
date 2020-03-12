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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.dao.impl.MovieListDAOImpl;
import com.chainsys.movieapp.model.Movie;

@WebServlet("/MovieDetailsServlet")
public class MovieDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MovieDetailsServlet.class);


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MovieListDAOImpl obj = new MovieListDAOImpl();
		String movieName = request.getParameter("movieName");
		logger.info(movieName);
		List<Movie> list = new ArrayList<Movie>();
		try {

			list = obj.findByMovieName(movieName);
			request.setAttribute("MOVIE_LIST", list);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("MovieDetails.jsp");
		dispatcher.forward(request, response);
	}

}
