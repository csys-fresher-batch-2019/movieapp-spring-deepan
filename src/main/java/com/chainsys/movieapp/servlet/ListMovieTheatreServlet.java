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

import com.chainsys.movieapp.model.MovieTheatre;
import com.chainsys.movieapp.service.MovieTheatreService;

@WebServlet("/ListMovieTheatreServlet")
public class ListMovieTheatreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	MovieTheatreService movieTheatreService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String movieIdStr = request.getParameter("movieId");
		int movieId = Integer.parseInt(movieIdStr);

		// MovieTheatreDAO dao = new MovieTheatreDAOImpl();

		try {
			List<MovieTheatre> list = movieTheatreService.findActiveTheatre(movieId);
			request.setAttribute("Movie_theatre", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListMovieTheatre.jsp");
		dispatcher.forward(request, response);
	}

}
