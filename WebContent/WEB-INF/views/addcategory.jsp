<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	function validateForm() {
		var x = document.forms["addCategory"]["cname"].value;
		if (x == "") {
			alert("Category can not be empty");
			return false;
		}
		if (isNaN(x)) {
			alert("Category should be a number");
			return false;
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
    <form:form action="./Testingadmin" method="post" onsubmit="return validateForm()" style="text-align: center;">
	<form:label path="CategoryName">Enter category name</form:label>
	<form:input path="CategoryName"/><br> <br>
	
		
		
		<table border="1">
			<tr>
				<td>Enter Category Name:</td>
				<td><input type="text" name="cname"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" name="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>