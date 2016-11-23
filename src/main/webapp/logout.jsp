
<%@ include file="header.jsp"%>
<%
	session.invalidate();
%>
<div id="ourCompany-bg">
	<!--Our Company Part Starts -->
	<div id="ourCompany-part">
		<h2 class="ourCompany-hdr">Logout Successfully!</h2>
		<!--Our Company Left Part Starts -->

		<div id="ourCompany-rightPart">
			<div style="height: 250px; width: 600px">
				Thank you for using our service, you have logged out successfully. <br>We
				hope to see you soon!! <br> <br>
				<form action="/deliverytrackingsystem/index.jsp">
					<input type="submit" value="Home" />
				</form>
			</div>
		</div>
		<!--Our Company Right Part Ends -->
		<br class="spacer" />
	</div>
	<!--Our Company Part Ends -->
</div>
<!--Our Company Bacground Part Ends -->
<%@ include file="footer.jsp"%>