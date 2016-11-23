<%@ include file="header.jsp"%>

<!--Our Company Bacground Part Starts -->

<div id="ourCompany-bg">
	<!--Our Company Part Starts -->
	<div id="ourCompany-part">
		<h2 class="ourCompany-hdr">My Account</h2>
		<!--Our Company Left Part Starts -->
		<div id="ourCompany-leftPart">
			<ul>

				<h2 class="moreIdeas-Hdr">
					<a href="#content">Your Details</a>
				</h2>
				<ul class="emptySpace"></ul>
				<h2 class="moreInfo-Hdr">
					<a href="#content">Your Orders</a>
				</h2>
				<ul class="emptySpace"></ul>
				<h2 class="faq-Hdr">
					<a href="#content">More Information</a>
				</h2>
				<ul class="emptySpace"></ul>
				<h2 class="searchUrl-Hdr">
					<a href="logout.jsp">Logout</a>
				</h2>
				<ul class="emptySpace">


				</ul>
			</ul>
		</div>
		<!--Our Company Left Part Ends -->
		<!--Our Company Right Part Starts -->
		<div id="ourCompany-rightPart">
			<table width="350" rules="rows" class="userDetail" height="250px">
				<tr>
					<td style="color: #A0522D" width="35%">Name:</td>
					<td style="font-family: courier; color: blue;"><%=user.getName()%></td>
				</tr>
				<tr>
					<td style="color: #A0522D">Surnname:</td>
					<td style="font-family: courier; color: blue;"><%=user.getSurnname()%></td>
				</tr>
				<tr>
					<td style="color: #A0522D">Username:</td>
					<td style="font-family: courier; color: blue;"><%=user.getUsername()%></td>
				</tr>
				<tr>
					<td style="color: #A0522D">Age:</td>
					<td style="font-family: courier; color: blue;"><%=user.getAge()%></td>
				</tr>
				<tr>
					<td style="color: #A0522D">Date of Birth:</td>
					<td style="font-family: courier; color: blue;"><%=user.getDob()%></td>
				</tr>
				<tr>
					<td style="color: #A0522D">E-mail:</td>
					<td style="font-family: courier; color: blue;"><%=user.getEmail()%></td>
				</tr>
				<tr>
					<td style="color: #A0522D">Address:</td>
					<td style="font-family: courier; color: blue;"><%=user.getAddress()%></td>
				</tr>

			</table>
		</div>

		<!--Our Company Right Part Ends -->
		<br class="spacer" />
	</div>
	<!--Our Company Part Ends -->
</div>
<!--Our Company Bacground Part Ends -->
<!--Future Plans Part Starts -->
<!--Footer Part Starts -->
<%@ include file="footer.jsp"%>