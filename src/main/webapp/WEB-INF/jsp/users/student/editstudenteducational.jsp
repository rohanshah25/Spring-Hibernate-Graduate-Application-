<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Student Educational Records</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="page-header">
				<%-- <p><a href="../newapplication/${user.userid}.html">Go Back</a> > New Application </p> --%>
				<center><h4 style="color:black;"><b>Student Educational Records</b></h4></center>
		</div>

	</div>
	
	
	<br/>
	<br/>
				

		<div class="container">
			<form:form modelAttribute="educationalinfo">
			
		<br/>
		<br/>
		<div class="form-group">
						<label class="control-label col-sm-2" >College/University:</label>
								<div class="col-sm-3">
									<form:input type="text" path="collegeuniversity" value="${educationalinfo.collegeuniversity}" class="form-control"/>
								</div>
		
		</div>	
		
		
		<br/>
		<br/>
		<div class="form-group">
						<label class="control-label col-sm-2" >Degree Name:</label>
								<div class="col-sm-3">
									<form:input type="text" path="degreename" value="${educationalinfo.degreename}" class="form-control"/>
								</div>
		
		</div>	
		
		</br>
		<br/>
		<div class="form-group">
						<label class="control-label col-sm-2" >Major Field:</label>
								<div class="col-sm-3">
									<form:input type="text" path="majorfield" value="${educationalinfo.majorfield}" class="form-control"/>
								</div>
		
		</div>	
		
		
		<br/>
		<br/>
		
				<div class="form-group">
						<label class="control-label col-sm-2" >Degree Period:</label><h7 style="color:grey;">eg.2011-2015</h7>
								<div class="col-sm-3">
										<form:input type="text" path="periodofdegree" value="${educationalinfo.periodofdegree}" class="form-control"/>
								</div>
				</div>	
		
		<br/>
		<br/>
		<br/>
				
		<div class="form-group" align="left">
					<div class="col-sm-offset-2 col-sm-10">
					
						<button type="submit" class="btn btn-success">Add Degree</button>&nbsp;&nbsp;
						<!-- <a href="#"><button type="submit" class="btn btn-success">Add Another Degree</button> </a> -->
					</div>
				</div>	
			 </form:form>
		</div>	 	
					
		<br/>
		<br/>
		<div class="container">
				
				<center><h4 style="color:black;"><b>Educational Info List</b></h4></center>
		</div>
		<div class ="container">

			
			
		<%-- <c:if test="${!empty listEducationalinfo}"> --%>
		<table border = "1">
		
			<tr align="center">
	    		<th style="width:10%" align="center">College/University</th>
	    		<th style="width:10%" align="center">Degree Name</th>
	    		<th style="width:10%" align="center">Major Field</th>
	    		<th style="width:10%" align="center">Period Of Degree</th>
	    		
	    		<th style="width:10%" align="center">Remove</th>
	    		
	    		
	    	</tr>
	    <c:forEach  items="${listEducationalinfo}" var="educationalinfo">
	    	<tr>
					<td align="center">${educationalinfo.collegeuniversity}</td>
					<td align="center">${educationalinfo.degreename}</td>
					<td align="center">${educationalinfo.majorfield}</td>
					<td align="center">${educationalinfo.periodofdegree}</td>
					
					<%-- <td align="center"><a href="/gapp/users/student/educationalinfo/edit/${user.userid}/${student.studentid}/${educationalinfo.educationalid}.html" />Edit</a></td> --%>
					<td align="center"><a href="/gapp/users/student/educationaleditinfo/remove/${user.userid}/${application.applicationid}/${student.studentid}/${educationalinfo.educationalid}.html"/>Remove</a></td>
				</tr>
	   		</c:forEach>
	   
	 	</table>
	<%-- </c:if>
	 --%>
	 
	 </div>	
	 <br/>
	 <br/>
	 <br/>
	 <div class="form-group">
					<div class="col-sm-offset-2 col-sm-10" align="center">
					
					<a href="/gapp/users/student/submitapplication/${user.userid}/${application.applicationid}.html"><button type="submit" class="btn btn-success">Submit Application</button></a>&nbsp;&nbsp;
					<a href="/gapp/users/student/saveapplication/${user.userid}/${application.applicationid}.html"><button type="submit" class="btn btn-success">Save Application</button> </a> 
					</div>
		</div>	
	 
	 
</body>
</html>		