<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Student Application</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</head>
<body>


<div class="container">
		<div class="page-header">
			<p><b>Hello Applicant, ${user.firstName} </b></p>
		
		
		<div align="right">
					<a href="/gapp/logout.html"><button type="submit" name="submit" class="btn btn-success">Logout</button></a>
					
		<%-- 		<form action="<c:url value='../logout.html' />" method="POST"><input name="submit" type="submit" value="Logout"/></form> --%>
		</div>
	</div>	
</div>
<br/>
<br/>


<div class ="container">
<c:if test="${!empty listapplication}">

	<table border = "1">
		<thead align="center">
			<tr>
  	    		<th style="width:10%" align="center">Application Date</th>  
				<th style="width:10%" align="center">Department Name</th>
				<th style="width:10%" align="center">Program Name</th>
				<th style="width:10%" align="center">Term</th>
				<th style="width:10%" align="center">Status</th>
				<th style="width:10%" align="center">View Application</th>
				<th style="width:10%" align="center">Edit Application</th>
			</tr>	
		</thead>
	<tbody>		
		  <c:forEach items="${listapplication}" var="application">
   <tr>
    	<td align="center">${application.status[0].timestamp}</td> 
		<td align="center">${application.department.departmentname}</td> 
		<td align="center">${application.program.programname}</td>
		<td align="center">${application.term}</td>	
		<td align="center">${application.status[0].status} </td>	
		<td align="center">
				<a href="../applicationview/${application.applicationid}.html">View</a>
		</td>
		<td align="center">
		<c:if test="${application.status[0].status ne 'Submitted'}">
				<a href="/gapp/users/student/editnewapplication/${user.userid}/${application.applicationid}.html">Edit</a>
		</c:if>		
		</td>
		
		
   </tr>
		  </c:forEach>
		</tbody>
      </table>
    </c:if>
    <br/>
    
   <br/>
   
   
   
    <div class="container">
    	<h2>You can start new application</h2>	
    		<ul>	
    			<li><b><a href="../newapplication/${user.userid}.html">New Application</a></b></li>
    		</ul>	
    </div>
   
   
   </div>
   
  </body>
</html>