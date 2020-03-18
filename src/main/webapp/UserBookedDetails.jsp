<%@page import="com.chainsys.movieapp.model.TicketBooking"%>
<%@page import="com.chainsys.movieapp.dao.impl.TicketBookingDAOImpl"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>


<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking History</title>



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

	<form action="#">
		<h1
			style="color: white; font-size: 25px; font-family: courier; text-align: centre;">Booking
			History</h1>
		<%
			TicketBookingDAOImpl impl = new TicketBookingDAOImpl();
			List<TicketBooking> list = (List<TicketBooking>) request.getAttribute("UserBookedDetails");
		%>
		<table border="1">
			<thead>
				<tr>
					<th><h1
							style="color: red; font-size: 25px; font-family: courier; text-align: centre;">User
							Id</h1></th>
					<th><h1
							style="color: red; font-size: 25px; font-family: courier; text-align: centre;">Booked
							Id</h1></th>
					<th><h1
							style="color: red; font-size: 25px; font-family: courier; text-align: centre;">Movie
							Theatre Id</h1></th>
					<th><h1
							style="color: red; font-size: 25px; font-family: courier; text-align: centre;">Number
							of seats</h1></th>
					<th><h1
							style="color: red; font-size: 25px; font-family: courier; text-align: centre;">Show
							Date</h1></th>
					<th><h1
							style="color: red; font-size: 25px; font-family: courier; text-align: centre;">Booked
							Date</h1></th>
					<th><h1
							style="color: red; font-size: 25px; font-family: courier; text-align: centre;">Amount</h1></th>
					<th><h1
							style="color: red; font-size: 25px; font-family: courier; text-align: centre;">Booked
							Status</h1></th>

				</tr>
			</thead>

			<%
				LocalDate d = LocalDate.now();
			
				for (TicketBooking B : list) {
			%>
			<tr>
				<td><h1
						style="color: white; font-size: 20px; font-family: courier; text-align: centre;"><%=B.getUserId()%></h1></td>
				<td><h1
						style="color: white; font-size: 20px; font-family: courier; text-align: centre;"><%=B.getBookedId()%></h1></td>
				<td><h1
						style="color: white; font-size: 20px; font-family: courier; text-align: centre;"><%=B.getMovieTheaterId()%></h1></td>
				<td><h1
						style="color: white; font-size: 20px; font-family: courier; text-align: centre;"><%=B.getBookedSeats()%></h1></td>
				<td><h1
						style="color: white; font-size: 20px; font-family: courier; text-align: centre;"><%=B.getShowDate()%></h1>
				<td><h1
						style="color: white; font-size: 20px; font-family: courier; text-align: centre;"><%=B.getBookedDate()%></h1></td>
				<td><h1
						style="color: white; font-size: 20px; font-family: courier; text-align: centre;"><%=B.getAmount()%></h1></td>
				<td><h1
						style="color: white; font-size: 20px; font-family: courier; text-align: centre;"><%=B.getPaymentStatus()%></h1></td>
				<%
					if (B.getPaymentStatus().equals("BOOKED")
								&& (B.getBookedDate().isAfter(d) || B.getBookedDate().isEqual(d))) {
				%>
				<td><a
					href="CancelTicketServlet?bookedId=<%=B.getBookedId()%>"
					class="btn btn-danger"> CANCEL </a></td>
				<%
					}
				%>
			</tr>
			<%
				}
			%>
		</table>
	</form>
</body>
</html>
