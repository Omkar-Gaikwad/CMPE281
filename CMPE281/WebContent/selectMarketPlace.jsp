<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marketplace</title>
<script type="text/javascript">
function submitBookForm() {
	document.forms["bookForm"].submit();
}
function submitCarForm() {
	document.forms["carForm"].submit();
}
function submitMobileForm() {
	document.forms["mobileForm"].submit();
}
function submitLaptopForm() {
	document.forms["laptopForm"].submit();
}
function submitSportForm() {
	document.forms["sportForm"].submit();
}

</script>
</head>
<body>

	<table align="center">
		<tr align="center"> 
				<td align="right" width="50%"><a href="#" onclick="javascript:submitBookForm();"> Books </a>
				<form action="selectTenant" method="post" name="bookForm" id="bookForm"> 
				<input type="hidden" name="market" id="market" value="book">
				 </form> </td>				
		</tr>
		<tr></tr>
		<tr></tr>
		<tr align="center"> 
				<td align="right" width="50%"><a href="#" onclick="javascript:submitCarForm();"> Cars </a>
				<form action="selectTenant" method="post" name="carForm" id="carForm"> 
				<input type="hidden" name="market" id="market" value="car">
				 </form> </td>				
		</tr>
		<tr align="center"> 
				<td align="right" width="50%"><a href="#" onclick="javascript:submitMobileForm();"> Mobile </a>
				<form action="selectTenant" method="post" name="mobileForm" id="mobileForm"> 
				<input type="hidden" name="market" id="market" value="mobile">
				 </form> </td>				
		</tr>
		<tr align="center"> 
				<td align="right" width="50%"><a href="#" onclick="javascript:submitLaptopForm();"> Laptop </a>
				<form action="selectTenant" method="post" name="laptopForm" id="laptopForm"> 
				<input type="hidden" name="market" id="market" value="laptop">
				 </form> </td>				
		</tr>
		<tr align="center"> 
				<td align="right" width="50%"><a href="#" onclick="javascript:submitSportForm();"> Sport </a>
				<form action="selectTenant" method="post" name="sportForm" id="sportForm"> 
				<input type="hidden" name="market" id="market" value="sport">
				 </form> </td>				
		</tr>
	</table>

</body>
</html>