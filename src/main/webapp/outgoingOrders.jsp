<%@ page import="java.util.List" import="com.example.model.Order"
	import="com.example.model.Company"%>
<%@ include file="header.jsp"%>
<!--Our Company Bacground Part Starts -->
<%
	Company company = (Company) session.getAttribute("company");
	System.out.println("----------------");
%>
<div id="ourCompany-bg">
	<!--Our Company Part Starts -->
	<div id="ourCompany-part">
		<h2 class="ourCompany-hdr">Sending Orders</h2>
		<div class="search-table-outter wrapper">
			<table class="ordertable">
				<thead>
					<tr>
						<th width="120px">Order ID</th>
						<th width="90px">User</th>
						<th width="250px">From</th>
						<th width="250px">To</th>
						<th width="100px">Status</th>
						<th width="250px">Order Date</th>
						<th width="50px">Weight</th>
						<th width="30px">Size</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<Order> order = company.getOrderList();
																															for (Order o : order) {
																														out.print("<tr><td><strong>" + o.getId() + "</strong></td>");
																														out.print("<td>" + o.getUser().getUsername()+ "</td>");
																														out.print("<td>" + o.getFromAddress() + "</td>");
																														out.print("<td>" + o.getDestination() + "</td>");
																														out.print("<td>" + o.getStatus() + "</td>");
																														out.print("<td>" + o.getOrderDate() + "</td>");
																														out.print("<td>" + o.getWeight() + "</td>");
																														out.print("<td>" + o.getSize() + "</td></tr>");
																															}
					%>

				</tbody>
			</table>

		</div>
		<table>
			<tr>
				<td>
			<tr>
				<td><form action="/deliverytrackingsystem/addOrder.jsp">
						<input type="submit" value="Add">
					</form></td>
				<td><form
						action="/deliverytrackingsystem/changeOrderStatus.jsp">
						<input type="submit" value="Update Orders">
					</form></td>
			</tr>
		</table>

	</div>

</div>
<br class="spacer" />
<!-- </div> -->
<!--Our Company Part Ends -->

<!--Our Company Bacground Part Ends -->
<!--Future Plans Part Starts -->
<!--Footer Part Starts -->
<%@ include file="footer.jsp"%>