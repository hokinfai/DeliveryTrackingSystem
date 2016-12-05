<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.example.servlet.LoginServlet"
	import="com.example.dao.DeliveryStatus" import="com.example.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Package</title>
<link href="style/style.css" rel="stylesheet" type="text/css" />
<link href="style/tablestyle.css" rel="stylesheet" type="text/css" />
<script>
	function verify() {
		if (!document.getElementById("check").value.trim().length)
			alert("Please enter the required elements!");
	}
</script>
</head>

<body>

	<!--Header Background Part Starts -->
	<div id="header-bg">
		<!--Header Contant Part Starts -->
		<div id="header">
			<a href="index.jsp"><img src="images/logo.gif" alt="Package"
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
				<li><a href="/deliverytrackingsystem/tracking.jsp"
					title="Track">Track</a></li>
				<li><a href="#" title="Our Services">Services</a></li>

				<li><a href="#" title="Help Us">Help</a></li>
				<li><a href="#" title="About">About</a></li>

				<%
					if (session.getAttribute("user") != null
							&& session.getAttribute("company") == null) {
						out.print("<li><a href=\"/deliverytrackingsystem/contact.jsp\" title=\"Contact\">Contact</a></li>");
						out.print("<li class=\"noBg\"><a href=\"/deliverytrackingsystem/myaccount.jsp\" title=\"My Account\">My Account</a></li>");
					} else
						out.print("<li class=\"noBg\"><a href=\"/deliverytrackingsystem/contact.jsp\" title=\"Contact\">Contact</a></li>");
				%>

			</ul>
			<%
				if (session.getAttribute("user") == null
						&& session.getAttribute("company") == null) {
					out.print("<a href=\"/deliverytrackingsystem/register.jsp\" class=\"signup\" title=\"signup now\"></a>");
				} else {
					out.print("<form action=\"/deliverytrackingsystem/logout.jsp\">");
					out.print("<input type=\"image\" src=\"images/logout.png\" alt=\"Logout\" title=\"Logout\"  style=\"float:right;width:35px;height:30px;padding-top: 2px\" /></form>");
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
				<li style="border: none"><a href="#" title="FAQ">FAQ</a></li>
				<%
					if (session.getAttribute("user") == null
							&& session.getAttribute("company") == null) {
						out.print("<li style=\"padding-left: 253px\"><a href=\"companylogin.jsp\" title=\"Company Login\">Company Login</a></li>");
					} else if (session.getAttribute("user") == null
							&& session.getAttribute("company") != null) {
						out.print("<li style=\"padding-left: 248px\"><a href=\"outgoingOrders.jsp\" title=\"Company Orders\">Company Orders</a></li>");
					}
				%>

			</ul>
			<br class="spacer" />
		</div>
		<!--Navigation Part Ends -->
	</div>