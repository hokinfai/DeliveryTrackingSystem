

<%@ include file="header.jsp"%>
<%@ page import="com.example.model.Company"%>
<%
	session.invalidate();
	HttpSession nsession = request.getSession(false);
// 	if (nsession != null) {
// 		Company company = (Company) session.getAttribute("company");
// 		User user = (User) session.getAttribute("user");
// 		out.println("Session is still active");
// 		out.println(company);
// 		out.println(user);
// 	} else
// 		out.println("Session is inactive");
%>
<META http-equiv="refresh" content="5;URL=index.jsp">
<div id="ourCompany-bg">
	<!--Our Company Part Starts -->
	<div id="ourCompany-part">
		<h2 class="ourCompany-hdr">Logout Successfully!</h2>
		<!--Our Company Left Part Starts -->

		<div id="ourCompany-rightPart">
			<div style="height: 250px; width: 600px">
				Thank you for using our service, you have logged out successfully. <br>We
				hope to see you soon!! <br /> <br /> This page will be redirected
				to the home page after 5 second. <br /> If it does not work, please
				click the bottom below.<br /> <br />
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