<%@ include file="header.jsp"%>
<!--Navigation Background Part Ends -->
<!--Our Company Bacground Part Starts -->
<div id="ourCompany-bg">
	<!--Our Company Part Starts -->
	<div id="ourCompany-part">
		<h2 class="ourCompany-hdr">Welcome to our family, Register NOW!</h2>
		<!--Our Company Left Part Starts -->

		<div id="ourCompany-rightPart">
			<form action="/deliverytrackingsystem/register" method="post"
				onsubmit="return checkForm(this);">

				<table style="width: 500px">
					<tr>
						<td><font face="Comic Sans MS">Name:</font></td>
						<td><input type="text" name="name" placeholder="Name"
							style="height: 20px; font-size: 15px" size="31" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Surnname:</font></td>
						<td><input type="text" name="surnname" placeholder="SurnName"
							style="height: 20px; font-size: 15px" size="31" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Username:</font></td>
						<td><input type="text" name="username" placeholder="UserName"
							style="height: 20px; font-size: 15px" size="31" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Age:</font></td>
						<td><input type="text" name="age" placeholder="Age"
							style="height: 20px; font-size: 15px" size="31" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Date of Birth:</font></td>
						<td><input type="text" name="dob" placeholder="DD/MM/YYYY"
							style="height: 20px; font-size: 15px" size="31" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">E-mail:</font></td>
						<td><input type="email" name="email"
							placeholder="email@example.com"
							style="height: 20px; font-size: 15px" size="20" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Password:</font></td>
						<td><input type="password" name="password"
							placeholder="8 letters and number"
							style="height: 20px; font-size: 15px" size="20" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Confirm password:</font></td>
						<td><input type="password" name="confirmpassword"
							placeholder="Confirm Password"
							style="height: 20px; font-size: 15px" size="20" required></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS">Address:</font></td>
						<td><textarea name="address" cols="40" rows="5" required></textarea></td>
					</tr>
					<tr>
						<td></td>
						<td>&emsp;</td>
					</tr>
				</table>
				<input type="submit" value="Register">
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