<%@page import="com.chainsys.movieapp.model.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
 List<Movie> list=(List<Movie>)request.getAttribute("MOVIE_LIST");
if (list !=null){
for (Movie m : list) 
{
	out.println("<pre> MOVIE ID <input type='number' name='movieid' value="+m.getMovieId()+"><br></br></pre>");
	out.println("<pre> MOVIE NAME <input type='text' name='moviename' value="+m.getMovieName()+"><br></br></pre>");
	out.println("<pre> MOVIE TYPE <input type='text' name='movietype' value="+m.getMovieType()+"><br></br></pre>");
	out.println("<pre> MOVIE LANGUAGE <input type='text' name='movielanguage' value="+m.getMovieLanguage()+"><br></br></pre>");
	out.println("<pre> MOVIE DURATION <input type='number' name='movieduration' value="+m.getMovieDuration()+"><br></br></pre>");
	out.println("<pre> MOVIE RATING <input type='number' name='movierating' value="+m.getMovieRating()+"><br></br></pre>");
	out.println("<pre> MOVIE RELEASED DATE <input type='date' name='releaseddate' value="+m.getReleasedDate()+"><br></br></pre>");

}	
}
else{
	out.println("No records");
}
%>
	<%
for(Movie m :list){%>
	<div class="card" style="width: 18rem;">
		<img src="..." class="card-img-top" alt="...">
		<div class="card-body">
			<h5 class="card-title">Card title</h5>
			<p class="card-text">Some quick example text to build on the card
				title and make up the bulk of the card's content.</p>
			<a href="#" class="btn btn-primary">Go somewhere</a>
		</div>
	</div>
	<%}%>
	}


</body>
</html>