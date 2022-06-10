<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<html>
<head>
	<meta charset="utf-8">
	 <meta http-equiv="X-UA-Compatible" content="IE=edge">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Login</title>
<!--  compiled and minified CSS --> 
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional Bootstrap theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!--  compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!--  My Css File -->
<link rel="stylesheet" type="text/css" href="./css/main.css">
<!--  google fonts -->
<link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Faster+One|Gloria+Hallelujah|Merienda|Oleo+Script:700|Yesteryear|Monoton|Srisakdi:400,700|Black+Ops+One&amp;subset=latin-ext" rel="stylesheet">
<style type="text/css">
	a{
		color: white;
	}
</style>
<script type="text/javascript">
function checkinput(){
	if (document.login.adminId.value=="")
	  {
	  alert("Enter your ID");
	  var field=document.login.adminId;
		field.style.borderColor="red";
		field.style.borderWidth="5px";
	  document.login.adminId.focus();
	  return false;
	  }
	if (document.login.password.value=="")
	  {
	  alert("Enter your Password");
	  var field=document.login.password;
		field.style.borderColor="red";
		field.style.borderWidth="5px";
	  document.login.password.focus();
	  return false;
	  }
}
</script>
</head>
<body>
	<div id="header">
	<div class="logo" align="center">
 <a class="navbar-brand " href="index.html" id="logo"> <img src="images/logo.PNG" height="100px" weight="100px"></a>
	</div>
			<div class="menu">
				<ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Contact Us</a></li>                
				</ul>
			</div>
	</div>

	<div id="img" style="background:url(./images/login7.jpg); background-repeat: no-repeat; background-size: cover; ">
	

	
		<div class="login">
		<center><h2 style="color:white;">Admin Login</h2></center>
		<springform:form modelAttribute="adminModel" align="center" name="login" method="post" action="doadminlogin.htm" onsubmit="return checkinput()">
			<b style="color:white;">Username&nbsp;:</b> <springform:input path="adminId" class="box" type="text" name="username"/><br><br>
			<b style="color:white;">Password&nbsp;:&nbsp;</b> <springform:input path="password" class="box" type="password" name="password"/><br><br>

			<input id="styled" type="submit" value="Log In"><br>
		<springform:errors path="adminId" style="color:red"></springform:errors>
	</springform:form>
		<center>
		<a href="adminregistration.htm" style="color:orange;"><span class="glyphicon  glyphicon glyphicon-user"></span>  Admin Registration</a>
		</center>
		</div>
		
		
	</div>
	<div id="footer">
		<a href="#" style="display: inline; padding-left: 5%;">CMS Infotech</a>
  <a href="#" style="display: inline; padding-left: 5%;">Privacy & Terms</a>  
  <a href="#" style="display: inline; padding-left: 5%;">Need Help ?</a>    

    <a href="https://www.cognizant.com/" style="display: inline; float: right; padding-right: 5%;">Powered by Cognizant © 2019</a>
	</div>
	
</body>
</html>
