<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Movies</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<style>
body {
	background-image: url('assets/images/blacky.jpeg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
<body>

	<form action="AddMovieServlet">
		<div style="text-align: centre">
			<pre>
<br></br>
<h1
					style="color: white; font-size: 30px; font-family: courier; text-align: centre;">                                ADD MOVIES</h1>

<p
					style="color: white; font-size: 20px; font-family: courier; text-align: center;">Movie Name      <input
						type="text" name="Moviename" required autofocus />

				
				<p
					style="color: white; font-size: 20px; font-family: courier; text-align: center;">Movie Type      <select
						name="MovieType">
                     <option value="comedy">comedy</option>
                     <option value="horror">horror	</option>
                     <option value="action">action </option>
                     <option value="Hindi">historical</option>
                     <option value="Romance">Romance </option>
                     </select>

				
				<p
					style="color: white; font-size: 20px; font-family: courier; text-align: center;">Movie Language  <select
						name="Language">
                     <option value="Tamil">Tamil</option>
                     <option value="Malayalam">Malayalam</option>
                     <option value="English">English </option>
                     <option value="Hindi">Hindi</option>
                     <option value="Telugu">Telugu </option>
                     </select>               

				
				<p
					style="color: white; font-size: 20px; font-family: courier; text-align: center;">Movie Rating    <select
						name="Rating">
                     <option value="5">5</option>
                     <option value="4">4</option>
                     <option value="3">3</option>
                     <option value="2">2</option>
                     <option value="1">1</option>
                     </select>        

				
				<p
					style="color: white; font-size: 20px; font-family: courier; text-align: center;">Movie Duration  <input
						type="text" name="duration" required />                           

				
				<p
					style="color: white; font-size: 20px; font-family: courier; text-align: center;">Released Date   <input
						type="date" id="Releaseddate" name="releaseddate" required />  

				
				<p
					style="color: white; font-size: 20px; font-family: courier; text-align: center;">Movie Image     <input
						type="file" name="image" required />         

			
			</pre>
			<p
				style="color: white; font-size: 20px; font-family: courier; text-align: center;">
				<a href="HomeMovies"><button type="submit">Add</button></a>> <br></br>
		</div>
		<br /> <br />

	</form>
</body>
</html>
