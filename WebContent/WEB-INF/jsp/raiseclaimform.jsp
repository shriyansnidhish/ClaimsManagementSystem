<%@ taglib prefix="springform"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Claim Registration</title>
<!--  compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional Bootstrap theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!--  compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!--  My Css File -->
<link rel="stylesheet" type="text/css" href="./css/main.css">
<!--  google fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Bungee+Shade|Faster+One|Gloria+Hallelujah|Merienda|Oleo+Script:700|Yesteryear|Monoton|Srisakdi:400,700|Black+Ops+One&amp;subset=latin-ext"
	rel="stylesheet">
<style type="text/css">
 body{
 background-color: DarkCyan;
   
  }
a {
	color: white;
}
.transbox{
padding-left:5%;
padding-right:5%;
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
	

		if (document.claimform.claimServiceDate.value == "") {
			alert("Enter Claim Service Date");
			var field=document.claimform.claimServiceDate;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.claimform.claimServiceDate.focus();
			return false;
		}
		if (document.claimform.claimSubmissionDate.value == "") {
			alert("Enter the Claim Submission date");
			var field=document.claimform.claimSubmissionDate;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.claimform.claimSubmissionDate.focus();
			return false;
		}

		if (document.claimform.claimProcessingDate.value == "") {
			alert("Enter the claim processing date");
			var field=document.claimform.claimProcessingDate;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.claimform.claimProcessingDate.focus();
			return false;
		}
		if (document.claimform.claimAmount.value == "") {
			alert("Enter the Claim Amount");
			var field=document.claimform.claimAmount;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.claimform.claimAmount.focus();
			return false;
		}
		if (document.claimform.approvedAmount.value == "") {
			alert("Enter the Approved Amount");
			var field=document.claimform.approvedAmount;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.claimform.approvedAmount.focus();
			return false;
		}

	}
</script>
</head>
<body>
	<!-- NavBar -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header" >
      <a class="navbar-brand " href="memberdash.htm" id="logo"> <img src="images/logo.PNG" height="50px" weight="50px"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active" ><a href="memberdash.htm"><span class="glyphicon glyphicon-home"></span> Home</a></li>
      <li><a href="#">Services</a></li>
      <li><a href="#">Contact Us</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right" id="navbr">
      <li><a href="memberlogout.htm" style="color:yellow;"><span class="glyphicon glyphicon-user" ></span> Logout</a></li>
    </ul>
  </div>
</nav> 

	<div id="img"
		style="background-color: DarkCyan; background-repeat: no-repeat; background-size: cover;">



		<div style="width: 50%;" class="transbox">
			<center>
				<h2 style="color: red;background-color: #87dec5;">Claim Registration</h2>
			</center>
			<br>

			<springform:form id="claimForm" modelAttribute="claimModel" name="claimform"
				onsubmit="return checkfield()"
				action="claimregistrationprocess.htm" method="post">
				<table>
			 		

					<tr>
						<td><springform:label path="claimServiceDate">Claim Service Date&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="claimServiceDate" />&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="claimServiceDate" /></td>
					</tr>
					<tr>
						<td><springform:label path="claimSubmissionDate">Claim Submission Date&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="claimSubmissionDate" />&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="claimSubmissionDate" /></td>

					</tr>
					<tr>
						<td><springform:label path="claimProcessingDate">Claim Processing Date&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="claimProcessingDate" />&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="claimProcessingDate" /></td>

					</tr>



					<tr>
						<td><springform:label path="claimAmount">Claim Amount&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="claimAmount" />&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="claimAmount" /></td>

					</tr>


					<tr>
						<td><springform:label path="approvedAmount">Approved Amount&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="approvedAmount" />&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="approvedAmount" /></td>

					</tr>
                     <tr>

						<td>
						<td colspan="2"><br><input id="styled" type="submit"
							value="Register" /></td>

					</tr>


				</table>

<br>

			</springform:form>



		</div>


	</div>


</body>
</html>
