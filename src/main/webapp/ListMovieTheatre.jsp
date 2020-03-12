
<%@page import="com.chainsys.movieapp.dao.impl.MovieTheatreDAOImpl"%>
<%@page import="com.chainsys.movieapp.model.MovieTheatre"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.movieapp.dao.MovieTheatreDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>



	
	<div class="container">
		<h3>Movies List</h3>
		<div class="row">
			<% 
			List<MovieTheatre> list=(List<MovieTheatre>)request.getAttribute("Movie_theatre");
for(MovieTheatre m: list)
{%>
			<div class="col">
				<div class="card" style="width: 18rem;">
					<img src="assets/images/<%=m.getTheatreImageUrl()%>"
						class="card-img-top" alt="...">


					<div class="card-body">
						<h5 class="card-title">
							<span class="btn btn-success btn-sm">Theatre Name: <%=m.getTheatreName()%></span>
							</p>
						</h5>
						<p class="card-text">
							<span class="btn btn-light btn-sm">Theatre Address: <%=m.getTheatreAddress() %></span>
						</p>
						<span class="btn btn-light btn-sm">Theatre Rating: <%=m.getTheatreRating() %></span>
						</p>
						<span class="btn btn-light btn-sm">Movie Theatre Id: <%=m.getMovieTheatreId() %></span>
						</p>
						<span class="btn btn-light btn-sm">Time: <%=m.getMovieTiming() %></span>
						</p>
						<span class="btn btn-light btn-sm">Price: <%=m.getPrice() %></span>
						</p>

						&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;<a
							href="TicketBooking.jsp?movieTheatreId=<%= m.getMovieTheatreId() %>"
							class="btn btn-danger"> Ticket Booking</a>

						<% HttpSession sess=request.getSession();
                          sess.setAttribute("movieTheatreId",m.getMovieTheatreId());  %>

					</div>
				</div>
			</div>
			<% }%>
		</div>
	</div>
</body>
</html>