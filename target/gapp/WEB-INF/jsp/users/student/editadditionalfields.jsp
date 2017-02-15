<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Additional Requirements</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="page-header">
				<center><h4 style="color:black;"><b>Edit Additional Requirements</b></h4></center>
		</div>
	</div>	
		<div class="container">
		<form:form modelAttribute="application">
		
		
		<c:forEach items="${application.customvalues}" var="customvalue" varStatus="iterator">
				<c:if test="${customvalue.customfield.fieldtype != 'File'}">
				
					<label class="control-label col-sm-2" >${customvalue.customfield.fieldname}</label>	
				<div class="col-sm-3">
					<form:input path="customvalues[${iterator.index}].value"  class="form-control"/>
				</div>
				</c:if>		
			</c:forEach>
				<br/>
				<br/>
				<br/>
					
		<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
					
						<button type="submit" name= "submit" value="save" class="btn btn-success">Continue for FileUpload</button>
						
					</div>
				</div>
			
		
			</form:form>
		</div>
	</body>
</html>		