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
    <title>BOOKS</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/shop-homepage.css" rel="stylesheet">

<script type="text/javascript">
function submitForm(form) {
	form.submit();
}
function submitCartForm(cartForm) {
	document.forms["cartForm"].submit();
}
function submitReviewForm() {
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
                                       <li><a href="#" onclick="javascript:submitLogoutForm();"> Logout </a><form action="logoutUser" method="post" name="logoutForm" id="logoutForm">  </form></li>
                </ul>
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
                                <div class="item active">
                                    <img class="slide-image"  align="middle" style="max-height: 300px; max-width: 1400px;" src="https://www.barnsley.gov.uk/media/Books%20On%20A%20Library%20Shelf.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" align="middle" style="max-height: 300px; max-width: 1400px;" src="http://edudemic.com/wp-content/uploads/2012/07/library.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" align="middle" style="max-height: 300px; max-width: 1400px;"  src="http://blakleylibrary.blog.com/files/2013/05/Library-Books1.jpg" alt="">
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
		<p style="font: bold;font-size: x-large;"> BOOKS </p>
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
                                <h4><a href="#" onclick="javascript:submitReviewForm();">${item.bookName}</a>                                		 
						 </a>
						 <form action="showReview" method="post" name="reviewForm" id="reviewForm">  
						 		<input type="hidden" name="itemId" id="itemId" value="${item.bookId}">
						 </form> 
                                </h4>
                                 <h4 >Author <b>${item.author}</b></h4>
                                <h4 >Available	<b>${item.quantity} </b></h4>
                            </div>
                            <form action="addToCart" method="post">
                            <input type="text" name="quantityCart" id="quantityCart" placeholder="Enter Quantity"  size="3" class="form-control"  required autofocusmaxlength="20" size="40%"/ >
					<input type="hidden" name="itemId" id="itemId" value="${item.bookId}">
					 <button class="btn btn-lg btn-primary btn-block" type="button" type="button" name="inputButton" value="Add to Cart"  onclick="javascript:submitForm(this.form)">Add to Cart</button>
						</form> 
                        </div>
                    </div>
		</c:forEach>
	</div>
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>

</body>
</html>