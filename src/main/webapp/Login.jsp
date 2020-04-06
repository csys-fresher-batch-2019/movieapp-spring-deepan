<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">

<style>
body {
	background-image: url('assets/images/backgroundlogin.jpg');
	background-attachment: fixed;
	background-repeat: no-repeat;
	background-size: 100% 100%;
}

body::before {
	background-color: rgba(0, 0, 0, 0.37);
	content: '';
	display: block;
	height: 100%;
	position: absolute;
	width: 100%;
	z-index: -1;
}

.middle {
	width: 445px;
	height: 395px;
	background-color: rgba(0, 0, 0, 0.5);
	margin-top: 125px;
	margin-left: 325px;
	border-radius: 12px;
	padding: 56px;
}

#password {
	padding-right: 29px;
}

#eye {
	font-size: 125%;
	cursor: pointer;
	postion: absolute;
	float: right;
	margin-top: -31px;
	margin-right: 12px;
}
</style>
</head>
<body>
		<form action="Login" autocomplete="off">

	<jsp:include page="header.jsp"></jsp:include>
	<div style="position: relative; left: 700px;">
		<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<middle><font color='white' size='5'>" + errorMessage + "</font></middle>");
}
		%>
		</div>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->


	<div class="container">

		<div class="middle">
			<div class="col-md-12">

				<form method="post" action="Login" role="login">
					<p style="color: white;">E-mail</p>
					<input type="email" name="EmailId" placeholder="Email Id" required
						class="form-control input-lg" value="" /><br>
					<p style="color: white;">Password</p>
					<input type="password" name="Password"
						class="form-control input-lg" id="password" placeholder="Password"
						required="" /> <span id="eye" style="display: none"
						data-click-state="1" class="glyphicon glyphicon-eye-open"></span>

					<div class="process" style="display: none">
						<p> </p>
						<div class="progress">
							<div id="bar"
								class="progress-bar progress-bar-danger progress-bar-striped active"
								style="width: 10%;"></div>
						</div>
					</div>

					<br>
					<br>
					<button type="submit" name="go"
						class="btn btn-lg btn-primary btn-block">Sign in</button>

					<br /> &emsp;&emsp;&emsp;&emsp;&nbsp;&emsp;&emsp;&emsp;<a
					
					
						href="ResetPassword.jsp">Forgot Password</a> <br />
						
						
					<br />


				</form>


			</div>

		</div>

		
		</div>
			</form>
</body>
</html>