<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Edit Department</title>
</head>
<body>
	
	</div>
	<div class="container">
		<form:form modelAttribute="department" class="text-center">

		<div class="form-group">
			<label >Department Name:</label>
			<form:input path="departmentname" value="${department.departmentname}" class="form-control"/> 
  		</div>
  		
		<input type="submit" name="save" value="Save" />	
		</form:form>
	</div>
 </body>
</html>