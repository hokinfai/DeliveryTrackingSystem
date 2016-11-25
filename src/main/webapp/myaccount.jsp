<%@ include file="sessionChecking.jsp"%>
<%@ include file="header.jsp"%>

<div id="ourCompany-bg">
	<!--Our Company Part Starts -->
	<div id="ourCompany-part">
		<h2 class="ourCompany-hdr">My Account</h2>
		<!--Our Company Left Part Starts -->
		<div id="ourCompany-leftPart">
			<ul></ul>
			<h2 class="moreIdeas-Hdr">
				<a href="/deliverytrackingsystem/myaccount.jsp">Your Details</a>
			</h2>
			<ul class="emptySpace"></ul>
			<h2 class="moreInfo-Hdr">
				<a href="/deliverytrackingsystem/myorder.jsp">Your Orders</a>
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
		</div>
		<!--Our Company Left Part Ends -->
		<!--Our Company Right Part Starts -->
		<div id="ourCompany-rightPart">
			<%
				User loginUser = (User) session.getAttribute("user");
			%>

			<table width="350" rules="rows" class="userDetail" height="250px">
				<tr>
					<td style="color: #A0522D" width="35%">Name:</td>
					<td style="font-family: courier; color: blue;"><%=loginUser.getName()%></td>
				</tr>
				<tr>
					<td style="color: #A0522D">Surnname:</td>
					<td style="font-family: courier; color: blue;"><%=loginUser.getSurnname()%></td>
				</tr>
				<tr>
					<td style="color: #A0522D">Username:</td>
					<td style="font-family: courier; color: blue;"><%=loginUser.getUsername()%></td>
				</tr>
				<tr>
					<td style="color: #A0522D">Age:</td>
					<td style="font-family: courier; color: blue;"><%=loginUser.getAge()%></td>
				</tr>
				<tr>
					<td style="color: #A0522D">Date of Birth:</td>
					<td style="font-family: courier; color: blue;"><%=loginUser.getDob()%></td>
				</tr>
				<tr>
					<td style="color: #A0522D">E-mail:</td>
					<td style="font-family: courier; color: blue;"><%=loginUser.getEmail()%></td>
				</tr>
				<tr>
					<td style="color: #A0522D">Address:</td>
					<td style="font-family: courier; color: blue;"><%=loginUser.getAddress()%></td>
				</tr>
				<tr>
					<td></td>

					<td align="right"><form action="detailEdit.jsp">
							<input type="submit" value="Edit" />
						</form></td>

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