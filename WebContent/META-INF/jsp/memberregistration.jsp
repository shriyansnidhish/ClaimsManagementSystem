<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="utf-8">
	 <meta http-equiv="X-UA-Compatible" content="IE=edge">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Member Registration</title>
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
	

	
		<div >
		<center><h2 style="color:white;">Member Registration</h2></center><br>
		
		<springform:form id="regFormM"  modelAttribute="memberModel"  action="registerProcessMember.htm" method="post" >
                <table>
                    <tr>
                        <td>
                            <springform:label path="memberId">Member ID&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label> </td>
                        
                        <td>
                               <springform:input class="box" path="memberId"  /></td>
                               
                                <td style="color: red; font-style: italic;"><springform:errors    
       path="memberId" />    
     </td>  
                               
                               
                    </tr>
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
                        <td>
                            <springform:label path="age">Age&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="age"  /></td>
                        <td style="color: red; font-style: italic;"><springform:errors    
       path="age" />  </td> 
                    </tr>
                    
                    
                    
                  <tr>
                    <td>  <springform:label path="gender">Gender&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label>
                    
                     </td>
                      <td>
                       <springform:select class="box" path= "gender">
                       <springform:option value = "NONE" label = "Select"/>
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
                            <springform:input class="box" path="dob"  /></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="dob" />  </td> 
                    </tr>
                    <tr>
                        <td>
                            <springform:label path="contact">Contact&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="contact"  /></td>
                               <td style="color: red; font-style: italic;"><springform:errors    
       path="contact" />  </td> 
                        
                    </tr>
                    <tr>
                        <td>
                            <springform:label path="altContact">AltContact&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="altContact"  /></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="altContact" />  </td> 
                    </tr>
                    
                    <tr>
                        <td>
                            <springform:label path="emailId">Email ID&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="emailId"  /></td>
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
                            <springform:input class="box" path="planCode"  /></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="planCode" />  </td> 
                    </tr>
                    
                    <tr>
                        <td>
                            <springform:label path="coverageStartDate">Coverage StartDate&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="coverageStartDate"  /></td>
                           <td style="color: red; font-style: italic;"><springform:errors    
       path="coverageStartDate" />  </td> 
                    </tr>
                    
                     <tr>
                        <td>
                            <springform:label path="coverageEndDate">Coverage EndDate&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</springform:label></td>
                        
                        <td>
                            <springform:input class="box" path="coverageEndDate"  /></td>
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
                            <td colspan="2"><input id="styled" type="submit" value="Register" /></td>
                        
                    </tr>
                    
                   
                </table>
            </springform:form>
		
				
		
		
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
