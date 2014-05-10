<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="assets/css/custom.css"/>	


<title>Cart</title>
<script type="text/javascript">
function submitForm(form) {
	form.submit();
}
function submitHomeForm() {
	document.forms["homeForm"].submit();
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
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>

			</button>
		</div>

		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="#" onclick="javascript:submitHomeForm();">
						Home </a>
					<form action="showMarketHome" method="post" name="homeForm"
						id="homeForm"></form></li>
				<li><a href="#contact">Contact</a></li>

			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" onclick="javascript:submitLogoutForm();">
						Logout </a>
					<form action="logoutUser" method="post" name="logoutForm"
						id="logoutForm"></form></li>
			</ul>
		</div>

	</div>

	</nav>
	<jsp:useBean id="userBean" scope="session"
		class="com.cmpe281.project.beans.UserBean"></jsp:useBean>
	<div>
		<table width="100%">
			<tr>
				<td align="left" width="50%"></td>
				<td align="right" width="50%">Logged in as <jsp:getProperty
						property="firstName" name="userBean" /> <jsp:getProperty
						property="lastName" name="userBean" />
				</td>
			</tr>
		</table>
	</div>


	
	<div class="container-fluid breadcrumbBox text-center">
		<ol class="breadcrumb">
			<li><a href="#">Review</a></li>
			<li class="active"><a href="#">Order</a></li>
			<li><a href="#">Payment</a></li>
		</ol>
	</div>
	<br>
	<br>
	<%
		int tenantId = (Integer) request.getSession().getAttribute("tenantId"); 
		System.out.print("in JSP  :: " + tenantId);
	%>



	<%
		if (tenantId == 1) {

		%>
		<div class="container text-center">

		<div class="col-md-5 col-sm-12">
			<div class="bigcart"></div>
			<h1>Your shopping cart</h1>
		</div>
		<div class="col-md-7 col-sm-12 text-left">
			<ul>
				<li class="row list-inline columnCaptions"><span>QTY</span> <span>ITEM</span>

					<span>AMOUNT</span></li>


				<c:forEach var="cart" items="${cartList}" >
					<li class="row"><span class="quantity">${cart.quantity}</span>
						<span class="quantity">${cart.column1}&nbsp;${cart.column2}</span> 
					
						<span class="popbtn"><a
							class="arrow"></a></span> <span class="price">${cart.amount}</span> 
							</li>
							
				</c:forEach>
				
				<li class="row totals">
						<span class="itemName">Total:</span>
						<span class="price"><%= request.getSession().getAttribute("totalAmount") %></span>
						<form action="showMakePayment" method="post" name="showPayment"
					id="showPayment">
						<input class="btn btn-primary" style="float: right;" type="submit" value="Order"/> 
						</form>
					</li>
			</ul>
		</div>
	</div>

				<%
		}
			%>


	<%
		if (tenantId == 2) {
		%>
	<div class="container text-center">

		<div class="col-md-5 col-sm-12">
			<div class="bigcart"></div>
			<h1>Your shopping cart</h1>
		</div>
		<div class="col-md-7 col-sm-12 text-left">
			<ul>
				<li class="row list-inline columnCaptions"><span>QTY</span> <span>ITEM</span>

					<span>AMOUNT</span></li>


				<c:forEach var="cart" items="${cartList}">
					<li class="row"><span class="quantity">${cart.quantity}</span>
						<span class="quantity">${cart.column1}&nbsp;${cart.column2}</span> 
					
						<span class="popbtn"><a
							class="arrow"></a></span> <span class="price">${cart.amount}</span> 
							</li>
							
				</c:forEach>
				<li class="row totals">
						<span class="itemName">Total:</span>
						<span class="price"><%= request.getSession().getAttribute("totalAmount") %></span>
						<form action="showMakePayment" method="post" name="showPayment"
					id="showPayment">
						<input class="btn btn-primary" style="float: right;" type="submit" value="Order"/> 
						</form>
					</li>
			</ul>
		</div>
	</div>
	<%
		}
			%>



	<%
		if (tenantId == 3) {
		%>
		
		<div class="container text-center">

		<div class="col-md-5 col-sm-12">
			<div class="bigcart"></div>
			<h1>Your shopping cart</h1>
		</div>
		<div class="col-md-7 col-sm-12 text-left">
			<ul>
				<li class="row list-inline columnCaptions"><span>QTY</span> <span>ITEM</span>

					<span>AMOUNT</span></li>


				<c:forEach var="cart" items="${cartList}">
					<li class="row"><span class="quantity">${cart.quantity}</span>
						<span class="quantity">${cart.column1}&nbsp;${cart.column2}</span> 
					
						<span class="popbtn"><a
							class="arrow"></a></span> <span class="price">${cart.amount}</span> 
							</li>
							
				</c:forEach>
				<li class="row totals">
						<span class="itemName">Total:</span>
						<span class="price"><%= request.getSession().getAttribute("totalAmount") %></span>
						<form action="showMakePayment" method="post" name="showPayment"
					id="showPayment">
						<input class="btn btn-primary" style="float: right;" type="submit" value="Order"/> 
						</form>
					</li>
			</ul>
		</div>
	</div>
		
		
		
	<%
		}
			%>
			<%
		if (tenantId == 4) {
		%>
				<div class="container text-center">

		<div class="col-md-5 col-sm-12">
			<div class="bigcart"></div>
			<h1>Your shopping cart</h1>
		</div>
		<div class="col-md-7 col-sm-12 text-left">
			<ul>
				<li class="row list-inline columnCaptions"><span>QTY</span> <span>ITEM</span>

					<span>AMOUNT</span></li>


				<c:forEach var="cart" items="${cartList}">
					<li class="row"><span class="quantity">${cart.quantity}</span>
						<span class="quantity">${cart.column1}&nbsp;${cart.column2}</span> 
					
						<span class="popbtn"><a
							class="arrow"></a></span> <span class="price">${cart.amount}</span> 
							</li>
							
				</c:forEach>
				<li class="row totals">
						<span class="itemName">Total:</span>
						<span class="price"><%= request.getSession().getAttribute("totalAmount") %></span>
						<form action="showMakePayment" method="post" name="showPayment"
					id="showPayment">
						<input class="btn btn-primary" style="float: right;" type="submit" value="Order"/> 
						</form>
					</li>
			</ul>
		</div>
	</div>
			<%
		}
			%>
			
		<%
if (tenantId == 5) {
		%>
		
				<div class="container text-center">

		<div class="col-md-5 col-sm-12">
			<div class="bigcart"></div>
			<h1>Your shopping cart</h1>
		</div>
		<div class="col-md-7 col-sm-12 text-left">
			<ul>
				<li class="row list-inline columnCaptions"><span>QTY</span> <span>ITEM</span>

					<span>AMOUNT</span></li>


				<c:forEach var="cart" items="${cartList}">
					<li class="row"><span class="quantity">${cart.quantity}</span>
						<span class="quantity">${cart.column1}&nbsp;${cart.column2}</span> 
					
						<span class="popbtn"><a
							class="arrow"></a></span> <span class="price">${cart.amount}</span> 
							</li>
							
				</c:forEach>
				<li class="row totals">
						<span class="itemName">Total:</span>
						<span class="price"><%= request.getSession().getAttribute("totalAmount") %></span>
						<form action="showMakePayment" method="post" name="showPayment"
					id="showPayment">
						<input class="btn btn-primary" style="float: right;" type="submit" value="Order"/> 
						</form>
					</li>
			</ul>
		</div>
	</div>			<%
		}
			%>
	</table>
	
	</div>
	
<div id="popover" style="display: none">
			<a href="#"><span class="glyphicon glyphicon-pencil"></span></a>
			<a href="#"><span class="glyphicon glyphicon-remove"></span></a>
		</div>

	<!-- JavaScript -->
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/customjs.js"></script>

</body>
</html>