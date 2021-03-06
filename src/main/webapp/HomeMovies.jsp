
<%@page import="com.chainsys.movieapp.model.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<title>Display all movies</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>

	<!-- A grey horizontal navbar that becomes vertical on small screens -->

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container-fluid">


		<h3>List Movies</h3>
		
           
		<div class="row">

			<%
				List<Movie> list1=(List<Movie>) request.getAttribute("MOVIE_LIST");
					for (Movie movie : list1) {
			%>
			<div class="col">
				<div class="card" style="width: 18rem;">
					<img src="assets/images/<%=movie.getImageUrl()%>"
						class="card-img-top" alt="...">

					<div class="card-body">
						<h5 class="card-title"><%=movie.getMovieName()%></h5>
						<p class="card-text">
							<span class="btn btn-success btn-sm"><%=movie.getMovieLanguage()%>
							</span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <span
								class="btn btn-danger btn-sm"><%=movie.getMovieType()%>
							</span> <br /> <br /> <span class="btn btn-dark btn-sm">Rating: <%=movie.getMovieRating()%>
							</span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; <span
								class="btn btn-warning btn-sm">Hours: <%=movie.getMovieDuration()%></span>
						</p>


						&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
						<a href="ListMovieTheatreServlet?movieId=<%=movie.getMovieId()%>"
							class="btn btn-primary"> Theatre</a>
							
					</div>
				</div>
			</div>

			<%
				}
			%>

		</div>
	</div>
	</form>
</body>
</html>