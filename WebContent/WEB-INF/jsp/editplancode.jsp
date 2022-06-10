<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
 background-color: #5bc0de;
   
  }
  button{
 background-color: #5cb85c;
 color:red;
  }
  button:hover{
 background-color: red;
 color:#5cb85c;
  }
  .imageTransparent{
     opacity: 0.6;
  filter: alpha(opacity=60); /* For IE8 and earlier */
  }
   #table_background{
	background-color:white;
	width:25%;
	
}
  #highlight{
background-color:#eee;
color:#777;
padding-left:5px;
padding-right:2px;
}
#display{
background-color:#eee;
color:#2e6da4;
padding-left:5px;
padding-right:2px;
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

<br>
<center>
<div id="table_background">
<br>
<table>

 <c:forEach items="${planById}" var="onePlan">             
<tr>
<th id="highlight">PlanCode</th>
<td id="display"><c:out value="${onePlan.planCode}"/></td>
</tr>
<tr>
<th id="highlight">PlanDescription</th> 
<td id="display"><c:out value="${onePlan.planDescription}"/></td>
</tr>
<tr>
<th id="highlight">Coverage1</th>
<td id="display"><c:out value="${onePlan.coverage1}"/></td>
</tr>
<tr>
 <th id="highlight">Coverage2</th>
<td id="display"><c:out value="${onePlan.coverage2}"/></td>
</tr>
<tr>
<th id="highlight">Coverage3</th>
<td id="display"><c:out value="${onePlan.coverage3}"/></td>
</tr>
<tr>
 <th id="highlight">Coverage4</th>
<td id="display"> <c:out value="${onePlan.coverage4}"/></td>
</tr>
<tr>
<th id="highlight">Coverage5</th>
<td id="display"><c:out value="${onePlan.coverage5}"/></td>
</tr>
<tr>
 <td id="highlight"></td>
<td id="display"><br><a href="loadplancodeform.htm?planCode=${onePlan.planCode}"><button> <b>Update Plan</b></button></a><br><br></td>
</tr>


</c:forEach>   
</table>
<br>
</div>
</center>




</body>
</html>