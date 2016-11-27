<%@ page import="java.util.List" import="com.example.model.Order"
	import="com.example.model.Company" import="com.example.model.User"%>
<%@ include file="header.jsp"%>
<!--Our Company Bacground Part Starts -->
<%
	
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
						List<String> username = (List<String>) session.getAttribute("username");
						List<Order> order = (List<Order>) session.getAttribute("companyOrder");
						System.out.println("----------------");
									for(int i = 0; i < order.size(); i ++){
														out.print("<tr><td><strong>" + order.get(i).getId() + "</strong></td>");
														out.print("<td>" +  username.get(i)+ "</td>");
														out.print("<td>" +  order.get(i).getFromAddress() + "</td>");
														out.print("<td>" +  order.get(i).getDestination() + "</td>");
														out.print("<td>" +  order.get(i).getStatus() + "</td>");
														out.print("<td>" +  order.get(i).getOrderDate() + "</td>");
														out.print("<td>" +  order.get(i).getWeight() + "</td>");
														out.print("<td>" +  order.get(i).getSize() + "</td></tr>");
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
				<td><form action="/deliverytrackingsystem/updateOrders.jsp">
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