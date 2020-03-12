<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="reg.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	background: rgba(0, 0, 0, 0.5);
}

.main-reg {
	background: rgba(0, 0, 0, 0.7);
	width: 100%;
	max-width: 500px;
	margin: 0 auto;
	padding: 20px;
	border-radius: 4px;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
}

.main-reg .form-heading {
	font-size: 25px;
	color: #fff;
	font-weight: 600;
	text-align: center;
	padding: 5px 0px;
	border-bottom: solid 1px #847E78;
}

.form-reg {
	justify-content: center;
	width: 100%;
	display: flex;
}

.form-group {
	margin: 10px 0px;
	justify-content: center;
}

.form-label {
	width: 100%;
	max-width: 150px;
	min-width: 150px;
	color: #fff;
	padding: 10px 0px;
}

.form-input input {
	padding: 10px 5px;
	border-radius: 4px;
	border: none;
	outline: none;
	width: 250px;
	color: #Black;
}

.form-input select {
	width: 263px;
	border-radius: 4px;
	border: none;
	padding: 10px 5px;
}

.form-group textarea {
	height: 40px;
	width: 250px;
	resize: none;
	padding: 10px 5px;
	border-radius: 4px;
}

.form-group {
	display: flex;
}

.radio-label {
	display: flex;
}

.form-radio {
	color: #ffffff;
	padding: 10px 0px;
	width: 262px;
}

.form-radio input[type="radio"] {
	padding: 0px 5px;
	display: inline;
	margin: 0px 2px;
}

.form-reg form {
	margin-top: 20px;
	width: 100%;
}

.bottom-footer {
	border-top: 1px solid #847E78;
	text-align: center;
	padding: 10px 0px;
}

button[type="reset"] {
	background: #204d74;
	border: none;
	border-radius: 4px;
	padding: 8px 15px;
	color: #fff;
	margin-right: 5px;
	cursor: pointer;
}

button[type="submit"] {
	background: #398439;
	border: none;
	border-radius: 4px;
	padding: 8px 5px;
	color: #fff;
	cursor: pointer;
}
</style>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="main-reg">
		<div class="form-heading">Registration</div>
<%String errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage !=null)
{%>
<center>
<font color="red"style="font: bold" >





 <%=errorMessage%></font></center>
<%}%>
		<div class="form-reg">

			<form action="Registration" autocomplete="off">

				<div class="form-group">
					<div class="form-label">User Name :-</div>
					<div class="form-input">
						<input type="text" name="Name" required autofocus>
					</div>
				</div>

				<div class="form-group">
					<div class="form-label">Gender :-</div>
					<div class="form-radio">

						<input type="radio" name="gender" value="male" checked>
						Male <input type="radio" name="gender" value="female">
						Female

					</div>
				</div>



				<div class="form-group">
					<div class="form-label">Email Id :-</div>
					<div class="form-input">
						<input type="text" name="EmailId" id="firstname" required>
					</div>
				</div>


				<div class="form-group">
					<div class="form-label">Mobile Number:-</div>
					<div class="form-input">
						<input type="tel" name="MobileNumber" pattern="[0-9]{10}" required>
					</div>
				</div>


				<div class="form-group">
					<div class="form-label">Password :-</div>
					<div class="form-input">
						<input type="Password" name="Password" minlength="8" required/>
					</div>
				</div>




				<div class="bottom-footer">
					<a href="login.jsp"><button type="submit">Submit</button> </a>
				</div>
			</form>

		</div>
	</div>
</body>
</html>