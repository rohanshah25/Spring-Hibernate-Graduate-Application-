<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transcript Upload</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>


	<div class="container">
		<div class="page-header">
			<p>Edit Your Transcript</p>
		</div>
	</div>

		<div class="form-group">
				
		<form  method="POST" action="/gapp/users/student/edittranscript/${user.userid}/${application.applicationid}/${student.studentid}.html" enctype="multipart/form-data">
				
					<label for="transcript" class="control-label col-sm-2" >Transcript:</label>
							<div class="col-sm-3">
									<input  type="file" name="transcript" class="form-control"/>
							</div>
			
			<br/>
			<br/>
			<br/>
			
			<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" name="upload" class="btn btn-success">Upload and Continue</button>
					</div>
				</div>					
							
		</form>
		</div>
	</body>
</html>			