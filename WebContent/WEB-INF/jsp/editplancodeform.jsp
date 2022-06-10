<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags" prefix="springcore" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
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
 body{
 background-color: DarkCyan;
   
  }
  .imageTransparent{
     opacity: 0.6;
  filter: alpha(opacity=60); /* For IE8 and earlier */
  }
  .transbox{

box-shadow:2px 2px 15px 10px black;
background-color:white;
margin-left:4%;
margin-right:4%;
opacity:0.7;
filter:alpha(opacity=90);
}
#img h2 {
    margin-top: 5%;
    font-style: italic;
     margin-left: 0%; 
    font-family: Copperplate Gothic;
}
#img
{
padding-top:0%;
padding-left:25%;
  background-repeat: no-repeat;
width:100%;
height:100%;
}

  </style>
  <script type="text/javascript">
	function checkfield() {
	

		if (document.claimform.planDescription.value == "") {
			alert("Enter plan Description");
			var field=document.claimform.planDescription;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.claimform.planDescription.focus();
			return false;
		}
		if (document.claimform.coverage1.value == "") {
			alert("Enter coverage1");
			var field=document.claimform.coverage1;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.claimform.coverage1.focus();
			return false;
		}

		if (document.claimform.coverage2.value == "") {
			alert("Enter coverage2");
			var field=document.claimform.coverage2;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.claimform.coverage2.focus();
			return false;
		}
		if (document.claimform.coverage3.value == "") {
			alert("Enter coverage3");
			var field=document.claimform.coverage3;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.claimform.coverage3.focus();
			return false;
		}
		if (document.claimform.coverage4.value == "") {
			alert("Enter coverage4");
			var field=document.claimform.coverage4;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.claimform.coverage4.focus();
			return false;
		}
		if (document.claimform.coverage5.value == "") {
			alert("Enter coverage5");
			var field=document.claimform.coverage5;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.claimform.coverage5.focus();
			return false;

	}
</script>
</head>
<body id="bgc"> 
<!-- NavBar -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header" >
      <a class="navbar-brand " href="admindash.htm" id="logo"> <img src="images/logo.PNG" height="50px" weight="50px"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active" ><a href="admindash.htm"><span class="glyphicon glyphicon-home"></span> Home</a></li>
      <li><a href="#">Services</a></li>
      <li><a href="#">Contact Us</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right" id="navbr">
      <li><a href="adminlogout.htm" style="color:yellow;"><span class="glyphicon glyphicon-user" ></span> Logout</a></li>
    </ul>
  </div>
</nav> 

<!-- Jumbotron -->
  <div  class="jumbo">
  <h3 style="display: inline; padding-left: 5%;" >Claims Management System</h3>     
    <h5 style="display: inline; float: right; padding-right: 5%;">Profession of Business</h5>
  </div>


<div id="img"
		style="background-color: DarkCyan; background-repeat: no-repeat; background-size: cover;">



		<div style="width: 50%;" class="transbox">
		<center>
				<h2 style="color: red;background-color: #87dec5;">Update Plan</h2>
			</center><br>
			<center>

<springform:form  modelAttribute="planCodeModel" action="editplancode.htm?planCode=${planCode}" name="claimform"
				onsubmit="return checkfield()" method="post">

<label>Plan Code&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${planCode}"/></label><br><br>

<springform:label path="planDescription">Plan Description&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</springform:label>
<springform:input class="box" type="text"  path="planDescription" /><br><br>

<springform:label path="coverage1">Coverage 1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</springform:label>
<springform:input class="box" path="coverage1" /><br><br>

<springform:label path="coverage2">Coverage 2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</springform:label>
<springform:input class="box"  path="coverage2" /><br><br>

<springform:label path="coverage3">Coverage 3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</springform:label>
<springform:input class="box"  path="coverage3" /><br><br>

<springform:label path="coverage4">Coverage 4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</springform:label>
<springform:input class="box" path="coverage4" /><br><br>

<springform:label path="coverage5">Coverage 5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</springform:label>
<springform:input class="box" path="coverage5" /><br><br>

<input id="styled" type="submit" value="Update" >

</springform:form>
<br><br><br><br>
</center>
</div><br><br><br>
</div>



</body>
</html>