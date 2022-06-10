<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Registration</title>

<!--  My Css File -->
<link rel="stylesheet" type="text/css" href="./css/main.css">
<!--  google fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Bungee+Shade|Faster+One|Gloria+Hallelujah|Merienda|Oleo+Script:700|Yesteryear|Monoton|Srisakdi:400,700|Black+Ops+One&amp;subset=latin-ext"
	rel="stylesheet">
<style type="text/css">
a {
	color: white;
}
.transbox{
box-shadow:2px 2px 15px 10px black;
background-color:white;
margin-left:4%;
margin-right:4%;
opacity:0.7;
filter:alpha(opacity=90);
}
#img h2
{
margin-top:5%;
font-style:italic;
margin-left: 0%;
font-family:Copperplate Gothic;
}
</style>
<script type="text/javascript">

	function checkfield() {
		
		if (document.adminform.firstName.value == "") {
			alert("Enter your First Name");
			var field=document.adminform.firstName;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.adminform.firstName.focus();
			return false;
		}
		if (document.adminform.lastName.value == "") {
			alert("Enter your Last Name");
			var field=document.adminform.lastName;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.adminform.lastName.focus();
			return false;
		}
		if (document.adminform.age.value == "") {
			alert("Enter your age");
			var field=document.adminform.age;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.adminform.age.focus();
			return false;
		}
		if (document.adminform.gender.value == "none") {
			alert("Select Your Gender");
			var field=document.adminform.gender;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			return false;
		}
		if (document.adminform.dob.value == "") {
			alert("Enter your DOB");
			var field=document.adminform.dob;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.adminform.dob.focus();
			return false;
		}
		if (document.adminform.contactNo.value == "") {
			alert("Enter your ContactNo Detail");
			var field=document.adminform.contactNo;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.adminform.contactNo.focus();
			return false;
		}
		if (document.adminform.emailId.value == "") {
			alert("Enter your EMail ID");
			var field=document.adminform.emailId;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.adminform.emailId.focus();
			return false;
		}
		if (document.adminform.password.value == "") {
			alert("Create Password");
			var field=document.adminform.password;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.adminform.password.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<div id="header">
		<div class="logo" align="center">
			<a class="navbar-brand " href="index.html" id="logo"> <img
				src="images/logo.PNG" height="100px" weight="100px"></a>
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
<h3 style="padding-left: 5%; color:red;">Your ID Is : <c:out value="${id}"/></h3>
	<div id="img"
		style="background-color: DarkCyan; background-repeat: no-repeat; background-size: cover;">

<center>

		<div style="width: 60%;" class="transbox">
			
				<h2 style="color: red;background-color: #87dec5;">Admin Registration</h2>
			
			<br>

			<springform:form id="regForm" modelAttribute="adminModel"
				name="adminform" onsubmit="return checkfield()"
				action="registerProcessAdmin.htm" method="post">
				<table>
				<!-- 
					<tr>
						<td><springform:label path="adminId">Admin ID&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label>
						</td>

						<td><springform:input class="box" path="adminId" /></td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="adminId" /></td>
					</tr>
					 -->
					<tr>
						<td><springform:label path="firstName">First Name&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="firstName" />&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="firstName" /></td>
					</tr>
					<tr>
						<td><springform:label path="lastName">Last Name&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="lastName" />&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="lastName" /></td>

					</tr>
					



					<tr>
						<td><springform:label path="gender">Gender&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label>

						</td>
						<td><springform:select class="box" path="gender">
								<springform:option value="none" label="Select" />
								<springform:option value="male" label="Male" />
								<springform:option value="female" label="Female" />
								<springform:option value="others" label="Others" />
							</springform:select></td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="gender" /></td>
					</tr>




					<tr>
						<td><springform:label path="dob">DoB&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input id="calculateAge" class="box" path="dob" placeholder="DD/MM/YYYY" onfocusout="myFunction()"/></td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="dob" /></td>

					</tr>
					
					<tr>
						<td><springform:label path="age">Age&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input id="age" class="box" path="age" />&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="age" /></td>

					</tr>
					
					<tr>
						<td><springform:label path="contactNo">ContactNo&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="contactNo" /></td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="contactNo" /></td>

					</tr>
					<tr>
						<td><springform:label path="altContactNo">AltContactNo&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="altContactNo" /></td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="altContactNo" /></td>

					</tr>

					<tr>
						<td><springform:label path="emailId">Email ID&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="emailId" type="email" /></td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="emailId" /></td>


					</tr>

					<tr>
						<td><springform:label path="password">Password&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="password"
								type="password" /></td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="password" /></td>


					</tr>







					<tr>

						<td>
						<td  style="padding-top:5%;"colspan="2"><input id="styled" type="submit"
							value="Register" /></td>

					</tr>


				</table>



			</springform:form>


















		</div>

</center>
	</div>
	<div id="footer">
		<a href="doadminregistration.htm"
			style="display: inline; padding-left: 5%;">CMS Infotech</a> <a
			href="#" style="display: inline; padding-left: 5%;">Privacy &
			Terms</a> <a href="#" style="display: inline; padding-left: 5%;">Need
			Help ?</a> <a href="https://www.cognizant.com/"
			style="display: inline; float: right; padding-right: 5%;">Powered
			by Cognizant © 2019</a>
	</div>
<script>



function getAge(dateString) {

    var dates = dateString.split("/");
    var d = new Date();

    var userday = dates[0];
    var usermonth = dates[1];
    var useryear = dates[2];

    var curday = d.getDate();
    var curmonth = d.getMonth()+1;
    var curyear = d.getFullYear();

    var age = curyear - useryear;

    if((curmonth < usermonth) || ( (curmonth == usermonth) && curday < userday   )){

        age--;

    }

    return age;
}
</script>
<script>
function myFunction() {
	
	var age=getAge(document.getElementById('calculateAge').value);
	document.getElementById('age').value=age;
}
</script>
</body>
</html>
