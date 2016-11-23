<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.example.servlet.LoginServlet"
	import="com.example.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Package</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<!--Header Background Part Starts -->
	<div id="header-bg">
		<!--Header Contant Part Starts -->
		<div id="header">
			<a href="index.html"><img src="images/logo.gif" alt="Package"
				width="205" height="62" border="0" class="logo" title="Package" /></a>
			<!--Login Background Starts -->
			<!--Login Area Starts -->
			<%@ include file="loginField.jsp"%>
			<!-- 						<br class="spacer" /> -->
			<!-- 					</form> -->

			<!--Login Area Ends -->

			<!--Login Background Ends -->
			<br class="spacer" />
		</div>
		<!--Header Contant Part Ends -->
	</div>
	<!--Header Background Part Ends -->
	<!--Navigation Background Part Starts -->
	<div id="navigation-bg">
		<!--Navigation Part Starts -->
		<div id="navigation">
			<ul class="mainMenu">
				<li><a href="/deliverytrackingsystem/index.jsp" title="Home">Home</a></li>
				<li><a href="#" title="Track">Track</a></li>
				<li><a href="#" title="Our Services">Services</a></li>
				<li><a href="/deliverytrackingsystem/sessionChecking.jsp"
					title="My Account">My Account</a></li>
				<li><a href="#" title="Help Us">Help</a></li>
				<li><a href="#" title="About">About</a></li>
				<li class="noBg"><a href="#" title="Contact">Contact</a></li>
			</ul>
			<%
				if (session.getAttribute("user") == null) {
					out.print("<a href=\"/deliverytrackingsystem/register.jsp\" class=\"signup\" title=\"signup now\"></a>");
				}
			%>
			<br class="spacer" />
			<ul class="subNav">
				<li class="noBg"><a href="#" title="Our Benefits">Business
						Opportunities</a></li>
				<li><a href="#" title="What Our Future Plans">What Our
						Future Plans</a></li>
				<!--Using a graph to show how many orders that we have completed in DB -->
				<li><a href="#" title="Our Success">Our Success</a></li>
				<li><a href="#" title="News">News</a></li>
				<li><a href="#" title="FAQ">FAQ</a></li>
				<li><a href="#" title="Company Login">Company Login</a></li>
			</ul>
			<br class="spacer" />
		</div>
		<!--Navigation Part Ends -->
	</div>