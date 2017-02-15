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
<center><h2>View Details of Departments</h2></center>

<div class="container">
		<div class="page-header">
			<p><a href="../list.html">Go Back</a> > List Of Departments	
			</p>
		</div>
</div>

<div class ="container">

	<form:form modelAttribute="department" class="text-center">
	<table border = "1">
		<thead align="center">
			<tr>
	    		<th style="width:10%" align="center">Department ID</th>
	    	</tr>
	    </thead>
	    <tbody>
	    <tr>
	    	<td align="center">${department.departmentid}</td>
	    </tr>	
	    </tbody>
	 </table>
	 <br />
	<table border = "1">
		<thead align="center">	
		  	<tr>	
				<th style="width:10%" align="center">Department Name</th>
				<th style="width:10%" align="center">Edit</th>
	    		
	    	</tr>
	    </thead>
	    <tbody>	
	    	<tr>
	    			
				<td align="center">${department.departmentname}</td> 
	    		<td align ="center" ><a href="/gapp/users/admin/editdepartment/${department.departmentid}.html">Edit Department Name</a></td>
	    		
	    		
	   		 </tr>
	    </tbody>
	    	
	  </table>
	 <br /> 
	<table border = "1">
		<thead >	
		  <tr>	
				<th style="width:10%" align="center">Program Name</th>
				<th style="width:10%" align="center">Edit</th>
	    		<th style="width:10%" align="center">Remove</th>
	     </tr>
	     </thead>
	     <tbody>
	     <tr>
	     		<td>
	     		<c:forEach items="${department.programs}" var="program">
					 	<li>	 ${program.programname}</li>
				
				</c:forEach>
				</td>
				<td>
				<c:forEach items="${department.programs}" var="program">
				<li><a href="/gapp/users/admin/editprogram/${department.departmentid}/${program.programid}.html">Edit Program Name</a></li>
				</c:forEach>
				</td>
				<td>
				<c:forEach items="${department.programs}" var="program">
				<li><a href="/gapp/users/admin/removeProg/${department.departmentid}/${program.programid}.html">Remove Program Name</a></li>		
	    		 </c:forEach>
	    		</td>
		 </tr>	
		 </tbody>
	  	
	 </table>	
	 
	 <br />
	 <table border = "1">
		 <thead align="center">	
		 	<tr>	
				<th style="width:10%" align="center">Programs Offered</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td align="center">${department.programs.size()}</td>
			</tr>
		</tbody>	
	  </table>		
	  
	  <br />
	  
	  <table border = "1">
		<thead align="center">	
		 	<tr>	
	  	
				<th style="width:10%" align="center">Additional Requirements</th>
				<th style="width:10%" align="center">Edit</th>
	    		<th style="width:10%" align="center">Remove</th>		
			</tr>
		</thead>
		<tbody>	
			<tr>
					<td align="center">
						<c:forEach items="${department.customfield}" var="customdata">
							<li> ${customdata.fieldname} </li>
							<li> ${customdata.fieldtype} </li> 
							<li> ${customdata.required} </li>
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${department.customfield}" var="customdata">
						<li><a href="/gapp/users/admin/editadditional/${department.departmentid}/${customdata.controlid}.html">Edit Additional Requirements</a></li>
					</c:forEach>
					</td>	
					<td>
					<c:forEach items="${department.customfield}" var="customdata">
	    				<li><a href="/gapp/users/admin/removeCust/${department.departmentid}/${customdata.controlid}.html">Remove Additional Requirements</a></li>
	    				
	    				</c:forEach>
	    				</td>
			</tr>
			
	</tbody>		

      </table>
    </form:form>
   </div>	
  </body>
</html>