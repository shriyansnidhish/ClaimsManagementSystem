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
a {
	color: white;
}
</style>
<script type="text/javascript">
	function checkfield() {
		if (document.adminform.adminId.value == "") {
			alert("Enter your ID");
			document.adminform.adminId.focus();
			return false;
		}
		if (document.adminform.firstName.value == "") {
			alert("Enter your First Name");
			document.adminform.firstName.focus();
			return false;
		}
		if (document.adminform.lastName.value == "") {
			alert("Enter your Last Name");
			document.adminform.lastName.focus();
			return false;
		}
		if (document.adminform.age.value == "") {
			alert("Enter your age");
			document.adminform.age.focus();
			return false;
		}
		if (document.adminform.gender.value == "none") {
			alert("Select Your Gender");

			return false;
		}
		if (document.adminform.dob.value == "") {
			alert("Enter your DOB");
			document.adminform.dob.focus();
			return false;
		}
		if (document.adminform.contact.value == "") {
			alert("Enter your Contact Detail");
			document.adminform.contact.focus();
			return false;
		}
		if (document.adminform.emailId.value == "") {
			alert("Enter your EMail ID");
			document.adminform.emailId.focus();
			return false;
		}
		if (document.adminform.password.value == "") {
			alert("Create Password");
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

	<div id="img"
		style="background-color: DarkCyan; background-repeat: no-repeat; background-size: cover;">



		<div class="form">
			<center>
				<h2 style="color: white;">Admin Registration</h2>
			</center>
			<br>

			<springform:form id="regForm" modelAttribute="adminModel"
				name="adminform" onsubmit="return checkfield()"
				action="registerProcessAdmin.htm" method="post">
				<table>
					<tr>
						<td><springform:label path="adminId">Admin ID&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label>
						</td>

						<td><springform:input class="box" path="adminId" /></td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="adminId" /></td>
					</tr>
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
						<td><springform:label path="age">Age&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="age" />&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="age" /></td>

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

						<td><springform:input class="box" path="dob" /></td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="dob" /></td>

					</tr>
					<tr>
						<td><springform:label path="contact">Contact&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="contact" /></td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="contact" /></td>

					</tr>
					<tr>
						<td><springform:label path="altContact">AltContact&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>

						<td><springform:input class="box" path="altContact" /></td>
						<td style="color: red; font-style: italic;"><springform:errors
								path="altContact" /></td>

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
						<td colspan="2"><input id="styled" type="submit"
							value="Register" /></td>

					</tr>


				</table>



			</springform:form>


















		</div>


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

</body>
</html>
