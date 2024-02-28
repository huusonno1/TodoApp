<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Register</title>
		<link rel="stylesheet"
				href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
				integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
				crossorigin="anonymous">
	</head>
	<body>
		<jsp:include page="../common/header.jsp"></jsp:include>
		
		<div class="container">
			
			<h2>User Register Form</h2>
			<div class="col-md-6 col-md-offset-3">
				<div class="alert alert-success center" role="alert">
					<p>${NOTIFICATION}</p>
				</div>
				
				<form action="<%=request.getContextPath()%>/register" method = "post" >
					<div class = "form-group">
						<label for="firstName">First Name:</label>
						<input type="text" class="form-control" id="firstName" placeholder="First Name" 
						name="firstName" required />
					</div>
					
					<div class = "form-group">
						<label for="lastName">Last Name:</label>
						<input type="text" class="form-control" id="lastName" placeholder="Last Name" 
						name="lastName" required />
					</div>
					
					<div class = "form-group">
						<label for="username">Username:</label>
						<input type="text" class="form-control" id="username" placeholder="User Name" 
						name="username" required />
					</div>
					
					<div class = "form-group">
						<label for="password">Password:</label>
						<input type="password" class="form-control" id="password" placeholder="Password" 
						name="password" required />
					</div>
					
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			
			</div>
			
		</div>
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</body>
</html>