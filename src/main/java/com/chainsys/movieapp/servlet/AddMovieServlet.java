package com.chainsys.movieapp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.dao.impl.MovieListDAOImpl;
import com.chainsys.movieapp.model.Movie;
import com.chainsys.movieapp.exception.DbException;

@WebServlet("/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(AddMovieServlet.class);

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Movie> List = new ArrayList<Movie>();

		Movie ml = new Movie();

		ml.setMovieName(request.getParameter("Moviename"));
		ml.setMovieDuration(Integer.parseInt(request.getParameter("duration")));
		ml.setMovieLanguage(request.getParameter("Language"));
		ml.setMovieRating(Integer.parseInt(request.getParameter("Rating")));
		ml.setMovieType(request.getParameter("MovieType"));
		ml.setReleasedDate(LocalDate.parse(request.getParameter("releaseddate")));
		ml.setImageUrl(request.getParameter("image"));
		List.add(ml);

		MovieListDAOImpl obj = new MovieListDAOImpl();

		for (Movie movie : List) {
			try {
				obj.save(movie);
			} catch (DbException e) {
				logger.debug(e.getMessage());
			}
			logger.info(""+movie);

		}
	}

}
