<%@ include file="header.jsp"%>
<!--Navigation Background Part Ends -->
<!--Our Company Bacground Part Starts -->
<div id="ourCompany-bg">
	<!--Our Company Part Starts -->
	<div id="ourCompany-part">
		<h2 class="ourCompany-hdr">Update Order:</h2>
		<!--Our Company Left Part Starts -->

		<div id="ourCompany-rightPart">
			<form action="/deliverytrackingsystem/updateOrders" method="post"
				onsubmit="return checkForm(this);">


				<table style="width: 500px">
					<tr>
						<td><font face="Comic Sans MS">Order ID:</font></td>
						<td><input type="text" name="orderId" placeholder="Number Only"
							style="height: 20px; font-size: 15px" size="31"></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Ship From:</font></td>
						<td><input type="text" name="from" placeholder="From"
							style="height: 20px; font-size: 15px" size="31"></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Ship To:</font></td>
						<td><input type="text" name="to" placeholder="To"
							style="height: 20px; font-size: 15px" size="31"></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Status:</font></td>
						<td><input type="text" name="status" placeholder="status"
							style="height: 20px; font-size: 15px" size="31"></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Weight:</font></td>
						<td><input type="text" name="weight" placeholder="weight"
							style="height: 20px; font-size: 15px" size="31"></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Size:</font></td>
						<td><input type="text" name="size" placeholder="size"
							style="height: 20px; font-size: 15px" size="31"></td>
					</tr>
					<tr>
						<td></td>
						<td>&emsp;</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Update Order"></td>
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