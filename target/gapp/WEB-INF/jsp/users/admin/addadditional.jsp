<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Add Additional Requirements</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<p><a href="./list.html">Go Back</a> >List Of Departments</p>
		</div>
	</div>	
	
	<div class="container">
	
		<form:form modelAttribute="additional" class="text-center">
		
			<form:input path="controlid" readonly="true" size="8" disabled="true"
				cssStyle="display:none" />
			<form:hidden path="controlid" />
		
		<table border = 1>
			<tr>
				<td>Field Name</td>
				<td><form:input path="fieldname" /></td>
			</tr>
			<tr>
				<td>Field Type</td>
				<td><form:select path="fieldtype" >
					<form:option value="Text"></form:option>
					<form:option value="Number"></form:option>
					<form:option value="File"></form:option>
				</form:select></td>
			</tr>
			<tr>
				<td>Required</td>
				<td><form:checkbox path="required"/>
				</td>
			</tr>
			<tr>
				<td>Department</td>
				<td><form:select path="department.departmentid">
						
							<c:forEach items="${addi}" var="department">">
                         <form:option value="${department.departmentid}">${department.departmentname}</form:option>
							</c:forEach>
						
					</form:select></td>
			 </tr>
		</table>	 
			 
			
		 
				<input type="submit" name="customdata" value="Add Additional Requirements" />	

			</form:form>
		
		</div>
	
	
</body>
</html>