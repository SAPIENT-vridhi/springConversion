<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	function validateForm() {
		var x = document.forms["updatePassword"]["opwd"].value;
		if (x == "") {
			alert("Name must be filled out");
			return false;
		}
		var x = document.forms["updatePassword"]["pwd"].value;
		if (x == "") {
			alert("Name must be filled out");
			return false;
		}
		var x = document.forms["updatePassword"]["rpwd"].value;
		if (x == "") {
			alert("Name must be filled out");
			return false;
		}
	}
</script>
<title>Update Password</title>
</head>
<body>
	<form name="updatePassword" action="UpdatePasswordServlet"
		onsubmit="return validateForm()" method="post">
		<table border="1">


			<tr>
				<td>Enter old password:</td>
				<td><input type="text" name="opwd"></td>
			</tr>
			<tr>
				<td>Enter New Password:</td>
				<td><input type="text" name="pwd"></td>
			</tr>
			<tr>
				<td>Enter Retype New Password:</td>
				<td><input type="text" name="rpwd"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="Submit"></td>
			</tr>

		</table>
	</form>
</body>
</html>