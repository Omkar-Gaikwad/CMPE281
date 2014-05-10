<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Market Place Login</title>
<script type="text/javascript">
function submitForm(form){
	var toSubmit = true;
	if(form.emailAddress.value == ""){
		alert("Email cannot be blank!!");
		toSubmit = false;
		form.emailAddress.focus();
	}
	if(form.password.value == ""){
		alert("Password cannot be blank!!");
		toSubmit = false;
		form.password.focus();
	}
	if(toSubmit) {
	var url = "loginUser";
	form.action = url; 
	form.submit();
	}
}
</script>
</head>
<body>
<div align="center">
<br><br><br><br><br><br><br>
	<form action="loginUser" method="post" name="loginForm" id="loginForm">
	<h2>LOGIN TO MARKET</h2>
		<table>
			<tr align="center"> 
				<td style="padding-bottom: 10%;">Enter Email Address </td>
				<td style="padding-left: 10%;padding-bottom: 10%;"><input type="text" name="emailAddress" id="emailAddress" maxlength="30" size="40%"/> </td>
			</tr>
			<tr align="center"> 
				<td style="padding-bottom: 10%;">Enter Password </td>
				<td style="padding-left: 10%;padding-bottom: 10%;"><input type="password" name="password" id="password" maxlength="20" size="40%"/> </td>
			</tr>
			<tr align="center"> 
				<td colspan="2" style="padding-left: 10%;"><input type="button" name="inputButton" value="Login" onclick="javascript:submitForm(this.form)"/> </td>
			</tr>
			<tr align="center"> 
				<td colspan="2" style="padding-left: 10%;"><a href="RegisterNewUser.jsp">Sign up?</a> </td>
			</tr>
			
		</table>
	</form>
</div>
</body>
</html>