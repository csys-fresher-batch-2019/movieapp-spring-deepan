
<%
Integer userId = (Integer)session.getAttribute("USER_ID");
%>

<nav class="navbar navbar-expand-sm bg-dark">
	<a class="navbar-brand" href="index.jsp">BookYourShows</a>
	<!-- Links -->
		<ul class="navbar-nav ml-auto">

		<% if ( userId == null){ %>
		<li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a>
		</li>
		<li class="nav-item"><a class="nav-link"
			href="UserRegistration.jsp">Register</a></li>
		<%}else {%>
		<li class="nav-item"><a class="nav-link"
			href="UserBookedDetailsServlet">Welcome <%=userId %> !!!
		</a></li>
		<li class="nav-item"><a class="nav-link" href="LogoutServ">Logout</a>
		</li>
		<% } %>
		
		<li class="nav-item"><a class="nav-link" href="AddMovies.jsp">Admin</a>
		</li>
		
	</ul>

</nav>
