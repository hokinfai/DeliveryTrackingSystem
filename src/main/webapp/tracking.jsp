<%@ include file="header.jsp"%>
<!--Navigation Background Part Ends -->
<!--Our Company Bacground Part Starts -->
<div id="ourCompany-bg">
	<!--Our Company Part Starts -->
	<div id="ourCompany-part">
		<h2 class="ourCompany-hdr">Track Your Orders Here!</h2>
		<!--Our Company Left Part Starts -->

		<div id="ourCompany-rightPart">
			<form action="/deliverytrackingsystem/OrderTracking" method="post"
				onsubmit="return checkForm(this);">

				<table style="width: 500px; height: 200px">
					<tr>
						<td><font face="Comic Sans MS">Order ID:</font></td>
						<td><input type="text" id="check" name="id"
							placeholder="Order ID" style="height: 20px; font-size: 15px"
							size="31" required></td>

					</tr>
					<tr>
						<td><font face="Comic Sans MS">Order Date:</font></td>
						<td><input type="text" name="date" id="check"
							placeholder="e.g. 15th (Only Date, without y/m)"
							style="height: 20px; font-size: 15px" size="31" required></td>
						<td><input type="submit" value="Track Now" onclick="verify()"></td>
					</tr>

				</table>

			</form>
		</div>
		<!--Our Company Right Part Ends -->
		<br class="spacer" />
	</div>
	<!--Our Company Part Ends -->
</div>
<!--Our Company Bacground Part Ends -->
<%@ include file="footer.jsp"%>