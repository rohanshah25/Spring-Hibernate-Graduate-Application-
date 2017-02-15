<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Department</title>
</head>
<body>
<h2>List of Departments</h2>

<div class="container">
		<div class="page-header">
			<p><a href="./${user.userid}/adminhome.html">Go Back</a> > Admin Home
				<form action="<c:url value='../logout.html' />" method="POST"><input name="submit" type="submit" value="Logout"/></form>
			</p>
		</div>
</div>

<div class ="container">
<c:if test="${!empty listDepartment}">

	<table border = "1">
		<thead align="center">
			<tr>
	    		<th style="width:10%" align="center">Department ID</th>
				<th style="width:10%" align="center">Department Name</th>
				<th style="width:10%" align="center">Programs Offered</th>
				<th style="width:10%" align="center">Details</th>
				
			</tr>	
		</thead>
	<tbody>		
		  <c:forEach items="${listDepartment}" var="department">
   <tr>
		<td align="center">${department.departmentid}</td>
		<td align="center">${department.departmentname}</td> 
		<td align="center">${department.programs.size()}</td>	
		<td align="center">
				<a href="view/${department.departmentid}.html">View</a>
		</td>	
		
			
		 
   </tr>
		  </c:forEach>
		</tbody>
      </table>
    </c:if>
    <br/>
    <div class="container">
    	<h2>You can Add Departments, Programs and Additional Requirements</h2>	
    		<ul>	
    			<li><a href="adddepartment.html">Add Department</a></li>
    			<li><a href="addprogram.html">Add Program</a></li>
    			<li><a href="addadditional.html">Add Additional Requirements</a></li>
    		</ul>	
    </div>
    
   
   </div>	
  </body>
</html>