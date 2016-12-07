<%@ page import="java.util.List" import="com.example.model.Order"
	import="com.example.model.Company" import="com.example.model.User"%>
<%@ include file="header.jsp"%>
<!--Our Company Bacground Part Starts -->
<%
	
%>
<div id="ourCompany-bg">
	<!--Our Company Part Starts -->
	<div id="ourCompany-part">
		<h2 class="ourCompany-hdr">Single Order Tracking</h2>
		<div class="search-table-outter wrapper">
			<table class="ordertable">
				<thead>
					<tr>
						<th width="120px">Order ID</th>
						<th width="250px">From</th>
						<th width="250px">To</th>
						<th width="100px">Status</th>
						<th width="200px">Order Date</th>
						<th width="250px">Expected Arrival Date</th>
						<th width="50px">Weight</th>
						<th width="30px">Size</th>
					</tr>
				</thead>
				<tbody>
					<%
						Order order = (Order) session.getAttribute("order");

						System.out.println("----------------");

						out.print("<tr><td><strong>" + order.getId() + "</strong></td>");
						out.print("<td>" + order.getFromAddress() + "</td>");
						out.print("<td>" + order.getDestination() + "</td>");
						out.print("<td>" + order.getStatus() + "</td>");
						out.print("<td>" + order.getOrderDate() + "</td>");
						if (!order.getStatus().equalsIgnoreCase("CANCELLED"))
							out.print("<td>" + order.getExpectedArrivalDate() + "</td>");
						else
							out.print("<td>CANCELLED</td>");
						out.print("<td>" + order.getWeight() + "</td>");
						out.print("<td>" + order.getSize() + "</td></tr>");
					%>

				</tbody>
			</table>

		</div>


	</div>

</div>
<br class="spacer" />
<%@ include file="footer.jsp"%>