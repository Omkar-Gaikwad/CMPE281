<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>LAPTOPS</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/shop-homepage.css" rel="stylesheet">
<script type="text/javascript">
function submitForm(form) {
	form.submit();
}
function submitCartForm(cartForm) {
	document.forms["cartForm"].submit();
}
function submitHistoryForm() {
	document.forms["userHistory"].submit();
}
function submitLogoutForm() {	
	
	document.forms["logoutForm"].submit();
}
function submitAccessoryForm(cartForm) {
	
	document.forms["accessoryForm"].submit();
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
<a class="navbar-brand" href="#home" onclick="javascript:submitCartForm();"><jsp:getProperty property="firstName" name="userBean" />'s Cart 
</a> <form action="showUserCart" method="post" name="cartForm" id="cartForm"></form>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav navbar-left">
                    <li><a href="#about">Home</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                                       <li><a href="#" onclick="javascript:submitLogoutForm();"> Logout </a></li>
                </ul>
                <form action="logoutUser" method="post" name="logoutForm" id="logoutForm">  </form>
            </div>
        </div>
    </nav>
    
<jsp:useBean id="userBean" scope="session" class="com.cmpe281.project.beans.UserBean"></jsp:useBean>
	<div >
		<table width="100%">
			<tr>
				<td align="left" width="50%" >  </td>
				<td align="right" width="50%">Logged in as <jsp:getProperty property="firstName" name="userBean" /> 
				<jsp:getProperty property="lastName" name="userBean"/> </td>
			</tr>
			<tr> </tr>
		</table>
 	</div>
	<br><br> 

   <div class="col-md-12">
                <div class="row carousel-holder">
                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active" align="center">
                                    <img class="slide-image"   style="max-height: 300px; max-width: 400px;" src="http://www.notebookcheck.net/uploads/tx_nbc2/MacBookPro_klein_07.jpg" alt="">
                                </div>
                                <div class="item" align="center">
                                    <img class="slide-image" style="max-height: 300px; max-width: 400px;" src="http://www9.pcmag.com/media/images/238829-dell-xps-15-top.jpg" alt="">
                                </div>
                                <div class="item" align="center">
                                    <img class="slide-image"  style="max-height: 300px; max-width: 400px;"  src="http://www.slashgear.com/wp-content/uploads/2009/06/sony_vaio_nw_2.jpg" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
                
	<div align="center" >
		<p style="font: bold;font-size: x-large;"> LAPTOPS </p>
	</div>

	<div>
	<%
 			String itemAdded = (String)request.getAttribute("itemAdded");
 			if(itemAdded != null){
 				
 				%> 
 				<h1 align="center" style="font-style: normal;font-weight: normal;font-size: x-large;"><%= itemAdded %></h1>
 				<%
 			}
 		%>
 	</div>
	<div>
	<%
 			String paymentStatus = (String)request.getAttribute("paymentStatus");
 			if(paymentStatus != null){
 				
 				%> 
 				<h1 align="center" style="font-style: normal;font-weight: normal;font-size: x-large;"><%= paymentStatus %></h1>
 				<%
 			}
 		%>
 	</div>

	
		<div class="row">
		<c:forEach var="item" items="${productlist}" >
	<div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <!--  <img src="http://placehold.it/320x150" alt="">-->
                            <div class="caption">
                                <h4 class="pull-right">${item.price}</h4>
                                <h4><a href="#" onclick="javascript:submitAccessoryForm();">${item.brandName}</a>   
                                <a href="#" onclick="javascript:submitAccessoryForm();">${item.laptopName}</a>                               		 
						 </a>
						 <form action="showLaptopAccessory" method="post" name="accessoryForm" id="accessoryForm">  
						 		<input type="hidden" name="itemId" id="itemId" value="${item.laptopId}">
						 </form> 
                                </h4>
                                
                                 <h4 >Operating System <b>${item.operatingSystem}</b></h4>
                                <h4 >Available	<b>${item.quantity} </b></h4>
                            </div>
                            <form action="addToCart" method="post">
                            <input type="text" name="quantityCart" id="quantityCart" placeholder="Enter Quantity"  size="3" class="form-control"  required autofocusmaxlength="20" size="40%"/ >
					<input type="hidden" name="itemId" id="itemId" value="${item.laptopId}">
					 <button class="btn btn-lg btn-primary btn-block" type="button" type="button" name="inputButton" value="Add to Cart"  onclick="javascript:submitForm(this.form)">Add to Cart</button>
						</form> 
                        </div>
                    </div>
		</c:forEach>
	</div>
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
	
<%-- 	<div>
		<table border="1" align="center" width="70%" >		 
		<tr align="center" style="padding-left: 2%;padding-top: 2%;">
			<td width="20%">
				Brand
			</td>
			<td>
				Mobile
			</td>
			<td width="20%">
				Price
			</td>
			<td  width="5%">
				Quantity
			</td>
			<td  width="30%">
				OS
			</td>
			<td width="10%">
				Add to cart
			</td>
		</tr>
		<c:forEach var="item" items="${productlist}" >
		<tr align="center" style="padding-left: 2%;padding-top: 2%;">
			<td width="17%">
				${item.brandName}
			</td>
			<td>
				
				<a href="#" onclick="javascript:submitAccessoryForm();"> 
							${item.laptopName}
						 </a>
						 <form action="showAccessory" method="post" name="accessoryForm" id="accessoryForm">  
						 		<input type="hidden" name="itemId" id="itemId" value="${item.laptopId}">
						 </form> 
			</td>
			<td width="12%">
				${item.price}
			</td>
			<td  width="5%">
				${item.quantity}
			</td>
			<td  width="5%">
				${item.operatingSystem}
			</td>
			<td width="15%">
				<form action="addToCart" method="post">
					<input type="text" name="quantityCart" id="quantityCart" value="1" size="3" align="middle"/>
					<input type="hidden" name="itemId" id="itemId" value="${item.laptopId}">
					<input type="button" value="Add to Cart" onclick="javascript:submitForm(this.form);">
				</form> 
			</td>
		</tr>		
		</c:forEach>
		</table>
	</div> --%>
</body>
</html>