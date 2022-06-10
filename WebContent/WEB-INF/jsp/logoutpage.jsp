<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claims Management System</title>  
  <!--  compiled and minified CSS --> 
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional Bootstrap theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!--  compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!--  My Css File -->
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--  google fonts -->
<link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Faster+One|Gloria+Hallelujah|Merienda|Oleo+Script:700|Yesteryear|Monoton|Srisakdi:400,700|Black+Ops+One&amp;subset=latin-ext" rel="stylesheet">
  <style type="text/css">
  #userButtons{
	font-family:Copperplate Gothic;
	padding-left:2%;
	color:blue;
	background-color:#54285a08;
}
#userButton{
color:green;
}
#userButton:hover {
    color: rgba(220, 0, 0, 1);
}

 body{
 background-color: #5bc0de;
   
  }
  .imageTransparent{
     opacity: 0.6;
  filter: alpha(opacity=60); /* For IE8 and earlier */
  }
  #table_background{
	background-color:white;
	width:30%;
}
  </style>
  <script language="Javascript">


</script>
</head>
<body id="bgc"> 
<!-- NavBar -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header" >
      <a class="navbar-brand " href="index.html" id="logo"> <img src="images/logo.PNG" height="50px" weight="50px"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active" ><a href="index.html"><span class="glyphicon glyphicon-home"></span> Home</a></li>
      <li><a href="#">Services</a></li>
      <li><a href="#">Contact Us</a></li>
    </ul>
   
  </div>
</nav> 

<!-- Jumbotron -->
  <div  class="jumbo">
  <h3 style="display: inline; padding-left: 5%;" >Claims Management System</h3>     
    <h5 style="display: inline; float: right; padding-right: 5%;">Profession of Business</h5>
  </div>

<!-- Login Start -->
<center>
<div id="userButtons"><br>
<div id="table_background" >
<br>

<h3 style="color:red;">You are Logged Out sucessfully</h3>
</div>
</div>
</center>
<!-- Login End -->




</body>
</html>