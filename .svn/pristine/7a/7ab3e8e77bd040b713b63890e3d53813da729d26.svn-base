<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Review Applications</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style type="text/css">
body {
	.open {
    	display:block;
	}
</style>


</head>
<body>
	<div class="container">
		<div class="page-header">
			<p><a href="../applicationlist/${applications.applicant.userid}.html">Go Back</a> > List Of Applications	</p>
		</div>
	</div>
	<div class="container">
	<form:form modelAttribute="applications" class="text-center">
		
			
			<p><b> Department</b></p>
		
		
		<ul id="nav" class="nav nav-pills nav-stacked"> 
		 	<li>Applied Department: ${applications.department.departmentname}</li>	
		</ul>
		<br />
		
		<p><b>Program</b></p>
		
		<ul id="nav" class="nav nav-pills nav-stacked"> 
		 	<li>Applied Program: ${applications.program.programname}</li>	
		</ul>
		<br />
		
		<p><b>Term</b></p>
		<ul id="nav" class="nav nav-pills nav-stacked"> 
		 	<li>Applied Term: ${applications.term}</li>	
		</ul>
		<br />
		
		<p><b>Student's Information</b></p>
		<ul id="nav" class="nav nav-pills nav-stacked"> 
		 	<li> First Name : ${applications.student.firstname} </li>
		 	<li> Last Name : ${applications.student.lastname} </li>
		 	<li> Date Of Birth : <fmt:formatDate type="date" value="${applications.student.dob}"/></li>
		 	<li> <b>Campus Identification Number : ${applications.student.cin} </b></li>	
		 	<li> Email : ${applications.student.email} </li>
		 	<li> Gender : ${applications.student.gender} </li>
		 	<li> PhoneNo : ${applications.student.phoneno} </li>
		 	<li> Citizenship : ${applications.student.citizenship} </li>	
		</ul>
		<br />
		
		<p><b>Student's Educational Information</b></p>
		<ul id="nav" class="nav nav-pills nav-stacked"> 
		 
							<c:forEach items="${applications.student.educationalinfos}" var="degree">
								<li>${degree.degreename} from ${degree.collegeuniversity} from ${degree.periodofdegree}</li>
								<li> Major Field : ${degree.majorfield}</li>
							</c:forEach>
					
		</ul>
		<br />
		<p><b>Student's Academic Information</b></p>
		<ul id="nav" class="nav nav-pills nav-stacked">
				
			<li> GPA : ${applications.student.academicrecord.gpa} </li>
			<li> GRE : ${applications.student.academicrecord.grescore} </li>
			<li> TOEFL : ${applications.student.academicrecord.toeflscore} </li>
			<li> Transcript : <c:if test="${not empty applications.student.academicrecord.filename}"><a href="/gapp/users/student/download.html?filename=${applications.student.academicrecord.filename}">Download</a></c:if></li>
			
		</ul>	
		<p><b>Student's Additional Information</b></p>
		<ul id="nav" class="nav nav-pills nav-stacked"> 
		 
							<c:forEach items="${applications.customvalues}" var="custom">
								<li>Field Name: ${custom.customfield.fieldname}</li>
								<c:choose>
								<c:when test="${custom.customfield.fieldtype == 'File'}">
								<li> Field Value : <a href="/gapp/users/student/download.html?filename=${custom.value}">Download</a></li>
								</c:when>
								<c:otherwise>
								<li>Field Value :${custom.value}</li>
								</c:otherwise>
								</c:choose>
							</c:forEach>
					
		</ul>
		
		
				
	</form:form>	
	</div>
</body>
</html>