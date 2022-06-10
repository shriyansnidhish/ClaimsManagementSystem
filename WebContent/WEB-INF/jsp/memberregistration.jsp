<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<html>
<head>
	<meta charset="utf-8">
	 <meta http-equiv="X-UA-Compatible" content="IE=edge">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Member Registration</title>

<!--  My Css File -->
<link rel="stylesheet" type="text/css" href="./css/main.css">
<!--  google fonts -->
<link href="https://fonts.googleapis.com/css?family=Bungee+Shade|Faster+One|Gloria+Hallelujah|Merienda|Oleo+Script:700|Yesteryear|Monoton|Srisakdi:400,700|Black+Ops+One&amp;subset=latin-ext" rel="stylesheet">
<style type="text/css">
	a{
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
		if (document.memberform.firstName.value == "") {
			alert("Enter your First Name");
			var field=document.memberform.firstName;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.firstName.focus();
			return false;
		}
		if (document.memberform.lastName.value == "") {
			alert("Enter your last Name");
			var field=document.memberform.lastName;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.lastName.focus();
			return false;
		}
		if (document.memberform.age.value == "") {
			alert("Enter your age");
			var field=document.memberform.age;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.age.focus();
			return false;
		}
		if (document.memberform.gender.value == "") {
			alert("Select Your Gender");
			var field=document.memberform.gender;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.gender.focus();
			return false;
		}
		if (document.memberform.dob.value == "") {
			alert("Enter your DOB");
			var field=document.memberform.dob;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.dob.focus();
			return false;
		}
		if (document.memberform.contactNo.value == "") {
			alert("Enter your contact No");
			var field=document.memberform.contactNo;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.contactNo.focus();
			return false;
		}
		if (document.memberform.emailId.value == "") {
			alert("Enter your emailId");
			var field=document.memberform.emailId;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.emailId.focus();
			return false;
		}
		if (document.memberform.password.value == "") {
			alert("Create Password");
			var field=document.memberform.password;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.password.focus();
			return false;
		}
		if (document.memberform.planCode.value == "") {
			alert("Enter plan Code");
			var field=document.memberform.planCode;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.planCode.focus();
			return false;
		}
		if (document.memberform.coverageStartDate.value == "") {
			alert("Enter coverage Start Date");
			var field=document.memberform.coverageStartDate;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.coverageStartDate.focus();
			return false;
		}
		if (document.memberform.coverageEndDate.value == "") {
			alert("Enter coverage End Date");
			var field=document.memberform.coverageEndDate;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.coverageEndDate.focus();
			return false;
		}
		if (document.memberform.addressLine1.value == "") {
			alert("Enter address Line1");
			var field=document.memberform.addressLine1;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.addressLine1.focus();
			return false;
		}
		if (document.memberform.addressLine2.value == "") {
			alert("Enter address Line2");
			var field=document.memberform.addressLine2;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.addressLine2.focus();
			return false;
		}
		if (document.memberform.city.value == "") {
			alert("Enter your city");
			var field=document.memberform.city;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.city.focus();
			return false;
		}
		if (document.memberform.state.value == "") {
			alert("Enter state");
			var field=document.memberform.state;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.state.focus();
			return false;
		}
		if (document.memberform.zipCode.value == "") {
			alert("Enter zipCode");
			var field=document.memberform.zipCode;
			field.style.borderColor="red";
			field.style.borderWidth="5px";
			document.memberform.zipCode.focus();
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

	<div id="img" style="background-color: DarkCyan; background-repeat: no-repeat; background-size: cover; ">
	

	<center>
		<div style="width: 60%;" class="transbox">
		<h2 style="color: red;background-color: #87dec5;">Member Registration</h2><br>
		
		<springform:form id="regFormM"  modelAttribute="memberModel" name="memberform" onsubmit="return checkfield()" action="registerProcessMember.htm" method="post" >
                <table>
                    
                    <tr>
                        <td>
                            <springform:label path="firstName">First Name&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="firstName"  />
                        </td>
                        <td style="color: red; font-style: italic;"><springform:errors    
       path="firstName" />  </td> 
                    </tr>
                   
                    <tr>
                        <td>
                            <springform:label path="lastName">Last Name&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="lastName"/></td>
                        <td style="color: red; font-style: italic;"><springform:errors    
       path="lastName" />  </td> 
                    </tr>
                  
                    
                    
                    
                  <tr>
                    <td>  <springform:label path="gender">Gender&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label>
                    
                     </td>
                      <td>
                       <springform:select class="box" path= "gender">
                       <springform:option value = "none" label = "Select"/>
                       <springform:option value = "male" label = "male"/>
                       <springform:option value = "female" label = "female"/>
                       <springform:option value = "others" label = "others"/>
                  </springform:select>  
                      </td>
                         <td style="color: red; font-style: italic;"><springform:errors    
       path="gender" />  </td> 
                      
                    </tr>
                    
                    
                    
                    
                    <tr>
                        <td>
                            <springform:label path="dob">DoB&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input id="calculateAge"  class="box" path="dob"  placeholder="DD/MM/YYYY" onfocusout="myFunction()"/></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="dob" />  </td> 
                    </tr>
                    
                      <tr>
                        <td>
                            <springform:label path="age">Age&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input id="age"  class="box" path="age"  /></td>
                        <td style="color: red; font-style: italic;"><springform:errors    
       path="age" />  </td> 
                    </tr>
                    
                    <tr>
                        <td>
                            <springform:label path="contactNo">ContactNo&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="contactNo"  /></td>
                               <td style="color: red; font-style: italic;"><springform:errors    
       path="contactNo" />  </td> 
                        
                    </tr>
                    <tr>
                        <td>
                            <springform:label path="altContactNo">AltContactNo&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="altContactNo"  /></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="altContactNo" />  </td> 
                    </tr>
                    
                    <tr>
                        <td>
                            <springform:label path="emailId">Email ID&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="emailId" type="email" /></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="emailId" />  </td> 
                    </tr>
                    
                    
                    <tr>
                        <td>
                            <springform:label path="password">Password&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input  type="password" class="box" path="password"  /></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="password" />  </td> 
                    </tr>
                    
                    <tr>
                        <td>
                            <springform:label path="planCode">PlanCode&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                        <!-- Start -->
                            <springform:select class="box" path="planCode"  >
                            <springform:options items="${planCodeList}" />
                             </springform:select>
                           <!-- End -->  
                            </td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="planCode" />  </td> 
                    </tr>
                    
                    <tr>
                        <td>
                            <springform:label path="coverageStartDate">Coverage StartDate&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="coverageStartDate"  placeholder="DD/MM/YYYY"/></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="coverageStartDate" />  </td> 
                    </tr>
                    
                     <tr>
                        <td>
                            <springform:label path="coverageEndDate">Coverage EndDate&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="coverageEndDate"  placeholder="DD/MM/YYYY"/></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="coverageEndDate" />  </td> 
                    </tr>
                    <tr>
                        <td>
                            <springform:label path="addressLine1">AddressLine1&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="addressLine1"  /></td>
                            <td style="color: red; font-style: italic;"><springform:errors    
       path="addressLine1" />  </td> 
                    </tr>
                      <tr>
                        <td>
                            <springform:label path="addressLine2">AddressLine2&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box"  path="addressLine2"  /></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="addressLine2" />  </td> 
                    </tr>
                    
                      <tr>
                        <td>
                            <springform:label path="city">City&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="city"  /></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="city" />  </td> 
                    </tr>
                    
                    <tr>
                        <td>
                            <springform:label path="state">State&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="state"  /></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="state" />  </td> 
                    </tr>
                    
                     <tr>
                        <td>
                            <springform:label path="zipCode">Zip Code&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="zipCode"  /></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="zipCode" />  </td> 
                    </tr>
                    <tr>
                        
                        <td>
                            <td style="padding-top:5%;" colspan="2"><input  id="styled" type="submit" value="Register" /></td>
                        
                    </tr>
                    
                   
                </table>
            </springform:form>
		
				
		
		
		</div>
		</center>
		
	</div>
	<div id="footer">
		<a href="#" style="display: inline; padding-left: 5%;">CMS Infotech</a>
  <a href="#" style="display: inline; padding-left: 5%;">Privacy & Terms</a>  
  <a href="#" style="display: inline; padding-left: 5%;">Need Help ?</a>    

    <a href="https://www.cognizant.com/" style="display: inline; float: right; padding-right: 5%;">Powered by Cognizant © 2019</a>
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
