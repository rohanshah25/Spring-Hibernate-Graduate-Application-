<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Registration</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<p><a href="/gapp/home.html">Home</a> > Registration</p>
	</div>
	</div>
	<div class="container">
		<form:form modelAttribute="user" class="text-center">
		<div class="form-group">
			<label >First Name:</label>
			<form:input path="firstName" class="form-control"/> <form:errors path="firstName" />
  		</div>
  		<div class="form-group">
			<label>Last Name:</label>
			<form:input path="lastName" class="form-control"/> <form:errors path="lastName" />
  		</div>
  		<div class="form-group">
			<label> Email:</label>
			<form:input path="email" class="form-control"/> <form:errors path="email" />
  		</div>	
		<div class="form-group">
			<label >Password:</label>
			<form:input path="password" class="form-control" type="password"/> <form:errors path="password" />
  		</div>
  		
		<input type="submit" name="add" value="Register" onClick="msg()"/>	
		</form:form>
	</div>
	<script>
		function msg() {
   			 alert("SuccessFully Registered");
}
</script>
	
 </body>
</html>