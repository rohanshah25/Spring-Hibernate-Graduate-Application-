<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>New Application</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="page-header">
				<p><a href="/gapp/users/student/applicationlist/${user.userid}.html">Go Back</a> > List Of Applications </p>
		</div>



		<div class="container">
				
				<center><h4 style="color:black;"><b>Apply Program</b></h4></center>
		</div>

	</div>		
	<br/>
	<br/>
				

		<div class="container">
			<form:form modelAttribute="application">
			
		
		
		<div class="form-group">
			<label class="control-label col-sm-2"> Department Name: </label>
				<div class="col-sm-3">
				 <select id="departmentname" name="departmentname" onchange="loadProgram()" class="form-control" >
				 

								<c:forEach items="${departmentlist}" var="department">">
                         				<option value="${department.departmentid}">${department.departmentname}</option>
								</c:forEach>
						
				 </select> 
			</div>	 
		</div>
		
		<br/>
		<br/>
		<br/>
		
		<div class="form-group">
			<label class="control-label col-sm-2"> Program Name: </label>
			<div class="col-sm-3">
				 <select id="programname"  name="programname" class="form-control">
					<!--  <option value="">Select Program</option> --> 
				</select>	
			</div>	
		</div>
		
		<br/>
		<br/>
		<br/>
		
		<div class="form-group">
				<label class="control-label col-sm-2" for="term">Term:</label><h7 style="color:grey;">eg.Fall-2016,Spring-2016</h7>
				<div class="col-sm-3">
					<form:input path="term" value="${application.term}" class="form-control"/>
				</div>
		</div>	
			<br/>
			<br/>
			
		<%-- <div class="container">
					
					<center><h4 style="color:black;"><b>Student Information</b></h4></center>
		
		</div> --%>
		
		
				
	
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Save and Continue</button>
					</div>
				</div>		
			</form:form>
		</div>
		
		
	</body>
<script	
src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
	var isLoad=true;
	var selected=${application.program.programid==null?0:application.program.programid};
	function loadProgram() {
		$.ajax({
			type : "Get",
			url : "/gapp/users/student/newapplication/${user.userid}/loadProgram.html",
			data : {
				deptid : $('#departmentname').val(),
			},
			success : function(response) {
				var data = JSON.parse(response);
				var $select = $('#programname');
				$select.find('option').remove();
				$.each(data.programlist, function(key, value) {
					$select.append('<option value=' + value.programid + '>'
							+ value.programname + '</option>');
				});
				if(selected>0){
					if(isLoad){
						$select.val(selected);
						isLoad=false;	
					}
				}
			},
			error : function(e) {
				console.log('Error: ' + e);
			}
		});

	}
	
$(document).ready(function() {
		loadProgram();
	})	
</script>
</html>