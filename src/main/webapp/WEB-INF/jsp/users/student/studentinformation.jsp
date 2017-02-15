<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Student Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="page-header">
				<%-- <p><a href="../newapplication/${user.userid}.html">Go Back</a> > New Application </p> --%>
				<%-- <a href="/gapp/users/student/submitapplication/${user.userid}/${application.applicationid}.html"><button type="submit" value="submit" class="btn btn-success">Submit Application</button></a> --%>
				
					<center><h4 style="color:black;"><b>Student Information</b></h4></center>
		</div>

	
	</div>		
	<br/>
	<br/>
				

		<div class="container">
		<form:form modelAttribute="student">
			
			
		
		<div class="form-group">
				<label class="control-label col-sm-2" >FirstName:</label>
				<div class="col-sm-3">
					<form:input path="firstname"  class="form-control"/>
				</div>
		</div>	
			
		<br/>
		<br/>
		
				<div class="form-group">
						<label class="control-label col-sm-2" >LastName:</label>
								<div class="col-sm-3">
									<form:input path="lastname"  class="form-control"/>
								</div>
		
				</div>	
		<br/>
		<br/>
		
				<div class="form-group">
						<label class="control-label col-sm-2" >Email:</label>
								<div class="col-sm-3">
									<form:input type="email" path="email"  class="form-control"/>
								</div>
		
				</div>	
		<br/>
		<br/>
		 
				 <div class="form-group">
						<label class="control-label col-sm-2" >Date Of Birth:</label><h7 style="color:grey;">eg.25-2-1989,20-11-1989</h7>
								<div class="col-sm-3">
									<form:input type="text" path="dob" class="form-control" />
								</div>
				</div> 	 
		<br/>
		<br/>
		
				<div class="form-group">
						<label class="control-label col-sm-2" >CIN:</label>
								<div class="col-sm-3">
									<form:input type="number" path="cin"  class="form-control"/>
								</div>
		
				</div>	
		<br/>
		<br/>
		
				<div class="form-group">
						<label class="control-label col-sm-2" >Gender:</label>
								<div class="col-sm-3">
									<form:input type="text" path="gender"  class="form-control"/>		
								</div>
		
				</div>	
		<br/>
		<br/>
				<div class="form-group">
						<label class="control-label col-sm-2" >Phone no:</label>
								<div class="col-sm-3">
									<form:input type="number" path="phoneno"  class="form-control"/>
								</div>
		
				</div>	
		<br/>
		<br/>
		<div class="form-group">
						<label class="control-label col-sm-2" >Citizenship:</label>
								<div class="col-sm-3">
									<form:input type="text" path="citizenship"  class="form-control"/>
								</div>
		
				</div>	
		<br/>
		<br/>	
		
		<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" name= "submit" value="save" class="btn btn-success">Save and Continue</button>
						
					</div>
				</div>		
			</form:form>
		</div>
		
	</body>
</html>	