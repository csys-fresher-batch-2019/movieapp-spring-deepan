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

import com.chainsys.movieapp.dao.impl.MovieListDAOImpl;
import com.chainsys.movieapp.model.MovieList;
import com.chainsys.movieapp.util.DbException;

@WebServlet("/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<MovieList> List = new ArrayList<MovieList>();

		MovieList ml = new MovieList();

		ml.setMovieName(request.getParameter("Moviename"));
		ml.setMovieDuration(Integer.parseInt(request.getParameter("duration")));
		ml.setMovieLanguage(request.getParameter("Language"));
		ml.setMovieRating(Integer.parseInt(request.getParameter("Rating")));
		ml.setMovieType(request.getParameter("MovieType"));
		ml.setReleasedDate(LocalDate.parse(request.getParameter("releaseddate")));
		ml.setImageUrl(request.getParameter("image"));
		List.add(ml);

		MovieListDAOImpl obj = new MovieListDAOImpl();

		for (MovieList movie : List) {
			try {
				obj.addMovie(movie);
			} catch (DbException e) {
				e.printStackTrace();
			}
			System.out.println(movie);

		}
	}

}
