<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Reviews</title>
<script type="text/javascript">
function submitForm(form) {
	form.submit();
}
function submitHomeForm() {
	document.forms["homeForm"].submit();
}
function submitCartForm(cartForm) {
	document.forms["cartForm"].submit();
}
function submitReviewForm(cartForm) {
	document.forms["reviewForm"].submit();
}
function submitHistoryForm() {
	document.forms["userHistory"].submit();
}
function submitLogoutForm() {
	document.forms["logoutForm"].submit();
}
</script>

</head>
<body>
<jsp:useBean id="userBean" scope="session" class="com.cmpe281.project.beans.UserBean"></jsp:useBean>
	<div >
		<table width="100%">
			<tr>
				<td align="left" width="50%" >
  			    <a href="#" onclick="javascript:submitHomeForm();"> Home </a><form action="showMarketHome" method="post" name="homeForm" id="homeForm">  </form> </td>  
				<td align="right" width="50%">Logged in as <jsp:getProperty property="firstName" name="userBean" /> 
				<jsp:getProperty property="lastName" name="userBean"/> </td>
			</tr>
			<tr>
				<td align="left" width="50%"> <a href="#" onclick="javascript:submitCartForm();"> <jsp:getProperty property="firstName" name="userBean" />'s Cart </a><form action="showUserCart" method="post" name="cartForm" id="cartForm">  </form> </td>
				<td align="right" width="50%"><a href="#" onclick="javascript:submitLogoutForm();"> Logout </a><form action="logoutUser" method="post" name="logoutForm" id="logoutForm">  </form> </td>
			</tr>
		</table>
 		
 	</div>
	<br><br> 

	<div align="center" >
		<p style="font: bold;font-size: x-large;"> BOOK REVIEWS </p>
	</div>


<div align="center" style="width: 70%;">
	<table border="1" align="center" width="100%" >
		<tr>
			<td style="width: 90%;" align="center">
				Review : <c:out value="${bookName}" />
			</td>
			<td align="center">
				Rating
			</td>
		</tr>
		
		<c:forEach var="review" items="${reviews}" >
		<tr>
			<td>
				${review.review} - <p style="font-weight: bold;"> ${review.userName} </p>
			</td>
			<td align="center">
				${review.rating} 
			</td>
		</tr>
			
		</c:forEach>
	</table>
</div>
</body>
</html>