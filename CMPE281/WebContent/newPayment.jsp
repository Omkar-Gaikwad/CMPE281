<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function submitForm(form) {
	
	form.submit();
}
</script>
</head>
<body>
this is new
<form action="creditCardPayment" method="get" name="payForm" id="payForm">
	<input type="text" name="quantityCart" id="quantityCart" value="1" size="3" align="middle"/>
	<input type="button" value="Add to Cart" onclick="javascript:submitForm(this.form);">
</form>
</body>
</html>