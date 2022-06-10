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
  .imageTransparent{
     opacity: 0.6;
  filter: alpha(opacity=60); /* For IE8 and earlier */
  }
   #table_background{
	background-color:white;
	width:35%;
	
}
#highlight{
background-color:#eee;
color:#777;
padding-left:5px;
padding-right:2px;
}
#display{
background-color:#eee;

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

<!-- Login Start -->

<!-- Login End -->

<br>
<center>
<div id="table_background">


<table  style="color:#337ab7;">
<br>
<c:forEach items="${memberById}" var="oneMember">   
<tr>

<tr>
<td id="highlight"><b>PlanCode&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display">
<a style="color:red;" href="viewmemberplancode.htm?planCode=${oneMember.planCode}">
<c:out value="${oneMember.planCode}"/>
</a></td>

</tr>


<td id="highlight"><b>MemberID&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.memberId}"/></td>
</tr>

<tr>
<td id="highlight"><b>FirstName&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.firstName}"/></td>
</tr>

<tr>
<td id="highlight"><b>LastName&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.lastName}"/></td>
</tr>

<tr>
<td id="highlight"><b>Age&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.age}"/></td>
</tr>

<tr>
<td id="highlight"><b>Gender&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.gender}"/></td>
</tr>

<tr>
<td id="highlight"><b>DOB&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.dob}"/></td>
</tr>

<tr>
<td id="highlight"><b>ContactNo&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.contactNo}"/></td>
</tr>

<tr>
<td id="highlight"><b>AltContactNo&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.altContactNo}"/></td>
</tr>

<tr>
<td id="highlight"><b>EmailID&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.emailId}"/></td>
</tr>

<tr>
<td id="highlight"><b>Password&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.password}"/></td>
</tr>


<tr>
<td id="highlight"><b>CoverageStartDate&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.coverageStartDate}"/></td>
</tr>

<tr>
<td id="highlight"><b>CoverageEndDate&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.coverageEndDate}"/></td>
</tr>

<tr>
<td id="highlight"><b>AddressLine1&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.addressLine1}"/></td>
</tr>

<tr>
<td id="highlight"><b>AddressLine2&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.addressLine2}"/></td>
</tr>

<tr>
<td id="highlight"><b>City&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.city}"/></td>
</tr>

<tr>
<td id="highlight"><b>ZipCode&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<td id="display"><c:out value="${oneMember.zipCode}"/></td>
</tr>
<tr>



</c:forEach>   
</table>
<br><br>
</div>
</center>






</body>
</html>