<%@ include file="sessionChecking.jsp"%><%@ page import="java.util.List"
	import="com.example.model.Order"%>
<%@ include file="header.jsp"%>
<!--Our Company Bacground Part Starts -->
<%
	User loginUser = (User) session.getAttribute("user");
	List<Order> order =(List<Order>) session.getAttribute("order");
// 	System.out.println("-----------------");
// 	System.out.println(loginUser.getOrder().get(0).getId());
%>
<div id="ourCompany-bg">
	<!--Our Company Part Starts -->
	<div id="ourCompany-part">
		<h2 class="ourCompany-hdr">My Orders</h2>
		<div class="search-table-outter wrapper">
			<table class="ordertable">
				<thead>
					<tr>
						<th width="120px">Order ID</th>
						<th width="250px">From</th>
						<th width="250px">To</th>
						<th width="70px">Status</th>
						<th width="130px">Order Date</th>
						<th width="350px">Expected Arrival Date</th>
						<th width="50px">Weight</th>
						<th width="30px">Size</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Order o : order) {
								out.print("<tr><td><strong>" + o.getId() + "</strong></td>");
								out.print("<td>" + o.getFromAddress() + "</td>");
								out.print("<td>" + o.getDestination() + "</td>");
								out.print("<td>" + o.getStatus() + "</td>");
								out.print("<td>" + o.getOrderDate() + "</td>");
								out.print("<td>" + o.getTheExpectedArrivalDate() + "</td>");
								out.print("<td>" + o.getWeight() + "</td>");
								out.print("<td>" + o.getSize() + "</td></tr>");
						}
					%>


				</tbody>
			</table>
		</div>
	</div>
</div>
<br class="spacer" />
<!-- </div> -->
<!--Our Company Part Ends -->

<!--Our Company Bacground Part Ends -->
<!--Future Plans Part Starts -->
<!--Footer Part Starts -->
<%@ include file="footer.jsp"%>