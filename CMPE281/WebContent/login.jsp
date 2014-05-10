<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Market Place Login</title>

    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
      /* Override some defaults */
      html, body {
        background-color: #eee;
      }
      body {
        padding-top: 40px; 
      }
      .container {
        width: 300px;
      }

      /* The white background content wrapper */
      .container > .content {
        background-color: #fff;
        padding: 20px;
        margin: 0 -20px; 
        -webkit-border-radius: 10px 10px 10px 10px;
           -moz-border-radius: 10px 10px 10px 10px;
                border-radius: 10px 10px 10px 10px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.15);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.15);
                box-shadow: 0 1px 2px rgba(0,0,0,.15);
      }

      .login-form {
        margin-left: 65px;
      }

      legend {
        margin-right: -50px;
        font-weight: bold;
          color: #404040;
      }

    </style>
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

    <div class="container">

      <form class="form-signin" role="form" action="loginUser" method="post" name="loginForm" id="loginForm">
        <h2 class="form-signin-heading">&nbsp&nbsp&nbsp&nbsp&nbspMarket Login</h2>
        <input type="email" name="emailAddress" id="emailAddress"  class="form-control" placeholder="Email address" required autofocusmaxlength="20" size="40%"/ >
        <input type="password" name="password" id="password" class="form-control" placeholder="Password" required maxlength="20" size="40%"/>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="button" type="button" name="inputButton" value="Login" onclick="javascript:submitForm(this.form)">Sign in</button>
        <button class="btn btn-lg btn-primary btn-block" type="button" type="button" name="signupButton" value="Signup" onclick="location.href='createUser.jsp'">Sign up</button>  
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- Latest compiled and minified JavaScript -->
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
  </body>
</html>
