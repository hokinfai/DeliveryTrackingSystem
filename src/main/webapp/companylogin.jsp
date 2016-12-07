<%@ include file="header.jsp"%>
<!--Navigation Background Part Ends -->
<!--Our Company Bacground Part Starts -->
<div id="ourCompany-bg">
	<!--Our Company Part Starts -->
	<div id="ourCompany-part">
		<h2 class="ourCompany-hdr">Company Login!</h2>
		<!--Our Company Left Part Starts -->

		<div id="ourCompany-rightPart">
			<form action="/deliverytrackingsystem/companyLogin" method="post">

				<table width="400">
					<tr>
						<td><font face="Comic Sans MS">Registration Number:</font></td>
						<td><input type="text" name="regiNumber"
							placeholder="Registration Number" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Manager Name:</font></td>
						<td><input type="text" name="managername"
							placeholder="Manager Name" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Company Name:</font></td>
						<td><input type="text" name="companyname"
							placeholder="Company Name" required></td>
					</tr>

					<tr>
						<td></td>
						<td>&emsp;</td>
					</tr>
				</table>
				<input type="submit" value="Login Now!">
			</form>
		</div>
		<!--Our Company Right Part Ends -->
		<br class="spacer" />
	</div>
	<!--Our Company Part Ends -->
</div>
<!--Our Company Bacground Part Ends -->
</div>
<%@ include file="footer.jsp"%>