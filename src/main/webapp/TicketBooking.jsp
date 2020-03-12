<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>

<body>


	<%
		String movieTheatreId = request.getParameter("movieTheatreId");
		HttpSession ses = request.getSession(false);
		Integer userId = (Integer) ses.getAttribute("USER_ID");
		Integer totalAmount = (Integer) ses.getAttribute("tot_amt");

		LocalDate today = LocalDate.now();
		
		if (userId == null) {
			response.sendRedirect("Login.jsp");

		}
	%>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">
		<br />
		<h3>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Ticket
			Booking</h3>
			
		<form action="BookingTicket" action="get">
		
			<input type="hidden" name="userid" placeholder="Enter the User id"
				value="<%=userId%>" readonly required /> <br />
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Movie
			Theatre Id: <input type="text" name="Movietheatreid"
				placeholder="Enter the Movie Theatre Id"
				value="<%=movieTheatreId%>" readonly required /> <br />
			<br />
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Number
			of Seats: <input type="number" name="numberofseats"
				placeholder="number of seats" value="1" required /> <br />
			<br />
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			Enter the date : <input type="date" id="showdate" name="showdate"
				placeholder="Enter the date" required /> <br />
			<div class="form-group">
				<label class="col-md-4 control-label" for="button1id"> </label>
				<div class="col-md-8">
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<button id="button1id" name="button1id" class="btn btn-success">Submit</button>
				</div>
			</div>


		</form>
	</div>
	<script>
		function setTodayDate() {
			var today = new Date();
			console.log(today);
			var dateStr = today.toJSON().substr(0, 10); //toJSON returns "2020-02-20T09:32:45.644Z" ( get only date)
			console.log(dateStr);
			$("#showdate").val(dateStr);
			$("#showdate").attr("min", dateStr);
		}
		setTodayDate();
	</script>
</body>
</html>