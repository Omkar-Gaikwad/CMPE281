<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registation</title>
<script type="text/javascript">
function submitForm(form){
	var toSubmit = true;
	if(form.fname.value == ""){
		alert("Enter first Name!!");
		form.fname.focus();
		toSubmit = false;
	} else if(form.lname.value == ""){
		alert("Enter last Name!!");
		form.lname.focus();
		toSubmit = false;
	} else if(form.emailAddress.value == ""){
		alert("Enter valid email Address!!");
		form.emailAddress.focus();
		toSubmit = false;
	} else if(form.password.value == ""){
		alert("Password firld cannot be blank!!");
		form.password.focus();
		toSubmit = false;
	}
	if(toSubmit) {
		var url = "registerNewUser";
		form.action = url; 
		form.submit();
	}
}
</script>
</head>
<body>
	<div align="center">
<br><br><br><br><br><br><br>
	<form action="registerNewUser" method="post" name="registrationForm" id="registrationForm">
	<h2>REGISTER FOR MARKET</h2>
		<table>
			<tr align="center"> 
				<td style="padding-bottom: 10%;">Enter First Name* </td>
				<td style="padding-left: 10%;padding-bottom: 10%;"><input type="text" name="fname" id="fname" maxlength="20" size="40%"/> </td>
			</tr>
			<tr align="center"> 
				<td style="padding-bottom: 10%;">Enter Last Name* </td>
				<td style="padding-left: 10%;padding-bottom: 10%;"><input type="text" name="lname" id="lname" maxlength="20" size="40%"/> </td>
			</tr>
			<tr align="center"> 
				<td style="padding-bottom: 10%;">Enter Email Id* </td>
				<td style="padding-left: 10%;padding-bottom: 10%;"><input type="text" name="emailAddress" id="emailAddress" maxlength="30" size="40%"/></td>
			</tr >
			<tr align="center"> 
				<td style="padding-bottom: 10%;">Enter Password* </td>
				<td style="padding-left: 10%;padding-bottom: 10%;"><input type="password" name="password" id="password" maxlength="30" size="40%"/></td>
			</tr >
			<tr align="center"> 
				<td colspan="2" style="padding-left: 10%;"><input type="button" name="inputButton" value="Submit" onclick="javascript:submitForm(this.form)"/> </td>
			</tr>
			<tr>
			<td colspan="2" style="padding-left: 47%;"> <a href="login.jsp">Already a member?</a> </td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>