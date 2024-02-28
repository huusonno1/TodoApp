<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet"
					href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
					integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
					crossorigin="anonymous">
	</head>
	<body>
	
		<jsp:include page="../common/header.jsp"></jsp:include>
		<div class="container col-md-6 col-md-offset-3" style="overflow: auto">
			<h1>Login Form</h1>
			<form action="<%=request.getContextPath()%>/login" method="post">
	
				<div class="form-group">
					<label for="uname">User Name:</label> <input type="text"
						class="form-control" id="username" placeholder="User Name"
						name="username" required>
				</div>
	
				<div class="form-group">
					<label for="uname">Password:</label> <input type="password"
						class="form-control" id="password" placeholder="Password"
						name="password" required>
				</div>
	
	
				<button type="submit" class="btn btn-primary mt-2">Submit</button>
			</form>
			
			
		</div>
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</body>
</html>