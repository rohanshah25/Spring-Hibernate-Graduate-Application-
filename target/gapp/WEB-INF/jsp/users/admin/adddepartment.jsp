<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Add Department</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<p><a href="./list.html">Go Back</a> >List Of Departments</p>
	</div>
	</div>
	<div class="container">
		<form:form modelAttribute="department" class="text-center">
		<c:if test="${!empty department.departmentname}">
									<form:input path="departmentid" readonly="true" size="8"
										disabled="true"/>
									<form:hidden path="departmentid" />
		</c:if>
		<div class="form-group">
			<label >Department Name:</label>
			<form:input path="departmentname" class="form-control"/> 
  		</div>
  		
		<input type="submit" name="department" value="Add Department" />	
		</form:form>
	</div>
 </body>
</html>