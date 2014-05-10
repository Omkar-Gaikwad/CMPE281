<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function submitForm(form) {
	var toSubmit =true;
	if(form.carditCardText.value.length != 16){
		alert("Enter valid credit card number!!");
		form.carditCardText.focus();
		toSubmit = false;
	} else if(form.csvNumberText.value.length != 3){
		alert("Enter valid CSV number!!");
		form.csvNumberText.focus();
		toSubmit = false;
	}
	if(toSubmit){

		var url = "creditCardPayment";
		form.action = url; 
		form.submit();

	}
}

function submitForm1(form) {

	document.forms["creditCardPayment"].submit();
	
}
function submitForm2(form) {
	form.submit();
	
}
</script>
</head>
<body>
<div align="center">
<br><br><br><br><br><br>
<!-- 
<form action="creditCardPayment" method="post" name="makePaymentForm" id="makePaymentForm">
<input type="button" name="makePayment" id="makePayment" value="Make Payment" onclick="javascript:submitForm1(this.form)"/>
Credit Card Number : <input type="text" name="carditCardText" id="carditCardText" maxlength="16"  value="1"/><br><br><br>
</form> -->


				

<form action="creditCardPayment" method="post" name="makePaymentForm" id="makePaymentForm">
	User Name          : <input type="text" name="userNameText" id="userNameText" value="<%= request.getSession().getAttribute("userName") %>" disabled="disabled"/><br><br><br>
	Total Payment      : <input type="text" name="totalAmountText" id="totalAmountText" value="<%= request.getSession().getAttribute("totalAmount") %>" disabled="disabled"/><br><br><br>
	Card type          : <input type="text" name="cardType" id="cardType" value="Visa" disabled="disabled"/><br><br><br>
	Credit Card Number : <input type="text" name="carditCardText" id="carditCardText" maxlength="16" /><br><br><br>
	CSV Number         : <input type="text" name="csvNumberText" id="csvNumberText" maxlength="3"/><br><br><br>
	<input type="submit" name="makePayment" id="makePayment" value="Make Payment" onclick="javascript:submitForm(this.form)"/>
</form>
 </div>

</body>
</html>